package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float val1;
    float val2;

    private void fetchValues() {
        EditText firstNum = (EditText) findViewById(R.id.firstNum);
        EditText secondNum = (EditText) findViewById(R.id.secondNum);

        String string1 = firstNum.getText().toString();
        String string2 = secondNum.getText().toString();

        val1 = Float.parseFloat(string1);
        val2 = Float.parseFloat(string2);
    }

    private String floatToString(float f) {
        return Float.valueOf(f).toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivity(String str){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("message", str);
        startActivity(intent);
    }

    public void addClick(View view){
        fetchValues();
        String str = floatToString(val1 + val2);
        goToActivity(str);
    }

    public void subClick(View view){
        fetchValues();
        String str = floatToString(val1 - val2);
        goToActivity(str);
    }

    public void mulClick(View view){
        fetchValues();
        String str = floatToString(val1 * val2);
        goToActivity(str);
    }

    public void divClick(View view){
        fetchValues();
        if (val2 != 0) {
            String str = floatToString(val1 / val2);
            goToActivity(str);
        }
        else
            goToActivity("Error: Cannot divide by zero");
    }
}