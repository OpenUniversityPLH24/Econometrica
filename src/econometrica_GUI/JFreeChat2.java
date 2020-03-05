/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica_GUI;

import java.awt.Color;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author vborotis
 */
public class JFreeChat2 extends ApplicationFrame{

public JFreeChat2(final String title) { 
    
    super(title);

final String chartTitle = "Economic Data";    
final XYDataset dataset = createDataset1();
final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                   chartTitle, 
                   "Time", 
                   "GDP",
                   dataset, 
                   true, 
                   true, 
                   false
                  );

final XYPlot plot = chart.getXYPlot();
final NumberAxis axis2 = new NumberAxis("Secondary");
axis2.setAutoRangeIncludesZero(false);
plot.setRangeAxis(1, axis2);
plot.setDataset(1, createDataset2());
plot.mapDatasetToRangeAxis(1, 1);
final XYItemRenderer renderer = plot.getRenderer();
renderer.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setPlotImages(true); // setPlotShapes(true);
            rr.setPlotLines(true);  // setShapesFilled(true);
}

final StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setSeriesPaint(0, Color.black);
        
        renderer2.setPlotImages(true);
        renderer2.setPlotLines(true);
        plot.setRenderer(1, renderer2);
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
}
    
private XYDataset createDataset1() {
    
TimeSeries s1 = new TimeSeries("Random Data 1");
//        "Random Data 1", Month.class
        s1.add(new Month(2, 2001), 181.8);
        s1.add(new Month(3, 2001), 167.3);
        s1.add(new Month(4, 2001), 153.8);
        s1.add(new Month(5, 2001), 167.6);
        s1.add(new Month(6, 2001), 158.8);
        s1.add(new Month(7, 2001), 148.3);
        s1.add(new Month(8, 2001), 153.9);
        s1.add(new Month(9, 2001), 142.7);
        s1.add(new Month(10, 2001), 123.2);
        s1.add(new Month(11, 2001), 131.8);
        s1.add(new Month(12, 2001), 139.6);
        s1.add(new Month(1, 2002), 142.9);
        s1.add(new Month(2, 2002), 138.7);
        s1.add(new Month(3, 2002), 137.3);
        s1.add(new Month(4, 2002), 143.9);
        s1.add(new Month(5, 2002), 139.8);
        s1.add(new Month(6, 2002), 137.0);
        s1.add(new Month(7, 2002), 132.8);
        
TimeSeriesCollection dataset = new TimeSeriesCollection();
dataset.addSeries(s1);
        
  return dataset;    
}    

private XYDataset createDataset2() {

TimeSeries s2 = new TimeSeries("Random Data 2");
// , Month.class
        s2.add(new Month(2, 2001), 429.6);
        s2.add(new Month(3, 2001), 323.2);
        s2.add(new Month(4, 2001), 417.2);
        s2.add(new Month(5, 2001), 624.1);
        s2.add(new Month(6, 2001), 422.6);
        s2.add(new Month(7, 2001), 619.2);
        s2.add(new Month(8, 2001), 416.5);
        s2.add(new Month(9, 2001), 512.7);
        s2.add(new Month(10, 2001), 501.5);
        s2.add(new Month(11, 2001), 306.1);
        s2.add(new Month(12, 2001), 410.3);
        s2.add(new Month(1, 2002), 511.7);
        s2.add(new Month(2, 2002), 611.0);
        s2.add(new Month(3, 2002), 709.6);
        s2.add(new Month(4, 2002), 613.2);
        s2.add(new Month(5, 2002), 711.6);
        s2.add(new Month(6, 2002), 708.8);
        s2.add(new Month(7, 2002), 501.6);

TimeSeriesCollection dataset = new TimeSeriesCollection();
dataset.addSeries(s2);

  return dataset;
}

public void JFreeChar2(String title) {

 }

public void JFreeChat2() {
    final JFreeChat2 demo = new JFreeChat2("Annotation2AxisChart");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
  }
}

