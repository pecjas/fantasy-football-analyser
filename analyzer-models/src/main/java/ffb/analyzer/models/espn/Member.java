package ffb.analyzer.models.espn;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
    @JsonProperty("displayName")
    private String leagueDisplayName;

    private String firstName;
    private String lastName;

    @JsonProperty("id")
    private String espnId;

    private List<NotificationSetting> notificationSettings;


    public String getLeagueDisplayName() {
        return leagueDisplayName;
    }
    public void setLeagueDisplayName(String leagueDisplayName) {
        this.leagueDisplayName = leagueDisplayName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEspnId() {
        return espnId;
    }
    public void setEspnId(String espnId) {
        this.espnId = espnId;
    }

    public List<NotificationSetting> getNotificationSettings() {
        return notificationSettings;
    }
    public void setNotificationSettings(List<NotificationSetting> notificationSettings) {
        this.notificationSettings = notificationSettings;
    }
}
