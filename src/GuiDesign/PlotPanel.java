/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiDesign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Country;
import model.CountryData;
import model.CountryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */
public class PlotPanel extends javax.swing.JFrame {

    List<CountryData> GDPData = new ArrayList();
    List<CountryData> OILData = new ArrayList();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    public PlotPanel(String plotcountry) throws ParseException {
        initComponents();
        String output = plotcountry.substring(0, 1).toUpperCase() + plotcountry.substring(1).toLowerCase();
        Plot_Panel.setText("Economic Data for " + String.valueOf(output));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EconometricaPU");

        EntityManager em = emf.createEntityManager();

        Query fetchdata = em.createNamedQuery("Country.findByName", Country.class);
        fetchdata.setParameter("name", plotcountry);

        List<Country> countries = fetchdata.getResultList();
        List<CountryDataset> ctrySet = new ArrayList();

//        System.out.println("ÂñÝèçêáí "+ countries.size()+" ÷þñåò!");
        if (!countries.isEmpty()) {
            countries.get(0).getIsoCode();
//            System.out.println("Country ISO Code is = "+countries.get(0).getIsoCode());

            for (int i = 0; i < countries.get(0).getCountryDatasetList().size(); i++) {
//            System.out.println("Country Dataset is = "+countries.get(0).getCountryDatasetList().get(i));
                ctrySet.add(countries.get(0).getCountryDatasetList().get(i));
//            System.out.println("Country Dataset is = "+ctrySet.get(i).getName());
            }
            for (int i = 0; i < ctrySet.size(); i++) {
                System.out.println("country set ID = " + ctrySet.get(i).getDatasetId());
                if (ctrySet.get(i).getDescription().contains("GDP")) {
//        System.out.println("Size of DataList table for GDP = "+ctrySet.get(i).getCountryDataList().size());
                    for (int j = 0; j < ctrySet.get(i).getCountryDataList().size(); j++) {
                        GDPData.add(ctrySet.get(i).getCountryDataList().get(j));
                    }
                }
                if (ctrySet.get(i).getDescription().contains("Oil")) {
//        System.out.println("Size of DataList table for OIL = "+ctrySet.get(i).getCountryDataList().size());                     
                    for (int j = 0; j < ctrySet.get(i).getCountryDataList().size(); j++) {
                        OILData.add(ctrySet.get(i).getCountryDataList().get(j));
                    }
                }
            }
        }
//*****************************************************************************
// Creation of core process 
//
//*****************************************************************************
        XYDataset dataset = createDataset1();
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                Plot_Panel.getText(),
                "Time",
                "GDP",
                dataset,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        NumberAxis axis2 = new NumberAxis("Oil Consumption");
        axis2.setAutoRangeIncludesZero(false);
        plot.setRangeAxis(1, axis2);
        plot.setDataset(1, createDataset2());
        plot.mapDatasetToRangeAxis(1, 1);
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
        if (renderer instanceof StandardXYItemRenderer) {
            StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setPlotImages(true); // setPlotShapes(true);
            rr.setPlotLines(true);  // setShapesFilled(true);
        }

        StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setSeriesPaint(0, Color.black);

        renderer2.setPlotImages(true);
        renderer2.setPlotLines(true);
        plot.setRenderer(1, renderer2);
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
//      axis.setLowerBound(0.0); 
//      axis.setUpperBound(24.0);
//      axis.setAutoRange(true);
//      axis.setAxisLineVisible(false);
//      axis.setRange(0.0,240000000000.0);
//      axis.setLowerMargin(0.0);
//      axis.setUpperMargin(240000000000.0);
        ChartPanel chartPanel = new ChartPanel(chart);
        //  chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

        ChartPanel FinalPanel = new ChartPanel(chart);
        jPanel1.removeAll();
        jPanel1.add(FinalPanel, BorderLayout.CENTER);
        jPanel1.validate();
//*****************************************************************************
//  End of core process
//*****************************************************************************
        em.close();
        emf.close();
    }

    private XYDataset createDataset1() throws ParseException {
        DecimalFormat df = new DecimalFormat("#.#");
        TimeSeries s1 = new TimeSeries("GDP");
        for (CountryData g : GDPData) {
            Number v = df.parse(g.getValue());
            int y = Integer.parseInt(g.getDataYear());
            s1.add(new Year(y),v);
        }
//                       Double.parseDouble(g.getValue())
            //                           df.format(g.getValue())

            //   Integer.parseInt(g.getValue()));
        
//           System.out.println("parse Integer = "+Integer.parseInt("180217594600.0"));
//           System.out.println("parse Float = "+Float.parseFloat("180217594600.0"));
//           System.out.println("parse Double = "+Double.parseDouble("180217594600.0"));
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        return dataset;
    }

    private XYDataset createDataset2() throws ParseException {
        DecimalFormat df = new DecimalFormat("#.##");
        
        TimeSeries s2 = new TimeSeries("Oil Consumption");

        for (CountryData g : OILData) {
            int y = Integer.parseInt(g.getDataYear());
            Number v = df.parse(g.getValue());
            s2.add(new Year(y),v);
//                       
        }
//           System.out.println("parse Float = "+Float.parseFloat("15.8073384323"));
//           System.out.println("parse Long = "+Long.parseLong("15.8073384323"));
//           System.out.println("parse Double = "+Double.parseDouble("15.8073384323"));
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s2);
        return dataset;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Plot_Panel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Economic Data");
        setLocation(new java.awt.Point(500, 250));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 250));

        jPanel1.setToolTipText("Plot");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        Plot_Panel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Plot_Panel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Plot_Panel.setText("country");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(Plot_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Plot_Panel)
                .addGap(76, 76, 76)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlotPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Plot_Panel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
