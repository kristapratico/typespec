// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package tsptest.discriminatoredgecases.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The GrandChildWithRequiredProperty model.
 */
@Immutable
public final class GrandChildWithRequiredProperty extends ChildWithRequiredPropertyAsDiscriminator {
    /*
     * Discriminator property for ChildWithRequiredPropertyAsDiscriminator.
     */
    @Generated
    private String discriminator = "aValue";

    /**
     * Creates an instance of GrandChildWithRequiredProperty class.
     * 
     * @param discriminator the discriminator value to set.
     * @param aProperty the aProperty value to set.
     * @param anotherProperty the anotherProperty value to set.
     */
    @Generated
    private GrandChildWithRequiredProperty(String discriminator, String aProperty, String anotherProperty) {
        super(discriminator, aProperty, anotherProperty);
    }

    /**
     * Get the discriminator property: Discriminator property for ChildWithRequiredPropertyAsDiscriminator.
     * 
     * @return the discriminator value.
     */
    @Generated
    @Override
    public String getDiscriminator() {
        return this.discriminator;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("aProperty", getAProperty());
        jsonWriter.writeStringField("anotherProperty", getAnotherProperty());
        jsonWriter.writeStringField("discriminator", this.discriminator);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GrandChildWithRequiredProperty from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GrandChildWithRequiredProperty if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GrandChildWithRequiredProperty.
     */
    @Generated
    public static GrandChildWithRequiredProperty fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String aProperty = null;
            String anotherProperty = null;
            String discriminator = "aValue";
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("aProperty".equals(fieldName)) {
                    aProperty = reader.getString();
                } else if ("anotherProperty".equals(fieldName)) {
                    anotherProperty = reader.getString();
                } else if ("discriminator".equals(fieldName)) {
                    discriminator = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            GrandChildWithRequiredProperty deserializedGrandChildWithRequiredProperty
                = new GrandChildWithRequiredProperty(discriminator, aProperty, anotherProperty);
            deserializedGrandChildWithRequiredProperty.discriminator = discriminator;

            return deserializedGrandChildWithRequiredProperty;
        });
    }
}
