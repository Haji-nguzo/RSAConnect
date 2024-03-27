package com.example.rsaconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ServiceProviderAdapter extends RecyclerView.Adapter<ServiceProviderAdapter.ViewHolder> {
    private ArrayList<ServiceProvider> serviceProviders = new ArrayList<>();
    private Context context;

    public ServiceProviderAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_provider_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(serviceProviders.get(position).getmName());
        holder.address.setText(serviceProviders.get(position).getAddress());
        Glide.with(context)
                .asBitmap()
                .load(serviceProviders.get(position).getImageUrl())
                .into(holder.imageUrl);
        //TODO card on click listener 26/11/23
    }

    @Override
    public int getItemCount() {
        return serviceProviders.size();
    }

    public void setServiceProviders(ArrayList<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName, address;
        private ImageView imageUrl;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            imageUrl = itemView.findViewById(R.id.image);
            address = itemView.findViewById(R.id.address);
            parent = itemView.findViewById(R.id.parent);
        }
    }

}
