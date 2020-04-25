package ffb.analyzer.models.espn;

import java.util.List;

public class DraftStrategy {
    private List<Integer> keeperPlayerIds; //List of players to keep in team - only for Keeper leagues

    public List<Integer> getKeeperPlayerIds() { return keeperPlayerIds; }
    public void setKeeperPlayerIds(List<Integer> keeperPlayerIds) {
        this.keeperPlayerIds = keeperPlayerIds;
    }
}
