package lk.nsbm.javaee.springmvcrest.web;


import lk.nsbm.javaee.springmvcrest.data.model.Artist;
import lk.nsbm.javaee.springmvcrest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/artists")
@RestController
public class ArtistsController {

    private ArtistService artistService;

    @Autowired
    public ArtistsController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping(path = "test")
    public String test() {
        return "Artists controller is running";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllArtists() {

        List<Artist> artists = this.artistService.getAllArtists();
        return ResponseEntity.ok(artists);

    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createArtist(@RequestBody Artist artist) {

        if (artist.isValid()) {
            Artist saved = this.artistService.addArtist(artist);
            return ResponseEntity.ok(saved);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("time", LocalDateTime.now().toString());
            error.put("error", "Invalid artist info: " + artist.toString());
            return ResponseEntity.badRequest().body(error);
        }

    }

    @PutMapping
    public ResponseEntity<?> updateArtist(@RequestBody Artist artist) {
        if (artist.getId() != null && artist.isValid()) {
            Artist updated = this.artistService.updateArtist(artist);
            return ResponseEntity.ok(updated);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("time", LocalDateTime.now().toString());
            error.put("error", "Invalid artist info: " + artist.toString());
            return ResponseEntity.badRequest().body(error);
        }
    }


//    @Autowired
//    public void setArtistService(ArtistService artistService) {
//        this.artistService = artistService;
//    }
}
