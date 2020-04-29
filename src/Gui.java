import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class Gui extends JFrame implements ActionListener {

    JTextField userInput;
    JButton submit;
    JLabel instructions, outPut, trendingCocktail;
    List<String> preStop = new ArrayList<>();
    DrinkAlgo choice;
    TrendingCocktail trend;

    Gui(){
        JFrame theWindow = new JFrame("Cocktail Picker");
        theWindow.setLayout(new FlowLayout());
        theWindow.getContentPane().setBackground( Color.LIGHT_GRAY );

        instructions = new JLabel("What Sounds Good To You?", SwingConstants.CENTER);
        instructions.setFont(new Font("Courier New", Font.PLAIN, 20));
        instructions.setForeground(Color.BLACK);
        theWindow.add(instructions);

        userInput = new JTextField(50);
        userInput.setFont(new Font("Courier New", Font.PLAIN, 20));
        userInput.setBackground(Color.WHITE);
        userInput.setForeground(Color.BLACK);
        userInput.setPreferredSize(new Dimension(100, 25));
        theWindow.add(userInput);
        userInput.addActionListener(this);

        submit = new JButton("Find Me A Drink!");
        submit.setFont(new Font("Courier New", Font.PLAIN, 20));
        submit.setBackground(Color.GRAY);
        submit.setForeground(Color.BLACK);
        theWindow.add(submit);
        submit.addActionListener(this);

        outPut = new JLabel("", SwingConstants.CENTER);
        outPut.setFont(new Font("Courier New", Font.PLAIN, 20));
        outPut.setForeground(Color.BLACK);
        theWindow.add(outPut);

        trendingCocktail = new JLabel("", SwingConstants.CENTER);
        trendingCocktail.setFont(new Font("Courier New", Font.PLAIN, 20));
        trendingCocktail.setForeground(Color.BLACK);
        theWindow.add(trendingCocktail);

        theWindow.setSize(800, 500);
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
            outPut.setText("\n\n\nA Shot Of Tequila!");
        } else {
            outPut.setText("\n\n\nYou Should Try A " + choice.getName());
        }

        try {
            trend = new TrendingCocktail();
            trendingCocktail.setText("\n\n\n" + trend.getTrending() + " Is trending");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
