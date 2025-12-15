package com.sz.steven;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class TemperatureConversionFragment extends Fragment {

    public TemperatureConversionFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature_conversion, container, false);

        EditText input = view.findViewById(R.id.tempInput);
        Spinner fromSpinner = view.findViewById(R.id.tempFromSpinner);
        Spinner toSpinner = view.findViewById(R.id.tempToSpinner);
        Button convertBtn = view.findViewById(R.id.tempConvertBtn);
        TextView result = view.findViewById(R.id.tempResult);

        String[] units = new String[]{"Celsius (°C)", "Fahrenheit (°F)", "Kelvin (K)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                units
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);
        fromSpinner.setSelection(0);
        toSpinner.setSelection(1);

        convertBtn.setOnClickListener(v -> {
            String raw = input.getText().toString().trim();
            if (raw.isEmpty()) {
                result.setText("Result: (enter a value)");
                return;
            }

            double value;
            try {
                value = Double.parseDouble(raw);
            } catch (NumberFormatException e) {
                result.setText("Result: (invalid number)");
                return;
            }

            int from = fromSpinner.getSelectedItemPosition();
            int to = toSpinner.getSelectedItemPosition();

            double out = convertTemperature(value, from, to);
            String outStr = String.format(Locale.US, "Result: %.4f", out);
            result.setText(outStr);
        });

        return view;
    }

    /**
     * from/to: 0 = Celsius, 1 = Fahrenheit, 2 = Kelvin
     */
    private double convertTemperature(double v, int from, int to) {
        if (from == to) return v;

        // First convert to Celsius
        double c;
        switch (from) {
            case 1: // F -> C
                c = (v - 32.0) * (5.0 / 9.0);
                break;
            case 2: // K -> C
                c = v - 273.15;
                break;
            case 0: // C
            default:
                c = v;
                break;
        }

        // Then convert Celsius to target
        switch (to) {
            case 1: // C -> F
                return (c * (9.0 / 5.0)) + 32.0;
            case 2: // C -> K
                return c + 273.15;
            case 0: // C
            default:
                return c;
        }
    }
}
