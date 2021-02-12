package chat;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Chat extends JFrame {
    private JPanel chatPanel;
    private JTextField messageTextField;
    private JScrollPane scrollPane;

    public Chat(){
        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createWindow();
        setVisible(true);
        setBounds(50, 50, 300, 500);
    }


    private void createWindow(){
        setLayout(new BorderLayout());

        chatPanel = new JPanel();
        BoxLayout layout = new BoxLayout(chatPanel, BoxLayout.Y_AXIS);
        chatPanel.setLayout(layout);
        scrollPane = new JScrollPane(chatPanel);
        //scrollPane.add(chatPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel messagePanel = new JPanel(new BorderLayout());
        messageTextField = new JTextField();
        messageTextField.addKeyListener(new MessageSendListener());
        JButton messageSendButton = new JButton("Отправить");
        messageSendButton.addActionListener(new MessageSendListener());
        messagePanel.add(messageTextField, BorderLayout.CENTER);
        messagePanel.add(messageSendButton, BorderLayout.EAST);
        add(messagePanel, BorderLayout.SOUTH);

        JMenuBar menu = new JMenuBar();
        JMenu chatMenu = new JMenu("Окно");
        JMenuItem clearButton = new JMenuItem("Очистить");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatPanel.removeAll();
                //chatPanel.repaint();
                scrollPane.repaint();
            }
        });
        chatMenu.add(clearButton);
        menu.add(chatMenu);
        add(menu, BorderLayout.NORTH);
    }

    private class MessageSendListener implements ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            processAction();
        }

        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e) { }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == 10){
                processAction();
            }
        }

        private void processAction(){
            String messageText = messageTextField.getText();
            messageTextField.setText(null);
            boolean evenChildren = chatPanel.getComponentCount() % 2 == 0;
            JPanel messagePanel = new JPanel(new BorderLayout());
            JLabel message = new JLabel(messageText, evenChildren ? SwingConstants.LEFT : SwingConstants.RIGHT);
            messagePanel.add(message, evenChildren ? BorderLayout.WEST : BorderLayout.EAST);
            chatPanel.add(messagePanel);
            scrollPane.validate();
        }
    }

}
