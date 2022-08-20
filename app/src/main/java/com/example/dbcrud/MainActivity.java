package com.example.dbcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button createBtn;
Button updateBtn;
Button deleteBtn;
Button viewOneBtn;
Button viewAllBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createBtn=findViewById(R.id.addNewStudent);
        updateBtn=findViewById(R.id.updateStudentRecord);
        deleteBtn=findViewById(R.id.deleteStudent);
        viewOneBtn=findViewById(R.id.viewStudentRecord);
        viewAllBtn=findViewById(R.id.viewAllStudents);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,addNewStudentActivity.class);
                startActivity(intent);
            }
        });
        viewOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,findStudent.class);
                startActivity(intent);
            }
        });
        viewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listAllStudentsActivity.class);
                startActivity(intent);

            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,updateStudentActivity.class);
                startActivity(intent);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,deleteStudentActivity.class);
                startActivity(intent);
            }
        });
    }
}