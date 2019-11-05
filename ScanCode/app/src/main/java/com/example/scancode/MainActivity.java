package com.example.scancode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity {

    public static TextView txt_branch,txt_numTable;
    Button btn_scan,btn_create;
    ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObject=new JSONObject(result.getContents());
                    txt_branch.setText(jsonObject.getString("ChiNhanh"));
                    txt_numTable.setText(jsonObject.getString("SoBan"));
                }
                catch (Exception e)
                {
                    e.getMessage();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }*/

    private void addEvents() {
        //final IntentIntegrator intentIntegrator=new IntentIntegrator(this);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Display display =
                        ((WindowManager)getSystemService(Context.WINDOW_SERVICE))
                                .getDefaultDisplay();
                intentIntegrator.setPrompt("Scan a barcode");
                intentIntegrator.initiateScan();

                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
*/              Intent intent = new Intent(MainActivity.this,ScanCodeActivity.class);
                startActivity(intent);

            }
        });
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CodeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void addControls() {
        txt_branch=findViewById(R.id.txt_branch);
        txt_numTable=findViewById(R.id.txt_numTable);
        btn_scan=findViewById(R.id.btn_scan);
        btn_create=findViewById(R.id.btn_create);
    }
}
