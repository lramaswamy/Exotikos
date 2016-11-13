package com.exotikosteam.exotikos.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.exotikosteam.exotikos.R;
import com.exotikosteam.exotikos.databinding.TravelPrepFragmentBinding;
import com.google.android.gms.maps.model.LatLng;

import butterknife.Unbinder;

/**
 * Created by lramaswamy on 11/12/16.
 */

public class TravelPrepFragment extends Fragment {

    Unbinder unbinder;
    OnButtonsClicks listener;
    TravelPrepFragmentBinding prepFragmentBinding;
    Button btnAirportPage;

    public interface OnButtonsClicks {
        void handleButtonsClicks(String buttonName, LatLng latLng);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        prepFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_travel_prep, container, false);
        setupBindings();
        setOnClickListener();

        return prepFragmentBinding.getRoot();
    }

    private void setupBindings() {
        //bind any view elements here to PrepFragmentBinding
        btnAirportPage = prepFragmentBinding.btnAirportPage;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnButtonsClicks) {
            listener = (OnButtonsClicks) context;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setOnClickListener() {
        prepFragmentBinding.btnLaunchScanPage.setOnClickListener(v -> {
            handleLaunchScanPage();
        });

        btnAirportPage.setOnClickListener(v -> {
            handleLaunchAirportMapPage();
        });
    }

    private void handleLaunchAirportMapPage() {
        listener.handleButtonsClicks("LaunchAirportPage", new LatLng(37.6213129,-122.3811494));
    }
    private void handleLaunchScanPage() {
        listener.handleButtonsClicks("LaunchScanPage", null);
    }

    public static TravelPrepFragment newInstance() {
        TravelPrepFragment frag = new TravelPrepFragment();
        Bundle args = new Bundle();
        //args.putParcelable("tripStatus", Parcels.wrap(trips));
        frag.setArguments(args);
        return frag;
    }


}
