package ra176976.br.unicamp.br.poliglota;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import ra176976.br.unicamp.br.poliglota.Associacao.InsertAssociacaoActivity;
import ra176976.br.unicamp.br.poliglota.Poliglota.InsertPoliglotaActivity;
import ra176976.br.unicamp.br.poliglota.adapters.IdiomaAdapter;
import ra176976.br.unicamp.br.poliglota.models.Idioma;

public class MainActivity extends AppCompatActivity {


    ArrayList<Idioma> idiomas;
    IdiomaAdapter adapter;
    ListView listaIdiomas;

    DatabaseHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    Button btnInserirPoliglota;
    Button btnAssociar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        dbHelper = new DatabaseHelper(this);
        sqLiteDatabase = dbHelper.getReadableDatabase();
        idiomas = new ArrayList<>();
        listaIdiomas = (ListView) findViewById(R.id.lvIdioma);


        onSelecionar(listaIdiomas);


        btnInserirPoliglota = (Button)findViewById(R.id.btnInsert);
        btnInserirPoliglota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertPoliglotaActivity.class);
                startActivity(intent);
            }
        });
        btnAssociar = (Button) findViewById(R.id.btnAssociar);
        btnAssociar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertAssociacaoActivity.class);
                startActivity(intent);
            }
        });





    }

    public void onSelecionar(View view){
        String sql = "Select * from Idiomas";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            String str = "";
            do{
                int idIdioma = cursor.getInt(0);
                String idioma = cursor.getString(1);
                String origem = cursor.getString(2);

                idiomas.add(new Idioma(idIdioma,idioma,origem));
            }while(cursor.moveToNext());



        }
        adapter = new IdiomaAdapter(MainActivity.this,idiomas);
        listaIdiomas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
