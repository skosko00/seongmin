package student.controller;

import java.util.ArrayList;
import java.util.Collections;

import student.vo.Student;

public class StudentController {

	private ArrayList<Student> aL = new ArrayList<Student>();

	public ArrayList<Student> selectAll()
	{
		Collections.sort(aL);
		return aL;
	}

	public boolean insertStudent(Student s) {
		return this.aL.add(s);
	}

	public Student selectOne(int classNumber)
	{
		for(int i=0; i<aL.size();i++)
		{
			if(classNumber == aL.get(i).getClassNumber())
			{
				return aL.get(i);
			}
		}
		return null;
	}

	public int searchStuent(int number) 
	{
		for(int i=0; i<aL.size();i++)
		{
			if(number == aL.get(i).getClassNumber())
			{
				return i;
			}
		}
		return -1;
	}

	public void updateStudent(Student s, int index) 
	{
		aL.set(index, s);
	}

	public void deleteStudent(int classNumber) 
	{
		for(int i=0; i<aL.size();i++)
		{
			if(classNumber == aL.get(i).getClassNumber())
			{
				aL.remove(i);
			}
		}
		
	}
}
