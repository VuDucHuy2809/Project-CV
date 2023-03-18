/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChucNangKhac;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class ThongKe {

    public static void barChart(ArrayList<String[]> data, String title, String xTitle, String yTitle, JPanel root) {
        //ArrayList<Sach> data = sachbus.getAllData();
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        for (int i = 0; i < data.size(); i++) {
            barChartData.addValue(Double.valueOf(data.get(i)[0]), data.get(i)[1], data.get(i)[2]);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                xTitle,
                yTitle,
                barChartData,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel barPanel = new ChartPanel(barChart);
        barPanel.setVisible(true);
        root.removeAll();
        root.add(barPanel);
    }

    public static void lineChart(ArrayList<String[]> data, String title, String xTitle, String yTitle, JPanel root) {
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        for (int i = 0; i < data.size(); i++) {
            barChartData.addValue(Double.valueOf(data.get(i)[0]), data.get(i)[1], data.get(i)[2]);
        }

        JFreeChart barChart = ChartFactory.createLineChart(
                title,
                xTitle,
                yTitle,
                barChartData,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel barPanel = new ChartPanel(barChart);
        barPanel.setVisible(true);
        root.removeAll();
        root.add(barPanel);
    }
    
    public static void pieChart(ArrayList<String []> data,String title,JPanel root){
        DefaultPieDataset defaultsPie = new DefaultPieDataset();
        for(String[] str:data){
            defaultsPie.setValue(str[0], new Integer(str[1]));
        }
                
        JFreeChart chart = ChartFactory.createPieChart(title, defaultsPie, true,true,true);
        PiePlot p = (PiePlot)chart.getPlot();
        JPanel barPanel = new ChartPanel(chart);
        barPanel.setVisible(true);
        
        root.removeAll();
        root.add(barPanel);
    }
}
