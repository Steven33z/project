package com.sz.steven;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdditionFragment extends Fragment {
    public AdditionFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addition, container, false);

        EditText num1 = view.findViewById(R.id.num1);
        EditText num2 = view.findViewById(R.id.num2);
        Button calculation = view.findViewById(R.id.addButton);
        TextView result = view.findViewById(R.id.result);

        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(num1.getText().toString());
                double b = Double.parseDouble(num2.getText().toString());
                result.setText("Result: " + (a + b));
            }
        });
        return view;
    }
}
