package com.example.mathildawatson.back2android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnTest = null;
    private EditText phoneNumber = null;

    public String getPhoneNumber(){
       return phoneNumber.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTest = (Button) findViewById(R.id.btn_tel);
        phoneNumber = (EditText) findViewById(R.id.et_tel);
        btnTest.setOnClickListener(new MyListener());
    }

    private class MyListener implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            callPhone();
        }
    }


    private void callPhone(){
        if(!TextUtils.isEmpty(getPhoneNumber())) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.CALL");
            intent.setData(Uri.parse("tel:" + getPhoneNumber()));
            //startActivity(intent);
            Toast.makeText(MainActivity.this, "the number " + getPhoneNumber() , Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Please input the number", Toast.LENGTH_SHORT).show();
        }
    }


}
