package christmasBonus;

import java.util.*;

public class ChristmasLetter {
    Random rnd = new Random();
    private String name;
    private String address;

    private List<String> wishes;

    //Constructor
    public ChristmasLetter(String name, String address, List<String> wishes) {
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

    public List<String> getWishes() {
        return wishes;
    }

    public void setWishes(List<String> wishes) {
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

    public Map<String, Integer> wishesCount(){
        Map<String, Integer> counts = new HashMap<>();
        for (String s : wishes){
            int count  = counts.getOrDefault(s, 0);
            counts.put(s, count +1);
        }
        return counts;
    }

    public Set<String> removeDuplicates(){
        Set<String> uniqueWishes = new HashSet<>(wishes);
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
