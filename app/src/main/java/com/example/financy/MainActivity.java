package com.example.financy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vehicle Type
        Spinner selectTypeVehicle = (Spinner) findViewById(R.id.spinnerType);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.select_type_vehicle, android.R.layout.simple_spinner_item);

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectTypeVehicle.setAdapter(typeAdapter);

        // Vehicle Brand
        Spinner selectBrandVehicle = (Spinner) findViewById(R.id.spinnerBrand);
        ArrayAdapter<CharSequence> brandAdapter = ArrayAdapter.createFromResource(this, R.array.select_brand_vehicle, android.R.layout.simple_spinner_item);

        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectBrandVehicle.setAdapter(brandAdapter);

        // Vehicle Model
        Spinner selectModelVehicle = (Spinner) findViewById(R.id.spinnerModel);
        ArrayAdapter<CharSequence> modelAdapter = ArrayAdapter.createFromResource(this, R.array.select_model_vehicle, android.R.layout.simple_spinner_item);

        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectModelVehicle.setAdapter(modelAdapter);

        // Vehicle Year
        Spinner selectYearVehicle = (Spinner) findViewById(R.id.spinnerYear);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this, R.array.select_year_vehicle, android.R.layout.simple_spinner_item);

        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectYearVehicle.setAdapter(yearAdapter);

        // Vehicle Year
        Spinner selectParcels = (Spinner) findViewById(R.id.spinnerParcels);
        ArrayAdapter<CharSequence> parcelAdapter = ArrayAdapter.createFromResource(this, R.array.select_parcels_vehicle, android.R.layout.simple_spinner_item);

        parcelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectParcels.setAdapter(parcelAdapter);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        EditText enterValue = (EditText) findViewById(R.id.enterValue);

        // Handling data
        selectTypeVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        selectBrandVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        selectModelVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        selectYearVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        selectParcels.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("item", enterValue.getText().toString());
            }
        });
    }
}