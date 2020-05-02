package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationSetting extends EspnEntity<NotificationSetting> {
    public enum NotificationType {
        TEAM_TRADE_OFFER,
        TEAM_PLAYER_AVAILABILITY,
        TEAM_PLAYER_INJURY,
        TEAM_PLAYER_STARTBENCH,
        TEAM_PLAYER_NEWS,
        DRAFT
    }

    private boolean enabled;

    @JsonProperty("id")
    private String playerNotificationId;

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPlayerNotificationId() {
        return playerNotificationId;
    }
    public void setPlayerNotificationId(String playerNotificationId) {
        this.playerNotificationId = playerNotificationId;
    }
}
