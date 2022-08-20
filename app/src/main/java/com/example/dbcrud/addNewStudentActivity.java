package com.example.dbcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class addNewStudentActivity extends AppCompatActivity {

    Button insertBtn;
    TextView name, age, rollno, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        rollno=findViewById(R.id.rollno);
        email=findViewById(R.id.email);
        insertBtn=findViewById(R.id.insertBtn);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sName=name.getText().toString();
                String sAge=age.getText().toString();
                String sRollno=rollno.getText().toString();
                String sEmail=email.getText().toString();
                AlertDialog.Builder builder=new AlertDialog.Builder(addNewStudentActivity.this);
                if(sName.length()==0||sAge.length()==0||sEmail.length()==0||sRollno.length()==0) {
                    builder.setTitle("Error");
                    String message="";
                    if(sName.length()==0){
                        message+=" Name is empty \n";
                    }
                    if(sAge.length()==0){
                        message+=" Age is empty \n";
                    }
                    if(sEmail.length()==0){
                        message+=" Rollno is empty \n";
                    }
                    if(sRollno.length()==0){
                        message+=" Email is empty";
                    }

                    builder.setMessage(message);

                }else{
                    studentModel student=new studentModel(sName,sAge,sRollno,sEmail);
                    dbHelper db=new dbHelper(addNewStudentActivity.this);
                    try {
                        int result = db.addStudent(student);
                        if (result == -1) {
                            builder.setTitle("Error");
                            builder.setMessage("Rollno and Email must be unique.");
                        } else {
                            builder.setMessage("Inserted Successfully.");
                        }
                    }catch(Exception e){
                        builder.setCancelable(true);
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();
                    }
                }
                builder.setCancelable(true);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });

    }
}