package com.andresleonel09.ejercicioiguanafix.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.andresleonel09.ejercicioiguanafix.R;
import com.andresleonel09.ejercicioiguanafix.api.IguanaFixService;
import com.andresleonel09.ejercicioiguanafix.models.Contacto;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class DetailContactActivity extends AppCompatActivity {

    public TextView tvNombre,tvPhoneHome,tvPhoneCellphone,tvPhoneOffice,tvBirthDate;
    public ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);


        if(getActionBar() != null){
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Contacto contacto = getIntent().getParcelableExtra("contacto");
        IguanaFixService.getInstance().getContactoById(Integer.valueOf(contacto.getUserId()));

        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvPhoneHome = (TextView) findViewById(R.id.tvPhoneHome);
        tvPhoneCellphone = (TextView) findViewById(R.id.tvPhoneCellphone);
        tvPhoneOffice = (TextView) findViewById(R.id.tvPhoneOffice);
        tvBirthDate = (TextView) findViewById(R.id.tvBirthDate);

        Picasso.with(this).load(contacto.getPhoto()).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(imgFoto);
        tvNombre.setText(contacto.getFirstName()+" "+contacto.getLastName());
        tvPhoneHome.setText(String.format(getResources().getString(R.string.phone_home),      contacto.getPhones().get(0).getNumber()==null? "-":contacto.getPhones().get(0).getNumber().toString()));
        tvPhoneCellphone.setText(String.format(getResources().getString(R.string.phone_cellphone), contacto.getPhones().get(1).getNumber()==null? "-":contacto.getPhones().get(1).getNumber().toString()));
        tvPhoneOffice.setText(String.format(getResources().getString(R.string.phone_office),    contacto.getPhones().get(2).getNumber()==null? "-":contacto.getPhones().get(2).getNumber().toString()));
        tvBirthDate.setText(String.format(getResources().getString(R.string.birth_date), contacto.getBirthDate()));
    }
}
