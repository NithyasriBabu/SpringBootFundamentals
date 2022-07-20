package ttl.larku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ttl.larku.domain.Track;
import ttl.larku.service.TrackService;

import java.util.List;

@RestController
@RequestMapping("/track")
public class StudentController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Here we go to tracks.";
    }

    @GetMapping("/{id}")
    public Track getTrack(@PathVariable("id") int id) {
        Track t = trackService.getTrack(id);
        return t;
    }

    @GetMapping
    public List<Track> getAllTracks() {
        List<Track> tracks = trackService.getAllTracks();
        return tracks;
    }

    @PostMapping
    public Track insertTrack(@RequestBody Track track) {
        Track newTrack = trackService.createTrack(track);
        return newTrack;
    }
}
