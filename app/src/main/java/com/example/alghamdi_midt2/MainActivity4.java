package com.example.alghamdi_midt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Button go1 = findViewById(R.id.btn_go_2act1);
        Button go3 = findViewById(R.id.btn_go_2act3);

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, MainActivity2.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, MainActivity3.class));
            }
        });


        Button select_1 = findViewById(R.id.btn_read_first_row);
        Button del_1 = findViewById(R.id.btn_del_first_row);
        TextView out_row_1 = findViewById(R.id.out_first_row);

        dbHelper dbHelper = new dbHelper(this);

        select_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = dbHelper.getFirstRow();
                if (c == null) {
                    Toast.makeText(MainActivity4.this, "No data to read.", Toast.LENGTH_SHORT).show();
                    return;
                }
                out_row_1.setText(c.getInt(0) + " " +
                        c.getString(1) + " " +
                        c.getString(2) + " " +
                        c.getString(3) + " " +
                        c.getInt(4) + " ");

            }
        });
        del_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteFirstRow();
                Toast.makeText(MainActivity4.this, "Successfully deleted first row", Toast.LENGTH_SHORT).show();
            }
        });

    }
}