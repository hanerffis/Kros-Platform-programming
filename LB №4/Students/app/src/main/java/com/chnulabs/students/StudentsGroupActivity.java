package com.chnulabs.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class StudentsGroupActivity extends AppCompatActivity {

    public static final String GROUP_NUMBER = "groupnumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_group);

        Intent intent = getIntent ();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);
        StudentsGroup group = StudentsGroup. getGroup (grpNumber) ;

        TextView txtGrpNumber = (TextView) findViewById (R.id.grpNumberImageTxt);
        txtGrpNumber.setText(group.getNumber ());

        TextView txtFacultyName = (TextView) findViewById(R.id.facultyNumberImageTxt);
        txtFacultyName.setText(group.getFacultyName());

        if (group.getEducationLevel()==0){
            ((RadioButton) findViewById(R.id.edu_level_bachelor)).setChecked(true);
        } else {
            ((RadioButton) findViewById(R.id.edu_level_master)).setChecked(true);
        }

        ((CheckBox) findViewById(R.id.contract_flg)).setChecked(
                group.isContractExistsFlg()
        );

        ((CheckBox) findViewById(R.id.privilege_flg)).setChecked(
                group.isPrivilageExistsFlg()
        );
    }
    public void onOkBtnClick(View view){
        String outString = "Група " + ((TextView) findViewById(R.id.grpNumberEdit)).getText() + "\n";

        outString += "факультет " + ((TextView) findViewById(R.id.facultyEdit)).getText()+"\n";

        if (((RadioButton) findViewById(R.id.edu_level_master)).isChecked()) {
            outString += "рівень освіти - " + "магфстр\n";
        } else {
            outString += "рівень освіти - " + "бакалавр\n";
        }

        if (((CheckBox) findViewById(R.id.contract_flg)).isChecked()) {
            outString += "контрактники є\n";
        } else {
            outString += "пільговиків немає\n";
        }

        Toast.makeText(this,outString,Toast.LENGTH_LONG).show();
    }
}