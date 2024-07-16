public class TicTacToe extends javax.swing.JFrame {
    
    static int turn = 0;
    static String[][] table = new String[3][3];
    static boolean[][] taken = new boolean[3][3];
    static int cX, cY = 99;
    
    public TicTacToe() {
        initComponents();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = null;
                taken[i][j] = false;
            }
        }
        
        jLabel1.setText("Player (X) is up");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[0][0] = "X";
            taken[0][0]=true;
            jButton1.setText("X");
            jButton1.setEnabled(false);
            turn++;
            compTurn(0, 0);
        }
        else{
            table[0][0] = "O";
            taken[0][0]=true;
            jButton1.setText("O");
            jButton1.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[1][0] = "X";
            taken[1][0]=true;
            jButton2.setText("X");
            jButton2.setEnabled(false);
            turn++;
            compTurn(1, 0);
        }
        else{
            table[1][0] = "O";
            taken[1][0]=true;
            jButton2.setText("O");
            jButton2.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[2][0] = "X";
            taken[2][0]=true;
            jButton3.setText("X");
            jButton3.setEnabled(false);
            turn++;
            compTurn(2, 0);
        }
        else{
            table[2][0] = "O";
            taken[2][0]=true;
            jButton3.setText("O");
            jButton3.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[0][1] = "X";
            taken[0][1]=true;
            jButton4.setText("X");
            jButton4.setEnabled(false);
            turn++;
            compTurn(0, 1);
        }
        else{
            table[0][1] = "O";
            taken[0][1]=true;
            jButton4.setText("O");
            jButton4.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[1][1] = "X";
            taken[1][1]=true;
            jButton5.setText("X");
            jButton5.setEnabled(false);
            turn++;
            compTurn(1, 1);
        }
        else{
            table[1][1] = "O";
            taken[1][1]=true;
            jButton5.setText("O");
            jButton5.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[2][1] = "X";
            taken[2][1]=true;
            jButton6.setText("X");
            jButton6.setEnabled(false);
            turn++;
            compTurn(2, 1);
        }
        else{
            table[2][1] = "O";
            taken[2][1]=true;
            jButton6.setText("O");
            jButton6.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[0][2] = "X";
            taken[0][2]=true;
            jButton7.setText("X");
            jButton7.setEnabled(false);
            turn++;
            compTurn(0, 2);
        }
        else{
            table[0][2] = "O";
            taken[0][2]=true;
            jButton7.setText("O");
            jButton7.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[1][2] = "X";
            taken[1][2]=true;
            jButton8.setText("X");
            jButton8.setEnabled(false);
            turn++;
            compTurn(1, 2);
        }
        else{
            table[1][2] = "O";
            taken[1][2]=true;
            jButton8.setText("O");
            jButton8.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (turn % 2 == 0){
            table[2][2] = "X";
            taken[2][2]=true;
            jButton9.setText("X");
            jButton9.setEnabled(false);
            turn++;
            compTurn(2, 2);
        }
        else{
            table[2][2] = "O";
            taken[2][2]=true;
            jButton9.setText("O");
            jButton9.setEnabled(false);
            turn++;
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    public void compTurn(int lastMoveX, int lastMoveY){
        
        int x, y;
        
        if (turn==1){
            
            if (!(lastMoveX == 1 && lastMoveY == 1) ){
                put(1, 1);
            }
            else{
                put(0, 0);
            }
            
        }
        if (turn == 3 && table[1][1] == "O" && table[0][0] == "X" && table[2][2] == "X" )
            put(1, 0);
        else if (turn == 3 && table[1][1] == "O" && table[2][0] == "X" && table[0][2] == "X" )
            put (1, 0);
        else if (turn == 3 && table[1][1] == "O" && table[1][0] == "X" && table[0][1] == "X" )
            put (0, 0);
        else if (turn == 3 && table[1][1] == "O" && table[2][2] == "X" && table[0][1] == "X" )
            put (0, 2);
        else if (turn == 3 && table[1][1] == "O" && table[2][2] == "X" && table[1][0] == "X" )
            put (2, 0);
        else if (turn == 3 && table[1][1] == "X" && table[2][2] == "X" && table[0][0] == "O" )
            put (2, 0);
        else if (turn == 3 && table[1][1] == "O" && table[2][0] == "X" && table[0][1] == "X" )
            put (0, 0);
        else if (turn%2==1){
            check("O");
            if (cX == 99 && turn%2==1){
                check("X");
                if (cX == 99 && turn%2==1){
                    
                    int a = 0; 
                    int b = 0;
                    
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (taken[i][j] == false){
                                a = i;
                                b = j;
                            }
                        
                    }
                        
                }
                    
                    put(a,b);
                    
                }
            }
            
            if (turn==9)
                jLabel1.setText("DRAW");
            
            if (table[0][0] == "O" && table[1][0] == "O" && table[2][0] == "O")
                victory();
            else if (table[0][1] == "O" && table[1][1] == "O" && table[2][1] == "O")
                victory();
            else if (table[0][2] == "O" && table[1][2] == "O" && table[2][2] == "O")
                victory();
            else if (table[0][0] == "O" && table[0][1] == "O" && table[0][2] == "O")
                victory();
            else if (table[1][0] == "O" && table[1][1] == "O" && table[1][2] == "O")
                victory();
            else if (table[2][0] == "O" && table[2][1] == "O" && table[2][2] == "O")
                victory();
            else if (table[0][0] == "O" && table[1][1] == "O" && table[2][2] == "O")
                victory();
            else if (table[2][0] == "O" && table[1][1] == "O" && table[0][2] == "O")
                victory();
            
        }
        
    }
    
    public void victory(){
    
        jLabel1.setText("COMPUTER WINS");
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        
    }
    
    public void check(String sign){
        
        for (int j = 0; j < 3; j++) {
                
                for (int i = 0; i < 3; i++) {
                    if (taken[i][j] == false){
                        if (checkRow(i, j, sign)!=4){
                            put(checkRow(i, j, sign), j);
                            break;
                        }
                        else if (checkCol(i, j, sign)!=4){
                            put(i, checkCol(i, j, sign));
                            break;
                        }
                        else if (checkDiag1(i, j, sign)!=4){
                            put(checkDiag1(i, j, sign), checkDiag1(i, j, sign));
                            break;
                        }
                        else if (checkDiag2(i, j, sign)!=4){
                            put(checkDiag2(i, j, sign), checkDiag2(i-1, j+1, sign));
                            break;
                        }
                    }
                    
                }
        }
        
        put(99,0);
            
    }
    
    public int checkDiag2(int row, int col, String sign){
        
        if (row==0 && table[0][2]==sign && table[1][1]==sign){
            put(2, 0);
            return 1;
        }
        else if (row==1 && table[0][2]==sign && table[2][0]==sign){
            put(1, 1);
            return 1;
        }
        else if (row==2 && table[1][1]==sign && table[2][0]==sign){
            put(0, 2);
            return 1;
        }
        else 
            return 4;
        
    }
    
    public int checkDiag1(int row, int col, String sign){
        
        if (row==0 && table[1][1]==sign && table[2][2]==sign)
            return 0;
        else if (row==1 && table[0][0]==sign && table[2][2]==sign)
            return 1;
        else if (row==2 && table[0][0]==sign && table[1][1]==sign)
            return 2;
        else return 4;
        
    }
    
    public int checkRow(int row, int col, String sign){
        
        if (row==0 && table[1][col]==sign && table[2][col]==sign)
            return 0;
        else if (row==1 && table[0][col]==sign && table[2][col]==sign)
            return 1;
        else if (row==2 && table[0][col]==sign && table[1][col]==sign)
            return 2;
        else return 4;
        
    }
    
    public int checkCol(int row, int col, String sign){
        
        if (col==0 && table[row][1]==sign && table[row][2]==sign)
            return 0;
        else if (col==1 && table[row][0]==sign && table[row][2]==sign)
            return 1;
        else if (col==2 && table[row][0]==sign && table[row][1]==sign)
            return 2;
        else return 4;
        
    }
    
    public void put(int x, int y){
        
        cX=x;
        cY=y;
        
        if (x == 0 && y == 0)
            jButton1.doClick();
        else if (x == 1 && y == 0)
            jButton2.doClick();
        else if (x == 2 && y == 0)
            jButton3.doClick();
        else if (x == 0 && y == 1)
            jButton4.doClick();
        else if (x == 1 && y == 1)
            jButton5.doClick();
        else if (x == 2 && y == 1)
            jButton6.doClick();
        else if (x == 0 && y == 2)
            jButton7.doClick();
        else if (x == 1 && y == 2)
            jButton8.doClick();
        else if (x == 2 && y == 2)
            jButton9.doClick();
        else{
        }
        
        
    }
    
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
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
