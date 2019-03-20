package testandroid.mvp.ui.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import testandroid.mvp.R;
import testandroid.mvp.adapters.DeparmentAdapter;
import testandroid.mvp.core.home.HomeInteractor;
import testandroid.mvp.core.home.HomePresenter;
import testandroid.mvp.core.home.HomeView;
import testandroid.mvp.models.view.Vehicle;
import testandroid.mvp.utils.CommonMethods;

public class HomeFragment extends Fragment implements HomeView {
    private static HomeFragment instance;
    private static String LOG_FAIL_CONNECTION = "La conexión ha fallado";
    //attributes
    private ProgressDialog progressDialog;
    private RecyclerView rv_content;
    private View mainView;
    private HomePresenter homePresenter;

    //Singleton constructor
    public static HomeFragment newInstance() {
        if(instance==null) instance = new HomeFragment();
        return  instance;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView =  inflater.inflate(R.layout.fragment_login, container, false);
        bindViews(mainView);
        setContent();
        return mainView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgress() {
        progressDialog = CommonMethods.createProgressDialog(getContext(),
                getContext().getString(R.string.s_loading));
        progressDialog.show();
    }

    @Override
    public void onSucces(List<Vehicle> list) {
        DeparmentAdapter deparmentAdapter = new DeparmentAdapter(getContext(),list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_content.setLayoutManager(layoutManager);
        rv_content.setAdapter(deparmentAdapter);
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void showError(ResponseBody responseBody) {
        try {
            JSONObject jObjError = new JSONObject(responseBody.string());
            Toast.makeText(getContext(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void errorConnection() {
        Toast.makeText(getContext(), LOG_FAIL_CONNECTION, Toast.LENGTH_SHORT).show();
    }

    private void bindViews(View mainView){
        homePresenter = new HomeInteractor(HomeFragment.this,getContext());
        rv_content = mainView.findViewById(R.id.rv_content);
        rv_content.setHasFixedSize(true);
    }
    private void setContent(){
        homePresenter.retrieveInformation();
    }
}
