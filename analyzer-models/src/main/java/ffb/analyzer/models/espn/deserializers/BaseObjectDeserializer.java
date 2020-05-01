package ffb.analyzer.models.espn.deserializers;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * Wrapper around {@link StdDeserializer} to make construction easier.
 * @param <T> Type of class to deserialize.
 */
abstract class BaseObjectDeserializer<T> extends StdDeserializer<T> {

    BaseObjectDeserializer() {
        this(null);
    }

    private BaseObjectDeserializer(Class<?> vc) {
        super(vc);
    }

}
