package north.sample.spark.consultation;

import com.avaje.ebean.Ebean;
import north.sample.domain.Consultation;
import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;

import java.io.IOException;

/**
 * Created by yyou on 2017/2/3.
 */

public class PostConsultationRoute extends JsonTransformer {

    public PostConsultationRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        Consultation consultation = null;
        try {
            consultation = mapper.readValue(request.body(), Consultation.class);
        } catch (IOException e) {

            response.status(500); // Server-side error

            return createErrorResponse("consultation couldn't be saved");
        }
        Ebean.save(consultation);
        response.status(201); // 201 Created
        return consultation;
    }
}
