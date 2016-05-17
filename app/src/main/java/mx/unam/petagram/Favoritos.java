package mx.unam.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFavoritos);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaMascotas = (RecyclerView) findViewById(R.id.rvFavoritos); //Manipulación del objeto definido en el layout, dentro de java

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);

        listaMascotas.setLayoutManager(llm); //El recyclerview se comporte como linearlayout
        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
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
