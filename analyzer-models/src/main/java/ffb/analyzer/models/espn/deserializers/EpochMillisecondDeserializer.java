package ffb.analyzer.models.espn.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class EpochMillisecondDeserializer extends BaseObjectDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        long timestamp = jsonParser.getLongValue();
        return toLocalDate(timestamp);
    }

    public static LocalDate toLocalDate(long timestamp) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }
}
