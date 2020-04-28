package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;

/**
 * Unit tests for {@link ScoreByStat}.
 */
public class ScoreByStatTests extends DeserializingResourceLoader {

    @Override
    public void testDeserialization() throws IOException {

        List<ScoreByStat> scores = deserializeObjects(ScoreByStat.class);
        Assert.assertEquals(1, scores.size());

        ScoreByStat score = scores.get(0);

        Assert.assertEquals(136, score.getId());
        Assert.assertFalse(score.isIneligible());
        Assert.assertEquals(0.0, score.getRank(), .1);
        Assert.assertEquals(0.0, score.getScore(), .1);
    }

    @Override
    protected String getResourceFileName() {
        return "score-by-stat.json";
    }
}
