package com.example.borja.aplicacionejemplotabsylistviews2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Borja on 28/10/2015.
 */
public class AdaptadorContactos extends ArrayAdapter<Contacto> {
    private Contacto[]datosContacto;
    public AdaptadorContactos(Context context, Contacto[]datosContacto) {
        super(context, R.layout.activity_main,datosContacto    );//R.layout.activity_main,datosWeb
        this.datosContacto=datosContacto;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*LayoutInflater inflater=LayoutInflater.from(getContext());

        View item=inflater.inflate(R.layout.lista_contactos, null);

        TextView tvNombreContacto=(TextView)item.findViewById(R.id.tvTituloContacto);
        tvNombreContacto.setText(datosContacto[position].getNombreContacto());

        TextView tvUrlWEb=(TextView)item.findViewById(R.id.tvNivk);
        tvUrlWEb.setText(datosContacto[position].getNick());

        ImageView imWeb=(ImageView)item.findViewById(R.id.imIconContactoContacto);
        imWeb.setImageResource(datosContacto[position].getImageIcon());

        return item;*/
        View item=convertView;
        ViewHolder holder;

        if(item==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            item=inflater.inflate(R.layout.lista_contactos, null);
            holder=new ViewHolder();
            holder.tvNombreContacto=(TextView)item.findViewById(R.id.tvTituloContacto);
            holder.tvUrlWEb=(TextView)item.findViewById(R.id.tvNivk);
            holder.imWeb=(ImageView)item.findViewById(R.id.imIconContactoContacto);
            item.setTag(holder);
        }else
            holder=(ViewHolder)item.getTag();
        holder.tvNombreContacto.setText(datosContacto[position].getNombreContacto());
        holder.tvUrlWEb.setText(datosContacto[position].getNick());
        holder.imWeb.setImageDrawable(datosContacto[position].getImageIcon());
        return item;
    }
    static class ViewHolder{
        TextView tvNombreContacto;
        TextView tvUrlWEb;
        ImageView imWeb;

    }
}