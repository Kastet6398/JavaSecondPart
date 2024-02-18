package com.kastet6398.myapplication.ui;
import android.content.Intent;
import android.view.View;

import com.kastet6398.myapplication.R;

public class SecondActivity extends androidx.appcompat.app.AppCompatActivity{
    private String result;
    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        ((android.widget.TextView) findViewById(R.id.result)).setText(result = String.format(getString(R.string.result_text), getIntent().getStringExtra("result")));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainActivity.class).putExtra("result", result));
    }
}
