package epsi.B3.bo;

public class Article {
    private int id;
    
    private String name;

    private Double price;

    private Fournisseur fournisseur;

    public Article(String name, Double price, Fournisseur fournisseur) {
        this.name = name;
    }
    public Article(int id, String name, Double price, Fournisseur fournisseur) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fournisseur = fournisseur;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}
