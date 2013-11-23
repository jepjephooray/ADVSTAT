package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class GraphPanel extends JPanel{
	public enum Type {
		Population,
		Sample
	}
	public static GraphPanel PopulationGraph;
	public static GraphPanel SamplingGraph;

	private CategoryPlot plot;
	
	public GraphPanel(String title, Type type) {
		/**
		 * Panel initialization
		 */
		setPreferredSize(new Dimension(500, 300));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEtchedBorder());


		/**
		 * Chart initialization
		 */
		final double[][] data = new double[][] {
				{0.0}
		};

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		final JFreeChart chart = generateBarChart(dataset, title, type);
		plot = chart.getCategoryPlot();
		chart.setBackgroundPaint(getBackground());
		final ChartPanel chartPanel = new ChartPanel(chart);
		add(chartPanel);
	}


	public static JFreeChart generateBarChart(DefaultCategoryDataset dataset, String title, Type type) {
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		String xAxis = (type == Type.Population) ? "" : "Sample mean";
		String yAxis = (type == Type.Population) ? "" : "Probability";
		
		final JFreeChart chart = ChartFactory.createBarChart(
				title, xAxis, yAxis,
				dataSet, PlotOrientation.VERTICAL, false, true, false);
		return chart;
	}

	public void updateDomain(final CategoryDataset dataset){
		plot.setDataset(dataset);
	}
}
