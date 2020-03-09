import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class Gui extends JFrame implements ActionListener {

    JTextField userInput;
    JButton submit;
    JLabel instructions, outPut;
    List<String> preStop = new ArrayList<>();
    DrinkAlgo choice;

    Gui(){
        JFrame theWindow = new JFrame("Cocktail Picker");
        theWindow.setLayout(new GridLayout(4, 3));
        theWindow.getContentPane().setBackground( Color.BLACK );

        instructions = new JLabel("What Sounds Good To You?", SwingConstants.CENTER);
        instructions.setFont(new Font("Courier New", Font.PLAIN, 20));
        instructions.setForeground(Color.WHITE);
        theWindow.add(instructions);

        userInput = new JTextField();
        userInput.setFont(new Font("Courier New", Font.PLAIN, 20));
        userInput.setBackground(Color.WHITE);
        userInput.setForeground(Color.BLACK);
        theWindow.add(userInput);
        userInput.addActionListener(this);

        submit = new JButton("Find Me A Drink!");
        submit.setFont(new Font("Courier New", Font.PLAIN, 20));
        submit.setBackground(Color.LIGHT_GRAY);
        submit.setForeground(Color.BLACK);
        theWindow.add(submit);
        submit.addActionListener(this);

        outPut = new JLabel("", SwingConstants.CENTER);
        outPut.setFont(new Font("Courier New", Font.PLAIN, 20));
        outPut.setForeground(Color.WHITE);
        theWindow.add(outPut);

        theWindow.setSize(800, 200);
        theWindow.setVisible(true);
        theWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String input = userInput.getText();
        input = input.toLowerCase().replaceAll("not ", "not");

        String[] arr = input.split("\\s");
        preStop = Arrays.asList(arr);

        try {
            choice = new DrinkAlgo(preStop);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInput.setText("");

        if (preStop.size() < 2) {
            outPut.setText("A Shot Of Tequila!");
        } else {
            outPut.setText("You Should Try A " + choice.getName());
        }
    }

}
