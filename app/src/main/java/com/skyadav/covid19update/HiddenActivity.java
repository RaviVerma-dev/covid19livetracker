package com.skyadav.covid19update;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class HiddenActivity extends AppCompatActivity {

    private int positionCountry;
    TextView tveCountry,tveCases,tveRecovered,tveCritical,tveActive,tveTodayCases,tveTotalDeaths,tveTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Details of "+AffectedCountries.countryModelList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        tveCountry = findViewById(R.id.tveCountry);
        tveCases = findViewById(R.id.tveCases);
        tveRecovered = findViewById(R.id.tveRecovered);
        tveCritical = findViewById(R.id.tveCritical);
        tveActive = findViewById(R.id.tveActive);
        tveTodayCases = findViewById(R.id.tveTodayCases);
        tveTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tveTodayDeaths = findViewById(R.id.tveTodayDeaths);

        tveCountry.setText(AffectedCountries.countryModelList.get(positionCountry).getCountry());
        tveCases.setText(AffectedCountries.countryModelList.get(positionCountry).getCases());
        tveRecovered.setText(AffectedCountries.countryModelList.get(positionCountry).getRecovered());
        tveCritical.setText(AffectedCountries.countryModelList.get(positionCountry).getCritical());
        tveActive.setText(AffectedCountries.countryModelList.get(positionCountry).getActive());
        tveTodayCases.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayCases());
        String totalValue = (AffectedCountries.countryModelList.get(positionCountry).getDeaths());
        System.out.println("totoal death"+(AffectedCountries.countryModelList.get(positionCountry).getDeaths()));
        tveTotalDeaths.setText(totalValue);
        tveTodayDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayDeaths());


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
