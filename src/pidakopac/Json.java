package pidakopac;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

public class Json {

    String caminhoLista;
    String caminhoIndicadores;
    DBcon banco;

    public Json() throws IOException {
        config config = new config(); //----------
        config.carregar();//Checa o diretorio onde os dados devem ser salvos
        caminhoLista = config.getCaminhoSumario();//Json com a lista de empresas;
        caminhoIndicadores = config.getCaminhoIndicadores();//JSON com os dados calculados
    }

    private void geraJson(String ano) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        DBcon _banco = new DBcon("dako", "123456", "jdbc:oracle:thin:@localhost:1521:XE");
        //Gera o arquivo JSON
        PrintWriter writer;
        writer = new PrintWriter(caminhoIndicadores + "\\" + ("Dados do ano de " + ano + ".json"), "UTF-8");
        for (int i = 1; i <= 27; i++) {
            if (i == 1) {
                writer.println("{");
            }
            writer.println("\"" + "Estado_" + i + "\":{");
            writer.println("\"Em_licitação\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + i + " and ID_ESTAGIO = 40 and ano='" + ano + "'") + "\",");
            writer.println("\"Em_obras\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + i + " and ID_ESTAGIO = 70 and ano='" + ano + "'") + "\",");
            writer.println("\"Em_execução\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + i + " and ID_ESTAGIO = 71 and ano='" + ano + "'") + "\",");
            writer.println("\"Concluido\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + i + " and ID_ESTAGIO = 90 and ano='" + ano + "'") + "\",");
            writer.println("\"Total_Investido\":\"" + _banco.retornaCelula("select sum(total_investido) from empreendimento where id_estado =" + i + "and ano='" + ano + "'") + "\"}");
            if (i != 27) {
                writer.println(",");
            }
            if (i == 27) {
                writer.println("}");
            }
        }
        writer.close();
        _banco.desconectar();
    }

    public boolean exportar(String ano) throws FileNotFoundException, UnsupportedEncodingException {

        //Realiza a exportação dos arquivos .json
        try {
            this.geraJson(ano);
            showMessageDialog(null, "Dados exportados");
        } catch (SQLException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    private boolean possuiDados(DBcon _banco, int _id_estado) throws SQLException {
        //Consulta no banco de dados se o estado possui algum empreendimento
        return (_banco.retornaCelula("select nome_empreendimento from empreendimento where id_estado=" + _id_estado) != null);
    }
}
