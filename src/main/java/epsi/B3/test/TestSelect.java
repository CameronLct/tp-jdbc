package epsi.B3.test;
import epsi.B3.bo.Fournisseur;
import epsi.B3.dal.FournisseurDaoJdbc;
import java.sql.SQLException;
import java.util.List;

public class TestSelect {
    private FournisseurDaoJdbc fournisseurDaoJdbc;

    public TestSelect() {
        this.fournisseurDaoJdbc = new FournisseurDaoJdbc();
    }
    
    public List<Fournisseur> FindAll() throws SQLException {
        return this.fournisseurDaoJdbc.findAll();
    }
}
