package front;

import java.awt.*;
import javax.swing.*;

public class FrontEndCadastroMembro extends JPanel{
    
    public FrontEndCadastroMembro(JFrame frame){
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Cadastro Membro", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(label, BorderLayout.NORTH);

        JPanel inputs = new JPanel(new FlowLayout());
        
        JPanel nomePanel = new JPanel(new FlowLayout());
        JLabel name = new JLabel("Nome Completo:");
        nomePanel.add(name);
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(600, 30));
        nomePanel.add(nameField);

        JPanel dataPanel = new JPanel(new FlowLayout());
        JLabel cpf = new JLabel("CPF:");
        dataPanel.add(cpf);
        JTextField cpfField = new JTextField();
        cpfField.setPreferredSize(new Dimension(200, 30));
        dataPanel.add(cpfField);

        JLabel birthDate = new JLabel("Data de Nascimento:");
        JTextField bDField = new JTextField();
        bDField.setPreferredSize(new Dimension(200, 30));
        dataPanel.add(birthDate); dataPanel.add(bDField);

        inputs.add(nomePanel); inputs.add(dataPanel);
        add(inputs, BorderLayout.CENTER);
        
    }
}