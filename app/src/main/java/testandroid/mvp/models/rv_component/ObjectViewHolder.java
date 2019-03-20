package testandroid.mvp.models.rv_component;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import testandroid.mvp.R;

public class ObjectViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_name;
    public ObjectViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_name = itemView.findViewById(R.id.tv_name);
    }
}
