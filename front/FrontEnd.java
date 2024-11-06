package front;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

public class FrontEnd extends JPanel{

    private JButton botaoDeposito;
    private JButton botaoSaque;
    private JButton botaoPix;
    
    public FrontEnd(){
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo ao Banco", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(label, BorderLayout.NORTH);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));

        botaoDeposito = new JButton("Depositar");
        botaoSaque = new JButton("Sacar");
        botaoPix = new JButton("Transferir");

        // Centralizando os botões
        botaoDeposito.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoPix.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSaque.setAlignmentX(Component.CENTER_ALIGNMENT);

        // cor e fonte
        addHoverEffect(botaoDeposito);
        addHoverEffect(botaoPix);
        addHoverEffect(botaoSaque);

        Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        botaoDeposito.setBorder(buttonBorder);
        botaoPix.setBorder(buttonBorder);
        botaoSaque.setBorder(buttonBorder);


         // Adicionando espaçamento entre os botões e o painel
        botoesPanel.add(botaoDeposito);
        botoesPanel.add(botaoPix);
        botoesPanel.add(botaoSaque);

        add(botoesPanel, BorderLayout.CENTER);

        botaoDeposito.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "TEste deposito");
            }
        });

        botaoPix.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "TEste Pix");
            }
        });

        botaoSaque.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "TEste Saque");
            }
        });
    }
    private void addHoverEffect(JButton button) {
        button.setBackground(new Color(50,50,50));
        button.setForeground(Color.white);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(120, 50));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.BLACK); 
                button.setForeground(Color.WHITE); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(50, 50, 50)); 
                button.setForeground(Color.WHITE); 
            }
        });
    }
}