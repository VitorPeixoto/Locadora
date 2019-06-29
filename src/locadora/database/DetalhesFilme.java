package locadora.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import locadora.model.Movie;

/**
 *
 * @author brunodamacena
 */
public class DetalhesFilme {

    private Conexao con;
    
    public DetalhesFilme() {
        con = new Conexao();
    }
    
    public Movie getDetalhesFilme(String id_filme) {
        String sql = "SELECT F.nm_filme,F.nu_ano, F.tx_sinopse,D.nm_diretor " + 
        "FROM filme F " +
        "JOIN diretor D " + 
        "ON F.id_diretor = D.id_diretor " + 
        "WHERE F.id_filme = " + id_filme;
        
        Movie result = null;
        
        try {
            Statement stm = con.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.execute(sql);
            ResultSet rs = stm.getResultSet();
            rs.last();
            int i = rs.getRow();
            if (rs.getRow() > 0){
                rs.beforeFirst();
                while(rs.next()){
                    result = new Movie(
                        Integer.parseInt(id_filme),
                        rs.getString("nm_filme"),
                        Integer.parseInt(rs.getString("nu_ano")),
                        rs.getString("tx_sinopse"),
                        rs.getString("nm_diretor")
                    );
                    break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            con.fechaConexao();
        }
        
        return result;
    }
}
