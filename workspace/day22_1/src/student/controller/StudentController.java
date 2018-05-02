package student.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	public Student selectOne(int index)
	{
		return aL.get(index);
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
		aL.remove(classNumber);
	}

	public boolean save()
	{
		try(ObjectOutputStream oOs = new ObjectOutputStream(new FileOutputStream("student.txt")))
		{
			oOs.writeObject(aL);
			return true;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean load() {
		ObjectInputStream oIs = null;

		try {
			oIs = new ObjectInputStream(new FileInputStream("student.txt"));
			try {
				aL = (ArrayList<Student>) oIs.readObject();
				return true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try {
				oIs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;



		//		try(ObjectInputStream oIs = new ObjectInputStream(new FileInputStream("student.txt")))
		//		{
		//			try {
		//				aL = (ArrayList<Student>) oIs.readObject();
		//				return true;
		//			} catch (ClassNotFoundException e) {
		//				e.printStackTrace();
		//			}			
		//		} catch (FileNotFoundException e1) {
		//			e1.printStackTrace();
		//		} catch (IOException e1) {
		//			e1.printStackTrace();
		//		}
		//		return false ;
	}
}
