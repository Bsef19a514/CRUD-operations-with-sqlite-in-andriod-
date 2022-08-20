package com.example.dbcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listAllStudentsActivity extends AppCompatActivity {
    ListView studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_students);

        studentsList=findViewById(R.id.studentsList);
        try {
            dbHelper db = new dbHelper(listAllStudentsActivity.this);
            ArrayList<studentModel> students = db.listAllStudents();
            if(students.size()<=0){
                AlertDialog.Builder builder=new AlertDialog.Builder(listAllStudentsActivity.this);
                builder.setTitle("Error");
                builder.setMessage("No record found");
                builder.setCancelable(true);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }else {
                ArrayAdapter arrayAdapter = new ArrayAdapter<studentModel>(listAllStudentsActivity.this, android.R.layout.simple_list_item_1, students);
                studentsList.setAdapter(arrayAdapter);
            }
        }catch(Exception e){
            AlertDialog.Builder builder=new AlertDialog.Builder(listAllStudentsActivity.this);
            builder.setTitle("Error");
            builder.setMessage(e.getMessage());
            builder.setCancelable(true);
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
    }
}