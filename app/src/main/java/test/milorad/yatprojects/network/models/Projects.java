package test.milorad.yatprojects.network.models;

import java.util.List;

public class Projects {

	private Status STATUS;
	private List<NetworkProject> projects;

	/**
	 * Status of the request.
	 *
	 * @return The status emitted by the service or Status.ABSENT if null wa received.
	 */
	public Status getStatus() {
		return STATUS == null ? Status.ABSENT : STATUS;
	}

	public List<NetworkProject> getProjects() {
		return projects;
	}

	public enum Status {
		OK,
		ERROR,
		ABSENT;

		public boolean isSuccess() {
			return this == OK;
		}
	}
}
