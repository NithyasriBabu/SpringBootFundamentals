package ttl.larku.app;

import ttl.larku.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author whynot
 */
public class JPADemo {

    public static void main(String[] args) {
        JPADemo demo = new JPADemo();
        //demo.insertStudent();
        demo.updateDB();
        demo.dumpAllStudents();
    }

    private EntityManagerFactory factory;
    public JPADemo() {
       factory = Persistence.createEntityManagerFactory("LarkUPU_SE");
    }

    public void dumpAllStudents() {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Student> query = manager.createQuery("select s from Student s", Student.class);

        List<Student> students = query.getResultList();

        System.out.println("students: " + students.size());
        students.forEach(System.out::println);
    }

    public void insertStudent() {
        Student st = new Student("Prius", "383 9393", Student.Status.HIBERNATING);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(st);

        manager.getTransaction().commit();
    }

    public void updateDB() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Student oldStudent = manager.find(Student.class, 21);
        oldStudent.setName("Marnie");

        manager.getTransaction().commit();
    }
}
