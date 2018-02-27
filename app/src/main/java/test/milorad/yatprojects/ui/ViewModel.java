package test.milorad.yatprojects.ui;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import test.milorad.yatprojects.BR;

/**
 * Base view model, extends the BaseObservable to enable data binding.
 */
public class ViewModel extends BaseObservable {

	/**
	 * Property to be toggled when lasting operations are running,
	 * should mostly be bound to a progress bar. compose() an observable with
	 * showLoadingUntilTermination() in RxUtils.java for 0 effort handling
	 */
	private boolean loading = false;

	@Bindable
	public boolean isLoading() {
		return loading;
	}

	public void setLoading(boolean loading) {
		this.loading = loading;
		notifyPropertyChanged(BR.loading);
	}

}
