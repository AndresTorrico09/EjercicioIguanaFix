package com.andresleonel09.ejercicioiguanafix.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andresleonel09.ejercicioiguanafix.api.IguanaFixService;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;
import com.andresleonel09.ejercicioiguanafix.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.andresleonel09.ejercicioiguanafix.R.id.parent;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> implements Filterable {

    private ArrayList<Contacto> contactos;
    private ContactFilter contactFilter;
    private Context context;

    public ContactoAdapter(ArrayList<Contacto> contactos, Context context) {
        this.contactos = contactos;
        this.context = context;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);

        holder.tvNombreCV.setText(contacto.getFirstName() + " " + contacto.getLastName());
        Picasso.with(context).load(contactos.get(position).getThumb()).into(holder.imgThumb);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IguanaFixService.getInstance().getContactoById(Integer.valueOf(contacto.getUserId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public void addAllItems(List<Contacto> items) {
        contactos.clear();
        contactos.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        if (contactFilter == null) {
            contactFilter = new ContactFilter();
        }

        return contactFilter;
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombreCV;
        private ImageView imgThumb;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgThumb = itemView.findViewById(R.id.imgThumb);
            tvNombreCV = itemView.findViewById(R.id.tvNombre);
        }
    }

    private class ContactFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<Contacto> tempList = new ArrayList<>();

                // search content in friend list
                for (Contacto contact : contactos) {
                    if (contact.getFirstName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(contact);
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = contactos.size();
                filterResults.values = contactos;
            }

            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            addAllItems((ArrayList<Contacto>) filterResults.values);
        }
    }
}