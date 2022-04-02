package com.example.projetcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnconn;
    Button btninscr;
    private ArrayList<ContactModal> LoginModalArrayList;
    EditText login;
    EditText passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_main);
        btnconn = findViewById(R.id.button);
        btninscr = findViewById(R.id.inscr);
        passwd = findViewById(R.id.textmdp);
        login = findViewById(R.id.textuser);
        btnconn.setOnClickListener(this);
        btninscr.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                try {
                String value = null;
                FileInputStream inputStream=openFileInput("connexion.txt");
                StringBuilder stringb= new StringBuilder();
                int content;
                while ((content=inputStream.read())!=-1){
                    value = String.valueOf(stringb.append((char)content)); }
                /*
                if (passwd.getText().toString() != value){
                        Toast.makeText(this, "Le mot de passe est incorrect", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (login.getText().toString() != value){
                    Toast.makeText(this, "Le login est incorrect", Toast.LENGTH_SHORT).show();
                    break;
                }

                 */
                Bundle bundle = new Bundle();
                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.putExtras(bundle);
                startActivity(intent);
                } catch (Exception e) {
                    throw new Error(e);
                }
                break;
            case R.id.inscr:
                Bundle bundleinscr = new Bundle();
                Intent intentinscr = new Intent(MainActivity.this, Inscription.class);
                intentinscr.putExtras(bundleinscr);
                startActivity(intentinscr);
        }
    }

    public void Ouvrir() {

    }
}