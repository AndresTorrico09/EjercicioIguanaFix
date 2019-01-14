package com.andresleonel09.ejercicioiguanafix.api;

import android.content.Context;

import com.andresleonel09.ejercicioiguanafix.Globals;
import com.andresleonel09.ejercicioiguanafix.activity.ListContactosActivity;
import com.andresleonel09.ejercicioiguanafix.adapter.ContactoAdapter;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public class IguanaFixService {

    static IguanaFixService instance;
    private Context context;
    private ApiManager apiManager;

    public void init(Context context, ApiManager apiManager){
        this.context = context;
        this.apiManager = apiManager;
    }

    public static IguanaFixService getInstance() {
        if(instance == null)
            instance = new IguanaFixService();
        return instance;
    }

    public void getContactos(final ContactoAdapter contactoAdapter) {
        apiManager.getContactos().
                enqueue(new Callback<List<Contacto>>() {
                    @Override
                    public void onResponse(Call<List<Contacto>> call, Response<List<Contacto>> response) {
                        if (response.isSuccessful()) {
                            //Actualizo la informacion del adapter una vez que llega el response
                            contactoAdapter.addAllItems(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Contacto>> call, Throwable t) {
                        Throwable x = t;
                    }
                });
    }

    public void getContactoById(Integer id) {
        apiManager.getContactoById(id).
                enqueue(new Callback<Contacto>() {
                    @Override
                    public void onResponse(Call<Contacto> call, Response<Contacto> response) {
                        if (response.isSuccessful()) {

                        }
                    }

                    @Override
                    public void onFailure(Call<Contacto> call, Throwable t) {
                        Throwable x = t;
                    }
                });
    }
}