import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Connect4Drawing extends JPanel {
    private Connect4Model model;

    public Connect4Drawing(Connect4Model m){
        model = m;
        setSize(765,800);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        GeneralPath gp = new GeneralPath();
        int x = 25; int y = 100;
        for(int i = 0; i <= model.getBoard().length; i++){
            gp.moveTo(x,y+i*100);
            gp.lineTo(x+model.getBoard()[0].length*100, y+i*100);
        }
        for(int i = 0; i <= model.getBoard()[0].length; i++){
            gp.moveTo(x+i*100,y);
            gp.lineTo(x+i*100,y+model.getBoard().length*100);
        }
        Stroke stroke = new BasicStroke(10, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);
        g2.draw(gp);
        int[] cords = model.getCoordinates();
        int j = 0;
        for(int i = 0;i < cords.length-1;i = i+2){
            if(j%2 == 0){ g2.setColor(Color.RED); }
            else{ g2.setColor(Color.BLUE); }
            g2.fillOval(x+10+cords[i]*100,y+10+cords[i+1]*100,2*x+30,2*x+30);
            j++;
        }

        if(model.getGameIsWon() == true){
            int[][] winnerMoves = model.getWinnersMoves();
            if(model.wonGame() == 1){g2.setColor(Color.PINK);}
            else{g2.setColor(new Color(	51,204,255));}

            g2.fillRect(x+5+winnerMoves[1][0]*100, y+5+winnerMoves[0][0]*100, 90,90);
            g2.fillRect(x+5+winnerMoves[1][1]*100, y+5+winnerMoves[0][1]*100, 90,90);
            g2.fillRect(x+5+winnerMoves[1][2]*100, y+5+winnerMoves[0][2]*100, 90,90);
            g2.fillRect(x+5+winnerMoves[1][3]*100, y+5+winnerMoves[0][3]*100, 90,90);

            if(model.wonGame() == 1){g2.setColor(Color.RED);}
            else{g2.setColor(Color.BLUE);}

            g2.fillOval(x+10+winnerMoves[1][0]*100,y+10+winnerMoves[0][0]*100,80,80);
            g2.fillOval(x+10+winnerMoves[1][1]*100,y+10+winnerMoves[0][1]*100,80,80);
            g2.fillOval(x+10+winnerMoves[1][2]*100,y+10+winnerMoves[0][2]*100,80,80);
            g2.fillOval(x+10+winnerMoves[1][3]*100,y+10+winnerMoves[0][3]*100,80,80);
        }
    }


}
