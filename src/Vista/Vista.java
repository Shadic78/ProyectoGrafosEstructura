package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
public class Vista extends JFrame
{

    public Vista()
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
        jPanel7 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jPanel1 = new JPanel();
        jComboBox1 = new JComboBox<>();
        jButton1 = new JButton();
        jPanel2 = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafos!");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(840, 620));

        jSplitPane1.setDividerLocation(280);

        panelGraficoGrafo.setBackground(new Color(255, 255, 255));
        panelGraficoGrafo.setMinimumSize(new Dimension(0, 0));
        panelGraficoGrafo.setPreferredSize(new Dimension(0, 0));
        panelGraficoGrafo.setLayout(new BorderLayout());
        jScrollPane1.setViewportView(panelGraficoGrafo);

        jSplitPane1.setRightComponent(jScrollPane1);

        jPanel6.setLayout(new BorderLayout());

        jPanel7.setBackground(new Color(255, 255, 255));
        jPanel7.setBorder(BorderFactory.createTitledBorder(null, "Edición", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 156, 144))); // NOI18N
        jPanel7.setMinimumSize(new Dimension(280, 70));
        jPanel7.setPreferredSize(new Dimension(260, 300));
        jPanel7.setLayout(null);

        jLabel1.setFont(new Font("Dialog", 0, 16)); // NOI18N
        jLabel1.setForeground(new Color(238, 110, 115));
        jLabel1.setText("Aristas:");
        jPanel7.add(jLabel1);
        jLabel1.setBounds(10, 140, 80, 21);

        jLabel2.setFont(new Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setForeground(new Color(238, 110, 115));
        jLabel2.setText("Vértices:");
        jPanel7.add(jLabel2);
        jLabel2.setBounds(10, 20, 80, 21);

        jButton4.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\Button+Green1.png")); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton4.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\Button+Green2.png")); // NOI18N
        jPanel7.add(jButton4);
        jButton4.setBounds(60, 50, 57, 57);

        jButton5.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\Button+RedNew1.png")); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton5.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\Material\\Button+RedNew2.png")); // NOI18N
        jPanel7.add(jButton5);
        jButton5.setBounds(160, 50, 57, 57);

        jPanel6.add(jPanel7, BorderLayout.CENTER);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Creación del grafo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        jPanel1.setMinimumSize(new Dimension(22, 150));
        jPanel1.setPreferredSize(new Dimension(22, 80));
        jPanel1.setLayout(null);

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Matriz de adyacencia", "Lista de adyacencia" }));
        jComboBox1.setBorder(BorderFactory.createTitledBorder(null, "Tipo de grafo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 11), new Color(255, 141, 141))); // NOI18N
        jComboBox1.setFocusable(false);
        jComboBox1.setOpaque(false);
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(10, 20, 150, 50);

        jButton1.setBackground(new Color(38, 166, 154));
        jButton1.setFont(new Font("Dialog", 0, 14)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Crear");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jPanel1.add(jButton1);
        jButton1.setBounds(170, 37, 100, 30);

        jPanel6.add(jPanel1, BorderLayout.PAGE_START);

        jPanel2.setBorder(BorderFactory.createTitledBorder("Busquedas"));
        jPanel2.setPreferredSize(new Dimension(22, 250));
        jPanel6.add(jPanel2, BorderLayout.PAGE_END);

        jSplitPane1.setLeftComponent(jPanel6);

        getContentPane().add(jSplitPane1, BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    private ButtonGroup grupoBusqueda;
    private ButtonGroup grupoCreacionGrafo;
    private ButtonGroup grupoRecorrido;
    private JButton jButton1;
    private JButton jButton4;
    private JButton jButton5;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JSplitPane jSplitPane1;
    private JPanel panelGraficoGrafo;
    // End of variables declaration//GEN-END:variables
}
