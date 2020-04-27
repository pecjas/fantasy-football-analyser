package ffb.analyzer.models.espn.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class EpochMillisecondDeserializer extends StdDeserializer<LocalDate> {

    public EpochMillisecondDeserializer() {
        this(null);
    }

    public EpochMillisecondDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        long timestamp = jsonParser.getLongValue();
        return toLocalDate(timestamp);
    }

    public static LocalDate toLocalDate(long timestamp) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }
}
