package com.sz.steven;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.fragment.app.Fragment;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import android.content.res.AssetFileDescriptor;

import com.nex3z.fingerpaintview.FingerPaintView;

public class FingerPaintViewFragment extends Fragment {
    protected FingerPaintView fpv;
    protected Paint p;
    private MappedByteBuffer mappedByteBuffer;
    private static final String MODEL_NAME = "digit.tflite";
    private static int WIDTH = 28;
    private static int HEIGHT = 28;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fingerpaint, container, false);

        fpv = view.findViewById(R.id.fpv);
        RadioButton red = view.findViewById(R.id.red);
        RadioButton blue = view.findViewById(R.id.blue);
        RadioButton green = view.findViewById(R.id.green);
        Button clear = view.findViewById(R.id.clearButton);
        Button predict = view.findViewById(R.id.predictButton);

        p = new Paint();
        fpv.setPen(p);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(36);
        p.setColor(Color.RED);

        // set color and set stroke based on radio button clicked
        // attributes for red button
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setColor(Color.RED);
                p.setStrokeWidth(36);
            }
        });

        // attributes for blue button
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setColor(Color.BLUE);
                p.setStrokeWidth(36);
            }
        });

        // attributes for green button
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setColor(Color.GREEN);
                p.setStrokeWidth(36);
            }
        });

        // clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fpv.clear();
            }
        });
        return view;
    }
}
