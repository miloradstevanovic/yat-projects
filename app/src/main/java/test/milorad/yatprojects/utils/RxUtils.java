package test.milorad.yatprojects.utils;

import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import test.milorad.yatprojects.ui.ViewModel;

/**
 * RxJava utility function collection
 */
public class RxUtils {

	private RxUtils() {
	}

	/**
	 * Applies the default Schedulers for android.
	 * subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
	 *
	 * @return The SingleTransformer to pass to compose() in the chain.
	 */
	public static <T> SingleTransformer<T, T> applySchedulersSingle() {
		return upstream -> upstream.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread());
	}

	/**
	 * Toggles the loading property of the view model until completion.
	 *
	 * @param viewModel The ViewModel to toggle the loading of.
	 * @return The SingleTransformer to pass to compose() in the chain.
	 */
	public static <T> SingleTransformer<T, T> showLoadingUntilTerminationSingle(ViewModel viewModel) {
		return upstream -> upstream
				.doOnSubscribe(p -> viewModel.setLoading(true))
				.doOnSuccess(p -> viewModel.setLoading(false))
				.doOnError(p -> viewModel.setLoading(false))
				.doOnDispose(() -> {
					viewModel.setLoading(false);
				});
	}
}
