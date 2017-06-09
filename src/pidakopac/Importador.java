package pidakopac;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.text.Normalizer;

public class Importador {

    private int insere;
    private DBcon banco;
    /*----------------Municipio-----------------*/
    private int id_municipio;
    private String nome_municipio = " ";
    /*----------------Empreendimento-----------------*/
    private String orgao_fiscalizador = " ";
    private String nome_empreendimento = " ";
    private double total_investido;
    private String executores = " ";
    private int id_estagio;
    private int id_digs;

    public String remove(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFKD).replaceAll("[^\\p{ASCII}]", "");
    }

    public void importar(String caminho, int _id_estado, String _ano) throws SQLException {
        BufferedReader buffer = null;
        String aux = null;
        try {
            String linhaAtual;
            String[] dados = new String[11];
            buffer = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), Charset.forName("ISO-8859-1")));
            buffer.readLine();
            while ((linhaAtual = buffer.readLine()) != null) {
                //Abre conexao
                banco = new DBcon("dako", "123456", "jdbc:oracle:thin:@localhost:1521:XE");
                dados = linhaAtual.split(";");
                try {
                    id_digs = Integer.parseInt(dados[1].replaceAll("[/'-,\"-]", ""));
                    nome_empreendimento = remove(dados[2].replaceAll("[/'-,\"-]", ""));
                    total_investido = Double.parseDouble(dados[5]);
                    nome_municipio = remove(dados[7].replaceAll("[/'-,\"-]", ""));
                    executores = remove(dados[8].replaceAll("[/'-,\"–]", ""));
                    orgao_fiscalizador = remove(dados[9].replaceAll("[/'-,\"-]", ""));
                    id_estagio = Integer.parseInt(dados[10].replaceAll("[/'-,\"-]", ""));
                    insere = 1;
                    if (dados[7].length() > 0 && dados[7].length() <= 100) {
                        aux = dados[7];
                    }
                    if (nome_empreendimento.length() == 0 || nome_empreendimento == "#") {
                        nome_empreendimento = "Sem Nome";
                    }
                } catch (NumberFormatException e) {
                    insere = 0;
                    System.out.println(_ano + "-CSV do " + banco.retornaCelula("select nome_estado from estado where id_estado=" + _id_estado) + " erro na linha de id igual a:" + dados[0]);
                }
                if (insere == 1) {
                    if (nome_municipio.isEmpty()) {
                        nome_municipio = aux;
                    }
                    if (!banco.jaExiste("select id_municipio from municipio where id_estado =" + _id_estado + "and UPPER(nome_municipio) ='" + nome_municipio.toUpperCase() + "'")) {
                        banco.exec("insert into municipio values(seq_id_municipio.nextval,'" + nome_municipio + "'," + _id_estado + ")");
                        id_municipio = Integer.parseInt(banco.retornaCelula("select id_municipio from municipio where id_estado =" + _id_estado + "and  UPPER(nome_municipio) ='" + nome_municipio.toUpperCase() + "'"));
                    } else {
                        id_municipio = Integer.parseInt(banco.retornaCelula("select id_municipio from municipio where id_estado =" + _id_estado + "and  UPPER(nome_municipio) ='" + nome_municipio.toUpperCase() + "'"));
                    }
                    banco.exec("insert into empreendimento values(seq_id_empreendimento.nextval,'" + orgao_fiscalizador + "','" + nome_empreendimento + "'," + total_investido + ",'" + executores + "'," + id_municipio + "," + _id_estado + "," + id_digs + "," + id_estagio + ",'" + _ano + "')");
                }
                //Fecha conexao
                banco.desconectar();
            }
            banco.desconectar();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
