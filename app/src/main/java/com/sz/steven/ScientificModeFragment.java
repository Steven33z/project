package com.sz.steven;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class ScientificModeFragment extends Fragment {

    public ScientificModeFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scientific_mode, container, false);

        EditText inputX = view.findViewById(R.id.sciInputX);
        EditText inputY = view.findViewById(R.id.sciInputY);
        TextView result = view.findViewById(R.id.sciResult);

        Button sinBtn = view.findViewById(R.id.sciSin);
        Button cosBtn = view.findViewById(R.id.sciCos);
        Button tanBtn = view.findViewById(R.id.sciTan);
        Button sqrtBtn = view.findViewById(R.id.sciSqrt);
        Button pow2Btn = view.findViewById(R.id.sciPow2);
        Button powBtn = view.findViewById(R.id.sciPow);
        Button logBtn = view.findViewById(R.id.sciLog10);
        Button lnBtn = view.findViewById(R.id.sciLn);
        Button piBtn = view.findViewById(R.id.sciPi);
        Button eBtn = view.findViewById(R.id.sciE);

        View.OnClickListener opListener = v -> {
            String rawX = inputX.getText().toString().trim();
            if (rawX.isEmpty()) {
                result.setText("Result: (enter X)");
                return;
            }

            double x;
            try {
                x = Double.parseDouble(rawX);
            } catch (NumberFormatException e) {
                result.setText("Result: (invalid X)");
                return;
            }

            double out;
            int id = v.getId();

            try {
                if (id == R.id.sciSin) {
                    out = Math.sin(Math.toRadians(x));
                } else if (id == R.id.sciCos) {
                    out = Math.cos(Math.toRadians(x));
                } else if (id == R.id.sciTan) {
                    out = Math.tan(Math.toRadians(x));
                } else if (id == R.id.sciSqrt) {
                    if (x < 0) {
                        result.setText("Result: (sqrt needs X ≥ 0)");
                        return;
                    }
                    out = Math.sqrt(x);
                } else if (id == R.id.sciPow2) {
                    out = Math.pow(x, 2);
                } else if (id == R.id.sciPow) {
                    String rawY = inputY.getText().toString().trim();
                    if (rawY.isEmpty()) {
                        result.setText("Result: (enter Y for X^Y)");
                        return;
                    }
                    double y;
                    try {
                        y = Double.parseDouble(rawY);
                    } catch (NumberFormatException e) {
                        result.setText("Result: (invalid Y)");
                        return;
                    }
                    out = Math.pow(x, y);
                } else if (id == R.id.sciLog10) {
                    if (x <= 0) {
                        result.setText("Result: (log10 needs X > 0)");
                        return;
                    }
                    out = Math.log10(x);
                } else if (id == R.id.sciLn) {
                    if (x <= 0) {
                        result.setText("Result: (ln needs X > 0)");
                        return;
                    }
                    out = Math.log(x);
                } else {
                    return;
                }
            } catch (Exception ex) {
                result.setText("Result: (error)");
                return;
            }

            result.setText(String.format(Locale.US, "Result: %.6f", out));
        };

        sinBtn.setOnClickListener(opListener);
        cosBtn.setOnClickListener(opListener);
        tanBtn.setOnClickListener(opListener);
        sqrtBtn.setOnClickListener(opListener);
        pow2Btn.setOnClickListener(opListener);
        powBtn.setOnClickListener(opListener);
        logBtn.setOnClickListener(opListener);
        lnBtn.setOnClickListener(opListener);

        piBtn.setOnClickListener(v -> inputX.setText(String.valueOf(Math.PI)));
        eBtn.setOnClickListener(v -> inputX.setText(String.valueOf(Math.E)));

        return view;
    }
}