package testandroid.mvp.utils.communication;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import testandroid.mvp.BuildConfig;

public class RestClient {
    private final MvpServices webServices;
    private static final String BASE_URL = BuildConfig.BASE_URL;
    private static final int MAX_TIME = 300;

    public RestClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                readTimeout(MAX_TIME, TimeUnit.SECONDS).
                connectTimeout(MAX_TIME, TimeUnit.SECONDS).
                addInterceptor(interceptor).
                build();

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                client(okHttpClient).
                build();

        webServices = retrofit.create(MvpServices.class);
    }


    public MvpServices getWebServices(){
        return webServices;
    }
}
