package test.milorad.yatprojects.ui.screens.project.list;

import java.util.List;

interface ProjectListView {

	/**
	 * A callback to signal that a list of projects has been received.
	 *
	 * @param projects The ProjectViewModel list to show in the collection.
	 */
	void onProjectsReceived(List<ProjectViewModel> projects);


	/**
	 * Shows an error to the user.
	 *
	 * @param title   The title of the error.
	 * @param message The message to show.
	 */
	void showError(String title, String message);
}
