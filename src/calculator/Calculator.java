package calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private final boolean modernCalc;
    private JTextField expresionField;
    private JTextField secondExpresionField;
    private double previousNumber;
    private String previousAction;

    public Calculator(){
        this(false);
    }

    public Calculator(boolean modernCalc){
        this.modernCalc = modernCalc;
        createWindow();
        setVisible(true);
    }


    private void createWindow(){
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 50, 300, 500);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new GridLayout(6, 3));
        add(topPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);

        expresionField = new JTextField();
        expresionField.setEditable(false);
        expresionField.setPreferredSize(new Dimension(100, 40));
        expresionField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        topPanel.add(expresionField, BorderLayout.CENTER);

        secondExpresionField = new JTextField();
        secondExpresionField.setEditable(false);
        topPanel.add(secondExpresionField, BorderLayout.SOUTH);

        for (int i = 1; i < 10; i++){
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new DigitalButtonListener());
            buttonsPanel.add(button);
        }
        JButton buttonZero = new JButton("0");
        buttonZero.addActionListener(new DigitalButtonListener());
        buttonsPanel.add(buttonZero);
        JButton buttonDot = new JButton(".");
        buttonDot.addActionListener(new DigitalButtonListener());
        buttonsPanel.add(buttonDot);

        JButton buttonPlus = new JButton("+");
        buttonPlus.addActionListener(modernCalc ? new DigitalButtonListener() : new ActionButtonListener());
        buttonsPanel.add(buttonPlus);
        JButton buttonMinus = new JButton("-");
        buttonMinus.addActionListener(modernCalc ? new DigitalButtonListener() : new ActionButtonListener());
        buttonsPanel.add(buttonMinus);
        JButton buttonMultiply = new JButton("*");
        buttonMultiply.addActionListener(modernCalc ? new DigitalButtonListener() : new ActionButtonListener());
        buttonsPanel.add(buttonMultiply);
        JButton buttonDivide = new JButton("/");
        buttonDivide.addActionListener(modernCalc ? new DigitalButtonListener() : new ActionButtonListener());
        buttonsPanel.add(buttonDivide);
        JButton buttonEqual = new JButton("=");
        buttonEqual.addActionListener(modernCalc ? new EqualButtonListener() : new ActionButtonListener());
        buttonsPanel.add(buttonEqual);

        JButton buttonClear = new JButton("C");
        buttonClear.addActionListener(new ClearButtonListener());
        buttonsPanel.add(buttonClear);
    }

    private class ActionButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            double newNumber = Double.parseDouble(expresionField.getText());
            String action = source.getText();
            if (previousAction != null && !previousAction.isEmpty() ){
                newNumber = calcExpression(previousNumber, newNumber, previousAction);
            }
            previousAction = action.equals("=") ? null : source.getText();
            previousNumber = newNumber; //Можно не перезаписывать, так как постоянно перезаписывается когад надо
            expresionField.setText(action.equals("=") ? String.valueOf(newNumber) : null);
            secondExpresionField.setText(action.equals("=") ? null : String.valueOf(newNumber));
        }
    }

    private class ClearButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            previousAction = null;
            expresionField.setText(null);
        }
    }

    private class DigitalButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String newValue = expresionField.getText();
            if (source.getText().equals(".")){
                newValue = newValue.replaceAll("\\.", "");
            }
            expresionField.setText(newValue + source.getText()); //Не вижу смысла использовать для добавления одной буквы стринг билдера
        }
    }

    private class EqualButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String expresion = expresionField.getText();
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("js"); //Я так понимаю, что это должно работать в java 11-13, но в 15 версии, которую я использую js движок недоступен, по идее должнол работать)
            try {
                expresionField.setText((String) engine.eval(expresion));
            } catch (ScriptException scriptException) {
                expresionField.setText("ошибка");
            }

        }
    }

    private double calcExpression(double a, double b, String action){
        double res = a;
        switch (action) {
            case "+" -> res += b;
            case "-" -> res -= b;
            case "*" -> res *= b;
            case "/" -> res = b == 0 ? 0 : res / b;
        }
        return res;
    }
}
