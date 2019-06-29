package locadora.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import locadora.model.Actor;

/**
 *
 * @author brunodamacena
 */
public class ListaAtoresFilme {
    private Conexao con;

    public ListaAtoresFilme() {
        con = new Conexao();
    }
    
    public ArrayList<Actor> getAtoresFilme(String id_filme) {
        String sql = "SELECT A.nm_ator,ATU.nm_papel " +
        "FROM filme F " +
        "JOIN atuacao ATU " +
        "ON ATU.id_filme = F.id_filme " +
        "JOIN ator A " +
        "ON A.id_ator = ATU.id_ator " +
        "WHERE F.id_filme = " + id_filme;
        
        ArrayList<Actor> result = new ArrayList<Actor>();
        
        try {
            Statement stm = con.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.execute(sql);
            ResultSet rs = stm.getResultSet();
            rs.last();
            int i = rs.getRow();
            Actor actor = null;
            if (rs.getRow() > 0){
                rs.beforeFirst();
                while(rs.next()){
                    actor = new Actor(
                        rs.getString("nm_ator"),
                        rs.getString("nm_papel")
                    );
                    result.add(actor);
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
