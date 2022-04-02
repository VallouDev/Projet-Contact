package com.example.projetcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRVAdapter extends RecyclerView.Adapter<ContactRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<ContactModal> contactModalArrayList;
    private Context context;

    // constructor
    public ContactRVAdapter(ArrayList<ContactModal> contactModalArrayList, Context context) {
        this.contactModalArrayList = contactModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.affichecontact, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        ContactModal modal = contactModalArrayList.get(position);
        holder.contactName.setText(modal.getPrenom());
        holder.contactNomFamille.setText(modal.getNom());
        holder.contactCP.setText(modal.getCP());
        holder.contactAdresse.setText(modal.getAdresse());
        holder.contactMail.setText(modal.getMail());
        holder.contactNTF.setText(modal.getNTF());
        holder.contactNTP.setText(modal.getNTP());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return contactModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView contactName, contactNomFamille, contactCP, contactAdresse, contactMail, contactNTF, contactNTP;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            contactName = itemView.findViewById(R.id.idTVprenom);
            contactNomFamille = itemView.findViewById(R.id.idTVnom);
            contactCP = itemView.findViewById(R.id.idTVCP);
            contactAdresse = itemView.findViewById(R.id.idTVAdresse);
            contactMail = itemView.findViewById(R.id.idTVmail);
            contactNTF = itemView.findViewById(R.id.idTVNTF);
            contactNTP = itemView.findViewById(R.id.idTVNTP);
        }
    }
}

