package test.milorad.yatprojects.core.contracts;

import java.util.List;

import io.reactivex.Single;
import test.milorad.yatprojects.core.models.Project;

/**
 * Repository for getting Project information.
 */
public interface ProjectRepository {
	/**
	 * Gets all the Projects.
	 *
	 * @return The list of Project.
	 */
	Single<List<Project>> getProjects();
}
