package north.sample.spark.doctor;

import com.avaje.ebean.Ebean;
import north.sample.domain.Doctor;
import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;

/**
 * Created by yyou on 2016/12/8.
 */
public class GetDoctorsRoute extends JsonTransformer {

    public GetDoctorsRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        return Ebean.find(Doctor.class).findList();
    }

}
