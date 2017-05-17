package pidakopac;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

public class config {
    TelaPrincipal tela;

    //Configuração do banco de dados;
    private String userDB;
    private String senhaDB;
    private String serverDB;

    //Caminhos JSON
    private String caminhoSumario;
    private String caminhoCSV;

    public void setTela(TelaPrincipal _tela) {
        this.tela = _tela;
    }

    public void carregar() throws IOException {

        BufferedReader buffer;
        String linhaAtual;
        String[] confFile = new String[2];

        try {
            buffer = new BufferedReader(new FileReader("config.conf"));
            int i = 0;
            while ((linhaAtual = buffer.readLine()) != null) {
                confFile = linhaAtual.split("=", -1);
                switch (confFile[0]) {
                    case "senhaDB":
                        senhaDB = confFile[1];
                        i++;
                        break;
                    case "userDB":
                        userDB = confFile[1];
                        i++;
                        break;
                    case "serverDB":
                        serverDB = confFile[1];
                        i++;
                        break;
                    case "caminhoSumario":
                        caminhoSumario = confFile[1];
                        i++;
                        break;
                    case "caminhoIndicadores":
                        caminhoCSV = confFile[1];
                        i++;
                        break;
                }

            }
            if (i != 5) {
                showMessageDialog(null, "Falha ao carregar configuração");
            }
        } catch (FileNotFoundException ex) {
            showMessageDialog(null, "Arquivo de configuração não encontrado");
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public TelaPrincipal getTela() {
        return tela;
    }

    public String getUserDB() {
        return userDB;
    }

    public String getSenhaDB() {
        return senhaDB;
    }

    public String getServerDB() {
        return serverDB;
    }

    public String getCaminhoSumario() {
        return caminhoSumario;
    }

    public String getCaminhoIndicadores() {
        return caminhoCSV;
    }
}
