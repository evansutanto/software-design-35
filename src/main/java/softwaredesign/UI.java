//package softwaredesign;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class UI {
//    Main gm;
//
//    JFrame window;
//
//    public JTextArea text;
//    private JProgressBar healthBar;
//    public JPanel bgImage[] = new JPanel[10];
//    public JLabel bgLabel[] = new JLabel[10];
//
//    public UI(Main gm) {
//        this.gm = gm;
//
//        createMainField();
//        createBackground();
//        createObject();
//        window.setVisible(true);
//    }
//
//    public void createMainField() {
//        window = new JFrame();
//        window.setSize(800,600);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setResizable(false);
//        window.getContentPane().setBackground(Color.black);
//        window.setLayout(null);
//
//        // Could be for Indicator just window.add
//        text = new JTextArea("PrisonBird");
//        text.setBounds(300, 20, 193, 48);
//        text.setBackground(Color.black);
//        text.setForeground(Color.white);
//        text.setEditable(false);
//        text.setLineWrap(true);
//        text.setWrapStyleWord(true);
//        text.setFont(new Font("Inter", Font.PLAIN, 26));
//        window.add(text);
//
//        JPanel healthBarPanel = new JPanel();
//        healthBarPanel.setBounds(100, 500, 600, 50);
//        healthBarPanel.setBackground(Color.white);
//
//        window.add(healthBarPanel);
//
//        JPanel sidebar1 = new JPanel() {
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                int x = 10;
//                int y = 10;
//                int width = getWidth() - 20;
//                int height = getHeight() - 20;
//                int circleHeight = height / 3; // divide the height into 3 equal parts
//                g.setColor(Color.RED);
//                g.drawOval(x, y, width, circleHeight); // top circle
//                g.drawOval(x, y + circleHeight * 2, width, circleHeight); // bottom circle
//            }
//        };
//        sidebar1.setBounds(35, 135, 65, 235);
//        sidebar1.setBackground(Color.white);
//
//        JPanel sidebar2 = new JPanel();
//        sidebar2.setBounds(700, 135, 65, 235);
//        sidebar2.setBackground(Color.white);
//
//        window.add(sidebar1);
//        window.add(sidebar2);
//    }
//
//    public void createBackground() {
//        bgImage[1] = new JPanel();
//        bgImage[1].setBounds(125,80,550,400);
//        bgImage[1].setBackground(Color.blue);
//        bgImage[1].setLayout(null);
//        window.add(bgImage[1]);
//
//        bgLabel[1] = new JLabel();
//        bgLabel[1].setBounds(0,0,550,400);
//        ImageIcon bgIcon = new ImageIcon("src/main/res/mainbg.jpg");
//        Image originalImage = bgIcon.getImage();
//        int newWidth = bgIcon.getIconWidth() / 3;
//        int newHeight = bgIcon.getIconHeight() / 3;
//        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(scaledImage);
//
//        bgLabel[1].setIcon(scaledIcon);
//        bgImage[1].add(bgLabel[1]);
//
//    }
//    public void createObject() {
//    }
//}
