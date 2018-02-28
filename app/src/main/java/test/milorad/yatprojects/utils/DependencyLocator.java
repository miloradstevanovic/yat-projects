package test.milorad.yatprojects.utils;

import android.app.Application;
import android.content.Context;

import test.milorad.yatprojects.core.contracts.ImageLoader;
import test.milorad.yatprojects.core.contracts.RemoteService;
import test.milorad.yatprojects.core.repositories.RemoteProjectRepository;
import test.milorad.yatprojects.network.DefaultRemoteService;
import test.milorad.yatprojects.network.RestClient;
import test.milorad.yatprojects.ui.GlideImageLoader;
import test.milorad.yatprojects.ui.screens.project.list.ProjectListModel;

/**
 * A place to get dependencies from, to be replaced by a DI solution.
 */
public class DependencyLocator {

	private DependencyLocator() {

	}

	public static ProjectListModel getProjectListModel() {
		return new ProjectListModel(getRemoteRepository());
	}

	private static RemoteProjectRepository getRemoteRepository() {
		return new RemoteProjectRepository(getRemoteService());
	}

	private static RemoteService getRemoteService() {
		return new DefaultRemoteService(RestClient.INSTANCE.getProjectApi());
	}

	public static ResourceProvider getResourceProvider(Context applicationContext) {
		if (!(applicationContext instanceof Application)) {
			throw new Error("Supply the application context for the resource provider construction.");
		}
		return new ResourceProvider(applicationContext);
	}

	static ImageLoader getImageLoader() {
		return GlideImageLoader.INSTANCE;
	}
}
