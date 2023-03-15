//package softwaredesign;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Game extends JFrame {
//    public JPanel[] layout = new JPanel[5];
//
//    private JLabel background = new JLabel();
//    private JLabel title = new JLabel("PrisonBird");
//
//    Game() {
//        this.setSize(800,600);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setTitle("PrisonBird: My Tamagotchi");
////        this.setResizable(false); // Could be adjusted later using an if statement
////        this.getContentPane().setBackground(Color.black);
////        this.setLayout(new BorderLayout(10,10));
//        this.setLayout(new BorderLayout());
//
//        // Could be wrapped inside a function [createLayout()]
//        for (int i = 0; i < 5; i++) {
//            layout[i] = new JPanel();
//        }
//        // TODO: Make layout[1,2] into a panel java class
//        layout[0].setBackground(Color.red); // UPPER
//        layout[1].setBackground(Color.green); // LEFT
//        layout[2].setBackground(Color.yellow); //RIGHT
//        layout[3].setBackground(Color.magenta); // BOTTOM
//        layout[4].setBackground(Color.blue); // MAIN SCREEN
//
//        layout[0].setPreferredSize(new Dimension(600,65));
//        layout[1].setPreferredSize(new Dimension(100,200));
//        layout[2].setPreferredSize(new Dimension(100,200));
//        layout[3].setPreferredSize(new Dimension(600,125));
//        layout[4].setPreferredSize(new Dimension(550,400));
//
//        this.add(layout[0],BorderLayout.NORTH);
//        this.add(layout[1],BorderLayout.WEST);
//        this.add(layout[2],BorderLayout.EAST);
//        this.add(layout[3],BorderLayout.SOUTH);
//        this.add(layout[4],BorderLayout.CENTER);
//
////        layout[1].setLayout(new BorderLayout(50, 50));
//
//        // ------- Adding Components --------
//
//        ImageIcon bgIcon = new ImageIcon("src/main/res/mainbg.jpg");
//        Image originalImage = bgIcon.getImage();
//        int newWidth = bgIcon.getIconWidth() / 3;
//        int newHeight = bgIcon.getIconHeight() / 3;
//        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(scaledImage);
//
//        background.setIcon(scaledIcon);
//        layout[4].add(background);
//
////        title.setBounds(300, 20, 193, 48);
//        title.setBackground(Color.black);
//        title.setForeground(Color.white);
//        title.setFont(new Font("Inter", Font.PLAIN, 26));
//
//        layout[0].add(title);
//
//        JButton button1 = new JButton();
//        JButton button2 = new JButton();
//        JButton button3 = new JButton();
//        JButton button4 = new JButton();
//
//        int height1 = layout[1].getPreferredSize().height;
//        int buttonHeight = height1 / 3;
//        button1.setBounds(10,10,50,50 );
//        button2.setBounds(10,10 + buttonHeight * 2 ,50, 50);
//        System.out.println(layout[1].getLayout());
//
//        layout[1].add(button1);
//        layout[1].add(button2);
//
//        this.setVisible(true);
//    }
//
//}
