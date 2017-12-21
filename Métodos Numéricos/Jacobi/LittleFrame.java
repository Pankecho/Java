import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LittleFrame extends JFrame
{
    private JLabel xLabel, yLabel, funcionLabel, errorLabel;
    private JButton evaluaButton;
    private JTextField xField, yField, funcionField, valor1Field, valor2Field, errorField;
    private JPanel panel;
    /**
     * Constructor for objects of class LittleFrame
     */
    public LittleFrame()
    {
        super("Ayuda Jacobi");
        setLayout(new GridLayout(1,1,1,1));
        init();
        add(panel);
        pack();
        setSize(300,200);
        setVisible(true);
    }

    public void init(){
        panel = new JPanel(null);
        
        xLabel = new JLabel("x2 = ");
        yLabel  = new JLabel("x3 = ");
        funcionLabel = new JLabel("x1 = ");
        errorLabel = new JLabel("Error : ");
        
        xField = new JTextField(100);
        yField = new JTextField(100);
        funcionField = new JTextField(100);
        errorField = new JTextField(100);
        
        evaluaButton = new JButton("Evalua");
        
        evaluaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String y = xField.getText();
                    String z = yField.getText();
                    String x = funcionField.getText();
                    float error = Float.parseFloat(errorField.getText());
                    
                    Funcion2Var x1 = new Funcion2Var(x);
                    Funcion2Var x2 = new Funcion2Var(y);
                    Funcion2Var x3 = new Funcion2Var(z);
                    Jacobi3V prueba = new Jacobi3V(x1,x2,x3,error);
                    prueba.calcula();
                }catch(Exception ex){
                }
            }
        });
        
        xLabel.setBounds(15,45,100,30);
        yLabel.setBounds(15,75,100,30);
        funcionLabel.setBounds(15,15,100,30);
        errorLabel.setBounds(15,105,100,30);
        
        xField.setBounds(120,45,150,30);
        yField.setBounds(120,75,150,30);
        funcionField.setBounds(120,15,150,30);
        errorField.setBounds(120,105,150,30);
        
        evaluaButton.setBounds(100,140,100,30);
        
        panel.add(xLabel);
        panel.add(yLabel);
        panel.add(funcionLabel);
        panel.add(errorLabel);
        
        panel.add(xField);
        panel.add(yField);
        panel.add(funcionField);
        panel.add(errorField);
        
        panel.add(evaluaButton);
    }
}
