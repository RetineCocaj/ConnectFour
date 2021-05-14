import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connect4Frame extends JFrame {

    private Connect4Model model;
    public JLabel lab;
    public JButton reset;
    private JPanel drawing;
    public JPanel p1, p2;
    private ColumnButton[] b = new ColumnButton[7];

    public Connect4Frame(Connect4Model m, JPanel d){
        model = m;
        drawing = d;
        drawing.setLayout(new FlowLayout());
        drawing.repaint();
        this.setLayout(new BorderLayout());
        p1 = new JPanel(new FlowLayout());
        lab = new JLabel("");
        reset = new JButton("RESET");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        reset.setPreferredSize(new Dimension(120,30));
        lab.setPreferredSize(new Dimension(120,30));
        p1.add(lab); p1.add(reset);
        p2 = new JPanel(new FlowLayout());
        for(int i = 0; i < b.length; i++){
            b[i] = new ColumnButton(""+(i+1), m, this);
            b[i].setPreferredSize(new Dimension(95,25));
            p2.add(b[i]);
        }
        this.add(p2, BorderLayout.NORTH);
        this.add(drawing, BorderLayout.CENTER);

        setSize(765,800);
        setTitle("Connect4 Game");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update(){
        drawing.repaint();
        this.revalidate();
        this.repaint();
    }

    public void disableButtons(){
        for(int i = 0; i < b.length; i++){
            b[i].setEnabled(false);
        }
    }

    public void resetGame(){
        new TestConnect4();
        dispose();
    }

}
