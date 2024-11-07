package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton.*;
import javax.swing.border.*;

public class FrontEnd extends JPanel{
    
    private FrontEndCadastro cadastroPanel;

    private JButton verCadastro, adcCadastro;

    public FrontEnd(){
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Defesa Civil | Gerenciamento de Famílias", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(label, BorderLayout.NORTH);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));

        verCadastro = new JButton("Ver Cadastros");
        adcCadastro = new JButton("Adicionar Cadastros");

        addHoverEffect(verCadastro);
        addHoverEffect(adcCadastro);

        botoesPanel.add(verCadastro);
        botoesPanel.add(adcCadastro);

        add(botoesPanel, BorderLayout.CENTER);

        adcCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadastro();
            }
        });
    }

    private void janelaCadastro(){
        JFrame frameCadastro = new JFrame("Cadastro de Família");
        frameCadastro.setSize(800, 600);
        frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cadastroPanel = new FrontEndCadastro(frameCadastro);
        frameCadastro.add(cadastroPanel);

        frameCadastro.setLocationRelativeTo(null);
        frameCadastro.setVisible(true);
    }

    public void addHoverEffect(JButton button) {
        button.setBackground(new Color(50,50,50));
        button.setForeground(Color.white);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(200, 50));

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