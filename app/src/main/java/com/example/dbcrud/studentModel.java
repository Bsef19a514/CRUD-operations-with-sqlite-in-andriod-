package com.example.dbcrud;

public class studentModel {
    private String name;
    private String age;
    private String rollno;
    private String email;

    public studentModel(){
        name=null;
        age=null;
        rollno=null;
        email=null;
    }
    public studentModel(String name, String age, String rollno, String email){
        this.name=name;
        this.age=age;
        this.rollno=rollno;
        this.email=email;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }
    public String toString(){
        return "\nName: "+name+"\nAge: "+age+"\nRollno: "+rollno+"\nEmail: "+email +"\n";
    }
}
