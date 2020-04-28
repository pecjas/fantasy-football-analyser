package ffb.analyzer.models.espn;

import org.junit.Assert;

import java.io.IOException;
import java.util.List;

public class ScoresByStatTests extends DeserializingResourceLoader {

    @Override
    public void testDeserialization() throws IOException {
        List<ScoresByStats> scores = deserializeObjects(ScoresByStats.class);

        Assert.assertEquals(1, scores.size());
        Assert.assertEquals(7, scores.get(0).getScores().size());
    }

    @Override
    protected String getResourceFileName() {
        return "scores-by-stat.json";
    }
}
