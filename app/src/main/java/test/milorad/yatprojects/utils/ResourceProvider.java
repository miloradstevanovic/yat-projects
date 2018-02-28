package test.milorad.yatprojects.utils;

import android.content.Context;

/**
 * A wrapper around the android way of getting localized resources.
 */
public class ResourceProvider {

	ResourceProvider(Context context) {
		this.context = context;
	}

	private Context context;

	public String getString(int resId) {
		return context.getString(resId);
	}
}