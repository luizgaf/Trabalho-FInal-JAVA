package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrontEndCadastro extends JPanel{

    private JButton adicionarButton, adcMembro, voltarButton;
    private JTextField endereco;
    private JComboBox<String> risco;
    private JFrame parentFrame;

    public FrontEndCadastro(JFrame parentFrame){
        this.parentFrame = parentFrame;

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Cadastro de Família", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(label, BorderLayout.NORTH);

        JPanel inputs = new JPanel(new FlowLayout());

        JPanel enderecoImput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        endereco = new JTextField();
        endereco.setPreferredSize(new Dimension(200, 30));
        endereco.setText("Endereço");
        addPlaceholderText(endereco, "Endereço");
        enderecoImput.add(new JLabel ("Endereço:"));
        enderecoImput.add(endereco);
        inputs.add(enderecoImput);

        JPanel riscoImput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        String[] riscoStrings = {"em risco", "risco alto", "risco extremo"};
        risco = new JComboBox<>(riscoStrings); 
        risco.setPreferredSize(new Dimension(150, 30));
        riscoImput.add(new JLabel("Nível de Risco:"));
        riscoImput.add(risco);
        inputs.add(riscoImput);
        
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
        System.out.println("Família adicionada: Endereço: " + (endereco.getText().equals("Endereço") ? "NULL" : endereco.getText()) + ", Risco: " + risco.getSelectedItem());
    }

    private void adicionarMembro() {
        JFrame adcMembro = new JFrame("Adição de Membro");
        adcMembro.setSize(800, 800);
        adcMembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel cadastroPanel = new FrontEndCadastroMembro(adcMembro);
        adcMembro.add(cadastroPanel);

        adcMembro.setLocationRelativeTo(null);
        adcMembro.setVisible(true);

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