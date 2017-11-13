package ra176976.br.unicamp.br.poliglota.Poliglota;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import ra176976.br.unicamp.br.poliglota.adapters.PoliglotaAdapter;
import ra176976.br.unicamp.br.poliglota.models.Poliglota;

/**
 * Created by r176976 on 13/11/17.
 */

public class SelectPoliglota extends AsyncTask <Void,Void,String> {

    private Context context;
    private String[] fields;
    private String[] values;
    private static final String HOST = "http://es.ft.unicamp.br/ulisses/si700/select_data.php";

    Spinner spNomes;

    public SelectPoliglota(Context context, Spinner spNomes) {
        this.context = context;
        this.spNomes = spNomes;
        this.fields = fields;
    }

    @Override
    protected String doInBackground(Void... params) {
        HttpURLConnection httpURLConnection = null;

        try {
            String data =
                            URLEncoder.encode("database","UTF-8")+"="+
                            URLEncoder.encode("29_poliglota","UTF-8")+"&"+

                            URLEncoder.encode("table","UTF-8")+"="+
                            URLEncoder.encode("Poliglota","UTF-8");



            URL url = new URL(HOST);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            OutputStreamWriter wr = new OutputStreamWriter(httpURLConnection.getOutputStream());
            wr.write(data);
            wr.flush();


            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                sb.append(line);
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    protected void onPostExecute(String result) {

        ArrayList<Poliglota> poliglotas = new ArrayList<>();
        ArrayList<String> nomesPoliglotas = new ArrayList<>();

        try{
            JSONArray jsonArray = new JSONArray(result);


            for(int i = 0; i < jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Toast.makeText(context,jsonArray.toString(), Toast.LENGTH_LONG);

                Poliglota novoPoliglota = new Poliglota(jsonObject.getInt("idPoliglota"), jsonObject.getString("NomePoliglota"), jsonObject.getString("DataNascimento"));
                poliglotas.add(novoPoliglota);

                nomesPoliglotas.add(jsonObject.getString("NomePoliglota"));

            }

            PoliglotaAdapter adapter = new PoliglotaAdapter(context,poliglotas);
            spNomes.setAdapter(adapter);





        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
