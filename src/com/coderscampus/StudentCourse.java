package com.coderscampus;

public class StudentCourse {

	private StudentList studentService;
	private FileService fileService;

	public StudentCourse(StudentList studentService, FileService fileService) {
		this.studentService = studentService;
		this.fileService = fileService;
	}

	public void courseReport(String course, String exportFilename) {
		Student[] courseStudents = studentService.filterStudentsByCourse(course);

		fileService.writeStudentCsv(courseStudents, exportFilename);
	}
}