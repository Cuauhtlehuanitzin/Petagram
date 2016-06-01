package mx.unam.petagram.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.unam.petagram.R;
import mx.unam.petagram.pojo.Mascota;


/**
 * Created by Cuauhtlehuanitl on 12/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, FragmentActivity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    //Infla el layout y lo pasa al viewHolder, para que el obtenga cada elemento
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false); //Le da vida al layout (asocia con RecyclerView)
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de nuestra lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder MascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        MascotaViewHolder.imgFoto.setImageResource(mascota.getFoto()); //Foto del objeto actual
        MascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        MascotaViewHolder.tvLikesCV.setText(mascota.getLikes());

        MascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),Toast.LENGTH_SHORT).show();
                MascotaViewHolder.tvLikesCV.setText("22");
            }
        });

    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene mi lista de contactos(ReciclerView)
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageView btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV   = (TextView)  itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV    = (TextView)  itemView.findViewById(R.id.tvNumLikesCV);
            btnLike   = (ImageView) itemView.findViewById(R.id.imgLikes);
        }
    }


}
