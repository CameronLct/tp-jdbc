package epsi.B3;
import epsi.B3.bo.Fournisseur;
import epsi.B3.dal.ArticleDaoJdbc;
import epsi.B3.dal.FournisseurDaoJdbc;
import epsi.B3.test.TestDelete;
import epsi.B3.test.TestSelect;
import epsi.B3.test.TestInsertion;
import epsi.B3.test.TestJdbcArticles;
import epsi.B3.test.TestUpdate;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class Main {
    private static final String DB_URL;
    private static final String DB_LOGIN;
    private static final String DB_PWD;

    static {
        System.out.println("Chargement de la classe");
        ResourceBundle bundle = ResourceBundle.getBundle("db");

        DB_URL = bundle.getString("db.url");
        DB_LOGIN = bundle.getString("db.login");
        DB_PWD= bundle.getString("db.password");
    }
    public static void main(String[] args) {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
             Statement st = cnx.createStatement();) {
            
            TestInsertion test1 = new TestInsertion();
            test1.Insert(new Fournisseur("La maison de la peinture"));

            TestUpdate test2= new TestUpdate();
            test2.Update(new Fournisseur(1, "La maison de la peinture"), new Fournisseur("La cabane de la peinture"));

            TestSelect test3 = new TestSelect();
            List<Fournisseur> listFournisseurs = test3.FindAll();
            System.out.println(listFournisseurs.size());

            TestDelete test4= new TestDelete();
            test4.Delete(1);

            TestJdbcArticles test = new TestJdbcArticles(new FournisseurDaoJdbc(), new ArticleDaoJdbc());
            test.add();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello world!");
    }
}