package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;


public class GraphPanel extends JPanel{
	public static GraphPanel PopulationGraph;
	public static GraphPanel SamplingGraph;
	
	private CategoryPlot plot;
	private GraphUpdateListener graphUpdateListener;
	
	public GraphPanel(String title) {
		/**
		 * Panel initialization
		 */
		setPreferredSize(new Dimension(400, 300));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		

		/**
		 * Chart initialization
		 */
		final double[][] data = new double[][] {
        		{0.0}
        };

        final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
            "Series ", "", data
        );
        
		final JFreeChart chart = createChart(dataset, title);
		final ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);
	}


	
	private JFreeChart createChart(final CategoryDataset dataset, String title){
		   final JFreeChart chart = ChartFactory.createAreaChart(
		            title,    // chart title
		            "N",               // domain axis label
		            "Frequency",                  // range axis label
		            dataset,                  // data
		            PlotOrientation.VERTICAL, // orientation
		            false,                     // include legend
		            false,                     // tooltips
		            false                     // urls
		        );
		 
		        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

		        // set the background color for the chart...
		   		// final StandardLegend legend = (StandardLegend) chart.getLegend();
		   		// legend.setAnchor(StandardLegend.SOUTH);

		        chart.setBackgroundPaint(getBackground());
		        final TextTitle subtitle = new TextTitle("");
		        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
		        subtitle.setPosition(RectangleEdge.TOP);
//		        subtitle.setSpacer(new Spacer(Spacer.RELATIVE, 0.05, 0.05, 0.05, 0.05));
		        subtitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
		        chart.addSubtitle(subtitle);
		        
		        plot = chart.getCategoryPlot();
		        plot.setForegroundAlpha(0.5f);
		        
		  //      plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
		        plot.setBackgroundPaint(Color.lightGray);
		        plot.setDomainGridlinesVisible(true);
		        plot.setDomainGridlinePaint(Color.white);
		        plot.setRangeGridlinesVisible(true);
		        plot.setRangeGridlinePaint(Color.white);
		        
		        
		        final CategoryAxis domainAxis = plot.getDomainAxis();
		        // domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		        domainAxis.setLowerMargin(0.0);
		        domainAxis.setUpperMargin(0.0);
		        domainAxis.addCategoryLabelToolTip("Type 1", "The first type.");
		        domainAxis.addCategoryLabelToolTip("Type 2", "The second type.");
		        domainAxis.addCategoryLabelToolTip("Type 3", "The third type.");
		        
		       
		        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		        rangeAxis.setTickUnit(new NumberTickUnit(0.1F));
		        rangeAxis.setLabelAngle(0 * Math.PI / 2.0);
		        // OPTIONAL CUSTOMISATION COMPLETED.
		        
		        return chart;
	}
	
	public void addGraphListener(GraphUpdateListener listener) {
		this.graphUpdateListener = listener;
	}
	
	public void updateDomain(final CategoryDataset dataset){
		plot.setDataset(dataset);
	}
}
