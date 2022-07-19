package ttl.larku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.util.List;

/**
 * @author whynot
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Here we go";
//    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
       Student s = studentService.getStudent(id);
       return s;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @PostMapping
    public Student insertStudent(@RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);

        return newStudent;
    }
}
