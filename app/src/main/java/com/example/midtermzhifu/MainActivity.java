package com.example.midtermzhifu;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editInputSide = findViewById(R.id.edit_side_input);
        TextView tvPerimeter = findViewById(R.id.tv_perimeter);
        editInputSide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    if (charSequence.length() > 0) {
                        double side = Double.parseDouble(charSequence.toString());
                        double perimeter = 4 * side;
                        tvPerimeter.setText(String.valueOf(perimeter));
                    } else {
                        tvPerimeter.setText(R.string.no_data);
                    }
                } catch (NumberFormatException e) {
                    tvPerimeter.setText(R.string.invalid_input);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}