package ffb.analyzer.models.espn;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionCounter extends EspnEntity<TransactionCounter> {
    private float acquisitionBudgetSpent;

    @JsonProperty("acquisitions")
    private int countOfWaiverAcquisitions;

    @JsonProperty("drops")
    private int countOfDroppedPlayers;

    @JsonProperty("matchupAcquisitionTotals")
    private Map<Integer, Integer> acquisitionsByScoringPeriod;

    @JsonProperty("moveToActive")
    private int countOfPlayerMovesToActiveRoster;

    @JsonProperty("moveToIR")
    private int countOfPlayerMovesToIR;

    //TODO: paid
    //TODO: teamCharges

    @JsonProperty("trades")
    private int countOfTrades;


    public float getAcquisitionBudgetSpent() {
        return acquisitionBudgetSpent;
    }
    public void setAcquisitionBudgetSpent(float acquisitionBudgetSpent) {
        this.acquisitionBudgetSpent = acquisitionBudgetSpent;
    }

    public int getCountOfWaiverAcquisitions() {
        return countOfWaiverAcquisitions;
    }
    public void setCountOfWaiverAcquisitions(int waiverAcquisitions) {
        this.countOfWaiverAcquisitions = waiverAcquisitions;
    }

    public int getCountOfDroppedPlayers() {
        return countOfDroppedPlayers;
    }
    public void setCountOfDroppedPlayers(int countOfDroppedPlayers) {
        this.countOfDroppedPlayers = countOfDroppedPlayers;
    }

    public Map<Integer, Integer> getAcquisitionsByScoringPeriod() {
        return acquisitionsByScoringPeriod;
    }
    public void setAcquisitionsByScoringPeriod(Map<Integer, Integer> acquisitionsByScoringPeriod) {
        this.acquisitionsByScoringPeriod = acquisitionsByScoringPeriod;
    }

    public int getCountOfPlayerMovesToActiveRoster() {
        return countOfPlayerMovesToActiveRoster;
    }
    public void setCountOfPlayerMovesToActiveRoster(int countOfPlayerMovesToActiveRoster) {
        this.countOfPlayerMovesToActiveRoster = countOfPlayerMovesToActiveRoster;
    }

    public int getCountOfPlayerMovesToIR() {
        return countOfPlayerMovesToIR;
    }
    public void setCountOfPlayerMovesToIR(int countOfPlayerMovesToIR) {
        this.countOfPlayerMovesToIR = countOfPlayerMovesToIR;
    }

    public int getCountOfTrades() {
        return countOfTrades;
    }
    public void setCountOfTrades(int countOfTrades) {
        this.countOfTrades = countOfTrades;
    }
}
