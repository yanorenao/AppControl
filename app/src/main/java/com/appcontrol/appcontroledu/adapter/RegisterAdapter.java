package com.appcontrol.appcontroledu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.Contact;

import java.util.List;

public class RegisterAdapter extends RecyclerView.Adapter<RegisterAdapter.ViewHolder> {

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public RegisterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_register, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(RegisterAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Contact contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView nameTextView = holder.nameTextView;
        TextView tipoUsurarioTextView = holder.tipoUsurarioTextView;
        TextView tipoUsurarioSalon = holder.tipoUsurarioSalon;

        nameTextView.setText(contact.getName());
        tipoUsurarioTextView.setText(contact.getTipoUsurario());
        tipoUsurarioSalon.setText(contact.getTipoUSalon());
        Button button = holder.aceptarButton;
        Button button2 = holder.rechazarButton;

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView tipoUsurarioTextView;
        public TextView tipoUsurarioSalon;
        public Button aceptarButton;
        public Button rechazarButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.name);
            tipoUsurarioTextView = (TextView) itemView.findViewById(R.id.tipoUsurarioTextView);
            tipoUsurarioSalon = (TextView) itemView.findViewById(R.id.tipoUsurarioSalon);
            aceptarButton = (Button) itemView.findViewById(R.id.button_aceptar);
            rechazarButton = (Button) itemView.findViewById(R.id.button_rechazar);
        }
    }

    // Store a member variable for the contacts
    private List<Contact> mContacts;

    // Pass in the contact array into the constructor
    public RegisterAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }
}