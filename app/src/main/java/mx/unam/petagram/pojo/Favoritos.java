package mx.unam.petagram.pojo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import mx.unam.petagram.adapter.MascotaAdaptador;
import mx.unam.petagram.R;


public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

       /* Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFavoritos);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/


        rvMascotas = (RecyclerView) findViewById(R.id.rvFavoritos); //Manipulación del objeto definido en el layout, dentro de java

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);

        rvMascotas.setLayoutManager(llm); //El recyclerview se comporte como linearlayout
        //inicializarListaContactos();
        //inicializarAdaptador();
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador() {
        //adaptador = new MascotaAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.xolo, "Itzcuintli", "10"));
        mascotas.add(new Mascota(R.drawable.pastor, "Huitzi", "9"));
        mascotas.add(new Mascota(R.drawable.bulldog, "Miztli", "7"));
        mascotas.add(new Mascota(R.drawable.salchicha, "Hot dog", "4"));
        mascotas.add(new Mascota(R.drawable.chihuahua, "Grandote", "2"));

    }



}
