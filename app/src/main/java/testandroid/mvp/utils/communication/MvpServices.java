package testandroid.mvp.utils.communication;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import testandroid.mvp.models.view.Vehicle;
import testandroid.mvp.models.view.VehicleView;


public interface MvpServices {
    @GET(Urls.VEHICLES)
    Call<RestView<VehicleView>> getContent(@Header("Authorization") String authorization);


}
