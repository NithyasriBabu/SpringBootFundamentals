package ttl.larku.jconfig;

import org.springframework.context.annotation.*;
import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;


//@ComponentScan({"ttl.larku.service", "ttl.larku.dao", "ttl.larku.misc"})
//@PropertySource({"classpath:/larkUContext.properties"})

@Configuration
@ComponentScan(basePackages = {"ttl.larku.service", "ttl.larku.dao"})
public class LarkUConfig {
    /*
      <bean id="inMemoryStudentDAO" class="ttl.larku.dao.inmemory.InMemoryStudentDAO"/>
    */
    @Bean
    public BaseDAO<Student> studentDAO() {
        var dao = new InMemoryStudentDAO();
        return dao;
    }

    /*
    <bean id="studentService" class="ttl.larku.service.StudentService">
        <property name="studentDAO" ref="inMemoryStudentDAO" />
    </bean>
     */
    @Bean
    @Lazy
    public StudentService studentService() {
        StudentService ss = new StudentService();
        BaseDAO<Student> dao = studentDAO();

        ss.setStudentDAO(dao);
        return ss;
    }

}