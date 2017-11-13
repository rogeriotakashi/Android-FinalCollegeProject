package ra176976.br.unicamp.br.poliglota.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ra176976.br.unicamp.br.poliglota.R;
import ra176976.br.unicamp.br.poliglota.models.Idioma;
import ra176976.br.unicamp.br.poliglota.models.Poliglota;

/**
 * Created by ROGERIO on 13/11/2017.
 */

public class PoliglotaAdapter extends BaseAdapter {
    private Context context;
    private List<Poliglota> poliglotas;

    public PoliglotaAdapter(Context context, List<Poliglota> poliglotas) {
        this.context = context;
        this.poliglotas = poliglotas;
    }

    @Override
    public int getCount() {
        return poliglotas.size();
    }

    @Override
    public Object getItem(int i) {
        return poliglotas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return poliglotas.get(i).getIdPoliglota();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Poliglota poliglota = poliglotas.get(i);

        View linha = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,null);

        TextView txt = (TextView) linha.findViewById(android.R.id.text1);
        txt.setText(poliglota.getNomePoliglota());

        return linha;
    }
}
