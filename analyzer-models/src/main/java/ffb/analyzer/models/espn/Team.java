package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.String;
import java.net.URL;
import java.util.List;

public class Team extends EspnEntity<Team> {
    private int id;

    @JsonProperty("abbrev")
    private String abbreviation;

    private int currentProjectedRank;
    private int draftDayProjectedRank;

    private int divisionId;

    private DraftStrategy draftStrategy;

    private boolean isActive;

    private String location;

    private URL logo;

    private String nickname;

    private List<String> owners;

    private int playoffSeed;

    @JsonProperty("points")
    private int regularSeasonPoints;

    //TODO: pointsAdjusted
    //TODO: pointsDelta

    private String primaryOwner;

    //TODO: rankCalculatedFinal - I think this is the estimated final standing.

    @JsonProperty("record")
    private TeamRecord record;

    //TODO: Need example of player on trade block first
    //@JsonProperty("tradeBlock")
    //private TradeBlock playersOnTradeBlock;

    private TransactionCounter transactionCounter;

    //TODO: valuesByStat - WUT?

    @JsonProperty("waiverRank")
    private int currentWaiverWireRank;


    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getCurrentProjectedRank() { return currentProjectedRank; }
    public void setCurrentProjectedRank(int currentProjectedRank) {
        this.currentProjectedRank = currentProjectedRank;
    }

    public int getDraftDayProjectedRank() { return draftDayProjectedRank; }
    public void setDraftDayProjectedRank(int draftDayProjectedRank) {
        this.draftDayProjectedRank = draftDayProjectedRank;
    }

    public int getDivisionId() { return divisionId; }
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public DraftStrategy getDraftStrategy() { return draftStrategy; }
    public void setDraftStrategy(DraftStrategy draftStrategy) {
        this.draftStrategy = draftStrategy;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) {
        this.location = location;
    }

    public URL getLogo() { return logo; }
    public void setLogo(URL logo) {
        this.logo = logo;
    }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getOwners() { return owners; }
    public void setOwners(List<String> owners) {
        this.owners = owners;
    }

    public int getPlayoffSeed() { return playoffSeed; }
    public void setPlayoffSeed(int playoffSeed) {
        this.playoffSeed = playoffSeed;
    }

    public int getRegularSeasonPoints() { return regularSeasonPoints; }
    public void setRegularSeasonPoints(int regularSeasonPoints) {
        this.regularSeasonPoints = regularSeasonPoints;
    }

    public String getPrimaryOwner() { return primaryOwner; }
    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public TeamRecord getRecord() { return record; }
    public void setRecord(TeamRecord record) {
        this.record = record;
    }

    public TransactionCounter getTransactionCounter() { return transactionCounter; }
    public void setTransactionCounter(TransactionCounter transactionCounter) {
        this.transactionCounter = transactionCounter;
    }

    public int getCurrentWaiverWireRank() { return currentWaiverWireRank; }
    public void setCurrentWaiverWireRank(int currentWaiverWireRank) {
        this.currentWaiverWireRank = currentWaiverWireRank;
    }
}
