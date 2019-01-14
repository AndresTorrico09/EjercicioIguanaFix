package com.andresleonel09.ejercicioiguanafix.presenter;

import android.content.Context;

import com.andresleonel09.ejercicioiguanafix.Globals;
import com.andresleonel09.ejercicioiguanafix.activity.IContactosView;
import com.andresleonel09.ejercicioiguanafix.api.IguanaFixService;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public class ContactosPresenter implements IContactosPresenter{
    private IContactosView iContactosView;
    private Context context;
    private ArrayList<Contacto> contactos;

    public ContactosPresenter(IContactosView iContactosView, Context context) {
        this.iContactosView = iContactosView;
        this.context = context;
        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        contactos = new ArrayList<>(Globals.getInstance().getContactos());
        mostrarContactos();
    }

    @Override
    public void mostrarContactos() {
        iContactosView.inicializarAdaptador(iContactosView.crearAdaptador(contactos));
        iContactosView.generarLayoutVertical();
    }
}
