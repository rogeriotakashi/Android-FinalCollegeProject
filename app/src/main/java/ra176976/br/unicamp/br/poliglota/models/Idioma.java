package ra176976.br.unicamp.br.poliglota.models;

/**
 * Created by ROGERIO on 13/11/2017.
 */

public class Idioma {
    private int idIdioma;
    private String idioma;
    private String origem;

    public Idioma(int idIdioma,String idioma, String origem) {
        this.idioma = idioma;
        this.origem = origem;
        this.idIdioma = idIdioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getOrigem() {
        return origem;
    }
}
