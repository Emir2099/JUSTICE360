package com.example.justice360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindLawyersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_lawyers);

        CardView exit = findViewById(R.id.backButtonFindLawyer);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindLawyersActivity.this,HomeActivity.class));
            }
        });


        CardView familylitigator = findViewById(R.id.cardLitigatorFinder);
        familylitigator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindLawyersActivity.this,LawyersDetailsActivity.class);
                it.putExtra("title","Litigators");
                startActivity(it);
            }
        });

        CardView familycriminaldefenselawyer = findViewById(R.id.cardCriminalLawyerFinder);
        familycriminaldefenselawyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindLawyersActivity.this,LawyersDetailsActivity.class);
                it.putExtra("title","Criminal Defense Lawyers");
                startActivity(it);
            }
        });

        CardView familylawyerfam = findViewById(R.id.cardFamilyLayerFinder);
        familylawyerfam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindLawyersActivity.this,LawyersDetailsActivity.class);
                it.putExtra("title","Family Lawyers");
                startActivity(it);
            }
        });
    }
}