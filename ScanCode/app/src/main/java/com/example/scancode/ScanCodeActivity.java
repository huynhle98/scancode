package com.example.scancode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.Result;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);
        scannerView=new ZXingScannerView(this);
        setContentView(scannerView);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {

        String txt=result.getText();
        MainActivity.txt_branch.setText(txt);
        /*
        try {
            JSONObject jsonObject=new JSONObject(txt);
            MainActivity.txt_branch.setText(jsonObject.getString("ChiNhanh"));
            MainActivity.txt_numTable.setText(jsonObject.getString("SoBan"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
*/
        onBackPressed();
    }
}
