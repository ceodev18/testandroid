package testandroid.mvp.core.home;

import android.content.Context;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import testandroid.mvp.models.view.Vehicle;
import testandroid.mvp.models.view.VehicleView;
import testandroid.mvp.utils.communication.MvpCallback;
import testandroid.mvp.utils.communication.RestClient;
import testandroid.mvp.utils.communication.RestView;

public class HomeInteractor implements HomePresenter {
    private Context context;
    private HomeView homeView;


    public HomeInteractor(HomeView homeView, Context context){
        this.homeView = homeView;
        this.context = context;
    }
    @Override
    public void retrieveInformation() {
        homeView.showProgress();

        Call<RestView<VehicleView>>call = new RestClient().getWebServices().getContent("");
        call.enqueue(new MvpCallback<RestView<VehicleView>>(){
            @Override
            public void onResponse(Call<RestView<VehicleView>> call, Response<RestView<VehicleView>> response) {
                super.onResponse(call, response);
                homeView.hideProgress();
                RestView<VehicleView> answer = response.body();
                if(answer!=null){
                    VehicleView vehicleView = answer.getBody();
                    homeView.onSucces(vehicleView.getVehicle_list());
                }
            }

            @Override
            public void onFailure(Call<RestView<VehicleView>> call, Throwable t) {
                super.onFailure(call, t);
                homeView.hideProgress();
            }
        });
    }
}
