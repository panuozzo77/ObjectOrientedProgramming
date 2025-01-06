package esami.homeAutomation;

import java.util.ArrayList;
import java.util.List;

class MP3Player {
    private String name;
    private String brand;
    public List<String> songs;
    private String selectedSong;
    public boolean isOn;
    private int playedSongs;

    public MP3Player(String name, String brand) {
        this.name = name;
        this.brand = brand;
        this.songs = new ArrayList<>();
        this.selectedSong = null;
        this.isOn = false;
        this.playedSongs = 0;
    }

    public void load(List<String> songs) {
        this.songs.addAll(songs);
    }

    public void start() {
        if (songs.isEmpty()) {
            System.out.println("No songs loaded.");
            return;
        }

        isOn = true;
        selectedSong = songs.get(0);
        System.out.println("MP3 player " + name + " is on. Selected song: " + selectedSong);
    }

    public String next() {
        if (!isOn) {
            return null;
        }

        if (selectedSong == null) {
            return null; // No song selected
        }

        int index = songs.indexOf(selectedSong);

        if (index < songs.size() - 1) {
            index++;
        } else {
            index = 0; // Go back to the first song
        }

        selectedSong = songs.get(index);
        return selectedSong;
    }

    public String play() {
        if (!isOn || selectedSong == null) {
            return null;
        }

        System.out.println("Playing song: " + selectedSong);
        playedSongs++;
        return selectedSong;
    }

    public void stop() {
        isOn = false;
        System.out.println("MP3 player " + name + " is off.");
    }

    @Override
    public String toString() {
        return name + " (" + brand + ") - Songs played: " + playedSongs;
    }
}
