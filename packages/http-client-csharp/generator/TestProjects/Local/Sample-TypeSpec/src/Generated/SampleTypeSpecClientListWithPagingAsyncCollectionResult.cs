// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT License.

// <auto-generated/>

#nullable disable

using System.ClientModel;
using System.ClientModel.Primitives;
using System.Collections.Generic;

namespace SampleTypeSpec
{
    internal partial class SampleTypeSpecClientListWithPagingAsyncCollectionResult : AsyncCollectionResult
    {
        private readonly SampleTypeSpecClient _client;
        private readonly RequestOptions _options;

        public SampleTypeSpecClientListWithPagingAsyncCollectionResult(SampleTypeSpecClient client, RequestOptions options)
        {
            _client = client;
            _options = options;
        }

        public override async IAsyncEnumerable<ClientResult> GetRawPagesAsync()
        {
            PipelineMessage message = _client.CreateListWithPagingRequest(_options);
            yield return ClientResult.FromResponse(await _client.Pipeline.ProcessMessageAsync(message, _options).ConfigureAwait(false));
        }

        public override ContinuationToken GetContinuationToken(ClientResult page)
        {
            return null;
        }
    }
}
