package com.coderscampus;

public class ClassSortApp {

	public static void main(String[] args) {

		FileService fileService = new FileService();
		StudentList studentService = new StudentList(fileService);
		StudentCourse reportService = new StudentCourse(studentService, fileService);

		reportService.courseReport("COMPSCI", "course1.csv");
		reportService.courseReport("APMTH", "course2.csv");
		reportService.courseReport("STAT", "course3.csv");
	}
}