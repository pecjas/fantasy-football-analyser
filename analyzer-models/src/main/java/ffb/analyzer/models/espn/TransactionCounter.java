package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class TransactionCounter extends EspnEntity<TransactionCounter> {
    private float acquisitionBudgetSpent;

    @JsonProperty("acquisitions")
    private int waiverAcquisitions;

    @JsonProperty("drops")
    private int droppedPlayerCount;

    @JsonProperty("matchupAcquisitionTotals")
    private Map<String, Integer> acquisitionsByScoringPeriod;

    @JsonProperty("moveToActive")
    private int countPlayerMovesToActiveRoster;

    @JsonProperty("moveToIR")
    private int countPlayerMovesToIR;

    //TODO: paid
    //TODO: teamCharges

    @JsonProperty("trades")
    private int countOfTrades;


    public float getAcquisitionBudgetSpent() { return acquisitionBudgetSpent; }
    public void setAcquisitionBudgetSpent(float acquisitionBudgetSpent) {
        this.acquisitionBudgetSpent = acquisitionBudgetSpent;
    }

    public int getWaiverAcquisitions() { return waiverAcquisitions; }
    public void setWaiverAcquisitions(int waiverAcquisitions) {
        this.waiverAcquisitions = waiverAcquisitions;
    }

    public int getDroppedPlayerCount() { return droppedPlayerCount; }
    public void setDroppedPlayerCount(int droppedPlayerCount) {
        this.droppedPlayerCount = droppedPlayerCount;
    }

    public Map<String, Integer> getAcquisitionsByScoringPeriod() { return acquisitionsByScoringPeriod; }
    public void setAcquisitionsByScoringPeriod(Map<String, Integer> acquisitionsByScoringPeriod) {
        this.acquisitionsByScoringPeriod = acquisitionsByScoringPeriod;
    }

    public int getCountPlayerMovesToActiveRoster() { return countPlayerMovesToActiveRoster; }
    public void setCountPlayerMovesToActiveRoster(int countPlayerMovesToActiveRoster) {
        this.countPlayerMovesToActiveRoster = countPlayerMovesToActiveRoster;
    }

    public int getCountPlayerMovesToIR() { return countPlayerMovesToIR; }
    public void setCountPlayerMovesToIR(int countPlayerMovesToIR) {
        this.countPlayerMovesToIR = countPlayerMovesToIR;
    }

    public int getCountOfTrades() { return countOfTrades; }
    public void setCountOfTrades(int countOfTrades) {
        this.countOfTrades = countOfTrades;
    }
}
