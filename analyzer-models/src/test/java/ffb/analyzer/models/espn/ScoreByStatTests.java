package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

/**
 * Unit tests for {@link ScoreByStat}.
 */
public class ScoreByStatTests extends BaseSerializationTests {
    private static final double DELTA = .1;
    private static final int EXPECTED_INT_VALUE = 1;
    private static final double EXPECTED_DOUBLE_VALUE = 1.0;

    @Override
    public void testDeserialization() throws IOException {

        List<ScoreByStat> scores = deserializeObjects(ScoreByStat.class);
        Assert.assertEquals(EXPECTED_INT_VALUE, scores.size());

        ScoreByStat score = scores.get(0);

        Assert.assertEquals(EXPECTED_INT_VALUE, score.getId());
        Assert.assertFalse(score.isIneligible());
        Assert.assertEquals(EXPECTED_DOUBLE_VALUE, score.getRank(), DELTA);
        Assert.assertEquals(EXPECTED_DOUBLE_VALUE, score.getScore(), DELTA);
    }

    @Override
    protected String getResourceFileName() {
        return "score-by-stat.json";
    }

    @Override
    protected Class<?> getClassUnderTest() {
        return ScoreByStat.class;
    }
}
