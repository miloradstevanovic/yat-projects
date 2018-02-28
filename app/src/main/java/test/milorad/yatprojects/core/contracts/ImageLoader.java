package test.milorad.yatprojects.core.contracts;

import android.widget.ImageView;

/**
 * Loads images into ImageViews.
 */
public interface ImageLoader {
	/**
	 * Loads the image the url points to, into the {@link ImageView}.
	 *
	 * @param url       The url of the image to be loaded
	 * @param imageView The ImageView into which the downloaded image will be loaded
	 */
	void load(String url, ImageView imageView);
}