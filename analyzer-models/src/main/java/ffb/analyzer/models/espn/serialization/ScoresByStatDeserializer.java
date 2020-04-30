package ffb.analyzer.models.espn.serialization;

import ffb.analyzer.models.espn.ScoreByStat;
import ffb.analyzer.models.espn.ScoresByStats;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class ScoresByStatDeserializer extends StdDeserializer<ScoresByStats> {
    private static final String INELIGIBLE_FIELD_NAME = "ineligible";
    private static final String RANK_FIELD_NAME = "rank";
    private static final String SCORE_FIELD_NAME = "score";

    public ScoresByStatDeserializer() {
        this(null);
    }

    public ScoresByStatDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ScoresByStats deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<Entry<String, JsonNode>> fields = node.fields();
        ScoresByStats scores = new ScoresByStats();

        fields.forEachRemaining(field -> {
            String statIdName = field.getKey();
            JsonNode statNode = field.getValue();

            ScoreByStat score = new ScoreByStat();
            score.setId(Integer.parseInt(statIdName));
            score.setIneligible(statNode.get(INELIGIBLE_FIELD_NAME).booleanValue());
            score.setScore(statNode.get(SCORE_FIELD_NAME).floatValue());
            score.setRank(statNode.get(RANK_FIELD_NAME).floatValue());

            scores.getScores().add(score);
        });

        return scores;
    }
}
