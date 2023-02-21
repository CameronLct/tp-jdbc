package epsi.B3.bo;

public class Fournisseur {
    private int id;
    
    private String name;

    public Fournisseur(String name) {
        this.name = name;
    }
    public Fournisseur(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
