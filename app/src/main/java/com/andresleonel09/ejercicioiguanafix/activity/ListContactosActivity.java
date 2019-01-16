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
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.andresleonel09.ejercicioiguanafix.adapter.ContactoAdapter;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;
import com.andresleonel09.ejercicioiguanafix.presenter.ContactosPresenter;
import com.andresleonel09.ejercicioiguanafix.presenter.IContactosPresenter;
import com.andresleonel09.ejercicioiguanafix.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;

public class ListContactosActivity extends AppCompatActivity implements IContactosView,android.support.v7.widget.SearchView.OnQueryTextListener {

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IContactosPresenter presenter;
    private ContactoAdapter mAdapter;
    //Map<String, Integer> mapIndex;
    //ListView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContactos = (RecyclerView) findViewById(R.id.rvContactos);
        presenter = new ContactosPresenter(this, this);

/*
        VerticalRecyclerViewFastScroller fastScroller = (VerticalRecyclerViewFastScroller) findViewById(R.id.fast_scroller);
        // Connect the recycler to the scroller (to let the scroller scroll the list)
        fastScroller.setRecyclerView(rvContactos);
        // Connect the scroller to the recycler (to let the recycler scroll the scroller's handle)
        rvContactos.setOnScrollListener(fastScroller.getOnScrollListener());
*/

/*        String[] contacts = getResources().getStringArray(R.array.contacts_array);
        Arrays.asList(contacts);
        contactList = (ListView) findViewById(R.id.list_contacts);
        contactList.setFastScrollEnabled(true);
        contactList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, contacts));

        getIndexList(contacts);
        displayIndex();*/

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
        rvContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos) {
        mAdapter = new ContactoAdapter(contactos, this);
        return  mAdapter;
    }

    @Override
    public void inicializarAdaptador(ContactoAdapter mAdapter) {
        rvContactos.setAdapter(mAdapter);
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

/*    private void getIndexList(String[] contacts) {
        mapIndex = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < contacts.length; i++) {
            String contact = contacts[i];
            String index = contact.substring(0, 1);

            if (mapIndex.get(index) == null)
                mapIndex.put(index, i);
        }
    }

    private void displayIndex() {
        LinearLayout indexLayout = (LinearLayout) findViewById(R.id.side_index);

        TextView textView;
        List<String> indexList = new ArrayList<>(mapIndex.keySet());
        for (String index : indexList) {
            textView = (TextView) getLayoutInflater().inflate(
                    R.layout.side_index_item, null);
            textView.setText(index);
            textView.setOnClickListener(this);
            indexLayout.addView(textView);
        }
    }

    public void onClick(View view) {
        TextView selectedIndex = (TextView) view;
        contactList.setSelection(mapIndex.get(selectedIndex.getText()));
    }*/
}
