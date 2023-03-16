package christmasBonus;

import java.util.*;

public class ChristmasLetter {
    Random rnd = new Random();
    private String name;
    private String address;

    private List<Wish> wishes;

    //Constructor
    public ChristmasLetter(String name, String address, List<Wish> wishes) {
        this.name = name;
        this.address = address;
        this.wishes = wishes;
    }

    //S/Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }


    //Methods
    public void send() throws WishException {
        boolean good = rnd.nextBoolean();

        if (wishes.size() > 5){
            throw new WishException("List exceeds the maximum amount of wishes (5)");
        }

        if (good){
            System.out.println("Your letter has been sent. This is the letter: ");
            System.out.println(toString());
        }

        if (!good){
            throw new WishException("Sorry you have been judged evil, your letter cannot be sent");
        }


    }

    public Map<Wish, Integer> wishesCount(){
        Map<Wish, Integer> counts = new HashMap<>();
        for (Wish s : wishes){
            counts.putIfAbsent(s, 0);
           counts.put(s, counts.get(s) +1);
        }
        return counts;
    }

    public Set<Wish> removeDuplicates(){
        Set<Wish> uniqueWishes = new HashSet<>(wishes);
        return uniqueWishes;
    }





    @Override
    public String toString() {
        return "ChristmasLetter:" + "\n" +
                "name = " + name + "\n" +
                "address =" + address + '\n' +
                "wishes = " + wishes;
    }
}
