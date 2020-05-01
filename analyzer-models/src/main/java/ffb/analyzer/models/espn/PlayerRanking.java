package ffb.analyzer.models.espn;

/**
 * Entity representing a player's ranking.
 */
public class PlayerRanking extends EspnEntity<PlayerRanking> {

    public enum RankType {
        STANDARD,
        PPR
    }

    private int auctionValue;
    private int rank;
    private int rankSourceId;
    private RankType rankType;
    private int slotId;
    private int id;

    public PlayerRanking(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuctionValue() {
        return auctionValue;
    }

    public void setAuctionValue(int auctionValue) {
        this.auctionValue = auctionValue;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRankSourceId() {
        return rankSourceId;
    }

    public void setRankSourceId(int rankSourceId) {
        this.rankSourceId = rankSourceId;
    }

    public RankType getRankType() {
        return rankType;
    }

    public void setRankType(String rankType) {
        this.rankType = RankType.valueOf(rankType);
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
}
