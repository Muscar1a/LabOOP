package hust.soict.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book() {

    }
    public Book(String title) {
        this.title = title;
    }
    
    public Book(String title, float cost) {
        this.title = title;
        this.cost = cost;
    }
    
    public Book(String title, String category, float cost, ArrayList<String> authors) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = authors;
    }
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

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).equals(authorName)) {
                System.out.println("The author is already in the list.");
                return;
            } else {
                authors.add(authorName);
                System.out.println("The author has been added.");
                return;
            }
        }
    }

    public void removeAuthor(String authorName) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).equals(authorName)) {
                authors.remove(i);
                System.out.println("The author has been removed.");
                return;
            }
        }
        System.out.println("The author is not in the list.");
    }
}
