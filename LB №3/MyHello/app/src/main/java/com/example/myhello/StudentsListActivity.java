package com.example.myhello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class StudentsListActivity extends AppCompatActivity {

//    public static final String GROUP_NUMBER = "groupnumber";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Intent intent = getIntent();
//        String grpNumber = intent.getStringExtra(GROUP_NUMBER);
//
//        String txtStudents="";
//        for (Student s : Student.getStudents(grpNumber)){
//            txtStudents += s.getName() + "\n";
//        }
//        TextView textView = (TextView) findViewById(R.id.text);
//        textView.setText(txtStudents);
//    }
    public void onBtnClick(View view) {
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        String grpNumb = (String) spinner.getSelectedItem();

        Intent intent = new Intent(this, StudentsListActivity.class);
//        intent.putExtra(MainActivity.GROUP_NUMBER,grpNumb);

        startActivity(intent);
    }
}