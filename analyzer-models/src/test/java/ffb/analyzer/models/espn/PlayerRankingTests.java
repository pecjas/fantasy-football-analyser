package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ffb.analyzer.models.espn.deserializers.PlayerRankingsDeserializer;
import org.junit.Assert;
import ffb.analyzer.models.espn.PlayerRanking.RankType;

import java.io.IOException;
import java.util.List;

public class PlayerRankingTests extends DeserializingResourceLoader {

    @Override
    protected ObjectMapper configureObjectMapper() {
        SimpleModule module = new SimpleModule().addDeserializer(List.class, new PlayerRankingsDeserializer());

        return super.configureObjectMapper()
            .registerModule(module);

    }

    @Override
    public void testDeserialization() throws IOException {
        List<PlayerRanking> rankings = deserializeObjects(PlayerRanking.class);

        Assert.assertEquals(4, rankings.size());
        rankings.forEach(this::testRankingDeserialization);
    }

    private void testRankingDeserialization(PlayerRanking ranking) {
        Assert.assertEquals(0, ranking.getAuctionValue());
        Assert.assertEquals(0, ranking.getRank());
        Assert.assertEquals(0, ranking.getRankSourceId());
        Assert.assertEquals(4, ranking.getSlotId());
        Assert.assertTrue(
            ranking.getRankType().equals(RankType.PPR) || ranking.getRankType().equals(RankType.STANDARD)
        );
    }

    @Override
    protected String getResourceFileName() {
        return "player-rankings.json";
    }
}
