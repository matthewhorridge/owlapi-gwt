package uk.ac.manchester.cs.owl.owlapi;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

/**
 * An implementation of CustomFieldSerilizer for serializing {@link OWLLiteralImplNoCompression}
 * objects.
 */
public class OWLLiteralImplNoCompression_CustomFieldSerializer extends CustomFieldSerializer<OWLLiteralImplNoCompression> {

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
    public OWLLiteralImplNoCompression instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    public static OWLLiteralImplNoCompression instantiate(SerializationStreamReader streamReader) throws SerializationException {
        String literal = streamReader.readString();
        String lang = streamReader.readString();
        OWLDatatype datatype = (OWLDatatype) streamReader.readObject();
        return new OWLLiteralImplNoCompression(literal, lang, datatype);
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
    public void serializeInstance(SerializationStreamWriter streamWriter, OWLLiteralImplNoCompression instance) throws SerializationException {
        serialize(streamWriter, instance);
    }

    public static void serialize(SerializationStreamWriter streamWriter, OWLLiteralImplNoCompression instance) throws SerializationException {
        streamWriter.writeString(instance.getLiteral());
        streamWriter.writeString(instance.getLang());
        streamWriter.writeObject(instance.getDatatype());
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
    public void deserializeInstance(SerializationStreamReader streamReader, OWLLiteralImplNoCompression instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    public static void deserialize(SerializationStreamReader streamReader, OWLLiteralImplNoCompression instance) throws SerializationException {

    }
}