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

public class q1 extends JFrame {

    private static final long serialVersionUID = -3985057624056040625L;
    JPanel contentPane;
    ButtonGroup buttonGroup = new ButtonGroup();
    
    private static final Color PRIMARY_COLOR = new Color(70, 130, 180); // Steel Blue
    private static final Color SECONDARY_COLOR = new Color(135, 206, 235); // Sky Blue
    private static final Color BUTTON_COLOR = new Color(0, 102, 204); // Royal Blue
    private static final Color HOVER_COLOR = new Color(30, 144, 255); // Dodge Blue

    private JPanel headerPanel;
    private JPanel questionPanel;
    private JButton nextButton;
    
    String s1;
    int m1;
    int c;
    
    public q1(String name, int m, int count) {
        s1 = name;
        m1 = m;
        c = count;
        
        setTitle("Quiz Application - Question 1");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(new Dimension(600, 450)); 
        setMinimumSize(new Dimension(450, 350)); 
        setResizable(true);
        
        contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
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
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });
        
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
        
        JLabel headerLabel = new JLabel("Question 1");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setVerticalAlignment(SwingConstants.CENTER);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        
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
        
        JLabel lblNewLabel = new JLabel("What is correct Syntax for main method of java class?");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        questionPanel.add(lblNewLabel, gbc);
        
        JRadioButton opt1 = new JRadioButton("public static int main(String [] args)");
        opt1.setBackground(Color.WHITE);
        buttonGroup.add(opt1);
        opt1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt1.setFocusPainted(false);
        gbc.gridy = 1;
        questionPanel.add(opt1, gbc);
        
        JRadioButton opt2 = new JRadioButton("public int main(String [] args)");
        opt2.setBackground(Color.WHITE);
        buttonGroup.add(opt2);
        opt2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt2.setFocusPainted(false);
        gbc.gridy = 2;
        questionPanel.add(opt2, gbc);
        
        JRadioButton opt3 = new JRadioButton("public static void main(String [] args)");
        opt3.setBackground(Color.WHITE);
        buttonGroup.add(opt3);
        opt3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt3.setFocusPainted(false);
        gbc.gridy = 3;
        questionPanel.add(opt3, gbc);
        
        JRadioButton opt4 = new JRadioButton("None of the Above");
        opt4.setBackground(Color.WHITE);
        buttonGroup.add(opt4);
        opt4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opt4.setFocusPainted(false);
        gbc.gridy = 4;
        questionPanel.add(opt4, gbc);
        
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(new EmptyBorder(0, 0, 10, 10));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
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
        
        JPanel buttonWrapper = new JPanel(new BorderLayout());
        buttonWrapper.setBackground(Color.WHITE);
        buttonWrapper.add(nextButton, BorderLayout.EAST);
        buttonPanel.add(buttonWrapper, BorderLayout.EAST);
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(opt3.isSelected()) {
                    m1 = m1 + 5;
                    c = c + 1;
            
                    q2 question2 = new q2(s1, m1, c);
                    question2.setLocationRelativeTo(null);                     question2.setVisible(true);
                    dispose();
                }
                else if(opt1.isSelected() == false && opt2.isSelected() == false && opt4.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Please select an option", "Selection Required", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    q2 question2 = new q2(s1, m1, c);
                    question2.setLocationRelativeTo(null);                     question2.setVisible(true);
                    dispose();
                }
            }
        });
        
        setLocationRelativeTo(null);
    }
    
    private void resizeComponents() {
        int width = getWidth();
        int height = getHeight();
        
        float fontSizeFactor = Math.min(width / 600f, height / 450f);
        int headerFontSize = Math.max(16, Math.round(20 * fontSizeFactor));
        
        for (java.awt.Component comp : headerPanel.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                label.setFont(new Font("Segoe UI", Font.BOLD, headerFontSize));
            }
        }
        
        int headerHeight = Math.max(60, Math.round(70 * fontSizeFactor));
        headerPanel.setPreferredSize(new Dimension(width, headerHeight));
        
        contentPane.revalidate();
    }
}
