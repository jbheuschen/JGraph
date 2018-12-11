package de.heuschen.j.graph;

import java.awt.Dimension;
import java.math.BigDecimal;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.udojava.evalex.Expression;

/**
 * 
 * @author J. Heuschen
 *
 */
public final class JGraph {

	private static JGraphFrame frame = null;
	
	public static final Dimension MINIMUM_SIZE = new Dimension(200, 200), GRAPH_SIZE = new Dimension(500, 500);

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