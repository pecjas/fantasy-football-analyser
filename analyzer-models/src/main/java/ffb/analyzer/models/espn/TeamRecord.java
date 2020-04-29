package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamRecord extends EspnEntity<TeamRecord> {
    @JsonProperty("away")
    private TeamRecordAway awayRecord;

    @JsonProperty("home")
    private TeamRecordHome homeRecord;

    @JsonProperty("division")
    private TeamRecordDivision divisionRecord;

    @JsonProperty("overall")
    private TeamRecordOverall overallRecord;


    public TeamRecordAway getAwayRecord() { return awayRecord; }
    public void setAwayRecord(TeamRecordAway awayRecord) {
        this.awayRecord = awayRecord;
    }

    public TeamRecordHome getHomeRecord() { return homeRecord; }
    public void setHomeRecord(TeamRecordHome homeRecord) {
        this.homeRecord = homeRecord;
    }

    public TeamRecordDivision getDivisionRecord() { return divisionRecord; }
    public void setDivisionRecord(TeamRecordDivision divisionRecord) {
        this.divisionRecord = divisionRecord;
    }

    public TeamRecordOverall getOverallRecord() { return overallRecord; }
    public void setOverallRecord(TeamRecordOverall overallRecord) {
        this.overallRecord = overallRecord;
    }
}
