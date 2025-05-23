// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package parameters.spread.implementation;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in Alias.
 */
public final class AliasImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final AliasService service;

    /**
     * The service client containing this operation class.
     */
    private final SpreadClientImpl client;

    /**
     * Initializes an instance of AliasImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    AliasImpl(SpreadClientImpl client) {
        this.service = RestProxy.create(AliasService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for SpreadClientAlias to be used by the proxy service to perform REST
     * calls.
     */
    @Host("{endpoint}")
    @ServiceInterface(name = "SpreadClientAlias")
    public interface AliasService {
        @Put("/parameters/spread/alias/request-body")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> spreadAsRequestBody(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadAsRequestBodyRequest, RequestOptions requestOptions,
            Context context);

        @Put("/parameters/spread/alias/request-body")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> spreadAsRequestBodySync(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadAsRequestBodyRequest, RequestOptions requestOptions,
            Context context);

        @Post("/parameters/spread/alias/inner-model-parameter/{id}")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> spreadParameterWithInnerModel(@HostParam("endpoint") String endpoint,
            @PathParam("id") String id, @HeaderParam("x-ms-test-header") String xMsTestHeader,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadParameterWithInnerModelRequest,
            RequestOptions requestOptions, Context context);

        @Post("/parameters/spread/alias/inner-model-parameter/{id}")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> spreadParameterWithInnerModelSync(@HostParam("endpoint") String endpoint,
            @PathParam("id") String id, @HeaderParam("x-ms-test-header") String xMsTestHeader,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadParameterWithInnerModelRequest,
            RequestOptions requestOptions, Context context);

        @Put("/parameters/spread/alias/request-parameter/{id}")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> spreadAsRequestParameter(@HostParam("endpoint") String endpoint,
            @PathParam("id") String id, @HeaderParam("x-ms-test-header") String xMsTestHeader,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadAsRequestParameterRequest, RequestOptions requestOptions,
            Context context);

        @Put("/parameters/spread/alias/request-parameter/{id}")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> spreadAsRequestParameterSync(@HostParam("endpoint") String endpoint, @PathParam("id") String id,
            @HeaderParam("x-ms-test-header") String xMsTestHeader, @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadAsRequestParameterRequest, RequestOptions requestOptions,
            Context context);

        @Put("/parameters/spread/alias/multiple-parameters/{id}")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> spreadWithMultipleParameters(@HostParam("endpoint") String endpoint,
            @PathParam("id") String id, @HeaderParam("x-ms-test-header") String xMsTestHeader,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadWithMultipleParametersRequest,
            RequestOptions requestOptions, Context context);

        @Put("/parameters/spread/alias/multiple-parameters/{id}")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> spreadWithMultipleParametersSync(@HostParam("endpoint") String endpoint,
            @PathParam("id") String id, @HeaderParam("x-ms-test-header") String xMsTestHeader,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadWithMultipleParametersRequest,
            RequestOptions requestOptions, Context context);

        @Post("/parameters/spread/alias/inner-alias-parameter/{id}")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> spreadParameterWithInnerAlias(@HostParam("endpoint") String endpoint,
            @PathParam("id") String id, @HeaderParam("x-ms-test-header") String xMsTestHeader,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadParameterWithInnerAliasRequest,
            RequestOptions requestOptions, Context context);

        @Post("/parameters/spread/alias/inner-alias-parameter/{id}")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> spreadParameterWithInnerAliasSync(@HostParam("endpoint") String endpoint,
            @PathParam("id") String id, @HeaderParam("x-ms-test-header") String xMsTestHeader,
            @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") BinaryData spreadParameterWithInnerAliasRequest,
            RequestOptions requestOptions, Context context);
    }

    /**
     * The spreadAsRequestBody operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Required)
     * }
     * }
     * </pre>
     * 
     * @param spreadAsRequestBodyRequest The spreadAsRequestBodyRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> spreadAsRequestBodyWithResponseAsync(BinaryData spreadAsRequestBodyRequest,
        RequestOptions requestOptions) {
        final String contentType = "application/json";
        return FluxUtil.withContext(context -> service.spreadAsRequestBody(this.client.getEndpoint(), contentType,
            spreadAsRequestBodyRequest, requestOptions, context));
    }

    /**
     * The spreadAsRequestBody operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Required)
     * }
     * }
     * </pre>
     * 
     * @param spreadAsRequestBodyRequest The spreadAsRequestBodyRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> spreadAsRequestBodyWithResponse(BinaryData spreadAsRequestBodyRequest,
        RequestOptions requestOptions) {
        final String contentType = "application/json";
        return service.spreadAsRequestBodySync(this.client.getEndpoint(), contentType, spreadAsRequestBodyRequest,
            requestOptions, Context.NONE);
    }

    /**
     * The spreadParameterWithInnerModel operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Required)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param xMsTestHeader The xMsTestHeader parameter.
     * @param spreadParameterWithInnerModelRequest The spreadParameterWithInnerModelRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> spreadParameterWithInnerModelWithResponseAsync(String id, String xMsTestHeader,
        BinaryData spreadParameterWithInnerModelRequest, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return FluxUtil.withContext(context -> service.spreadParameterWithInnerModel(this.client.getEndpoint(), id,
            xMsTestHeader, contentType, spreadParameterWithInnerModelRequest, requestOptions, context));
    }

    /**
     * The spreadParameterWithInnerModel operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Required)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param xMsTestHeader The xMsTestHeader parameter.
     * @param spreadParameterWithInnerModelRequest The spreadParameterWithInnerModelRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> spreadParameterWithInnerModelWithResponse(String id, String xMsTestHeader,
        BinaryData spreadParameterWithInnerModelRequest, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return service.spreadParameterWithInnerModelSync(this.client.getEndpoint(), id, xMsTestHeader, contentType,
            spreadParameterWithInnerModelRequest, requestOptions, Context.NONE);
    }

    /**
     * The spreadAsRequestParameter operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Required)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param xMsTestHeader The xMsTestHeader parameter.
     * @param spreadAsRequestParameterRequest The spreadAsRequestParameterRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> spreadAsRequestParameterWithResponseAsync(String id, String xMsTestHeader,
        BinaryData spreadAsRequestParameterRequest, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return FluxUtil.withContext(context -> service.spreadAsRequestParameter(this.client.getEndpoint(), id,
            xMsTestHeader, contentType, spreadAsRequestParameterRequest, requestOptions, context));
    }

    /**
     * The spreadAsRequestParameter operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Required)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param xMsTestHeader The xMsTestHeader parameter.
     * @param spreadAsRequestParameterRequest The spreadAsRequestParameterRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> spreadAsRequestParameterWithResponse(String id, String xMsTestHeader,
        BinaryData spreadAsRequestParameterRequest, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return service.spreadAsRequestParameterSync(this.client.getEndpoint(), id, xMsTestHeader, contentType,
            spreadAsRequestParameterRequest, requestOptions, Context.NONE);
    }

    /**
     * The spreadWithMultipleParameters operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     requiredString: String (Required)
     *     optionalInt: Integer (Optional)
     *     requiredIntList (Required): [
     *         int (Required)
     *     ]
     *     optionalStringList (Optional): [
     *         String (Optional)
     *     ]
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param xMsTestHeader The xMsTestHeader parameter.
     * @param spreadWithMultipleParametersRequest The spreadWithMultipleParametersRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> spreadWithMultipleParametersWithResponseAsync(String id, String xMsTestHeader,
        BinaryData spreadWithMultipleParametersRequest, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return FluxUtil.withContext(context -> service.spreadWithMultipleParameters(this.client.getEndpoint(), id,
            xMsTestHeader, contentType, spreadWithMultipleParametersRequest, requestOptions, context));
    }

    /**
     * The spreadWithMultipleParameters operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     requiredString: String (Required)
     *     optionalInt: Integer (Optional)
     *     requiredIntList (Required): [
     *         int (Required)
     *     ]
     *     optionalStringList (Optional): [
     *         String (Optional)
     *     ]
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param xMsTestHeader The xMsTestHeader parameter.
     * @param spreadWithMultipleParametersRequest The spreadWithMultipleParametersRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> spreadWithMultipleParametersWithResponse(String id, String xMsTestHeader,
        BinaryData spreadWithMultipleParametersRequest, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return service.spreadWithMultipleParametersSync(this.client.getEndpoint(), id, xMsTestHeader, contentType,
            spreadWithMultipleParametersRequest, requestOptions, Context.NONE);
    }

    /**
     * spread an alias with contains another alias property as body.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Required)
     *     age: int (Required)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param xMsTestHeader The xMsTestHeader parameter.
     * @param spreadParameterWithInnerAliasRequest The spreadParameterWithInnerAliasRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> spreadParameterWithInnerAliasWithResponseAsync(String id, String xMsTestHeader,
        BinaryData spreadParameterWithInnerAliasRequest, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return FluxUtil.withContext(context -> service.spreadParameterWithInnerAlias(this.client.getEndpoint(), id,
            xMsTestHeader, contentType, spreadParameterWithInnerAliasRequest, requestOptions, context));
    }

    /**
     * spread an alias with contains another alias property as body.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Required)
     *     age: int (Required)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param xMsTestHeader The xMsTestHeader parameter.
     * @param spreadParameterWithInnerAliasRequest The spreadParameterWithInnerAliasRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> spreadParameterWithInnerAliasWithResponse(String id, String xMsTestHeader,
        BinaryData spreadParameterWithInnerAliasRequest, RequestOptions requestOptions) {
        final String contentType = "application/json";
        return service.spreadParameterWithInnerAliasSync(this.client.getEndpoint(), id, xMsTestHeader, contentType,
            spreadParameterWithInnerAliasRequest, requestOptions, Context.NONE);
    }
}
