/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public class Exam extends javax.swing.JFrame {
  
    public String qid ="1";
    public String correct_answer;
    public int min =0;
    public int sec =0;
    public int marks=0;
    public int id ;
   
   
    Timer time; 
   
    public void answerCheck(){
        String studentAnswer="";
        if(option1.isSelected()){
          studentAnswer=option1.getText();
        }
        else if(option2.isSelected()){
          studentAnswer=option2.getText();
        }
       else if(option3.isSelected()){
          studentAnswer=option3.getText();
         
        }
       else {
          studentAnswer=option4.getText();
        }
        if(studentAnswer.equals(correct_answer)){
            marks = marks+1;
            String marks1 =(String.valueOf(marks)); 
            
        }
        int qid1 =Integer.parseInt(qid);
        qid1=qid1+1;
        qid = String.valueOf(qid1);
        
        option1.setSelected(false);
        option2.setSelected(false);
        option3.setSelected(false);
        option4.setSelected(false);
        
        if(qid.equals("10"))
        {
           jButton1 .setVisible(false);
        }
    }
    
    public void question(){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from question_bank where QID = '"+qid+"' ");
            while(rs.next()){
               
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
                jLabel22.setText(rs.getString(8));
               
                correct_answer=rs.getString(8);
            }
           
          
        } catch (SQLException | ClassNotFoundException e) {
            
        }
    }
    public void Submit(){ 
       String user = jLabel3.getText();
      answerCheck();
      
      try{
          Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
             stmt.executeUpdate("update result set TOTAL_MARKS='"+ marks+"'where USERNAME='"+user+"'");
            String marks1 = String.valueOf(marks);
            
            setVisible(false);
            new score(marks1).setVisible(true);
      }
      catch(HeadlessException | ClassNotFoundException | SQLException e)
      {
            
      }
    }
    /**
     * Creates new form Exam
     */ 
    public Exam() {
        initComponents();
    
      
      
    
         
         //date//
         
        SimpleDateFormat dFormate= new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel6.setText(dFormate.format(date));
        
        //dispalay first question and student detail
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from question_bank where QID ='"+qid+"'  ");
            while(rs.next()){
                
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
               jLabel22. setText( rs.getString(8));
               
            }
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // time program
        setLocationRelativeTo(this);
        time = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel11.setText(String.valueOf(sec));
                jLabel10.setText(String.valueOf(min));
               if(sec == 60){
                   sec=0;
                   min++;
                 
                   if(min == 10){
                     time.stop();
                     answerCheck();
                     Submit();
                   }
               }
               sec++;
            }
          });
        time.start();
       
   
    }

      
       
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText(" Options :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 83, 30));

        option1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });
        getContentPane().add(option1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        option2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });
        getContentPane().add(option2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        option3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });
        getContentPane().add(option3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, -1));

        option4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });
        getContentPane().add(option4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAVE AND NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 770, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CLEAR RESPONSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 770, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("FINAL SUBMIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 770, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 90)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("ONLINE EXAM");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TIME TAKEN :");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("00");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("00");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DATE :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL TIME :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("10 minutes");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Pictures\\New folder (2)\\images\\book")); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(204, 204, 204)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addGap(1254, 1254, 1254))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1500, 230));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton9.setText("1");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 91, -1, -1));

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton10.setText("2");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 91, 51, -1));

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton11.setText("3");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 91, 48, -1));

        jButton12.setBackground(new java.awt.Color(204, 204, 204));
        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton12.setText("4");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 91, 54, -1));

        jButton13.setBackground(new java.awt.Color(204, 204, 204));
        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton13.setText("5");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 140, -1, -1));

        jButton14.setBackground(new java.awt.Color(204, 204, 204));
        jButton14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton14.setText("6");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 140, 51, -1));

        jButton15.setBackground(new java.awt.Color(204, 204, 204));
        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton15.setText("7");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 140, 51, -1));

        jButton19.setBackground(new java.awt.Color(204, 204, 204));
        jButton19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton19.setText("10");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        jButton16.setBackground(new java.awt.Color(204, 204, 204));
        jButton16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton16.setText("8");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 140, 51, -1));

        jButton17.setBackground(new java.awt.Color(204, 204, 204));
        jButton17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton17.setText("9");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel15.setBackground(new java.awt.Color(0, 102, 204));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("\tENGLISH");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 1, -1, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 490, 334, 260));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 318, 1480, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("TOTAL QUESTION :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("QUESTION NUMBER :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("COURSE NAME :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 466, 1490, 10));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("QSTATEMENT :");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("ENGLISH");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("jLabel21");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setText("jLabel22");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 260, -1, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel25.setText("10");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setText("MARKS :");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 260, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        // TODO add your handling code here:
       if(option1.isSelected())  {
             option2.setSelected(false);
             option3.setSelected(false);
             option4.setSelected(false);
         }        

    
    }//GEN-LAST:event_option1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=8";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                jLabel21.setText(rs.getString(3));
                jLabel16.setText(rs.getString(4));
                option1.setText(rs.getString(5));
                option2.setText(rs.getString(6));
                option3.setText(rs.getString(7));
                option4.setText(rs.getString(8));
               correct_answer = rs.getString(9);
            jLabel22. setText( rs.getString(10));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            
        }
         setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:    
answerCheck();
question();      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed
        // TODO add your handling code here:
        if(option3.isSelected())  {
             option2.setSelected(false);
             option1.setSelected(false);
             option4.setSelected(false);
         }  
    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed
        // TODO add your handling code here:
        if(option4.isSelected())  {
             option2.setSelected(false);
             option3.setSelected(false);
             option1.setSelected(false);
         }  
    }//GEN-LAST:event_option4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO SUBMIT","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
         dispose();
         score sc = new score();
         sc.setVisible(true);
          
         
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        // TODO add your handling code here:
        if(option2.isSelected())  {
             option1.setSelected(false);
             option3.setSelected(false);
             option4.setSelected(false);
         }  
    }//GEN-LAST:event_option2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank  where QID = 1";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            
        }
         setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=2";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            
        }
         setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=3";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            
        }
         setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=4";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=5";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            
        }
         setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=6";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
               jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=7";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=9";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
         setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC", "root", "");
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
           
            String sql = "select * from question_bank where QID=10";
            
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                jLabel21.setText(rs.getString(1));
                jLabel16.setText(rs.getString(2));
                option1.setText(rs.getString(3));
                option2.setText(rs.getString(4));
                option3.setText(rs.getString(5));
                option4.setText(rs.getString(6));
               correct_answer = rs.getString(7);
            jLabel22. setText( rs.getString(8));
            }
            
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            
        }
         setVisible(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        jLabel21.setText("");
                jLabel16.setText("");
                option1.setText("");
                option2.setText("");
                option3.setText("");
                option4.setText("");
               correct_answer = ("");
            jLabel22. setText("");

    }//GEN-LAST:event_jButton4ActionPerformed
         
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    // End of variables declaration//GEN-END:variables
}
