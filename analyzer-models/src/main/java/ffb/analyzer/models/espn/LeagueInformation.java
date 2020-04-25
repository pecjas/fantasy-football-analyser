package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ffb.analyzer.models.espn.serialization.EpochMillisecondDeserializer;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class LeagueInformation {

    public enum LeagueType {
        PRIVATE(0),
        PUBLIC(1);

        LeagueType(int type) {}
    }

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    private Date activatedDate;
    private boolean isFull;
    private boolean isActive;
    private boolean isExpired;
    private boolean isPlayoffMatchupEdited;
    private boolean isWillBeDeleted;
    private boolean isViewable;
    private boolean isWaiverOrderEdited;
    private List<Integer> previousSeasons;
    private Date waiverLastExecutionDate;

    @JsonProperty("waiverProcessStatus")
    private Map<Date, Integer> transactions;

    @JsonProperty("latestScoringPeriod")
    private int lastScoringPeriod;

    @JsonProperty("firstScoringPeriod")
    private int firstWeek;

    @JsonProperty("finalScoringPeriod")
    private int finalWeek;

    @JsonProperty("currentMatchupPeriod")
    private int currentWeek;

    @JsonProperty("createdAsLeagueType")
    private LeagueType createdAsType;

    @JsonProperty("currentLeagueType")
    private LeagueType currentType;


    public Date getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isPlayoffMatchupEdited() {
        return isPlayoffMatchupEdited;
    }

    public void setPlayoffMatchupEdited(boolean playoffMatchupEdited) {
        isPlayoffMatchupEdited = playoffMatchupEdited;
    }

    public boolean isWillBeDeleted() {
        return isWillBeDeleted;
    }

    public void setWillBeDeleted(boolean willBeDeleted) {
        isWillBeDeleted = willBeDeleted;
    }

    public boolean isViewable() {
        return isViewable;
    }

    public void setViewable(boolean viewable) {
        isViewable = viewable;
    }

    public boolean isWaiverOrderEdited() {
        return isWaiverOrderEdited;
    }

    public void setWaiverOrderEdited(boolean waiverOrderEdited) {
        isWaiverOrderEdited = waiverOrderEdited;
    }

    public List<Integer> getPreviousSeasons() {
        return previousSeasons;
    }

    public void setPreviousSeasons(List<Integer> previousSeasons) {
        this.previousSeasons = previousSeasons;
    }

    public Date getWaiverLastExecutionDate() {
        return waiverLastExecutionDate;
    }

    public void setWaiverLastExecutionDate(Date waiverLastExecutionDate) {
        this.waiverLastExecutionDate = waiverLastExecutionDate;
    }

    public Map<Date, Integer> getTransactions() {
        return transactions;
    }

    public void setTransactions(Map<Date, Integer> transactions) {
        this.transactions = transactions;
    }

    public int getLastScoringPeriod() {
        return lastScoringPeriod;
    }

    public void setLastScoringPeriod(int lastScoringPeriod) {
        this.lastScoringPeriod = lastScoringPeriod;
    }

    public int getFirstWeek() {
        return firstWeek;
    }

    public void setFirstWeek(int firstWeek) {
        this.firstWeek = firstWeek;
    }

    public int getFinalWeek() {
        return finalWeek;
    }

    public void setFinalWeek(int finalWeek) {
        this.finalWeek = finalWeek;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(int currentWeek) {
        this.currentWeek = currentWeek;
    }

    public LeagueType getCreatedAsType() {
        return createdAsType;
    }

    public void setCreatedAsType(LeagueType createdAsType) {
        this.createdAsType = createdAsType;
    }

    public LeagueType getCurrentType() {
        return currentType;
    }

    public void setCurrentType(LeagueType currentType) {
        this.currentType = currentType;
    }
}
