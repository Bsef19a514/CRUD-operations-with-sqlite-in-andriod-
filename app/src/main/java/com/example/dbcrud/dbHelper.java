package com.example.dbcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context){
        super(context,"firstDB.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase database){
        String creteTableQuery="CREATE TABLE STUDENTS (Student_id Integer PRIMARY KEY AUTOINCREMENT, Student_name text, Student_age text, Student_rollno text UNIQUE, Student_email text UNIQUE)";
        database.execSQL(creteTableQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database,int i,int j){

    }
    public int  addStudent(studentModel student)throws Exception{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put("Student_name", student.getName());
            cv.put("Student_age", student.getAge());
            cv.put("Student_rollno", student.getRollno());
            cv.put("Student_email", student.getEmail());

            int result = (int) db.insert("STUDENTS", null, cv);
            db.close();
            return result;
    }
    public studentModel findByRollno(String rollno) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        String query="Select * from STUDENTS where Student_rollno= '"+rollno.trim()+"' ";
        Cursor cursor=db.rawQuery(query,null);

        studentModel student=new studentModel();
        if (cursor.moveToFirst()) {
           student=new studentModel(cursor.getString(1), cursor.getString(2),cursor.getString(3) , cursor.getString(4));
           cursor.close();
           db.close();
           return student;
        }else{
            throw new Exception("No student found");
        }
    }
    public ArrayList<studentModel> listAllStudents()throws Exception {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "Select * from STUDENTS";
            Cursor cursor = db.rawQuery(query, null);
            studentModel student;
            ArrayList<studentModel> students = new ArrayList<studentModel>();
            while (cursor.moveToNext()) {
                student = new studentModel(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                students.add(student);
            }
            cursor.close();
            return students;
        }catch(Exception e){
            throw e;
        }
    }
    public boolean deleteStudent(String rollno){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete("STUDENTS","Student_rollno=?",new String[]{rollno})>0;
    }
    public int updateStudent(String rollno,studentModel student) throws Exception{
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        if(student.getName().length()!=0){
            cv.put("Student_name", student.getName());
        }
        if(student.getAge().length()!=0) {
            cv.put("Student_age", student.getAge());
        }
        if(student.getEmail().length()!=0){
            cv.put("Student_email",student.getEmail());
        }
        int result= db.update("STUDENTS",cv,"Student_rollno=?",new String[]{rollno});
        return result;
    }
}
