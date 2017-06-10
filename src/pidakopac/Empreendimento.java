package pidakopac;

public class Empreendimento {
    private String nome_empreendimento;
    private String orgao_fiscalizador;
    private String executores;
    private double total_investido;
    private int id_digs;
    private int id_estagio;
    private int id_estado;
    private int id_municipio;
    private String ano;
    
    public void cadastro(String _orgao_fiscalizador, String _nome_empreendimento,double _total_investido, String _executores, int _id_municipio, int _id_estado, int _id_digs, int _id_estagio, String _ano) {
        orgao_fiscalizador = _orgao_fiscalizador;
        nome_empreendimento = _nome_empreendimento;
        total_investido = _total_investido;
        executores = _executores;
        id_municipio = _id_municipio;
        id_estado = _id_estado;
        id_digs = _id_digs;
        id_estagio = _id_estagio;
        ano = _ano;
    }

    public String getQuery() {
        String query = "INSERT INTO empreendimento VALUES (seq_id_empreendimento.nextval,'" + orgao_fiscalizador + "','" + nome_empreendimento + "'," + total_investido + ",'" + executores + "'," + id_municipio + "," + id_estado + "," + id_digs + "," + id_estagio + ",'" + ano + "')";
        return query;
    }
}
