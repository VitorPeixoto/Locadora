package locadora.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import locadora.model.Movie;

public class MovieListPanel extends javax.swing.JPanel {
    private GridBagConstraints gbc;
    private ArrayList<MovieElementPanel> moviePanels;
    private MouseListener listener;
    
    public MovieListPanel() {
        initComponents();
        moviePanels = new ArrayList<>();
        
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        this.setConstraints();
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
    
    private void setConstraints() {
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();

	gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.weightx = 1;
        
        int inset = 2;
        gbc.insets = new Insets(inset, inset, inset, inset);
    }
    
    public void setMoviesOnPanel(ArrayList<Movie> movies) { 
        moviePanels.forEach(
            (MovieElementPanel mep) -> this.remove(mep)
        );
        moviePanels = new ArrayList<>();
        
        for (int i = 0; i < movies.size(); i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            if(i == movies.size() - 1) gbc.weighty = 1;
            MovieElementPanel mep = new MovieElementPanel(movies.get(i));
            mep.addMouseListener(listener);
            moviePanels.add(mep);
            this.add(mep, gbc);            
        }
        
        this.validate();
        
        gbc.weighty = 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
