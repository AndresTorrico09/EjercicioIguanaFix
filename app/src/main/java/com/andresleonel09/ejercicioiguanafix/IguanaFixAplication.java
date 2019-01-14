package com.andresleonel09.ejercicioiguanafix;

import android.app.Application;

import com.andresleonel09.ejercicioiguanafix.api.ApiManager;
import com.andresleonel09.ejercicioiguanafix.api.IguanaFixApi;
import com.andresleonel09.ejercicioiguanafix.api.IguanaFixService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public class IguanaFixAplication extends Application {

    public static final String BASE_URL = "https://private-d0cc1-iguanafixtest.apiary-mock.com/";

    private IguanaFixApi api;

    @Override
    public void onCreate() {
        super.onCreate();

        api = provideIguanaFixApi();
        ApiManager apiManager = new ApiManager(api);
        IguanaFixService.getInstance().init(this, apiManager);

        //Inicio el servicio de busqueda contactos
        IguanaFixService.getInstance().getContactos();
    }

    private IguanaFixApi provideIguanaFixApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IguanaFixApi.class);
    }
}
