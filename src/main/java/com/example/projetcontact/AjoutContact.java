package com.example.projetcontact;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AjoutContact extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText nomc, prenomc, mailc, CPc, adressec, NTFc,NTPc;
    private Button addContactBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutcontact);
        // getting the bundle from the intent
        Bundle bundle = getIntent().getExtras();

        // initializing all our variables.
        nomc = findViewById(R.id.textuser);
        prenomc = findViewById(R.id.textprenom);
        mailc = findViewById(R.id.textmail);
        CPc = findViewById(R.id.textcp);
        adressec = findViewById(R.id.textadresse);
        NTFc = findViewById(R.id.textNTF);
        NTPc = findViewById(R.id.textNTP);
        addContactBtn = findViewById(R.id.button);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(AjoutContact.this);

        // below line is to add on click listener for our add course button.
        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String nom = nomc.getText().toString();
                String prenom = prenomc.getText().toString();
                String mail = mailc.getText().toString();
                String CP = CPc.getText().toString();
                String adresse = adressec.getText().toString();
                String NTF = NTFc.getText().toString();
                String NTP = NTPc.getText().toString();


                // validating if the text fields are empty or not.
                if (nom.isEmpty() && prenom.isEmpty() && mail.isEmpty() && CP.isEmpty() && adresse.isEmpty() && NTF.isEmpty() && NTP.isEmpty()) {
                    Toast.makeText(AjoutContact.this , "Merci de tout remplir...", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewContact(nom, prenom, mail, CP, adresse, NTF,NTP);
                // after adding the data we are displaying a toast message.
                Toast.makeText(AjoutContact.this, "Contact ajouté !", Toast.LENGTH_SHORT).show();
                nomc.setText("");
                prenomc.setText("");
                mailc.setText("");
                CPc.setText("");
                adressec.setText("");
                NTFc.setText("");
                NTPc.setText("");
            }
        });
    }
}

