package com.example.mayank.withyou;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    CheckBox c1;
    Button b1;
    private SQLiteDatabase db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        e1 = (EditText)findViewById(R.id.name);
        e2 = (EditText)findViewById(R.id.email_signup);
        e3 = (EditText)findViewById(R.id.pass_signup);
        e4 = (EditText)findViewById(R.id.phone);
        c1 = (CheckBox)findViewById(R.id.checkBox);
        b1 = (Button)findViewById(R.id.signup2);

        db1 = openOrCreateDatabase("rec", Context.MODE_PRIVATE,null);
        db1.execSQL("CREATE TABLE IF NOT EXISTS Reg1(su_name text,su_email text,su_pass text,su_phone text);");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues row = new ContentValues();
                row.put("su_name",e1.getText().toString());
                row.put("su_email",e2.getText().toString());
                row.put("su_pass",e3.getText().toString());
                row.put("su_phone",e4.getText().toString());
                db1.insert("Reg1",null,row);


                Toast.makeText(getApplicationContext(),"Registration Success...",Toast.LENGTH_LONG).show();

                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");

                //Toast.makeText(this,"Registration Success",Toast.LENGTH_LONG).show();
                db1.close();
                //Bundle e=new Bundle();

                //this is the class android uses to pass to new window
                //e.putString("v1",message); //name value pair
                //i.putExtras(e);
                Intent i = new Intent(SignUp.this,SignIn.class);
                startActivity(i);

                //Intent i = new Intent(SignUpActivity.this,SignInActivity.class);
                //startActivity(i);

            }
        });
    }
}
