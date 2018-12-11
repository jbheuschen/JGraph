package de.heuschen.j.graph;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ValueTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6084503566398596425L;

	public ValueTable(String equation, double range) {
		setLayout(null);
		System.out.println("t");
		Vector<String> header = new Vector<>();
		header.add("x");
		Vector<Vector<Object>> data = new Vector<>();
		Vector<Object> y = new Vector<Object>();
		y.add("y");

		for (int z = 0; z <= range * 2; z++) {

			double z2 = 0.5 * z;
			try {
				if (z != 0) {
					header.add(String.valueOf(-z2));
					Vector<Object> o = new Vector<>();
					o.add(JGraph.calc(equation, -z2));
					data.add(o);
				}
			} catch (Exception e) {
				header.add(String.valueOf(z2));
				Vector<Object> o = new Vector<>();
				o.add("N/A");
				data.add(o);
			}
		}

		for (int z = 0; z <= range * 2; z++) {

			double z2 = 0.5 * z;
			try {
				if (z == 0) {
					header.add(String.valueOf(z2));
					Vector<Object> o = new Vector<>();
					o.add(JGraph.calc(equation, z2));
					data.add(o);
				} else {
					header.add(String.valueOf(z2));
					Vector<Object> o = new Vector<>();
					o.add(JGraph.calc(equation, z2));
					data.add(o);
				}
			} catch (Exception e) {
				header.add(String.valueOf(z2));
				Vector<Object> o = new Vector<>();
				o.add("N/A");
				data.add(o);
			}
		}
		System.out.println(data);
		System.out.println(header);
		System.out.println(this);
		JTable vals = new JTable(data, header);
		vals.setModel(new DefaultTableModel(data, header));
		System.out.println(vals);
//		try {
//			vals.print();
//		} catch (PrinterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		vals.setBackground(Color.BLUE);
		add(vals);
		this.setBackground(Color.GREEN);
	}
}
