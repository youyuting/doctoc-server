package north.sample.spark.patient;

import com.avaje.ebean.Ebean;
import north.sample.domain.Patient;
import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yyou on 2016/11/14.
 */
public class PostPatientRoute extends JsonTransformer {
    public PostPatientRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        Patient patient = null;
        System.out.println("Creating account ...");
        System.out.println(request.body());
        try {
            patient = mapper.readValue(request.body(), Patient.class);
            System.out.println(patient);
            byte[] encodedPassword = MessageDigest.getInstance("SHA-256").digest(patient.getPassword().getBytes("UTF-8"));
            patient.setPassword(new String(encodedPassword, Charset.forName("UTF-8")));
            Ebean.save(patient);
            response.status(201); // 201 Created
            return patient;
        } catch (IOException | NoSuchAlgorithmException e) {
            System.out.println("error " +e.getMessage());
            response.status(500); // Server-side error
            return createErrorResponse("Patient couldn't be saved error was " + e.getMessage());
        }
    }
}
