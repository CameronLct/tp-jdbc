package epsi.B3.dal;
import epsi.B3.bo.Article;
import epsi.B3.bo.Fournisseur;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.ArrayList;

public class ArticleDaoJdbc implements ArticleDao{
    private static final String INSERT_QUERY = "INSERT INTO article(NAME) VALUES(?)";
    private static final String SELECT_QUERY = "SELECT * FROM article";
    private static final String UPDATE_QUERY = "UPDATE article SET NAME=? WHERE ID=?";
    private static final String DELETE_ID_QUERY = "DELETE FROM article WHERE ID=?";
    private static final String GET_MOYENNE_REQ = "SELECT AVG(PRIX) as MOYENNE FROM article";
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
    public List<Article> findAll() throws SQLException {
        List<Article> articles = new ArrayList<>();

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
              PreparedStatement ps = cnx.prepareStatement(SELECT_QUERY);
              ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Integer fournisseurId = rs.getInt("fournisseurId");
                String fournisseurName = rs.getString("fournisseurName");
                Fournisseur fournisseur = new Fournisseur(fournisseurId, fournisseurName);
                Article article = new Article(id, name, price, fournisseur);
                articles.add(article);
            }
        }

        return articles;
    }
    @Override
    public void add(Article article) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
              PreparedStatement ps = cnx.prepareStatement(INSERT_QUERY)) {
            ps.setString(1, article.getName());
            ps.setDouble(2, article.getPrice());
            ps.setInt(3, article.getFournisseur().getId());
            ps.executeUpdate();
        }
    }
    @Override
    public void update(Article previousArticle, Article newArticle) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
              PreparedStatement ps = cnx.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, newArticle.getName());
            ps.setDouble(2, newArticle.getPrice());
            ps.setInt(3, newArticle.getFournisseur().getId());
            ps.setInt(4, previousArticle.getId());
            ps.executeUpdate();
        }
    }

    public void deleteById(int articleId) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
              PreparedStatement ps = cnx.prepareStatement(DELETE_ID_QUERY)) {
            ps.setString(1, String.valueOf(articleId));
            ps.executeUpdate();
        }
    }

    public Double getMoyenne() throws SQLException {
        double res = 0;
        try ( Connection cnx = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
              PreparedStatement ps = cnx.prepareStatement(GET_MOYENNE_REQ)) {
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                res = rs.getDouble("moyenne");
            }
        }
        return res;
    }
}

