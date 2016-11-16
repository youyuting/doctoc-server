package north.sample.spark.doctor;

import com.avaje.ebean.Ebean;
import north.sample.domain.Book;
import north.sample.domain.Doctor;
import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;

import java.io.IOException;

/**
 * Created by yyou on 2016/11/14.
 */
public class PostDoctorRoute extends JsonTransformer {
    public PostDoctorRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        Doctor doctor = null;
        try {
            doctor = mapper.readValue(request.body(), Doctor.class);
        } catch (IOException e) {

            response.status(500); // Server-side error

            return createErrorResponse("Doctor couldn't be saved");
        }
        Ebean.save(doctor);
        response.status(201); // 201 Created
        return doctor;
    }


}
