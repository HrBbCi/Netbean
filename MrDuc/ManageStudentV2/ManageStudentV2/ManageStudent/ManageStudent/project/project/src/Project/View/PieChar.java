package Project.View;

import Project.Controller.ScoreDAO;
import Project.Model.Score;
import java.awt.Font;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChar {

    public String idStudent = "";

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }
    
    Score s;
    public PieDataset createDataset() {
        s = ScoreDAO.getInstance().getAmountScorePass(idStudent);
        float a = ((float)s.getPass()/(float)s.getTotal()) * 100;
        System.out.println(a);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Đạt", a);
        dataset.setValue("Không đạt", 100 - a);
        return dataset;
    }

    private JFreeChart createPieChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }

    public void display1() {
        s = ScoreDAO.getInstance().getAmountScorePass(idStudent);
        JFreeChart pieChart = createPieChart(createDataset());
        PiePlot P = (PiePlot) pieChart.getPlot();
        ChartFrame f = new ChartFrame("", pieChart);
        JLabel txtTenBieuDo = new JLabel("BIỂU ĐỒ GHI NHẬN KẾT QUẢ HỌC TẬP");
        txtTenBieuDo.setBounds(56, 345, 337, 28);
        f.add(txtTenBieuDo);
        txtTenBieuDo.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel txtTong = new JLabel("Tổng số môn học: " + s.getTotal() + " môn");
        txtTong.setBounds(123, 42, 230, 28);
        f.add(txtTong);
        txtTong.setFont(new Font("Tahoma", Font.BOLD, 15));

        JLabel txtCountKetQua = new JLabel("Đạt " + s.getPass() + " môn  - Không đạt "
                + (s.getTotal() - s.getPass()) + " môn");
        txtCountKetQua.setBounds(102, 68, 281, 20);
        f.add(txtCountKetQua);
        txtCountKetQua.setFont(new Font("Tahoma", Font.BOLD, 15));

        f.setTitle("Biểu đồ");
        f.setSize(400, 550);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);

    }
}
