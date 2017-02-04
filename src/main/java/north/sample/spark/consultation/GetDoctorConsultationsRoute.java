package north.sample.spark.consultation;
import com.avaje.ebean.Ebean;
import north.sample.domain.Consultation;
import north.sample.spark.JsonTransformer;
import org.codehaus.jackson.map.ObjectWriter;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyou on 2017/2/3.
 */
public class GetDoctorConsultationsRoute extends JsonTransformer {
    public GetDoctorConsultationsRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        long doctorId = Long.parseLong(request.params("id"));
        List<Consultation> consultations = Ebean.find(Consultation.class).select("*")
                .fetch("doctor")
                .where()
                .eq("doctor.id", doctorId)
                .findList();
/*        long consultationId = Long.parseLong(request.params(":id"));
        Consultation consultation = Ebean.find(Consultation.class,consultationId);*/
        if (consultations != null) {
            return consultations;
        } else {
            response.status(404); // 404 Not found
            return createErrorResponse("Not found");
        }
    }
}
