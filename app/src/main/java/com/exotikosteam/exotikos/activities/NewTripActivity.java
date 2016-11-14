package com.exotikosteam.exotikos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.exotikosteam.exotikos.R;
import com.exotikosteam.exotikos.fragments.AirlinePickDialogFragment;
import com.exotikosteam.exotikos.models.airline.Airline;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewTripActivity extends AppCompatActivity {

    private Airline mSelectedAirline;

    @BindView(R.id.btnSelectAirline) Button btnSelectAirline;
    @BindView(R.id.btnSelectFlights) Button btnSelectFlights;
    @BindView(R.id.etFlightNumber) EditText etFlightNumber;
    @BindView(R.id.dpDepartureDate) DatePicker dpDepartureDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);
        ButterKnife.bind(this);

        setupListeners();

        // only dates starting tomorrow
        dpDepartureDate.setMinDate(System.currentTimeMillis() - 1000);

        // TODO ticket scan
    }

    private void setupListeners() {
        btnSelectAirline.setOnClickListener(view -> {
            FragmentManager fm = getSupportFragmentManager();
            AirlinePickDialogFragment pickAirlineDialogFragment = AirlinePickDialogFragment.newInstance();
            pickAirlineDialogFragment.getSelectSubject()
                    .subscribe(airline -> {
                        mSelectedAirline = airline;
                        btnSelectAirline.setText(airline.getName());
                        pickAirlineDialogFragment.dismiss();
                    });
            pickAirlineDialogFragment.show(fm, "fragment_dialog_pick_airline");
        });

        btnSelectFlights.setOnClickListener(view -> {
            // TODO where to go?
            Intent i = new Intent(NewTripActivity.this, FlightResultsActivity.class);
            i.putExtra("airline", Parcels.wrap(mSelectedAirline));
            i.putExtra("year", dpDepartureDate.getYear());
            i.putExtra("month", dpDepartureDate.getMonth() + 1);
            i.putExtra("day", dpDepartureDate.getDayOfMonth());
            i.putExtra("flightNumber", etFlightNumber.getText().toString());
            startActivity(i);
        });
    }
}
