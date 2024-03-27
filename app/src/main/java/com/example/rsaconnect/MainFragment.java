package com.example.rsaconnect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class MainFragment extends Fragment {
    private Context mContext;

    private BottomNavigationView bottomNavigationView;
    private ImageView imageView;
    private RecyclerView providerRecView;
    private CardView serviceCardView, rsaCardView;
    private RelativeLayout relativeLayout;
    private ServiceProviderAdapter serviceProviderAdapter;
    private MainAdapter mainAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container,false);
        initView(view);
        initBottomNavView();
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView(View view){
        bottomNavigationView = view.findViewById(R.id.bottomNavMenu);
        providerRecView = view.findViewById(R.id.newProviderRecView);
        imageView = view.findViewById(R.id.imageBanner);
        serviceCardView = view.findViewById(R.id.carCard);
        rsaCardView = view.findViewById(R.id.rsaCard);
        relativeLayout = view.findViewById(R.id.relativeLayout);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),VehicleServices.class);
                startActivity(i);
            }
        });

        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("serviceProviders"), MainModel.class)
                        .build();

        mainAdapter = new MainAdapter(options);
        providerRecView.setAdapter(mainAdapter);
        providerRecView.setLayoutManager(new LinearLayoutManager(getActivity(), providerRecView.VERTICAL,false));


    }


    /* private void initRecView(){
       serviceProviderAdapter = new ServiceProviderAdapter(getActivity());
        providerRecView.setAdapter(serviceProviderAdapter);
        providerRecView.setLayoutManager(new LinearLayoutManager(getActivity(), providerRecView.VERTICAL,false));

        ArrayList<ServiceProvider> newProvider = Utils.getAllProviders(getActivity());
        if (newProvider != null) {
            serviceProviderAdapter.setServiceProviders(newProvider);
        }

        //Firebase


    }*/


    private void initBottomNavView(){

    }

    @Override
    public void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}
