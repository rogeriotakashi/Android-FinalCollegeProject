package ra176976.br.unicamp.br.poliglota.Poliglota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ra176976.br.unicamp.br.poliglota.R;

public class InsertPoliglotaActivity extends AppCompatActivity {

    EditText edNome;
    EditText edDtNascimento;
    Button btnInserirPoliglota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_poliglota);

        edNome = (EditText)findViewById(R.id.edNome);
        edDtNascimento = (EditText)findViewById(R.id.edDtNascimento);

        btnInserirPoliglota = (Button)findViewById(R.id.btnInsertPoliglota);

        btnInserirPoliglota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] fields = new String[2];
                String[] values = new String[2];
                fields[0] = "NomePoliglota";
                fields[1] = "DataNascimento";

                values[0] = edNome.getText().toString();
                values[1] = edDtNascimento.getText().toString();


                if (values[0].matches("")) {
                    Toast.makeText(InsertPoliglotaActivity.this, "Nome Vazio!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (values[1].matches("")) {
                    Toast.makeText(InsertPoliglotaActivity.this, "Data Nascimento Vazio!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    InsertPoliglota ip = new InsertPoliglota(fields, values);
                    ip.execute();

                    Toast.makeText(InsertPoliglotaActivity.this, "Poliglota inserido com sucesso!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}
