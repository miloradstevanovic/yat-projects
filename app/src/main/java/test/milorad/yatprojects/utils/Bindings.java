package test.milorad.yatprojects.utils;


import com.bumptech.glide.Glide;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;

import test.milorad.yatprojects.R;

/**
 * Bindings for custom xml attributes using data binding
 * See [Android data binding documentation](http://developer.android.com/tools/data-binding/guide.html)
 */
public class Bindings {

	private Bindings() {
	}

	/**
	 * Converts the binding from boolean to Visibility toggling between View.VISIBLE and View.GONE.
	 *
	 * @param visible If the view should be visible
	 * @return The view visibility ([View.VISIBLE] for true, and [View.GONE] for false)
	 */
	@BindingConversion
	public static int convertBooleanToVisibility(boolean visible) {
		return visible ? View.VISIBLE : View.GONE;
	}

	/**
	 * Sets the image fetched from the url into the imageView.
	 *
	 * @param imageView The imageView to load the image into
	 * @param url       The url to fetch the image from
	 */
	@BindingAdapter("url")
	public static void setImageUrl(final ImageView imageView, String url) {
		Glide.with(imageView.getContext()).load(url).placeholder(R.drawable.ic_launcher_foreground).into(imageView);
	}

	/**
	 * Sets a refresh action when the SwipeRefreshLayout is swiped down.
	 *
	 * @param swipeRefreshLayout The target SwipeRefreshLayout
	 * @param listener           The listener to be triggered when the SwipeRefreshLayout is refreshed
	 */
	@BindingAdapter("onRefresh")
	public static void setOnRefreshAction(SwipeRefreshLayout swipeRefreshLayout, SwipeRefreshLayout.OnRefreshListener listener) {
		swipeRefreshLayout.setOnRefreshListener(listener);
	}

	/**
	 * Shows the SwipeRefreshLayout loading thingy while in refreshing state.
	 *
	 * @param swipeRefreshLayout The target SwipeRefreshLayout
	 * @param refreshing         If the SwipeRefreshLayout should go into refreshing state
	 */
	@BindingAdapter("refreshing")
	public static void setRefreshing(SwipeRefreshLayout swipeRefreshLayout, boolean refreshing) {
		swipeRefreshLayout.setRefreshing(refreshing);
	}

}