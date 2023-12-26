package com.coderscampus;

import java.util.Arrays;
import java.util.Comparator;

public class StudentList {

	private final String FILENAME = "student-master-list.csv";
	private Student[] students = new Student[100];

	public StudentList(FileService fileService) {
		students = fileService.readStudentFile(FILENAME);
		sortStudentsByGrade(students);
	}

	public void sortStudentsByGrade(Student[] inputArray) {

		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				if (student1 == null && student2 == null) {
					return 0;
				} else if (student1 == null) {
					return 1;
				} else if (student2 == null) {
					return -1;
				}
				return student1.compareTo(student2);
			}
		});
	}

	public Student[] filterStudentsByCourse(String course) {
		Student[] courseStudents = new Student[students.length];
		int studCtr = 0;
		for (Student student : students) {
			if (student != null && (student.getInfo()).contains(course)) {
				courseStudents[studCtr] = student;
			}
			studCtr++;
		}
		return courseStudents;
	}
}