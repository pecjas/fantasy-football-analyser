package ffb.analyzer.models.espn;

import org.junit.Assert;

import java.io.IOException;
import java.util.List;

public class ScoreByStatTests extends DeserializingResourceLoader {

    @Override
    public void testDeserialization() throws IOException {

        List<ScoreByStat> scores = deserializeObjects(ScoreByStat.class);
        Assert.assertEquals(1, scores.size());
    }

    @Override
    protected String getResourceFileName() {
        return "score-by-stat.json";
    }
}
