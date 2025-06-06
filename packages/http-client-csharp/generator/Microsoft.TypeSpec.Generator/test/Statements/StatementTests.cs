// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Microsoft.TypeSpec.Generator.Expressions;
using Microsoft.TypeSpec.Generator.Primitives;
using Microsoft.TypeSpec.Generator.Providers;
using Microsoft.TypeSpec.Generator.Statements;
using Microsoft.TypeSpec.Generator.Tests.Common;
using NUnit.Framework;
using static Microsoft.TypeSpec.Generator.Snippets.Snippet;

namespace Microsoft.TypeSpec.Generator.Tests.Statements
{
    public class StatementTests
    {
        public StatementTests()
        {
            MockHelpers.LoadMockGenerator();
        }

        [Test]
        public void CreateForStatement()
        {
            var assignment = new AssignmentExpression(new DeclarationExpression(new CSharpType(typeof(BinaryData)), "responseParamName"), ValueExpression.Empty);
            var condition = True;
            var increment = ValueExpression.Empty;
            var forStatement = new ForStatement(assignment, condition, increment);

            Assert.NotNull(forStatement);
            Assert.IsEmpty(forStatement.Body);
        }

        [Test]
        public void ForStatementWithAddMethod()
        {
            var assignment = new AssignmentExpression(new DeclarationExpression(new CSharpType(typeof(BinaryData)), "responseParamName"), ValueExpression.Empty);
            var condition = True;
            var increment = ValueExpression.Empty;
            var forStatement = new ForStatement(assignment, condition, increment);
            var statementToAdd = MethodBodyStatement.Empty;

            forStatement.Add(statementToAdd);

            Assert.NotNull(forStatement.Body);
            Assert.IsNotEmpty(forStatement.Body);
            Assert.AreEqual(statementToAdd, forStatement.Body[0]);
        }

        [Test]
        public void CreateForeachStatement()
        {
            var itemType = new CSharpType(typeof(int));
            var itemName = "item";
            var enumerable = ValueExpression.Empty;

            var foreachStatement = new ForEachStatement(itemType, itemName, enumerable, isAsync: false, out var itemReference);

            Assert.NotNull(foreachStatement);
            Assert.AreEqual(itemType, foreachStatement.ItemType);
            Assert.AreEqual(itemName, foreachStatement.Item.RequestedName);
            Assert.AreEqual(enumerable, foreachStatement.Enumerable);
            Assert.IsFalse(foreachStatement.IsAsync);
            Assert.NotNull(itemReference);
            Assert.AreEqual(itemType, itemReference.Type);
            Assert.AreEqual(itemName, itemReference.Declaration.RequestedName);
        }

        [Test]
        public void ForeachStatementWithAddMethod()
        {
            var foreachStatement = new ForEachStatement(new CSharpType(typeof(int)), "item", ValueExpression.Empty, isAsync: false, out var itemReference);
            var statementToAdd = MethodBodyStatement.Empty;

            foreachStatement.Add(statementToAdd);

            Assert.NotNull(foreachStatement.Body);
            Assert.IsNotEmpty(foreachStatement.Body);
            Assert.IsTrue(foreachStatement.Body.Any(s => s == statementToAdd));
        }

        [Test]
        public void IfStatementWithBoolExpression()
        {
            var condition = True;
            var ifStatement = new IfStatement(condition);

            using var writer = new CodeWriter();
            ifStatement.Write(writer);

            Assert.AreEqual(Helpers.GetExpectedFromFile(), writer.ToString(false));
        }

        [Test]
        public void IfStatementWithAddMethod()
        {
            var ifStatement = new IfStatement(True);
            var statementToAdd = MethodBodyStatement.Empty;

            ifStatement.Add(statementToAdd);

            Assert.NotNull(ifStatement.Body);
            Assert.IsInstanceOf<MethodBodyStatement>(ifStatement.Body);
            Assert.IsTrue(((MethodBodyStatements)ifStatement.Body).Statements.Any(s => s == statementToAdd));
        }

        [Test]
        public void IfStatementWithDefaultOptions()
        {
            var condition = True;
            var ifStatement = new IfStatement(condition);

            Assert.IsFalse(ifStatement.Inline);
            Assert.IsTrue(ifStatement.AddBraces);
        }

        [Test]
        public void IfStatementInlineOptionTrue()
        {
            var condition = True;
            var ifStatement = new IfStatement(condition, inline: true);

            Assert.IsTrue(ifStatement.Inline);
        }

        [Test]
        public void IfStatementAddBracesOptionFalse()
        {
            var condition = True;
            var ifStatement = new IfStatement(condition, addBraces: false);

            Assert.IsFalse(ifStatement.AddBraces);
        }

        [Test]
        public void IfElseStatementWithIfAndElse()
        {
            var condition = True;
            var elseStatement = MethodBodyStatement.Empty;

            var ifElseStatement = new IfElseStatement(new IfStatement(condition), elseStatement);

            using var writer = new CodeWriter();
            ifElseStatement.Write(writer);

            Assert.AreEqual(Helpers.GetExpectedFromFile(), writer.ToString(false));
        }

        [Test]
        public void IfElseStatementWithConditionAndStatements()
        {
            var condition = True;
            var ifStatement = MethodBodyStatement.Empty;
            var elseStatement = MethodBodyStatement.Empty;

            var ifElseStatement = new IfElseStatement(condition, ifStatement, elseStatement);

            using var writer = new CodeWriter();
            ifElseStatement.Write(writer);

            Assert.AreEqual(Helpers.GetExpectedFromFile(), writer.ToString(false));
        }

        [Test]
        public void SwitchStatementWithSingleCase()
        {
            var matchExpression = ValueExpression.Empty;
            var switchStatement = new SwitchStatement(matchExpression);

            var caseStatement = MethodBodyStatement.Empty;
            var switchCase = new SwitchCaseStatement(ValueExpression.Empty, caseStatement);

            switchStatement.Add(switchCase);

            Assert.AreEqual(1, switchStatement.Cases.Count);
            Assert.AreEqual(switchCase, switchStatement.Cases[0]);
        }

        [Test]
        public void SwitchStatementWithMultipleCases()
        {
            var matchExpression = ValueExpression.Empty;
            var switchStatement = new SwitchStatement(matchExpression);

            var caseStatements = new List<SwitchCaseStatement>
            {
                new SwitchCaseStatement(ValueExpression.Empty, MethodBodyStatement.Empty),
                new SwitchCaseStatement(ValueExpression.Empty, MethodBodyStatement.Empty)
            };

            foreach (var switchCase in caseStatements)
            {
                switchStatement.Add(switchCase);
            }

            CollectionAssert.AreEqual(caseStatements, switchStatement.Cases);
        }

        [Test]
        public void SwitchStatementEnumeratingCases()
        {
            var matchExpression = ValueExpression.Empty;
            var switchStatement = new SwitchStatement(matchExpression);

            var caseStatements = new List<SwitchCaseStatement>
            {
                new SwitchCaseStatement(ValueExpression.Empty, MethodBodyStatement.Empty),
                new SwitchCaseStatement(ValueExpression.Empty, MethodBodyStatement.Empty)
            };

            foreach (var switchCase in caseStatements)
            {
                switchStatement.Add(switchCase);
            }

            var enumeratedCases = new List<SwitchCaseStatement>();
            foreach (var caseItem in switchStatement.Cases)
            {
                enumeratedCases.Add(caseItem);
            }

            CollectionAssert.AreEqual(caseStatements, enumeratedCases);
        }

        [Test]
        public void TestSwitchStatementWithMultipleCasesWrite()
        {
            var variableFoo = new VariableExpression(typeof(bool), "foo");
            var fooDeclaration = Declare(variableFoo, Bool(true));
            var switchStatement = new SwitchStatement(variableFoo);

            var caseStatements = new List<SwitchCaseStatement>
            {
                new SwitchCaseStatement(Bool(true), Return(variableFoo)),
                SwitchCaseStatement.Default(Return(False))
            };

            foreach (var switchCase in caseStatements)
            {
                switchStatement.Add(switchCase);
            }

            // Create a method declaration statement
            var method = new MethodProvider(
                new MethodSignature(
                    Name: "Foo",
                    Modifiers: MethodSignatureModifiers.Public,
                    ReturnType: new CSharpType(typeof(bool)),
                    Parameters: [],
                    Description: null, ReturnDescription: null),
                new MethodBodyStatement[] { fooDeclaration, switchStatement },
                TestTypeProvider.Empty);

            // Verify the expected behavior
            using var writer = new CodeWriter();
            writer.WriteMethod(method);

            var expectedResult = Helpers.GetExpectedFromFile();
            var test = writer.ToString(false);
            Assert.AreEqual(expectedResult, test);
        }

        [Test]
        public void TestSwitchStatementWithUsingStatementWrite()
        {
            var variableFoo = new VariableExpression(typeof(bool), "foo");
            var fooDeclaration = Declare(variableFoo, Bool(true));
            var switchStatement = new SwitchStatement(variableFoo);
            var usingStatement = new UsingScopeStatement(null, new CodeWriterDeclaration("x"), New.Instance(typeof(MemoryStream)))
            {
                new SingleLineCommentStatement("some comment explaining the return"),
                Return(variableFoo)
            };

            var caseStatements = new List<SwitchCaseStatement>
            {
                new SwitchCaseStatement(Bool(true), usingStatement),
                SwitchCaseStatement.Default(Return(False))
            };

            foreach (var switchCase in caseStatements)
            {
                switchStatement.Add(switchCase);
            }

            // Create a method declaration statement
            var method = new MethodProvider(
                new MethodSignature(
                    Name: "Foo",
                    Modifiers: MethodSignatureModifiers.Public,
                    ReturnType: new CSharpType(typeof(bool)),
                    Parameters: [],
                    Description: null, ReturnDescription: null),
                new MethodBodyStatement[] { fooDeclaration, switchStatement },
                TestTypeProvider.Empty);

            // Verify the expected behavior
            using var writer = new CodeWriter();
            writer.WriteMethod(method);

            var expectedResult = Helpers.GetExpectedFromFile();
            var test = writer.ToString(false);
            Assert.AreEqual(expectedResult, test);
        }

        [Test]
        public void TryStatementWithEmptyBody()
        {
            var tryStatement = new TryExpression();
            Assert.IsEmpty(tryStatement.Body);
        }

        [Test]
        public void TryStatementWithOneLineBody()
        {
            var tryStatement = new TryExpression(Return(True));
            Assert.AreEqual(1, tryStatement.Body.Count());
        }

        [Test]
        public void TryStatementWithMultipleLineBody()
        {
            var tryStatement = new TryExpression
            (
                Declare(new VariableExpression(typeof(int), "foo"), Literal(5)),
                Return(True)
            );
            Assert.AreEqual(2, tryStatement.Body.Count());
        }

        [Test]
        public void CatchStatementWithEmptyBody()
        {
            var catchStatement = new CatchExpression(null);
            Assert.IsEmpty(catchStatement.Body);
        }

        [Test]
        public void CatchStatementWithOneLineBody()
        {
            var catchStatement = new CatchExpression(null, Return(True));
            Assert.AreEqual(1, catchStatement.Body.Count());
        }

        [Test]
        public void CatchStatementWithMultipleLineBody()
        {
            var catchStatement = new CatchExpression(
                null,
                Declare(new VariableExpression(typeof(int), "foo"), Literal(5)),
                Return(True));
            Assert.AreEqual(2, catchStatement.Body.Count());
        }

        [Test]
        public void FinallyStatementWithEmptyBody()
        {
            var finallyStatement = new FinallyExpression();
            Assert.IsEmpty(finallyStatement.Body);
        }

        [Test]
        public void FinallyStatementWithOneLineBody()
        {
            var finallyStatement = new FinallyExpression(Return(True));
            Assert.AreEqual(1, finallyStatement.Body.Count());
        }

        [Test]
        public void FinallyStatementWithMultipleLineBody()
        {
            var finallyStatement = new FinallyExpression
            (
                Declare(new VariableExpression(typeof(int), "foo"), Literal(5)),
                Return(True)
            );
            Assert.AreEqual(2, finallyStatement.Body.Count());
        }


        [Test]
        public void TryCatchFinallyStatementWithTryOnly()
        {
            var tryStatement = new TryExpression();
            var tryCatchFinally = new TryCatchFinallyStatement(tryStatement);

            Assert.AreEqual(tryStatement, tryCatchFinally.Try);
            Assert.AreEqual(0, tryCatchFinally.Catches.Count);
            Assert.IsNull(tryCatchFinally.Finally);
        }

        [Test]
        public void TryCatchFinallyStatementWithTryAndCatch()
        {
            var tryStatement = new TryExpression();
            var catchStatement = new CatchExpression(null);
            var tryCatchFinally = new TryCatchFinallyStatement(tryStatement, catchStatement, null);

            Assert.AreEqual(tryStatement, tryCatchFinally.Try);
            Assert.AreEqual(1, tryCatchFinally.Catches.Count);
            Assert.AreEqual(catchStatement, tryCatchFinally.Catches[0]);
            Assert.IsNull(tryCatchFinally.Finally);
        }

        [Test]
        public void TryCatchFinallyStatementWithTryCatchAndFinally()
        {
            var tryStatement = new TryExpression();
            var catchStatement = new CatchExpression(null);
            var finallyStatement = new FinallyExpression();
            var tryCatchFinally = new TryCatchFinallyStatement(tryStatement, catchStatement, finallyStatement);

            Assert.AreEqual(tryStatement, tryCatchFinally.Try);
            Assert.AreEqual(1, tryCatchFinally.Catches.Count);
            Assert.AreEqual(catchStatement, tryCatchFinally.Catches[0]);
            Assert.AreEqual(finallyStatement, tryCatchFinally.Finally);
        }

        [Test]
        public void TryCatchFinallyStatementWithMultipleCatches()
        {
            var tryStatement = new TryExpression();
            var var1 = new DeclarationExpression(typeof(UnauthorizedAccessException), "ex1");
            var var2 = new DeclarationExpression(typeof(Exception), "ex2");
            var catchStatements = new[]
            {
                new CatchExpression(var1),
                new CatchExpression(var2)
            };
            var finallyStatement = new FinallyExpression();
            var tryCatchFinally = new TryCatchFinallyStatement(tryStatement, catchStatements, finallyStatement);

            Assert.AreEqual(tryStatement, tryCatchFinally.Try);
            CollectionAssert.AreEqual(catchStatements, tryCatchFinally.Catches);
            Assert.AreEqual(finallyStatement, tryCatchFinally.Finally);

            // Create a method declaration statement
            var method = new MethodProvider(
                new MethodSignature(
                    Name: "Foo",
                    Modifiers: MethodSignatureModifiers.Public,
                    ReturnType: new CSharpType(typeof(bool)),
                    Parameters: [],
                    Description: null, ReturnDescription: null),
                new MethodBodyStatement[] { tryCatchFinally },
                TestTypeProvider.Empty);

            // Verify the expected behavior
            using var writer = new CodeWriter();
            writer.WriteMethod(method);
            var expectedResult = Helpers.GetExpectedFromFile();
            var test = writer.ToString(false);
            Assert.AreEqual(expectedResult, test);
        }

        [Test]
        public void TryCatchFinallyUpdate()
        {
            var tryCatchFinally = new TryCatchFinallyStatement(new TryExpression(), new CatchExpression(null), new FinallyExpression());

            var tryStatement = new TryExpression();
            var catchStatement = new CatchExpression(null);
            var finallyStatement = new FinallyExpression();

            tryCatchFinally.Update(
                @try: tryStatement,
                catches: [catchStatement],
                @finally: finallyStatement);

            Assert.AreEqual(tryStatement, tryCatchFinally.Try);
            Assert.AreEqual(1, tryCatchFinally.Catches.Count);
            Assert.AreEqual(catchStatement, tryCatchFinally.Catches[0]);
            Assert.AreEqual(finallyStatement, tryCatchFinally.Finally);
        }

        [Test]
        public void TestIfElsePreprocessorStatement()
        {
            // Set up test conditions and variables
            var condition = "MOCKCONDITION";
            var variableX = new VariableExpression(typeof(int), "x");
            var variableFoo = new VariableExpression(typeof(int), "foo");
            var variableBar = new VariableExpression(typeof(int), "bar");
            var xDeclaration = Declare(variableX, Int(1));
            var ifStatementBody = Declare(variableFoo, Int(2));
            var elseStatementBody = Declare(variableBar, Int(2));
            var ifElsePreprocessor = new IfElsePreprocessorStatement(condition, ifStatementBody, elseStatementBody);

            // Create a method declaration statement
            var method = new MethodProvider(
                new MethodSignature(
                    Name: "Foo",
                    Modifiers: MethodSignatureModifiers.Public,
                    ReturnType: null,
                    Parameters: [],
                    Description: null, ReturnDescription: null),
                new MethodBodyStatement[] { xDeclaration, ifElsePreprocessor },
                TestTypeProvider.Empty);

            // Verify the expected behavior
            using var writer = new CodeWriter();
            writer.WriteMethod(method);

            var expectedResult = Helpers.GetExpectedFromFile();
            var test = writer.ToString(false);
            Assert.AreEqual(expectedResult, test);
        }

        [Test]
        public void TestWhileStatement()
        {
            var condition = True;
            var whileStatement = new WhileStatement(condition) { Return(True) };

            Assert.NotNull(Helpers.GetExpectedFromFile(), whileStatement.ToDisplayString());
        }

        [Test]
        public void TestDoWhileStatement()
        {
            var condition = True;
            var whileStatement = new DoWhileStatement(condition) { Return(True) };

            Assert.NotNull(Helpers.GetExpectedFromFile(), whileStatement.ToDisplayString());
        }

        [Test]
        public void TestYieldReturnStatement()
        {
            var yieldReturnStatement = YieldReturn(Literal(5));
            Assert.AreEqual("yield return 5;\n", yieldReturnStatement.ToDisplayString());
        }

        [Test]
        public void TestYieldBreakStatement()
        {
            var yieldBreakStatement = YieldBreak();
            Assert.AreEqual("yield break;\n", yieldBreakStatement.ToDisplayString());
        }

        [Test]
        public void TestFlatten()
        {
            var ifTrueStatement = new IfStatement(True) { Return(True) };
            var ifFalseStatement = new IfStatement(False) { Return(False) };
            var ifElseStatement = new IfElseStatement(True, new SingleLineCommentStatement("$hello"), new SingleLineCommentStatement("$world"));
            MethodBodyStatement methodBodyStatements = new List<MethodBodyStatement>
            {
                ifTrueStatement,
                ifElseStatement,
                ifFalseStatement
            };

            var flattened = methodBodyStatements.ToList();
            Assert.AreEqual(3, flattened.Count);
            Assert.AreEqual(ifTrueStatement, flattened[0]);
            Assert.AreEqual(ifElseStatement, flattened[1]);
            Assert.AreEqual(ifFalseStatement, flattened[2]);

            // Test flattening a single statement
            var singleStatementFlattened = ifTrueStatement.ToList();
            Assert.AreEqual(1, singleStatementFlattened.Count);

            // flatten the body
            var body = ifTrueStatement.Body.ToList();
            Assert.AreEqual(1, body.Count);
            Assert.AreEqual(ifTrueStatement.Body.ToDisplayString(), body[0].ToDisplayString());
        }

        [Test]
        public void TestFlatten_CorrectNestedOrder()
        {
            var statement1 = new IfStatement(True) { Return(True) };
            var statement2 = new IfStatement(False) { Return(False) };
            var nestedStatement1 = new IfStatement(False) { Return(Literal("Foo")) };
            var nestedStatement2 = new IfStatement(True) { Return(Literal("Bar")) };
            var methodBodyStatements = new MethodBodyStatements(
            [
                statement1,
                new MethodBodyStatements(
                [
                    nestedStatement1,
                    nestedStatement2
                ]),
                statement2
            ]);

            var result = methodBodyStatements.ToList();
            var expectedOrder = new List<MethodBodyStatement>
            {
                statement1,
                nestedStatement1,
                nestedStatement2,
                statement2
            };
            Assert.AreEqual(expectedOrder, result);
        }

        [Test]
        public void SingleLineCommentStatement()
        {
            var comment = new SingleLineCommentStatement("This is a comment");
            Assert.AreEqual("// This is a comment\n", comment.ToDisplayString());
        }
    }
}
