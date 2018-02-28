package test.milorad.yatprojects.ui.screens.project.list;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.Single;
import test.milorad.yatprojects.ImmediateSchedulersTest;
import test.milorad.yatprojects.core.contracts.Navigator;
import test.milorad.yatprojects.core.models.Project;
import test.milorad.yatprojects.utils.ResourceProvider;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class ProjectListViewModelTest extends ImmediateSchedulersTest {

	@Mock
	private ProjectListModel model;
	@Mock
	private ResourceProvider resourceProvider;
	@Mock
	private ProjectListView view;
	@Mock
	private Navigator navigator;
	@Captor
	private ArgumentCaptor<List<ProjectViewModel>> projectViewModelsCaptor;

	private ProjectListViewModel viewModel;

	@Before
	public void setup() {
		viewModel = new ProjectListViewModel(model, resourceProvider);
	}

	@Test
	public void whenTheViewGetsCreatedTheViewModelShouldRequestTheProjectList() {
		//Dummy data
		List<Project> someProjects = getDummyProjects();

		//Successfully return some projects.
		Mockito.when(model.projects()).thenReturn(Single.just(someProjects));

		//Trigger view creation
		viewModel.onViewCreated(
				view,
				navigator
		);

		//Model triggered?
		Mockito.verify(model).projects();
	}

	@Test
	public void whenTheViewGetsCreatedTheViewModelShouldPassTheReceivedProjectListToTheViewMappedToViewModels() {
		//Dummy data
		List<Project> someProjects = getDummyProjects();

		//Successfully return some projects from the model.
		Mockito.when(model.projects()).thenReturn(Single.just(someProjects));

		//Trigger view creation
		viewModel.onViewCreated(
				view,
				navigator
		);

		//Capture arguments passed to the view.
		Mockito.verify(view).onProjectsReceived(projectViewModelsCaptor.capture());

		//Map the actual passed args to the projects they wrap.
		List<Project> actual = projectViewModelsCaptor.getValue().stream().map(ProjectViewModel::getProject).collect(Collectors.toList());

		//Are they the same as the dummy ones?
		assertEquals(someProjects, actual);
	}

	@Test
	public void whenTheProjectFetchingFailsTheViewOnErrorCallbackShouldBeTriggered() {
		//Error getting projects
		Error exception = new Error("Boom.");
		Mockito.when(model.projects()).thenReturn(Single.error(exception));

		//Message from resource provider
		String resProviderErrorTitle = "Whatever";
		Mockito.when(resourceProvider.getString(anyInt())).thenReturn(resProviderErrorTitle);

		//Trigger view creation
		viewModel.onViewCreated(
				view,
				navigator
		);

		//Error callback called on view?
		Mockito.verify(view).showError(resProviderErrorTitle, exception.getMessage());
	}

	private List<Project> getDummyProjects() {
		List<Project> projects = new ArrayList<>();
		projects.add(new Project("name", "tdf", "dsf"));
		projects.add(new Project("name1", "", "adsfg"));
		projects.add(new Project("name2", null, "adsfgh"));
		return projects;
	}

}