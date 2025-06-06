// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package parameters.bodyoptionality;

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
import com.azure.core.util.BinaryData;
import com.azure.core.util.FluxUtil;
import parameters.bodyoptionality.implementation.BodyOptionalityClientImpl;
import parameters.bodyoptionality.models.BodyModel;
import reactor.core.publisher.Mono;

/**
 * Initializes a new instance of the asynchronous BodyOptionalityClient type.
 */
@ServiceClient(builder = BodyOptionalityClientBuilder.class, isAsync = true)
public final class BodyOptionalityAsyncClient {
    @Generated
    private final BodyOptionalityClientImpl serviceClient;

    /**
     * Initializes an instance of BodyOptionalityAsyncClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    BodyOptionalityAsyncClient(BodyOptionalityClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The requiredExplicit operation.
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
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> requiredExplicitWithResponse(BinaryData body, RequestOptions requestOptions) {
        return this.serviceClient.requiredExplicitWithResponseAsync(body, requestOptions);
    }

    /**
     * The requiredImplicit operation.
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
     * @param bodyModel The bodyModel parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> requiredImplicitWithResponse(BinaryData bodyModel, RequestOptions requestOptions) {
        return this.serviceClient.requiredImplicitWithResponseAsync(bodyModel, requestOptions);
    }

    /**
     * The requiredExplicit operation.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> requiredExplicit(BodyModel body) {
        // Generated convenience method for requiredExplicitWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return requiredExplicitWithResponse(BinaryData.fromObject(body), requestOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * The requiredImplicit operation.
     * 
     * @param name The name parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> requiredImplicit(String name) {
        // Generated convenience method for requiredImplicitWithResponse
        RequestOptions requestOptions = new RequestOptions();
        BodyModel bodyModelObj = new BodyModel(name);
        BinaryData bodyModel = BinaryData.fromObject(bodyModelObj);
        return requiredImplicitWithResponse(bodyModel, requestOptions).flatMap(FluxUtil::toMono);
    }
}
