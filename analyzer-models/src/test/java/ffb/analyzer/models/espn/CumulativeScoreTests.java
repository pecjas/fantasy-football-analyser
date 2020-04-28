package ffb.analyzer.models.espn;

import org.junit.Assert;

import java.io.IOException;
import java.util.List;

public class CumulativeScoreTests extends DeserializingResourceLoader {

    @Override
    public void testDeserialization() throws IOException {
        List<CumulativeScore> cumulativeScores = deserializeObjects(CumulativeScore.class);

        Assert.assertEquals(1, cumulativeScores.size());
        Assert.assertEquals(0, cumulativeScores.get(0).getLosses());
        Assert.assertEquals(0, cumulativeScores.get(0).getWins());
        Assert.assertEquals(0, cumulativeScores.get(0).getTies());
        Assert.assertEquals(7, cumulativeScores.get(0).getScoresByStats().getScores().size());
    }

    @Override
    protected String getResourceFileName() {
        return "cumulative-score.json";
    }
}
