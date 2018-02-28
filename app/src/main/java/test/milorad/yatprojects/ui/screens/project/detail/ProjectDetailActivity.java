package test.milorad.yatprojects.ui.screens.project.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import test.milorad.yatprojects.R;
import test.milorad.yatprojects.core.models.Project;
import test.milorad.yatprojects.databinding.ActivityProjectDetailBinding;

/**
 * Project detail page showing basic project data passed through the intent.
 */
public class ProjectDetailActivity extends AppCompatActivity {

	private static final String PROJECT = "PROJECT";

	/**
	 * Starts the activity with the project in intent extra.
	 *
	 * @param context The context to start the activity through.
	 * @param project The {@link Project} to show the details of.
	 */
	public static void start(Context context, Project project) {
		Intent starter = new Intent(context, ProjectDetailActivity.class);
		starter.putExtra(PROJECT, project);
		context.startActivity(starter);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityProjectDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_project_detail);

		binding.setViewModel(new ProjectDetailViewModel(getProjectExtra(getIntent())));
	}

	private Project getProjectExtra(Intent intent) {
		return intent != null ? intent.getParcelableExtra(PROJECT) : null;
	}
}
