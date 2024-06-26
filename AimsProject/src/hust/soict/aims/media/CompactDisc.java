package hust.soict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title) {
        super();
        this.setTitle(title);
    }

    public CompactDisc(String title, float cost) {
        super();
        this.setTitle(title);
        this.cost = cost;
    }
    
    public CompactDisc(String title, String category, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
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
}
