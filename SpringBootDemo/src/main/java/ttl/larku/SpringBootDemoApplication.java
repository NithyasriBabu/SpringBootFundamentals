package ttl.larku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ttl.larku.domain.Student;
import ttl.larku.domain.Track;
import ttl.larku.service.StudentService;
import ttl.larku.service.TrackService;

import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}

@Component
class TrackServiceRunner implements CommandLineRunner {

    @Autowired
    private TrackService trackService;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("TrackServiceRunner Called");
        List<Track> tracks = trackService.getAllTracks();
        System.out.println("Tracks Count: " + tracks.size());
        tracks.forEach(System.out::println);
    }
}
