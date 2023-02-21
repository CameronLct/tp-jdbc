package epsi.B3.dal;
import epsi.B3.bo.Fournisseur;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.ArrayList;

public class FournisseurDaoJdbc implements FournisseurDao{
    private static final String INSERT_QUERY = "INSERT INTO fournisseur(NAME) VALUES(?)";
    private static final String SELECT_QUERY = "SELECT * FROM fournisseur";
    private static final String UPDATE_QUERY = "UPDATE fournisseur SET NAME=? WHERE ID=?";
    private static final String DELETE_ID_QUERY = "DELETE FROM fournisseur WHERE ID=?";
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.login");
        DB_PWD = bundle.getString("db.password");
    }

    @Override
    public List<Fournisseur> findAll() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
              PreparedStatement ps = cnx.prepareStatement(SELECT_QUERY);
              ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                Fournisseur fournisseur = new Fournisseur(id, name);
                fournisseurs.add(fournisseur);
            }
        }

        return fournisseurs;
    }
    @Override
    public void add(Fournisseur fournisseur) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
              PreparedStatement ps = cnx.prepareStatement(INSERT_QUERY)) {
            ps.setString(1, fournisseur.getName());
            ps.executeUpdate();
        }
    }
    @Override
    public void update(Fournisseur previousFournisseur, Fournisseur newFournisseur) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
              PreparedStatement ps = cnx.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, newFournisseur.getName());
            ps.setInt(2, previousFournisseur.getId());
            ps.executeUpdate();
        }
    }

    public void deleteById(int fournisseurId) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
              PreparedStatement ps = cnx.prepareStatement(DELETE_ID_QUERY)) {
            ps.setString(1, String.valueOf(fournisseurId));
            ps.executeUpdate();
        }
    }
}

