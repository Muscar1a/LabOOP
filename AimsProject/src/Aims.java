import hust.soict.aims.cart.Cart;
import hust.soict.aims.disc.DigitalVideoDisc;
import hust.soict.aims.media.Book;
import hust.soict.aims.media.CompactDisc;
import hust.soict.aims.media.Media;
import hust.soict.aims.store.Store;

import java.util.Scanner;
import java.util.Collections;

public class Aims {
    private static Store store = new Store(); 
    private static Cart cart = new Cart();
    static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("-------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See cart");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: ");
        
        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice > 3 || choice < 0) 
                System.out.println("Invalid, please enter again: ");
            else 
                break;
        }
        if (choice == 1) {
            storeMenu();
        } else if (choice == 2) {
            udpateStore();
        } else if (choice == 3) {
            cartMenu();
        } else {
            System.out.println("Exit program");
            System.exit(0);
        }
    }

    public static void udpateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");
		
        int choice;

        while (true) {
            choice = scanner.nextInt();
            if (choice > 3 || choice < 0) 
                System.out.println("Invalid, please enter again: ");
            else 
                break;
        }
		if (choice == 1) {
			updateStore01();
		} else if (choice == 2) {
			updateStore02();
		} else {
			showMenu();
		}
	}

    public static void updateStore01() {
		System.out.println("Enter the title of the media: ");
		String title = scanner.nextLine();
		System.out.println("Enter the cost of the media: ");
		float cost = scanner.nextFloat();

		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. DigitalVideoDisc");
		System.out.println("3. CompactDisc");
		System.out.println("0. Back");
		
        int choice;

        while (true) {
            choice = scanner.nextInt();
            if (choice > 3 || choice < 0) 
                System.out.println("Invalid, please enter again: ");
            else 
                break;
        }

		if (choice == 1) {
			Book newBook =  new Book(title, cost);
			store.addMedia(newBook);
		} else if (choice == 2) {
			DigitalVideoDisc newDVD = new DigitalVideoDisc(title, cost);
			store.addMedia(newDVD);
		} else if (choice == 3) {
			CompactDisc newCD = new CompactDisc(title, cost);
			store.addMedia(newCD);
		}
		udpateStore();
	}
	
	public static void updateStore02() {
		System.out.println("Enter the title of the media: ");
		String name = scanner.nextLine();
        name = scanner.nextLine();
		boolean found = false;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(name)) {
				found = true;
				store.removeMedia(media);
			}
		}
		if (!found) {
			System.out.println("This media is not in store");
		}
		udpateStore();
	}

    public static void storeMenu() {
        System.out.println("Store menu: ");
        System.out.println("-------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See the current cart");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: ");

        
        int choice;

        while (true) {
            choice = scanner.nextInt();
            if (choice > 4 || choice < 0) 
                System.out.println("Invalid, please enter again: ");
            else 
                break;
        }
        if (choice == 1) {
            storeMenu01();
        } if (choice == 2) {
            storeMenu02();
        } if (choice == 3) {
            storeMenu03();
        } if (choice == 4) {
            cartMenu();
        } else if (choice == 0) {
            showMenu();
        }

    }

    public static void storeMenu01() {
        System.out.println("Enter name of the media: ");
        String name = scanner.nextLine();
        name = scanner.nextLine();
        boolean found = false;

        for (Media media:store.getItemsInStore()) {
            if (media.getTitle().equals(name)) {
                media.toString();
                mediaDetailsMenu(media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Media not found.");
            storeMenu();
        }
    }

    public static void storeMenu02() {
        System.out.println("Enter name of the media: ");
        String name = scanner.nextLine();
        name = scanner.nextLine();
        boolean found = false;
        for (Media media:store.getItemsInStore()) {
            if (media.getTitle().equals(name)) {
                found = true;
                cart.addMedia(media);
                System.out.println("Media " + media.getTitle() + " added to cart.");
                System.out.println("Number of media in current cart: " + cart.getItemsOrdered().size());
            }
        }
        if (!found) {
            System.out.println("Media not found in store.");
        }
        storeMenu();
    }

    public static void storeMenu03() {
        System.out.println("Enter name of the media: ");
        String name = scanner.nextLine();
        name = scanner.nextLine();
        boolean found = false;
        for (Media media:store.getItemsInStore()) {
            if (media.getTitle().equals(name)) {
                found = true; 
                if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    cd.play();
                } if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    dvd.play();
                } if (media instanceof Book) {
                    System.out.println("This media is a book.");
                }
            }
        }
        if (!found) {
            System.out.println("Media not found in store.");
        }
        storeMenu();
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: ");

        int choice;

        while (true) {
            choice = scanner.nextInt();
            if (choice > 2 || choice < 0) 
                System.out.println("Invalid, please enter again: ");
            else 
                break;
        }

        if (choice == 1) {
            cart.addMedia(media);
        } else if (choice == 2) {
            if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                cd.play();
            } if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                dvd.play();
            } if (media instanceof Book) {
                System.out.println("This media is a book.");
            }
        }
        storeMenu();
    }

    public static void cartMenu() {
        cart.print();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: ");

        int choice;

        while (true) {
            choice = scanner.nextInt();
            if (choice > 5 || choice < 0) 
                System.out.println("Invalid, please enter again: ");
            else 
                break;
        }

        if (choice == 1) {
            cartMenu01();
        } if (choice == 2) {
            cartMenu02();
        } if (choice == 3) {
            cartMenu03();
        } if (choice == 4) {
            cartMenu04();
        } else if (choice == 5) {
            System.out.println("Ordered.");
            cart.getItemsOrdered().clear();
        } else {
            storeMenu();
        }
    }

    public static void cartMenu01() {
        System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by title");
		System.out.println("0. Back");
		
        int choice;

        while (true) {
            choice = scanner.nextInt();
            if (choice > 1 || choice < 0) 
                System.out.println("Invalid, please enter again: ");
            else 
                break;
        }

        if (choice == 1) {
			System.out.println("Enter title: ");
			String title = scanner.nextLine();
			cart.searchTitle(title);
		}
        cartMenu();
    }

    public static void cartMenu02() {
        System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
        System.out.println("Please choose a number: ");
        int choice;

        while (true) {
            choice = scanner.nextInt();
            if (choice > 2 || choice < 0) 
                System.out.println("Invalid, please enter again: ");
            else 
                break;
        }

		if (choice == 1) {
			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
			cart.print();
		} else if (choice == 2) {
			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
			cart.print();
		}
        cartMenu();
    }

    public static void cartMenu03() {
		System.out.println("Enter the title of the media: ");
		String name = scanner.nextLine();
        name = scanner.nextLine();

        boolean found = false;
		for (Media media: cart.getItemsOrdered()) {
			if (media.getTitle().equals(name)) {
				found = true;
				cart.removeMedia(media);
			}
		}
		if (found == false) {
			System.out.println("This media is not in cart");
		}
		cartMenu();
	}

    public static void cartMenu04() {
        System.out.println("Enter the title of the media: ");
		String name = scanner.nextLine();
        name = scanner.nextLine();
		boolean found = false;

		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(name)) {
				found = true;
				if (media instanceof CompactDisc){
					CompactDisc cd = (CompactDisc) media;
					cd.play();
				} else if (media instanceof DigitalVideoDisc){
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
				} else if (media instanceof Book) {
					System.out.println("Cannot play this media as it is a book");
				}
			}
		}
		if (!found) {
			System.out.println("This media is not in cart");
		}
		cartMenu();
    }
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);

        Book book1 = new Book("Harry Porter", 15.25f);
        store.addMedia(book1);

        Book book2 = new Book("Tu tuong HCM", 10000000.0f);
        store.addMedia(book2);

        CompactDisc cd1 = new CompactDisc("Control", 10.0f);
        store.addMedia(cd1);

        CompactDisc cd2 = new CompactDisc("Halo", 5.0f);
        store.addMedia(cd2);
        
		store.addMedia(dvd3);

        showMenu();
    }
}
