import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {

    JFrame frame;
    JLabel timeLabel;

    public DigitalClock() {

        frame = new JFrame("Digital Clock");
        frame.setSize(500,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        timeLabel = new JLabel("", SwingConstants.CENTER);

        timeLabel.setFont(
                new Font("Arial",
                        Font.BOLD,
                        40)
        );

        frame.add(timeLabel);

        Timer timer = new Timer(
                1000,
                e -> updateTime()
        );

        timer.start();

        updateTime();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateTime() {

        SimpleDateFormat format =
                new SimpleDateFormat(
                        "HH:mm:ss"
                );

        String currentTime =
                format.format(
                        new Date()
                );

        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new DigitalClock()
        );
    }
}