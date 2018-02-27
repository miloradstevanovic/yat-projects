package test.milorad.yatprojects.network;


import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import test.milorad.yatprojects.network.models.ApiResponse;
import test.milorad.yatprojects.network.models.NetworkProject;

/**
 * Retrofit interface for the project api to be expanded as needed.
 */
public interface ProjectApi {

	@GET("/projects.json")
	Single<ApiResponse<List<NetworkProject>>> projects();
}
