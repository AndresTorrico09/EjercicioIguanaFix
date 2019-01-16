package com.andresleonel09.ejercicioiguanafix.activity;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andresleonel09.ejercicioiguanafix.R;
import com.andresleonel09.ejercicioiguanafix.api.IguanaFixService;
import com.andresleonel09.ejercicioiguanafix.models.Address;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class DetailContactActivity extends AppCompatActivity {

    public TextView tvNombre,tvPhoneHome,tvPhoneCellphone,tvPhoneOffice,tvBirthDate, tvAdressHome, tvAdressWork;
    public ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        imgFoto          = (ImageView) findViewById(R.id.imgFoto);
        tvNombre         = (TextView) findViewById(R.id.tvNombre);
        tvPhoneHome      = (TextView) findViewById(R.id.tvPhoneHome);
        tvPhoneCellphone = (TextView) findViewById(R.id.tvPhoneCellphone);
        tvPhoneOffice    = (TextView) findViewById(R.id.tvPhoneOffice);
        tvBirthDate      = (TextView) findViewById(R.id.tvBirthDate);
        tvAdressHome     = (TextView) findViewById(R.id.tvAdressHome);
        tvAdressWork     = (TextView) findViewById(R.id.tvAdressWork);

        Contacto contacto = getIntent().getParcelableExtra("contacto");
        IguanaFixService.getInstance().getContactoById(onUpdateViewCustomListener,Integer.valueOf(contacto.getUserId()));
    }

    //Interfaz que actualiza los valores del detalle
    private onUpdateViewCustomListener onUpdateViewCustomListener = new onUpdateViewCustomListener() {
        @Override
        public void onAddContact(Context context, Contacto contacto) {
            Picasso.with(context).load(contacto.getPhoto()).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(imgFoto);

            tvNombre.setText(contacto.getFirstName()+" "+contacto.getLastName());
            tvPhoneHome.setText(String.format(getResources().getString(R.string.phone_home),           contacto.getPhones().get(0).getNumber()==null? "-":contacto.getPhones().get(0).getNumber().toString()));
            tvPhoneCellphone.setText(String.format(getResources().getString(R.string.phone_cellphone), contacto.getPhones().get(1).getNumber()==null? "-":contacto.getPhones().get(1).getNumber().toString()));
            tvPhoneOffice.setText(String.format(getResources().getString(R.string.phone_office),       contacto.getPhones().get(2).getNumber()==null? "-":contacto.getPhones().get(2).getNumber().toString()));
            tvBirthDate.setText(String.format(getResources().getString(R.string.birth_date),           contacto.getBirthDate()));
            tvAdressHome.setText(String.format(getResources().getString(R.string.address_home),        contacto.getAddresses().get(0).getHome()==null? "-":contacto.getAddresses().get(0).getHome()));
            tvAdressWork.setText(String.format(getResources().getString(R.string.address_work),        contacto.getAddresses().get(0).getWork()==null? "-":contacto.getAddresses().get(0).getWork()));
        }
    };
}
