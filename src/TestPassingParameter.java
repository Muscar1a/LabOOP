

public class TestPassingParameter {
    
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
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
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderallaDVD = new DigitalVideoDisc("Cinderalla");
        
        swap(jungleDVD, cinderallaDVD);
        System.out.println("Junlge dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderalla dvd title: " + cinderallaDVD.getTitle());

        changeTitle(jungleDVD, cinderallaDVD.getTitle());
        System.out.println("Junlge dvd title: " + jungleDVD.getTitle());
    }
}
