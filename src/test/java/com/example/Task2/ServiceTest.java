package com.example.Task2;


	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Task2.entity.Student;
import com.example.Task2.repository.StudentRepository;
import com.example.Task2.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.when;
	 
	import java.util.*;
	 
	@ExtendWith(MockitoExtension.class)
	class ServiceTest {
		@Mock
		StudentRepository sRepo;
		@InjectMocks
		StudentService sservice;
		@Test
		public void testGetDetails() {
			List<Student> list=new ArrayList<>();
			list.add(new Student(1,"kiran",24,40000));
			list.add(new Student(2,"pavan",25,50000));
			list.add(new Student(3,"sanjay",26,70000));
			list.add(new Student(4,"abhi",27,90000));
			when(sRepo.findAll()).thenReturn(list);
			List<Student> userExpected=sservice.getAllStudents();
			assertEquals(userExpected, list);
		}
		@Test
		public void testAddStudent() {
			Student s=new Student(1,"rahul",25,600000);
			when(sRepo.save(s)).thenReturn(s);
			Student s1=sservice.saveStudent(s);
			assertEquals(s.getId(), s1.getId());
		}
		@Test
		public void testGetById() {
			Student s=new Student(1,"sai",25,900000);
			when(sRepo.findById(1)).thenReturn(s);
			Student s1=sservice.getStudentById(s.getId());
			assertEquals(s.getId(), s1.getId());
		}
		@Test
		public void testUpdate() {
			Student s=new Student(1,"mukesh",25,800000);
			Student s1=new Student(s.getId(),"satish",26,2000000);
			when(sRepo.findById(s.getId())).thenReturn(s);
			when(sRepo.save(s)).thenReturn(s);
			sservice.updateStudent(s.getId(),s1);
			assertEquals(s1.getName(), s.getName());
		}
		@Test
		public void testDelete() {
			Student s=new Student(1,"ramu",25,500000);
			int studentIdToDelete = s.getId();
			String result = sservice.deleteStudent(studentIdToDelete);
			assertEquals("Deleted",result);
		}
	 
	}

