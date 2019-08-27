
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class Minesweeper extends JFrame implements ActionListener, ContainerListener {
    
    int fw, fh, blockr, blockc, var1, var2, num_of_mine, detectedmine = 0, savedlevel = 1,
            savedblockr, savedblockc, savednum_of_mine = 10;
    int[] r = {-1, -1, -1, 0, 1, 1, 1, 0};
    int[] c = {-1, 0, 1, 1, 1, 0, -1, -1};
    JButton[][] blocks;
    int[][] countmine;
    int[][] colour;
    ImageIcon[] ic = new ImageIcon[14];
    JPanel panelb;
    JPanel panelmt = new JPanel();
    JTextField tf_mine, tf_time;
    JButton reset = new JButton("");
    Random ranr = new Random();
    Random ranc = new Random();
    boolean check = true, starttime = false;
    Point framelocation;
    MouseHendeler mh;
    Point p;
    int v1;
    TimeThread t;
    
    public Minesweeper() {
        super("Dò mìn");
        setLocation(400, 300);
        
        setic();
        setpanel(1, 0, 0, 0);
        t = new TimeThread();
        t.Start();
        reset.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent ae) {
                t.stop();
                try {
                    setpanel(savedlevel, savedblockr, savedblockc, savednum_of_mine);
                } catch (Exception ex) {
                    setpanel(savedlevel, savedblockr, savedblockc, savednum_of_mine);
                }
                
                t.Start();
                reset();
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        show();
    }
    
    public long start, end;
    int count;
    
    public class TimeThread extends JFrame implements Runnable {
        
        Thread updater;
        boolean isRunning = false;
        int count = 0;
        
        Runnable displayUpdater = new Runnable() {
            public void run() {
                displayElapsedTime(count);
                count++;
            }
        };
        
        public void stop() {
            long elapsed = count;
            isRunning = false;
            try {
                updater.join();
            } catch (InterruptedException ie) {
            }
            displayElapsedTime(elapsed);
            count = 0;
        }
        
        private void displayElapsedTime(long elapsedTime) {
            tf_time.setText(elapsedTime + "");
        }

         @Override
        public void run() {
            try {
                while (isRunning) {
                    SwingUtilities.invokeAndWait(displayUpdater);
                    Thread.sleep(1000);
                }
            } catch (java.lang.reflect.InvocationTargetException ite) {
                ite.printStackTrace(System.err);
            } catch (InterruptedException ie) {
            }
        }

        public void Start() {
            start = System.currentTimeMillis();
            isRunning = true;
            updater = new Thread(this);
            updater.start();
        }
    }
    
    public void reset() {
        check = true;
        for (int i = 0; i < blockr; i++) {
            for (int j = 0; j < blockc; j++) {
                colour[i][j] = 'w';
            }
        }
    }
    
    public void setpanel(int level, int setr, int setc, int setm) {
        fw = 400;
        fh = 450;
        blockr = 10;
        blockc = 10;
        num_of_mine = 10;
        
        savednum_of_mine = num_of_mine;
        setSize(fw, fh);
        detectedmine = num_of_mine;
        p = this.getLocation();
        
        blocks = new JButton[10][10];
        countmine = new int[10][10];
        colour = new int[10][10];
        mh = new MouseHendeler();
        
        getContentPane().removeAll();
        tf_mine = new JTextField("" + num_of_mine, 3);
        tf_mine.setEditable(false);
        tf_mine.setFont(new Font("DigtalFont.TTF", Font.BOLD, 25));
        tf_mine.setBackground(Color.BLACK);
        tf_mine.setForeground(Color.RED);
        tf_mine.setBorder(BorderFactory.createLoweredBevelBorder());
        tf_time = new JTextField("000", 3);
        tf_time.setEditable(false);
        tf_time.setFont(new Font("DigtalFont.TTF", Font.BOLD, 25));
        tf_time.setBackground(Color.BLACK);
        tf_time.setForeground(Color.RED);
        tf_time.setBorder(BorderFactory.createLoweredBevelBorder());
        reset.setIcon(ic[11]);
        reset.setBorder(BorderFactory.createLoweredBevelBorder());

        //panelmt.removeAll();
        panelmt.setLayout(new BorderLayout());
        panelmt.add(tf_mine, BorderLayout.WEST);
        panelmt.add(reset, BorderLayout.CENTER);
        panelmt.add(tf_time, BorderLayout.EAST);
        panelmt.setBorder(BorderFactory.createLoweredBevelBorder());
        panelb = new JPanel(new GridLayout(10, 10));
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                blocks[i][j] = new JButton("");
                blocks[i][j].setBackground(Color.orange);
                blocks[i][j].addActionListener(this); //
                blocks[i][j].addMouseListener(mh);
                panelb.add(blocks[i][j]);
            }
        }
        reset();
        
        panelb.revalidate();
        panelb.repaint();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().addContainerListener(this);
        getContentPane().repaint();
        getContentPane().add(panelb, BorderLayout.CENTER);
        getContentPane().add(panelmt, BorderLayout.NORTH);
        setVisible(true);
    }
    
    @Override
    public void componentAdded(ContainerEvent ce) {
    }
    
    @Override
    public void componentRemoved(ContainerEvent ce) {
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
    class MouseHendeler extends MouseAdapter {
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if (check == true) {
                for (int i = 0; i < blockr; i++) {
                    for (int j = 0; j < blockc; j++) {
                        if (me.getSource() == blocks[i][j]) {
                            var1 = i;
                            var2 = j;
                            i = blockr;
                            break;
                        }
                    }
                }
                
                setmine();
                calculation();
                check = false;
            }
            
            showvalue(me);
            winner();
            
        }
    }
    
    public void winner() {
        int q = 0;
        for (int k = 0; k < blockr; k++) {
            for (int l = 0; l < blockc; l++) {
                if (colour[k][l] == 'w') {
                    q = 1;
                }
            }
        }
        
        if (q == 0) {
            for (int k = 0; k < blockr; k++) {
                for (int l = 0; l < blockc; l++) {
                    blocks[k][l].removeMouseListener(mh);
                }
            }
            t.stop();
            JOptionPane.showMessageDialog(this, " a lover");
        }
    }
    
    public void moHet() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (countmine[i][j] == -1) {
                    for (int k = 0; k < 10; k++) {
                        for (int l = 0; l < 10; l++) {
                            if (countmine[k][l] == -1) {
                                blocks[k][l].setIcon(ic[9]);
                                blocks[k][l].removeMouseListener(mh);
                            }
                            blocks[k][l].removeMouseListener(mh);
                        }
                    }
                    reset.setIcon(ic[12]);
                    
                } else if (countmine[i][j] == 0) {
                    dfs(i, j);
                } else {
                    blocks[i][j].setIcon(ic[countmine[i][j]]);
                    
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(countmine[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public void showvalue(MouseEvent e) {
        for (int i = 0; i < blockr; i++) {
            for (int j = 0; j < blockc; j++) {
                
                if (e.getSource() == blocks[i][j]) {
                    if (e.isMetaDown() == false) {
                        if (blocks[i][j].getIcon() == ic[10]) {
                            if (detectedmine < num_of_mine) {
                                detectedmine++;
                            }
                            tf_mine.setText("" + detectedmine);
                        }
                        
                        if (countmine[i][j] == -1) {
                            for (int k = 0; k < blockr; k++) {
                                for (int l = 0; l < blockc; l++) {
                                    if (countmine[k][l] == -1) {

                                        //blocks[k][l].setText("X");
                                        blocks[k][l].setIcon(ic[9]);
                                        //blocks[k][l].setBackground(Color.BLUE);
                                        //blocks[k][l].setFont(new Font("",Font.CENTER_BASELINE,8));
                                        blocks[k][l].removeMouseListener(mh);
                                    }
                                    blocks[k][l].removeMouseListener(mh);
                                }
                            }
                            
                            reset.setIcon(ic[12]);
                            t.stop();
                            JOptionPane.showMessageDialog(null, "sorry u R  loser");
                        } else if (countmine[i][j] == 0) {
                            dfs(i, j);
                        } else {
                            blocks[i][j].setIcon(ic[countmine[i][j]]);
                            colour[i][j] = 'b';
                            break;
                        }
                    } else {
                        if (detectedmine != 0) {
                            if (blocks[i][j].getIcon() == null) {
                                detectedmine--;
                                blocks[i][j].setIcon(ic[10]);
                            }
                            tf_mine.setText("" + detectedmine);
                        }
                        
                    }
                }
                
            }
        }
        
    }
    
    public void calculation() {
        int row, column;
        
        for (int i = 0; i < blockr; i++) {
            for (int j = 0; j < blockc; j++) {
                int value = 0;
                int R, C;
                row = i;
                column = j;
                if (countmine[row][column] != -1) {
                    for (int k = 0; k < 8; k++) {
                        R = row + r[k];
                        C = column + c[k];
                        
                        if (R >= 0 && C >= 0 && R < blockr && C < blockc) {
                            if (countmine[R][C] == -1) {
                                value++;
                            }
                            
                        }
                        
                    }
                    countmine[row][column] = value;
                    
                }
            }
        }
    }
    
    public void dfs(int row, int col) {
        int R, C;
        colour[row][col] = 'b';
        blocks[row][col].setBackground(Color.WHITE);
        blocks[row][col].setIcon(ic[countmine[row][col]]);
        for (int i = 0; i < 8; i++) {
            R = row + r[i];
            C = col + c[i];
            if (R >= 0 && R < blockr && C >= 0 && C < blockc && colour[R][C] == 'w') {
                if (countmine[R][C] == 0) {
                    dfs(R, C);
                } else {
                    blocks[R][C].setIcon(ic[countmine[R][C]]);
                    colour[R][C] = 'b';
                    
                }
            }
            
        }
    }
    public int arr[] = null;
    public int arr1[] = null;
    public int[] setMines(int row[]) {
        Random rd = new Random();
        row = new int[10];
        for (int i = 0; i < row.length; i++) {
            row[i] = rd.nextInt(10);
        }
        return row;
    }

    public int check(int a[], int b[]) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (a[i] == a[j] && i != j) {
                    int vt1 = i;
                    int vt2 = j;
                    if (b[vt1] == b[vt2]) {
                        return 1;
                    }
                }
            }
        }
        return 2;
    }

    public void rn() {
        int a[] = null;
        int b[] = null;

        a = setMines(a);
        b = setMines(b);
        while (check(a, b) == 1) {
            b = setMines(b);
        }
       
        arr = a;
        arr1 = b ;
    }
    
    public void setmine() {
        rn();
       
        Boolean[][] flag = new Boolean[blockr][blockc];
        
        for (int i = 0; i < blockr; i++) {
            for (int j = 0; j < blockc; j++) {
                flag[i][j] = true;
                countmine[i][j] = 0;
            }
        }
        
        flag[var1][var2] = false;
        colour[var1][var2] = 'b';
      
        for (int i = 0; i < num_of_mine; i++) {
            System.out.println(arr[i]+";"+ arr1[i]);
            if (flag[arr[i]][arr1[i]] == true) {
                countmine[arr[i]][arr1[i]] = -1;
                colour[arr[i]][arr1[i]] = 'b';
                flag[arr[i]][arr1[i]] = false;
            } else {
                i--;
            }
        }
    }
    
    public void setic() {
        String name = "";
        for (int i = 1; i <= 8; i++) {
            name = "/img/" + i + ".png";
            ic[i] = new ImageIcon(getClass().getResource(name));
        }
        ic[9] = new ImageIcon(getClass().getResource("/img/bom.png"));
        ic[10] = new ImageIcon(getClass().getResource("/img/co.png"));
        ic[11] = new ImageIcon(getClass().getResource("/img/he.png"));
        ic[12] = new ImageIcon(getClass().getResource("/img/hi.png"));
    }
    
}
