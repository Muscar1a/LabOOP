package hust.soict.aims.media;
import java.util.Comparator;
import hust.soict.aims.exception.PlayerException;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    private static int nbMedia = 0;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST 
                        = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE 
                        = new MediaComparatorByCostTitle();

    // Constructor
    public Media(String title) {
        this.title = title;
        this.id = ++nbMedia;
    }
    public Media(String title, float cost) {
        this.title = title;
        this.cost = cost;
        this.id = ++nbMedia;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media media = (Media) obj;
            return this.id == media.id;
        }
        return false;
    }

    // Check is title match
    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    // Getter and setter method
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String playGUI() throws PlayerException {
        return "Playing media";
    }

    public void play() {
        System.out.println("Playing media");
    }
}
