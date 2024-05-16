package hust.soict.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
        this.title = "";
        this.length = 0;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
