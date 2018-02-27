package test.milorad.yatprojects.network.models;

import java.util.List;

public class ProjectsApiResponse {

	private Status STATUS;
	private List<NetworkProject> projects;

	public Status getStatus() {
		return STATUS;
	}

	public List<NetworkProject> getProjects() {
		return projects;
	}

	public enum Status {
		OK,
		ERROR;

		public boolean isSuccess() {
			return this == OK;
		}
	}
}
