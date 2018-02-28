package test.milorad.yatprojects.ui.screens.project.list;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.List;

import test.milorad.yatprojects.R;
import test.milorad.yatprojects.core.contracts.Navigator;
import test.milorad.yatprojects.core.models.Project;
import test.milorad.yatprojects.databinding.ActivityProjectListBinding;
import test.milorad.yatprojects.utils.DependencyLocator;

public class ProjectListActivity extends AppCompatActivity implements ProjectListView, Navigator {

	private ProjectListViewModel viewModel;
	private ActivityProjectListBinding binding;
	private ProjectAdapter projectAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project_list);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_project_list);

		viewModel = new ProjectListViewModel(DependencyLocator.getProjectListModel(), DependencyLocator.getResourceProvider(getApplicationContext()));
		binding.setViewModel(viewModel);

		setupRecyclerView();
	}

	private void setupRecyclerView() {
		projectAdapter = new ProjectAdapter();
		binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
		binding.recyclerView.setAdapter(projectAdapter);
	}

	@Override
	protected void onStart() {
		super.onStart();
		viewModel.onViewCreated(this, this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		viewModel.onViewDestroyed();
	}

	@Override
	public void onProjectsReceived(List<ProjectViewModel> projects) {
		projectAdapter.setProjects(projects);
	}

	@Override
	public void showError(final String title, final String message) {
		//TODO Reimplement with a fragment dialog and a retry button
		Toast.makeText(this, title + ": " + message, Toast.LENGTH_LONG).show();
	}

	@Override
	public void goToProjectDetail(@NonNull Project project) {

	}
}
