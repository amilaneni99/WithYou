package com.example.mayank.withyou;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Contacts extends AppCompatActivity {
    String phoneNo1,phoneNo2,phoneNo3;
    EditText e1,e2,e3;

    Button b1;
    private SQLiteDatabase db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        final TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("Welcome ,"+getIntent().getExtras().getString("email"));

        b1 = (Button)findViewById(R.id.save);

        db1 = openOrCreateDatabase("rec", Context.MODE_PRIVATE,null);
        db1.execSQL("CREATE TABLE IF NOT EXISTS Reg2(su_email text,phone1 number,phone2 number,phone3 number);");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues row = new ContentValues();

                row.put("su_email",tv.getText().toString());
                row.put("phone1",e1.getText().toString());
                row.put("phone2",e2.getText().toString());
                row.put("phone3",e3.getText().toString());
                db1.insert("Reg2",null,row);


                Toast.makeText(getApplicationContext(),"Registration Success...",Toast.LENGTH_LONG).show();

                e1.setText("");
                e2.setText("");
                e3.setText("");


                //Toast.makeText(this,"Registration Success",Toast.LENGTH_LONG).show();
                db1.close();
                //Bundle e=new Bundle();
                String em=tv.getText().toString();
                String p1 = e1.getText().toString();
                //this is the class android uses to pass to new window
                //e.putString("v1",message); //name value pair
                //i.putExtras(e);
                Intent i = new Intent(Contacts.this,MainActivity.class);
                i.putExtra("email",em);
                i.putExtra("phone1", p1);
                startActivity(i);

                //Intent i = new Intent(SignUpActivity.this,SignInActivity.class);
                //startActivity(i);

            }
        });
    }
}
