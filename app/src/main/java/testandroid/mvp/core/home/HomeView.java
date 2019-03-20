package testandroid.mvp.core.home;

import java.util.List;

import okhttp3.ResponseBody;
import testandroid.mvp.models.view.Vehicle;

public interface HomeView {
    void showProgress();
    void onSucces(List<Vehicle>list);
    void hideProgress();
    void showError(ResponseBody responseBody);
    void errorConnection();
}
