package com.andresleonel09.ejercicioiguanafix.presenter;

import android.content.Context;

import com.andresleonel09.ejercicioiguanafix.Globals;
import com.andresleonel09.ejercicioiguanafix.activity.IContactosView;
import com.andresleonel09.ejercicioiguanafix.activity.ListContactosActivity;
import com.andresleonel09.ejercicioiguanafix.adapter.ContactoAdapter;
import com.andresleonel09.ejercicioiguanafix.api.ApiManager;
import com.andresleonel09.ejercicioiguanafix.api.IguanaFixApi;
import com.andresleonel09.ejercicioiguanafix.api.IguanaFixService;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public class ContactosPresenter implements IContactosPresenter{
    private IContactosView iContactosView;
    private Context context;
    private ArrayList<Contacto> contactos = new ArrayList<>();
    private ContactoAdapter mAdapter;

    public ContactosPresenter(IContactosView iContactosView, Context context) {
        this.iContactosView = iContactosView;
        this.context = context;
        mAdapter = iContactosView.crearAdaptador(contactos);
        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        IguanaFixService.getInstance().getContactos(mAdapter);
        mostrarContactos();
    }

    @Override
    public void mostrarContactos() {
        iContactosView.inicializarAdaptador(mAdapter);
        iContactosView.generarLayoutVertical();
    }
}
