package ug.co.absa.notify.utility;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {
    private static Retrofit retrofit = null;
    private static final Gson gson = new GsonBuilder().create();

    private static final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

    public static String BASE_API_URL ="http://localhost:9201/api/v1/";
    // public const String BASE_API_URL = "https://ugpbhkmapp0002.corp.dsarena.com:19020/api/v1/";



    // private static final OkHttpClient okHttpClient = okHttpClientBuilder.build();



    public static <T> T createService(Class<T> serviceClass){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                .client(okHttpClientBuilder.build())
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        }
        return retrofit.create(serviceClass);
    }

}
