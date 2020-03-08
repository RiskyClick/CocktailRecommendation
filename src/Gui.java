import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Gui extends Frame implements ActionListener {

    private Label lable;
    private Label output;
    private TextField  textBlock;
    private Button button;

    public Gui(){
        setLayout(new FlowLayout());

        lable = new Label("Enter in some flavors for a drink you would like");
        add(lable);

        textBlock = new TextField(); // construct the TextField component with initial text
        textBlock.setEditable(false);       // set to read-only
        add(textBlock);

        button = new Button("Find Me A Drink!");   // construct the Button component
        add(button);                    // "super" Frame container adds Button component

        textBlock.addActionListener(this);

        setTitle("Cocktail Chooser");
        setSize(250, 100);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String input = textBlock.getText();
        input = input.toLowerCase().replaceAll("not ", "not");

        String[] arr = input.split("\\s");
        List<String> preStop = Arrays.asList(arr);

        try {
            new DrinkAlgo(preStop);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textBlock.setText("");


    }
}
