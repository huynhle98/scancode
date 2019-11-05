package com.example.scancode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONException;
import org.json.JSONObject;

public class CodeActivity extends AppCompatActivity {

    ImageView img_BarCode, img_close;
    String txt_BarCode;
    JSONObject code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        addControls();
        addEvents();
    }

    private void addEvents() {
        code=new JSONObject();
        try {
            code.put("ChiNhanh","102 Tân Hòa");
            code.put("SoBan",01);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        txt_BarCode=code.toString();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(txt_BarCode, BarcodeFormat.QR_CODE, 350, 350);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            img_BarCode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void addControls() {
        img_BarCode = findViewById(R.id.img_barcode);
        img_close = findViewById(R.id.img_close);
    }
}
