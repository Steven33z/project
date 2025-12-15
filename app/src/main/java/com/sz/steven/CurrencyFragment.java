package com.sz.steven;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrencyFragment extends Fragment {
    public CurrencyFragment() {}

    // exchange rates
    private static final double USD_TO_CAD = 1.38;
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_JPY = 155.75;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency, container, false);

        EditText usdInput = view.findViewById(R.id.usd);
        Button convertButton = view.findViewById(R.id.conversionButton);
        TextView result = view.findViewById(R.id.result);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double usd = Double.parseDouble(usdInput.getText().toString());

                double usdToCAD = usd * USD_TO_CAD;
                double usdToEUR = usd * USD_TO_EUR;
                double usdToJPY = usd * USD_TO_JPY;

                result.setText(""); // clear first
                result.append("Canadian Dollar: " + usdToCAD + "\n");
                result.append("Euro: " + usdToEUR + "\n");
                result.append("Japanese Yen: " + usdToJPY);
            }
        });

        return view;
    }
}

