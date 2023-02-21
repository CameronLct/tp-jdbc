package epsi.B3.dal;
import epsi.B3.bo.Fournisseur;
import java.util.List;
import java.sql.SQLException;

public interface FournisseurDao {
    void add(Fournisseur fournisseur) throws SQLException;
    List<Fournisseur> findAll() throws SQLException;

    void update(Fournisseur previousFournisseur, Fournisseur newFournisseur) throws SQLException;

    void deleteById(int fournisseurId) throws SQLException;
}
