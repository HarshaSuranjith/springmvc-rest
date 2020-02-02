package lk.nsbm.javaee.springmvcrest.service.Impl;

import lk.nsbm.javaee.springmvcrest.data.model.Artist;
import lk.nsbm.javaee.springmvcrest.service.ArtistService;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ArtistServiceHashImpl implements ArtistService {

    private Long key = 0L;
    private Map<Long, Artist> artists = new HashMap<>();

    public ArtistServiceHashImpl() {
        super();
        this.initData();
    }

    @Override
    public List<Artist> getAllArtists() {

        List<Artist> artistList = new ArrayList<>();
        artists.forEach(
                (k, v) -> artistList.add(v)
        );
        return artistList;
    }

    @Override
    public Artist addArtist(Artist artist) {
        Long id = getNextKey();
        artist.setId(id);
        this.artists.put(id, artist);
        System.out.println("Added aritust" + artist + "succssfully");
        return artist;
    }

    private void initData() {

        Artist bobMarley = new Artist(getNextKey(), "Bob Marley", Arrays.asList("Talkin blues", "Catch a Fire"));
        artists.put(bobMarley.getId(), bobMarley);

        Artist justB = new Artist(getNextKey(), "Justin Beiber", Arrays.asList("Baby", "Never Say Never"));
        artists.put(justB.getId(), justB);


    }

    private Long getNextKey() {
        return ++key;
    }
}
