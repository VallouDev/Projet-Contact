package com.example.projetcontact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    private Button btnregister;
    private EditText username, mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cree_compte);
        btnregister = findViewById(R.id.button);
        username = findViewById(R.id.textuser);
        mdp = findViewById(R.id.textmdp);
        username.setOnClickListener(this);
        mdp.setOnClickListener(this);
        btnregister.setOnClickListener(this);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                try{
                    String FILENAME = "connexion.txt";
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(username.getText().toString().getBytes(StandardCharsets.UTF_8));
                    fos.write(mdp.getText().toString().getBytes(StandardCharsets.UTF_8));
                    fos.close();
                    Toast.makeText(this, "Inscription terminée", Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } catch (IOException iox) {
                    //do stuff with exception
                    iox.printStackTrace();
                }
                break;
            }
        }
    }