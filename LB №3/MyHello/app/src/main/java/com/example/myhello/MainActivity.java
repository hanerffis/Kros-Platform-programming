package com.example.myhello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String GROUP_NUMBER = "groupnumber";

    public void onBtnClick(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String grpNumb = (String) spinner.getSelectedItem();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.GROUP_NUMBER,grpNumb);

        startActivity(intent);
    }
}