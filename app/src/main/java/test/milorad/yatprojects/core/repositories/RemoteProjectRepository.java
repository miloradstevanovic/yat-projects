package test.milorad.yatprojects.core.repositories;

import java.util.List;

import io.reactivex.Single;
import test.milorad.yatprojects.core.contracts.ProjectRepository;
import test.milorad.yatprojects.core.contracts.RemoteService;
import test.milorad.yatprojects.core.models.Project;

/**
 * Fetches Project information from the {@link RemoteService}.
 */
public class RemoteProjectRepository implements ProjectRepository {

	private RemoteService remoteService;

	public RemoteProjectRepository(RemoteService remoteService) {
		this.remoteService = remoteService;
	}

	@Override
	public Single<List<Project>> getProjects() {
		return remoteService.getProjects();
	}
}
