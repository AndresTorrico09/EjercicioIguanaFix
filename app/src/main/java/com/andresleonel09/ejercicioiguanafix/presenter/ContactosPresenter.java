package com.andresleonel09.ejercicioiguanafix.presenter;

import android.content.Context;

import com.andresleonel09.ejercicioiguanafix.activity.IContactosView;
import com.andresleonel09.ejercicioiguanafix.adapter.ContactoAdapter;
import com.andresleonel09.ejercicioiguanafix.api.IguanaFixService;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;

import java.util.ArrayList;

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
