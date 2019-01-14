package com.andresleonel09.ejercicioiguanafix.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.andresleonel09.ejercicioiguanafix.adapter.ContactoAdapter;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;
import com.andresleonel09.ejercicioiguanafix.presenter.ContactosPresenter;
import com.andresleonel09.ejercicioiguanafix.presenter.IContactosPresenter;
import com.andresleonel09.ejercicioiguanafix.R;

import java.util.ArrayList;

public class ListContactosActivity extends AppCompatActivity implements IContactosView{

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IContactosPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);



        presenter = new ContactosPresenter(this, this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdapter mAdapter = new ContactoAdapter(contactos);
        return  mAdapter;
    }

    @Override
    public void inicializarAdaptador(ContactoAdapter mAdapter) {
        listaContactos.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
