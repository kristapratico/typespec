// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package payload.contentnegotiation.implementation;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;

/**
 * Initializes a new instance of the ContentNegotiationClient type.
 */
public final class ContentNegotiationClientImpl {
    /**
     * Service host.
     */
    private final String endpoint;

    /**
     * Gets Service host.
     * 
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * The HTTP pipeline to send requests through.
     */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     * 
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /**
     * The serializer to serialize an object into a string.
     */
    private final SerializerAdapter serializerAdapter;

    /**
     * Gets The serializer to serialize an object into a string.
     * 
     * @return the serializerAdapter value.
     */
    public SerializerAdapter getSerializerAdapter() {
        return this.serializerAdapter;
    }

    /**
     * The SameBodiesImpl object to access its operations.
     */
    private final SameBodiesImpl sameBodies;

    /**
     * Gets the SameBodiesImpl object to access its operations.
     * 
     * @return the SameBodiesImpl object.
     */
    public SameBodiesImpl getSameBodies() {
        return this.sameBodies;
    }

    /**
     * The DifferentBodiesImpl object to access its operations.
     */
    private final DifferentBodiesImpl differentBodies;

    /**
     * Gets the DifferentBodiesImpl object to access its operations.
     * 
     * @return the DifferentBodiesImpl object.
     */
    public DifferentBodiesImpl getDifferentBodies() {
        return this.differentBodies;
    }

    /**
     * Initializes an instance of ContentNegotiationClient client.
     * 
     * @param endpoint Service host.
     */
    public ContentNegotiationClientImpl(String endpoint) {
        this(new HttpPipelineBuilder().policies(new UserAgentPolicy(), new RetryPolicy()).build(),
            JacksonAdapter.createDefaultSerializerAdapter(), endpoint);
    }

    /**
     * Initializes an instance of ContentNegotiationClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param endpoint Service host.
     */
    public ContentNegotiationClientImpl(HttpPipeline httpPipeline, String endpoint) {
        this(httpPipeline, JacksonAdapter.createDefaultSerializerAdapter(), endpoint);
    }

    /**
     * Initializes an instance of ContentNegotiationClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializerAdapter The serializer to serialize an object into a string.
     * @param endpoint Service host.
     */
    public ContentNegotiationClientImpl(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter,
        String endpoint) {
        this.httpPipeline = httpPipeline;
        this.serializerAdapter = serializerAdapter;
        this.endpoint = endpoint;
        this.sameBodies = new SameBodiesImpl(this);
        this.differentBodies = new DifferentBodiesImpl(this);
    }
}