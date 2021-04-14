package com.example.alghamdi_midt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper dbHelper=new dbHelper(this);
        setContentView(R.layout.activity_main3);

        Button go1=findViewById(R.id.btn_go_2act1);
        Button go3=findViewById(R.id.btn_go_2act3);

        Button select=findViewById(R.id.btn_select);

        EditText name=findViewById(R.id.inp_name);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbHelper.getResult(name.getText()+"");

                if (c==null){
                    Toast.makeText(MainActivity3.this,"There is no such record.",Toast.LENGTH_SHORT).show();
                    return;
                }
                String message= c.getInt(0)+" "+
                        c.getString(1)+" "+
                        c.getString(2)+" "+
                        c.getString(3)+" "+
                        c.getInt(4)+" ";

                Toast.makeText(MainActivity3.this,"Record found: "+message,Toast.LENGTH_LONG).show();



            }
        });



        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this,MainActivity2.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this,MainActivity4.class));
            }
        });


    }

}