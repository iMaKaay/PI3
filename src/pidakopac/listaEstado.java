package pidakopac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class listaEstado {
    //Retorna a lista de estados cadastradas no formato String[]
    private DBcon banco;
    private ArrayList<String> lista;

    public String[] listaEstado() {
        String[] retorno = new String[this.lista.size()];
        for (int i = 0; i < this.lista.size(); i++) {
            retorno[i] = this.lista.get(i);
        }
        return retorno;
    }

    public void constroiLista(DBcon _banco) throws SQLException {
        banco = _banco;
        lista = new ArrayList();
        ResultSet rs = this.banco.exec("select nome_estado from estado order by upper(nome_estado)");//parametro upper usado para ignorar nao diferencias letras maiusculas e minusculas
        while (rs.next()) {
            lista.add(rs.getString("nome_estado"));
        }

    }
}
