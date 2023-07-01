package englishlanguage;
import utility.services.ArticleService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The main feature of this class is to store internally (as a String) an english
 * article.
 * @since 1.0 SNAPSHOT
 * @author Arthur Brenno
 */
public class Article implements Word<String> {
   private final String article;

   /**
    * Constructor.
    * @param article will be set as instance variable.
    */
   private Article(String article) {
      this.article = article;
   }

   /**
    * Factory.
    * Creates a random Article object.
    * This object will contain, as its only instance variable, a random
    * english article.
    * @return An Article object. This object contains a random article as "article" instance variable
    */
   @Contract(" -> new")
   public static @NotNull Article createRandom() {
      return new Article(ArticleService.getInstance().getRandom());
   }

   /**
    * Factory. Creates an Article if the input is valid.
    * @return An Article object. This object will contain an article if the article provided is really an article.
    * @param article to be verified.
    * @throws RuntimeException the argument is not an article.
    */
   @Contract("_ -> new")
   public static @NotNull Article createArticle(String article) {
      if (ArticleService.getInstance().isArticle(article)) {
         throw new RuntimeException(String.format("%s is not an article.", article));
      }
      return new Article(article);
   }

   /**
    * Factory. Creates an article by the input or a random article.
    * @param article to be verified.
    * @return Article instance.
    */
   @Contract("_ -> new")
   public static @NotNull Article createOrRandom(String article) {
      ArticleService checker = ArticleService.getInstance();
      if (!checker.isArticle(article)) {
         return new Article(checker.getRandom());
      }
      return new Article(article);
   }

   /**
    * Getter.
    * @return the article that the object represents.
    */
   @Override
   public String getContent() {
      return article;
   }

}
