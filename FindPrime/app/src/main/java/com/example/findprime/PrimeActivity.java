package com.example.findprime;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class PrimeActivity extends AppCompatActivity {

    private EditText editTextStartRange, editTextEndRange;
    private Button buttonFindPrimes;
    private TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);

        // To add a back button in the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle("Prime Number Finder");
        }

        editTextStartRange = findViewById(R.id.editTextStartRange);
        editTextEndRange = findViewById(R.id.editTextEndRange);
        buttonFindPrimes = findViewById(R.id.buttonFindPrimes);
        textViewResults = findViewById(R.id.textViewResults);

        buttonFindPrimes.setOnClickListener(v -> findPrimesClicked());
    }

    private void findPrimesClicked() {
        String startStr = editTextStartRange.getText().toString();
        String endStr = editTextEndRange.getText().toString();

        if (startStr.isEmpty() || endStr.isEmpty()) {
            Toast.makeText(this, "Please enter both range values", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int start = Integer.parseInt(startStr);
            int end = Integer.parseInt(endStr);

            if (start > end) {
                Toast.makeText(this, "Start of range must be less than or equal to the end", Toast.LENGTH_SHORT).show();
                return;
            }

            findAndDisplayPrimes(start, end);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private void findAndDisplayPrimes(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        if (primes.isEmpty()) {
            textViewResults.setText("No prime numbers found in this range.");
        } else {
            StringBuilder resultText = new StringBuilder();
            for (int i = 0; i < primes.size(); i++) {
                resultText.append(primes.get(i));
                if (i < primes.size() - 1) {
                    resultText.append(", ");
                }
            }
            textViewResults.setText(resultText.toString());
        }
    }

    // Handle the back button click
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
