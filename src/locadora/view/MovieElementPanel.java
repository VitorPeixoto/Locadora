package locadora.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import locadora.model.Movie;

public class MovieElementPanel extends javax.swing.JPanel {
    private JLabel nome, ano, nomeDiretor;
    private JTextArea sinopse;
    private JCheckBox bookingCheckbox;
    
    private Movie movie;
    
    public MovieElementPanel(Movie movie) {
        initComponents();
        
        this.movie = movie;
        
        nome = new JLabel(movie.getName());
        nome.setFont(new java.awt.Font("Dialog", 1, 14));
        
        ano  = new JLabel(""+movie.getAno());
        
        nomeDiretor = new JLabel(movie.getDiretor());
        
        sinopse = new JTextArea(movie.getSinopse());
        sinopse.setEditable(false);
        
        bookingCheckbox = new JCheckBox();
        bookingCheckbox.setText("Reservar");
        bookingCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bookingCheckbox.isSelected()) {
                    MovieSearchPanel.getInstance().addBooking(movie.getId());
                }
                else {
                    MovieSearchPanel.getInstance().removeBooking(movie.getId());
                }
            }
        });
        
        
        this.addComponentsWithConstraints();
        this.setBorder(BorderFactory.createEtchedBorder());
        
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MovieSearchPanel.getInstance().setSelectedMovie(MovieElementPanel.this.movie);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    private void addComponentsWithConstraints() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.anchor  = GridBagConstraints.NORTH;
        c.fill    = GridBagConstraints.HORIZONTAL;
	c.weightx = 1;
        
        c.gridx = 0;
	c.gridy = 0;
        this.add(nome, c);
        
        c.gridx = 0;
	c.gridy = 1;
        this.add(ano, c);
        
        c.gridx = 1;
	c.gridy = 1;
        c.weightx = 0.05;
        this.add(bookingCheckbox, c);
        
        c.gridx = 0;
	c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        this.add(nomeDiretor, c);
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
