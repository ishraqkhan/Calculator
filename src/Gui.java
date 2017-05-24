/**
 * Created by Ishraq on 5/30/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;

class Gui extends JFrame {
    private JTextField answerfield; //Textfield at op where calculations are shown
    private JButton one, two, three, four, five,six, seven, eight, nine, zero, //Every button in calculator
                    decimal, negative, add, subtract, multiply, divide, exponent, equals,
                    clear, backspace;
    private String stemp1, stemp2, sanswer; //Strings for both operands and answer
    private double answer = 0.0;
    private JPanel contentPanel; //Where all buttons are shown
    private boolean equalsClicked = false, opChosen = false; //At atart of calculations, no operation has been clicked and equal sign hasnt been clicked
    char operation = ' ';

    Gui(){
        super("Calculator");

        //Create answerfield that user can't type things in, can only add through clicking buttons
        answerfield = new JTextField(null, 20);
        answerfield.setEditable(false);

        //Creating objects for buttons
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        decimal = new JButton(".");
        negative = new JButton("+/-");
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        exponent = new JButton("^");
        equals = new JButton("=");
        clear = new JButton("C");
        backspace = new JButton("<--");

        //Creating different potential dimension sizes for each button
        Dimension onePerLine = new Dimension(225, 30);
        Dimension twoPerLine = new Dimension(113, 30);
        Dimension threePerLine = new Dimension(75, 30);

        //Setting size of each button
        one.setPreferredSize(threePerLine);
        two.setPreferredSize(threePerLine);
        three.setPreferredSize(threePerLine);
        four.setPreferredSize(threePerLine);
        five.setPreferredSize(threePerLine);
        six.setPreferredSize(threePerLine);
        seven.setPreferredSize(threePerLine);
        eight.setPreferredSize(threePerLine);
        nine.setPreferredSize(threePerLine);
        zero.setPreferredSize(onePerLine);
        decimal.setPreferredSize(twoPerLine);
        negative.setPreferredSize(twoPerLine);
        add.setPreferredSize(twoPerLine);
        subtract.setPreferredSize(twoPerLine);
        multiply.setPreferredSize(twoPerLine);
        divide.setPreferredSize(twoPerLine);
        exponent.setPreferredSize(twoPerLine);
        equals.setPreferredSize(twoPerLine);
        clear.setPreferredSize(onePerLine);
        backspace.setPreferredSize(onePerLine);

        //Creating objects for numbers to be calculated, and operators fro calculations
        Numbers n = new Numbers();
        Calc c = new Calc();

        //Creating action listener for every number object, so that each recognizes when it's being clicked
        one.addActionListener(n); two.addActionListener(n); three.addActionListener(n);
        four.addActionListener(n); five.addActionListener(n); six.addActionListener(n);
        seven.addActionListener(n); eight.addActionListener(n); nine.addActionListener(n);
        zero.addActionListener(n); decimal.addActionListener(n); negative.addActionListener(n);
        backspace.addActionListener(n);

        //Creating action listener for every calc object, so that each recognizes when it's being clicked
        add.addActionListener(c); subtract.addActionListener(c);
        multiply.addActionListener(c); divide.addActionListener(c);
        exponent.addActionListener(c); equals.addActionListener(c);
        clear.addActionListener(c);

        //Declaring qualities for content panel
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.GRAY);
        contentPanel.setLayout(new FlowLayout());
        contentPanel.add(answerfield, BorderLayout.NORTH); //Calculations shown on top

        //Show each button on content panel in order of which tey are added
        contentPanel.add(clear);contentPanel.add(one); contentPanel.add(two);
        contentPanel.add(three); contentPanel.add(four); contentPanel.add(five);
        contentPanel.add(six); contentPanel.add(seven); contentPanel.add(eight);
        contentPanel.add(nine); contentPanel.add(zero); contentPanel.add(decimal);
        contentPanel.add(negative); contentPanel.add(add); contentPanel.add(subtract);
        contentPanel.add(multiply); contentPanel.add(divide); contentPanel.add(exponent);
        contentPanel.add(equals); contentPanel.add(backspace);

        //Show calculator
        this.setContentPane(contentPanel);

    }

    //Class for numbers that don't involve answer
    private class Numbers implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JButton src = (JButton) event.getSource();

            if(src.equals(one)){ //If one is clicked
                if (opChosen == false){ //If operation isn't selected yet
                    if (stemp1 == null || stemp1.equals("0")){ //If first number isn't set to anything yet or is set to zero, change it to one
                        stemp1 = "1";
                    }
                    else{
                        stemp1 += "1"; //If it already is set to a non-zero number add 1 to the end of it
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0") ){ //
                        stemp2 = "1";
                    }
                    else{
                        stemp2 += "1";
                    }
                }
            }
            else if(src.equals(two)){ //If number two is clicked, same logic used in one for numbers two through zero.
                if (opChosen == false){
                    if (stemp1 == null || stemp1.equals("0")){
                        stemp1 = "2";
                    }
                    else{
                        stemp1 += "2";
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0")){
                        stemp2 = "2";
                    }
                    else{
                        stemp2 += "2";
                    }
                }
            }
            else if(src.equals(three)){
                if (opChosen == false){
                    if (stemp1 == null || stemp2.equals("0")){
                        stemp1 = "3";
                    }
                    else{
                        stemp1 += "3";
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0")){
                        stemp2 = "3";
                    }
                    else{
                        stemp2 += "3";
                    }
                }
            }
            else if(src.equals(four)){
                if (opChosen == false){
                    if (stemp1 == null || stemp1.equals("0")){
                        stemp1 = "4";
                    }
                    else{
                        stemp1 += "4";
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0")){
                        stemp2 = "4";
                    }
                    else{
                        stemp2 += "4";
                    }
                }
            }
            else if(src.equals(five)){
                if (opChosen == false){
                    if (stemp1 == null || stemp1.equals("0")){
                        stemp1 = "5";
                    }
                    else{
                        stemp1 += "5";
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0")){
                        stemp2 = "5";
                    }
                    else{
                        stemp2 += "5";
                    }
                }
            }
            else if(src.equals(six)){
                if (opChosen == false){
                    if (stemp1 == null || stemp1.equals("0")){
                        stemp1 = "6";
                    }
                    else{
                        stemp1 += "6";
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0")){
                        stemp2 = "6";
                    }
                    else{
                        stemp2 += "6";
                    }
                }
            }
            else if(src.equals(seven)){
                if (opChosen == false){
                    if (stemp1 == null || stemp1.equals("0")){
                        stemp1 = "7";
                    }
                    else{
                        stemp1 += "7";
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0")){
                        stemp2 = "7";
                    }
                    else{
                        stemp2 += "7";
                    }
                }
            }
            else if(src.equals(eight)){
                if (opChosen == false){
                    if (stemp1 == null || stemp1.equals("0")){
                        stemp1 = "8";
                    }
                    else{
                        stemp1 += "8";
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0")){
                        stemp2 = "8";
                    }
                    else{
                        stemp2 += "8";
                    }
                }
            }
            else if(src.equals(nine)){
                if (opChosen == false){
                    if (stemp1 == null || stemp1.equals("0")){
                        stemp1 = "9";
                    }
                    else{
                        stemp1 += "9";
                    }
                }
                else{
                    if (stemp2 == null || stemp2.equals("0")){
                        stemp2 = "9";
                    }
                    else{
                        stemp2 += "9";
                    }
                }
            }
            else if(src.equals(zero)){
                if (opChosen == false){
                    if (stemp1 != null){
                        stemp1 += "0";
                    }
                    else{
                        stemp1 = "0";
                    }
                }
                else{
                    if (stemp2 != null){
                        stemp2 += "0";
                    }
                    else{
                        stemp2 = "0";
                    }
                }
            }
            else if (src.equals(decimal)){ //If decimal is clicked
                if(opChosen == false){
                    if(stemp1 == null){ //if decimal is first, add zero and decimal, otherwise just add decimal
                        stemp1 = "0";
                        stemp1 += ".";
                    }
                    else{
                        if(stemp1.contains(".")){
                            System.out.println("No more than one decimal point!");
                        }
                        else{
                            if (stemp1.equals("-")){
                                stemp1 += "0.";
                            }
                            else{
                                stemp1 += ".";
                            }
                        }
                    }
                }
                else{
                    if (stemp2 == null){
                        stemp2 = "0";
                        stemp2 += ".";
                    }
                    else{
                        if(stemp2.contains(".")){
                            System.out.println("No more than one decimal point!");
                        }
                        else{
                            if (stemp2.equals("-")){
                                stemp2 += "0.";
                            }
                            else{
                                stemp2 += ".";
                            }
                        }
                    }
                }
            }
            else if(src.equals(negative)){
                if (opChosen == false){
                    if (stemp1 == null){ //make null string equa to -
                        stemp1 = "-";
                    }
                    else{
                        if (stemp1 != null && stemp1.startsWith("-")){
                            stemp1 = stemp1.substring(1); //Change negative num into a positive number
                        }
                        else{
                            stemp1 = "-" + stemp1; //Make positive number into negative number
                        }
                    }
                }
                else{
                    if (stemp2 == null){ //Same rules as stemp1
                        stemp2 = "-";
                    }
                    else{
                        if (stemp2 != null && stemp2.startsWith("-")){
                            stemp2 = stemp2.substring(1);
                        }
                        else{
                            stemp2 = "-" + stemp2;
                        }
                    }
                }
            }
            else if (src.equals(backspace)){ //If backspace is  selected
                if (opChosen == false && stemp1 != null){
                    stemp1 = stemp1.substring(0, stemp1.length() - 1);
                }
                else if (opChosen == true && stemp2 != null){
                    stemp2 = stemp2.substring(0, stemp2.length() - 1);
                }
            }

            if (equalsClicked == false){
                if (opChosen == false){
                    answerfield.setText(stemp1);
                }
                else{
                    answerfield.setText(stemp1 + operation + stemp2);
                }
            }

        }
    }

    private class Calc implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JButton src = (JButton) event.getSource();
            if (src.equals(add)){
                if(stemp1 ==  null){
                    System.out.println("Choose your numbers first!");
                }
                else{
                    if (stemp1 != null && stemp2 == null){
                        opChosen = true;
                        operation = '+';
                        answerfield.setText(stemp1 + operation);
                    }
                    else{
                        System.out.println("Two operations only!");
                    }
                }
            }
            else if (src.equals(subtract)){
                if(stemp1 ==  null){
                    System.out.println("Choose your numbers first!");
                }
                else{
                    if (stemp1 != null && stemp2 == null){
                        opChosen = true;
                        operation = '-';
                        answerfield.setText(stemp1 + operation);
                    }
                    else{
                        System.out.println("Two operations only!");
                    }
                }
            }
            else if (src.equals(multiply)){
                if(stemp1 ==  null){
                    System.out.println("Choose your numbers first!");
                }
                else{
                    if (stemp1 != null && stemp2 == null){
                        opChosen = true;
                        operation = '*';
                        answerfield.setText(stemp1 + operation);
                    }
                    else{
                        System.out.println("Two operations only!");
                    }
                }
            }
            else if (src.equals(divide)){
                if(stemp1 ==  null){
                    System.out.println("Choose your numbers first!");
                }
                else{
                    if (stemp1 != null && stemp2 == null){
                        opChosen = true;
                        operation = '/';
                        answerfield.setText(stemp1 + operation);
                    }
                    else{
                        System.out.println("Two operations only!");
                    }
                }
            }
            else if (src.equals(exponent)){
                if (stemp1 != null && stemp2 == null){
                    opChosen = true;
                    operation = '^';
                    answerfield.setText(stemp1 + operation);
                }
                else{
                    System.out.println("Two operations only!");
                }
            }
            else if (src.equals(equals)){
                if(stemp1 ==  null || stemp2 == null){
                    System.out.println("Choose your numbers first!");
                }
                else{
                        double d1 = 0.0, d2 = 0.0;

                        d1 = Double.parseDouble(stemp1);
                        d2 = Double.parseDouble(stemp2);
                        switch(operation){
                            case '+':
                                answer = d1 + d2;
                                break;
                            case '-':
                                answer = d1 - d2;
                                break;
                            case '*':
                                answer = d1 * d2;
                                break;
                            case '/':
                                answer = d1 / d2;
                                break;
                            case '^':
                                answer = Math.pow(d1, d2);
                        }
                        if (operation == '/' && d2 == 0.0){
                            answerfield.setText("DNE");
                        }
                        else{
                            sanswer = Double.toString(answer);
                            answerfield.setText(sanswer);
                        }
                }
            }

            if (src.equals(clear)){
                stemp1 = null;
                stemp2 = null;
                opChosen = false;
                equalsClicked = false;
                operation = ' ';
                answerfield.setText(null);
                sanswer = null;
            }
        }
    }
}
