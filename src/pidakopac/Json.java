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

    public boolean exportar(int _id_estado, DBcon _banco) throws FileNotFoundException, UnsupportedEncodingException {

        //Realiza a exportação dos arquivos .json
        try {
            if (possuiDados(_banco, _id_estado)) {
                this.geraJson(_id_estado, _banco);
                showMessageDialog(null, "Dados exportados");
            } else {
                showMessageDialog(null, "Dados referentes ao estado \"" + _banco.retornaCelula("select nome_estado from estado where id_estado=" + _id_estado) + "\" são insuficientes para exportação!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    private void geraJson(int _id_estado, DBcon _banco) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        //Gera o arquivo JSON
        PrintWriter writer;
        writer = new PrintWriter(caminhoIndicadores + "\\" + (_id_estado + ".json"), "UTF-8");
        writer.println("{\"Dados\":{");
        writer.println("\"Em_licitação\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + _id_estado + " and ID_ESTAGIO = 40") + "\",");
        writer.println("\"Em_obras\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + _id_estado + " and ID_ESTAGIO = 70") + "\",");
        writer.println("\"Em_execução\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + _id_estado + " and ID_ESTAGIO = 71") + "\",");
        writer.println("\"Concluido\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + _id_estado + " and ID_ESTAGIO = 90") + "\",");
        writer.println("\"Total_Investido\":\"" + _banco.retornaCelula("select sum(total_investido) from empreendimento where id_estado =" + _id_estado) + "\"");
        writer.println("}}");
        writer.close();
    }

    private void geraJson(DBcon _banco) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        //Gera o arquivo JSON
        PrintWriter writer;
        writer = new PrintWriter(caminhoIndicadores + "\\" + ("Dados" + ".json"), "UTF-8");
        for (int i = 1; i <= 27; i++) {
            writer.println("{\"" + "Estado_" + i +"\":{");
            writer.println("\"Em_licitação\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + i + " and ID_ESTAGIO = 40") + "\",");
            writer.println("\"Em_obras\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + i + " and ID_ESTAGIO = 70") + "\",");
            writer.println("\"Em_execução\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + i + " and ID_ESTAGIO = 71") + "\",");
            writer.println("\"Concluido\":\"" + _banco.retornaCelula("select count(id_estagio) from empreendimento where id_estado =" + i + " and ID_ESTAGIO = 90") + "\",");
            writer.println("\"Total_Investido\":\"" + _banco.retornaCelula("select sum(total_investido) from empreendimento where id_estado =" + i) + "\"");
            if (i != 27) {
                writer.println("},");
            }
            if (i == 27) {
                writer.println("}}");
            }
        }
        writer.close();
    }

    public boolean exportar(DBcon _banco) throws FileNotFoundException, UnsupportedEncodingException {

        //Realiza a exportação dos arquivos .json
        try {
            this.geraJson(_banco);
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
