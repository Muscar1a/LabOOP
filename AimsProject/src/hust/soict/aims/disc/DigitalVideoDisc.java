package hust.soict.aims.disc;
public class DigitalVideoDisc {

    private String title = null;
    private String category = null;
    private String director = null;
    private int length = 0;
    private float cost = 0;
    private static int nbDigitalVideoDiscs = 0; 
    private int id;

    public DigitalVideoDisc(String title) {
        this.title = title;
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost; 
        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
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
}


