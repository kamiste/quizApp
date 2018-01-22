import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

public class ViewQuiz extends JPanel implements ActionListener {

    private List<JButton> buttons;
    private int SIZE = 8;
    private JButton clicked, secondClick;
    private boolean isClicked = false;
    private int iter = 0;
    private long startTime, elapsedTime;

    public ViewQuiz() {

        setBounds(40, 40, 250, 250);
        setLayout(new GridLayout(4, 4, 2, 2));
        setVisible(true);

        buttons = new ArrayList<>();

        createTile();
        createButtPanel();

        startTime = System.currentTimeMillis();
        elapsedTime = 0L;

    }

    private void createTile() {

        for (int i = 0; i < SIZE; i++) {
            JButton button = new JButton();
            button.setActionCommand("" + i);
            JButton button2 = new JButton();
            button2.setActionCommand("" + i);

            button.addActionListener(this);
            button2.addActionListener(this);

            button.setHideActionText(true);
            button2.setHideActionText(true);

            buttons.add(button);
            buttons.add(button2);

        }

        Collections.shuffle(buttons);

    }

    private void createButtPanel() {
        for (int i = 0; i < (SIZE * 2); i++) {
            add(buttons.get(i));
        }
    }

    private void clearButtPanel() {
        buttons.clear();
        removeAll();
        revalidate();
        repaint();
    }

    private void catchAction(ActionEvent e) {
        if (isClicked) {
            secondClick = (JButton) e.getSource();
            secondClick.setText(secondClick.getActionCommand());

            if (clicked.equals(secondClick)) {
                clicked.setText("");
                isClicked = false;
            } else if (clicked.getActionCommand().equals(secondClick.getActionCommand())) {
                clicked.setEnabled(false);
                secondClick.setEnabled(false);
                clicked = null;
                secondClick = null;
                isClicked = false;
                iter += 2;
            } else if (!clicked.getActionCommand().equals(secondClick.getActionCommand())) {
                clicked.setText("");
                clicked = secondClick;
                isClicked = true;
            }

        } else {
            clicked = (JButton) e.getSource();
            clicked.setText(clicked.getActionCommand());
            isClicked = true;
        }
    }

    private void checkTime() {
        elapsedTime = ((new Date()).getTime() - startTime) / 1000;
        startTime = System.currentTimeMillis();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (iter < 16) {
            catchAction(e);
        }

        if (iter == 16) {
            iter = 0;
            clearButtPanel();
            createTile();
            createButtPanel();
            checkTime();

            JOptionPane.showMessageDialog(null, "Congratulations, your time :" + elapsedTime + "s");
        }

    }

}
