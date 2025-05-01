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

public class q10 extends JFrame {

    private static final long serialVersionUID = -3985057624056040632L;
    JPanel contentPane;
    ButtonGroup buttonGroup = new ButtonGroup();
    
    // Custom colors for the UI (matching mainPage, q1, and q9)
    private static final Color PRIMARY_COLOR = new Color(70, 130, 180); // Steel Blue
    private static final Color SECONDARY_COLOR = new Color(135, 206, 235); // Sky Blue
    private static final Color BUTTON_COLOR = new Color(0, 102, 204); // Royal Blue
    private static final Color HOVER_COLOR = new Color(30, 144, 255); // Dodge Blue
    private static final Color SUBMIT_COLOR = new Color(46, 139, 87); // Sea Green
    private static final Color SUBMIT_HOVER_COLOR = new Color(60, 179, 113); // Medium Sea Green

    // Components that need to be accessed by resize handler
    private JPanel headerPanel;
    private JPanel questionPanel;
    private JButton submitButton;
    private JButton prevButton;
    
    String s1;
    int m1;
    int c;
    
    public q10(String name, int m, int count) {
        s1 = name;
        m1 = m;
        c = count;
        
        setTitle("Quiz Application - Final Question");
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
        
        JLabel headerLabel = new JLabel("Question 10");
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
        JLabel lblNewLabel = new JLabel("<html>What will be the result of trying to compile and run the following code?<br><br>" +
                "public class Test {<br>" +
                "&nbsp;&nbsp;public static void main(String[] args) {<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;try {<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int[] array = new int[5];<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(array[5]);<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;} catch (NullPointerException e) {<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Null Pointer Exception\");<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;}<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"End of program\");<br>" +
                "&nbsp;&nbsp;}<br>" +
                "}</html>");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        questionPanel.add(lblNewLabel, gbc);
        
        // Options
        JRadioButton opt1 = new JRadioButton("It will print \"Null Pointer Exception\" followed by \"End of program\"");
        opt1.setBackground(Color.WHITE);
        buttonGroup.add(opt1);
        opt1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt1.setFocusPainted(false);
        gbc.gridy = 1;
        questionPanel.add(opt1, gbc);
        
        JRadioButton opt2 = new JRadioButton("It will print \"End of program\"");
        opt2.setBackground(Color.WHITE);
        buttonGroup.add(opt2);
        opt2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt2.setFocusPainted(false);
        gbc.gridy = 2;
        questionPanel.add(opt2, gbc);
        
        JRadioButton opt3 = new JRadioButton("It will throw an ArrayIndexOutOfBoundsException and terminate");
        opt3.setBackground(Color.WHITE);
        buttonGroup.add(opt3);
        opt3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt3.setFocusPainted(false);
        gbc.gridy = 3;
        questionPanel.add(opt3, gbc);
        
        JRadioButton opt4 = new JRadioButton("It will compile but not run");
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
        prevButton = new JButton("Previous") {
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
        prevButton.setBorderPainted(false);
        prevButton.setFocusPainted(false);
        prevButton.setContentAreaFilled(false);
        prevButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        prevButton.setPreferredSize(new Dimension(100, 35));
        
        // Submit button with hover effect (using a different color to indicate finality)
        submitButton = new JButton("Submit") {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(SUBMIT_COLOR.darker());
                } else if (getModel().isRollover()) {
                    g.setColor(SUBMIT_HOVER_COLOR);
                } else {
                    g.setColor(SUBMIT_COLOR);
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                
                g.setColor(Color.WHITE);
                String text = "Submit";
                Font font = new Font("Segoe UI", Font.BOLD, 14);
                g.setFont(font);
                
                // Center text
                java.awt.FontMetrics metrics = g.getFontMetrics(font);
                int x = (getWidth() - metrics.stringWidth(text)) / 2;
                int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g.drawString(text, x, y);
            }
        };
        submitButton.setBorderPainted(false);
        submitButton.setFocusPainted(false);
        submitButton.setContentAreaFilled(false);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setPreferredSize(new Dimension(100, 35));
        
        // Add buttons to the button panel
        JPanel leftWrapper = new JPanel(new BorderLayout());
        leftWrapper.setBackground(Color.WHITE);
        leftWrapper.add(prevButton, BorderLayout.WEST);
        buttonPanel.add(leftWrapper, BorderLayout.WEST);
        
        JPanel rightWrapper = new JPanel(new BorderLayout());
        rightWrapper.setBackground(Color.WHITE);
        rightWrapper.add(submitButton, BorderLayout.EAST);
        buttonPanel.add(rightWrapper, BorderLayout.EAST);
        
        // Add action listener for the previous button
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Return to question 9
                q9 question9 = new q9(s1, m1, c);
                question9.setLocationRelativeTo(null); // Center the window
                question9.setVisible(true);
                dispose();
            }
        });
        
        // Add action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(opt3.isSelected()) {
                    m1 = m1 + 5;
                    c = c + 1;
            
                    score scoreCard = new score(s1, m1, c);
                    scoreCard.setLocationRelativeTo(null); // Center the window
                    scoreCard.setVisible(true);
                    dispose();
                }
                else if(opt1.isSelected() == false && opt2.isSelected() == false && opt4.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Please select an option", "Selection Required", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    score scoreCard = new score(s1, m1, c);
                    scoreCard.setLocationRelativeTo(null); // Center the window
                    scoreCard.setVisible(true);
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