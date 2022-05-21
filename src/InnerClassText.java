import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InnerClassText extends JFrame {
    private String name;
    private JLabel nameLabel;
    private JTextField nameField,displayField;
    private JButton exitButton;
    public InnerClassText(){
        super("inner class text");
        Container container =getContentPane();
        container.setLayout(new FlowLayout());
        nameLabel=new JLabel("姓名");
        nameField=new JTextField(20);
        container.add(nameLabel);
        container.add(nameField);
        displayField=new JTextField(30);
        displayField.setEditable(false);
        container.add(displayField);
        exitButton=new JButton("Exit");
        container.add(exitButton);
        ActionEventHandler handler=new ActionEventHandler();
        nameField.addActionListener(handler);
        exitButton.addActionListener(handler);
    }
    public void displayName(){
        displayField.setText("姓名是："+name);
    }
    public static void main(String args[]){
        InnerClassText window=new InnerClassText();
        window.setSize(400,140);
        window.setVisible(true);
    }
    private class ActionEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==exitButton){
                System.exit(0);
            }else if(event.getSource()==nameField){
                name=event.getActionCommand();
                nameField.setText("");
            }
            displayName();
        }
    }
}
