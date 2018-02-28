package test.milorad.yatprojects.core.contracts;

import java.util.List;

import io.reactivex.Single;
import test.milorad.yatprojects.core.models.Project;

/**
 * Remote service supplying Project information.
 */
public interface RemoteService {
	/**
	 * Gets the {@link Project} list for the given page.
	 *
	 * @return The list of of {@link Project}s.
	 */
	Single<List<Project>> getProjects();

	/**
	 * Error sent downstream by the RemoteService in case of failures.
	 */
	class ApiError extends Error {
		public ApiError(Throwable cause) {
			super(cause);
		}
	}
}
