package com.andresleonel09.ejercicioiguanafix.api;

import com.andresleonel09.ejercicioiguanafix.models.Contacto;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public class ApiManager {
    private final IguanaFixApi api;

    public ApiManager(IguanaFixApi api) {
        this.api = api;
    }

    public Call<List<Contacto>> getContactos(){
        return api.getContactos();
    }
}
