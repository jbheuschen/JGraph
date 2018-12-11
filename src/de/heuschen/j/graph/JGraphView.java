package de.heuschen.j.graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class JGraphView {

	private ChartPanel g;
	private boolean zero = false, negative = true;

	public JGraphView(String equation, double range) {
		this(equation, range, true, true);
	}

	public JGraphView(String equation, double range, boolean zero, boolean negative) {
		System.out.println("Showing Graph for " + equation + " in Range " + range);
		this.zero = zero;
		this.negative = negative;
		XYDataset x = calc(equation, range);
		JFreeChart c = ChartFactory.createXYLineChart(equation, "x", "y", x, PlotOrientation.VERTICAL, true, true,
				false);
		c.addSubtitle(new TextTitle("Graph zur Gleichung"));

		XYPlot p = c.getXYPlot();
		p.setRangeZeroBaselineVisible(true);
		p.setDomainZeroBaselineVisible(true);

		g = new ChartPanel(c);
		g.setPopupMenu(null);
		g.setRangeZoomable(false);
		g.setDomainZoomable(false);
		System.out.println(zero + ";" + negative);

	}

	public ChartPanel getChart() {
		return g;
	}

	public XYDataset calc(String equation, double range) {
		XYSeries x = new XYSeries(equation), xneg = new XYSeries(equation + " (-)");
		try {
			for (int z = 0; z <= range * 2; z++) {
				double z2 = 0.5 * z;
				if (z == 0) {
					if (zero)
						x.add(z, JGraph.calc(equation, z2));
				} else {
					x.add(z, JGraph.calc(equation, z2));
					if (negative)
						if (zero)
							x.add(-z, JGraph.calc(equation, -z2));
						else
							xneg.add(-z, JGraph.calc(equation, -z2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		XYSeriesCollection ges = new XYSeriesCollection();
		ges.addSeries(x);
		if (!zero && negative)
			ges.addSeries(xneg);
		return ges;
	}

}
