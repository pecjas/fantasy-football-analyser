package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representing the information about a season.
 */
public class SeasonInformation {
    private String name;
    private long endDate;
    private long startDate;
    private int gameId;
    private int displayOrder;

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

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
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
