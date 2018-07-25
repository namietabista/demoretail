package com.example.namita.demoretail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    Button QuickOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        QuickOrder = (Button) (findViewById(R.id.quick));

        QuickOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                //Toast.makeText(HomePage.this, "Hello", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(HomePage.this, login.class);
                startActivity(intent);

            }
        });
    }
}