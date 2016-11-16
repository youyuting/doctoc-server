package north.sample.spark.user;

import com.avaje.ebean.Ebean;
import north.sample.domain.Book;
import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by yyou on 2016/11/8.
 */
public class GetUserRoute extends JsonTransformer {

    public GetUserRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        Book book = new Book();
        book.setTitle("Iam user book");
        return book;
    }
}
