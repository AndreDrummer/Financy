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
        Spinner selectParcelVehicle = (Spinner) findViewById(R.id.selectParcelSpinner);
        ArrayAdapter<CharSequence> parcelAdapter = ArrayAdapter.createFromResource(this, R.array.select_parcels_vehicle, android.R.layout.simple_spinner_item);

        parcelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectParcelVehicle.setAdapter(parcelAdapter);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        EditText vehicleValueTextEdit = (EditText) findViewById(R.id.vehicleValueTextEdit);
        EditText enterValueTextEdit = (EditText) findViewById(R.id.enterValueTextEdit);
        EditText feeValueTextEdit = (EditText) findViewById(R.id.feeValueTextEdit);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("item", vehicleValueTextEdit.getText().toString());
            }
        });
    }
}