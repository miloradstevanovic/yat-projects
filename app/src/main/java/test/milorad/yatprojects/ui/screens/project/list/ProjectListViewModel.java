package test.milorad.yatprojects.ui.screens.project.list;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import test.milorad.yatprojects.R;
import test.milorad.yatprojects.core.contracts.Navigator;
import test.milorad.yatprojects.core.models.Project;
import test.milorad.yatprojects.ui.ViewModel;
import test.milorad.yatprojects.utils.ResourceProvider;
import test.milorad.yatprojects.utils.RxUtils;

public class ProjectListViewModel extends ViewModel {

	//Dependencies
	private ProjectListModel model;
	private ProjectListView view;
	private ResourceProvider resourceProvider;
	private Navigator navigator;

	//Subscriptions to clean up on view destruction
	private CompositeDisposable compositeDisposable = new CompositeDisposable();


	ProjectListViewModel(ProjectListModel model, ResourceProvider resourceProvider) {
		this.model = model;
		this.resourceProvider = resourceProvider;
	}

	/**
	 * Callback to signal that the view is getting created, context holding dependencies get passed here.
	 *
	 * @param projectListView The view of this view model.
	 * @param navigator       The navigator of the app.
	 */
	void onViewCreated(ProjectListView projectListView, Navigator navigator) {
		this.view = projectListView;
		this.navigator = navigator;

		initialize();
	}

	/**
	 * Callback to signal that the view is getting destroyed.
	 */
	void onViewDestroyed() {
		view = null;
		navigator = null;
		compositeDisposable.dispose();
	}

	private void initialize() {
		Disposable disposable = model.projects()
				.compose(RxUtils.applySchedulersSingle())
				.compose(RxUtils.showLoadingUntilTerminationSingle(this))
				.subscribe(
						projects -> view.onProjectsReceived(mapProjectsToViewModels(projects)),
						error -> view.showError(
								resourceProvider.getString(R.string.error_title),
								error.getMessage()
						)
				);

		compositeDisposable.add(disposable);
	}

	private List<ProjectViewModel> mapProjectsToViewModels(List<Project> projects) {
		List<ProjectViewModel> vms = new ArrayList<>(projects.size());
		for (Project project : projects) {
			vms.add(new ProjectViewModel(project, navigator));
		}
		return vms;
	}

	public void refresh() {
		//Clear running requests if any
		compositeDisposable.dispose();

		//and re-trigger the fetching
		initialize();
	}
}
