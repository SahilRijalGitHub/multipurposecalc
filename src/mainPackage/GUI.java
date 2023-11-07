package mainPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;


public class GUI extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        DecimalFormat decimalFormat = new DecimalFormat("#.###");

        // main window
        primaryStage.
                setTitle("Multipurpose Calculator with Differentiation!");
        primaryStage.setWidth(395);
        primaryStage.setHeight(550);

        Pane mainPane = new Pane();
        Scene mainScene = new Scene(mainPane);

        Button goToDerivativeCalcButton = new
                Button("Derivative Calculator");
        goToDerivativeCalcButton.setLayoutX(130);
        goToDerivativeCalcButton.setLayoutY(80);

//        Button goToMatrixFunctionsButton = new Button("Matrix Functions");
//        goToMatrixFunctionsButton.setLayoutX(140);
//        goToMatrixFunctionsButton.setLayoutY(155);

        Button goToSimultaneousSolverButton = new
                Button("Simultaneous Equation Solver");
        goToSimultaneousSolverButton.setLayoutX(105);
        goToSimultaneousSolverButton.setLayoutY(180);

        Button goToNumberSortButton = new Button("Sort Numbers");
        goToNumberSortButton.setLayoutX(145);
        goToNumberSortButton.setLayoutY(280);

        Button goToNormalCalculator = new
                Button("Normal Calculator");
        goToNormalCalculator.setLayoutX(135);
        goToNormalCalculator.setLayoutY(380);

        // derivative calculator window

        Stage derivativeCalcStage = new Stage();
        derivativeCalcStage.setTitle("Derivative Calculator!");
        derivativeCalcStage.setWidth(395);
        derivativeCalcStage.setHeight(550);
        derivativeCalcStage.setX(525);
        derivativeCalcStage.setY(43);

        Pane derivativeCalcPane = new Pane();
        Scene derivativeCalcScene = new Scene(derivativeCalcPane);

        TextField derivativeInputTextField = new TextField();
        derivativeInputTextField.setLayoutX(62);
        derivativeInputTextField.setLayoutY(55);
        derivativeInputTextField.setPrefWidth(250);

        Button findDerivativeButton = new
                Button("Find Derivative");
        findDerivativeButton.setLayoutX(138);
        findDerivativeButton.setLayoutY(105);

        Label showDerivativeLabel = new Label("Hello");
        showDerivativeLabel.setLayoutX(40);
        showDerivativeLabel.setLayoutY(400);

        Text rulesText = new Text(" These are the rules:\n " +
                "This differentiates with respect to x.\n " +
                "Do not use any spaces.\n " +
                "For sin, cos, tan and ln, use: [ ].\n " +
                "For powers, use: < >.\n " +
                "For the product rule, use the format: a(f(x))(g(x)).\n " +
                "For the chain rule, use the format: a(f(x))<b>.\n " +
                "You may nest the different available functions.");
        rulesText.setLayoutX(40);
        rulesText.setLayoutY(175);


        derivativeCalcPane.getChildren().
                addAll(derivativeInputTextField, findDerivativeButton,
                        showDerivativeLabel, rulesText);
        derivativeCalcStage.setScene(derivativeCalcScene);

        goToDerivativeCalcButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                derivativeInputTextField.setText("");
                showDerivativeLabel.setText("");
                derivativeCalcStage.show();
            }
        });

        findDerivativeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String input = derivativeInputTextField.getText();
                String derivative;
                if (input.matches("^[xesctl0-9-+()<>\\[\\]]+$")) {
                    derivative = SplitedListDifferentiation.
                            mainDiff(PolynomialSplit.PolySplit(input));
                }
                else {
                    derivative = "Invalid";
                }
                showDerivativeLabel.setText(derivative);
                showDerivativeLabel.setFont(new Font(15));
            }
        });


        // Simultaneous Equation Solver Window

        Stage simultaneousEquationSolverStage = new Stage();
        simultaneousEquationSolverStage.
                setTitle("Simultaneous Equation solver!");
        simultaneousEquationSolverStage.setWidth(395);
        simultaneousEquationSolverStage.setHeight(550);
        simultaneousEquationSolverStage.setX(400);
        simultaneousEquationSolverStage.setY(43);

        Pane simultaneousEquationSolverPane = new Pane();
        Scene simultaneousEquationSolverScene = new
                Scene(simultaneousEquationSolverPane);

        Button goToTwoSimultaneousEquationSolverButton = new
                Button("2 Equations");
        goToTwoSimultaneousEquationSolverButton.setLayoutX(150);
        goToTwoSimultaneousEquationSolverButton.setLayoutY(100);

        Button goToThreeSimultaneousEquationSolverButton = new
                Button("3 Equations");
        goToThreeSimultaneousEquationSolverButton.setLayoutX(150);
        goToThreeSimultaneousEquationSolverButton.setLayoutY(200);

        Button goToFourSimultaneousEquationSolverButton = new
                Button("4 Equations");
        goToFourSimultaneousEquationSolverButton.setLayoutX(150);
        goToFourSimultaneousEquationSolverButton.setLayoutY(300);



            // Two Simultaneous Equations
        Stage twoSimultaneousEquationSolverStage = new Stage();
        twoSimultaneousEquationSolverStage.
                setTitle("Two Simultaneous Equation solver!");
        twoSimultaneousEquationSolverStage.setWidth(450);
        twoSimultaneousEquationSolverStage.setHeight(550);
        twoSimultaneousEquationSolverStage.setX(450);
        twoSimultaneousEquationSolverStage.setY(43);

        Pane twoSimultaneousEquationSolverPane = new Pane();
        Scene twoSimultaneousEquationSolverScene = new
                Scene(twoSimultaneousEquationSolverPane);

        TextField xInput1TextField = new TextField();
        xInput1TextField.setPrefWidth(40);
        xInput1TextField.setLayoutX(5);
        xInput1TextField.setLayoutY(50);

        Label x1Label = new Label("x");
        x1Label.setFont(new Font(30));
        x1Label.setLayoutX(50);
        x1Label.setLayoutY(40);

        TextField xInput2TextField = new TextField();
        xInput2TextField.setPrefWidth(40);
        xInput2TextField.setLayoutX(5);
        xInput2TextField.setLayoutY(90);

        Label x2Label = new Label("x");
        x2Label.setFont(new Font(30));
        x2Label.setLayoutX(50);
        x2Label.setLayoutY(80);

        TextField yInput1TextField = new TextField();
        yInput1TextField.setPrefWidth(40);
        yInput1TextField.setLayoutX(105);
        yInput1TextField.setLayoutY(50);

        Label y1Label = new Label("y");
        y1Label.setFont(new Font(30));
        y1Label.setLayoutX(150);
        y1Label.setLayoutY(40);

        TextField yInput2TextField = new TextField();
        yInput2TextField.setPrefWidth(40);
        yInput2TextField.setLayoutX(105);
        yInput2TextField.setLayoutY(90);

        Label y2Label = new Label("y");
        y2Label.setFont(new Font(30));
        y2Label.setLayoutX(150);
        y2Label.setLayoutY(80);

        Label add1Label = new Label("+");
        add1Label.setFont(new Font(30));
        add1Label.setLayoutX(80);
        add1Label.setLayoutY(40);

        Label add2Label = new Label("+");
        add2Label.setFont(new Font(30));
        add2Label.setLayoutX(80);
        add2Label.setLayoutY(80);

        Label equals1Label = new Label("=");
        equals1Label.setFont(new Font(30));
        equals1Label.setLayoutX(350);
        equals1Label.setLayoutY(40);

        TextField RHSInput1TextField = new TextField();
        RHSInput1TextField.setPrefWidth(40);
        RHSInput1TextField.setLayoutX(385);
        RHSInput1TextField.setLayoutY(50);

        Label equals2Label = new Label("=");
        equals2Label.setFont(new Font(30));
        equals2Label.setLayoutX(350);
        equals2Label.setLayoutY(80);

        TextField RHSInput2TextField = new TextField();
        RHSInput2TextField.setPrefWidth(40);
        RHSInput2TextField.setLayoutX(385);
        RHSInput2TextField.setLayoutY(90);

        Button solveTwoSimultaneousEquationButton = new
                Button("Solve");
        solveTwoSimultaneousEquationButton.setLayoutX(200);
        solveTwoSimultaneousEquationButton.setLayoutY(200);

        Label xAnswerLabel = new Label();
        xAnswerLabel.setFont(new Font(30));
        xAnswerLabel.setLayoutX(40);
        xAnswerLabel.setLayoutY(300);

        Label yAnswerLabel = new Label();
        yAnswerLabel.setFont(new Font(30));
        yAnswerLabel.setLayoutX(40);
        yAnswerLabel.setLayoutY(350);

        twoSimultaneousEquationSolverPane.getChildren().
                addAll(xAnswerLabel, yAnswerLabel,
                        solveTwoSimultaneousEquationButton, xInput1TextField,
                        x1Label, xInput2TextField,
                        x2Label, yInput1TextField,
                        y1Label, yInput2TextField,
                        y2Label, add1Label,
                        add2Label, equals1Label,
                        RHSInput1TextField, equals2Label, RHSInput2TextField);
        twoSimultaneousEquationSolverStage.
                setScene(twoSimultaneousEquationSolverScene);

        goToTwoSimultaneousEquationSolverButton.
                setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                xInput1TextField.setText("");
                xInput2TextField.setText("");
                yInput1TextField.setText("");
                yInput2TextField.setText("");
                RHSInput1TextField.setText("");
                RHSInput2TextField.setText("");
                xAnswerLabel.setText("");
                yAnswerLabel.setText("");
                twoSimultaneousEquationSolverStage.show();
            }
        });

        solveTwoSimultaneousEquationButton.
                setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                xAnswerLabel.setText("");
                yAnswerLabel.setText("");
                try {
                    double[][] LHSArray = {{Double.parseDouble(xInput1TextField.getText()),
                            Double.parseDouble(yInput1TextField.getText())},
                            {Double.parseDouble(xInput2TextField.getText()),
                                    Double.parseDouble(yInput2TextField.getText())}};
                    double[][] RHSArray = {{Double.parseDouble(RHSInput1TextField.getText())},
                            {Double.parseDouble(RHSInput2TextField.getText())}};
                    Matrix LHSMatrix = new Matrix(LHSArray);
                    Matrix RHSMatrix = new Matrix(RHSArray);
                    Matrix INVMatrix = Matrix.matrixInverse(LHSMatrix);
                    if (INVMatrix == null) {
                        xAnswerLabel.setText("No solutions, equations are parallel.");
                        xAnswerLabel.setFont(new Font(20));
                    } else {
                        Matrix ANSMatrix = Matrix.
                                matrixMultiplication(INVMatrix, RHSMatrix);
                        double[][] ANSArray = ANSMatrix.getMatrixData();
                        double x = ANSArray[0][0];
                        double y = ANSArray[1][0];
                        x = Double.parseDouble(decimalFormat.format(x));
                        y = Double.parseDouble(decimalFormat.format(y));
                        xAnswerLabel.setText("x = " + x);
                        yAnswerLabel.setText("y = " + y);
                        xAnswerLabel.setFont(new Font(30));
                    }
                }
                catch(Exception e){
                    xAnswerLabel.setText("Invalid");
                    xAnswerLabel.setFont(new Font(20));

                }
            }
        });
        

            // Three Simultaneous Equations
        Stage threeSimultaneousEquationSolverStage = new Stage();
        threeSimultaneousEquationSolverStage.
                setTitle("Three Simultaneous Equation solver!");
        threeSimultaneousEquationSolverStage.setWidth(450);
        threeSimultaneousEquationSolverStage.setHeight(550);
        threeSimultaneousEquationSolverStage.setX(350);
        threeSimultaneousEquationSolverStage.setY(43);

        Pane threeSimultaneousEquationSolverPane = new Pane();
        Scene threeSimultaneousEquationSolverScene = new
                Scene(threeSimultaneousEquationSolverPane);


        TextField xInput3TextField = new TextField();
        xInput3TextField.setPrefWidth(40);
        xInput3TextField.setLayoutX(5);
        xInput3TextField.setLayoutY(50);

        Label x3Label = new Label("x");
        x3Label.setFont(new Font(30));
        x3Label.setLayoutX(50);
        x3Label.setLayoutY(40);

        TextField xInput4TextField = new TextField();
        xInput4TextField.setPrefWidth(40);
        xInput4TextField.setLayoutX(5);
        xInput4TextField.setLayoutY(90);

        Label x4Label = new Label("x");
        x4Label.setFont(new Font(30));
        x4Label.setLayoutX(50);
        x4Label.setLayoutY(80);

        TextField xInput5TextField = new TextField();
        xInput5TextField.setPrefWidth(40);
        xInput5TextField.setLayoutX(5);
        xInput5TextField.setLayoutY(130);

        Label x5Label = new Label("x");
        x5Label.setFont(new Font(30));
        x5Label.setLayoutX(50);
        x5Label.setLayoutY(120);

        TextField yInput3TextField = new TextField();
        yInput3TextField.setPrefWidth(40);
        yInput3TextField.setLayoutX(105);
        yInput3TextField.setLayoutY(50);

        Label y3Label = new Label("y");
        y3Label.setFont(new Font(30));
        y3Label.setLayoutX(150);
        y3Label.setLayoutY(40);

        TextField yInput4TextField = new TextField();
        yInput4TextField.setPrefWidth(40);
        yInput4TextField.setLayoutX(105);
        yInput4TextField.setLayoutY(90);

        Label y4Label = new Label("y");
        y4Label.setFont(new Font(30));
        y4Label.setLayoutX(150);
        y4Label.setLayoutY(80);

        TextField yInput5TextField = new TextField();
        yInput5TextField.setPrefWidth(40);
        yInput5TextField.setLayoutX(105);
        yInput5TextField.setLayoutY(130);

        Label y5Label = new Label("y");
        y5Label.setFont(new Font(30));
        y5Label.setLayoutX(150);
        y5Label.setLayoutY(120);

        TextField zInput1TextField = new TextField();
        zInput1TextField.setPrefWidth(40);
        zInput1TextField.setLayoutX(205);
        zInput1TextField.setLayoutY(50);

        Label z1Label = new Label("z");
        z1Label.setFont(new Font(30));
        z1Label.setLayoutX(250);
        z1Label.setLayoutY(40);

        TextField zInput2TextField = new TextField();
        zInput2TextField.setPrefWidth(40);
        zInput2TextField.setLayoutX(205);
        zInput2TextField.setLayoutY(90);

        Label z2Label = new Label("z");
        z2Label.setFont(new Font(30));
        z2Label.setLayoutX(250);
        z2Label.setLayoutY(80);

        TextField zInput3TextField = new TextField();
        zInput3TextField.setPrefWidth(40);
        zInput3TextField.setLayoutX(205);
        zInput3TextField.setLayoutY(130);

        Label z3Label = new Label("z");
        z3Label.setFont(new Font(30));
        z3Label.setLayoutX(250);
        z3Label.setLayoutY(120);

        Label add3Label = new Label("+");
        add3Label.setFont(new Font(30));
        add3Label.setLayoutX(80);
        add3Label.setLayoutY(40);

        Label add4Label = new Label("+");
        add4Label.setFont(new Font(30));
        add4Label.setLayoutX(80);
        add4Label.setLayoutY(80);

        Label add5Label = new Label("+");
        add5Label.setFont(new Font(30));
        add5Label.setLayoutX(80);
        add5Label.setLayoutY(120);

        Label add6Label = new Label("+");
        add6Label.setFont(new Font(30));
        add6Label.setLayoutX(180);
        add6Label.setLayoutY(40);

        Label add7Label = new Label("+");
        add7Label.setFont(new Font(30));
        add7Label.setLayoutX(180);
        add7Label.setLayoutY(80);

        Label add8Label = new Label("+");
        add8Label.setFont(new Font(30));
        add8Label.setLayoutX(180);
        add8Label.setLayoutY(120);

        Label equals3Label = new Label("=");
        equals3Label.setFont(new Font(30));
        equals3Label.setLayoutX(350);
        equals3Label.setLayoutY(40);

        TextField RHSInput3TextField = new TextField();
        RHSInput3TextField.setPrefWidth(40);
        RHSInput3TextField.setLayoutX(385);
        RHSInput3TextField.setLayoutY(50);

        Label equals4Label = new Label("=");
        equals4Label.setFont(new Font(30));
        equals4Label.setLayoutX(350);
        equals4Label.setLayoutY(80);

        TextField RHSInput4TextField = new TextField();
        RHSInput4TextField.setPrefWidth(40);
        RHSInput4TextField.setLayoutX(385);
        RHSInput4TextField.setLayoutY(90);

        Label equals5Label = new Label("=");
        equals5Label.setFont(new Font(30));
        equals5Label.setLayoutX(350);
        equals5Label.setLayoutY(120);

        TextField RHSInput5TextField = new TextField();
        RHSInput5TextField.setPrefWidth(40);
        RHSInput5TextField.setLayoutX(385);
        RHSInput5TextField.setLayoutY(130);

        Button solveThreeSimultaneousEquationButton = new
                Button("Solve");
        solveThreeSimultaneousEquationButton.setLayoutX(200);
        solveThreeSimultaneousEquationButton.setLayoutY(225);

        Label xAnswerLabel2 = new Label();
        xAnswerLabel2.setFont(new Font(30));
        xAnswerLabel2.setLayoutX(40);
        xAnswerLabel2.setLayoutY(300);

        Label yAnswerLabel2 = new Label();
        yAnswerLabel2.setFont(new Font(30));
        yAnswerLabel2.setLayoutX(40);
        yAnswerLabel2.setLayoutY(350);

        Label zAnswerLabel = new Label();
        zAnswerLabel.setFont(new Font(30));
        zAnswerLabel.setLayoutX(40);
        zAnswerLabel.setLayoutY(400);


        threeSimultaneousEquationSolverPane.getChildren().
                addAll(x3Label, x4Label,
                        x5Label, xInput3TextField,
                        xInput4TextField, xInput5TextField,
                        xAnswerLabel2, y3Label,
                        y4Label, y5Label,
                        yInput3TextField, yInput4TextField,
                        yInput5TextField, yAnswerLabel2,
                        z1Label, z2Label,
                        z3Label, zInput1TextField,
                        zInput2TextField, zInput3TextField,
                        zAnswerLabel, equals3Label,
                        equals4Label, equals5Label,
                        add3Label, add4Label, add5Label,
                        add6Label, add7Label, add8Label,
                        solveThreeSimultaneousEquationButton,
                        RHSInput3TextField, RHSInput4TextField, RHSInput5TextField);
        threeSimultaneousEquationSolverStage.
                setScene(threeSimultaneousEquationSolverScene);

        goToThreeSimultaneousEquationSolverButton.
                setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                xInput3TextField.setText("");
                xInput4TextField.setText("");
                xInput5TextField.setText("");
                yInput3TextField.setText("");
                yInput4TextField.setText("");
                yInput5TextField.setText("");
                zInput1TextField.setText("");
                zInput2TextField.setText("");
                zInput3TextField.setText("");
                RHSInput3TextField.setText("");
                RHSInput4TextField.setText("");
                RHSInput5TextField.setText("");
                xAnswerLabel2.setText("");
                yAnswerLabel2.setText("");
                zAnswerLabel.setText("");
                threeSimultaneousEquationSolverStage.show();
            }
        });

        solveThreeSimultaneousEquationButton.
                setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                xAnswerLabel2.setText("");
                yAnswerLabel2.setText("");
                zAnswerLabel.setText("");
                try {
                    double[][] LHSArray = {{Double.parseDouble(xInput3TextField.getText()),
                            Double.parseDouble(yInput3TextField.getText()),
                            Double.parseDouble(zInput1TextField.getText())},
                            {Double.parseDouble(xInput4TextField.getText()),
                                    Double.parseDouble(yInput4TextField.getText()),
                                    Double.parseDouble(zInput2TextField.getText())},
                            {Double.parseDouble(xInput5TextField.getText()),
                                    Double.parseDouble(yInput5TextField.getText()),
                                    Double.parseDouble(zInput3TextField.getText())}};
                    double[][] RHSArray = {{Double.parseDouble(RHSInput3TextField.getText())},
                            {Double.parseDouble(RHSInput4TextField.getText())},
                            {Double.parseDouble(RHSInput5TextField.getText())}};
                    Matrix LHSMatrix = new Matrix(LHSArray);
                    Matrix RHSMatrix = new Matrix(RHSArray);
                    Matrix INVMatrix = Matrix.matrixInverse(LHSMatrix);
                    if (INVMatrix == null) {
                        xAnswerLabel2.setText("No solutions, equations are parallel.");
                        xAnswerLabel2.setFont(new Font(20));
                    } else {
                        Matrix ANSMatrix = Matrix.
                                matrixMultiplication(INVMatrix, RHSMatrix);
                        double[][] ANSArray = ANSMatrix.getMatrixData();
                        double x = ANSArray[0][0];
                        double y = ANSArray[1][0];
                        double z = ANSArray[2][0];
                        x = Double.parseDouble(decimalFormat.format(x));
                        y = Double.parseDouble(decimalFormat.format(y));
                        z = Double.parseDouble(decimalFormat.format(z));
                        xAnswerLabel2.setText("x = " + x);
                        yAnswerLabel2.setText("y = " + y);
                        zAnswerLabel.setText("z = " + z);
                        xAnswerLabel2.setFont(new Font(30));
                    }
                }
                catch(Exception e){
                    xAnswerLabel2.setText("Invalid");
                    xAnswerLabel2.setFont(new Font(20));
                }
            }
        });

        simultaneousEquationSolverPane.getChildren().
                addAll(goToTwoSimultaneousEquationSolverButton,
                        goToThreeSimultaneousEquationSolverButton);
        simultaneousEquationSolverStage.setScene(simultaneousEquationSolverScene);

        goToSimultaneousSolverButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                simultaneousEquationSolverStage.show();
            }
        });

        // Number Sorter Window

        Stage numberSortStage = new Stage();
        numberSortStage.setTitle("Number Sorter!");
        numberSortStage.setWidth(395);
        numberSortStage.setHeight(550);
        numberSortStage.setX(500);
        numberSortStage.setY(43);

        Pane numberSortPane = new Pane();
        Scene numberSortScene = new Scene(numberSortPane);

        TextArea numbersInputTextArea = new TextArea();
        numbersInputTextArea.setLayoutX(30);
        numbersInputTextArea.setLayoutY(40);
        numbersInputTextArea.setPrefWidth(320);
        numbersInputTextArea.setPrefHeight(200);
        numbersInputTextArea.setWrapText(true);

        Button sortNumbersButton = new Button("Sort Numbers");
        sortNumbersButton.setLayoutX(145);
        sortNumbersButton.setLayoutY(300);

        Text sortedNumbersText = new Text();
        sortedNumbersText.setLayoutX(30);
        sortedNumbersText.setLayoutY(350);
        sortedNumbersText.setWrappingWidth(320);

        numberSortPane.getChildren().
                addAll(numbersInputTextArea, sortNumbersButton,
                        sortedNumbersText);
        numberSortStage.setScene(numberSortScene);

        goToNumberSortButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numbersInputTextArea.setText("");
                numberSortStage.show();
            }
        });

        sortNumbersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String input = numbersInputTextArea.getText();
                String[] arrStringInput;
                boolean isComma;
                if (input.contains(", ")){
                    arrStringInput = input.split(", ");
                    isComma = true;
                }
                else if (input.contains(",")){
                    arrStringInput = input.split(",");
                    isComma = true;
                }
                else {
                    arrStringInput = input.split(" ");
                    isComma = false;
                }
                try {
                    int[] arrIntInput = Arrays.
                            stream(arrStringInput).
                            mapToInt(Integer::parseInt).toArray();
                    NumberSort.sort(arrIntInput, 0,
                            arrIntInput.length - 1);
                    String output = Arrays.toString(arrIntInput);
                    output = output.replace("[" , "");
                    output = output.replace("]", "");
                    if (!isComma){
                        output = output.replace(",", "");
                    }
                    sortedNumbersText.setText(output);
                }
                catch(Exception e){
                    sortedNumbersText.setText("Invalid input");

                }
            }
        });


        // Normal Calculator Window

        Stage normalCalcStage = new Stage();
        normalCalcStage.setTitle("Normal Calculator!");
        normalCalcStage.setWidth(395);
        normalCalcStage.setHeight(550);
        normalCalcStage.setX(443);
        normalCalcStage.setY(75);

        Pane normalCalcPane = new Pane();
        Scene normalCalcScene = new Scene(normalCalcPane);

        Button dotButton = new Button(".");
        dotButton.setLayoutX(150);
        dotButton.setLayoutY(400);

        Button zeroButton = new Button("0");
        zeroButton.setLayoutX(100);
        zeroButton.setLayoutY(400);

        Button oneButton = new Button("1");
        oneButton.setLayoutX(50);
        oneButton.setLayoutY(350);

        Button twoButton = new Button("2");
        twoButton.setLayoutX(100);
        twoButton.setLayoutY(350);

        Button threeButton = new Button("3");
        threeButton.setLayoutX(150);
        threeButton.setLayoutY(350);

        Button fourButton = new Button("4");
        fourButton.setLayoutX(50);
        fourButton.setLayoutY(300);

        Button fiveButton = new Button("5");
        fiveButton.setLayoutX(100);
        fiveButton.setLayoutY(300);

        Button sixButton = new Button("6");
        sixButton.setLayoutX(150);
        sixButton.setLayoutY(300);

        Button sevenButton = new Button("7");
        sevenButton.setLayoutX(50);
        sevenButton.setLayoutY(250);

        Button eightButton = new Button("8");
        eightButton.setLayoutX(100);
        eightButton.setLayoutY(250);

        Button nineButton = new Button("9");
        nineButton.setLayoutX(150);
        nineButton.setLayoutY(250);

        Button addButton = new Button("+");
        addButton.setLayoutX(250);
        addButton.setLayoutY(250);

        Button subButton = new Button("-");
        subButton.setLayoutX(300);
        subButton.setLayoutY(250);

        Button multButton = new Button("*");
        multButton.setLayoutX(250);
        multButton.setLayoutY(300);

        Button divButton = new Button("/");
        divButton.setLayoutX(300);
        divButton.setLayoutY(300);

        Button equalsButton = new Button("=");
        equalsButton.setLayoutX(300);
        equalsButton.setLayoutY(350);

        Button deleteButton = new Button("DELETE");
        deleteButton.setLayoutX(50);
        deleteButton.setLayoutY(200);

        Button clearAllButton = new Button("CLEAR ALL");
        clearAllButton.setLayoutX(125);
        clearAllButton.setLayoutY(200);

        Button openBracketButton = new Button("(");
        openBracketButton.setLayoutX(250);
        openBracketButton.setLayoutY(200);

        Button closeBracketButton = new Button(")");
        closeBracketButton.setLayoutX(300);
        closeBracketButton.setLayoutY(200);

        Text inputText = new Text();
        inputText.setFont(new Font(30));
        inputText.setLayoutX(50);
        inputText.setLayoutY(50);

        Text outputText = new Text();
        outputText.setFont(new Font(30));
        outputText.setLayoutX(50);
        outputText.setLayoutY(125);

        dotButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "."));
        zeroButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "0"));
        oneButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "1"));
        twoButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "2"));
        threeButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "3"));
        fourButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "4"));
        fiveButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "5"));
        sixButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "6"));
        sevenButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "7"));
        eightButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "8"));
        nineButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "9"));
        addButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "+"));
        subButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "-"));
        multButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "*"));
        divButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "/"));
        openBracketButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + "("));
        closeBracketButton.setOnAction(actionEvent -> inputText.
                setText(inputText.getText() + ")"));
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (inputText.getText().length() > 0){
                    inputText.setText(inputText.getText().
                            substring(0, inputText.getText().
                                    length() - 1));

                }
            }
        });
        clearAllButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                inputText.setText("");
                outputText.setText("");
            }
        });

        equalsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (inputText.getText().length() > 0){
                    boolean isSyntaxError = false;
                    String input = inputText.getText();
                    for (int i = 0; i < input.length(); i = i + 1){
                        if(((input.charAt(i) == '+')
                                || (input.charAt(i) == '-')
                                || (input.charAt(i) == '*')
                                || (input.charAt(i) == '/'))
                            && ((input.charAt(i + 1) == '+')
                                || (input.charAt(i + 1) == '-')
                                || (input.charAt(i + 1) == '*')
                                || (input.charAt(i + 1) == '/'))){
                            isSyntaxError = true;
                            break;
                        }
                    }
                    if (isSyntaxError){
                        outputText.setText("Invalid Syntax");
                    }
                    else {
                        try {
                            float output = NormalCalc.
                                    evaluateExpression(input);
                            float Output = BigDecimal.valueOf(output).
                                    setScale(5, BigDecimal.
                                            ROUND_HALF_DOWN).floatValue();
                            outputText.setText(String.valueOf(Output));
                        }
                        catch(Exception e){
                            outputText.setText("Maths Error");
                        }
                    }
                }
            }
        });


        normalCalcPane.getChildren().
                addAll(inputText, outputText, dotButton,
                        zeroButton, oneButton, twoButton,
                        threeButton, fourButton, fiveButton,
                        sixButton, sevenButton, eightButton,
                        nineButton, addButton, subButton,
                        multButton, divButton, equalsButton,
                        deleteButton, clearAllButton,
                        openBracketButton, closeBracketButton);
        normalCalcStage.setScene(normalCalcScene);

        goToNormalCalculator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                inputText.setText("");
                outputText.setText("");
                normalCalcStage.show();
            }
        });



        mainPane.getChildren().
                addAll(goToDerivativeCalcButton,
                        goToSimultaneousSolverButton,
                        goToNumberSortButton,
                        goToNormalCalculator);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
