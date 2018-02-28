package test.milorad.yatprojects.network.models;

import com.google.gson.annotations.SerializedName;

public class Company {

	private String id;
	private String name;

	@SerializedName("is-owner")
	private String isOwner;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIsOwner() {
		return isOwner;
	}
}
