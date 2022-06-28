package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.viewholder> {
    Context m;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public ContactAdapter(Context context) {
        m = context;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new viewholder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.itemView.setTag(ApplicationClass.contacts.get(position));
        holder.contact_name.setText(ApplicationClass.contacts.get(position).getName());
        holder.contact_number.setText(ApplicationClass.contacts.get(position).getNumber());
        holder.img.setImageResource(R.drawable.person);

    }

    @Override
    public int getItemCount() {
        return ApplicationClass.contacts.size();
    }


    public class viewholder extends RecyclerView.ViewHolder {
        TextView contact_name, contact_number;
        ImageView img;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            contact_name = itemView.findViewById(R.id.contact_name);
            contact_number = itemView.findViewById(R.id.contact_number);
            img = itemView.findViewById(R.id.img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
