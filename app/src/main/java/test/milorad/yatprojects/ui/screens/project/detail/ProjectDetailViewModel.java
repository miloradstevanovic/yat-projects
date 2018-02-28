package test.milorad.yatprojects.ui.screens.project.detail;

import test.milorad.yatprojects.core.models.Project;

/**
 * Simple view model to show the vehicle data passed locally.
 * At this point it's just a wrapper around {@link Project}.
 */
public class ProjectDetailViewModel {

	private final Project project;

	ProjectDetailViewModel(Project project) {
		this.project = project;
	}

	public String getName() {
		return project.getName();
	}

	public String getLogoUrl() {
		return project.getLogoUrl();
	}

	public String getDescription() {
		return project.getDescription();
	}

}
