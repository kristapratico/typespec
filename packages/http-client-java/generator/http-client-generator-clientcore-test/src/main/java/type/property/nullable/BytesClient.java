package type.property.nullable;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.http.exceptions.HttpResponseException;
import io.clientcore.core.http.models.RequestOptions;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.models.binarydata.BinaryData;
import type.property.nullable.implementation.BytesImpl;
import type.property.nullable.implementation.JsonMergePatchHelper;

/**
 * Initializes a new instance of the synchronous NullableClient type.
 */
@ServiceClient(builder = NullableClientBuilder.class)
public final class BytesClient {
    @Metadata(generated = true)
    private final BytesImpl serviceClient;

    /**
     * Initializes an instance of BytesClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Metadata(generated = true)
    BytesClient(BytesImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Get models that will return all properties in the model.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     requiredProperty: String (Optional, Required on create)
     *     nullableProperty: byte[] (Optional, Required on create)
     * }
     * }
     * </pre>
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return models that will return all properties in the model.
     */
    @Metadata(generated = true)
    public Response<BytesProperty> getNonNullWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getNonNullWithResponse(requestOptions);
    }

    /**
     * Get models that will return the default object.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     requiredProperty: String (Optional, Required on create)
     *     nullableProperty: byte[] (Optional, Required on create)
     * }
     * }
     * </pre>
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return models that will return the default object.
     */
    @Metadata(generated = true)
    public Response<BytesProperty> getNullWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getNullWithResponse(requestOptions);
    }

    /**
     * Put a body with all properties present.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     requiredProperty: String (Optional, Required on create)
     *     nullableProperty: byte[] (Optional, Required on create)
     * }
     * }
     * </pre>
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    @Metadata(generated = true)
    public Response<Void> patchNonNullWithResponse(BinaryData body, RequestOptions requestOptions) {
        return this.serviceClient.patchNonNullWithResponse(body, requestOptions);
    }

    /**
     * Put a body with default properties.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     requiredProperty: String (Optional, Required on create)
     *     nullableProperty: byte[] (Optional, Required on create)
     * }
     * }
     * </pre>
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    @Metadata(generated = true)
    public Response<Void> patchNullWithResponse(BinaryData body, RequestOptions requestOptions) {
        return this.serviceClient.patchNullWithResponse(body, requestOptions);
    }

    /**
     * Get models that will return all properties in the model.
     * 
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return models that will return all properties in the model.
     */
    @Metadata(generated = true)
    public BytesProperty getNonNull() {
        // Generated convenience method for getNonNullWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getNonNullWithResponse(requestOptions).getValue();
    }

    /**
     * Get models that will return the default object.
     * 
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return models that will return the default object.
     */
    @Metadata(generated = true)
    public BytesProperty getNull() {
        // Generated convenience method for getNullWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getNullWithResponse(requestOptions).getValue();
    }

    /**
     * Put a body with all properties present.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Metadata(generated = true)
    public void patchNonNull(BytesProperty body) {
        // Generated convenience method for patchNonNullWithResponse
        RequestOptions requestOptions = new RequestOptions();
        JsonMergePatchHelper.getBytesPropertyAccessor().prepareModelForJsonMergePatch(body, true);
        BinaryData bodyInBinaryData = BinaryData.fromObject(body);
        // BinaryData.fromObject() will not fire serialization, use getLength() to fire serialization.
        bodyInBinaryData.getLength();
        JsonMergePatchHelper.getBytesPropertyAccessor().prepareModelForJsonMergePatch(body, false);
        patchNonNullWithResponse(bodyInBinaryData, requestOptions).getValue();
    }

    /**
     * Put a body with default properties.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Metadata(generated = true)
    public void patchNull(BytesProperty body) {
        // Generated convenience method for patchNullWithResponse
        RequestOptions requestOptions = new RequestOptions();
        JsonMergePatchHelper.getBytesPropertyAccessor().prepareModelForJsonMergePatch(body, true);
        BinaryData bodyInBinaryData = BinaryData.fromObject(body);
        // BinaryData.fromObject() will not fire serialization, use getLength() to fire serialization.
        bodyInBinaryData.getLength();
        JsonMergePatchHelper.getBytesPropertyAccessor().prepareModelForJsonMergePatch(body, false);
        patchNullWithResponse(bodyInBinaryData, requestOptions).getValue();
    }
}
