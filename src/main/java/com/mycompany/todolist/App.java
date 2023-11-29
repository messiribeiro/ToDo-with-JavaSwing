



package com.mycompany.todolist;




/**
 *
 * @author micael
 */

import javax.swing.DefaultListModel;
import javax.swing.BoxLayout;

import java.awt.event.MouseMotionAdapter;
import javax.swing.JList;
import java.awt.event.MouseEvent;

//importações necessárias para a estilização da srollbar

import javax.swing.plaf.basic.BasicScrollBarUI;



import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Rectangle;
import java.awt.Color;



import javax.swing.BorderFactory;

public class App extends javax.swing.JFrame {

    private DefaultListModel<String> listModel;
    
    
    public App() {
        initComponents();
        tasksContainer.setLayout(new BoxLayout(tasksContainer, BoxLayout.Y_AXIS));
        listModel = new DefaultListModel<>();
        tasksContainer.setModel(listModel);
        jScrollPane2.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        
        addButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        addButton.setContentAreaFilled(false);
        
        completedButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        completedButton.setBackground(Color.white);
        
        
        tasksContainer.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JList<String> list = (JList<String>) e.getSource();
                int index = list.locationToIndex(e.getPoint());
                if (index >= 0) {
                    list.setToolTipText(listModel.getElementAt(index));
                }
            }
        });
    }   

     private static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createArrowButton(orientation);
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createArrowButton(orientation);
        }

        private JButton createArrowButton(int orientation) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            return button;
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            g.setColor(Color.lightGray);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            g.setColor(Color.darkGray);
            g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        blankContainer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tasksContainer = new javax.swing.JList<>();
        completedButton = new javax.swing.JButton();
        inputContainer = new javax.swing.JPanel();
        taskInput = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 51, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("ToDo List");

        blankContainer.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(null);

        tasksContainer.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tasksContainer.setForeground(new java.awt.Color(102, 102, 102));
        tasksContainer.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "você não tem nenhuma tarefa .-." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        tasksContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tasksContainer.setFixedCellWidth(0);
        tasksContainer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tasksContainerValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(tasksContainer);

        completedButton.setBackground(new java.awt.Color(204, 204, 204));
        completedButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        completedButton.setForeground(new java.awt.Color(102, 102, 102));
        completedButton.setText("concluída");
        completedButton.setBorder(null);
        completedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout blankContainerLayout = new javax.swing.GroupLayout(blankContainer);
        blankContainer.setLayout(blankContainerLayout);
        blankContainerLayout.setHorizontalGroup(
            blankContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blankContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(blankContainerLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(completedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        blankContainerLayout.setVerticalGroup(
            blankContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blankContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(completedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        inputContainer.setBackground(new java.awt.Color(255, 255, 255));

        taskInput.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        taskInput.setForeground(new java.awt.Color(102, 102, 102));
        taskInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        taskInput.setText("Nova Tarefa");
        taskInput.setBorder(null);
        taskInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskInputActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        addButton.setText("+");
        addButton.setBorder(null);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setMaximumSize(new java.awt.Dimension(47, 34));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputContainerLayout = new javax.swing.GroupLayout(inputContainer);
        inputContainer.setLayout(inputContainerLayout);
        inputContainerLayout.setHorizontalGroup(
            inputContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(taskInput, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
        );
        inputContainerLayout.setVerticalGroup(
            inputContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputContainerLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(taskInput))
            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blankContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(inputContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blankContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void taskInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskInputActionPerformed

    
    Task task = new Task();
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        String taskText;
        taskText = taskInput.getText();
        
        if (!taskText.isEmpty()) {
            
            
            task.addTask(taskText, tasksContainer);
            

            // Limpar o campo de entrada
            taskInput.setText("Nova Tarefa");
        }
        
                
    }//GEN-LAST:event_addButtonActionPerformed

    private void tasksContainerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tasksContainerValueChanged
        if (!evt.getValueIsAdjusting()) {
        }
    }//GEN-LAST:event_tasksContainerValueChanged

    private void completedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedButtonActionPerformed
       task.removeTask(tasksContainer);
    }//GEN-LAST:event_completedButtonActionPerformed

    
    
    public static void main(String args[]) {
        
        try {
            
            
           
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel blankContainer;
    private javax.swing.JButton completedButton;
    private javax.swing.JPanel inputContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField taskInput;
    private javax.swing.JList<String> tasksContainer;
    // End of variables declaration//GEN-END:variables
}
