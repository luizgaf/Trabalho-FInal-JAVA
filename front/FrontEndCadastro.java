package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton.*;
import javax.swing.border.*;

public class FrontEndCadastro extends JPanel{

    private JButton adicionarButton, adcMembro, voltarButton;
    private JTextField endereco;
    private JSpinner risco;
    private JFrame parentFrame;

    public FrontEndCadastro(JFrame parentFrame){
        this.parentFrame = parentFrame;

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Cadastro de Família", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(label, BorderLayout.NORTH);

        JPanel inputs = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));

        endereco = new JTextField();
        endereco.setPreferredSize(new Dimension(200, 30));
        endereco.setText("Endereço");
        addPlaceholderText(endereco, "Endereço");
        inputs.add(endereco);

        risco = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1)); // valor inicial, mínimo, máximo, passo
        risco.setPreferredSize(new Dimension(200, 30));
        inputs.add(new JLabel("Nível de Risco:"));
        inputs.add(risco);

        inputs.add(endereco);
        add(inputs, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(buttonPanel, BorderLayout.SOUTH);

        adicionarButton = new JButton("Concluido");
        adcMembro = new JButton("Adicionar Membro");
        voltarButton = new JButton("Voltar");

        addHoverEffect(adicionarButton);
        addHoverEffect(adcMembro);
        addHoverEffect(voltarButton);

        adicionarButton.addActionListener(e -> adicionarFamilia());
        adcMembro.addActionListener(e -> adicionarMembro());
        voltarButton.addActionListener(e -> voltar());

        buttonPanel.add(adicionarButton);
        buttonPanel.add(adcMembro);
        buttonPanel.add(voltarButton);
    }

    private void addPlaceholderText(JTextField field, String placeholder) {
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                }
            }
        });
    }

    private void adicionarFamilia() {
        System.out.println("Família adicionada: " + endereco.getText() + ", Risco: " + risco.getValue());
    }

    private void adicionarMembro() {
        System.out.println("Membro adicionado");
    }

    private void voltar() {
        if (parentFrame != null) {
            parentFrame.dispose();
        }
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