---
# Change versionKind to one of: internal, fix, dependencies, feature, deprecation, breaking
changeKind: feature
packages:
  - "@typespec/http-specs"
---

Add Spector scenario for basic pagination without nextLink or continuationToken

This addresses the missing test case for operations marked with @list that have @pageItems but no pagination metadata like nextLink or continuationToken. The new scenario `Payload_Pageable_basic` tests the simplest form of pagination.