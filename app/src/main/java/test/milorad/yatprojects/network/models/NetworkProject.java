package test.milorad.yatprojects.network.models;

import com.google.gson.annotations.SerializedName;

public class NetworkProject {

	private String startDate;
	private String notifyeveryone;
	@SerializedName("show-announcement")
	private String showAnnouncement;
	private String endDate;
	private String replyByEmailEnabled;
	private Integrations integrations;
	private String id;
	private String isProjectAdmin;
	private Defaults defaults;
	@SerializedName("overview-start-page")
	private String overviewStartPage;
	private String description;
	private String name;
	private String announcementHTML;
	@SerializedName("last-changed-on")
	private String lastChangedOn;
	private Tags[] tags;
	private String logo;
	private String announcement;
	private String status;
	private String privacyEnabled;
	private Object boardData;
	private String defaultPrivacy;
	@SerializedName("tasks-start-page")
	private String tasksStartPage;
	@SerializedName("start-page")
	private String startPage;
	@SerializedName("created-on")
	private String createdOn;
	private Category category;
	private String filesAutoNewVersion;
	private String starred;
	private String subStatus;
	private Company company;
	@SerializedName("harvest-timers-enabled")
	private String harvestTimersEnabled;

	public String getStartDate() {
		return startDate;
	}

	public String getNotifyeveryone() {
		return notifyeveryone;
	}

	public String getShowAnnouncement() {
		return showAnnouncement;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getReplyByEmailEnabled() {
		return replyByEmailEnabled;
	}

	public Integrations getIntegrations() {
		return integrations;
	}

	public String getId() {
		return id;
	}

	public String isProjectAdmin() {
		return isProjectAdmin;
	}

	public Defaults getDefaults() {
		return defaults;
	}

	public String getOverviewStartPage() {
		return overviewStartPage;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public String getAnnouncementHTML() {
		return announcementHTML;
	}

	public String getLastChangedOn() {
		return lastChangedOn;
	}

	public Tags[] getTags() {
		return tags;
	}

	public String getLogo() {
		return logo;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public String getStatus() {
		return status;
	}

	public String getPrivacyEnabled() {
		return privacyEnabled;
	}

	public Object getBoardData() {
		return boardData;
	}

	public String getDefaultPrivacy() {
		return defaultPrivacy;
	}

	public String getTasksStartPage() {
		return tasksStartPage;
	}

	public String getStartPage() {
		return startPage;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public Category getCategory() {
		return category;
	}

	public String getFilesAutoNewVersion() {
		return filesAutoNewVersion;
	}

	public String getStarred() {
		return starred;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public Company getCompany() {
		return company;
	}

	public String getHarvestTimersEnabled() {
		return harvestTimersEnabled;
	}
}
