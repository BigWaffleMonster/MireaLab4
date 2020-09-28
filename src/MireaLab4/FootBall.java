package MireaLab4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FootBall extends JFrame{

    int AC_Milan_Score = 0, Real_Madrid_Score = 0;
    String last_scorer = " N/A ", winner = " DRAW ";

    // Создание кнопок для обеих команд
    private JFrame table1 = new JFrame();
    private JPanel table2 = new JPanel(new BorderLayout());
    private JButton AC_Milan = new JButton(" AC Milan ");
    private JButton Real_Madrid = new JButton(" Real Madrid ");

    // Создание таблицы результатов
    private JLabel label1 = new JLabel (" Result: ");
    private JLabel label11 = new JLabel (String.valueOf(AC_Milan_Score));
    private JLabel label12 = new JLabel (" X ");
    private JLabel label13 = new JLabel (String.valueOf(Real_Madrid_Score));

    // Строки с последним голом и победителем
    private JLabel label2 = new JLabel (" Last Scorer: ");
    private JLabel label21 = new JLabel (last_scorer);
    private Label label3 = new Label(" Winner: ");
    private Label label31 = new Label(winner);

    public FootBall() {

        super("FootBall");
        setLayout(new GridLayout(3, 4));
        this.setBounds(100, 100, 600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonGroup buttonGroup = new ButtonGroup();
        AC_Milan.addActionListener(new ButtonEventListener1());
        Real_Madrid.addActionListener(new ButtonEventListener2());

        // Добавление всех элементов на табло
        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        container.add(AC_Milan);
        container.add(Real_Madrid);
        container.add(label1);
        container.add(label11);
        container.add(label12);
        container.add(label13);
        container.add(label2);
        container.add(label21);
        container.add(label3);
        container.add(label31);
    }

    private void Goal(int x, int y){
        if (x > y){
            label31.setText("AC Milan");
        }
        if(x < y){
            label31.setText("Real Madrid");
        }
        else{
            label31.setText("DRAW");
        }
    }

    private class ButtonEventListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent Event) {
            AC_Milan_Score++;
            label21.setText("AC Milan");
            Goal(AC_Milan_Score, Real_Madrid_Score);
        }
    }
    private class ButtonEventListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent Event) {
            Real_Madrid_Score++;
            label21.setText("Real Madrid");
            Goal(AC_Milan_Score, Real_Madrid_Score);
        }
    }
}
