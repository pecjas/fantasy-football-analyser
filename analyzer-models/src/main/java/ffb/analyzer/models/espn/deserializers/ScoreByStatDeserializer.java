package ffb.analyzer.models.espn.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import ffb.analyzer.models.espn.ScoreByStat;

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
        double rank = fields.get("rank").doubleValue();
        double score = fields.get("score").doubleValue();

        ScoreByStat stat = new ScoreByStat();
        stat.setId(Integer.parseInt(statFieldName));
        stat.setIneligible(ineligible);
        stat.setRank(rank);
        stat.setScore(score);

        return stat;
    }
}
