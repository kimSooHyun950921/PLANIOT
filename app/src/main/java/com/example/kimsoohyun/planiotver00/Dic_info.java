package com.example.kimsoohyun.planiotver00;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by tjdwp on 2017-08-08.
 */

public class Dic_info extends AppCompatActivity{
    EditText plantName;
    ImageView plantImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dic_info);
        plantName = (EditText)findViewById(R.id.pname);
        plantImage= (ImageView)findViewById(R.id.tulip);
    }
    public void addPlant(View v){
        /*db에 저장하고 저장한내용으로 바꿔주기*/
        String plantNameToString = plantName.getText().toString();

        Intent intent = new Intent(Dic_info.this,MainActivity.class);
        intent.putExtra("PLANTNAME",plantNameToString);
        intent.putExtra("PLANTIMAGE",R.drawable.tulip);
        startActivity(intent);
    }
}
