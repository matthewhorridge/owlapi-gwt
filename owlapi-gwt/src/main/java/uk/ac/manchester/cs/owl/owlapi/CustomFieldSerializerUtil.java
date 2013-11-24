package uk.ac.manchester.cs.owl.owlapi;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.util.CollectionFactory;

import java.util.*;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/11/2013
 */
public class CustomFieldSerializerUtil {

    private static <T> void serializeCollection(Collection<T> set, SerializationStreamWriter writer) throws SerializationException {
        writer.writeInt(set.size());
        for(T object : set) {
            writer.writeObject(object);
        }
    }

    public static <T> void serializeSet(Set<T> set, SerializationStreamWriter writer) throws SerializationException {
        serializeCollection(set, writer);
    }


    public static <T> Set<T> deserializeSet(SerializationStreamReader reader) throws SerializationException {
        List<T> elements = derserializeCollection(reader);
        if(elements.isEmpty()) {
            return Collections.emptySet();
        }
        return CollectionFactory.createSet(elements);
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> derserializeCollection(SerializationStreamReader reader) throws SerializationException {
        int size = reader.readInt();
        if(size == 0) {
            return Collections.emptyList();
        }
        List<T> elements = new ArrayList<T>();
        for(int i = 0; i < size; i++) {
            T object = (T) reader.readObject();
            elements.add(object);
        }
        return elements;
    }

    public static <A extends OWLAxiom> void serializeAnnotations(A axiom, SerializationStreamWriter writer) throws SerializationException {
        Set<OWLAnnotation> annotations = axiom.getAnnotations();
        serializeSet(annotations, writer);
    }

    public static Set<OWLAnnotation> deserializeAnnotations(SerializationStreamReader reader) throws SerializationException {
        return deserializeSet(reader);
    }
}
