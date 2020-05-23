package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Equipo1
 */
public class Vista extends JFrame {

    public Vista() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/Icono2.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBusqueda = new ButtonGroup();
        grupoRecorrido = new ButtonGroup();
        grupoCreacionGrafo = new ButtonGroup();
        jSplitPane1 = new JSplitPane();
        jScrollPane1 = new JScrollPane();
        ContainerpanelGraficoGrafo = new JPanel();
        panelGraficoGrafo = new JPanel();
        jPanel6 = new JPanel();
        PanelContVerticesAristas = new JPanel();
        PanelAristas = new JPanel();
        BtnAgregarArista = new JButton();
        BtnBorrarArista = new JButton();
        PanelVertices = new JPanel();
        BtnAgregarVertice = new JButton();
        BtnBorrarVertice = new JButton();
        PanelCreacion = new JPanel();
        jComboBox1 = new JComboBox<>();
        BtnCrearGrafo = new JButton();
        PanelContBusquedasRecorridos = new JPanel();
        PanelBusquedas1 = new JPanel();
        jLabel7 = new JLabel();
        BtnAdyacencia = new JButton();
        TxtAdyacenciaDestino = new JTextField();
        jLabel8 = new JLabel();
        TxtAdyacenciaOrigen = new JTextField();
        PanelBusquedas2 = new JPanel();
        jLabel5 = new JLabel();
        ComboTipoBusqueda = new JComboBox<>();
        jLabel6 = new JLabel();
        BtnVerticeBusqueda = new JButton();
        TxtVerticeBusqueda = new JTextField();
        PanelBusquedas3 = new JPanel();
        BtnRecorridoProfundidad = new JButton();
        BtnRecorridoAnchura = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edición de grafos");
        setMinimumSize(new Dimension(800, 600));
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jSplitPane1.setDividerLocation(280);

        ContainerpanelGraficoGrafo.setBackground(new Color(64, 64, 64));
        ContainerpanelGraficoGrafo.setBorder(BorderFactory.createTitledBorder(null, "Grafo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        ContainerpanelGraficoGrafo.setMinimumSize(new Dimension(0, 0));
        ContainerpanelGraficoGrafo.setPreferredSize(new Dimension(700, 0));
        ContainerpanelGraficoGrafo.setLayout(new BorderLayout());

        panelGraficoGrafo.setBackground(new Color(58, 76, 94));
        ContainerpanelGraficoGrafo.add(panelGraficoGrafo, BorderLayout.CENTER);

        jScrollPane1.setViewportView(ContainerpanelGraficoGrafo);

        jSplitPane1.setRightComponent(jScrollPane1);

        jPanel6.setLayout(new BorderLayout());

        PanelContVerticesAristas.setBackground(new Color(64, 64, 64));
        PanelContVerticesAristas.setMinimumSize(new Dimension(280, 70));
        PanelContVerticesAristas.setPreferredSize(new Dimension(260, 220));
        PanelContVerticesAristas.setLayout(null);

        PanelAristas.setBackground(new Color(64, 64, 64));
        PanelAristas.setBorder(BorderFactory.createTitledBorder(null, "Aristas", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelAristas.setLayout(null);

        BtnAgregarArista.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\ProyectoUnidadGrafos\\img\\Button+GreenGray1.png")); // NOI18N
        BtnAgregarArista.setBorder(null);
        BtnAgregarArista.setBorderPainted(false);
        BtnAgregarArista.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnAgregarArista.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\ProyectoUnidadGrafos\\img\\Button+GreenGray2.png")); // NOI18N
        PanelAristas.add(BtnAgregarArista);
        BtnAgregarArista.setBounds(60, 30, 57, 57);

        BtnBorrarArista.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\ProyectoUnidadGrafos\\img\\ButtonRedGray1.png")); // NOI18N
        BtnBorrarArista.setBorder(null);
        BtnBorrarArista.setBorderPainted(false);
        BtnBorrarArista.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnBorrarArista.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\ProyectoUnidadGrafos\\img\\ButtonRedGray2.png")); // NOI18N
        BtnBorrarArista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BtnBorrarAristaActionPerformed(evt);
            }
        });
        PanelAristas.add(BtnBorrarArista);
        BtnBorrarArista.setBounds(160, 30, 57, 57);

        PanelContVerticesAristas.add(PanelAristas);
        PanelAristas.setBounds(0, 110, 280, 110);

        PanelVertices.setBackground(new Color(64, 64, 64));
        PanelVertices.setBorder(BorderFactory.createTitledBorder(null, "Vértices", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelVertices.setLayout(null);

        BtnAgregarVertice.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\ProyectoUnidadGrafos\\img\\Button+GreenGray1.png")); // NOI18N
        BtnAgregarVertice.setBorder(null);
        BtnAgregarVertice.setBorderPainted(false);
        BtnAgregarVertice.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnAgregarVertice.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\ProyectoUnidadGrafos\\img\\Button+GreenGray2.png")); // NOI18N
        BtnAgregarVertice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BtnAgregarVerticeActionPerformed(evt);
            }
        });
        PanelVertices.add(BtnAgregarVertice);
        BtnAgregarVertice.setBounds(60, 30, 57, 57);

        BtnBorrarVertice.setIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\ProyectoUnidadGrafos\\img\\ButtonRedGray1.png")); // NOI18N
        BtnBorrarVertice.setBorder(null);
        BtnBorrarVertice.setBorderPainted(false);
        BtnBorrarVertice.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnBorrarVertice.setPressedIcon(new ImageIcon("C:\\Users\\Equipo1\\Desktop\\ProyectoUnidadGrafos\\img\\ButtonRedGray2.png")); // NOI18N
        BtnBorrarVertice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BtnBorrarVerticeActionPerformed(evt);
            }
        });
        PanelVertices.add(BtnBorrarVertice);
        BtnBorrarVertice.setBounds(160, 30, 57, 57);

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

        BtnCrearGrafo.setBackground(new Color(38, 166, 154));
        BtnCrearGrafo.setFont(new Font("Dialog", 0, 14)); // NOI18N
        BtnCrearGrafo.setForeground(new Color(255, 255, 255));
        BtnCrearGrafo.setText("Crear");
        BtnCrearGrafo.setBorder(null);
        BtnCrearGrafo.setBorderPainted(false);
        BtnCrearGrafo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnCrearGrafo.setFocusPainted(false);
        PanelCreacion.add(BtnCrearGrafo);
        BtnCrearGrafo.setBounds(170, 37, 100, 30);

        jPanel6.add(PanelCreacion, BorderLayout.PAGE_START);

        PanelContBusquedasRecorridos.setBackground(new Color(64, 64, 64));
        PanelContBusquedasRecorridos.setBorder(BorderFactory.createTitledBorder(null, "Busquedas", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelContBusquedasRecorridos.setPreferredSize(new Dimension(22, 330));
        PanelContBusquedasRecorridos.setLayout(null);

        PanelBusquedas1.setBackground(new Color(64, 64, 64));
        PanelBusquedas1.setBorder(BorderFactory.createTitledBorder(null, "Adyacencia", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelBusquedas1.setLayout(null);

        jLabel7.setBackground(new Color(64, 64, 64));
        jLabel7.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setForeground(new Color(255, 141, 141));
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("Destino");
        jLabel7.setOpaque(true);
        PanelBusquedas1.add(jLabel7);
        jLabel7.setBounds(160, 20, 100, 20);

        BtnAdyacencia.setBackground(new Color(38, 166, 154));
        BtnAdyacencia.setFont(new Font("Dialog", 0, 14)); // NOI18N
        BtnAdyacencia.setForeground(new Color(255, 255, 255));
        BtnAdyacencia.setText("Comprobar");
        BtnAdyacencia.setBorder(null);
        BtnAdyacencia.setBorderPainted(false);
        BtnAdyacencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnAdyacencia.setFocusPainted(false);
        PanelBusquedas1.add(BtnAdyacencia);
        BtnAdyacencia.setBounds(80, 80, 110, 30);

        TxtAdyacenciaDestino.setToolTipText("Origen");
        TxtAdyacenciaDestino.setBorder(new MatteBorder(null));
        PanelBusquedas1.add(TxtAdyacenciaDestino);
        TxtAdyacenciaDestino.setBounds(160, 40, 100, 30);

        jLabel8.setBackground(new Color(64, 64, 64));
        jLabel8.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setForeground(new Color(255, 141, 141));
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel8.setText("Origen");
        jLabel8.setOpaque(true);
        PanelBusquedas1.add(jLabel8);
        jLabel8.setBounds(30, 20, 100, 20);

        TxtAdyacenciaOrigen.setToolTipText("Origen");
        TxtAdyacenciaOrigen.setBorder(new MatteBorder(null));
        PanelBusquedas1.add(TxtAdyacenciaOrigen);
        TxtAdyacenciaOrigen.setBounds(30, 40, 100, 30);

        PanelContBusquedasRecorridos.add(PanelBusquedas1);
        PanelBusquedas1.setBounds(0, 200, 280, 130);

        PanelBusquedas2.setBackground(new Color(64, 64, 64));
        PanelBusquedas2.setBorder(BorderFactory.createTitledBorder(null, "Busquedas", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelBusquedas2.setLayout(null);

        jLabel5.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new Color(255, 141, 141));
        jLabel5.setText("Tipo de búsqueda:");
        PanelBusquedas2.add(jLabel5);
        jLabel5.setBounds(10, 20, 120, 30);

        ComboTipoBusqueda.setEditable(true);
        ComboTipoBusqueda.setFont(new Font("Dialog", 0, 12)); // NOI18N
        ComboTipoBusqueda.setModel(new DefaultComboBoxModel<>(new String[] { "Anchura", "Profundidad" }));
        ComboTipoBusqueda.setBorder(null);
        ComboTipoBusqueda.setFocusable(false);
        ComboTipoBusqueda.setOpaque(false);
        PanelBusquedas2.add(ComboTipoBusqueda);
        ComboTipoBusqueda.setBounds(140, 20, 130, 30);

        jLabel6.setFont(new Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setForeground(new Color(255, 141, 141));
        jLabel6.setText("Vértice:");
        PanelBusquedas2.add(jLabel6);
        jLabel6.setBounds(10, 60, 50, 30);

        BtnVerticeBusqueda.setBackground(new Color(38, 166, 154));
        BtnVerticeBusqueda.setFont(new Font("Dialog", 0, 14)); // NOI18N
        BtnVerticeBusqueda.setForeground(new Color(255, 255, 255));
        BtnVerticeBusqueda.setText("Buscar");
        BtnVerticeBusqueda.setBorder(null);
        BtnVerticeBusqueda.setBorderPainted(false);
        BtnVerticeBusqueda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnVerticeBusqueda.setFocusPainted(false);
        PanelBusquedas2.add(BtnVerticeBusqueda);
        BtnVerticeBusqueda.setBounds(160, 60, 110, 30);

        TxtVerticeBusqueda.setBorder(new MatteBorder(null));
        PanelBusquedas2.add(TxtVerticeBusqueda);
        TxtVerticeBusqueda.setBounds(60, 60, 90, 30);

        PanelContBusquedasRecorridos.add(PanelBusquedas2);
        PanelBusquedas2.setBounds(0, 0, 280, 110);

        PanelBusquedas3.setBackground(new Color(64, 64, 64));
        PanelBusquedas3.setBorder(BorderFactory.createTitledBorder(null, "Recorridos", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(38, 166, 154))); // NOI18N
        PanelBusquedas3.setLayout(null);

        BtnRecorridoProfundidad.setBackground(new Color(38, 166, 154));
        BtnRecorridoProfundidad.setFont(new Font("Dialog", 0, 14)); // NOI18N
        BtnRecorridoProfundidad.setForeground(new Color(255, 255, 255));
        BtnRecorridoProfundidad.setText("Profundidad");
        BtnRecorridoProfundidad.setBorder(null);
        BtnRecorridoProfundidad.setBorderPainted(false);
        BtnRecorridoProfundidad.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnRecorridoProfundidad.setFocusPainted(false);
        PanelBusquedas3.add(BtnRecorridoProfundidad);
        BtnRecorridoProfundidad.setBounds(150, 30, 110, 40);

        BtnRecorridoAnchura.setBackground(new Color(38, 166, 154));
        BtnRecorridoAnchura.setFont(new Font("Dialog", 0, 14)); // NOI18N
        BtnRecorridoAnchura.setForeground(new Color(255, 255, 255));
        BtnRecorridoAnchura.setText("Anchura");
        BtnRecorridoAnchura.setBorder(null);
        BtnRecorridoAnchura.setBorderPainted(false);
        BtnRecorridoAnchura.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BtnRecorridoAnchura.setFocusPainted(false);
        PanelBusquedas3.add(BtnRecorridoAnchura);
        BtnRecorridoAnchura.setBounds(20, 30, 110, 40);

        PanelContBusquedasRecorridos.add(PanelBusquedas3);
        PanelBusquedas3.setBounds(0, 110, 280, 90);

        jPanel6.add(PanelContBusquedasRecorridos, BorderLayout.PAGE_END);

        jSplitPane1.setLeftComponent(jPanel6);

        getContentPane().add(jSplitPane1, BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBorrarVerticeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_BtnBorrarVerticeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBorrarVerticeActionPerformed

    private void BtnBorrarAristaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_BtnBorrarAristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBorrarAristaActionPerformed

    private void BtnAgregarVerticeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_BtnAgregarVerticeActionPerformed

    }//GEN-LAST:event_BtnAgregarVerticeActionPerformed

    private void formComponentResized(ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

    public JPanel getPanelGraficoGrafo() {
        return ContainerpanelGraficoGrafo;
    }

    public JPanel getContainerpanelGraficoGrafo() {
        return ContainerpanelGraficoGrafo;
    }

    public void setContainerpanelGraficoGrafo(JPanel ContainerpanelGraficoGrafo) {
        this.ContainerpanelGraficoGrafo = ContainerpanelGraficoGrafo;
    }

    public JButton getBtnAgregarVertice() {
        return BtnAgregarVertice;
    }

    public JButton getBtnAgregarArista() {
        return BtnAgregarArista;
    }

    public JButton getBtnCrearGrafo() {
        return BtnCrearGrafo;
    }

    public JButton getBtnBorrarArista() {
        return BtnBorrarArista;
    }

    public JButton getBtnBorrarVertice() {
        return BtnBorrarVertice;
    }

    public JButton getBtnAdyacencia() {
        return BtnAdyacencia;
    }

    public JTextField getTxtAdyacenciaDestino() {
        return TxtAdyacenciaDestino;
    }

    public JTextField getTxtAdyacenciaOrigen() {
        return TxtAdyacenciaOrigen;
    }

    public JButton getBtnVerticeBusqueda() {
        return BtnVerticeBusqueda;
    }

    public JComboBox<String> getComboTipoBusqueda() {
        return ComboTipoBusqueda;
    }

    public JTextField getTxtVerticeBusqueda() {
        return TxtVerticeBusqueda;
    }

    public JButton getBtnRecorridoAnchura() {
        return BtnRecorridoAnchura;
    }

    public JButton getBtnRecorridoProfundidad() {
        return BtnRecorridoProfundidad;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton BtnAdyacencia;
    private JButton BtnAgregarArista;
    private JButton BtnAgregarVertice;
    private JButton BtnBorrarArista;
    private JButton BtnBorrarVertice;
    private JButton BtnCrearGrafo;
    private JButton BtnRecorridoAnchura;
    private JButton BtnRecorridoProfundidad;
    private JButton BtnVerticeBusqueda;
    private JComboBox<String> ComboTipoBusqueda;
    private JPanel ContainerpanelGraficoGrafo;
    private JPanel PanelAristas;
    private JPanel PanelBusquedas1;
    private JPanel PanelBusquedas2;
    private JPanel PanelBusquedas3;
    private JPanel PanelContBusquedasRecorridos;
    private JPanel PanelContVerticesAristas;
    private JPanel PanelCreacion;
    private JPanel PanelVertices;
    private JTextField TxtAdyacenciaDestino;
    private JTextField TxtAdyacenciaOrigen;
    private JTextField TxtVerticeBusqueda;
    private ButtonGroup grupoBusqueda;
    private ButtonGroup grupoCreacionGrafo;
    private ButtonGroup grupoRecorrido;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JSplitPane jSplitPane1;
    private JPanel panelGraficoGrafo;
    // End of variables declaration//GEN-END:variables
}
