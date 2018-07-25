package com.example.namita.demoretail;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {
    EditText name, phone, email, password;
    Button create;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(validate()){
                   //Uploads data to the database

                   String emailval = email.getText().toString().trim();
                   String passwordval = password.getText().toString().trim();

                   firebaseAuth.createUserWithEmailAndPassword(emailval, passwordval).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              Toast.makeText(registration.this, "Account Registered", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(registration.this, login.class));
                          }
                          else{
                              String a = task.getException().getMessage().toString();
                              Toast.makeText(registration.this, a , Toast.LENGTH_SHORT).show();
                          }
                       }
                   });

               }
            }
        });


    }

    private void setupUIViews() {
        name = (EditText)(findViewById(R.id.uname));
        phone = (EditText) (findViewById(R.id.number));
        email = (EditText) (findViewById(R.id.mail));
        password = (EditText)(findViewById(R.id.ppd));
        create = (Button) (findViewById(R.id.createa));
    }

    private Boolean validate(){
        Boolean result = false;

        String nameval= name.getText().toString();
        String passwordval = password.getText().toString();
        String emailval = email.getText().toString();
        String phoneval = phone.getText().toString();

        if (nameval.isEmpty() || passwordval.isEmpty() || emailval.isEmpty()|| phoneval.isEmpty()){
            Toast.makeText(this, "Please enter all the details in the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }
        return result;
    }
}
