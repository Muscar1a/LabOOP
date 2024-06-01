package hust.soict.test.disc;
import hust.soict.aims.media.CompactDisc;

public class TestPassingParameter {
    
    public static void changeTitle(CompactDisc.DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new CompactDisc.DigitalVideoDisc(oldTitle);
    }

    public static void swap(CompactDisc.DigitalVideoDisc dvd1, CompactDisc.DigitalVideoDisc dvd2) {
        String temp = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(temp);
    }

    /*public static void swap(Object dvd1, Object dvd2) {
        Object temp = dvd1;
        dvd1 = dvd2;
        dvd2 = temp;
    }*/

    public static void main(String[] args) {
        CompactDisc.DigitalVideoDisc jungleDVD = new CompactDisc.DigitalVideoDisc("Jungle");
        CompactDisc.DigitalVideoDisc cinderallaDVD = new CompactDisc.DigitalVideoDisc("Cinderalla");
        
        swap(jungleDVD, cinderallaDVD);
        System.out.println("Junlge dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderalla dvd title: " + cinderallaDVD.getTitle());

        changeTitle(jungleDVD, cinderallaDVD.getTitle());
        System.out.println("Junlge dvd title: " + jungleDVD.getTitle());
    }
}
