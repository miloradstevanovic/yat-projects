package test.milorad.yatprojects.network;


import io.reactivex.Single;
import retrofit2.http.GET;
import test.milorad.yatprojects.network.models.Projects;

/**
 * Retrofit interface for the project api to be expanded as needed.
 */
public interface ProjectApi {

	@GET("/projects.json?status=ALL")
	Single<Projects> projects();
}
