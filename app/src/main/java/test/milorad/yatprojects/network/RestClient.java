package test.milorad.yatprojects.network;


import com.google.gson.GsonBuilder;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A wrapper for retrofit Api initialization.
 */
public enum RestClient {

	INSTANCE;

	private static final String BASE_URL = "https://yat.teamwork.com";

	//Hardcoded for this use case
	private static final String BASIC_AUTH_HEADER = "Basic dHdwX1RFYkJYR0NudmwySGZ2WFdma0xVbHp4OTJlM1Q6WA==";

	//OkHttpClient with the interceptor that adds the necessary headers
	private OkHttpClient client =
			new OkHttpClient.Builder()
					.addInterceptor(chain -> {

						Request original = chain.request();

						Request.Builder requestBuilder = original.newBuilder()
								.header("Accept", "application/json")
								.header("Authorization", BASIC_AUTH_HEADER)
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
