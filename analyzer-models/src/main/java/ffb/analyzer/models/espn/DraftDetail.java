package ffb.analyzer.models.espn;

public class DraftDetail {

    private boolean drafted;
    private boolean inProgress;

    public boolean isDrafted() {
        return drafted;
    }

    public void setDrafted(boolean drafted) {
        this.drafted = drafted;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}
