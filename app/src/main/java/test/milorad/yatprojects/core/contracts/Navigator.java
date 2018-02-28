package test.milorad.yatprojects.core.contracts;

import android.support.annotation.NonNull;

import test.milorad.yatprojects.core.models.Project;

/**
 * Navigates around the app.
 */
public interface Navigator {
	/**
	 * Redirects the user to the Project detail page.
	 *
	 * @param project The {@link Project} whose details to show on the page.
	 */
	void goToProjectDetail(@NonNull Project project);
}