package ttl.larku.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttl.larku.domain.Student;

/**
 * @author whynot
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
