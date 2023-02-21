package epsi.B3.test;
import epsi.B3.bo.Article;
import epsi.B3.bo.Fournisseur;
import epsi.B3.dal.ArticleDaoJdbc;
import epsi.B3.dal.FournisseurDaoJdbc;
import java.sql.SQLException;

public class TestJdbcArticles {
    private final FournisseurDaoJdbc fournisseurDaoJdbc;
    private final ArticleDaoJdbc articleDaoJdbc;

    public TestJdbcArticles(FournisseurDaoJdbc fournisseurDaoJdbc, ArticleDaoJdbc articleDaoJdbc) {
        this.fournisseurDaoJdbc = fournisseurDaoJdbc;
        this.articleDaoJdbc = articleDaoJdbc;
    }

    public void add() throws SQLException {
        Fournisseur fournisseur = new Fournisseur("La Maison de la Peinture");

        this.fournisseurDaoJdbc.add(fournisseur);
        
        fournisseur = this.fournisseurDaoJdbc.findAll().get(0);

        Article article1 = new Article("Peinture blanche 1L", 12.5, fournisseur);
        Article article2 = new Article("Peinture rouge mate 1L", 15.5, fournisseur);
        Article article3 = new Article("Peinture noire laquée 1L", 17.8, fournisseur);
        Article article4 = new Article("Peinture bleue mate 1L", 15.5, fournisseur);

        this.articleDaoJdbc.add(article1);
        this.articleDaoJdbc.add(article2);
        this.articleDaoJdbc.add(article3);
        this.articleDaoJdbc.add(article4);

        for (Article article : this.articleDaoJdbc.findAll()) {
            System.out.printf("%s; %f; %s%n", article.getName(), article.getPrice(), article.getFournisseur());
        }

        for (Article article : this.articleDaoJdbc.findAll()) {
            this.articleDaoJdbc.update(article , new Article(article.getName(), article.getPrice()*0.75, article.getFournisseur()));
        }

        System.out.println(this.articleDaoJdbc.getMoyenne());

        for (Article a : this.articleDaoJdbc.findAll()) {
            articleDaoJdbc.deleteById(a.getId());
        }

        for (Fournisseur f : this.fournisseurDaoJdbc.findAll()) {
            fournisseurDaoJdbc.deleteById(f.getId());
        }


    }
}