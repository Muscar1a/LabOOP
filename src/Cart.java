import java.util.Arrays;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private DigitalVideoDisc tempOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is full.");
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("The disc " + '"' + dvdList[i].getTitle() + '"' + " has been added.");
            } else {
                System.out.println("The cart is full.");
                break;
            }
        }
    }

    /*public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("The disc " + '"' + dvdList[i].getTitle() + '"' + " has been added.");
            } else {
                System.out.println("The cart is full.");
                break;
            }
        }
    }*/

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The disc " + '"' + dvd1.getTitle() + '"' + " has been added.");
        } else {
            System.out.println("The cart is full.");
            return;
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The disc " + '"' + dvd2.getTitle() + '"' + " has been added.");
        } else {
            System.out.println("The cart is full.");
            return;
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int cnt = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle() != disc.getTitle()) {
                tempOrdered[cnt] = itemsOrdered[i];
                cnt++;
            }
        }
        if (cnt == qtyOrdered) {
            System.out.println("The disc " + '"' + disc.getTitle() + '"' + " is not in the cart.");
        } else {
            itemsOrdered = Arrays.copyOf(tempOrdered, cnt);
            qtyOrdered = cnt;
            System.out.println("The disc " + '"' + disc.getTitle() + '"' + " has been removed.");
        }
    }

    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            cost += itemsOrdered[i].getCost();
        } 
        return cost;
    }
}



