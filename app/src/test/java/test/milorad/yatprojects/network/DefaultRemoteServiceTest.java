package test.milorad.yatprojects.network;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import test.milorad.yatprojects.ImmediateSchedulersTest;
import test.milorad.yatprojects.core.contracts.RemoteService;
import test.milorad.yatprojects.network.models.Projects;

@RunWith(MockitoJUnitRunner.class)
public class DefaultRemoteServiceTest extends ImmediateSchedulersTest {

	@Mock
	private ProjectApi projectApi;

	private DefaultRemoteService defaultRemoteService;

	@Before
	public void setup() {
		defaultRemoteService = new DefaultRemoteService(projectApi);
	}

	@Test
	public void whenTheApiReturnsUnexpectedNullsTheRemoteServiceShouldSendAnApiErrorDownstream() {
		//Something went totally wrong server side, an empty projects has been returned
		Projects projects = new Projects();
		Mockito.when(projectApi.projects()).thenReturn(Single.just(projects));

		//Has an api error been thrown for the lower layers to handle?
		defaultRemoteService.getProjects().test().assertError(error -> error instanceof RemoteService.ApiError);
	}
}