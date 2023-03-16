package christmasBonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Wish> wishlist = new ArrayList<Wish>();

        boolean exit = false;
        System.out.println("What's your name?: ");
        String name = scan.nextLine();
        System.out.println("What's your address?: ");
        String address = scan.nextLine();
        System.out.println("Insert a new wish into the list: ");
        String wish = scan.nextLine();
        System.out.println("Insert the addressee of the wish: ");
        String addressee = scan.nextLine();
        wishlist.add(new Wish(wish, addressee));
        do {

            System.out.println("Do you want to insert another wish? (y/n)");
            String answer = scan.nextLine();

            if (answer.equals("y")){
                System.out.println("Insert a new wish into the list: ");
                String additionalWish = scan.nextLine();
                System.out.println("Insert the addressee of the wish: ");
                String additionalAddressee = scan.nextLine();
                wishlist.add(new Wish(additionalWish, additionalAddressee));
                System.out.println("You have inserted " + wishlist.size() + " wishes");
            } else if (answer.equals("n")){
                exit = true;
               /* Collections.sort(wishlist);*/
                System.out.println("This is your wishlist:");
                for(Wish item : wishlist) {
                    System.out.println("- " + item);
                }
            }

        } while (!exit);

        System.out.println("__________________");

        ChristmasLetter letter = new ChristmasLetter(name, address,wishlist);

        try {
            letter.send();
        } catch (WishException e ){
            System.out.println(e.getMessage());
        }

        System.out.println(letter.wishesCount());



    }
}