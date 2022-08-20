package com.example.dbcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class deleteStudentActivity extends AppCompatActivity {
    TextView rollnoTextView;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        deleteBtn=findViewById(R.id.deleteByRollnoBtn);
        rollnoTextView=findViewById(R.id.deleteByRollno);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno=rollnoTextView.getText().toString().trim();
                dbHelper db=new dbHelper(deleteStudentActivity.this);
                boolean result=db.deleteStudent(rollno);
                AlertDialog.Builder builder=new AlertDialog.Builder(deleteStudentActivity.this);
                if (!result){
                    builder.setTitle("Error");
                    builder.setMessage("No record found");

                }else{
                    builder.setMessage("Deleted Successfully.");
                }
                builder.setCancelable(true);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });
    }
}