package com.kastet6398.myapplication.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.kastet6398.myapplication.R;
import com.kastet6398.myapplication.models.Calculator;
import com.kastet6398.myapplication.models.Utils;


public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private TextInputEditText textInputEditText;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputEditText = findViewById(R.id.expression);
        String lastResult = getIntent().getStringExtra("result");
        ((TextView) findViewById(R.id.last_result)).setText(lastResult != null ? "Last " + lastResult : "");
    }

    public void calculate(View view) {
        System.out.println(Calculator.calculate(String.valueOf(textInputEditText.getText())));
        startActivity(new Intent(this, SecondActivity.class).putExtra("result", Utils.formatComplex(Calculator.calculate(String.valueOf(textInputEditText.getText())))));
    }
}
