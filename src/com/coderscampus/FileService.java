package com.coderscampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

	// Method to read file and return Array
	public Student[] readStudentFile(String filename) {
		Student[] studentObjectArray = new Student[150];
		String[] studentStringArray = new String[4];

		try (BufferedReader fileReader = new BufferedReader(new FileReader(filename));) {
			int i = 0;
			String line = fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				studentStringArray = line.split(",");
				studentObjectArray[i] = new Student(studentStringArray);
				i++;
			}
		} catch (Exception e) {
			System.out.println("There was an exception while reading the file.");
			e.printStackTrace();
		}
		return studentObjectArray;
	}

	// write csv method
	public void writeStudentCsv(Student[] inputStudentArray, String exportFilename) {

		try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(exportFilename))) {
			fileWriter.write("Student ID, Student Name, Course, Grade\n");
			for (Student student : inputStudentArray) {
				if (student != null) {
					fileWriter.write(student.getInfo() + "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("IOException writing csv");
			e.printStackTrace();
		}
	}
}