package org.semanticweb.owlapi.model;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

/**
 * An implementation of CustomFieldSerilizer for serializing {@link EntityType} objects.
 */
public class EntityType_CustomFieldSerializer extends CustomFieldSerializer<EntityType> {

    public static final byte CLASS_MARKER = (byte) 1;

    public static final byte OBJECT_PROPERTY_MARKER = (byte) 2;

    public static final byte DATA_PROPERTY_MARKER = (byte) 3;

    public static final byte ANNOTATION_PROPERTY_MARKER = (byte) 4;

    public static final byte NAMED_INDIVIDUAL_PROPERTY_MARKER = (byte) 5;

    public static final byte DATATYPE_MARKER = (byte) 6;


    /**
     * @return <code>true</code> if a specialist {@link #instantiateInstance} is
     *         implemented; <code>false</code> otherwise
     */
    @Override
    public boolean hasCustomInstantiateInstance() {
        return true;
    }

    /**
     * Instantiates an object from the {@link com.google.gwt.user.client.rpc.SerializationStreamReader}.
     * <p>
     * Most of the time, this can be left unimplemented and the framework
     * will instantiate the instance itself.  This is typically used when the
     * object being deserialized is immutable, hence it has to be created with
     * its state already set.
     * <p>
     * If this is overridden, the {@link #hasCustomInstantiateInstance} method
     * must return <code>true</code> in order for the framework to know to call
     * it.
     * @param streamReader the {@link com.google.gwt.user.client.rpc.SerializationStreamReader} to read the
     * object's content from
     * @return an object that has been loaded from the
     *         {@link com.google.gwt.user.client.rpc.SerializationStreamReader}
     * @throws com.google.gwt.user.client.rpc.SerializationException
     *          if the instantiation operation is not
     *          successful
     */
    @Override
    public EntityType instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    public static EntityType instantiate(SerializationStreamReader streamReader) throws SerializationException {
        byte marker = streamReader.readByte();
        if(marker == CLASS_MARKER) {
            return EntityType.CLASS;
        }
        else if(marker == OBJECT_PROPERTY_MARKER) {
            return EntityType.OBJECT_PROPERTY;
        }
        else if(marker == DATA_PROPERTY_MARKER) {
            return EntityType.DATA_PROPERTY;
        }
        else if(marker == ANNOTATION_PROPERTY_MARKER) {
            return EntityType.ANNOTATION_PROPERTY;
        }
        else if(marker == NAMED_INDIVIDUAL_PROPERTY_MARKER) {
            return EntityType.NAMED_INDIVIDUAL;
        }
        else if(marker == DATATYPE_MARKER) {
            return EntityType.DATATYPE;
        }
        else {
            throw new SerializationException("Unknown type marker: " + marker);
        }
    }


    /**
     * Serializes the content of the object into the
     * {@link com.google.gwt.user.client.rpc.SerializationStreamWriter}.
     * @param streamWriter the {@link com.google.gwt.user.client.rpc.SerializationStreamWriter} to write the
     * object's content to
     * @param instance the object instance to serialize
     * @throws com.google.gwt.user.client.rpc.SerializationException
     *          if the serialization operation is not
     *          successful
     */
    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, EntityType instance) throws SerializationException {
        serialize(streamWriter, instance);
    }

    public static void serialize(SerializationStreamWriter streamWriter, EntityType instance) throws SerializationException {
        if(instance == EntityType.CLASS) {
            streamWriter.writeByte(CLASS_MARKER);
        }
        else if(instance == EntityType.OBJECT_PROPERTY) {
            streamWriter.writeByte(OBJECT_PROPERTY_MARKER);
        }
        else if(instance == EntityType.DATA_PROPERTY) {
            streamWriter.writeByte(DATA_PROPERTY_MARKER);
        }
        else if(instance == EntityType.ANNOTATION_PROPERTY) {
            streamWriter.writeByte(ANNOTATION_PROPERTY_MARKER);
        }
        else if(instance == EntityType.NAMED_INDIVIDUAL) {
            streamWriter.writeByte(NAMED_INDIVIDUAL_PROPERTY_MARKER);
        }
        else if(instance == EntityType.DATATYPE) {
            streamWriter.writeByte(DATATYPE_MARKER);
        }
    }


    /**
     * Deserializes the content of the object from the
     * {@link com.google.gwt.user.client.rpc.SerializationStreamReader}.
     * @param streamReader the {@link com.google.gwt.user.client.rpc.SerializationStreamReader} to read the
     * object's content from
     * @param instance the object instance to deserialize
     * @throws com.google.gwt.user.client.rpc.SerializationException
     *          if the deserialization operation is not
     *          successful
     */
    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, EntityType instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    public static void deserialize(SerializationStreamReader streamReader, EntityType instance) throws SerializationException {

    }
}