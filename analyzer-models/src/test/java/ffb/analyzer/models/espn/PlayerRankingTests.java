package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Assert;

import ffb.analyzer.models.espn.PlayerRanking.RankType;
import ffb.analyzer.models.espn.deserializers.PlayerRankingsDeserializer;

/**
 * Unit tests for a {@link PlayerRanking}.
 */
public class PlayerRankingTests extends BaseSerializationTests {
    private static final int EXPECTED_VALUE = 0;
    private static final int EXPECTED_RANKING_COUNT = 2;

    @Override
    protected ObjectMapper configureObjectMapper() {
        SimpleModule module = new SimpleModule().addDeserializer(List.class, new PlayerRankingsDeserializer());

        return super.configureObjectMapper()
            .registerModule(module);

    }

    @Override
    public void testDeserialization() throws IOException {
        List<PlayerRanking> rankings = deserializeObjects(PlayerRanking.class);

        Assert.assertEquals(EXPECTED_RANKING_COUNT, rankings.size());
        testRankingDeserialization(rankings.get(0), RankType.STANDARD);
        testRankingDeserialization(rankings.get(1), RankType.PPR);
    }

    private void testRankingDeserialization(PlayerRanking ranking, RankType expectedRankType) {
        Assert.assertEquals(EXPECTED_VALUE, ranking.getAuctionValue());
        Assert.assertEquals(EXPECTED_VALUE, ranking.getRank());
        Assert.assertEquals(EXPECTED_VALUE, ranking.getRankSourceId());
        Assert.assertEquals(EXPECTED_VALUE, ranking.getSlotId());

        Assert.assertEquals(ranking.getRankType(), expectedRankType);
    }

    @Override
    protected String getResourceFileName() {
        return "player-rankings.json";
    }

    @Override
    protected Class<?> getClassUnderTesting() {
        return PlayerRanking.class;
    }
}
