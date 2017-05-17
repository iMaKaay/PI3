package pidakopac;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;

public class PIdakoPAC extends Application {

    public static void main(String[] args) throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        TelaPrincipal menu = new TelaPrincipal();
        menu.setVisible(true);
        config config = new config();
        config.setTela(menu);
        config.carregar();
        DBcon banco = new DBcon(config.getUserDB(), config.getSenhaDB(), config.getServerDB());
        menu.setBanco(banco);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
