package com.example.dbcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class findStudent extends AppCompatActivity {
    TextView input;
    Button findBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_student);

        input=findViewById(R.id.deleteByRollno);
        findBtn=findViewById(R.id.deleteByRollnoBtn);

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputRollno=input.getText().toString();
                AlertDialog.Builder builder=new AlertDialog.Builder(findStudent.this);
                if(inputRollno.length()==0){
                    builder.setTitle("Error");
                    builder.setMessage(("Please enter rollno to search student"));
                }else{
                    dbHelper db= new dbHelper(findStudent.this);
                    try{
                        studentModel student=db.findByRollno(inputRollno);
                        builder.setMessage(student.toString());
                    }catch(Exception e){
                        builder.setTitle("Error");
                        builder.setMessage(e.getMessage());
                    }
                }
                builder.setCancelable(true);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });
    }
}