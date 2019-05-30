/*
    Copyright 2011, 2012 Volkan TUNALI
    This file is part of PRETO.

    PRETO is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PRETO is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with PRETO.  If not, see <http://www.gnu.org/licenses/>.
 */

package preto;

import document.AffixStrippingTurkishStemmer;
import document.AsciiToTurkish;
import document.Document;
import document.FixedPrefixStemmer;
import document.PorterStemmer;
import document.Stemmer;
import document.Term;
import document.ZemberekStemmer;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class PretoView extends FrameView {

    public PretoView(SingleFrameApplication app) {
        super(app);

        initComponents();
        jLabel7.hide();
        jSpinner_TermMinFreqInAnyDoc.hide();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = PretoApp.getApplication().getMainFrame();
            aboutBox = new PretoAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        PretoApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_DatasetFolder = new javax.swing.JTextField();
        jButton_OpenDatasetFolder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField_StopwordsFile = new javax.swing.JTextField();
        jButton_OpenStopwordsFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_ProcessDetails = new javax.swing.JTextArea();
        jLabel_ProcessedDocNo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_OutputFilesFolder = new javax.swing.JTextField();
        jButton_OpenOutputFilesFolder = new javax.swing.JButton();
        jCheckBox_DoStemming = new javax.swing.JCheckBox();
        jSpinner_FixedPrefixStemmerPrefixLength = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSpinner_TermMinNumberOfDocs = new javax.swing.JSpinner();
        jSpinner_TermMinPercentOfDocs = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jSpinner_TermMinFreqInAnyDoc = new javax.swing.JSpinner();
        jSpinner_TermMaxPercentOfDocs = new javax.swing.JSpinner();
        jPanel_Language = new javax.swing.JPanel();
        jRadioButton_Turkish = new javax.swing.JRadioButton();
        jRadioButton_English = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox_UseLongestStem = new javax.swing.JCheckBox();
        jButton_StartProcessing = new javax.swing.JButton();
        jCheckBox_UseAsciiToTR = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jSpinner_TermMaxNumberOfDocs = new javax.swing.JSpinner();
        jCheckBox_5gram = new javax.swing.JCheckBox();
        jCheckBox_1gram = new javax.swing.JCheckBox();
        jCheckBox_2gram = new javax.swing.JCheckBox();
        jCheckBox_3gram = new javax.swing.JCheckBox();
        jCheckBox_4gram = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton_Turkish_Stemmer_Zemberek = new javax.swing.JRadioButton();
        jRadioButton_Turkish_Stemmer_Affix_Stripping = new javax.swing.JRadioButton();
        jRadioButton_Turkish_Stemmer_Fixed_Prefix = new javax.swing.JRadioButton();
        jSpinner_MinTermLength = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        buttonGroup_DataSet_Language = new javax.swing.ButtonGroup();
        buttonGroup_Turkish_Stemmer = new javax.swing.ButtonGroup();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setLabelFor(jTextField_DatasetFolder);
        jLabel1.setText("Document DataSet Folder"); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        mainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 140, -1));

        jTextField_DatasetFolder.setName("jTextField_DatasetFolder"); // NOI18N
        mainPanel.add(jTextField_DatasetFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 12, 293, -1));

        jButton_OpenDatasetFolder.setText("..."); // NOI18N
        jButton_OpenDatasetFolder.setName("jButton_OpenDatasetFolder"); // NOI18N
        jButton_OpenDatasetFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OpenDatasetFolderActionPerformed(evt);
            }
        });
        mainPanel.add(jButton_OpenDatasetFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 11, 29, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setLabelFor(jTextField_StopwordsFile);
        jLabel2.setText("Stopwords File"); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        mainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, 140, -1));

        jTextField_StopwordsFile.setName("jTextField_StopwordsFile"); // NOI18N
        mainPanel.add(jTextField_StopwordsFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 70, 293, -1));

        jButton_OpenStopwordsFile.setText("..."); // NOI18N
        jButton_OpenStopwordsFile.setName("jButton_OpenStopwordsFile"); // NOI18N
        jButton_OpenStopwordsFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OpenStopwordsFileActionPerformed(evt);
            }
        });
        mainPanel.add(jButton_OpenStopwordsFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 69, 29, -1));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea_ProcessDetails.setColumns(20);
        jTextArea_ProcessDetails.setName("jTextArea_ProcessDetails"); // NOI18N
        jScrollPane1.setViewportView(jTextArea_ProcessDetails);

        mainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 730, 120));

        jLabel_ProcessedDocNo.setText("0"); // NOI18N
        jLabel_ProcessedDocNo.setName("jLabel_ProcessedDocNo"); // NOI18N
        mainPanel.add(jLabel_ProcessedDocNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 33, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setLabelFor(jTextField_OutputFilesFolder);
        jLabel4.setText("Output Files Folder"); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        mainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 44, 140, -1));

        jTextField_OutputFilesFolder.setName("jTextField_OutputFilesFolder"); // NOI18N
        mainPanel.add(jTextField_OutputFilesFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 41, 293, -1));

        jButton_OpenOutputFilesFolder.setText("..."); // NOI18N
        jButton_OpenOutputFilesFolder.setName("jButton_OpenOutputFilesFolder"); // NOI18N
        jButton_OpenOutputFilesFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OpenOutputFilesFolderActionPerformed(evt);
            }
        });
        mainPanel.add(jButton_OpenOutputFilesFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 40, 29, -1));

        jCheckBox_DoStemming.setSelected(true);
        jCheckBox_DoStemming.setText("Stemming");
        jCheckBox_DoStemming.setName("jCheckBox_DoStemming"); // NOI18N
        mainPanel.add(jCheckBox_DoStemming, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 74, -1));

        jSpinner_FixedPrefixStemmerPrefixLength.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(3), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinner_FixedPrefixStemmerPrefixLength.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner_FixedPrefixStemmerPrefixLength, ""));
        jSpinner_FixedPrefixStemmerPrefixLength.setName("jSpinner_FixedPrefixStemmerPrefixLength"); // NOI18N
        mainPanel.add(jSpinner_FixedPrefixStemmerPrefixLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 72, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setLabelFor(jSpinner_FixedPrefixStemmerPrefixLength);
        jLabel5.setText("Fixed Prefix Length (TR)"); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        mainPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 140, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setLabelFor(jTextField_StopwordsFile);
        jLabel6.setText("A term must appear at least in [n] documents or [n%] of documents"); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        mainPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 351, -1));

        jSpinner_TermMinNumberOfDocs.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(3), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinner_TermMinNumberOfDocs.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner_TermMinNumberOfDocs, ""));
        jSpinner_TermMinNumberOfDocs.setName("jSpinner_TermMinNumberOfDocs"); // NOI18N
        mainPanel.add(jSpinner_TermMinNumberOfDocs, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 58, -1));

        jSpinner_TermMinPercentOfDocs.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.5d));
        jSpinner_TermMinPercentOfDocs.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner_TermMinPercentOfDocs, ""));
        jSpinner_TermMinPercentOfDocs.setName("jSpinner_TermMinPercentOfDocs"); // NOI18N
        mainPanel.add(jSpinner_TermMinPercentOfDocs, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 59, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setLabelFor(jTextField_StopwordsFile);
        jLabel7.setText("A term must appear at least [n] times in a document"); // NOI18N
        jLabel7.setEnabled(false);
        jLabel7.setName("jLabel7"); // NOI18N
        mainPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 351, -1));

        jSpinner_TermMinFreqInAnyDoc.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinner_TermMinFreqInAnyDoc.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner_TermMinFreqInAnyDoc, ""));
        jSpinner_TermMinFreqInAnyDoc.setEnabled(false);
        jSpinner_TermMinFreqInAnyDoc.setName("jSpinner_TermMinFreqInAnyDoc"); // NOI18N
        mainPanel.add(jSpinner_TermMinFreqInAnyDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 58, -1));

        jSpinner_TermMaxPercentOfDocs.setModel(new javax.swing.SpinnerNumberModel(95.0d, 0.0d, 100.0d, 0.5d));
        jSpinner_TermMaxPercentOfDocs.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner_TermMaxPercentOfDocs, ""));
        jSpinner_TermMaxPercentOfDocs.setName("jSpinner_TermMaxPercentOfDocs"); // NOI18N
        mainPanel.add(jSpinner_TermMaxPercentOfDocs, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 59, -1));

        jPanel_Language.setBorder(javax.swing.BorderFactory.createTitledBorder("Language of Dataset"));
        jPanel_Language.setName("jPanel_Language"); // NOI18N

        buttonGroup_DataSet_Language.add(jRadioButton_Turkish);
        jRadioButton_Turkish.setSelected(true);
        jRadioButton_Turkish.setText("Turkish");
        jRadioButton_Turkish.setName("jRadioButton_Turkish"); // NOI18N

        buttonGroup_DataSet_Language.add(jRadioButton_English);
        jRadioButton_English.setText("English");
        jRadioButton_English.setName("jRadioButton_English"); // NOI18N

        javax.swing.GroupLayout jPanel_LanguageLayout = new javax.swing.GroupLayout(jPanel_Language);
        jPanel_Language.setLayout(jPanel_LanguageLayout);
        jPanel_LanguageLayout.setHorizontalGroup(
            jPanel_LanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LanguageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton_Turkish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jRadioButton_English)
                .addContainerGap())
        );
        jPanel_LanguageLayout.setVerticalGroup(
            jPanel_LanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jRadioButton_Turkish)
                .addComponent(jRadioButton_English))
        );

        mainPanel.add(jPanel_Language, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 11, -1, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setLabelFor(jTextField_StopwordsFile);
        jLabel8.setText("Processed Document #"); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        mainPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 140, -1));

        jCheckBox_UseLongestStem.setText("Zemberek: Longest Stem (TR)"); // NOI18N
        jCheckBox_UseLongestStem.setName("jCheckBox_UseLongestStem"); // NOI18N
        mainPanel.add(jCheckBox_UseLongestStem, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jButton_StartProcessing.setText("Start Processing"); // NOI18N
        jButton_StartProcessing.setName("jButton_StartProcessing"); // NOI18N
        jButton_StartProcessing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StartProcessingActionPerformed(evt);
            }
        });
        mainPanel.add(jButton_StartProcessing, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 169, 31));

        jCheckBox_UseAsciiToTR.setSelected(true);
        jCheckBox_UseAsciiToTR.setText("ASCII to TR");
        jCheckBox_UseAsciiToTR.setName("jCheckBox_UseAsciiToTR"); // NOI18N
        mainPanel.add(jCheckBox_UseAsciiToTR, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 102, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setLabelFor(jTextField_StopwordsFile);
        jLabel10.setText("A term can appear at most in [n] documents or [n%] of documents"); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N
        mainPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 351, -1));

        jSpinner_TermMaxNumberOfDocs.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinner_TermMaxNumberOfDocs.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner_TermMaxNumberOfDocs, ""));
        jSpinner_TermMaxNumberOfDocs.setName("jSpinner_TermMaxNumberOfDocs"); // NOI18N
        mainPanel.add(jSpinner_TermMaxNumberOfDocs, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 58, -1));

        jCheckBox_5gram.setText("5-gram");
        jCheckBox_5gram.setName("jCheckBox_5gram"); // NOI18N
        mainPanel.add(jCheckBox_5gram, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, -1));

        jCheckBox_1gram.setSelected(true);
        jCheckBox_1gram.setText("1-gram");
        jCheckBox_1gram.setName("jCheckBox_1gram"); // NOI18N
        mainPanel.add(jCheckBox_1gram, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, -1, -1));

        jCheckBox_2gram.setText("2-gram");
        jCheckBox_2gram.setName("jCheckBox_2gram"); // NOI18N
        mainPanel.add(jCheckBox_2gram, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        jCheckBox_3gram.setText("3-gram");
        jCheckBox_3gram.setName("jCheckBox_3gram"); // NOI18N
        mainPanel.add(jCheckBox_3gram, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        jCheckBox_4gram.setText("4-gram");
        jCheckBox_4gram.setName("jCheckBox_4gram"); // NOI18N
        mainPanel.add(jCheckBox_4gram, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Turkish Stemmer"));
        jPanel1.setName("jPanel1"); // NOI18N

        buttonGroup_Turkish_Stemmer.add(jRadioButton_Turkish_Stemmer_Zemberek);
        jRadioButton_Turkish_Stemmer_Zemberek.setText("Zemberek");
        jRadioButton_Turkish_Stemmer_Zemberek.setName("jRadioButton_Turkish_Stemmer_Zemberek"); // NOI18N

        buttonGroup_Turkish_Stemmer.add(jRadioButton_Turkish_Stemmer_Affix_Stripping);
        jRadioButton_Turkish_Stemmer_Affix_Stripping.setSelected(true);
        jRadioButton_Turkish_Stemmer_Affix_Stripping.setText("Affix Stripping"); // NOI18N
        jRadioButton_Turkish_Stemmer_Affix_Stripping.setName("jRadioButton_Turkish_Stemmer_Affix_Stripping"); // NOI18N

        buttonGroup_Turkish_Stemmer.add(jRadioButton_Turkish_Stemmer_Fixed_Prefix);
        jRadioButton_Turkish_Stemmer_Fixed_Prefix.setText("Fixed Prefix");
        jRadioButton_Turkish_Stemmer_Fixed_Prefix.setName("jRadioButton_Turkish_Stemmer_Fixed_Prefix"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton_Turkish_Stemmer_Affix_Stripping)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_Turkish_Stemmer_Zemberek, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton_Turkish_Stemmer_Fixed_Prefix, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_Turkish_Stemmer_Affix_Stripping)
                    .addComponent(jRadioButton_Turkish_Stemmer_Zemberek))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton_Turkish_Stemmer_Fixed_Prefix)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 220, 80));

        jSpinner_MinTermLength.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(3), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinner_MinTermLength.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner_MinTermLength, ""));
        jSpinner_MinTermLength.setName("jSpinner_MinTermLength"); // NOI18N
        mainPanel.add(jSpinner_MinTermLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 72, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setLabelFor(jSpinner_MinTermLength);
        jLabel9.setText("Minimum Term Length"); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        mainPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 140, -1));

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText("File");
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(preto.PretoApp.class).getContext().getActionMap(PretoView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        jLabel3.setText("2012.06.07.0008"); // NOI18N
        jLabel3.setName("jLabel_Version"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 761, Short.MAX_VALUE)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusMessageLabel)
                            .addComponent(statusAnimationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_OpenDatasetFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OpenDatasetFolderActionPerformed
        JFileChooser fileChooser = new JFileChooser(jTextField_DatasetFolder.getText());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this.getFrame());

        File curDir = fileChooser.getSelectedFile();
        jTextField_DatasetFolder.setText(curDir.getAbsolutePath());

        if (jTextField_OutputFilesFolder.getText().length() <= 0)
            jTextField_OutputFilesFolder.setText(curDir.getAbsolutePath());
    }//GEN-LAST:event_jButton_OpenDatasetFolderActionPerformed

    private void jButton_OpenStopwordsFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OpenStopwordsFileActionPerformed
        JFileChooser fileChooser = new JFileChooser(jTextField_StopwordsFile.getText());
        //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this.getFrame());

        File curDir = fileChooser.getSelectedFile();
        jTextField_StopwordsFile.setText(curDir.getAbsolutePath());
    }//GEN-LAST:event_jButton_OpenStopwordsFileActionPerformed

    private void jButton_StartProcessingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_StartProcessingActionPerformed
        PrintInfo("Processing started at " + DateUtils.now());
        PerformDocumentProcessing();
        PrintInfo("Processing ended at " + DateUtils.now());
    }//GEN-LAST:event_jButton_StartProcessingActionPerformed

    private void jButton_OpenOutputFilesFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OpenOutputFilesFolderActionPerformed
        JFileChooser fileChooser = new JFileChooser(jTextField_OutputFilesFolder.getText());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this.getFrame());

        File curDir = fileChooser.getSelectedFile();
        jTextField_OutputFilesFolder.setText(curDir.getAbsolutePath());
    }//GEN-LAST:event_jButton_OpenOutputFilesFolderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_DataSet_Language;
    private javax.swing.ButtonGroup buttonGroup_Turkish_Stemmer;
    private javax.swing.JButton jButton_OpenDatasetFolder;
    private javax.swing.JButton jButton_OpenOutputFilesFolder;
    private javax.swing.JButton jButton_OpenStopwordsFile;
    private javax.swing.JButton jButton_StartProcessing;
    private javax.swing.JCheckBox jCheckBox_1gram;
    private javax.swing.JCheckBox jCheckBox_2gram;
    private javax.swing.JCheckBox jCheckBox_3gram;
    private javax.swing.JCheckBox jCheckBox_4gram;
    private javax.swing.JCheckBox jCheckBox_5gram;
    private javax.swing.JCheckBox jCheckBox_DoStemming;
    private javax.swing.JCheckBox jCheckBox_UseAsciiToTR;
    private javax.swing.JCheckBox jCheckBox_UseLongestStem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_ProcessedDocNo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Language;
    private javax.swing.JRadioButton jRadioButton_English;
    private javax.swing.JRadioButton jRadioButton_Turkish;
    private javax.swing.JRadioButton jRadioButton_Turkish_Stemmer_Affix_Stripping;
    private javax.swing.JRadioButton jRadioButton_Turkish_Stemmer_Fixed_Prefix;
    private javax.swing.JRadioButton jRadioButton_Turkish_Stemmer_Zemberek;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_FixedPrefixStemmerPrefixLength;
    private javax.swing.JSpinner jSpinner_MinTermLength;
    private javax.swing.JSpinner jSpinner_TermMaxNumberOfDocs;
    private javax.swing.JSpinner jSpinner_TermMaxPercentOfDocs;
    private javax.swing.JSpinner jSpinner_TermMinFreqInAnyDoc;
    private javax.swing.JSpinner jSpinner_TermMinNumberOfDocs;
    private javax.swing.JSpinner jSpinner_TermMinPercentOfDocs;
    private javax.swing.JTextArea jTextArea_ProcessDetails;
    private javax.swing.JTextField jTextField_DatasetFolder;
    private javax.swing.JTextField jTextField_OutputFilesFolder;
    private javax.swing.JTextField jTextField_StopwordsFile;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    // TextPP.cpp'den alınan
    private static long VERY_LARGE_LONG_INTEGER = 10000000;
    private List<Document> documents = new ArrayList<Document>();
    private List<Term> terms = new ArrayList<Term>();
    private HashMap<String, Term> stringToTermMap = new HashMap<String, Term>();
    private Deque<String> n2GramQueue = new LinkedList<String>();
    private Deque<String> n3GramQueue = new LinkedList<String>();
    private Deque<String> n4GramQueue = new LinkedList<String>();
    private Deque<String> n5GramQueue = new LinkedList<String>();

    private long documentCount = 0;
    private int termCount = 0;
    private long nonZeroCount = 0;

    private int minimum_word_length = 3;
    private boolean do_stopwords_elimination = false;
    private HashSet<String> stopWords = new HashSet<String>();
    private boolean do_stemming = false;
    private boolean use_longest_stem_TR = false;
    private boolean use_ascii_to_TR = false;
    private Stemmer stemmer;

    double lower_bound_percentage_of_files = 0.0;
    double upper_bound_percentage_of_files = 100.0;
    long lower_bound_number_of_files = 0;
    long upper_bound_number_of_files = VERY_LARGE_LONG_INTEGER;
    // 05.01.2011 VT begin
    long lower_bound_freq_in_any_doc = 1;
    // 05.01.2011 VT end


    private boolean n1Gram = false;
    private boolean n2Gram = false;
    private boolean n3Gram = false;
    private boolean n4Gram = false;
    private boolean n5Gram = false;
    
    DatasetLanguage dataset_language = DatasetLanguage.Turkish;
    // TextPP.cpp'den alınan

    private void PrintInfo(String text)
    {
        jTextArea_ProcessDetails.append(text + "\n");
        jTextArea_ProcessDetails.setCaretPosition(jTextArea_ProcessDetails.getDocument().getLength());
        /*
        try {
            Thread.sleep(100);
        } catch(InterruptedException ex) {
        }
        */
        jTextArea_ProcessDetails.paintImmediately(0,0,jTextArea_ProcessDetails.getWidth(), jTextArea_ProcessDetails.getHeight());
    }

    private void ProcessAllFilesRecursively(String dirName) {
        //throw new UnsupportedOperationException("Not yet implemented");
        PrintInfo("Processing Folder: " + dirName);

        File f = new File(dirName);
        for(File ff:f.listFiles())
        {
            if (ff.isDirectory())
                ProcessAllFilesRecursively(ff.getAbsolutePath());
            else
                ProcessFile(ff);
        }
    }

    private boolean IsValidLetter(int i)
    {
        return ((i >= 'a' && i <= 'z') || (i >= 'A' && i <= 'Z')); // || (i == '@'));
    }

    private boolean IsValidLetterTR(int i)
    {
        return ((i >= 'a' && i <= 'z') || 
                (i >= 'A' && i <= 'Z') || 
                (i == 'İ') ||
                (i == 'ı') ||
                (i == 'Ç') ||
                (i == 'ç') ||
                (i == 'Ö') ||
                (i == 'ö') ||
                (i == 'Ş') ||
                (i == 'ş') ||
                (i == 'Ü') ||
                (i == 'ü') ||
                (i == 'Ğ') ||
                (i == 'ğ')); // ||
                // (i == '@'));
    }

    private int ToLower(int i)
    {
        if (i >= 'A' && i <= 'Z')
            return i + 32;
        else
            return i;
    }

    private int ToLowerTR(int i)
    {
        if (i == 'I')
            return 'ı';
        else
        if (i >= 'A' && i <= 'Z') {
            return i + 32;
        } else {
            switch (i) {
                case 'İ': return 'i';
                case 'Ç': return 'ç';
                case 'Ö': return 'ö';
                case 'Ü': return 'ü';
                case 'Ş': return 'ş';
                case 'Ğ': return 'ğ';
                default: return i;
            }
        }
    }

    private String GetNextToken(Reader fr) throws java.io.IOException
    {
        if (!fr.ready())
            return "";

        int i = 0;
        String retVal = "";

        int ch = fr.read();

        // harf ile baslamadiysak harf bulana kadar gidelim.
        if (!IsValidLetter(ch))
         {
            while (fr.ready())
            {
              ch = fr.read();
              if (IsValidLetter(ch))
                 break;
            }

            if (!fr.ready())
               return "";
         }

        // buraya geldiysek bir harf bulmusuzdur.
        // harf buldukca okuyalim.
        boolean firstEnter = true;
        do
        {
            if (firstEnter)
                firstEnter = false;
            else
                ch = fr.read();

              if (IsValidLetter(ch))
              {
                  ch = ToLower(ch); /* forces lower case */
                  retVal += (char)ch;
                  i++;
              }
              else
                   break;
        }
        while (fr.ready());

        return retVal;
    }

    private String GetNextTokenTR(Reader fr) throws java.io.IOException
    {
        if (!fr.ready())
            return "";

        int i = 0;
        String retVal = "";

        int ch = fr.read();

        // harf ile baslamadiysak harf bulana kadar gidelim.
        if (!IsValidLetterTR(ch))
         {
            while (fr.ready())
            {
              ch = fr.read();
              if (IsValidLetterTR(ch))
                 break;
            }

            if (!fr.ready())
               return "";
         }

        // buraya geldiysek bir harf bulmusuzdur.
        // harf buldukca okuyalim.
        boolean firstEnter = true;
        do
        {
            if (firstEnter)
                firstEnter = false;
            else
                ch = fr.read();
            if (IsValidLetterTR(ch))
              {
                  ch = ToLowerTR(ch); /* forces lower case */
                  retVal += (char)ch;
                  i++;
              }
              else
                   break;
          
        }
        while (fr.ready());

        return retVal;
    }
    private void ProcessFile(File f) {
        String name = f.getAbsolutePath();
        //PrintInfo("Processing File: " + name);
        jLabel_ProcessedDocNo.setText(String.valueOf(documentCount + 1));
        jLabel_ProcessedDocNo.paintImmediately(0, 0, jLabel_ProcessedDocNo.getWidth(),jLabel_ProcessedDocNo.getHeight());
        try
        {
            //InputStreamReader fre = new InputStreamReader()
            InputStreamReader isr;
            if (dataset_language == dataset_language.Turkish)
                isr = new InputStreamReader(new FileInputStream(f), "ISO-8859-9");
            else
                isr = new InputStreamReader(new FileInputStream(f));

            BufferedReader fr = new BufferedReader(isr);
            Document d = new Document(name);
            documents.add(d);
            documentCount++;

            ClearNGramQueues();
            String token;
            while (true) {
                if (dataset_language == DatasetLanguage.Turkish)
                    token = GetNextTokenTR(fr);
                else
                    token = GetNextToken(fr);

                if (token.length() <= 0)
                    break;

                // Test length of the word
                if (token.length() < minimum_word_length) {
                    continue;
                }

                // Test if the word is in the stop-words list
                if (do_stopwords_elimination) {
                    if (stopWords.contains(token)) {
                        //cout << "stop word çıktı: " << temp << endl;
                        continue;
                    }
                }

                // Apply Ascii to TR conversion if specified for Turkish texts.
                if (dataset_language == DatasetLanguage.Turkish && use_ascii_to_TR) 
                    token = AsciiToTurkish.AsciiToTurkish(token);

                // Apply Stemming
                if (do_stemming)
                    token = stemmer.stem(token);
                //cout << token << " ";

                //cout << term << "  ";

                // 26.08.2010 Stemming ile boyutu 3ten 2ye inen terimler olabiliyor. 
                // Bunları da almayalım. 
                // Test length of the word
                if (token.length() < minimum_word_length) {
                    continue;
                }


                // - - - - - - - - - - - - - - - - - - - - - - - - -
                // Now we have the final term. Let's process it.
                if (n1Gram)
                    ProcessTerm(d, token, false, 1);
                // - - - - - - - - - - - - - - - - - - - - - - - - -

                if (n2Gram)
                    ProcessNGram(d, token, n2GramQueue, 2);
                if (n3Gram)
                    ProcessNGram(d, token, n3GramQueue, 3);
                if (n4Gram)
                    ProcessNGram(d, token, n4GramQueue, 4);
                if (n5Gram)
                    ProcessNGram(d, token, n5GramQueue, 5);
                

            }

            fr.close();
        }
        catch (Exception ex)
        {
            //fprintf(stderr,"File %s not found or cannot open it.\n", name);
            return;
        }
    }

    private void ProcessTerm(Document d, String term, boolean isNGram, int n) {
        Term t;
        if (!stringToTermMap.containsKey(term)) { // add if not found
            termCount++;

            t = new Term();
            t.termId = termCount;
            t.value = term;
            t.termFreq = 1;
            t.docCount = 1;
            t.lastDocument = d;
            stringToTermMap.put(term, t);

            // bu terimi unordered terms vektörüne de ekleriz.
            // unordered olması sayesinde termId'ler sıralı olur.
            terms.add(t);
        } else { // increment freq if found
            t = stringToTermMap.get(term);
            t.termFreq++;

            if (t.lastDocument != d) {
                t.docCount++;
            }
            t.lastDocument = d;
        }

        // if this term exists in the current documents term list
        //    then increment its freq
        //    else add this term to the doc's term list

        if (!d.terms.containsKey(t)) {
            d.terms.put(t, 1.0f);
            nonZeroCount++;
        } else {
            Float freq = d.terms.get(t);
            freq++;
            d.terms.put(t, freq);
        }

        return;
    }

    private void WriteOutputFiles() throws java.io.IOException {
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        // OUTPUT FILES ARE GENERATED
        String outputFolder = jTextField_OutputFilesFolder.getText() + File.separator;
        String documentsTextFile = outputFolder + "documents.txt";
        String documentsFullNameTextFile = outputFolder + "documents_fullname.txt";

        String termsTextFile = outputFolder + "terms.txt";
        String termsDetailedTextFile = outputFolder + "terms_detailed.txt";
        
        String docByTermTextFile = outputFolder + "docbyterm.txt";
        String docByTermTFIDFTextFile = outputFolder + "docbyterm.tfidf.txt";
        String docByTermTFIDFNormalizedTextFile = outputFolder + "docbyterm.tfidf.norm.txt";

        String docByTermMatFile = outputFolder + "docbyterm.mat";
        String docByTermTFIDFMatFile = outputFolder + "docbyterm.tfidf.mat";
        String docByTermTFIDFNormalizedMatFile = outputFolder + "docbyterm.tfidf.norm.mat";

        FileWriter fw = new FileWriter(documentsTextFile);
        FileWriter fw2 = new FileWriter(documentsFullNameTextFile);
        for (Document d : documents) {
            File ff = new File(d.documentName);

            fw.write( ff.getName() + "\n");
            fw2.write(d.documentName + "\n");
        }
        fw.flush();
        fw.close();
        fw2.flush();
        fw2.close();
        PrintInfo("documents.txt generated.");
        PrintInfo("documents_fullname.txt generated.");

        fw = new FileWriter(termsTextFile);
        fw2 = new FileWriter(termsDetailedTextFile);
        for (Term t : terms) {
            if (t.termId > 0) {
                fw.write(t.value + "\n");
                fw2.write(t.termId + " " + t.value + " " + t.docCount + "\n");
            }
        }
        fw.flush();
        fw.close();
        fw2.flush();
        fw2.close();
        PrintInfo("terms.txt generated.");
        PrintInfo("terms_detailed.txt generated.");


        // _DOCBYTERM.TXT
        // _DOCBYTERM.MAT
        fw = new FileWriter(docByTermTextFile);
        FileWriter fw_tfidf = new FileWriter(docByTermTFIDFTextFile);
        FileWriter fw_tfidf_norm = new FileWriter(docByTermTFIDFNormalizedTextFile);

        fw2 = new FileWriter(docByTermMatFile);
        FileWriter fw_tfidf_mat = new FileWriter(docByTermTFIDFMatFile);
        FileWriter fw_tfidf_norm_mat = new FileWriter(docByTermTFIDFNormalizedMatFile);

        fw.write(documentCount + " " + termCount + " " + nonZeroCount + "\n");
        fw_tfidf.write(documentCount + " " + termCount + " " + nonZeroCount + "\n");
        fw_tfidf_norm.write(documentCount + " " + termCount + " " + nonZeroCount + "\n");


        fw2.write(documentCount + " " + termCount + " " + nonZeroCount + "\n");
        fw_tfidf_mat.write(documentCount + " " + termCount + " " + nonZeroCount + "\n");
        fw_tfidf_norm_mat.write(documentCount + " " + termCount + " " + nonZeroCount + "\n");

        int i = 0;
        for (Document d : documents) {
            i++;

            double rowWeightTotal = 0.0;
            for (Entry<Term, Float> entry : d.terms.entrySet()) {
                Term term = entry.getKey();
                int termId = term.termId;

                if (termId > 0) {
                    int termDocCount = term.docCount;
                    float freq = entry.getValue();
                    fw.write(i + " " + termId + " " + freq + "\n");
                    fw2.write(termId + " " + freq + " ");

                    double weight = 0;
                    if (freq > 0)
		      weight = (1.0 + Math.log((double)freq)) * Math.log(1.0 + ((double)documentCount/(double)termDocCount));

                    fw_tfidf.write(i + " " + termId + " " + weight + "\n");
                    fw_tfidf_mat.write(termId + " " + weight + " ");
                    rowWeightTotal += (weight * weight);
                }
            }

            // Normalize edilmiş değerleri yazabilmek için yukarıda satırdaki
            // ağırlıkların toplamını elde etmek zorundaydık. Bu nedenle
            // yukarıdakine benzer bir döngüyü tekrar kurarak ağırlıkları
            // normalize ediyor ve tfidf.norm dosyasına yazıyoruz.
            rowWeightTotal = Math.sqrt(rowWeightTotal);
            for (Entry<Term, Float> entry : d.terms.entrySet()) {
                Term term = entry.getKey();
                int termId = term.termId;

                if (termId > 0) {
                    int termDocCount = term.docCount;
                    float freq = entry.getValue();

                    double weight = 0;
                    if (freq > 0)
		      weight = (1.0 + Math.log((double)freq)) * Math.log(1.0 + ((double)documentCount/(double)termDocCount));

                    if (rowWeightTotal > 0)
                        weight /= rowWeightTotal;

                    fw_tfidf_norm.write(i + " " + termId + " " + weight + "\n");
                    fw_tfidf_norm_mat.write(termId + " " + weight + " ");
                }
            }

            fw2.write("\n");
            fw_tfidf_mat.write("\n");
            fw_tfidf_norm_mat.write("\n");

        }
        fw.flush();
        fw.close();
        fw_tfidf.flush();
        fw_tfidf.close();
        fw_tfidf_norm.flush();
        fw_tfidf_norm.close();


        fw2.flush();
        fw2.close();
        fw_tfidf_mat.flush();
        fw_tfidf_mat.close();
        fw_tfidf_norm_mat.flush();
        fw_tfidf_norm_mat.close();

        PrintInfo("Coordinate Files:");
        PrintInfo("\tdocbyterm.txt generated.");
        PrintInfo("\tdocbyterm.tfidf.txt generated.");
        PrintInfo("\tdocbyterm.tfidf.norm.txt generated.");
        PrintInfo("");
        PrintInfo("Cluto MAT Files:");
        PrintInfo("\tdocbyterm.mat generated.");
        PrintInfo("\tdocbyterm.tfidf.mat generated.");
        PrintInfo("\tdocbyterm.tfidf.norm.mat generated.");
    }

    private void LoadStopWords() {
        String swFileName = jTextField_StopwordsFile.getText();
        if (swFileName.length() > 0) {
            try {
                FileReader fr = new FileReader(swFileName);
                BufferedReader in = new BufferedReader(fr);
                String str;
                while ((str = in.readLine()) != null) {
                    stopWords.add(str);
                }
                in.close();

            } catch (java.io.IOException ex) {
            }

            do_stopwords_elimination = !stopWords.isEmpty();
        }
    }

    private void DoLowerAndUpperBoundTermElimination() {
        // 05.01.2011 VT begin
        // Min freq in any doc eliminasyonu yapıyoruz.
        /*  ---------VAZGEÇTİK ŞİMDİLİK----------
        if (lower_bound_freq_in_any_doc > 1)
        {
            List<Term> termsToEliminate = new ArrayList<Term>();

            for (Document d : documents) {
                // 1. dokümandaki en az frekans limitinin altında kalan terimleri tespit et.
                for (Entry<Term, Float> e : d.terms.entrySet()) {
                    if (e.getValue().floatValue() < lower_bound_freq_in_any_doc) {
                        termsToEliminate.add(e.getKey());
                    }
                }

                // 2. bunları dokümanın terim listesinden çıkart.
                for (Term t : termsToEliminate) {
                    d.terms.remove(t);
                    t.docCount--;
                    t.termFreq--;

                    nonZeroCount--;
                }

                // 3. geçici listeyi temizlemeyi unutma.
                termsToEliminate.clear();
            }
        }
         */
        // 05.01.2011 VT end




        // Note: -ln & -un parameters are dominant over -lp & -up if supplied together.
        if (lower_bound_percentage_of_files > 0 && lower_bound_number_of_files == 0) {
            lower_bound_number_of_files = (long) ((double) documentCount * lower_bound_percentage_of_files / 100.0);
            //cout << "Calculated Lower bound of number of files a word must appear: " << lower_bound_number_of_files << endl;

        }
        if (upper_bound_percentage_of_files < 100.0 && upper_bound_number_of_files == VERY_LARGE_LONG_INTEGER) {
            upper_bound_number_of_files = (long) ((double) documentCount * upper_bound_percentage_of_files / 100.0);
            //cout << "Calculated Upper bound of number of files a word must appear: " << upper_bound_number_of_files << endl;
        }

        int newTermId = 0;
        for (Term t : terms) {
            long docCount = t.docCount;

            if (docCount >= lower_bound_number_of_files && docCount <= upper_bound_number_of_files) {
                newTermId++;
                t.termId = newTermId;
            } else {
                t.termId = 0;
            }
        }

        // After the elimination, new term count is the last termId
        termCount = newTermId;

        // nonZeroCount'u da yeniden dikkate almak gerek.
        for (Document d : documents) {
            for (Term t : d.terms.keySet()) {
                if (t.termId <= 0) {
                    nonZeroCount--;
                }
            }
        }
    }

    private void Initialize() {
        documents = new ArrayList<Document>();
        terms = new ArrayList<Term>();
        stringToTermMap = new HashMap<String, Term>();
        n2GramQueue = new LinkedList<String>();
        n3GramQueue = new LinkedList<String>();
        n4GramQueue = new LinkedList<String>();
        n5GramQueue = new LinkedList<String>();

        documentCount = 0;
        termCount = 0;
        nonZeroCount = 0;

        minimum_word_length = 3;
        do_stopwords_elimination = false;
        stopWords = new HashSet<String>();
        do_stemming = false;

        lower_bound_percentage_of_files = 0.0;
        upper_bound_percentage_of_files = 100.0;
        lower_bound_number_of_files = 0;
        upper_bound_number_of_files = VERY_LARGE_LONG_INTEGER;
        lower_bound_freq_in_any_doc = 1;
    }

    private void ProcessParameters() {
        minimum_word_length = (Integer) jSpinner_MinTermLength.getValue();
        lower_bound_number_of_files = (Integer) jSpinner_TermMinNumberOfDocs.getValue();
        upper_bound_number_of_files = (Integer) jSpinner_TermMaxNumberOfDocs.getValue();
        if (upper_bound_number_of_files <= 0) {
            upper_bound_number_of_files = VERY_LARGE_LONG_INTEGER;
        }
        lower_bound_percentage_of_files = (Double) jSpinner_TermMinPercentOfDocs.getValue();
        upper_bound_percentage_of_files = (Double) jSpinner_TermMaxPercentOfDocs.getValue();
        lower_bound_freq_in_any_doc = (Integer) jSpinner_TermMinFreqInAnyDoc.getValue();
        use_ascii_to_TR = jCheckBox_UseAsciiToTR.isSelected();

        if (jRadioButton_Turkish.isSelected())
            dataset_language = DatasetLanguage.Turkish;
        else
            dataset_language = DatasetLanguage.English;

        if (jCheckBox_DoStemming.isSelected()) {
            do_stemming = true;
            if (dataset_language == DatasetLanguage.Turkish)
            {
                use_longest_stem_TR = jCheckBox_UseLongestStem.isSelected();

                if (jRadioButton_Turkish_Stemmer_Affix_Stripping.isSelected())
                    stemmer = new AffixStrippingTurkishStemmer();
                else
                    if (jRadioButton_Turkish_Stemmer_Zemberek.isSelected())
                        stemmer = new ZemberekStemmer(use_longest_stem_TR);
                    else
                        stemmer = new FixedPrefixStemmer((Integer)jSpinner_FixedPrefixStemmerPrefixLength.getValue());
            }
            else
                stemmer = new PorterStemmer();
        } else {
            do_stemming = false;
        }

        n1Gram = jCheckBox_1gram.isSelected();
        n2Gram = jCheckBox_2gram.isSelected();
        n3Gram = jCheckBox_3gram.isSelected();
        n4Gram = jCheckBox_4gram.isSelected();
        n5Gram = jCheckBox_5gram.isSelected();

    }


    private void PerformDocumentProcessing() {
        Initialize();
        ProcessParameters();
        LoadStopWords();
        ProcessAllFilesRecursively(jTextField_DatasetFolder.getText());
        DoLowerAndUpperBoundTermElimination();
        try {
            WriteOutputFiles();
        } catch (java.io.IOException ex) {
            PrintInfo("Error writing output files:" + ex.getMessage());
        }
    }

    private void ProcessNGram(Document d, String token, Deque nGramQueue, int n) {
        if (nGramQueue.size() >= n)
            nGramQueue.removeFirst();
        
        nGramQueue.add(token);

        if (nGramQueue.size() == n) {
            String newToken = "";
            Iterator<String> it = nGramQueue.iterator();
            boolean firstTime = true;
            while (it.hasNext()) {
                if (firstTime) {
                    firstTime = false;
                    newToken += it.next();
                } else {
                    newToken += "_" + it.next();
                }
            }
            
            ProcessTerm(d, newToken, true, n);
        }
    }

    private void ClearNGramQueues() {
        n2GramQueue.clear();
        n3GramQueue.clear();
        n4GramQueue.clear();
        n5GramQueue.clear();
    }

    public enum DatasetLanguage {
        Turkish, English
    }
}
