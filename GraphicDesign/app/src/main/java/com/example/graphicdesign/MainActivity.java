package com.example.graphicdesign;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        // The variable type is now DrawEverything
        private GraphicDesign drawingView;
        private Button clearButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // The ID from the XML remains the same (R.id.drawingView)
            drawingView = findViewById(R.id.drawingView);
            clearButton = findViewById(R.id.clearButton);

            clearButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // The method call to clear the canvas is the same
                    drawingView.clearCanvas();
                }
            });
        }



}

