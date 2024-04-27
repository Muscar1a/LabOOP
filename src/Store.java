import java.util.Arrays;

public class Store {
    public static final int MAX_NUMBERS_STORE = 1000;
    DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_STORE];
    DigitalVideoDisc[] tempInStore = new DigitalVideoDisc[MAX_NUMBERS_STORE];

    private int counting = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (counting < MAX_NUMBERS_STORE) {
            itemsInStore[counting] = disc;
            counting++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("No more space in store.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        int cnt = 0;
        for (int i = 0; i < counting; i++) {
            if (itemsInStore[i].getTitle() != disc.getTitle()) {
                tempInStore[cnt] = itemsInStore[i];
                cnt++;
            }
        }
        if (cnt == counting) {
            System.out.println("The disc " + '"' + disc.getTitle() + '"' + " is not in the cart.");
        } else {
            itemsInStore = Arrays.copyOf(tempInStore, cnt);
            counting = cnt;
            System.out.println("The disc " + '"' + disc.getTitle() + '"' + " has been removed.");
        }
    }

}
