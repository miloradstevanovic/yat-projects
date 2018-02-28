package test.milorad.yatprojects.ui.screens.project.list;

import test.milorad.yatprojects.core.contracts.Navigator;
import test.milorad.yatprojects.core.models.Project;

public class ProjectViewModel {

	private final Project project;
	private final Navigator navigator;

	ProjectViewModel(Project project, Navigator navigator) {
		this.project = project;
		this.navigator = navigator;
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

	public void goToDetailScreen() {
		navigator.goToProjectDetail(project);
	}

	public Project getProject() {
		return project;
	}
}
