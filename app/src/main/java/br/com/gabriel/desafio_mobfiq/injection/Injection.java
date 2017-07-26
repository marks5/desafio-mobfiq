package br.com.gabriel.desafio_mobfiq.injection;

import br.com.gabriel.desafio_mobfiq.data.MobfiqRepository;
import br.com.gabriel.desafio_mobfiq.data.MobfiqRepositoryImp;
import br.com.gabriel.desafio_mobfiq.data.remote.MobfiqRestService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class Injection {
    private static final String BASE_URL = "https://desafio.mobfiq.com.br/";
    private static OkHttpClient okHttpClient;
    private static MobfiqRestService mobfiqRestService;
    private static Retrofit retrofitInstance;

    public static MobfiqRepository provideListFruits() {
        return new MobfiqRepositoryImp(provideFruitsRepo());
    }

    static MobfiqRestService provideFruitsRepo() {
        if (mobfiqRestService == null) {
            mobfiqRestService = getRetrofitInstance().create(MobfiqRestService.class);
        }
        return mobfiqRestService;
    }

    static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        }

        return okHttpClient;
    }

    static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            Retrofit.Builder retrofit = new Retrofit.Builder().client(Injection.getOkHttpClient()).baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
            retrofitInstance = retrofit.build();

        }
        return retrofitInstance;
    }
}
