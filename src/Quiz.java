import javax.swing.*;
import java.awt.*;

public class Quiz extends JFrame {

    private JLabel topLabel;

    public Quiz(){
        super("Quiz");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(350,350));
        setLocationRelativeTo(null);
        setLayout(null);

        topLabel = new JLabel("Click on the tiles and select two the same.");
        topLabel.setBounds(47,10,250,20);

        // panel z quizem
        JPanel quiz = new ViewQuiz();

        add(topLabel);
        add(quiz);

        setVisible(true);
    }

    // MAIN
    public static void main(String[] args) {
        new Quiz();
    }

}
