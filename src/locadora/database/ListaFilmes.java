package locadora.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import locadora.model.Movie;

/**
 *
 * @author brunodamacena
 */
public class ListaFilmes {
    private Conexao con;
    
    public ListaFilmes() {
        con = new Conexao();
    }
    
    public ArrayList<Movie> getListaFilmes() {
        String sql = "SELECT F.nm_filme,F.nu_ano,F.id_filme, F.tx_sinopse, D.nm_diretor " +
        "FROM filme F " +
        "WHERE id_filme NOT IN (SELECT AF.id_filme " +
        "FROM alguelfilme AF " +
        "JOIN aluguel A " +
        "ON A.id_aluguel = AF.id_aluguel " +
        "JOIN diretor D " +
        "ON D.id_diretor = F.id_diretor " +
        "WHERE now() BETWEEN A.dt_aluguel AND A.dt_devolucao);";
        
        ArrayList<Movie> result = new ArrayList<Movie>();
        
        try {
            Statement stm = con.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.execute(sql);
            ResultSet rs = stm.getResultSet();
            rs.last();
            int i = rs.getRow();
            Movie movie = null;
            if (rs.getRow() > 0){
                rs.beforeFirst();
                while(rs.next()){
                    movie = new Movie(
                        Integer.parseInt(rs.getString("id_filme")),
                        rs.getString("nm_filme"),
                        Integer.parseInt(rs.getString("nu_ano")),
                        rs.getString("tx_sinopse"),
                        rs.getString("nm_diretor")
                    );
                    result.add(movie);
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
