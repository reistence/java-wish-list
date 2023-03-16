package christmasBonus;

public class Wish {
    private String name;
    private String addressee;

    public Wish(String name, String addressee) {
        this.name = name;
        this.addressee = addressee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wish wish = (Wish) o;

        if (getName() != null ? !getName().equals(wish.getName()) : wish.getName() != null) return false;
        return getAddressee() != null ? getAddressee().equals(wish.getAddressee()) : wish.getAddressee() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAddressee() != null ? getAddressee().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wish: " + "name='" + name + '|' + "addressee=" + addressee ;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }
}
