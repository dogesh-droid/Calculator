import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculatorMain extends JFrame implements ActionListener {
    JButton plus,minus,multiply,divide,equals,point,clear,delete,neg;
    JPanel panel;
    JButton[] n=new JButton[10];
    JButton[] f=new JButton[9];
    JTextField t;
    JFrame frame;

    double a,b,res;char operator;

    Font font=new Font("ink free", Font.PLAIN,30);
    calculatorMain(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,500);
        frame.setLayout(null);

        t=new JTextField();
        t.setBounds(50, 25, 300, 50);
        t.setFont(font);
        t.setEditable(false);

        plus=new JButton("+");
        minus=new JButton("-");
        multiply=new JButton("x");
        divide=new JButton("/");
        point=new JButton(".");
        equals=new JButton("=");
        delete=new JButton("del");
        clear=new JButton("clr");
        neg=new JButton("(-)");

        f[0]=plus;
        f[1]=minus;
        f[2]=multiply;
        f[3]=divide;
        f[4]=point;
        f[5]=equals;
        f[6]=delete;
        f[7]=clear;
        f[8]=neg;

        for(JButton i:f){
            i.addActionListener(this);
            i.setFont(font);
            i.setFocusable(false);

        }

        for(int i=0;i<10;i++){
            n[i]=new JButton(String.valueOf(i));
            n[i].addActionListener(this);
            n[i].setFocusable(false);
            n[i].setFont(font);
        }

        neg.setBounds(50,430,100,50);
        delete.setBounds(150,430,100,50);
        clear.setBounds(250,430,100,50);





        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(n[1]);
        panel.add(n[2]);
        panel.add(n[3]);
        panel.add(plus);
        panel.add(n[4]);
        panel.add(n[5]);
        panel.add(n[6]);
        panel.add(minus);
        panel.add(n[7]);
        panel.add(n[8]);
        panel.add(n[9]);
        panel.add(multiply);
        panel.add(point);
        panel.add(n[0]);
        panel.add(equals);
        panel.add(divide);

        frame.add(panel);
        frame.add(neg);
        frame.add(delete);
        frame.add(clear);
        frame.add(t);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        calculatorMain cal=new calculatorMain();


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==n[i])
                t.setText(t.getText()+String.valueOf(i));
        }
        if(e.getSource()==point){
            t.setText(t.getText()+".");
        }
        if(e.getSource()==plus){
            a=Double.valueOf(t.getText());
            operator='+';
            t.setText("");
        }
        if(e.getSource()==minus){
            a=Double.valueOf(t.getText());
            operator='-';
            t.setText("");
        }
        if(e.getSource()==multiply){
            a=Double.valueOf(t.getText());
            operator='x';
            t.setText("");
        }
        if(e.getSource()==divide){
            a=Double.valueOf(t.getText());
            operator='/';
            t.setText("");
        }
        if(e.getSource()==equals){
            b=Double.valueOf(t.getText());

            switch(operator){
                case '+':
                    res=a+b;
                    break;
                case '-':
                    res=a-b;
                    break;
                case 'x':
                    res=a*b;
                    break;
                case '/':
                    res=a/b;
                    break;

            }
            t.setText(String.valueOf(res));
        }
        if(e.getSource()==clear){
            t.setText("");
        }
        if(e.getSource()==delete){
            String s=t.getText();
            t.setText(s.substring(0,s.length()-1));
        }
        if(e.getSource()==neg){
            double temp=Double.valueOf(t.getText());
            temp*=-1;
            t.setText(String.valueOf(temp));
        }



    }
}