// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package tsptest.server;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import tsptest.server.implementation.HttpbinClientImpl;

/**
 * Initializes a new instance of the synchronous HttpbinClient type.
 */
@ServiceClient(builder = HttpbinClientBuilder.class)
public final class HttpbinClient {
    @Generated
    private final HttpbinClientImpl serviceClient;

    /**
     * Initializes an instance of HttpbinClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    HttpbinClient(HttpbinClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The status operation.
     * 
     * @param code The code parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> statusWithResponse(int code, RequestOptions requestOptions) {
        return this.serviceClient.statusWithResponse(code, requestOptions);
    }

    /**
     * The status operation.
     * 
     * @param code The code parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void status(int code) {
        // Generated convenience method for statusWithResponse
        RequestOptions requestOptions = new RequestOptions();
        statusWithResponse(code, requestOptions).getValue();
    }
}
