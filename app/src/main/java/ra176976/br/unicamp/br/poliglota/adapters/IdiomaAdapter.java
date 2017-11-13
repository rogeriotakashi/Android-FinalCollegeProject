package ra176976.br.unicamp.br.poliglota.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

/**
 * Created by ROGERIO on 13/11/2017.
 */

public class IdiomaAdapter extends BaseAdapter {
    private Context context;
    private List <Idioma> idiomas;

    public IdiomaAdapter(Context context, List<Idioma> albuns) {
        this.context = context;
        this.idiomas = albuns;
    }

    @Override
    public int getCount() {
        return idiomas.size();
    }

    @Override
    public Object getItem(int position) {
        return idiomas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Idioma idioma = idiomas.get(position);

        View linha = LayoutInflater.from(context).inflate(R.layout.idioma_line,null);

        ImageView img = (ImageView) linha.findViewById(R.id.imageView);
        TextView txt = (TextView) linha.findViewById(R.id.txtIdioma);
        txt.setText(idioma.getIdioma());


        Picasso.with(context).load(idioma.getOrigem()).into(img);

        return linha;
    }
}
