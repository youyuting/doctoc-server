package north.sample.spark.doctor;
import com.avaje.ebean.Ebean;
import north.sample.domain.Book;
import north.sample.domain.Doctor;
import north.sample.domain.Patient;
import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;
import spark.utils.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

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
        System.out.println("Creating account ...");
        System.out.println(request.body());
        //System.out.println(request.params("password"));
        try {
            doctor = mapper.readValue(request.body(), Doctor.class);
            System.out.println("password");
            System.out.println(doctor.getPassword());
            if(doctor.getPassword()!= null )
            {
                if(doctor.getLastName()!= null)
                {
                    if(doctor.getFirstName()!= null)
                    {

                    }
                    else
                    {
                        response.status(400);
                        return "FirstName is mandatory !!";
                    }
                }
                else
                {
                    response.status(400);
                    return "LastName is mandatory !!";
                }
            }
            else
            {
                response.status(400);
                return "Password is mandatory !!";
            }

/*            try {
                Part uploaded_file = request.raw().getPart("uploaded_file");
                if (uploaded_file != null) {
                    try (InputStream is = request.raw().getPart("uploaded_file").getInputStream()) {
                        // Use the input stream to create a file
                        byte[] byteArray = org.apache.commons.io.IOUtils.toByteArray(is);
                        doctor.setPicture(byteArray);
                    }
                }
            }
            catch (ServletException e) {
                e.printStackTrace();
            }*/
        } catch (IOException e) {

            response.status(500); // Server-side error
            return createErrorResponse("Doctor couldn't be saved");
        }
        Ebean.save(doctor);
        response.status(201); // 201 Created
        return doctor;
    }
}
