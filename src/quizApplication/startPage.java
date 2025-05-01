package quizApplication;
import java.awt.FontMetrics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Cursor;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class startPage extends JFrame {

    private static final long serialVersionUID = 3096525787044740026L;
    
    // Modern color palette
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185); // Flat blue
    private static final Color SECONDARY_COLOR = new Color(52, 152, 219); // Light blue
    private static final Color ACCENT_COLOR = new Color(26, 188, 156); // Turquoise
    private static final Color BACKGROUND_COLOR = new Color(246, 248, 250); // Light gray/white
    private static final Color TEXT_COLOR = new Color(44, 62, 80); // Dark blue/black
    private static final Color PANEL_COLOR = new Color(255, 255, 255); // White
    private static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 24);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 18);
    private static final Font REGULAR_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font SMALL_FONT = new Font("Segoe UI", Font.PLAIN, 12);
    
    JPanel contentPane;
    JLabel textname;
    JButton startbtn;
    JLabel date;
    JLabel time;
    int m=0;
    String s1;
    int count=0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // Method left empty intentionally
    }

    /**
     * Create the frame.
     */
    public startPage(String name) {
        s1 = name;
        setBackground(BACKGROUND_COLOR);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        contentPane = new JPanel();
        contentPane.setBackground(BACKGROUND_COLOR);
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        setTitle("Quiz Instructions");
        
        // Create header panel with gradient
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
        
        textname = new JLabel("Welcome, " + s1);
        textname.setForeground(Color.WHITE);
        textname.setHorizontalAlignment(SwingConstants.CENTER);
        textname.setFont(HEADER_FONT);
        headerPanel.add(textname, BorderLayout.CENTER);
        
        // Main content panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        contentPane.add(mainPanel, BorderLayout.CENTER);
        
        // Instructions panel with rounded corners
        JPanel instructionPanel = new JPanel() {
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
        instructionPanel.setOpaque(false);
        instructionPanel.setLayout(new GridBagLayout());
        mainPanel.add(instructionPanel);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 15, 5, 15);
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        
        // Instructions title
        JLabel instructionTitle = new JLabel("Quiz Instructions");
        instructionTitle.setFont(TITLE_FONT);
        instructionTitle.setForeground(PRIMARY_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 15, 15, 15);
        instructionPanel.add(instructionTitle, gbc);
        
        // Instruction points with icons
        addInstruction(instructionPanel, gbc, 1, "Press the Start button to begin your quiz.");
        addInstruction(instructionPanel, gbc, 2, "The quiz consists of 10 questions worth 5 marks each.");
        addInstruction(instructionPanel, gbc, 3, "You need 23 marks to pass the quiz.");
        addInstruction(instructionPanel, gbc, 4, "Once you click the Next button, you cannot return to previous questions.");
        addInstruction(instructionPanel, gbc, 5, "The total quiz is worth 50 marks.");
        
        // Button panel at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        
        startbtn = createStyledButton("START QUIZ", ACCENT_COLOR);
        startbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                q1 q = new q1(s1, m, count);
                q.setVisible(true);
                q.setLocationRelativeTo(null); // Center on screen
                dispose();
            }
        });
        startbtn.setToolTipText("Click to start the quiz");
        buttonPanel.add(startbtn);
        
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(buttonPanel);
        
        // Footer panel with date and time
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(new Color(240, 240, 240));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        contentPane.add(footerPanel, BorderLayout.SOUTH);
        
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        timePanel.setOpaque(false);
        
        JLabel loginLabel = new JLabel("Login time:");
        loginLabel.setFont(SMALL_FONT);
        loginLabel.setForeground(TEXT_COLOR);
        timePanel.add(loginLabel);
        
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime dt = LocalDateTime.now();
        String logindate = dt.format(df);
        
        date = new JLabel(logindate);
        date.setFont(SMALL_FONT);
        date.setForeground(TEXT_COLOR);
        timePanel.add(date);
        
        timePanel.add(Box.createHorizontalStrut(10));
        
        DateTimeFormatter dtime = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime dtimes = LocalTime.now();
        String logintime = dtimes.format(dtime);
        
        time = new JLabel(logintime);
        time.setFont(SMALL_FONT);
        time.setForeground(TEXT_COLOR);
        timePanel.add(time);
        
        footerPanel.add(timePanel, BorderLayout.WEST);
    }
    
    /**
     * Add an instruction item with bullet point styling
     */
    private void addInstruction(JPanel panel, GridBagConstraints gbc, int number, String text) {
        gbc.gridy = number;
        gbc.insets = new Insets(5, 15, 5, 15);
        
        JPanel itemPanel = new JPanel(new BorderLayout(10, 0));
        itemPanel.setOpaque(false);
        
        // Create number bullet
        JLabel bullet = new JLabel(number + ".");
        bullet.setFont(new Font("Segoe UI", Font.BOLD, 14));
        bullet.setForeground(SECONDARY_COLOR);
        bullet.setHorizontalAlignment(SwingConstants.RIGHT);
        bullet.setPreferredSize(new Dimension(30, 25));
        itemPanel.add(bullet, BorderLayout.WEST);
        
        // Instruction text
        JLabel instruction = new JLabel(text);
        instruction.setFont(REGULAR_FONT);
        instruction.setForeground(TEXT_COLOR);
        itemPanel.add(instruction, BorderLayout.CENTER);
        
        panel.add(itemPanel, gbc);
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
        button.setPreferredSize(new Dimension(160, 45));
        
        return button;
    }
}
