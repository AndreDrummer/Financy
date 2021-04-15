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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String selectedParcelsValue;
    Button calculateButton;
    EditText vehicleValueTextEdit;
    EditText enterValueTextEdit;
    EditText feeValueTextEdit;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vehicle Type
        Spinner selectParcelVehicle = (Spinner) findViewById(R.id.selectParcelSpinner);
        ArrayAdapter<CharSequence> parcelAdapter = ArrayAdapter.createFromResource(this, R.array.select_parcels_vehicle, android.R.layout.simple_spinner_item);

        parcelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectParcelVehicle.setAdapter(parcelAdapter);

        calculateButton = (Button) findViewById(R.id.calculateButton);
        vehicleValueTextEdit = (EditText) findViewById(R.id.vehicleValueTextEdit);
        enterValueTextEdit = (EditText) findViewById(R.id.enterValueTextEdit);
        feeValueTextEdit = (EditText) findViewById(R.id.feeValueTextEdit);
        output = (TextView) findViewById(R.id.totalValue);

//        calculateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.v("item", enterValueTextEdit.getText().toString());
//            }
//        });

        selectParcelVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                selectedParcelsValue = (String) ((String) parent.getItemAtPosition(position)).split("x")[0];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void calculate(View view) {
        Log.v("VehicleValue", vehicleValueTextEdit.getText().toString());
        Log.v("EnterValue", enterValueTextEdit.getText().toString());
        Log.v("FeeValue", feeValueTextEdit.getText().toString());
        Log.v("Parcels", selectedParcelsValue);

        output.setText("R$ 19.800,00");
    }
}