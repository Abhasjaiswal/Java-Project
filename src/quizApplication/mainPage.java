package quizApplication;
import java.awt.FontMetrics;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.RenderingHints;
import java.awt.Cursor;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;


public class mainPage {

    JFrame frmQuizApplicationLogin;
    JTextField namefield;
    JCheckBox agree;
    String name;
    JLabel nameset;
    JLabel statusLabel;
    int m=0;
    
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185); // Flat blue
    private static final Color SECONDARY_COLOR = new Color(52, 152, 219); // Light blue
    private static final Color ACCENT_COLOR = new Color(26, 188, 156); // Turquoise
    private static final Color ERROR_COLOR = new Color(231, 76, 60); // Red
    private static final Color BACKGROUND_COLOR = new Color(246, 248, 250); // Light gray/white
    private static final Color TEXT_COLOR = new Color(44, 62, 80); // Dark blue/black
    private static final Color BUTTON_COLOR = new Color(52, 152, 219); // Light blue
    private static final Color BUTTON_HOVER = new Color(41, 128, 185); // Darker blue
    private static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 24);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 18);
    private static final Font REGULAR_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font SMALL_FONT = new Font("Segoe UI", Font.PLAIN, 12);

    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            UIManager.put("OptionPane.background", BACKGROUND_COLOR);
            UIManager.put("Panel.background", BACKGROUND_COLOR);
            UIManager.put("OptionPane.messageForeground", TEXT_COLOR);
            UIManager.put("Button.background", BUTTON_COLOR);
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.font", REGULAR_FONT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainPage window = new mainPage();
                    window.frmQuizApplicationLogin.setLocationRelativeTo(null); // Center the window
                    window.frmQuizApplicationLogin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public mainPage() {
        initialize();
    }

    
    void initialize() {
        
        frmQuizApplicationLogin = new JFrame();
        frmQuizApplicationLogin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to exit the application?", 
                        "Confirm Exit", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE);
                if(a == JOptionPane.YES_OPTION) {
                    frmQuizApplicationLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    frmQuizApplicationLogin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        
        frmQuizApplicationLogin.getContentPane().setFont(REGULAR_FONT);
        frmQuizApplicationLogin.getContentPane().setBackground(BACKGROUND_COLOR);
        frmQuizApplicationLogin.getContentPane().setLayout(new BorderLayout(0, 0));
        
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
        headerPanel.setPreferredSize(new Dimension(450, 70));
        headerPanel.setLayout(new BorderLayout());
        frmQuizApplicationLogin.getContentPane().add(headerPanel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Quiz Application");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(HEADER_FONT);
        headerPanel.add(lblNewLabel, BorderLayout.CENTER);
        
        JLabel lblSubtitle = new JLabel("Test your knowledge");
        lblSubtitle.setForeground(new Color(240, 240, 240));
        lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubtitle.setFont(SMALL_FONT);
        headerPanel.add(lblSubtitle, BorderLayout.SOUTH);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frmQuizApplicationLogin.getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        JPanel formPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
                g2d.setColor(new Color(230, 230, 230));
                g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
        };
        formPanel.setOpaque(false);
        formPanel.setLayout(new GridBagLayout());
        formPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        mainPanel.add(formPanel);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 15, 10, 15);
        
        JLabel lblNewLabel_1 = new JLabel("Enter Your Name:");
        lblNewLabel_1.setFont(REGULAR_FONT);
        lblNewLabel_1.setForeground(TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.3;
        formPanel.add(lblNewLabel_1, gbc);
        
        namefield = new JTextField();
        namefield.setFont(REGULAR_FONT);
        namefield.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.7;
        formPanel.add(namefield, gbc);
        
        agree = new JCheckBox("I confirm that I want to take this quiz");
        agree.setFont(REGULAR_FONT);
        agree.setForeground(TEXT_COLOR);
        agree.setOpaque(false);
        agree.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        formPanel.add(agree, gbc);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);
        
        JButton startbtn = createStyledButton("START", ACCENT_COLOR);
        startbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    name = namefield.getText().trim();
                    boolean check = agree.isSelected();
                
                    if(name.equals("")) {
                        JOptionPane.showMessageDialog(null, 
                            "Please enter your name", 
                            "Name Required", 
                            JOptionPane.WARNING_MESSAGE);
                    }
                    else if(check == false) {
                        JOptionPane.showMessageDialog(null, 
                            "Please agree to the confirmation", 
                            "Agreement Required", 
                            JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        startPage a = new startPage(name);
                        a.setVisible(true);
                        a.setLocationRelativeTo(null); 
                        frmQuizApplicationLogin.dispose();
                    }
                }
                catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        buttonPanel.add(startbtn);
        
        JButton exitbtn = createStyledButton("EXIT", ERROR_COLOR);
        exitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to exit?", 
                        "Confirm Exit", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    frmQuizApplicationLogin.dispose();
                }
            }
        });
        buttonPanel.add(exitbtn);
        
        mainPanel.add(Box.createVerticalStrut(15));
        
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(BACKGROUND_COLOR);
        footerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        statusLabel = new JLabel();
        statusLabel.setForeground(ERROR_COLOR);
        statusLabel.setFont(SMALL_FONT);
        footerPanel.add(statusLabel, BorderLayout.CENTER);
        
        mainPanel.add(footerPanel);
        
        frmQuizApplicationLogin.setTitle("Quiz Application");
        frmQuizApplicationLogin.setSize(new Dimension(500, 400));
        frmQuizApplicationLogin.setResizable(false);
        frmQuizApplicationLogin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    
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
