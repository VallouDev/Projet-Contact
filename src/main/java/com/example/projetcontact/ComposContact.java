package com.example.projetcontact;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComposContact extends AppCompatActivity {

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
        dbHandler = new DBHandler(ComposContact.this);

        // getting our course array
        // list from db handler class.
        contactModalArrayList = dbHandler.readContacts();

        // on below line passing our array lost to our adapter class.
        contactRVAdapter = new ContactRVAdapter(contactModalArrayList, ComposContact.this);
        contactRV = findViewById(R.id.affichecontactsy);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ComposContact.this, RecyclerView.VERTICAL, false);
        contactRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        contactRV.setAdapter(contactRVAdapter);
    }
}
