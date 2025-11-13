package com.example.findprime;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PalindromeActivity extends AppCompatActivity {

    private EditText editTextPalindrome;
    private Button buttonCheckPalindrome;
    private TextView textViewPalindromeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle("Palindrome Checker");
        }

        editTextPalindrome = findViewById(R.id.editTextPalindrome);
        buttonCheckPalindrome = findViewById(R.id.buttonCheckPalindrome);
        textViewPalindromeResult = findViewById(R.id.textViewPalindromeResult);

        buttonCheckPalindrome.setOnClickListener(v -> checkPalindromeClicked());
    }

    private void checkPalindromeClicked() {
        String input = editTextPalindrome.getText().toString().trim();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter some text or numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        // Remove spaces and convert to lower case for a robust check
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();

        // Reverse the string
        String reversedInput = new StringBuilder(cleanInput).reverse().toString();

        if (cleanInput.equals(reversedInput)) {
            textViewPalindromeResult.setText("'" + input + "' is a palindrome!");
        } else {
            textViewPalindromeResult.setText("'" + input + "' is not a palindrome.");
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

