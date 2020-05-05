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
			System.out.println("1.����	2.�л�	0.����");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.print("�޴��� �������ּ��� : 	");
			int menuNum = KeyboardUtil.nextInt();
			
			if (menuNum == 1) {
				
				System.out.println("[���� ������ �Դϴ�.]");
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("1.������ȸ	2.������	3.���������ȸ	4.��������ȸ	5.�������");
				System.out.println("----------------------------------------------------------------------------------");
				System.out.print("�޴��� �������ּ��� : 	");
				int professorNum = KeyboardUtil.nextInt();
				
				if (professorNum == 1) {
					
					System.out.println("[������ȸ]");
					System.out.print("�����̸��� �Է����ּ��� : ");
					String subjectName = KeyboardUtil.nextString();
					
					List<Subject> subjects = service.retrieveAllSubjectBySubjectName(subjectName);
					
					System.out.println("�����ȣ\t�����̸�\t�а���ȣ\t�а��̸�\t�������");
					
					for(Subject subject : subjects) {
						Department department = subject.getDepartment();
						System.out.println(subject.getNo()+"\t"+subject.getSubjectName()+"\t"+department.getNo()
											+"\t"+department.getDepartmentName()+"\t"+subject.getSubjectRegistrationDate());
					}
					
					
				} else if (professorNum == 2) {
					
					System.out.println("[������]");
					System.out.print("����Ͻ� ���� �̸��� �Է����ּ��� : ");
					String subjectName = KeyboardUtil.nextString();
					System.out.print("������ȣ�� �Է����ּ��� : ");
					int professorNo = KeyboardUtil.nextInt();
					boolean isSuccess = service.addNewSubject(subjectName, professorNo);
					if(isSuccess) {
						System.out.println("����� �Ϸ�Ǿ����ϴ�.");
					} else {
						System.out.println("����� �����Ͽ����ϴ�.");
					}
					
				} else if (professorNum == 3) {
					
					System.out.println("[���������ȸ]");
					System.out.print("��ȸ�Ͻ� ���� �̸��� �Է����ּ��� : ");
					String courseName = KeyboardUtil.nextString();
					
					System.out.println("������ȣ\t�����̸�\t��û�ο�\t�����ʰ�����\t�а��̸�\t�����̸�\t�����̸�\t�����");
					
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
					
					System.out.println("[��������ȸ]");
					System.out.print("��ȸȭ�� ���� ��ȣ�� �Է����ּ��� : ");
					int courseNo = KeyboardUtil.nextInt();
					
					System.out.println("������ȣ\t�����̸�\t�л���ȣ\t�л��̸�\t������ҿ���\t���Ῡ��\t����\t�����");
					
					List<RegistrationOfCourse> regis = service.retrieveCourseByCourseNo(courseNo);
					
					for(RegistrationOfCourse regi : regis) {
						Course course = regi.getCourse();
						Student student = regi.getStudent();
						System.out.println(regi.getNo()+"\t"+course.getCourseName()+"\t"+student.getNo()+"\t"+student.getStudentName()
											+"\t"+regi.getIsCancled()+"\t"+regi.getIsCompletion()+"\t"+regi.getScore()
											+"\t"+regi.getRegistrationOfCourseRegistrationDate());
					}
					
				} else if (professorNum == 5) {
					
					System.out.println("[�������]");
					System.out.print("���� �̸��� �Է����ּ��� : ");
					String courseName = KeyboardUtil.nextString();
					System.out.print("������ȣ�� �Է����ּ��� : ");
					int professorNo = KeyboardUtil.nextInt();
					System.out.print("���� �̸��� �Է����ּ��� : ");
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
						System.out.println("��ϵǾ����ϴ�.");
					} else {
						System.out.println("����� �����Ͽ����ϴ�.");
					}
				}
				
				
				
			} else if (menuNum == 2) {
				System.out.println();
				System.out.println("[�л� ������ �Դϴ�.]");
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("1.���������ȸ	2.������û	3.�������	4.������û������ȸ");
				System.out.println("----------------------------------------------------------------------------------");
				System.out.print("�޴��� �Է����ּ��� : ");
				int stuMenu = KeyboardUtil.nextInt();
				
				if (stuMenu == 1) {
					
					System.out.println("[���������ȸ]");
					System.out.print("��ȸ�Ͻ� ���� �̸��� �Է����ּ��� : ");
					String courseName = KeyboardUtil.nextString();
					
					System.out.println("������ȣ\t�����̸�\t��û�ο�\t�����ʰ�����\t�а��̸�\t�����̸�\t�����̸�\t�����");
					
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
					
					System.out.println("[������û]");
					System.out.print("�л���ȣ�� �Է����ּ��� : ");
					int studentNo = KeyboardUtil.nextInt();
					
					System.out.print("������ȣ�� �Է����ּ��� : ");
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
						System.out.println("������û�� �Ϸ�Ǿ����ϴ�.");
					} else {
						System.out.println("������û�� �����Ͽ����ϴ�.");
					}
					
					
				} else if (stuMenu == 3) {
					
					System.out.println("[�������]");
					System.out.print("�л���ȣ�� �Է����ּ��� : ");
					int studentNo = KeyboardUtil.nextInt();
					
					System.out.print("������ȣ�� �Է����ּ��� : ");
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
						System.out.println("��ҵǾ����ϴ�.");
					} else {
						System.out.println("�̹� ��ҵ� �����Դϴ�.");
					}
					
				} else if (stuMenu == 4) {
					
					System.out.println("[������û������ȸ]");
					System.out.print("�л���ȣ�� �Է����ּ��� : ");
					int studentNo = KeyboardUtil.nextInt();
					
					System.out.println("������ȣ\t�����̸�\t�л���ȣ\t�л��̸�\t������ҿ���\t���Ῡ��\t����\t�����");
				
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
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			
			
			
			
		}
		
	}
	
	
}
