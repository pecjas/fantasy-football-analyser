package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

public class CumulativeScoreTests extends BaseSerializationTests {
    private static final int EXPECTED_VALUE = 999;
    private static final int EXPECTED_SCORES_BY_STAT_COUNT = 7;
    private static final int EXPECTED_CUMULATIVE_SCORE_COUNT = 1;

    @Override
    public void testDeserialization() throws IOException {
        List<CumulativeScore> cumulativeScores = deserializeObjects(CumulativeScore.class);

        Assert.assertEquals(EXPECTED_CUMULATIVE_SCORE_COUNT, cumulativeScores.size());
        Assert.assertEquals(EXPECTED_VALUE, cumulativeScores.get(0).getLosses());
        Assert.assertEquals(EXPECTED_VALUE, cumulativeScores.get(0).getWins());
        Assert.assertEquals(EXPECTED_VALUE, cumulativeScores.get(0).getTies());
        Assert.assertEquals(EXPECTED_SCORES_BY_STAT_COUNT, cumulativeScores.get(0).getScoresByStats().size());
    }

    @Override
    protected String getResourceFileName() {
        return "cumulative-score.json";
    }

    @Override
    protected Class<?> getClassUnderTest() {
        return CumulativeScore.class;
    }
}
