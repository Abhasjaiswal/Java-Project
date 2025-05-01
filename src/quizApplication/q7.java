package quizApplication;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class q7 extends JFrame {

    private static final long serialVersionUID = -3985057624056040631L;
    JPanel contentPane;
    ButtonGroup buttonGroup = new ButtonGroup();
    
    // Custom colors for the UI (matching mainPage)
    private static final Color PRIMARY_COLOR = new Color(70, 130, 180); // Steel Blue
    private static final Color SECONDARY_COLOR = new Color(135, 206, 235); // Sky Blue
    private static final Color BUTTON_COLOR = new Color(0, 102, 204); // Royal Blue
    private static final Color HOVER_COLOR = new Color(30, 144, 255); // Dodge Blue

    // Components that need to be accessed by resize handler
    private JPanel headerPanel;
    private JPanel questionPanel;
    private JButton nextButton;
    private JButton previousButton;
    
    String s1;
    int m1;
    int c;
    
    public q7(String name, int m, int count) {
        s1 = name;
        m1 = m;
        c = count;
        
        setTitle("Quiz Application - Question 7");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(new Dimension(600, 450)); // Increased default size
        setMinimumSize(new Dimension(450, 350)); // Set minimum size
        setResizable(true);
        
        // Main content pane with BorderLayout for responsiveness
        contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        // Add window listener for close confirmation
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            
            @Override
            public void windowIconified(WindowEvent e) {}
            
            @Override
            public void windowDeiconified(WindowEvent e) {}
            
            @Override
            public void windowDeactivated(WindowEvent e) {}
            
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "You cannot close this window now. Complete the test first.", 
                        "Quiz in Progress", JOptionPane.WARNING_MESSAGE);
            }

            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}
        });
        
        // Add component resize listener
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // This method will be called when the frame is resized
                resizeComponents();
            }
        });
        
        // Create a gradient panel for the header
        headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, PRIMARY_COLOR, w, h, SECONDARY_COLOR);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        headerPanel.setPreferredSize(new Dimension(600, 70));
        headerPanel.setLayout(new BorderLayout());
        contentPane.add(headerPanel, BorderLayout.NORTH);
        
        JLabel headerLabel = new JLabel("Question 7");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setVerticalAlignment(SwingConstants.CENTER);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        
        // Main content panel with GridBagLayout for better component placement
        questionPanel = new JPanel(new GridBagLayout());
        questionPanel.setBackground(Color.WHITE);
        questionPanel.setBorder(BorderFactory.createCompoundBorder(
            new EmptyBorder(10, 10, 10, 10),
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1, true)
        ));
        contentPane.add(questionPanel, BorderLayout.CENTER);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        
        // Question label
        JLabel lblNewLabel = new JLabel("Which keyword is used to prevent a method from being overridden in Java?");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        questionPanel.add(lblNewLabel, gbc);
        
        // Options
        JRadioButton opt1 = new JRadioButton("static");
        opt1.setBackground(Color.WHITE);
        buttonGroup.add(opt1);
        opt1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt1.setFocusPainted(false);
        gbc.gridy = 1;
        questionPanel.add(opt1, gbc);
        
        JRadioButton opt2 = new JRadioButton("final");
        opt2.setBackground(Color.WHITE);
        buttonGroup.add(opt2);
        opt2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt2.setFocusPainted(false);
        gbc.gridy = 2;
        questionPanel.add(opt2, gbc);
        
        JRadioButton opt3 = new JRadioButton("abstract");
        opt3.setBackground(Color.WHITE);
        buttonGroup.add(opt3);
        opt3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt3.setFocusPainted(false);
        gbc.gridy = 3;
        questionPanel.add(opt3, gbc);
        
        JRadioButton opt4 = new JRadioButton("private");
        opt4.setBackground(Color.WHITE);
        buttonGroup.add(opt4);
        opt4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt4.setFocusPainted(false);
        gbc.gridy = 4;
        questionPanel.add(opt4, gbc);
        
        // Button panel at the bottom
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(new EmptyBorder(0, 0, 10, 10));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        // Previous button with hover effect
        previousButton = new JButton("Previous") {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(BUTTON_COLOR.darker());
                } else if (getModel().isRollover()) {
                    g.setColor(HOVER_COLOR);
                } else {
                    g.setColor(BUTTON_COLOR);
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                
                g.setColor(Color.WHITE);
                String text = "Previous";
                Font font = new Font("Segoe UI", Font.BOLD, 14);
                g.setFont(font);
                
                // Center text
                java.awt.FontMetrics metrics = g.getFontMetrics(font);
                int x = (getWidth() - metrics.stringWidth(text)) / 2;
                int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g.drawString(text, x, y);
            }
        };
        previousButton.setBorderPainted(false);
        previousButton.setFocusPainted(false);
        previousButton.setContentAreaFilled(false);
        previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        previousButton.setPreferredSize(new Dimension(120, 35));
        
        // Custom next button with hover effect
        nextButton = new JButton("Next") {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(BUTTON_COLOR.darker());
                } else if (getModel().isRollover()) {
                    g.setColor(HOVER_COLOR);
                } else {
                    g.setColor(BUTTON_COLOR);
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                
                g.setColor(Color.WHITE);
                String text = "Next";
                Font font = new Font("Segoe UI", Font.BOLD, 14);
                g.setFont(font);
                
                // Center text
                java.awt.FontMetrics metrics = g.getFontMetrics(font);
                int x = (getWidth() - metrics.stringWidth(text)) / 2;
                int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g.drawString(text, x, y);
            }
        };
        nextButton.setBorderPainted(false);
        nextButton.setFocusPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextButton.setPreferredSize(new Dimension(90, 35));
        
        // Add buttons to the panel
        JPanel buttonWrapper = new JPanel(new BorderLayout(10, 0));
        buttonWrapper.setBackground(Color.WHITE);
        
        // Create a panel for the previous button
        JPanel prevButtonPanel = new JPanel(new BorderLayout());
        prevButtonPanel.setBackground(Color.WHITE);
        prevButtonPanel.add(previousButton, BorderLayout.CENTER);
        
        // Create a panel for the next button
        JPanel nextButtonPanel = new JPanel(new BorderLayout());
        nextButtonPanel.setBackground(Color.WHITE);
        nextButtonPanel.add(nextButton, BorderLayout.CENTER);
        
        // Add both buttons to the wrapper
        buttonWrapper.add(prevButtonPanel, BorderLayout.WEST);
        buttonWrapper.add(nextButtonPanel, BorderLayout.EAST);
        
        // Add the wrapper to the button panel
        buttonPanel.add(buttonWrapper, BorderLayout.EAST);
        
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Go back to question 6
                q6 question6 = new q6(s1, m1, c);
                question6.setLocationRelativeTo(null); // Center the window
                question6.setVisible(true);
                dispose();
            }
        });
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(opt2.isSelected()) {
                    m1 = m1 + 5;
                    c = c + 1;
            
                    q8 question8 = new q8(s1, m1, c);
                    question8.setLocationRelativeTo(null); // Center the window
                    question8.setVisible(true);
                    dispose();
                }
                else if(opt1.isSelected() == false && opt3.isSelected() == false && opt4.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Please select an option", "Selection Required", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    q8 question8 = new q8(s1, m1, c);
                    question8.setLocationRelativeTo(null); // Center the window
                    question8.setVisible(true);
                    dispose();
                }
            }
        });
        
        // Set window to center of screen
        setLocationRelativeTo(null);
    }
    
    // Method to handle resizing of components
    private void resizeComponents() {
        int width = getWidth();
        int height = getHeight();
        
        // Adjust font sizes based on window size
        float fontSizeFactor = Math.min(width / 600f, height / 450f);
        int headerFontSize = Math.max(16, Math.round(20 * fontSizeFactor));
        
        // Get header label and update its font
        for (java.awt.Component comp : headerPanel.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                label.setFont(new Font("Segoe UI", Font.BOLD, headerFontSize));
            }
        }
        
        // Update header panel height proportionally
        int headerHeight = Math.max(60, Math.round(70 * fontSizeFactor));
        headerPanel.setPreferredSize(new Dimension(width, headerHeight));
        
        // Refresh layout
        contentPane.revalidate();
    }
}