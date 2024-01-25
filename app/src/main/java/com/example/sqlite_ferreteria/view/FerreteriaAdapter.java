package com.example.sqlite_ferreteria.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_ferreteria.R;
import com.example.sqlite_ferreteria.controller.CtrlFerreteria;
import com.example.sqlite_ferreteria.model.Producto;
import java.util.List;

public class FerreteriaAdapter extends RecyclerView.Adapter<FerreteriaAdapter.ViewHolder> {
    private List<Producto> ferretriaList;

    public FerreteriaAdapter(Context context) {
        this.ferretriaList = CtrlFerreteria.getProducto(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ferreteria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = ferretriaList.get(position);
        holder.tvNombre.setText("Nombre" + producto.getNombre());
        holder.tvStock.setText("Stock: " + producto.getStock());
        holder.tvPrecio.setText("Precio: " + producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return ferretriaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvStock, tvPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvStock = itemView.findViewById(R.id.tvStock);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }
}
