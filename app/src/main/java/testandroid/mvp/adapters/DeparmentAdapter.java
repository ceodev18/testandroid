package testandroid.mvp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import testandroid.mvp.R;
import testandroid.mvp.models.view.Vehicle;
import testandroid.mvp.models.rv_component.ObjectViewHolder;

public class DeparmentAdapter extends RecyclerView.Adapter<ObjectViewHolder> {
    private List<Vehicle> list;
    private Context context;

    public DeparmentAdapter(Context context, List<Vehicle> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_deparment,parent,false);
        return new ObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectViewHolder holder, int position) {
        Vehicle item = list.get(position);
        holder.tv_name.setText(item.getAttributes().getName());
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Touched", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
