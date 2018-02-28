package test.milorad.yatprojects.core.models;


public final class Project {
	private final String name;
	private final String logoUrl;
	private final String description;

	public Project(String name, String logoUrl, String description) {
		this.name = name;
		this.logoUrl = logoUrl;
		this.description = description;
	}
}
