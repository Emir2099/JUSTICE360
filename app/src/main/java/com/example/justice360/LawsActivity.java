package com.example.justice360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LawsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);

        CardView civillawsview = findViewById(R.id.cardCivilLaw);
        civillawsview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LawsActivity.this,CivilLawsActivity.class));
            }
        });

        CardView criminallawsview = findViewById(R.id.cardCriminalLaw);
        criminallawsview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LawsActivity.this,CriminalLawsActivity.class));
            }
        });

        CardView rtolawsview = findViewById(R.id.cardRtoLaw);
        rtolawsview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LawsActivity.this,RtoLawsActivity.class));
            }
        });

        CardView exit = findViewById(R.id.backButtonLaw);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LawsActivity.this,HomeActivity.class));
            }
        });

    }
}