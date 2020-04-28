package ffb.analyzer.models.espn.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//TODO: Rename this since this doesn't deserialize epoch milliseconds
//This deserializes a date like: 2019-08-19T07:41:09.149+0000
public class IsoDateWithOffsetDeserializer extends BaseObjectDeserializer<Map<LocalDate, Integer>>
{
    private final DateTimeFormatter formatter;

    public IsoDateWithOffsetDeserializer() {
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }

    @Override
    public Map<LocalDate, Integer> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        Map<LocalDate, Integer> localDates = new HashMap<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<Entry<String, JsonNode>> fields = node.fields();

        fields.forEachRemaining(field -> {
            localDates.put(
                LocalDate.parse(field.getKey(), formatter),
                field.getValue().intValue()
            );
        });

        return localDates;
    }
}
