package ffb.analyzer.models.espn;

/**
 * Entity reprsenting the details of a draft.
 */
public class DraftDetail extends EspnEntity<DraftDetail> {

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
