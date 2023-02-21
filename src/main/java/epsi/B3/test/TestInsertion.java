package epsi.B3.test;
import epsi.B3.bo.Fournisseur;
import epsi.B3.dal.FournisseurDaoJdbc;
import java.sql.SQLException;

public class TestInsertion {
    private FournisseurDaoJdbc fournisseurDaoJdbc;

    public TestInsertion() {
        this.fournisseurDaoJdbc = new FournisseurDaoJdbc();
    }

    public void Insert(Fournisseur fournisseur) throws SQLException {
        this.fournisseurDaoJdbc.add(fournisseur);
    }
}
