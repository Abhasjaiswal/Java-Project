package quizApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class resultPage extends JFrame {
    
    private static final long serialVersionUID = 8529261744703725825L;
    
    // Modern color palette
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185); // Flat blue
    private static final Color SECONDARY_COLOR = new Color(52, 152, 219); // Light blue
    private static final Color ACCENT_COLOR = new Color(26, 188, 156); // Turquoise
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113); // Green
    private static final Color WARNING_COLOR = new Color(243, 156, 18); // Orange
    private static final Color ERROR_COLOR = new Color(231, 76, 60); // Red
    private static final Color BACKGROUND_COLOR = new Color(246, 248, 250); // Light gray/white
    private static final Color TEXT_COLOR = new Color(44, 62, 80); // Dark blue/black
    private static final Color PANEL_COLOR = new Color(255, 255, 255); // White
    private static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 24);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 18);
    private static final Font REGULAR_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font SMALL_FONT = new Font("Segoe UI", Font.PLAIN, 12);
    
    private JLabel nameset;
    private JLabel score;
    private JLabel resultDescription;
    private JLabel correctAnswers;
    private String studentName;
    private int marks;
    private int correctCount;
    
    /**
     * Create the results frame
     */
    public resultPage(String name, int m, int count) {
        this.studentName = name;
        this.marks = m;
        this.correctCount = count;
        
        initialize();
    }
    
    /**
     * Initialize the contents of the frame
     */
    private void initialize() {
        setTitle("Quiz Results - " + studentName);
        setBounds(100, 100, 550, 450);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // Add window closing handler
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to exit?", 
                        "Confirm Exit", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
        
        // Main panel
        JPanel contentPane = new JPanel();
        contentPane.setBackground(BACKGROUND_COLOR);
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        // Header panel with gradient
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, PRIMARY_COLOR, w, h, SECONDARY_COLOR);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        headerPanel.setPreferredSize(new Dimension(550, 70));
        headerPanel.setLayout(new BorderLayout());
        contentPane.add(headerPanel, BorderLayout.NORTH);
        
        JLabel headerLabel = new JLabel("Quiz Results");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(HEADER_FONT);
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        
        // Main content panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        contentPane.add(mainPanel, BorderLayout.CENTER);
        
        // Results panel with rounded corners
        JPanel resultsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(PANEL_COLOR);
                g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
                g2d.setColor(new Color(230, 230, 230));
                g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
        };
        resultsPanel.setOpaque(false);
        resultsPanel.setLayout(new GridBagLayout());
        mainPanel.add(resultsPanel);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.weightx = 1.0;
        gbc.gridwidth = 2;
        
        // Student name
        JPanel namePanel = new JPanel(new BorderLayout(10, 0));
        namePanel.setOpaque(false);
        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setFont(REGULAR_FONT);
        nameLabel.setForeground(TEXT_COLOR);
        namePanel.add(nameLabel, BorderLayout.WEST);
        
        nameset = new JLabel(studentName);
        nameset.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nameset.setForeground(TEXT_COLOR);
        namePanel.add(nameset, BorderLayout.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        resultsPanel.add(namePanel, gbc);
        
        // Horizontal divider
        JPanel divider1 = new JPanel();
        divider1.setBackground(new Color(230, 230, 230));
        divider1.setPreferredSize(new Dimension(1, 1));
        divider1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 15, 5, 15);
        resultsPanel.add(divider1, gbc);
        
        // Score panel
        JPanel scorePanel = new JPanel(new BorderLayout(10, 0));
        scorePanel.setOpaque(false);
        JLabel scoreLabel = new JLabel("Score:");
        scoreLabel.setFont(REGULAR_FONT);
        scoreLabel.setForeground(TEXT_COLOR);
        scorePanel.add(scoreLabel, BorderLayout.WEST);
        
        score = new JLabel(marks + " / 50");
        score.setFont(new Font("Segoe UI", Font.BOLD, 14));
        // Score color based on performance
        if (marks == 50) {
            score.setForeground(SUCCESS_COLOR);
        } else if (marks >= 25) {
            score.setForeground(WARNING_COLOR);
        } else {
            score.setForeground(ERROR_COLOR);
        }
        scorePanel.add(score, BorderLayout.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 15, 10, 15);
        resultsPanel.add(scorePanel, gbc);
        
        // Correct answers panel
        JPanel correctPanel = new JPanel(new BorderLayout(10, 0));
        correctPanel.setOpaque(false);
        JLabel correctLabel = new JLabel("Correct Answers:");
        correctLabel.setFont(REGULAR_FONT);
        correctLabel.setForeground(TEXT_COLOR);
        correctPanel.add(correctLabel, BorderLayout.WEST);
        
        correctAnswers = new JLabel(correctCount + " / 10");
        correctAnswers.setFont(new Font("Segoe UI", Font.BOLD, 14));
        // Color based on correct count
        if (correctCount >= 8) {
            correctAnswers.setForeground(SUCCESS_COLOR);
        } else if (correctCount >= 5) {
            correctAnswers.setForeground(WARNING_COLOR);
        } else {
            correctAnswers.setForeground(ERROR_COLOR);
        }
        correctPanel.add(correctAnswers, BorderLayout.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        resultsPanel.add(correctPanel, gbc);
        
        // Horizontal divider
        JPanel divider2 = new JPanel();
        divider2.setBackground(new Color(230, 230, 230));
        divider2.setPreferredSize(new Dimension(1, 1));
        divider2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 15, 5, 15);
        resultsPanel.add(divider2, gbc);
        
        // Result description
        JPanel resultPanel = new JPanel();
        resultPanel.setOpaque(false);
        resultPanel.setLayout(new BorderLayout());
        
        resultDescription = new JLabel();
        resultDescription.setFont(REGULAR_FONT);
        resultDescription.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Set result message and color based on score
        if (marks == 50) {
            resultDescription.setText("<html><div style='text-align: center;'>Congratulations " + studentName + "!<br>You scored full marks in the test!</div></html>");
            resultDescription.setForeground(SUCCESS_COLOR);
        } else if (marks >= 25) {
            resultDescription.setText("<html><div style='text-align: center;'>Good job " + studentName + "!<br>You passed the test.</div></html>");
            resultDescription.setForeground(WARNING_COLOR);
        } else {
            resultDescription.setText("<html><div style='text-align: center;'>Sorry " + studentName + ".<br>You failed the test. Better luck next time!</div></html>");
            resultDescription.setForeground(ERROR_COLOR);
        }
        
        resultPanel.add(resultDescription, BorderLayout.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(15, 15, 15, 15);
        resultsPanel.add(resultPanel, gbc);
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        
        JButton exitButton = createStyledButton("EXIT", ERROR_COLOR);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to exit?", 
                        "Confirm Exit", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
        buttonPanel.add(exitButton);
        
        JButton restartButton = createStyledButton("RESTART", ACCENT_COLOR);
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainPage window = new mainPage();
                window.frmQuizApplicationLogin.setLocationRelativeTo(null);
                window.frmQuizApplicationLogin.setVisible(true);
            }
        });
        buttonPanel.add(restartButton);
        
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(buttonPanel);
        
        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(240, 240, 240));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        footerPanel.setLayout(new BorderLayout());
        
        JLabel footerLabel = new JLabel("Thank you for taking the quiz!");
        footerLabel.setFont(SMALL_FONT);
        footerLabel.setForeground(TEXT_COLOR);
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        footerPanel.add(footerLabel, BorderLayout.CENTER);
        
        contentPane.add(footerPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Creates a stylized button with hover effect
     */
    private JButton createStyledButton(String text, Color baseColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2d.setColor(baseColor.darker());
                } else if (getModel().isRollover()) {
                    g2d.setColor(baseColor.brighter());
                } else {
                    g2d.setColor(baseColor);
                }
                
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                
                g2d.setColor(Color.WHITE);
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 2;
                int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                g2d.drawString(text, x, y);
            }
        };
        
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, 40));
        
        return button;
    }
}
