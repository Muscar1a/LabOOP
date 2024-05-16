package hust.soict.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    protected Disc() {
        super();
    }

    Disc(int id, String title, String category, float cost, int length, String director) {
        super();
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.setLength(length);
        this.setDirector(director);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
