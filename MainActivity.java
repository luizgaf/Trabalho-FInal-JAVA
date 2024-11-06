// front e backend se conectam
import front.*;
import javax.swing.*;

public class MainActivity{
    public static void main(String[] args){
        JFrame frame = new JFrame("Banco");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionando FrontEnd como painel
        FrontEnd frontEndPanel = new FrontEnd();
        frame.add(frontEndPanel);

        // Exibindo a janela
        frame.setVisible(true);
    }
}