package com.andresleonel09.ejercicioiguanafix.activity;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.andresleonel09.ejercicioiguanafix.adapter.ContactoAdapter;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;
import com.andresleonel09.ejercicioiguanafix.presenter.ContactosPresenter;
import com.andresleonel09.ejercicioiguanafix.presenter.IContactosPresenter;
import com.andresleonel09.ejercicioiguanafix.R;

import java.util.ArrayList;

public class ListContactosActivity extends AppCompatActivity implements IContactosView,android.support.v7.widget.SearchView.OnQueryTextListener{

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IContactosPresenter presenter;
    private ContactoAdapter mAdapter;

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

    /*    MenuItem searchViewMenuItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) searchViewMenuItem.getActionView();
*/
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mAdapter.getFilter().filter(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //Reseteo la lista de contactos al cerrar el search
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchView.setQuery("", false);
                searchView.clearFocus();
                presenter.obtenerContactos();

                return false;
            }
        });

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
        mAdapter = new ContactoAdapter(contactos, this);
        return  mAdapter;
    }

    @Override
    public void inicializarAdaptador(ContactoAdapter mAdapter) {
        listaContactos.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
