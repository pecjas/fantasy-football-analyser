package ffb.analyzer.models.espn;

public class TeamRecordOverall extends TeamRecordBase {
    private float pointsFor;
    private float pointsAgainst;


    public float getPointsFor() { return pointsFor; }
    public void setPointsFor(float pointsFor) {
        this.pointsFor = pointsFor;
    }

    public float getPointsAgainst() { return pointsAgainst; }
    public void setPointsAgainst(float pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }
}
