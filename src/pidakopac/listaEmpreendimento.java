package pidakopac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class listaEmpreendimento {
    //Retorna a lista de empreendimento cadastradas no formato String[]
    private DBcon banco;
    private ArrayList<String> lista;

    public String[] listaEmpreendimento() {
        String[] retorno = new String[this.lista.size()];
        for (int i = 0; i < this.lista.size(); i++) {
            retorno[i] = this.lista.get(i);
        }
        return retorno;
    }

    public void constroiLista(DBcon _banco) throws SQLException {
        banco = _banco;
        lista = new ArrayList();
        ResultSet rs = this.banco.exec("select distinct nome_empreendimento from empreendimento order by upper(nome_empreendimento)");//parametro upper usado para ignorar nao diferencias letras maiusculas e minusculas
        while (rs.next()) {
            lista.add(rs.getString("nome_empreendimento"));
        }

    }
}
