package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;


public class Window {
    private JTextField[][] sudokuCells = new JTextField[9][9];
    private String[] messages;
    private Sudoku sudoku;
    private JFrame frame;

    private int exitCode = 8;

    public void run() {
        sudoku = new Sudoku();

        frame = new JFrame(messages[0]);
        Container container = frame.getContentPane();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        container.setBackground(new Color(99, 152, 157));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel title = new JLabel(messages[1]);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("华文彩云", Font.PLAIN, 70));
        title.setSize(350, 100);
        title.setLocation(225, 30);
        container.add(title);

        RoundButton exit = new RoundButton("退出游戏", 20);
        exit.setSize(100, 30);
        exit.setLocation(30, 30);
        exit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, messages[exitCode], messages[2], JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
        container.add(exit);

        JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(new GridLayout(9, 9, 1, 1));
        sudokuPanel.setBounds(125, 150, 540, 540);

        RoundButton restart = new RoundButton("重新开始", 20);
        restart.setSize(100, 30);
        restart.setLocation(30, 80);
        restart.addActionListener(e -> {
            game();
        });
        container.add(restart);

        RoundButton check = new RoundButton("提交答案", 20);
        check.setSize(100, 30);
        check.setLocation(660, 30);
        check.addActionListener(e -> {
            int[][] sudokuData = getSudokuAnswers();
            if (sudoku.checkAnswer(sudokuData)) {
                checkDialog(frame, messages[13], messages[15]);
                exitCode = 9;
            } else {
                checkDialog(frame, messages[14], messages[15]);
            }
        });
        container.add(check);

        RoundButton reset = new RoundButton("重置游戏", 20);
        reset.setSize(100, 30);
        reset.setLocation(660, 80);
        reset.addActionListener(e -> {
            printToPanel(sudoku.getSudoku());
        });
        container.add(reset);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("Arial", Font.BOLD, 24));
                cell.setBorder(BorderFactory.createLineBorder(new Color(99, 152, 157)));
                cell.setBackground(new Color(186, 232, 236));
                sudokuCells[row][col] = cell;
                cell.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!Character.isDigit(c) || c < '1' || c > '9' || !cell.getText().isEmpty()) {
                            e.consume();
                        }
                    }
                });
                sudokuPanel.add(cell);
            }
        }

        container.add(sudokuPanel);
        frame.setVisible(true);

    }

    public void game() {
        String difficulty = difficultyChoose();
        while (difficulty == null) {
            difficulty = difficultyChoose();
        }
        switch (difficulty) {
            case "easy":
                exitCode = exitCode == 9 ? 9 : 5;
                break;
            case "medium":
                exitCode = exitCode == 9 ? 9 : 6;
                break;
            case "hard":
                exitCode = exitCode == 9 ? 9 : 7;
                break;
            default:
                exitCode = exitCode == 9 ? 9 : 8;
        }
        sudoku.createSudoku(difficulty);
        printToPanel(sudoku.getSudoku());
    }

    private void checkDialog(Component parent, String content, String title) {
        JDialog checkDialog = new JDialog(frame, title, true);
        checkDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        checkDialog.setSize(300, 200);
        checkDialog.setLocationRelativeTo(frame);
        checkDialog.setModal(true);
        checkDialog.setResizable(false);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));

        JLabel label = new JLabel(content);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(label);

        contentPanel.add(Box.createVerticalStrut(20));

        RoundButton btn = new RoundButton("确定", 20);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkDialog.dispose();
            }
        });
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(btn);

        checkDialog.setLayout(new BorderLayout());
        checkDialog.add(contentPanel, BorderLayout.CENTER);

        checkDialog.setVisible(true);
    }

    private String difficultyChoose() {
        final String[] selectedDifficulty = {null};
        JDialog gameStartMenu = new JDialog(frame, messages[3], true);
        gameStartMenu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gameStartMenu.setSize(400, 200);
        gameStartMenu.setLocationRelativeTo(frame);
        gameStartMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
        gameStartMenu.setModal(true);
        gameStartMenu.setResizable(false);

        RoundButton easyBtn = new RoundButton(messages[10], 20);
        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDifficulty[0] = "easy";
                gameStartMenu.dispose();
            }
        });

        RoundButton mediumBtn = new RoundButton(messages[11], 20);
        mediumBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDifficulty[0] = "medium";
                gameStartMenu.dispose();
            }
        });

        RoundButton hardBtn = new RoundButton(messages[12], 20);
        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDifficulty[0] = "hard";
                gameStartMenu.dispose();
            }
        });

        easyBtn.setSize(100, 40);
        mediumBtn.setSize(100, 40);
        hardBtn.setSize(100, 40);
        gameStartMenu.add(easyBtn);
        gameStartMenu.add(mediumBtn);
        gameStartMenu.add(hardBtn);

        gameStartMenu.setVisible(true);

        return selectedDifficulty[0] != null ? selectedDifficulty[0] : "easy";
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    private int[][] getSudokuAnswers() {
        int[][] sudokuAnswers = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sudokuAnswers[row][col] = Integer.parseInt(Objects.equals(sudokuCells[row][col].getText(), "") ? "0" : sudokuCells[row][col].getText());
            }
        }
        return sudokuAnswers;
    }

    private void setSudoku(int[][] sudoku) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sudokuCells[row][col].setText(String.valueOf(sudoku[row][col]));
            }
        }
    }

    private void printToPanel(int[][] sudokuData) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = sudokuCells[row][col];
                int num = sudokuData[row][col];

                cell.setText("");
                cell.setForeground(Color.BLACK);
                cell.setEditable(true);

                if (num != 0) {
                    cell.setText(String.valueOf(num));
                    cell.setEditable(false);
                    cell.setForeground(new Color(100, 100, 100));
                }
            }
        }
    }
}
