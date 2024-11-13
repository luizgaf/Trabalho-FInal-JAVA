package com.view.Defesa_Civil;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class FrontEndCadastroMembro extends JPanel{
    private BufferedImage image;
    private JPanel imagePanel;
    private JFrame frame;
    
    public FrontEndCadastroMembro(JFrame frame){
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Cadastro Membro", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(label, BorderLayout.NORTH);

        JPanel inputs = new JPanel();
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));
        
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

        JPanel dataPanel2 = new JPanel(new FlowLayout());
        JLabel telefone = new JLabel("Telefone:");
        dataPanel2.add(telefone);
        JTextField telefoneField = new JTextField();
        telefoneField.setPreferredSize(new Dimension(150, 30));
        dataPanel2.add(telefoneField);

        JLabel email = new JLabel("Email:");
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30));
        dataPanel2.add(email); dataPanel2.add(emailField);

        JPanel dataPanel3 = new JPanel(new FlowLayout());
        JLabel telEmergencia = new JLabel("Telefone Emergencia:");
        JTextField telEmergenciaField = new JTextField();
        telEmergenciaField.setPreferredSize(new Dimension(150, 30));
        dataPanel3.add(telEmergencia); dataPanel3.add(telEmergenciaField);

        JLabel uploadFoto = new JLabel("Upload Foto:");
        dataPanel3.add(uploadFoto);
        JButton uploaderFoto = new JButton("Selecionar Imagem");
        uploaderFoto.addActionListener(e -> selectImage());
        dataPanel3.add(uploaderFoto);
        
        JPanel dataPanel4 = new JPanel(new FlowLayout());
        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            }
        };
        imagePanel.setPreferredSize(new Dimension(200, 200));
        dataPanel4.add(imagePanel);


        inputs.add(nomePanel); 
        inputs.add(dataPanel); 
        inputs.add(dataPanel2); 
        inputs.add(dataPanel3);
        inputs.add(dataPanel4);

        add(inputs, BorderLayout.CENTER);

        JButton submitButton = new JButton("Cadastrar");
        JButton cancelButton = new JButton("Cancelar");
        addHoverEffect(submitButton);
        addHoverEffect(cancelButton);

        submitButton.addActionListener(e -> adcMembro());
        cancelButton.addActionListener(e -> voltar());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
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

    private void selectImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagens", "jpg", "png", "jpeg"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                image = ImageIO.read(selectedFile);
                imagePanel.repaint(); // Atualiza o painel para exibir a imagem
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao carregar a imagem", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void adcMembro(){};

    private void voltar() {
        if (frame != null) {
            frame.dispose();
        }
    }
}