package com.view.Defesa_Civil;

import javax.swing.*;

public class MainActivity{
    public static void main(String[] args){
        JFrame frame = new JFrame("Defesa Civil");
        frame.setSize(800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // painel
        FrontEnd frontEndPanel = new FrontEnd(frame);
        frame.add(frontEndPanel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        // Exibindo a janela
        frame.setVisible(true);
    }
}