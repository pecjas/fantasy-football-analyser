package ffb.analyzer.models.espn.deserializers;

import ffb.analyzer.models.espn.PlayerRanking;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PlayerRankingsDeserializer extends BaseObjectDeserializer<List<PlayerRanking>> {

    private static final String AUCTION_FIELD = "auctionValue";
    private static final String RANK_FIELD = "rank";
    private static final String RANK_TYPE_FIELD = "rankType";
    private static final String SLOT_FIELD = "slotId";
    private static final String RANK_SOURCE_FIELD = "rankSourceId";

    @Override
    public List<PlayerRanking> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException
    {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
        List<PlayerRanking> rankings = new ArrayList<>();

        fields.forEachRemaining(field -> {
            deserializeAndAddRanking(rankings, Integer.parseInt(field.getKey()), field.getValue());
        });

        return rankings;
    }

    private void deserializeAndAddRanking(List<PlayerRanking> rankings, Integer id, JsonNode node) {
        node.forEach(rankJsonObj -> {
            PlayerRanking ranking = new PlayerRanking(id);
            ranking.setAuctionValue(parseInt(rankJsonObj, AUCTION_FIELD));
            ranking.setSlotId(parseInt(rankJsonObj, SLOT_FIELD));

            ranking.setRank(parseInt(rankJsonObj, RANK_FIELD));
            ranking.setRankSourceId(parseInt(rankJsonObj, RANK_SOURCE_FIELD));
            ranking.setRankType(rankJsonObj.get(RANK_TYPE_FIELD).asText());


            rankings.add(ranking);
        });
    }

    private int parseInt(JsonNode node, String fieldName) {
        return node.get(fieldName).intValue();
    }

}
