import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class UserInterface extends JFrame implements ActionListener {
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField patronymicField;
    private JTextField birthDateField;
    private JTextField phoneNumberField;
    private JTextField genderField;

    public UserInterface() {
        super("Введите данные");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        JLabel surnameLabel =new JLabel("Фамилия:");
        surnameField = new JTextField();
        panel.add(surnameLabel);
        panel.add(surnameField);

        JLabel nameLabel = new JLabel("Имя:");
        nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel patronymicLabel = new JLabel("Отчество:");
        patronymicField = new JTextField();
        panel.add(patronymicLabel);
        panel.add(patronymicField);

        JLabel birthDateLabel = new JLabel("Дата рождения:");
        birthDateField = new JTextField();
        panel.add(birthDateLabel);
        panel.add(birthDateField);

        JLabel phoneNumberLabel = new JLabel("Номер телефона:");
        phoneNumberField = new JTextField();
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);

        JLabel genderLabel = new JLabel("Пол:");
        genderField = new JTextField();
        panel.add(genderLabel);
        panel.add(genderField);

        JButton submitButton = new JButton("Отправить");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String surname = surnameField.getText();
        String name = nameField.getText();
        String patronymic = patronymicField.getText();
        String birthDate = birthDateField.getText();
        String phoneNumber = phoneNumberField.getText();
        String gender = genderField.getText();

        try {
            FileWriter writer = new FileWriter("data.txt", true);
            writer.write(surname + "," + name + "," + patronymic + "," + birthDate + "," + phoneNumber + "," + gender + "\n");
            writer.close();
            JOptionPane.showMessageDialog(this, "Данные успешно отправлены");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при отправке данных");
        }
    }

    public static void main(String[] args) {
        new UserInterface();
    }
}

