package lk.nsbm.javaee.springmvcrest.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.Transient;
import java.util.List;

public class Artist {

    private Long id;
    private String name;
    private List<String> albums;

    public Artist() {
    }

    public Artist(Long id, String name, List<String> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    @Transient
    @JsonIgnore
    public boolean isValid() {

        return name != null && !name.isEmpty();

    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", albums=" + albums +
                '}';
    }
}
