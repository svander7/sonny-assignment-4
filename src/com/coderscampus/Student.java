package com.coderscampus;

public class Student implements Comparable<Student> {

	private String studentId;
	private String studentName;
	private String course;
	private String grade;

	public Student(String[] studentInputArray) {
		this.studentId = studentInputArray[0];
		this.studentName = studentInputArray[1];
		this.course = studentInputArray[2];
		this.grade = studentInputArray[3];
	}
	
	private StudentList studentService;
	private FileService fileService;

	public Student(StudentList studentService, FileService fileService) {
		this.studentService = studentService;
		this.fileService = fileService;
	}

	public void courseReport(String course, String exportFilename) {
		Student[] courseStudents = studentService.filterStudentsByCourse(course);

		fileService.writeStudentCsv(courseStudents, exportFilename);
	}

	public String getInfo() {
		return studentId + ", " + studentName + ", " + course + ", " + grade;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public StudentList getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentList studentService) {
		this.studentService = studentService;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	@Override
	public int compareTo(Student that) {

		if (Integer.parseInt(this.getGrade()) > Integer.parseInt(that.getGrade())) {
			return -1;
		} else if (Integer.parseInt(this.getGrade()) < Integer.parseInt(that.getGrade())) {
			return 1;
		} else {
			return 0;
		}
	}

}