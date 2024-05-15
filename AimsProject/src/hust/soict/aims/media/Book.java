package hust.soict.aims.media;

import java.util.ArrayList;

public class Book {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book() {

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
