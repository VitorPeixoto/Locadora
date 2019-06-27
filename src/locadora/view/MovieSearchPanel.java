package locadora.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import locadora.model.Movie;

public class MovieSearchPanel extends javax.swing.JPanel {
    private JTextField searchField;
    private JLabel title;
    private MovieListPanel moviePanel;
    private MovieDetailPanel aboutPanel;
    private JButton confirmBookings;
    
    // Lista com os ids dos livros selecionados para reservar
    private ArrayList<Integer> bookings;

    private static final String[] directorExample = {
        "Quentin Tarantino",
        "Alfred Hitchcock",
        "Stanley Kubrick",
        "Christopher Nolan",
        "Steven Speilberg"
    };
    
    private static final String[] movieExample = {
        "Pulp Fiction",
        "Psicose",
        "O Iluminado",
        "Interestelar",
        "O Resgate do Soldado Ryan"
    };
    
    private static final String[] synopsisExample = {
        "The lives of two mob hitmen, a boxer, a gangster & his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
        "A Phoenix secretary embezzles forty thousand dollars from her employer's client, goes on the run, and checks into a remote motel run by a young man under the domination of his mother.",
        "A family heads to an isolated hotel for the winter where a sinister presence influences the father into violence, while his psychic son sees horrific forebodings from both past and future.",
        "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
        "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action."
    };
    
    private static MovieSearchPanel singleInstance = null;
    
    public static MovieSearchPanel getInstance(Dimension size) {
        if(singleInstance == null)
            singleInstance = new MovieSearchPanel(size);
        return singleInstance;
    }
    
    public static MovieSearchPanel getInstance() {
        return singleInstance;
    }
    
    private MovieSearchPanel(Dimension size) {
        this.setSize(size);
        this.setLayout(null);
        
        bookings = new ArrayList<>();
        
        initComponents();
        
        title = new JLabel("Reserva de filmes");
        title.setFont(new java.awt.Font("Dialog", 1, 36));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        confirmBookings = new JButton("Confirmar reservas");
        confirmBookings.setEnabled(false);
        confirmBookings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //@TODO: Enviar ao banco as reservas contidas no ArrayList bookings;
            }
        });
        
        searchField = new JTextField("Pesquisar um filme");
        searchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                ArrayList<Movie> movies = new ArrayList<>();
                
                //@TODO: Buscar aqui os livros baseado no searchField.getText() (Remover o que for relacionado a teste;
                for(int i = 0; i < Math.random()*5; i++) {
                    int index = (int)(Math.random()*5);
                    movies.add(new Movie(0, movieExample[index], (int)(1980 + Math.random()*40), synopsisExample[index], directorExample[index]));
                }
                bookings.clear();
                confirmBookings.setEnabled(false);
                
                //@TODO: Enviar os livros buscados (ou uma lista vazia) para o painel de filmes;
                moviePanel.setMoviesOnPanel(movies);
                moviePanel.repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
                
        moviePanel = new MovieListPanel();
        
        aboutPanel = new MovieDetailPanel();
        aboutPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        this.addComponentsWithConstraints(size, 100);
    }

    public void setSelectedMovie(Movie movie) {
        aboutPanel.setMovieOnPanel(movie);
    }
    
    public void addBooking(int id) {
        bookings.add(id);
        confirmBookings.setEnabled(true);
    }
    
    public void removeBooking(int id) {
        bookings.remove(id);
        confirmBookings.setEnabled(bookings.size() > 0);
    }
    
    private void addComponentsWithConstraints(Dimension size, int insets) {
        JPanel insetPanel = new JPanel();
        insetPanel.setBounds(insets, insets, size.width - (2*insets), size.height - (2*insets));
        insetPanel.setLayout(new GridBagLayout());
        
	GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 2;
	gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
	gbc.weightx = 1;
        
        gbc.gridx = 0;
	gbc.gridy = 0;
	insetPanel.add(title, gbc);
        
	gbc.gridx = 0;
	gbc.gridy = 1;
	insetPanel.add(searchField, gbc);
        
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
	gbc.gridy = 3;
	insetPanel.add(confirmBookings, gbc);
        
        gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.BOTH;
	gbc.weighty = 1.0;
	gbc.gridx = 0;
	gbc.gridy = 2;        
	insetPanel.add(moviePanel, gbc);
        
        gbc.fill = GridBagConstraints.VERTICAL;
	gbc.weighty = 1.0;
        gbc.weightx = 0;
	gbc.gridx = 1;
	gbc.gridy = 2;
 
	insetPanel.add(aboutPanel, gbc);
        
        this.add(insetPanel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
