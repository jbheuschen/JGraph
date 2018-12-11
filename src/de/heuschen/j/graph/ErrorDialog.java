package de.heuschen.j.graph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ErrorDialog extends JDialog {

	private static final long serialVersionUID = -4979985090315025196L;
	private final JPanel contentPanel = new JPanel();

	public ErrorDialog(String error) {
		setTitle("Fehler");
		setSize(450, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Beim Berechnen des Graphes ist ein Fehler aufgetreten:");
		lblNewLabel.setBounds(30, 25, 360, 14);
		contentPanel.add(lblNewLabel);

		JLabel label = new JLabel(error);
		label.setBounds(30, 50, 360, 14);
		contentPanel.add(label);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton close = new JButton("Schlieﬂen");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ErrorDialog.this.dispose();
			}
		});
		buttonPane.add(close);
		getRootPane().setDefaultButton(close);

		setVisible(true);
	}

}
