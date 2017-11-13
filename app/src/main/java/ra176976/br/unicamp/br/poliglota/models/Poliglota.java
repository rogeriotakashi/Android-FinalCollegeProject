package ra176976.br.unicamp.br.poliglota.models;

/**
 * Created by ROGERIO on 13/11/2017.
 */

public class Poliglota {
    private int idPoliglota;
    private String nomePoliglota;
    private String dataNascimento;

    public Poliglota(int idPoliglota, String nomePoliglota, String dataNascimento) {
        this.idPoliglota = idPoliglota;
        this.nomePoliglota = nomePoliglota;
        this.dataNascimento = dataNascimento;
    }

    public int getIdPoliglota() {
        return idPoliglota;
    }

    public String getNomePoliglota() {
        return nomePoliglota;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}
