package testandroid.mvp.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import testandroid.mvp.R;


public class CommonMethods {


    public static ProgressDialog createProgressDialog(Activity activity, String message) {
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        return progressDialog;
    }
    public static ProgressDialog createProgressDialog(Context activity, String message) {
        final ProgressDialog progressDialog = new ProgressDialog(activity , R.style.MyAlertDialogStyle);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        return progressDialog;
    }

}

