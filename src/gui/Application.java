/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import buildings.*;
import buildings.factories.DwellingFactory;
import buildings.factories.OfficeFactory;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Application extends javax.swing.JFrame{
    /**
     * Creates new form MainFrame
     */
    public Application(){
        initComponents();
        UIManager.LookAndFeelInfo[] l = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo l1 : l) {
            System.out.println(l1.toString());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buildingLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buildingLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buildingLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        floorLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        floorLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        floorLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        spaceLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spaceLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        spaceLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        buildingPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openDwellingMenuItem = new javax.swing.JMenuItem();
        openOfficeMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        metalRadioButton = new javax.swing.JRadioButtonMenuItem();
        motifRadioButton = new javax.swing.JRadioButtonMenuItem();
        nimbusRadioButton = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buildings");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Building"));

        jLabel1.setText("Type");
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel1.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 15));

        buildingLabel1.setMaximumSize(new java.awt.Dimension(150, 15));
        buildingLabel1.setMinimumSize(new java.awt.Dimension(150, 15));
        buildingLabel1.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel3.setText("Floors");
        jLabel3.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel3.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 15));

        buildingLabel2.setMaximumSize(new java.awt.Dimension(150, 15));
        buildingLabel2.setMinimumSize(new java.awt.Dimension(150, 15));
        buildingLabel2.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel5.setText("Total area");
        jLabel5.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel5.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel5.setPreferredSize(new java.awt.Dimension(150, 15));

        buildingLabel3.setMaximumSize(new java.awt.Dimension(150, 15));
        buildingLabel3.setMinimumSize(new java.awt.Dimension(150, 15));
        buildingLabel3.setPreferredSize(new java.awt.Dimension(150, 15));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buildingLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buildingLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buildingLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buildingLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buildingLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buildingLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Floor"));

        jLabel7.setText("Number");
        jLabel7.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel7.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 15));

        floorLabel1.setMaximumSize(new java.awt.Dimension(150, 15));
        floorLabel1.setMinimumSize(new java.awt.Dimension(150, 15));
        floorLabel1.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel9.setText("Spaces");
        jLabel9.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel9.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel9.setPreferredSize(new java.awt.Dimension(150, 15));

        floorLabel2.setMaximumSize(new java.awt.Dimension(150, 15));
        floorLabel2.setMinimumSize(new java.awt.Dimension(150, 15));
        floorLabel2.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel11.setText("Total area");
        jLabel11.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel11.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel11.setPreferredSize(new java.awt.Dimension(150, 15));

        floorLabel3.setMaximumSize(new java.awt.Dimension(150, 15));
        floorLabel3.setMinimumSize(new java.awt.Dimension(150, 15));
        floorLabel3.setPreferredSize(new java.awt.Dimension(150, 15));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(floorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(floorLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(floorLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(floorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(floorLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(floorLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Space"));

        jLabel13.setText("Number");
        jLabel13.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel13.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 15));

        spaceLabel1.setMaximumSize(new java.awt.Dimension(150, 15));
        spaceLabel1.setMinimumSize(new java.awt.Dimension(150, 15));
        spaceLabel1.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel15.setText("Rooms");
        jLabel15.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel15.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 15));

        spaceLabel2.setMaximumSize(new java.awt.Dimension(150, 15));
        spaceLabel2.setMinimumSize(new java.awt.Dimension(150, 15));
        spaceLabel2.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel17.setText("Total area");
        jLabel17.setMaximumSize(new java.awt.Dimension(150, 15));
        jLabel17.setMinimumSize(new java.awt.Dimension(150, 15));
        jLabel17.setPreferredSize(new java.awt.Dimension(150, 15));

        spaceLabel3.setMaximumSize(new java.awt.Dimension(150, 15));
        spaceLabel3.setMinimumSize(new java.awt.Dimension(150, 15));
        spaceLabel3.setPreferredSize(new java.awt.Dimension(150, 15));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spaceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spaceLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spaceLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spaceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spaceLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spaceLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout buildingPanelLayout = new javax.swing.GroupLayout(buildingPanel);
        buildingPanel.setLayout(buildingPanelLayout);
        buildingPanelLayout.setHorizontalGroup(
            buildingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        buildingPanelLayout.setVerticalGroup(
            buildingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(buildingPanel);

        jMenu1.setText("File");

        openDwellingMenuItem.setText("Open Dwelling");
        openDwellingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDwellingMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(openDwellingMenuItem);

        openOfficeMenuItem.setText("Open OfficeBuilding");
        openOfficeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openOfficeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(openOfficeMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Look & Feel");

        metalRadioButton.setSelected(true);
        metalRadioButton.setText("Metal");
        metalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metalRadioButtonActionPerformed(evt);
            }
        });
        jMenu2.add(metalRadioButton);

        motifRadioButton.setText("CDE/Motif");
        motifRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motifRadioButtonActionPerformed(evt);
            }
        });
        jMenu2.add(motifRadioButton);

        nimbusRadioButton.setText("Nimbus");
        nimbusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimbusRadioButtonActionPerformed(evt);
            }
        });
        jMenu2.add(nimbusRadioButton);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void metalRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_metalRadioButtonActionPerformed
    {//GEN-HEADEREND:event_metalRadioButtonActionPerformed
        metalRadioButton.setSelected(true);
        motifRadioButton.setSelected(false);
        nimbusRadioButton.setSelected(false);
        try{
            UIManager.setLookAndFeel(new MetalLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } 
        catch (UnsupportedLookAndFeelException ex){
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_metalRadioButtonActionPerformed

    private void motifRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_motifRadioButtonActionPerformed
    {//GEN-HEADEREND:event_motifRadioButtonActionPerformed
        metalRadioButton.setSelected(false);
        motifRadioButton.setSelected(true);
        nimbusRadioButton.setSelected(false);
        try{
            UIManager.setLookAndFeel(new MotifLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } 
        catch (UnsupportedLookAndFeelException ex){
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_motifRadioButtonActionPerformed

    private void nimbusRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nimbusRadioButtonActionPerformed
    {//GEN-HEADEREND:event_nimbusRadioButtonActionPerformed
        metalRadioButton.setSelected(false);
        motifRadioButton.setSelected(false);
        
        nimbusRadioButton.setSelected(true);
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } 
        catch (UnsupportedLookAndFeelException ex){
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nimbusRadioButtonActionPerformed

    private void openDwellingMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openDwellingMenuItemActionPerformed
    {//GEN-HEADEREND:event_openDwellingMenuItemActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
        
        JFileChooser dialog = new JFileChooser();
        dialog.setFileFilter(filter);
        if (dialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File file = dialog.getSelectedFile();
            openDwelling(file);
        }
    }//GEN-LAST:event_openDwellingMenuItemActionPerformed

    private void openOfficeMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openOfficeMenuItemActionPerformed
    {//GEN-HEADEREND:event_openOfficeMenuItemActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
        
        JFileChooser dialog = new JFileChooser();
        dialog.setFileFilter(filter);
        if (dialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File file = dialog.getSelectedFile();
            openOfficeBuilding(file);
        }
    }//GEN-LAST:event_openOfficeMenuItemActionPerformed

    private void openDwelling(File file){
        clearCurrentBuilding();
        try{
            Buildings.setBuildingFactory(new DwellingFactory());
            Building building = Buildings.readBuilding(new FileReader(file));
            buildingLabel1.setText("Dwelling");
            buildingLabel2.setText(building.getNumberOfFloors() + "");
            double area = building.getTotalArea();
            buildingLabel3.setText(area + "");
            buildingPanel.setLayout(new BoxLayout(buildingPanel, BoxLayout.Y_AXIS));
            for (int i = 0; i < building.getNumberOfFloors(); i++){
                buildingPanel.add(createFloorPanel(building.getFloor(i), i));
            }
        } 
        catch (IOException ex){
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void openOfficeBuilding(File file){
        clearCurrentBuilding();
        try{
            Buildings.setBuildingFactory(new OfficeFactory());
            Building building = Buildings.readBuilding(new FileReader(file));
            buildingLabel1.setText("Office building");
            buildingLabel2.setText(building.getNumberOfFloors() + "");
            double area = building.getTotalArea();
            buildingLabel3.setText(area + "");
            buildingPanel.setLayout(new BoxLayout(buildingPanel, BoxLayout.Y_AXIS));
            for (int i = 0; i < building.getNumberOfFloors(); i++){
                buildingPanel.add(createFloorPanel(building.getFloor(i), i));
            }
        } 
        catch ( IOException ex){
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private JPanel createFloorPanel(final Floor floor, final int number){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(new TitledBorder("Floor " + number));
        panel.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e){
                floorLabel1.setText(number + "");
                floorLabel2.setText(floor.getNumberOfSpaces() + "");
                floorLabel3.setText(floor.getTotalArea() + "");
            }

            @Override
            public void mousePressed(MouseEvent e){}

            @Override
            public void mouseReleased(MouseEvent e){}

            @Override
            public void mouseEntered(MouseEvent e){}

            @Override
            public void mouseExited(MouseEvent e){}
        });
        for (int i = 0; i < floor.getNumberOfSpaces(); i++){
            panel.add(createSpaceButton(floor.getSpace(i), i));
        }
        return panel;
    }
    
    private JButton createSpaceButton(final Space space, final int number){
        JButton button = new JButton("Space " + number);
        button.addActionListener((ActionEvent) -> {
            spaceLabel1.setText(number + "");
            spaceLabel2.setText(space.getNumberOfRooms() + "");
            spaceLabel3.setText(space.getArea() + "");
        });
        return button;
    }
    
    private void clearCurrentBuilding(){
        buildingPanel.removeAll();
        buildingLabel1.setText("");
        buildingLabel2.setText("");
        buildingLabel3.setText("");
        floorLabel1.setText("");
        floorLabel2.setText("");
        floorLabel3.setText("");
        spaceLabel1.setText("");
        spaceLabel2.setText("");
        spaceLabel3.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try{
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | 
                 IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Application().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buildingLabel1;
    private javax.swing.JLabel buildingLabel2;
    private javax.swing.JLabel buildingLabel3;
    private javax.swing.JPanel buildingPanel;
    private javax.swing.JLabel floorLabel1;
    private javax.swing.JLabel floorLabel2;
    private javax.swing.JLabel floorLabel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButtonMenuItem metalRadioButton;
    private javax.swing.JRadioButtonMenuItem motifRadioButton;
    private javax.swing.JRadioButtonMenuItem nimbusRadioButton;
    private javax.swing.JMenuItem openDwellingMenuItem;
    private javax.swing.JMenuItem openOfficeMenuItem;
    private javax.swing.JLabel spaceLabel1;
    private javax.swing.JLabel spaceLabel2;
    private javax.swing.JLabel spaceLabel3;
    // End of variables declaration//GEN-END:variables
}
