package com.example.projetcontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    Button btnajt;
    Button btnaffich;
    Button btnpos;
    Button btnnum;
    Button btnphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        // getting the bundle from the intent
        Bundle bundle = getIntent().getExtras();

        // setting the text in the textview
        //  txtString.setText(bundle.getString("key1", "No value from the MainActivity"));
        btnajt = findViewById(R.id.ajtcontact);
        btnaffich = findViewById(R.id.affichcontact);
        btnpos = findViewById(R.id.poscontact);
        btnnum = findViewById(R.id.numcontact);
        btnphoto = findViewById(R.id.photocontact);
        // one button will pass the bundle and other button
        // will not pass the bundle
        btnajt.setOnClickListener(this);
        btnaffich.setOnClickListener(this);
        btnpos.setOnClickListener(this);
        btnnum.setOnClickListener(this);
        btnphoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.poscontact:
                Bundle bundlepos = new Bundle();
                Intent ipos = new Intent(Menu.this, MapsActivity.class);
                ipos.putExtras(bundlepos);
                startActivity(ipos);
                break;
            case R.id.ajtcontact:
                Bundle bundlecont = new Bundle();
                Intent i = new Intent(Menu.this, AjoutContact.class);
                i.putExtras(bundlecont);
                startActivity(i);
                break;
            case R.id.affichcontact:
                Bundle bundleaf = new Bundle();
                Intent i2 = new Intent(Menu.this, AfficheContact.class);
                i2.putExtras(bundleaf);
                startActivity(i2);
                break;
            case R.id.numcontact:
                Bundle bundlenum = new Bundle();
                Intent intentnum = new Intent(Menu.this, ComposContact.class);
                intentnum.putExtras(bundlenum);
                startActivity(intentnum);
                break;
            case R.id.photocontact:
                Bundle bundlephoto = new Bundle();
                Intent intentphoto = new Intent(Menu.this, PhotoContact.class);
                intentphoto.putExtras(bundlephoto);
                startActivity(intentphoto);
                break;

        }

    }
}
