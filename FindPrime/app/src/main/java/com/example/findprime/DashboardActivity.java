package com.example.findprime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    private CardView cardPrime;
    private CardView cardPalindrome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize the cards from the layout
        cardPrime = findViewById(R.id.cardPrime);
        cardPalindrome = findViewById(R.id.cardPalindrome);

        // Set a click listener for the Prime Number Finder card
        cardPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start PrimeActivity
                Intent intent = new Intent(DashboardActivity.this, PrimeActivity.class);
                startActivity(intent);
            }
        });

        // Set a click listener for the Palindrome Checker card
        cardPalindrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start PalindromeActivity
                Intent intent = new Intent(DashboardActivity.this, PalindromeActivity.class);
                startActivity(intent);
            }
        });
    }
}
