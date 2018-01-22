import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ViewQuiz extends JPanel implements ActionListener {

    private List<JButton> buttons;
    private int SIZE = 8;
    private JButton clicked, secondClick;
    private boolean isClicked = false;
    private int iter=0;

    public ViewQuiz() {

        setBounds(40, 40, 250, 250);
        setLayout(new GridLayout(4, 4, 2, 2));
        setVisible(true);

        buttons = new ArrayList<>();

        // tworzenie przyciskow
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

        // mieszanie listy
        Collections.shuffle(buttons);

        // dodawanie do panelu pomieszanych przyciskow
        for (int i = 0; i < (SIZE * 2); i++) {
            add(buttons.get(i));
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (iter < 16) {
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
                    System.out.println(iter);
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

        if(iter == 16){
            iter = 0;
            JOptionPane.showMessageDialog(null, "Congrats, end game!");

        }


    }

}
