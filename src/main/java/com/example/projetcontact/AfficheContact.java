package com.example.projetcontact;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AfficheContact extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<ContactModal> contactModalArrayList;
    private DBHandler dbHandler;
    private ContactRVAdapter contactRVAdapter;
    private RecyclerView contactRV;
    ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichecontact);

        // getting the bundle from the intent
        Bundle bundle = getIntent().getExtras();

        // initializing our all variables.
        contactModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(AfficheContact.this);

        // getting our course array
        // list from db handler class.
        contactModalArrayList = dbHandler.readContacts();

        // on below line passing our array lost to our adapter class.
        contactRVAdapter = new ContactRVAdapter(contactModalArrayList, AfficheContact.this);
        contactRV = findViewById(R.id.affichecontactsy);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AfficheContact.this, RecyclerView.VERTICAL, false);
        contactRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        contactRV.setAdapter(contactRVAdapter);
    }
}

