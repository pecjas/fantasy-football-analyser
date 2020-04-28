package ffb.analyzer.models.espn.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import ffb.analyzer.models.espn.ScoreByStat;
import java.io.IOException;

/**
 * Deserialize JSON into a {@link ScoreByStat} object.
 */
public class ScoreByStatDeserializer extends BaseObjectDeserializer<ScoreByStat> {

    @Override
    public ScoreByStat deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String statFieldName = node.fieldNames().next();

        JsonNode fields = node.get(statFieldName);

        boolean ineligible = fields.get("ineligible").booleanValue();
        float rank = fields.get("rank").floatValue();
        float score = fields.get("score").floatValue();

        ScoreByStat stat = new ScoreByStat();
        stat.setId(Integer.parseInt(statFieldName));
        stat.setIneligible(ineligible);
        stat.setRank(rank);
        stat.setScore(score);

        return stat;
    }
}
