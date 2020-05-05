package com.sample.school.service;

import java.util.List;

import com.sample.school.dao.CourseDAO;
import com.sample.school.dao.DepartmentDAO;
import com.sample.school.dao.ProfessorDAO;
import com.sample.school.dao.RegistrationOfCourseDAO;
import com.sample.school.dao.StudentDAO;
import com.sample.school.dao.SubjectDAO;
import com.sample.school.vo.Course;
import com.sample.school.vo.Department;
import com.sample.school.vo.Professor;
import com.sample.school.vo.RegistrationOfCourse;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolService {

	CourseDAO courseDao = new CourseDAO();
	DepartmentDAO departmentDao = new DepartmentDAO();
	ProfessorDAO professorDao = new ProfessorDAO();
	RegistrationOfCourseDAO regiCourseDao = new RegistrationOfCourseDAO();
	StudentDAO studentDao = new StudentDAO();
	SubjectDAO subjectDao = new SubjectDAO();
	
	//교수
	//과목조회
	public List<Subject> retrieveAllSubjectBySubjectName(String subjectName) throws Exception {
		return subjectDao.getAllSubjectBySubjectName(subjectName);
	}
	//과목등록
	public boolean addNewSubject(String subjectName, int professorNo) throws Exception{
		Professor professor = professorDao.getProfessorByProfessorNo(professorNo);
		if(professor == null) {
			System.out.println("1");
			return false;
		}
		Subject subjectCheck = subjectDao.getSubjectBySubjectName(subjectName);
		if(subjectCheck != null) {
			System.out.println("2");
			return false;
		}
		Department department = departmentDao.getDepartmentByNo(professor.getDepartment().getNo());
		if(department == null) {
			System.out.println("3");
			return false;
		}
		
		Subject subject = new Subject();
		subject.setSubjectName(subjectName);
		subject.setDepartment(department);
		
		subjectDao.addNewSubject(subject);
		
		return true;
	}
	//과정목록조회
	public List<Course> retrieveAllCourseByCourseNo(String courseName) throws Exception {
		return courseDao.getAllCourseByCourseName(courseName);
	}
	//과정상세조회(해당과정 신청 학생 포함)
	public List<RegistrationOfCourse> retrieveCourseByCourseNo(int courseNo) throws Exception {
		return regiCourseDao.getAllRegistrationOfCourseByCourseNo(courseNo);
	}
	//과정 등록
	public boolean addNewCourse(Course course) throws Exception {
		List<Course> courses = courseDao.getAllCourseByCourseName(course.getCourseName());
		for(Course courseCheck : courses) {
			if(courseCheck.getCourseName().equals(course.getCourseName())) {
				System.out.println("1");
				return false;
			}
		}
		Professor professorCheck = professorDao.getProfessorByProfessorNo(course.getProfessor().getNo());
		if(professorCheck == null) {
			System.out.println("2");
			return false;
		}
		Department department = departmentDao.getDepartmentByNo(professorCheck.getDepartment().getNo());
		if(department == null) {
			System.out.println("3");
			return false;
		}
		course.setDepartment(department);

		Subject subject = subjectDao.getSubjectBySubjectName(course.getSubject().getSubjectName());
		if(subject == null) {
			System.out.println("4");
			return false;
		}
		course.setSubject(subject);
		
		courseDao.addNewCourse(course);
		
		return true;
	}
	//학생
	//수강신청
	public boolean addNewRegistrationCourse(RegistrationOfCourse registrationOfCourse) throws Exception {
		
		Student studentCheck = studentDao.getStudentByStudentNo(registrationOfCourse.getStudent().getNo());
		if(studentCheck == null) {
			return false;
		}
		Course courseCheck = courseDao.getCourseByCourseNo(registrationOfCourse.getCourse().getNo());
		if(courseCheck == null) {
			return false;
		}
		if(courseCheck.getIsFullOfCourse().equalsIgnoreCase("Y")) {
			return false;
		}
		RegistrationOfCourse DuplicateRegiCheck = regiCourseDao.getStudentByCourseNo(courseCheck.getNo(), studentCheck.getNo());
		if(DuplicateRegiCheck != null) {
			return false;
		}
		
		regiCourseDao.addNewRegistrationOfCourse(registrationOfCourse);

		Course course = courseCheck;
		int numberOfPeople = course.getNumberOfPeople();
		if(numberOfPeople == 30) {
			course.setIsFullOfCourse("Y");
			return false;
		}
		numberOfPeople++;
		course.setNumberOfPeople(numberOfPeople);
		
		courseDao.updateCourseByCourseNo(course);
		
		return true;
	}
	//수강신청 취소
	public boolean cancleRegistrationCourse(int courseNo, int studentNo) throws Exception {
		
		RegistrationOfCourse regiCheck = regiCourseDao.getStudentByCourseNo(courseNo, studentNo);
		if(regiCheck == null) {
			return false;
		}
		if(regiCheck.getIsCompletion().equalsIgnoreCase("Y")) {
			return false;
		}
		if(regiCheck.getIsCancled().equalsIgnoreCase("Y")) {
			return false;
		}
		RegistrationOfCourse registrationOfCourse = regiCheck;
		registrationOfCourse.setIsCancled("y");
		
		regiCourseDao.updateRegistrationOfCourse(registrationOfCourse);
		return true;
	}
	//수강신청 내역 조회
	public List<RegistrationOfCourse> retrieveAllRegistrationOfCourseByStudentNo(int studentNo) throws Exception {
		return regiCourseDao.getAllRegistrationOfCourseByStudentNo(studentNo);
	}
	
}
