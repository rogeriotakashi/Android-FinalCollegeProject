package ra176976.br.unicamp.br.poliglota.Associacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import ra176976.br.unicamp.br.poliglota.Poliglota.SelectPoliglota;
import ra176976.br.unicamp.br.poliglota.R;

public class InsertAssociacaoActivity extends AppCompatActivity {

    Spinner spNomes;
    Spinner spIdiomas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_associacao);

        spNomes = (Spinner) findViewById(R.id.spNomes);
        spIdiomas = (Spinner) findViewById(R.id.spIdiomas);

        SelectPoliglota selectPoliglota = new SelectPoliglota(this,spNomes);
        selectPoliglota.execute();


        spNomes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(InsertAssociacaoActivity.this,"ID:"+spNomes.getSelectedItemId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
