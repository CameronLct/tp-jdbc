package epsi.B3.test;
import epsi.B3.bo.Fournisseur;
import epsi.B3.dal.FournisseurDaoJdbc;
import java.sql.SQLException;

public class TestUpdate {
    private FournisseurDaoJdbc fournisseurDaoJdbc;

    public TestUpdate() {
        this.fournisseurDaoJdbc = new FournisseurDaoJdbc();
    }
    
    public void Update(Fournisseur previousFournisseur, Fournisseur newFournisseur) throws SQLException {
        this.fournisseurDaoJdbc.update(previousFournisseur, newFournisseur);
    }
}
