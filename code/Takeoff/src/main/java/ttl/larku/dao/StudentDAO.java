package ttl.larku.dao;
import ttl.larku.domain.Student;
import java.util.List;

public interface StudentDAO {

    public Student create(Student newObject);
    public boolean update(Student updateObject);
    public boolean delete(Student student);

    public Student get(int id);
    public List<Student> getAll();
}