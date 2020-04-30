package ffb.analyzer.models.espn;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ffb.analyzer.models.espn.deserializers.EpochMillisecondDeserializer;

/**
 * Class representing the information about a season.
 */
public class SeasonInformation extends EspnEntity<SeasonInformation> {
    private String name;
    private int gameId;
    private int displayOrder;
    private boolean isActive;
    private LocalDate endDate;
    private LocalDate startDate;

    @JsonProperty("abbrev")
    private String abbreviation;

    @JsonProperty("display")
    private boolean isDisplayable;

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

    public LocalDate getEndDate() {
        return endDate;
    }

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    public void setStartDate(LocalDate startDate) {
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

    public boolean isDisplayable() {
        return isDisplayable;
    }

    public void setIsDisplayable(boolean shouldDisplay) {
        this.isDisplayable = shouldDisplay;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean activeStatus) {
        this.isActive = activeStatus;
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
