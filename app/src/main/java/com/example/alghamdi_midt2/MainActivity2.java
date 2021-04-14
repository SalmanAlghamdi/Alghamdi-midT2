package com.example.alghamdi_midt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHelper dbHelper=new dbHelper(this);
        Button go2=findViewById(R.id.go2);
        Button go3=findViewById(R.id.go3);
        Button insert=findViewById(R.id.insert);
        EditText numb=findViewById(R.id.editTextNumber);
        EditText name=findViewById(R.id.editTextTextPersonName);
        EditText email=findViewById(R.id.editTextTextEmailAddress);
        EditText phone=findViewById(R.id.editTextPhone);



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name= name.getText().toString();
                String Numb = numb.getText().toString();
                String Email = email.getText().toString();
                String Phone = phone.getText().toString();

                if(Name.isEmpty()||Numb.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please fill all boxes",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    if(!dbHelper.addData(Name,Numb)){
                        Toast.makeText(MainActivity2.this, "Insertion failed",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity2.this, "Insertion Successful",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });









        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity4.class));
            }
        });
    }
}