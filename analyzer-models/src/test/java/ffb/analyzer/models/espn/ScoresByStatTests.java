package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScoresByStatTests extends DeserializingResourceLoader {

    private static final String SCORE_BY_STATS_FILE = "scores-by-stat.json";

    @Test
    public void testDeserialization() throws IOException {
        File file = getResourceFile(SCORE_BY_STATS_FILE);

        ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        List<ScoresByStats> scores = mapper.readValue(file,
            mapper.getTypeFactory().constructCollectionType(List.class, ScoresByStats.class));

        Assert.assertEquals(1, scores.size());
        Assert.assertEquals(7, scores.get(0).getScores().size());
    }
}
