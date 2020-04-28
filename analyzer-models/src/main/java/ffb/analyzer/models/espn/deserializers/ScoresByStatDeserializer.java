package ffb.analyzer.models.espn.deserializers;

import ffb.analyzer.models.espn.ScoreByStat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class ScoresByStatDeserializer extends BaseObjectDeserializer<List<ScoreByStat>> {
    private static final String INELIGIBLE_FIELD_NAME = "ineligible";
    private static final String RANK_FIELD_NAME = "rank";
    private static final String SCORE_FIELD_NAME = "score";

    @Override
    public List<ScoreByStat> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<Entry<String, JsonNode>> fields = node.fields();
        List<ScoreByStat> scores = new ArrayList<>();

        fields.forEachRemaining(field -> {
            String statIdName = field.getKey();
            JsonNode statNode = field.getValue();

            ScoreByStat score = new ScoreByStat();
            score.setId(Integer.parseInt(statIdName));
            score.setIneligible(statNode.get(INELIGIBLE_FIELD_NAME).booleanValue());
            score.setScore(statNode.get(SCORE_FIELD_NAME).floatValue());
            score.setRank(statNode.get(RANK_FIELD_NAME).floatValue());

            scores.add(score);
        });

        return scores;
    }
}
