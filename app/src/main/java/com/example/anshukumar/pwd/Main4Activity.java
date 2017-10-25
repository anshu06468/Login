package com.example.anshukumar.pwd;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    database stud;
    EditText tx1, tx2, tx3, tx4;
    Button bn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        intent = getIntent();
        stud = new database(this);

        tx1 = (EditText)findViewById(R.id.editText2);
        tx2 = (EditText)findViewById(R.id.editText4);
        tx3 = (EditText)findViewById(R.id.editText6);
        tx4 = (EditText)findViewById(R.id.editText7);
        bn = (Button)findViewById(R.id.button);
        AddData();
    }
    public  void AddData() {
        bn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = stud.datainserted(tx1.getText().toString(),
                                tx2.getText().toString(),
                                tx3.getText().toString(),tx4.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(Main4Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main4Activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}


