package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Nicolás
 */
public class Vista1 extends JFrame
{

    public Vista1()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBusqueda = new ButtonGroup();
        grupoRecorrido = new ButtonGroup();
        grupoCreacionGrafo = new ButtonGroup();
        jSplitPane1 = new JSplitPane();
        jScrollPane1 = new JScrollPane();
        panelGraficoGrafo = new JPanel();
        jPanel6 = new JPanel();
        PanelContVerticesAristas = new JPanel();
        PanelAristas = new JPanel();
        jButton8 = new JButton();
        jButton9 = new JButton();
        PanelVertices = new JPanel();
        jButton6 = new JButton();
        jButton7 = new JButton();
        PanelCreacion = new JPanel();
        jComboBox1 = new JComboBox<>();
        jButton1 = new JButton();
        PanelContBusquedasRecorridos = new JPanel();
        PanelBusquedas1 = new JPanel();
        jButton3 = new JButton();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        PanelBusquedas2 = new JPanel();
        jLabel5 = new JLabel();
        jComboBox4 = new JComboBox<>();
        jLabel6 = new JLabel();
        jTextField3 = new JTextField();
        jButton4 = new JButton();
        PanelBusquedas3 = new JPanel();
        jButton10 = new JButton();
        jButton11 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafos!");
        setMinimumSize(new Dimension(800, 600));

        jSplitPane1.setDividerLocation(280);

        panelGraficoGrafo.setBackground(new Color(255, 255, 255));
        panelGraficoGrafo.setMinimumSize(new Dimension(0, 0));
        panelGraficoGrafo.setPreferredSize(new Dimension(0, 0));
        panelGraficoGrafo.setLayout(new BorderLayout());
        jScrollPane1.setViewportView(panelGraficoGrafo);

        jSplitPane1.setRightComponent(jScrollPane1);

        jPanel6.setLayout(new BorderLayout());

        PanelContVerticesAristas.setBackground(new Color(64, 64, 64));
        PanelContVerticesAristas.setBorder(BorderFactory.createTitledBorder(null, "Edición", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 156, 144))); // NOI18N
        PanelContVerticesAristas.setMinimumSize(new Dimension(280, 70));
        PanelContVerticesAristas.setPreferredSize(new Dimension(260, 220));
        PanelContVerticesAristas.setLayout(null);

        PanelAristas.setBackground(new Color(64, 64, 64));
        PanelAristas.setBorder(BorderFactory.createTitledBorder(null, "Aristas", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelAristas.setLayout(null);

        jButton8.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\Button+GreenGray1.png")); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton8.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\Button+GreenGray2.png")); // NOI18N
        PanelAristas.add(jButton8);
        jButton8.setBounds(60, 30, 57, 57);

        jButton9.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\ButtonRedGray1.png")); // NOI18N
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton9.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\ButtonRedGray2.png")); // NOI18N
        jButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        PanelAristas.add(jButton9);
        jButton9.setBounds(160, 30, 57, 57);

        PanelContVerticesAristas.add(PanelAristas);
        PanelAristas.setBounds(0, 110, 280, 110);

        PanelVertices.setBackground(new Color(64, 64, 64));
        PanelVertices.setBorder(BorderFactory.createTitledBorder(null, "Vértices", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelVertices.setLayout(null);

        jButton6.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\Button+GreenGray1.png")); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton6.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\Button+GreenGray2.png")); // NOI18N
        PanelVertices.add(jButton6);
        jButton6.setBounds(60, 30, 57, 57);

        jButton7.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\ButtonRedGray1.png")); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton7.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\ButtonRedGray2.png")); // NOI18N
        jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        PanelVertices.add(jButton7);
        jButton7.setBounds(160, 30, 57, 57);

        PanelContVerticesAristas.add(PanelVertices);
        PanelVertices.setBounds(0, 0, 280, 110);

        jPanel6.add(PanelContVerticesAristas, BorderLayout.CENTER);

        PanelCreacion.setBackground(new Color(64, 64, 64));
        PanelCreacion.setBorder(BorderFactory.createTitledBorder(null, "Creación del grafo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelCreacion.setMinimumSize(new Dimension(22, 150));
        PanelCreacion.setPreferredSize(new Dimension(22, 80));
        PanelCreacion.setLayout(null);

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Matriz de adyacencia", "Lista de adyacencia" }));
        jComboBox1.setBorder(BorderFactory.createTitledBorder(null, "Tipo de grafo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 11), new Color(255, 141, 141))); // NOI18N
        jComboBox1.setFocusable(false);
        jComboBox1.setOpaque(false);
        PanelCreacion.add(jComboBox1);
        jComboBox1.setBounds(10, 20, 150, 50);

        jButton1.setBackground(new Color(38, 166, 154));
        jButton1.setFont(new Font("Dialog", 0, 14)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Crear");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        PanelCreacion.add(jButton1);
        jButton1.setBounds(170, 37, 100, 30);

        jPanel6.add(PanelCreacion, BorderLayout.PAGE_START);

        PanelContBusquedasRecorridos.setBackground(new Color(64, 64, 64));
        PanelContBusquedasRecorridos.setBorder(BorderFactory.createTitledBorder(null, "Busquedas", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelContBusquedasRecorridos.setPreferredSize(new Dimension(22, 330));
        PanelContBusquedasRecorridos.setLayout(null);

        PanelBusquedas1.setBackground(new Color(64, 64, 64));
        PanelBusquedas1.setBorder(BorderFactory.createTitledBorder(null, "Adyacencia", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelBusquedas1.setLayout(null);

        jButton3.setBackground(new Color(38, 166, 154));
        jButton3.setFont(new Font("Dialog", 0, 14)); // NOI18N
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("Comprobar");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        PanelBusquedas1.add(jButton3);
        jButton3.setBounds(80, 70, 110, 30);

        jTextField4.setText(" ");
        PanelBusquedas1.add(jTextField4);
        jTextField4.setBounds(160, 30, 100, 30);

        jTextField5.setText(" ");
        PanelBusquedas1.add(jTextField5);
        jTextField5.setBounds(30, 30, 100, 30);

        PanelContBusquedasRecorridos.add(PanelBusquedas1);
        PanelBusquedas1.setBounds(0, 220, 280, 110);

        PanelBusquedas2.setBackground(new Color(64, 64, 64));
        PanelBusquedas2.setBorder(BorderFactory.createTitledBorder(null, "Busquedas", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelBusquedas2.setLayout(null);

        jLabel5.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new Color(255, 141, 141));
        jLabel5.setText("Tipo de búsqueda:");
        PanelBusquedas2.add(jLabel5);
        jLabel5.setBounds(10, 20, 120, 16);

        jComboBox4.setEditable(true);
        jComboBox4.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Anchura", "Profundidad" }));
        jComboBox4.setBorder(null);
        jComboBox4.setFocusable(false);
        jComboBox4.setOpaque(false);
        PanelBusquedas2.add(jComboBox4);
        jComboBox4.setBounds(140, 20, 130, 20);

        jLabel6.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setForeground(new Color(255, 141, 141));
        jLabel6.setText("Vértice:");
        PanelBusquedas2.add(jLabel6);
        jLabel6.setBounds(10, 50, 50, 16);

        jTextField3.setText(" ");
        PanelBusquedas2.add(jTextField3);
        jTextField3.setBounds(60, 50, 90, 30);

        jButton4.setBackground(new Color(38, 166, 154));
        jButton4.setFont(new Font("Dialog", 0, 14)); // NOI18N
        jButton4.setForeground(new Color(255, 255, 255));
        jButton4.setText("Buscar");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        PanelBusquedas2.add(jButton4);
        jButton4.setBounds(160, 50, 110, 30);

        PanelContBusquedasRecorridos.add(PanelBusquedas2);
        PanelBusquedas2.setBounds(0, 0, 280, 110);

        PanelBusquedas3.setBackground(new Color(64, 64, 64));
        PanelBusquedas3.setBorder(BorderFactory.createTitledBorder(null, "Recorridos", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelBusquedas3.setLayout(null);

        jButton10.setBackground(new Color(38, 166, 154));
        jButton10.setFont(new Font("Dialog", 0, 14)); // NOI18N
        jButton10.setForeground(new Color(255, 255, 255));
        jButton10.setText("Profundidad");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton10.setFocusPainted(false);
        PanelBusquedas3.add(jButton10);
        jButton10.setBounds(150, 40, 110, 40);

        jButton11.setBackground(new Color(38, 166, 154));
        jButton11.setFont(new Font("Dialog", 0, 14)); // NOI18N
        jButton11.setForeground(new Color(255, 255, 255));
        jButton11.setText("Anchura");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton11.setFocusPainted(false);
        PanelBusquedas3.add(jButton11);
        jButton11.setBounds(20, 40, 110, 40);

        PanelContBusquedasRecorridos.add(PanelBusquedas3);
        PanelBusquedas3.setBounds(0, 110, 280, 110);

        jPanel6.add(PanelContBusquedasRecorridos, BorderLayout.PAGE_END);

        jSplitPane1.setLeftComponent(jPanel6);

        getContentPane().add(jSplitPane1, BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed


    public ButtonGroup getGrupoBusqueda()
    {
        return grupoBusqueda;
    }

    public ButtonGroup getGrupoCreacionGrafo()
    {
        return grupoCreacionGrafo;
    }

    public ButtonGroup getGrupoRecorrido()
    {
        return grupoRecorrido;
    }

    public JPanel getPanelGraficoGrafo()
    {
        return panelGraficoGrafo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel PanelAristas;
    private JPanel PanelBusquedas1;
    private JPanel PanelBusquedas2;
    private JPanel PanelBusquedas3;
    private JPanel PanelContBusquedasRecorridos;
    private JPanel PanelContVerticesAristas;
    private JPanel PanelCreacion;
    private JPanel PanelVertices;
    private ButtonGroup grupoBusqueda;
    private ButtonGroup grupoCreacionGrafo;
    private ButtonGroup grupoRecorrido;
    private JButton jButton1;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JSplitPane jSplitPane1;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JPanel panelGraficoGrafo;
    // End of variables declaration//GEN-END:variables
}
