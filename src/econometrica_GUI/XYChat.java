/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica_GUI;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author vborotis
 */
public class XYChat {
    
    public static void XYChat() throws IOException {
        
        //xy chart
        XYSeries xySeries = new XYSeries("XY Chat");
        xySeries.add(1, 1);
        xySeries.add(1, 2);
        xySeries.add(2, 1);
        xySeries.add(3, 9);
        xySeries.add(4, 10);
        
        // add xySeries to Dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(xySeries);
        
        //generating the graphic 
        JFreeChart chart = ChartFactory.createAreaChart(
                "New chat for Customers",              // title             = title
                "X-Axis", // categoryAxisLabel = category Axis Label - X
                "Y-Axis", (CategoryDataset) dataset,           // dataset           = Dataset
                PlotOrientation.HORIZONTAL,  
                true,              // true              = Plot Orientation
                true,              // true              = Show Legend 
                true);             // true              = Configure chart to generate URL
        ChartUtilities.saveChartAsJPEG(new File("C:/TestChart.jpg"), chart, 100, 100);
    } 
    
}
