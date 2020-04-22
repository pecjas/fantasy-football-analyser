package ffb.analyzer.models.espn.serialization;

import com.fasterxml.jackson.databind.JavaType;
import ffb.analyzer.models.espn.ScoreByStat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ScoreByStatSerializer extends StdDeserializer<ScoreByStat> {

    protected ScoreByStatSerializer(Class<?> vc) {
        super(vc);
    }

    protected ScoreByStatSerializer(JavaType valueType) {
        super(valueType);
    }

    protected ScoreByStatSerializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public ScoreByStat deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        int id = Integer.parseInt(jsonParser.getCurrentName());

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        boolean ineligible = node.get("ineligible").booleanValue();
        float rank = node.get("rank").floatValue();
        float score = node.get("score").floatValue();

        ScoreByStat stat = new ScoreByStat();
        stat.setId(id);
        stat.setIneligible(ineligible);
        stat.setRank(rank);
        stat.setScore(score);

        return stat;
    }
}
