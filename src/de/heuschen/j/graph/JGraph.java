package de.heuschen.j.graph;

import java.math.BigDecimal;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.udojava.evalex.Expression;

public final class JGraph {

	private static JGraphFrame frame = null;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		System.out.println("(C) JGraph by Julian Heuschen.");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame = new JGraphFrame();
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public static double calc(String equation, double x) {
		return new Expression(equation).with("x", new BigDecimal(x)).eval().doubleValue();
	}

}