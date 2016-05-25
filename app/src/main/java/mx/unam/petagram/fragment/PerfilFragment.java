package mx.unam.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.unam.petagram.R;
import mx.unam.petagram.adapter.MascotaAdaptador;
import mx.unam.petagram.adapter.PageAdapter;
import mx.unam.petagram.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvPerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Asigna la clase de java al layout fragment_recyclerview (layout dentro del objeto "v")
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfil = (RecyclerView) v.findViewById(R.id.rvPerfil01); //Manipulación del objeto definido en el layout dentro de java

        GridLayoutManager glm = new GridLayoutManager(this.getContext(), 3);

        rvPerfil.setLayoutManager(glm); //El recyclerview se comporte como linearlayout
        inicializarDatos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarDatos() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.puppy1, "1"));
        mascotas.add(new Mascota(R.drawable.puppy1, "2"));
        mascotas.add(new Mascota(R.drawable.puppy1, "3"));
        mascotas.add(new Mascota(R.drawable.puppy1, "4"));
        mascotas.add(new Mascota(R.drawable.puppy1, "5"));
        mascotas.add(new Mascota(R.drawable.puppy1, "6"));
        mascotas.add(new Mascota(R.drawable.puppy1, "7"));
        mascotas.add(new Mascota(R.drawable.puppy1, "8"));
        mascotas.add(new Mascota(R.drawable.puppy1, "9"));
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas,getActivity());
        rvPerfil.setAdapter(adaptador);
    }

}
