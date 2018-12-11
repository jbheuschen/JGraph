package de.heuschen.j.graph;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class JGraphFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4484439934078533732L;
	private JPanel contentPane;
	private JTextField equation;
	private JSpinner range;
	private JCheckBox nullX, negativeX;

	/**
	 * Create the frame.
	 */
	public JGraphFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("JGraph");
		setSize(800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGleichung = new JLabel("Gleichung:");
		lblGleichung.setBounds(10, 55, 100, 14);
		contentPane.add(lblGleichung);

		JLabel lblY = new JLabel("y = ");
		lblY.setBounds(120, 55, 20, 14);
		contentPane.add(lblY);

		equation = new JTextField();
		equation.setToolTipText("Beispiel: 3*x+7, eine ung\u00FCltige Gleichung ergibt 0.");
		equation.setBounds(150, 52, 100, 20);
		contentPane.add(equation);
		equation.setColumns(10);

		JButton generate = new JButton("Graph generieren");
		generate.setBounds(624, 51, 150, 23);
		contentPane.add(generate);

		JLabel lblZahlenbereich = new JLabel("Zahlenbereich:");
		lblZahlenbereich.setBounds(260, 55, 84, 14);
		contentPane.add(lblZahlenbereich);

		range = new JSpinner();
		range.setToolTipText(
				"Gibt den Zahlenbereich an, f\u00FCr den die Gleichung berechnet wird. Zu gro\u00DFe Zahlen k\u00F6nnen Lags verursachen.");
		range.setBounds(354, 52, 66, 20);
		range.setModel(new SpinnerNumberModel(15, 0, 10000, 0.5));
		contentPane.add(range);

		nullX = new JCheckBox("Null");
		nullX.setSelected(true);
		nullX.setToolTipText(
				"Entscheidet, ob f\u00FCr x auch null eingesetzt werden soll. Sollte z.b. bei 1/x deaktiviert werden.");
		nullX.setBounds(426, 51, 66, 23);
		contentPane.add(nullX);

		negativeX = new JCheckBox("negative X");
		negativeX.setSelected(true);
		negativeX.setToolTipText(
				"Entscheidet, ob f\u00FCr x negative Werte eingesetzt werden.  Sollte z.B. bei Wurzeln deaktiviert sein.");
		negativeX.setBounds(494, 51, 97, 23);
		contentPane.add(negativeX);

		JLabel lblDerGraphWird = new JLabel("Der Graph wird in einem neuen Fenster ge\u00F6ffnet.");
		lblDerGraphWird.setBounds(260, 325, 331, 14);
		contentPane.add(lblDerGraphWird);

		generate.addActionListener(this);
		RefineryUtilities.centerFrameOnScreen(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!equation.getText().trim().isEmpty()) {
			try {
				JGraphView v = new JGraphView(equation.getText().trim(), Double.valueOf(range.getValue().toString()), nullX.isSelected(), negativeX.isSelected());
				new JGraphViewFrame(equation.getText(), v.getChart());
			} catch (Exception e) {
				new ErrorDialog(e.getLocalizedMessage());
				return;
			}
		}
	}
}
