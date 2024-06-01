package hust.soict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CompactDisc(String title, float cost) {
        super(title, cost);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    public void addTrack(Track track) {
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).equals(track)) {
                System.out.println("The track is already in the list.");
                return;
            } else {
                tracks.add(track);
                System.out.println("The track has been added.");
                return;
            }
        }
    }

    public void removeTrack(Track track) {
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).equals(track)) {
                tracks.remove(i);
                System.out.println("The track has been removed.");
                return;
            }
        }
        System.out.println("The track is not in the list.");
    }

    public int getLength() {
        int length = 0;
        for (int i = 0; i < tracks.size(); i++) {
            length += tracks.get(i).getLength();
        }
        return length;
    }

    @Override
    public void play() {
        for (int i = 0; i < tracks.size(); i++) {
            tracks.get(i).play();
        }
    }

    public static class DigitalVideoDisc extends Disc implements Playable {
        private String category = null;
        private String director = null;
        private int length = 0;
        private static int nbDigitalVideoDiscs = 0;

        // Constructor
        public DigitalVideoDisc(String title) {
            super(title);
        }
        public DigitalVideoDisc(String title, String category, float cost) {
            super(title, category, cost);
        }
        public DigitalVideoDisc(String title, String category, String director, float cost) {
            super(title, category, director, cost);
        }
        public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
            super(title, category, director, length, cost);
        }

        public String getTitle() {
            return title;
        }

        public String getCategory() {
            return category;
        }

        public String getDirector() {
            return director;
        }

        public float getCost() {
            return cost;
        }

        public int getLength() {
            return length;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public void play() {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
    }
}
