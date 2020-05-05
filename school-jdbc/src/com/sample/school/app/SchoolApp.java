package com.sample.school.app;

import java.util.List;

import com.sample.school.service.SchoolService;
import com.sample.school.util.KeyboardUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Department;
import com.sample.school.vo.Professor;
import com.sample.school.vo.RegistrationOfCourse;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolApp {

	
	public static void main(String[] args) throws Exception{
		SchoolService service = new SchoolService();
		
		while(true) {
		
			
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("1.교수	2.학생	0.종료");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.print("메뉴를 선택해주세요 : 	");
			int menuNum = KeyboardUtil.nextInt();
			
			if (menuNum == 1) {
				
				System.out.println("[교수 페이지 입니다.]");
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("1.과목조회	2.과목등록	3.과정목록조회	4.과정상세조회	5.과정등록");
				System.out.println("----------------------------------------------------------------------------------");
				System.out.print("메뉴를 선택해주세요 : 	");
				int professorNum = KeyboardUtil.nextInt();
				
				if (professorNum == 1) {
					
					System.out.println("[과목조회]");
					System.out.print("과목이름을 입력해주세요 : ");
					String subjectName = KeyboardUtil.nextString();
					
					List<Subject> subjects = service.retrieveAllSubjectBySubjectName(subjectName);
					
					System.out.println("과목번호\t과목이름\t학과번호\t학과이름\t등록일자");
					
					for(Subject subject : subjects) {
						Department department = subject.getDepartment();
						System.out.println(subject.getNo()+"\t"+subject.getSubjectName()+"\t"+department.getNo()
											+"\t"+department.getDepartmentName()+"\t"+subject.getSubjectRegistrationDate());
					}
					
					
				} else if (professorNum == 2) {
					
					System.out.println("[과목등록]");
					System.out.print("등록하실 과목 이름을 입력해주세요 : ");
					String subjectName = KeyboardUtil.nextString();
					System.out.print("교수번호를 입력해주세요 : ");
					int professorNo = KeyboardUtil.nextInt();
					boolean isSuccess = service.addNewSubject(subjectName, professorNo);
					if(isSuccess) {
						System.out.println("등록이 완료되었습니다.");
					} else {
						System.out.println("등록이 실패하였습니다.");
					}
					
				} else if (professorNum == 3) {
					
					System.out.println("[과정목록조회]");
					System.out.print("조회하실 과정 이름을 입력해주세요 : ");
					String courseName = KeyboardUtil.nextString();
					
					System.out.println("과정번호\t과정이름\t신청인원\t정원초과여부\t학과이름\t과목이름\t교수이름\t등록일");
					
					List<Course> courses = service.retrieveAllCourseByCourseNo(courseName);
					for(Course course : courses) {
						Department department = course.getDepartment();
						Subject subject = course.getSubject();
						Professor professor = course.getProfessor();
						System.out.println(course.getNo()+"\t"+course.getCourseName()+"\t"+course.getNumberOfPeople()
										+"\t"+course.getIsFullOfCourse()+"\t"+department.getDepartmentName()+"\t"+subject.getSubjectName()
										+"\t"+professor.getProfessorName()+"\t"+course.getCourseRegistrationDate());
					}
					
				} else if (professorNum == 4) {
					
					System.out.println("[과정상세조회]");
					System.out.print("조회화실 과정 번호를 입력해주세요 : ");
					int courseNo = KeyboardUtil.nextInt();
					
					System.out.println("수강번호\t과정이름\t학생번호\t학생이름\t수강취소여부\t수료여부\t점수\t등록일");
					
					List<RegistrationOfCourse> regis = service.retrieveCourseByCourseNo(courseNo);
					
					for(RegistrationOfCourse regi : regis) {
						Course course = regi.getCourse();
						Student student = regi.getStudent();
						System.out.println(regi.getNo()+"\t"+course.getCourseName()+"\t"+student.getNo()+"\t"+student.getStudentName()
											+"\t"+regi.getIsCancled()+"\t"+regi.getIsCompletion()+"\t"+regi.getScore()
											+"\t"+regi.getRegistrationOfCourseRegistrationDate());
					}
					
				} else if (professorNum == 5) {
					
					System.out.println("[과정등록]");
					System.out.print("과정 이름을 입력해주세요 : ");
					String courseName = KeyboardUtil.nextString();
					System.out.print("교수번호를 입력해주세요 : ");
					int professorNo = KeyboardUtil.nextInt();
					System.out.print("과목 이름을 입력해주세요 : ");
					String subjectName = KeyboardUtil.nextString();
					
					Course course = new Course();
					course.setCourseName(courseName);
					Professor professor = new Professor();
					professor.setNo(professorNo);
					course.setProfessor(professor);
					Subject subject = new Subject();
					subject.setSubjectName(subjectName);
					course.setSubject(subject);
					
					boolean isSuccess = service.addNewCourse(course);
					if(isSuccess) {
						System.out.println("등록되었습니다.");
					} else {
						System.out.println("등록이 실패하였습니다.");
					}
				}
				
				
				
			} else if (menuNum == 2) {
				System.out.println();
				System.out.println("[학생 페이지 입니다.]");
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("1.과정목록조회	2.수강신청	3.수강취소	4.수강신청내역조회");
				System.out.println("----------------------------------------------------------------------------------");
				System.out.print("메뉴를 입력해주세요 : ");
				int stuMenu = KeyboardUtil.nextInt();
				
				if (stuMenu == 1) {
					
					System.out.println("[과정목록조회]");
					System.out.print("조회하실 과정 이름을 입력해주세요 : ");
					String courseName = KeyboardUtil.nextString();
					
					System.out.println("과정번호\t과정이름\t신청인원\t정원초과여부\t학과이름\t과목이름\t교수이름\t등록일");
					
					List<Course> courses = service.retrieveAllCourseByCourseNo(courseName);
					for(Course course : courses) {
						Department department = course.getDepartment();
						Subject subject = course.getSubject();
						Professor professor = course.getProfessor();
						System.out.println(course.getNo()+"\t"+course.getCourseName()+"\t"+course.getNumberOfPeople()
										+"\t"+course.getIsFullOfCourse()+"\t"+department.getDepartmentName()+"\t"+subject.getSubjectName()
										+"\t"+professor.getProfessorName()+"\t"+course.getCourseRegistrationDate());
					}
					
				} else if (stuMenu == 2) {
					
					System.out.println("[수강신청]");
					System.out.print("학생번호를 입력해주세요 : ");
					int studentNo = KeyboardUtil.nextInt();
					
					System.out.print("과정번호를 입력해주세요 : ");
					int courseNo = KeyboardUtil.nextInt();
					
					RegistrationOfCourse regi = new RegistrationOfCourse();
					Student student = new Student();
					student.setNo(studentNo);
					regi.setStudent(student);
					Course course = new Course();
					course.setNo(courseNo);
					regi.setCourse(course);
					
					boolean isSuccess = service.addNewRegistrationCourse(regi);
					if(isSuccess) {
						System.out.println("수강신청이 완료되었습니다.");
					} else {
						System.out.println("수강신청이 실패하였습니다.");
					}
					
					
				} else if (stuMenu == 3) {
					
					System.out.println("[수강취소]");
					System.out.print("학생번호를 입력해주세요 : ");
					int studentNo = KeyboardUtil.nextInt();
					
					System.out.print("과정번호를 입력해주세요 : ");
					int courseNo = KeyboardUtil.nextInt();
					RegistrationOfCourse regi = new RegistrationOfCourse();
					Student student = new Student();
					student.setNo(studentNo);
					regi.setStudent(student);
					Course course = new Course();
					course.setNo(courseNo);
					regi.setCourse(course);
					boolean isSuccess = service.cancleRegistrationCourse(courseNo, studentNo);
					if(isSuccess) {
						System.out.println("취소되었습니다.");
					} else {
						System.out.println("이미 취소된 강의입니다.");
					}
					
				} else if (stuMenu == 4) {
					
					System.out.println("[수강신청내역조회]");
					System.out.print("학생번호를 입력해주세요 : ");
					int studentNo = KeyboardUtil.nextInt();
					
					System.out.println("수강번호\t과정이름\t학생번호\t학생이름\t수강취소여부\t수료여부\t점수\t등록일");
				
					List<RegistrationOfCourse> registrations = service.retrieveAllRegistrationOfCourseByStudentNo(studentNo);
					
					for(RegistrationOfCourse regi : registrations) {
						Course course = regi.getCourse();
						Student student = regi.getStudent();
						System.out.println(regi.getNo()+"\t"+course.getCourseName()+"\t"+student.getNo()+"\t"+student.getStudentName()
											+"\t"+regi.getIsCancled()+"\t"+regi.getIsCompletion()+"\t"+regi.getScore()
											+"\t"+regi.getRegistrationOfCourseRegistrationDate());
					}
					
				}
				
			} else if (menuNum == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			
			
			
		}
		
	}
	
	
}
