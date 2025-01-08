package com.example.sayhello;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textViewName;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable Edge-to-Edge UI (if applicable)
        setContentView(R.layout.activity_main);

        // Apply insets for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        textViewName = findViewById(R.id.textViewName);
    }

    // Method triggered when the "Say Hello" button is clicked
    public void SayHello(View view) {
        // Retrieve text from EditText and display a greeting in TextView
        String name = editTextName.getText().toString().trim();
        if (!name.isEmpty()) {
            textViewName.setText("Hi " + name);
        } else {
            textViewName.setText("Hi there! Please enter your name.");
        }
    }
}
