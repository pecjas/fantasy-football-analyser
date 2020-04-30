package ffb.analyzer.models.espn.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Date;

public class EpochMillisecondDeserializer extends StdDeserializer<Date> {

    public EpochMillisecondDeserializer() {
        this(null);
    }

    public EpochMillisecondDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        long timestamp = jsonParser.getLongValue();
        return new Date(timestamp);
    }
}
