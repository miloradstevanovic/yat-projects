package test.milorad.yatprojects.network;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import test.milorad.yatprojects.core.contracts.RemoteService;
import test.milorad.yatprojects.core.models.Project;
import test.milorad.yatprojects.network.models.NetworkProject;

/**
 * Default remote service implementation.
 */
public class DefaultRemoteService implements RemoteService {

	private ProjectApi projectApi;

	public DefaultRemoteService(ProjectApi projectApi) {
		this.projectApi = projectApi;
	}

	@Override
	public Single<List<Project>> getProjects() {
		return projectApi.projects().map(listApiResponse -> {

			//If the Status is not ok throw
			if (!listApiResponse.getStatus().isSuccess()) {
				throw new ApiError(new Exception("Request failed."));
			}

			//If the data is null something went terribly wrong.
			if (listApiResponse.getProjects() == null) {
				throw new ApiError(new Exception("Null projects received."));
			}
			return mapToProjects(listApiResponse.getProjects());
		});
		//TODO Map all network errors to an ApiError equivalent
		//TODO Add remote logging
	}

	private List<Project> mapToProjects(List<NetworkProject> data) {
		List<Project> projects = new ArrayList<>(data.size());
		for (NetworkProject networkProject : data) {
			projects.add(new Project(networkProject.getName(), networkProject.getLogo(), networkProject.getDescription()));
		}
		return projects;
	}
}
