package com.sz.steven;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.nex3z.fingerpaintview.FingerPaintView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

public class FPViewActivity extends AppCompatActivity {

    private final int IMG_WIDTH = 300;
    private final int IMG_HEIGHT = 300;
    private final String TAG = "PHC";
    final String FILE_NAME = "myfile.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpview);
        final String FILE_DIR = getFilesDir().getPath() + "/";

        //what is the internal storage directory
        //Log.v(TAG, Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.v(TAG, "FilesDir:"+FILE_DIR);

        //set up FingerPaintView
        FingerPaintView fpv = findViewById(R.id.fpv_paint);
        Button btn_save = findViewById(R.id.button_submit);
        Button btn_clear = findViewById(R.id.button_clear);
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(28);
        p.setColor(Color.BLUE);
        fpv.setPen(p);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = fpv.exportToBitmap(IMG_WIDTH, IMG_HEIGHT);
                Log.d(TAG, "is external storage writable:"+isExternalStorageWritable());
                externalStorage(bitmap);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fpv.clear();
            }
        });
    } //onCreate

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    // write to storage
    private void externalStorage(Bitmap bitmap) {
        Context context = this;
        File directory = context.getExternalFilesDir("MyApp");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        //what is the path?
        Log.d(TAG, "The directory is:"+directory.getPath());

        //time
        Calendar calendar = Calendar.getInstance();
        int seconds = calendar.get(Calendar.SECOND);

        File file = new File(directory, "fpvPaint.jpg");
        if (file.exists())
            file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            Log.v(TAG, e.getMessage());
        }
    }
} ///~