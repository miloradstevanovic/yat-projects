package test.milorad.yatprojects.network;


import com.google.gson.GsonBuilder;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A wrapper for retrofit Api initialization.
 */
public enum RestClient {

	INSTANCE;

	private static final String BASE_URL = "https://yat.teamwork.com";
	private static final String CLIENT_ID = "...";

	//OkHttpClient with the interceptor that adds the necessary headers
	private OkHttpClient client =
			new OkHttpClient.Builder()
					.addInterceptor(chain -> {

						Request original = chain.request();

						Request.Builder requestBuilder = original.newBuilder()
								.header("Accept", "application/json")
								.header(CLIENT_ID, "XXX")
								.method(original.method(), original.body());

						return chain.proceed(requestBuilder.build());

					}).build();

	private final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
			.client(client)
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.build();

	private final ProjectApi projectApi = retrofit.create(ProjectApi.class);

	public ProjectApi getProjectApi() {
		return projectApi;
	}
}
