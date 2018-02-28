package test.milorad.yatprojects.core.models;


import android.os.Parcel;
import android.os.Parcelable;

public final class Project implements Parcelable {

	private final String name;
	private final String logoUrl;
	private final String description;

	public Project(String name, String logoUrl, String description) {
		this.name = name;
		this.logoUrl = logoUrl;
		this.description = description;
	}

	protected Project(Parcel in) {
		name = in.readString();
		logoUrl = in.readString();
		description = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(logoUrl);
		dest.writeString(description);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Project> CREATOR = new Creator<Project>() {
		@Override
		public Project createFromParcel(Parcel in) {
			return new Project(in);
		}

		@Override
		public Project[] newArray(int size) {
			return new Project[size];
		}
	};

	public String getName() {
		return name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public String getDescription() {
		return description;
	}
}
