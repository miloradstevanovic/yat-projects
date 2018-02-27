package test.milorad.yatprojects.ui.screens.project.list;

import java.util.List;

import io.reactivex.Single;
import test.milorad.yatprojects.core.models.Project;
import test.milorad.yatprojects.core.repositories.RemoteProjectRepository;
import test.milorad.yatprojects.ui.ViewModel;

public class ProjectListModel extends ViewModel {

	private RemoteProjectRepository remoteProjectRepository;
	//TODO Add support for caching with a local RemoteProjectRepository database

	public ProjectListModel(RemoteProjectRepository remoteProjectRepository) {
		this.remoteProjectRepository = remoteProjectRepository;
	}

	/**
	 * Gets the project list to show.
	 *
	 * @return The project list Single.
	 */
	Single<List<Project>> projects() {
		return remoteProjectRepository.getProjects();
	}
}
