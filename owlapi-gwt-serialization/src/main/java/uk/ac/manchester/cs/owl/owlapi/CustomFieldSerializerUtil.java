package uk.ac.manchester.cs.owl.owlapi;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import org.semanticweb.owlapi.util.CollectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/11/2013
 */
public class CustomFieldSerializerUtil {

    public static <T> void serializeSet(Set<T> set, SerializationStreamWriter writer) throws SerializationException {
        writer.writeInt(set.size());
        for(T object : set) {
            writer.writeObject(object);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> Set<T> deserializeSet(SerializationStreamReader reader) throws SerializationException {
        int size = reader.readInt();
        List<T> elements = new ArrayList<T>();
        for(int i = 0; i < size; i++) {
            T object = (T) reader.readObject();
            elements.add(object);
        }
        return CollectionFactory.createSet(elements);
    }
}
