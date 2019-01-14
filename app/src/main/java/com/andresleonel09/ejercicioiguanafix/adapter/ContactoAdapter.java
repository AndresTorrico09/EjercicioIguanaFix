package com.andresleonel09.ejercicioiguanafix.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andresleonel09.ejercicioiguanafix.models.Contacto;
import com.andresleonel09.ejercicioiguanafix.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private ArrayList<Contacto> contactos;

    public ContactoAdapter(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);

        holder.tvNombreCV.setText(contacto.getFirstName() +" "+ contacto.getLastName());
        //Picasso.with(parent.getContext()).load(list.get(position).getImageURL()).into(holder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public  void addAllItems(List<Contacto> items) {
        contactos.addAll(items);
        notifyDataSetChanged();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombre);
        }
    }
}
