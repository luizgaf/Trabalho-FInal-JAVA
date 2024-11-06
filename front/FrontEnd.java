package front;

import javax.swing.*;

public class FrontEnd extends JPanel{
    
    public FrontEnd(){
        JLabel label = new JLabel("Bem-vindo ao Banco");
        add(label);
    }


    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }  

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banco");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        FrontEnd frontEnd = new FrontEnd();
        frame.add(frontEnd);

        
        frame.setVisible(true);
    }
}