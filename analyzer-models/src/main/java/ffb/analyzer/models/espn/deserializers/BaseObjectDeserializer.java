package ffb.analyzer.models.espn.deserializers;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

abstract class BaseObjectDeserializer<T> extends StdDeserializer<T> {

    BaseObjectDeserializer() {
        this(null);
    }

    private BaseObjectDeserializer(Class<?> vc) {
        super(vc);
    }

}
