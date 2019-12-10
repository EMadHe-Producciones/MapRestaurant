package com.emadhe.maprestaurant.ListaRestaurants;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.emadhe.maprestaurant.R;
import com.emadhe.maprestaurant.Model.Feature;

import java.util.ArrayList;
import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.HolderLista> {
    
    private List<Feature> dataset = new ArrayList<>();
    private Context context;

    public ListaAdapter(Context c) {
        this.context = c;
    }

    public void addAllLugares(List<Feature> featureList){
        dataset.clear();
        dataset.addAll(featureList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderLista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new HolderLista(view);
    }
    @Override
    public void onBindViewHolder(@NonNull HolderLista holder, final int position) {
        holder.name.setText(dataset.get(position).getPlaceName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] arreglo = dataset.get(position).getPlaceName().split(" ");
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                View layout = LayoutInflater.from(context).inflate(R.layout.layout_dialog, null);
                TextView name = layout.findViewById(R.id.name);
                TextView type = layout.findViewById(R.id.text_type);
                TextView center = layout.findViewById(R.id.text_center);

                name.setText(arreglo[1] + arreglo [2]);
                type.setText(dataset.get(position).getType());
                String coordenadas = "Latitud: "+dataset.get(position).getCenter().get(1)
                        +" Longitud: "+dataset.get(position).getCenter().get(0);
                center.setText(coordenadas);

                dialog.setView(layout);
                dialog.show();
            }
        });

    }
    @Override
    public int getItemCount() {
        return dataset.size();
    }
    class HolderLista extends RecyclerView.ViewHolder{

        TextView text,name;

        HolderLista(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
