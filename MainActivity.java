import front.*;
import javax.swing.*;

public class MainActivity{
    public static void main(String[] args){
        JFrame frame = new JFrame("Banco");
        frame.setSize(800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // painel
        FrontEnd frontEndPanel = new FrontEnd();
        frame.add(frontEndPanel);

        // Exibindo a janela
        frame.setVisible(true);
    }
}