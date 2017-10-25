package com.example.anshukumar.pwd;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText password,id;
    Button login1;
    String str="incorrect password or username";
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        id=(EditText)findViewById(R.id.editText3);
        password=(EditText)findViewById(R.id.editText);
        login1=(Button)findViewById(R.id.button);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b) {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                if((id.getText().toString().equals("admin")) && (password.getText().toString().equals("ak123@"))){
                    startActivity(intent);
                }
                else {
                AlertDialog dialog=builder.create();
                    dialog.setTitle("Message");
                    dialog.show();
                }
            }
        });
    }
}
