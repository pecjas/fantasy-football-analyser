package ffb.analyzer.models.espn.deserializers;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

import ffb.analyzer.core.utilities.DateUtils;

public class EpochMillisecondDeserializer extends BaseObjectDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        return DateUtils.fromEpochMillisecond(jsonParser.getLongValue());
    }
}
