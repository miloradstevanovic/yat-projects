package test.milorad.yatprojects.ui.screens.project.list;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import test.milorad.yatprojects.core.contracts.Navigator;
import test.milorad.yatprojects.core.models.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectViewModelTest {
	@Mock
	private Navigator navigator;

	private Project dummyProject = new Project("name2", null, "adsfgh");

	private ProjectViewModel viewModel;

	@Before
	public void setup() {
		viewModel = new ProjectViewModel(dummyProject, navigator);
	}

	@Test
	public void whenTheProjectIsSelectedItShouldNavigateToTheProjectDetail() {
		//Trigger selection.
		viewModel.goToDetailScreen();

		//Has the goToDetail been triggered with the proper project?
		Mockito.verify(navigator).goToProjectDetail(dummyProject);
	}
}