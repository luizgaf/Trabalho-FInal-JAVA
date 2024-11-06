package front;

import javax.swing.*;

public class FrontEnd extends JPanel{
    
    public FrontEnd(){
        JFrame frame = new JFrame("Banco");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }  

    public static void main(String[] args) {
        FrontEnd FE = new FrontEnd();
        FE.setVisible(true);
    }
}