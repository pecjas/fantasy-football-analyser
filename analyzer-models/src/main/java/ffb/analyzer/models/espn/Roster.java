package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Roster extends EspnEntity<Roster> {

    private float appliedStatTotal;
    private List<RosterEntry> players;

    public float getAppliedStatTotal() {
        return appliedStatTotal;
    }

    public void setAppliedStatTotal(float appliedStatTotal) {
        this.appliedStatTotal = appliedStatTotal;
    }

    public List<RosterEntry> getPlayers() {
        return players;
    }

    @JsonProperty("entries")
    public void setPlayers(List<RosterEntry> players) {
        this.players = players;
    }
}
