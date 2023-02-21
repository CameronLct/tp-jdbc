package epsi.B3.dal;
import java.sql.SQLException;
import java.util.List;
import epsi.B3.bo.Article;

public interface ArticleDao {
    void add(Article article) throws SQLException;
    List<Article> findAll() throws SQLException;

    void update(Article previousArticle, Article newArticle) throws SQLException;

    void deleteById(int articleId) throws SQLException;
}