package testandroid.mvp.utils.communication;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MvpCallback<T> implements Callback<T> {
    private static String LOG_TAG = "TEST_MVP";
    public MvpCallback() {
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.d(LOG_TAG, String.valueOf(response));
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d(LOG_TAG, String.valueOf(t));
    }
}
