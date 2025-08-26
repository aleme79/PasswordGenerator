package programa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PassGeneratorGUI extends JFrame {

	private PasswordGenerator passwordGenerator;

	public PassGeneratorGUI() {
		
		super("Generador de Contraseñas");

		setSize(540, 570);

		setResizable(false);

		setLayout(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		passwordGenerator = new PasswordGenerator();

		addGuiComponents();
	}

	private void addGuiComponents() {
		JLabel titleLabel = new JLabel("Generador de Contraseñas");

		titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		titleLabel.setBounds(0, 10, 540, 39);

		add(titleLabel);

		JTextArea passwordOutPut = new JTextArea();

		passwordOutPut.setEditable(false);
		passwordOutPut.setFont(new Font("Dialog", Font.BOLD, 32));

		JScrollPane passwordOutPane = new JScrollPane(passwordOutPut);
		passwordOutPane.setBounds(25, 97, 479, 70);

		passwordOutPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(passwordOutPane);

		JLabel passwordLengthLabel = new JLabel("Longitud de la Contraseña: ");
		passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordLengthLabel.setBounds(25, 215, 272, 39);
		add(passwordLengthLabel);

		JTextArea passwordLengthInputArea = new JTextArea();
		passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
		passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		passwordLengthInputArea.setBounds(310, 215, 192, 39);
		add(passwordLengthInputArea);

		JToggleButton uppercaseToggle = new JToggleButton("Mayúscula");
		uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		uppercaseToggle.setBounds(25, 302, 225, 56);
		add(uppercaseToggle);

		JToggleButton lowercaseToggle = new JToggleButton("Minúscula");
		lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		lowercaseToggle.setBounds(282, 302, 225, 56);
		add(lowercaseToggle);

		JToggleButton numbersToggle = new JToggleButton("Números");
		numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		numbersToggle.setBounds(25, 373, 225, 56);
		add(numbersToggle);

		JToggleButton symbolsToggle = new JToggleButton("Simbolos");
		symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		symbolsToggle.setBounds(282, 373, 225, 56);
		add(symbolsToggle);

		JButton generateButton = new JButton("Generar");
		generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
		generateButton.setBounds(155, 477, 222, 41);
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (passwordLengthInputArea.getText().length() <= 0)
					return;
				boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected()
						|| numbersToggle.isSelected() || symbolsToggle.isSelected();
				int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
				if (anyToggleSelected) {
					String GeneratedPassword = passwordGenerator.generarContraseña(passwordLength,
							uppercaseToggle.isSelected(), lowercaseToggle.isSelected(), numbersToggle.isSelected(),
							symbolsToggle.isSelected());

					passwordOutPut.setText(GeneratedPassword);
				}
			}
		});
		add(generateButton);

	}

}
