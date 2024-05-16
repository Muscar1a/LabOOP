package hust.soict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    CompactDisc(int id, String title, String category, float cost) {
        super();
        this.setId(id);
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
}
