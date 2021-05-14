import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColumnButton extends JButton implements ActionListener {
    private Connect4Frame view;
    private Connect4Model model;

    public ColumnButton(String l, Connect4Model m, Connect4Frame v){
        super(l);
        model = m;
        view = v;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt){
        int column = Integer.parseInt(this.getText())-1;
        model.makeMove(column);
        model.checkForWin();
        if(model.getGameIsWon() || model.getPlayersTurn() == 42){
            view.disableButtons();
            view.remove(view.p2);
            view.add(view.p1, BorderLayout.NORTH);
            if(model.wonGame() == 1){
                view.lab.setText("RED WON");
                view.lab.setForeground(Color.RED);
            }
            else if(model.wonGame() == 2){
                view.lab.setText("BLUE WON");
                view.lab.setForeground(Color.BLUE);
            }
            else if(model.wonGame() == 0) {
                view.lab.setText("DRAW");
                view.lab.setForeground(Color.BLACK);
            }
        }
        view.update();
    }
}
