package de.heuschen.j.graph;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartPanel;

public class JGraphViewFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2910786555975397616L;

	/**
	 * Create the frame.
	 */
	public JGraphViewFrame(String equation, ChartPanel graph) {

		JMenuBar m = new JMenuBar();

		JMenu export = new JMenu("Exportieren");
		JMenuItem print = new JMenuItem("Drucken");
		JMenuItem save = new JMenuItem("Als PDF speichern");

		export.add(save);
		export.add(print);

		m.add(export);

		setJMenuBar(m);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(500, 500);
		setTitle("JGraph | " + equation);
		setContentPane(graph);
		setVisible(true);
		setMinimumSize(JGraph.MINIMUM_SIZE);
		save.addActionListener((e) -> {

		});

		print.addActionListener((e) -> {
			graph.createChartPrintJob();
			JOptionPane.showMessageDialog(null, "Das Diagram wird gedruckt...", "Information", JOptionPane.INFORMATION_MESSAGE);
		});
	}

}
