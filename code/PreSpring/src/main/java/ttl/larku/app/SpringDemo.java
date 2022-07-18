package ttl.larku.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.domain.Course;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.CourseService;
import ttl.larku.service.StudentService;

import java.util.List;

/**
 * @author whynot
 */
public class SpringDemo {
    public static void main(String[] args) {
        SpringDemo sd = new SpringDemo();
//        sd.go();
        sd.go2();
    }

    public void go() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

        BaseDAO<Student> bd = context.getBean("studentDAO", BaseDAO.class);

        StudentService studentService = context.getBean("studentService", StudentService.class);
        StudentService studentService2 = context.getBean("studentService", StudentService.class);

        List<Student> students = studentService.getAllStudents();
        System.out.println("student: " + students.size());
        students.forEach(System.out::println);
    }

    public void go2() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

        CourseService courseService = context.getBean("courseService", CourseService.class);

        List<Course> courses = courseService.getAllCourses();
        System.out.println("student: " + courses.size());
        courses.forEach(System.out::println);
    }
}

