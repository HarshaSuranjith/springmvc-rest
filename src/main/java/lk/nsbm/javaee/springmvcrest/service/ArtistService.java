package lk.nsbm.javaee.springmvcrest.service;

import lk.nsbm.javaee.springmvcrest.data.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {

    List<Artist> getAllArtists();

    Artist addArtist(Artist artist);

    Artist updateArtist(Artist artist);
}
