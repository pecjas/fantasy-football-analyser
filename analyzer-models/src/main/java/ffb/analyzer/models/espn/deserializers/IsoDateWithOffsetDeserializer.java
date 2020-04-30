package ffb.analyzer.models.espn.deserializers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import ffb.analyzer.core.utilities.DateUtils;

/**
 * Deserializes an ISO 8601 date formatted as 2019-08-19T07:41:09.149+0000.
 */
public class IsoDateWithOffsetDeserializer extends BaseObjectDeserializer<Map<LocalDate, Integer>> {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    @Override
    public Map<LocalDate, Integer> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        Map<LocalDate, Integer> localDates = new HashMap<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<Entry<String, JsonNode>> fields = node.fields();

        fields.forEachRemaining(field -> {
            localDates.put(
                DateUtils.fromString(field.getKey(), DATE_FORMAT),
                field.getValue().intValue()
            );
        });

        return localDates;
    }
}
