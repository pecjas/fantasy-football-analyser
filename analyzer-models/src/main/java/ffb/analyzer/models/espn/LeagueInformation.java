package ffb.analyzer.models.espn;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ffb.analyzer.models.espn.deserializers.EpochMillisecondDeserializer;
import ffb.analyzer.models.espn.deserializers.IsoDateWithOffsetDeserializer;

/**
 * Entity representing information about a Fantasy Football league.
 */
public class LeagueInformation extends EspnEntity<LeagueInformation> {

    public enum LeagueType {
        PRIVATE,
        PUBLIC
    }

    private boolean isFull;
    private boolean isActive;
    private boolean isExpired;
    private boolean isToBeDeleted;
    private boolean isViewable;
    private List<Integer> previousSeasons;
    private int teamsJoined;
    private int transactionScoringPeriod;
    private LocalDate activatedDate;
    private LocalDate waiverLastExecutionDate;
    private LocalDate standingsUpdateDate;

    @JsonProperty("waiverProcessStatus")
    private Map<LocalDate, Integer> transactions;

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

    public LocalDate getActivatedDate() {
        return activatedDate;
    }

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    public void setActivatedDate(LocalDate activatedDate) {
        this.activatedDate = activatedDate;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setIsFull(boolean full) {
        isFull = full;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean getIsToBeDeleted() {
        return isToBeDeleted;
    }

    public void setIsToBeDeleted(boolean willBeDeleted) {
        this.isToBeDeleted = willBeDeleted;
    }

    public boolean isViewable() {
        return isViewable;
    }

    public void setIsViewable(boolean viewable) {
        isViewable = viewable;
    }

    public List<Integer> getPreviousSeasons() {
        return previousSeasons;
    }

    public void setPreviousSeasons(List<Integer> previousSeasons) {
        this.previousSeasons = previousSeasons;
    }

    public LocalDate getWaiverLastExecutionDate() {
        return waiverLastExecutionDate;
    }

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    public void setWaiverLastExecutionDate(LocalDate waiverLastExecutionDate) {
        this.waiverLastExecutionDate = waiverLastExecutionDate;
    }

    public Map<LocalDate, Integer> getTransactions() {
        return transactions;
    }

    @JsonDeserialize(using = IsoDateWithOffsetDeserializer.class)
    public void setTransactions(Map<LocalDate, Integer> transactions) {
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

    public LocalDate getStandingsUpdateDate() {
        return standingsUpdateDate;
    }

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    public void setStandingsUpdateDate(LocalDate standingsUpdateDate) {
        this.standingsUpdateDate = standingsUpdateDate;
    }

    public int getTeamsJoined() {
        return teamsJoined;
    }

    public void setTeamsJoined(int teamsJoined) {
        this.teamsJoined = teamsJoined;
    }

    public int getTransactionScoringPeriod() {
        return transactionScoringPeriod;
    }

    public void setTransactionScoringPeriod(int transactionScoringPeriod) {
        this.transactionScoringPeriod = transactionScoringPeriod;
    }
}
