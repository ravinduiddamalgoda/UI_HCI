import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainInterface extends JFrame {

    public MainInterface() {
        initComponents();
    }

    private void initComponents() {
        JLabel jLabel2 = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/comp2Main.jpg"))));
        JLabel jLabel4 = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/comp3Main.jpg"))));
        JLabel jLabel5 = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/LogoElite.png"))));
        JButton jButton1 = new JButton("SIGN OUT");
        JButton jButton2 = new JButton("Let's Start");
        JLabel jLabel6 = new JLabel("VISUALIZE - CUSTOMIZE - PERSONALIZE", SwingConstants.CENTER);
        JLabel jLabel7 = new JLabel(new ImageIcon(getClass().getResource("/comp1Main.jpg")));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel jPanel1 = new JPanel(new BorderLayout());
        jPanel1.setBackground(new Color(144, 95, 60));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(144, 95, 60));
        jLabel5.setPreferredSize(new Dimension(250, 150));
        topPanel.add(jLabel5);
        topPanel.add(Box.createHorizontalStrut(20));
        jButton1.setBackground(new Color(144, 95, 60));
        jButton1.setForeground(new Color(251, 180, 12));
        jButton1.setFont(jButton1.getFont().deriveFont(Font.BOLD, 16));
        topPanel.add(jButton1);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(144, 95, 60));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10); // Adding padding around items
        centerPanel.add(jLabel2, gbc);

        gbc.gridx = 1;
        centerPanel.add(jLabel7, gbc);

        gbc.gridx = 2;
        centerPanel.add(jLabel4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 20, 10);
        jLabel6.setForeground(new Color(251, 180, 12));
        jLabel6.setFont(jLabel6.getFont().deriveFont(Font.BOLD, 18));
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Open the SelectMethod class when jButton2 is clicked
                new SelectType().setVisible(true);
            }
        });
        centerPanel.add(jLabel6, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        jButton2.setBackground(new Color(144, 95, 60));
        jButton2.setForeground(new Color(251, 180, 12));
        jButton2.setFont(jButton2.getFont().deriveFont(Font.BOLD, 16)); // font size
        centerPanel.add(jButton2, gbc);

        jPanel1.add(topPanel, BorderLayout.NORTH);
        jPanel1.add(centerPanel, BorderLayout.CENTER);

        add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainInterface().setVisible(true);
        });
    }
}
