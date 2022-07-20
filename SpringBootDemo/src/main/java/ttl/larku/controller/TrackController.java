package ttl.larku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ttl.larku.domain.Track;
import ttl.larku.service.TrackService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Here we go to tracks.";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrack(@PathVariable("id") int id) {
        Track t = trackService.getTrack(id);

        if (t == null) {
            return ResponseEntity.status(404).body("No track with id " + id);
        }

        return ResponseEntity.ok(t);
    }

    @GetMapping
    public ResponseEntity<?> getAllTracks() {
        List<Track> tracks = trackService.getAllTracks();

        if(tracks.size() == 0) {
            return ResponseEntity.status(404).body("No tracks Found");
        }

        return ResponseEntity.ok(tracks);
    }

    @PostMapping
    public ResponseEntity<Track> insertTrack(@RequestBody Track track) {
        Track newTrack = trackService.createTrack(track);

        URI newResourse = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTrack.getId())
                .toUri();

//        return newTrack;
        return ResponseEntity.created(newResourse).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) {
        boolean ifTrackDeleted = trackService.deleteTrack(id);

        if (!ifTrackDeleted) {
            return ResponseEntity.status(404).body("No track with id " + id);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> updateTrack(@RequestBody Track track) {
        boolean ifTrackUpdated = trackService.updateTrack(track);

        if(!ifTrackUpdated) {
            return ResponseEntity.status(404).body("Not able to update track");
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }
}
