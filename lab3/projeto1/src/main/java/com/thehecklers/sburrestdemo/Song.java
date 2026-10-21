package com.thehecklers.sburrestdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Song {
    private UUID id;
    private String name;
    private List<String> artists = new ArrayList<>();
    private int duration;

    public Song(UUID id, String name, List<String> artists, int duration) {
        this.id = id;
        this.name = name;
        this.artists = artists;
        this.duration = duration;
    }

    public Song() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
