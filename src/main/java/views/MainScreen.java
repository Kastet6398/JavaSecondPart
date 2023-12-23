package views;

import controllers.BaseController;
import enums.Names;

import javax.swing.*;
import java.awt.*;

public final class MainScreen extends BaseScreen {

    public MainScreen(BaseController controller) {
        super(controller, "Calculator", 720, 570);
    }

    private static final Font font = new Font("Arial", Font.BOLD, 16);

    @Override
    protected void initComponents() {
        setLayout(null);
        JTextField textField = new JTextField();
        textField.setName(Names.EXPRESSION_FIELD.name());
        textField.setFont(font);
        textField.setBounds(0, 0, 720, 50);
        add(textField);

        createButton("(", 0, 50);

        createButton(")", 80, 50);

        createButton("%", 160, 50);

        createButton("+", 240, 50);
        createButton("-", 240, 130);
        createButton("×", 240, 210);
        createButton("÷", 240, 290);
        createButton("√", "ins√()", 240, 370);

        createButton("ℯ", 320, 50);
        createButton("π", 320, 130);
        createButton(">", 320, 210);
        createButton("<", 320, 290);
        createButton("==", 320, 370);

        createButton("!", 400, 50);
        createButton("≠", 400, 130);
        createButton("≥", 400, 210);
        createButton("≤", 400, 290);
        createButton("∛", "ins∛()", 400, 370);

        createButton("&&", 480, 50);
        createButton("||", 480, 130);
        createButton("sin", "inssin()", 480, 210);
        createButton("cos", "inscos()", 480, 290);
        createButton("sec", "inssec()", 480, 370);

        createButton("tan", "instan()", 560, 50);
        createButton("cot", "inscot()", 560, 130);
        createButton("atan", "insatan()", 560, 210);
        createButton("acot", "insacot()", 560, 290);
        createButton("csc", "inscsc()", 640, 50);

        createButton("rad", "insrad()", 640, 130);
        createButton("deg", "insdeg()", 640, 210);
        createButton("⌫", Names.BACK.name(), 640, 290, Color.orange);

        int num = 9;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                createButton(String.valueOf(num--), "ins" + (num + 1), (2 - j) * 80, 50 + 80 * (i + 1));

        createButton("0", "ins0", 0, 370);
        createButton(".", "ins.", 80, 370);

        createButton("=", Names.CALCULATE.name(), 560, 370, Color.green);
        createButton("C", Names.CLEAR.name(), 640, 370, Color.RED);

        createButton("^", "ins^", 160, 370);

        JTextField result = new JTextField("RESULT");
        result.setFont(new Font("Arial", Font.BOLD, 16));
        result.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        result.setEditable(false);
        result.setName(Names.RESULT_FIELD.name());
        result.setBounds(0, 450, 720, 80);
        add(result);
        setResizable(false);
    }

    private void createButton(String text, String name, int x, int y) {
        createButton(text, name, x, y, null);
    }

    private void createButton(String text, int x, int y) {
        createButton(text, "ins" + text, x, y);
    }

    private void createButton(String text, String name, int x, int y, Color color) {
        JButton button = new JButton(text);
        button.setName(name);
        button.setFont(font);
        button.setBackground(color);
        button.setBounds(x, y, 80, 80);
        add(button);
    }
}
