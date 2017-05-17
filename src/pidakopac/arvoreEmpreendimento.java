package pidakopac;

import java.sql.ResultSet;
import java.sql.SQLException;

public class arvoreEmpreendimento {
    private noEmpreendimento noAtual;
    private DBcon banco;

    public arvoreEmpreendimento(DBcon banco) {
        noAtual = null;
        this.banco = banco;
    }

    private noEmpreendimento adicionaEmp(noEmpreendimento noAtual, String nome) {
        if (noAtual == null) {
            noAtual = new noEmpreendimento(nome);
        } else if (ordem(noAtual.getNome(), nome) < 0) {
            noAtual.setNoDir(adicionaEmp(noAtual.getNoDir(), nome));
        } else {
            noAtual.setNoEsq(adicionaEmp(noAtual.getNoEsq(), nome));
        }
        return noAtual;
    }

    public void adicionaEmp(String nome) {
        noAtual = adicionaEmp(noAtual, nome);
    }

    private int ordem(String _palavra01, String _palavra02) {
        return _palavra01.toLowerCase().compareTo(_palavra02.toLowerCase());
    }

    private String[] buscaNo(noEmpreendimento noAtual, String nome) throws SQLException {
        String[] resultado = new String[4];
        if (noAtual != null) {
            if (nome.toUpperCase().equals(noAtual.getNome().toUpperCase())) {
                ResultSet rs = banco.exec("select * from empreendimento where UPPER(nome_empreendimento)=UPPER('" + nome + "')");
                while (rs.next()) {
                    resultado[0] = rs.getString("ORGAO_FISCALIZADOR");
                    resultado[1] = rs.getString("NOME_EMPREENDIMENTO");
                    resultado[2] = rs.getString("EXECUTORES");
                    resultado[3] = rs.getString("TOTAL_INVESTIDO");
                }
            } else if (ordem(noAtual.getNome(), nome) > 0 && noAtual.getNoEsq() != null) {
                resultado = buscaNo(noAtual.getNoEsq(), nome);
            } else if (ordem(noAtual.getNome(), nome) < 0 && noAtual.getNoDir() != null) {
                resultado = buscaNo(noAtual.getNoDir(), nome);
            }
        }
        return resultado;
    }

    public String[] buscaNo(String nome) throws SQLException {
        return buscaNo(this.noAtual, nome);
    }
}
