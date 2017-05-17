package pidakopac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcon {
    private String DBURL;
    private String DBUSER;
    private String DBPASS;

    private Connection con;
    private Statement statement;
    private ResultSet rs;
    private PreparedStatement psmt;
    
    public Connection getCon(){
        return con;
    }
    
    public DBcon(String userDB, String senhaDB, String serverDB) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());//Realiza o carregamento do driver JBDC
        DBURL = serverDB;
        DBUSER = userDB;
        DBPASS = senhaDB;
        con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
    }
    
    public ResultSet exec(String query) throws SQLException {
        //Realiza a execução de query informadas em formato string e retorna seu resultado
        statement = con.createStatement();
        rs = statement.executeQuery(query);
        return rs;
    }

    public void desconectar() throws SQLException {
        //Realiza desconexão da sessão no banco de dados
        rs.close();
        statement.close();
        con.close();
    }

    public String retornaCelula(String _query) throws SQLException {
        //Retorna o valor de uma unica celular em formato de string
        String resultado = null;
        ResultSet tmp = this.exec(_query);
        if (tmp.next()) {
            resultado = tmp.getString(1);
        }
        return resultado;
    }

    public boolean jaExiste(String _query) throws SQLException {
        //Verifica se já existe algum registro no banco de dados para a query executada
        ResultSet tmp = this.exec(_query);
        if (tmp.next()) {
            if (tmp.getString(1) != null) {
                return true;
            }
        }
        return false;
    }
}
