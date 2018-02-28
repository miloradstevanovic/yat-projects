package test.milorad.yatprojects.ui;


import com.bumptech.glide.Glide;

import android.widget.ImageView;

import test.milorad.yatprojects.core.contracts.ImageLoader;

/**
 * AN ImageLoader implementation relying on glide <3
 */
public enum GlideImageLoader implements ImageLoader {
	INSTANCE;

	@Override
	public void load(String url, ImageView imageView) {
		Glide.with(imageView.getContext()).load(url).into(imageView);
	}
}
