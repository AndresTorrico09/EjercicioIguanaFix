package com.andresleonel09.ejercicioiguanafix.api;

import com.andresleonel09.ejercicioiguanafix.models.Contacto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public interface IguanaFixApi {
    @GET("contacts")
    Call<List<Contacto>> getContactos();

}
