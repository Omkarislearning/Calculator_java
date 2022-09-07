import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator implements ActionListener
{
    JFrame frame=new JFrame("Calculator");
    JPanel panel=new JPanel();
    JButton[] Number = new JButton[10];
    JButton[] FunctionB = new JButton[8];
    JButton addButton,subButton,multiButton,divButton,clrButton,eqButton,deciButton,delButton;

    JTextField Textfield = new JTextField();
    double num1=0,num2=0,result=0;
    char operator;
    Font myfont = new Font("Mv Boli",Font.BOLD,25);


    MyCalculator()
    {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.BLACK);

        JLabel label= new JLabel("CASIO");
        label.setBounds(150,10,150,40);
        label.setFont(myfont);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.GREEN);
        Textfield.setBounds(50,50,300,50);
        Textfield.setFont(myfont);
        Textfield.setForeground(Color.black);
        Textfield.setBackground(new Color(102,255,102));
        frame.add(label);


        addButton=new JButton("+");
        subButton=new JButton("-");
        multiButton=new JButton("*");
        divButton=new JButton("/");
        eqButton=new JButton("=");
        clrButton=new JButton("Clear");
        deciButton=new JButton(".");
        delButton=new JButton("Delete");

        FunctionB[0]=addButton;
        FunctionB[1]=subButton;
        FunctionB[2]=multiButton;
        FunctionB[3]=divButton;
        FunctionB[4]=eqButton;
        FunctionB[5]=clrButton;
        FunctionB[6]=deciButton;
        FunctionB[7]=delButton;



     for(int i=0;i<8;i++)
        {
            FunctionB[i].addActionListener(this);
            FunctionB[i].setFont(myfont);
            FunctionB[i].setFocusable(false);
            FunctionB[i].setForeground(Color.GREEN);
            FunctionB[i].setBackground(Color.black);
        }

        for(int i=0;i<10;i++)
        {
            Number[i]=new JButton(String.valueOf(i));
            Number[i].addActionListener(this);
            Number[i].setFont(myfont);
            Number[i].setFocusable(false);
            Number[i].setForeground(Color.GREEN);
            Number[i].setBackground(Color.black);

        }
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel.setBounds(50,120,300,300);
        panel.setBackground(Color.black);
        panel.setForeground(Color.GREEN);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(Number[1]);
        panel.add(Number[2]);
        panel.add(Number[3]);
        panel.add(addButton);
        panel.add(Number[4]);
        panel.add(Number[5]);
        panel.add(Number[6]);
        panel.add(subButton);
        panel.add(Number[7]);
        panel.add(Number[8]);
        panel.add(Number[9]);
        panel.add(multiButton);
        panel.add(Number[0]);
        panel.add(deciButton);
        panel.add(eqButton);
        panel.add(divButton);


        frame.add(delButton);
        frame.add(clrButton);
        frame.add(panel);
        frame.add(Textfield);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==Number[i])
            {
                Textfield.setText(Textfield.getText().concat(String.valueOf(i)));
            }
        }
        if ((e.getSource()==deciButton))
        {
            Textfield.setText(Textfield.getText().concat("."));
        }
        if(e.getSource()==addButton)
        {
            num1=Double.parseDouble(Textfield.getText());
            operator='+';
            Textfield.setText("");
        }
        if(e.getSource()==subButton)
        {
            num1=Double.parseDouble(Textfield.getText());
            operator='-';
            Textfield.setText("");
        }
        if(e.getSource()==multiButton)
        {
            num1=Double.parseDouble(Textfield.getText());
            operator='*';
            Textfield.setText("");
        }
        if(e.getSource()==divButton)
        {
            num1=Double.parseDouble(Textfield.getText());
            operator='/';
            Textfield.setText("");
        }
        if(e.getSource()==eqButton) 
        {
            num2=Double.parseDouble(Textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;


                case '/':
                    result = num1 / num2;
                    break;
            }

            Textfield.setText(String.valueOf(result));
            num1 = result;
        }
            if (e.getSource() == clrButton)
            {
                Textfield.setText("");
            }

            if(e.getSource()==delButton)
            {
               String string= Textfield.getText();
               Textfield.setText("");
                for(int i = 0; i<(string.length()-1); i++)
                {
                    Textfield.setText(Textfield.getText()+string.charAt(i));

                }
            }

    }
}
