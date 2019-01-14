package com.andresleonel09.ejercicioiguanafix.activity;

import com.andresleonel09.ejercicioiguanafix.adapter.ContactoAdapter;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;

import java.util.ArrayList;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public interface IContactosView {
    void generarLayoutVertical ();

    ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos);

    void inicializarAdaptador(ContactoAdapter adaptador);

}
