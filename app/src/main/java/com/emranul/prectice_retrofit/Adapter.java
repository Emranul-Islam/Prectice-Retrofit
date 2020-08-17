package com.emranul.prectice_retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<DataHolderObject> list;

    public Adapter(Context context, List<DataHolderObject> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.resource.setText(list.get(position).getResource());
        holder.id.setText(list.get(position).getId());
        holder.updated_at.setText(list.get(position).getUpdated_at());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, resource, id, updated_at;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.raw_name);
            resource = itemView.findViewById(R.id.raw_resource);
            id = itemView.findViewById(R.id.raw_id);
            updated_at = itemView.findViewById(R.id.raw_updated_at);
        }
    }
}
