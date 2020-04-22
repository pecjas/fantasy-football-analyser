package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ffb.analyzer.models.espn.serialization.EpochMillisecondDeserializer;

import java.util.Date;

/**
 * Class representing the information about a season.
 */
public class SeasonInformation {
    private String name;
    private int gameId;
    private int displayOrder;

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    private Date endDate;

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    private Date startDate;

    @JsonProperty("abbrev")
    private String abbreviation;

    @JsonProperty("display")
    private boolean shouldDisplay;

    @JsonProperty("active")
    private boolean activeStatus;

    @JsonProperty("currentScoringPeriod")
    private ScoringPeriod scoringPeriod;

    @JsonProperty("id")
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public boolean isShouldDisplay() {
        return shouldDisplay;
    }

    public void setShouldDisplay(boolean shouldDisplay) {
        this.shouldDisplay = shouldDisplay;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public ScoringPeriod getScoringPeriod() {
        return scoringPeriod;
    }

    public void setScoringPeriod(ScoringPeriod scoringPeriod) {
        this.scoringPeriod = scoringPeriod;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
