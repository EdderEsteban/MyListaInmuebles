package com.ddrssoft.mylistainmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ddrssoft.mylistainmuebles.modelo.Inmueble;

import java.util.List;

public class InmuebleAdapter extends ArrayAdapter {
    // Declaracion de Variales Encapsuladas
    private Context contexto;
    private List<Inmueble> listadoInmueble;
    private LayoutInflater inflador;

    // Constructor
    public InmuebleAdapter(@NonNull Context contexto, int resource, List<Inmueble> listadoInmueble, LayoutInflater inflador) {
        super(contexto, resource, listadoInmueble);
        this.contexto = contexto;
        this.listadoInmueble = listadoInmueble;
        this.inflador = inflador;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = inflador.inflate(R.layout.item, parent, false);
        }
        Inmueble propiedad = listadoInmueble.get(position);
        ImageView foto = itemView.findViewById(R.id.foto);
        TextView direccion = itemView.findViewById(R.id.TVDireccion);
        TextView precio = itemView.findViewById(R.id.TVPrecio);
        foto.setImageResource(propiedad.getFoto());
        direccion.setText(propiedad.getDireccion());
        precio.setText(propiedad.getPrecio()+"");

        return itemView;
    }
}