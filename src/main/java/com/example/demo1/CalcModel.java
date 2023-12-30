package com.example.demo1;

public class CalcModel {
    String labelNum= "";
    String num1 = "";
    String sign = "";
    HelloController helloController;

    public CalcModel(HelloController helloController) {
        this.helloController = helloController;

    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }


    public void setNum(int num) {
        labelNum+=num;
        helloController.setLabelNum(labelNum);
    }

    public void plus() {
        num1 = labelNum;
        labelNum = "";
        sign = "+";
        helloController.setLabelNum(labelNum);
    }

    public void equal() {
        int res = switch (sign) {
            case "+" -> sum(Integer.parseInt(num1), Integer.parseInt(labelNum));
            case "-" -> sub(Integer.parseInt(num1), Integer.parseInt(labelNum));
            case "*" -> mul(Integer.parseInt(num1), Integer.parseInt(labelNum));
            default -> 0;
        };
        labelNum = String.valueOf(res);
        helloController.setLabelNum(labelNum);
    }
}
