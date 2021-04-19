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
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView valor_final, valor_parcelas, total_juros;
    EditText vehicleValueTextEdit, enterValueTextEdit, feeValueTextEdit;
    Spinner selectParcelVehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor_final = findViewById(R.id.totalValue);
        valor_parcelas = findViewById(R.id.valor_parcelas);
        total_juros = findViewById(R.id.total_juros);
        vehicleValueTextEdit = findViewById(R.id.vehicleValueTextEdit);
        enterValueTextEdit = findViewById(R.id.enterValueTextEdit);
        feeValueTextEdit = findViewById(R.id.feeValueTextEdit);
        selectParcelVehicle = findViewById(R.id.selectParcelSpinner);
        ArrayAdapter<CharSequence> parcelAdapter = ArrayAdapter.createFromResource(this, R.array.select_parcels_vehicle, android.R.layout.simple_spinner_item);
        parcelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectParcelVehicle.setAdapter(parcelAdapter);
    }

    public void calcularFinanceiro(View v) {
        if (validateCampoValorCarro() && validateCampoValorEntrada() && validateCampoJuros()) {
            Financiamento financiamento = new Financiamento(Float.valueOf(vehicleValueTextEdit.getText().toString()),
                    Float.valueOf(enterValueTextEdit.getText().toString()),
                    Float.valueOf(feeValueTextEdit.getText().toString()),
                    Integer.valueOf(selectParcelVehicle.getSelectedItem().toString()));
            float vlr_prestacao = financiamento.calculaFinanciamento();
            DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
            valor_parcelas.setText("R$ " + df.format(vlr_prestacao));
            total_juros.setText("R$ " + df.format((vlr_prestacao * financiamento.getQtd_parcelas()) - financiamento.getValor_liquido()));
            valor_final.setText("R$ " + df.format(vlr_prestacao * financiamento.getQtd_parcelas()));
        }
    }

    private boolean validateCampoValorCarro() {
        String val = vehicleValueTextEdit.getText().toString().trim();

        if (val.isEmpty()) {
            vehicleValueTextEdit.setError("O valor do veículo não pode ficar vazio!");
            return false;
        } else {
            vehicleValueTextEdit.setError(null);
            return true;
        }
    }

    private boolean validateCampoValorEntrada() {
        String val = enterValueTextEdit.getText().toString().trim();

        if (val.isEmpty()) {
            enterValueTextEdit.setError("O valor da entrada não pode ficar vazio!");
            return false;
        }
        float valor_carro = Float.valueOf(vehicleValueTextEdit.getText().toString());
        float valor_entrada = Float.valueOf(enterValueTextEdit.getText().toString());

        if (valor_entrada >= valor_carro) {
            enterValueTextEdit.setError("O valor da entrada não pode ser maior ou igual ao do veículo!");
            return false;
        } else {
            enterValueTextEdit.setError(null);
            return true;
        }
    }

    private boolean validateCampoJuros() {
        String val = feeValueTextEdit.getText().toString().trim();

        if (val.isEmpty()) {
            feeValueTextEdit.setError("O valor do juros não pode ficar vazio!");
            return false;
        } else {
            feeValueTextEdit.setError(null);
            return true;
        }

    }

    public void calculate(View view) {
        Log.v("VehicleValue", vehicleValueTextEdit.getText().toString());
        Log.v("EnterValue", enterValueTextEdit.getText().toString());
        Log.v("FeeValue", feeValueTextEdit.getText().toString());
        Log.v("Parcels", selectedParcelsValue);

        output.setText("R$ 19.800,00");
    }
}