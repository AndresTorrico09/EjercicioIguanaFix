package com.andresleonel09.ejercicioiguanafix;

import com.andresleonel09.ejercicioiguanafix.models.Contacto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres-PC on 2019-01-13.
 */


public class Globals{
    private static Globals instance;

    // Global variable
    private int data;
    private List<Contacto> contactos = new ArrayList<>();

    // Restrict the constructor from being instantiated
    private Globals(){}

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }
}