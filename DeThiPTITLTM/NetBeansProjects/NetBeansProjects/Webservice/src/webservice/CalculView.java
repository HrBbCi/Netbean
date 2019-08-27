/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author LENPOVO
 */
public class CalculView extends JFrame implements ActionListener{
    private JTextField txtFirstnumber;
    private JTextField txtSecondnumber;
    private JButton btnAdd, btnSub, btnMul, btnDiv;
    
    public CalculView()
    {
        super("Calculator using web service");
        txtFirstnumber = new JTextField(8);
        txtSecondnumber = new JTextField(8);
        btnAdd = new JButton("Add");
        btnSub = new JButton("Subvision");
        btnMul = new JButton("Multiple");
        btnDiv = new JButton("Division");
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("First number:"));
        content.add(txtFirstnumber);
        content.add(new JLabel("Second number:"));
        content.add(txtSecondnumber);
        content.add(btnAdd);
        content.add(btnSub);
        content.add(btnMul);
        content.add(btnDiv);
        btnAdd.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnSub.addActionListener(this);

        this.setContentPane(content);
        this.pack();
        this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
        System.exit(0);
        }
        });
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        Calculator cal = null;
        try{
        double a = Double.parseDouble(txtFirstnumber.getText());
        double b = Double.parseDouble(txtSecondnumber.getText());
        cal = new Calculator(a,b);
        }catch(Exception ex){
        ex.printStackTrace();
        }
        CalculControl cc = new CalculControl();
        if(e.getSource().equals(btnAdd)){
        showMessage("Addition of " + cal.getFirstnumber() + " and " 
        + cal.getSecondnumber() + " is: " + cc.add(cal));
        }else if(e.getSource().equals(btnSub)){
        showMessage("Subvision of " + cal.getFirstnumber() + " and " 
        + cal.getSecondnumber() + " is: " + cc.sub(cal));
        }else if(e.getSource().equals(btnMul)){
        showMessage("Multiple of " + cal.getFirstnumber() + " and " 
        + cal.getSecondnumber() + " is: " + cc.multiple(cal));
        }else if(e.getSource().equals(btnDiv)){
        showMessage("Division of " + cal.getFirstnumber() + " and " 
        + cal.getSecondnumber() + " is: " + cc.div(cal));
        }
    }
    
    public void showMessage(String msg)
    {
        JOptionPane.showMessageDialog(this, msg);
    }
}
