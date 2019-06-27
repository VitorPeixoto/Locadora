package locadora.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import locadora.model.Movie;

public class MovieDetailPanel extends javax.swing.JPanel {
    private JLabel title;
    private JLabel movieName, movieYear, movieDirector;
    private JTextArea movieSynopsis;
    
    public MovieDetailPanel() {
        initComponents();
        
        title = new JLabel("Detalhes");
        title.setFont(new java.awt.Font("Dialog", 1, 24));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        movieName = new JLabel("");
        movieName.setFont(new java.awt.Font("Dialog", 1, 14));
        movieYear  = new JLabel("");
        movieDirector = new JLabel("");        
        
        movieSynopsis = new JTextArea("Selecione um filme");
        movieSynopsis.setEditable(false);
        movieSynopsis.setColumns(50); 
        movieSynopsis.setRows(30);
        movieSynopsis.setLineWrap(true);
        
        this.addComponentsWithConstraints();
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

    private void addComponentsWithConstraints() {
        this.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
        
        c.anchor  = GridBagConstraints.NORTH;
        c.fill    = GridBagConstraints.HORIZONTAL;
	c.weightx = 1;
        
        c.gridx = 0;
	c.gridy = 0;
        this.add(title, c);
        
        c.gridx = 0;
	c.gridy = 1;
        this.add(movieName, c);
        
        c.gridx = 0;
	c.gridy = 2;
        this.add(movieYear, c);
        
        c.gridx = 0;
	c.gridy = 3;        
        this.add(movieDirector, c);
        
        c.gridx = 0;
	c.gridy = 4;
        c.weighty = 1;
        c.weightx = 0.3;
        this.add(movieSynopsis, c);
    }
    
    public void setMovieOnPanel(Movie movie) { 
        movieName.setText(movie.getName());
        movieYear.setText(""+movie.getAno());
        movieDirector.setText(movie.getDiretor());
        
        movieSynopsis.setText(movie.getSinopse());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
