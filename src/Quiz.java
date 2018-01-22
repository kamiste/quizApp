import javax.swing.*;
import java.awt.*;

public class Quiz {

    private JLabel topLabel;
    private JFrame mainFrame;

    public Quiz(){
        mainFrame = new JFrame();
        mainFrame.setTitle("Quiz");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(new Dimension(350,350));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        topLabel = new JLabel("Click on the tiles and select two the same.");
        topLabel.setBounds(47,10,250,20);

        JPanel quiz = new ViewQuiz();

        mainFrame.add(topLabel);
        mainFrame.add(quiz);

        mainFrame.setVisible(true);
    }

    // MAIN
    public static void main(String[] args) {
        new Quiz();
    }

}
