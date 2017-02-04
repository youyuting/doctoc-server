package north.sample.spark.consultation;
import com.avaje.ebean.Ebean;
import north.sample.domain.Consultation;
import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;

import java.util.List;

/**
 * Created by yyou on 2017/2/3.
 */
public class GetPatientConsultationsRoute extends JsonTransformer {

    public GetPatientConsultationsRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        long patientId = Long.parseLong(request.params("id"));
        List<Consultation> consultation = Ebean.find(Consultation.class).select("*")
                .fetch("patient")
                .where()
                .eq("patient.id",patientId)
                .findList();
//            Consultation consultation = Ebean.find()
        if (consultation != null) {
            return consultation;
        } else {
            response.status(404); // 404 Not found
            return createErrorResponse("Not found");
        }
    }
}