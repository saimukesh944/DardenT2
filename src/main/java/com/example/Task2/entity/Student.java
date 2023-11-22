package com.example.Task2.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student {

	    @Id
	    private int id;
	    private String name;
	    private int age;
	    private double salary;
	 
	   
	 
	    public Student(int id, String name, int age, double salary) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }
	    public Student() {
	    	
	    }
	 
	    
	 
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public int getAge() {
	        return age;
	    }
	 
	    public void setAge(int age) {
	        this.age = age;
	    }
	 
	    public double getSalary() {
	        return salary;
	    }
	 
	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
	 
        
        @Override
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
        }
}
