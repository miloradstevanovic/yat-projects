package test.milorad.yatprojects.ui.screens.project.list;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.milorad.yatprojects.R;
import test.milorad.yatprojects.databinding.ItemProjectBinding;

/**
 * RecyclerView adapter for the project list.
 */
class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

	private List<ProjectViewModel> projects = new ArrayList<>(0);

	@Override
	public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ItemProjectBinding binding = DataBindingUtil.inflate(
				LayoutInflater.from(parent.getContext()), R.layout.item_project, parent, false);
		return new ProjectViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(ProjectViewHolder holder, int position) {
		holder.bind(projects.get(position));
	}

	@Override
	public int getItemCount() {
		return projects.size();
	}

	public void setProjects(@NonNull List<ProjectViewModel> projects) {
		//TODO Update to use a DiffUtil
		this.projects.clear();
		this.projects.addAll(projects);
		notifyDataSetChanged();
	}

	static class ProjectViewHolder extends RecyclerView.ViewHolder {

		private ItemProjectBinding binding;

		ProjectViewHolder(ItemProjectBinding viewDataBinding) {
			super(viewDataBinding.getRoot());
			binding = viewDataBinding;
		}

		void bind(ProjectViewModel projectViewModel) {
			binding.setViewModel(projectViewModel);
			binding.executePendingBindings();
		}
	}
}
