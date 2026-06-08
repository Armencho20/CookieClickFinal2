import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame frame;
    JPanel panel;

    JButton cookieButton;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton rebirthButton;

    JLabel cookieLabel;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel rebirthLabel;

    Game game;
    Timer updateTimer;


    public GUI() {
        game = new Game();
        frame = new JFrame();
        panel = new JPanel();

        cookieButton = new JButton("Cookie");
        button1 = new JButton("Upgrade Click");
        button2 = new JButton("Discount");
        button3 = new JButton("2x Cookies (30s)");
        button4 = new JButton("Grandma");
        button5 = new JButton("Super Grandma");
        rebirthButton = new JButton("Rebirth");


        cookieLabel = new JLabel("Cookies: 0");
        label1 = new JLabel("Cost: " + game.cost1 + " | Owned: 0");
        label2 = new JLabel("Cost: " + game.cost2);
        label3 = new JLabel("Cost: " + game.cost3 + " | Owned: 0");
        label4 = new JLabel("Cost: " + game.cost4 + " | Owned: 0");
        label5 = new JLabel("Cost: " + game.cost5 + " | Owned: 0");
        rebirthLabel = new JLabel("Cost: " + game.rebirthCost + " | Rebirths: 0");

        Font font = new Font("Verdana", Font.BOLD, 14);

        cookieLabel.setFont(font);
        cookieLabel.setForeground(new Color(120, 60, 20));

        label1.setFont(font);
        label1.setForeground(new Color(30, 70, 140));

        label2.setFont(font);
        label2.setForeground(new Color(30, 110, 50));

        label3.setFont(font);
        label3.setForeground(new Color(180, 90, 20));

        label4.setFont(font);
        label4.setForeground(new Color(90, 40, 130));

        label5.setFont(font);
        label5.setForeground(new Color(20, 110, 110));

        rebirthLabel.setFont(font);
        rebirthLabel.setForeground(new Color(150, 30, 30));

        ImageIcon cookieIcon = new ImageIcon(getClass().getResource("/cookie.png"));
        Image scaled = cookieIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        cookieButton.setIcon(new ImageIcon(scaled));


        cookieButton.setFont(font);
        cookieButton.setBackground(new Color(160, 90, 40));
        cookieButton.setForeground(new Color(255, 230, 120));
        cookieButton.setOpaque(true);
        cookieButton.setBorderPainted(false);

        button1.setFont(font);
        button1.setBackground(new Color(40, 90, 160));
        button1.setForeground(new Color(180, 240, 255));
        button1.setOpaque(true);
        button1.setBorderPainted(false);


        button2.setFont(font);
        button2.setBackground(new Color(40, 140, 70));
        button2.setForeground(new Color(230, 255, 180));
        button2.setOpaque(true);
        button2.setBorderPainted(false);

        button3.setFont(font);
        button3.setBackground(new Color(210, 110, 30));
        button3.setForeground(new Color(255, 255, 255));
        button3.setOpaque(true);
        button3.setBorderPainted(false);

        button4.setFont(font);
        button4.setBackground(new Color(110, 50, 150));
        button4.setForeground(new Color(255, 200, 240));
        button4.setOpaque(true);
        button4.setBorderPainted(false);


        button5.setFont(font);
        button5.setBackground(new Color(30, 130, 130));
        button5.setForeground(new Color(200, 255, 245));
        button5.setOpaque(true);
        button5.setBorderPainted(false);

        rebirthButton.setFont(font);
        rebirthButton.setBackground(new Color(170, 40, 40));
        rebirthButton.setForeground(new Color(255, 220, 120));
        rebirthButton.setOpaque(true);
        rebirthButton.setBorderPainted(false);


        cookieButton.addActionListener(e -> {
            game.cookieClick();
            cookieLabel.setText("Cookies: " + game.cookieCounter);
        });

        button1.addActionListener(e -> game.buy1());
        button2.addActionListener(e -> game.buy2());
        button3.addActionListener(e -> game.buy3());
        button4.addActionListener(e -> game.buy4());
        button5.addActionListener(e -> game.buy5());
        rebirthButton.addActionListener(e -> game.rebirth());


        panel.setLayout(new GridLayout(7, 2, 5, 5));
        panel.setBackground(Color.PINK);

        panel.add(cookieButton);
        panel.add(cookieLabel);
        panel.add(button1);
        panel.add(label1);
        panel.add(button2);
        panel.add(label2);
        panel.add(button3);
        panel.add(label3);
        panel.add(button4);
        panel.add(label4);
        panel.add(button5);
        panel.add(label5);
        panel.add(rebirthButton);
        panel.add(rebirthLabel);


        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setVisible(true);

        updateTimer = new Timer(250, this);
        updateTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.tickPassive();

        cookieLabel.setText("Cookies: " + game.cookieCounter);
        label1.setText("Cost: " + game.cost1 + " | Owned: " + game.count1);

        if (game.discountUsed) {
            label2.setText("Used");
        } else {
            label2.setText("Cost: " + game.cost2);
        }

        label3.setText("Cost: " + game.cost3 + " | Owned: " + game.count3);
        label4.setText("Cost: " + game.cost4 + " | Owned: " + game.count4);
        label5.setText("Cost: " + game.cost5 + " | Owned: " + game.count5);

        rebirthLabel.setText("Cost: " + game.rebirthCost + " | Rebirths: " + game.rebirthCount);
    }
}


