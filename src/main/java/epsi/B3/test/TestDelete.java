package epsi.B3.test;
import epsi.B3.dal.FournisseurDaoJdbc;
import java.sql.SQLException;

public class TestDelete {
    private FournisseurDaoJdbc fournisseurDaoJdbc;

    public TestDelete() {
        this.fournisseurDaoJdbc = new FournisseurDaoJdbc();
    }
    
    public void Delete(int fournisseurId) throws SQLException {
        this.fournisseurDaoJdbc.deleteById(fournisseurId);
    }
}
