package com.poli.simuladorpaginacion.presentacion;

import com.poli.simuladorpaginacion.configuracion.Constantes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.poli.simuladorpaginacion.negocio.SimuladorPaginacionServicio;
import com.poli.simuladorpaginacion.negocio.SimuladorPaginacionServicioImpl;

public class VentanaGrafica extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(VentanaGrafica.class.getName());

    private final SimuladorPaginacionServicio simulador;

    /**
     * Creates new form VentanaGrafica
     */
    public VentanaGrafica() {

        setSystemLookAndFeel();
        initComponents();

        agregarNotificacion("*** Bienvenido al simulador de Marcos de Página ***");

        this.instruccionesJTextArea.setText(Constantes.INSTRUCCIONES);
        this.simulador = new SimuladorPaginacionServicioImpl();
        this.simulador.definirConsumidorNotificacion(this::agregarNotificacion);
        this.simulador.definirConsumidorListaEspera(this::actualizarListaEspera);
        this.simulador.definirConsumidorListaFinalizado(this::actualizarListaFinalizado);
        this.simulador.definirConsumidorMarcoPagina(this::actualizarMarcoPagina);

    }

    private void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, "Error configurando SystemLookAndFeel", ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        nuevoProcesoPanel = new javax.swing.JPanel();
        nuevoProcesoTamanoLabel = new javax.swing.JLabel();
        tamanoNuevoProcesoField = new javax.swing.JTextField();
        iniciarProcesoButton = new javax.swing.JButton();
        terminarProcesoPanel = new javax.swing.JPanel();
        terminarProcesoIdLabel = new javax.swing.JLabel();
        idTerminarProcesoField = new javax.swing.JTextField();
        terminarProcesoButton = new javax.swing.JButton();
        panelProcesos = new javax.swing.JPanel();
        ejecucionScrollPanel = new javax.swing.JScrollPane();
        ejecucionJList = new javax.swing.JList<>();
        esperaScrollPanel = new javax.swing.JScrollPane();
        esperaJList = new javax.swing.JList<>();
        terminadoScrollPanel = new javax.swing.JScrollPane();
        terminadoJList = new javax.swing.JList<>();
        marcoPaginaScrollPanel = new javax.swing.JScrollPane();
        marcoPaginaJList = new javax.swing.JList<>();
        ejecucionLabel = new javax.swing.JLabel();
        esperaLabel = new javax.swing.JLabel();
        terminadoLabel = new javax.swing.JLabel();
        marcoPaginaLabel = new javax.swing.JLabel();
        panelNotificaciones = new javax.swing.JPanel();
        areaNotificaciones = new javax.swing.JScrollPane();
        notificacionesJTextArea = new javax.swing.JTextArea();
        instruccionesJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instruccionesJTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paginación de Memoria");
        setBackground(new java.awt.Color(255, 0, 51));
        setResizable(false);
        setSize(new java.awt.Dimension(718, 762));

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        nuevoProcesoPanel.setBackground(new java.awt.Color(255, 255, 255));
        nuevoProcesoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Proceso"));

        nuevoProcesoTamanoLabel.setText("Tamaño:");

        iniciarProcesoButton.setText("Iniciar Proceso");
        iniciarProcesoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarProcesoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nuevoProcesoPanelLayout = new javax.swing.GroupLayout(nuevoProcesoPanel);
        nuevoProcesoPanel.setLayout(nuevoProcesoPanelLayout);
        nuevoProcesoPanelLayout.setHorizontalGroup(
            nuevoProcesoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoProcesoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevoProcesoTamanoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamanoNuevoProcesoField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iniciarProcesoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        nuevoProcesoPanelLayout.setVerticalGroup(
            nuevoProcesoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoProcesoPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(nuevoProcesoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoProcesoTamanoLabel)
                    .addComponent(tamanoNuevoProcesoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iniciarProcesoButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        terminarProcesoPanel.setBackground(new java.awt.Color(255, 255, 255));
        terminarProcesoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Terminar Proceso"));

        terminarProcesoIdLabel.setText("ID:");

        terminarProcesoButton.setText("Terminar Proceso");
        terminarProcesoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarProcesoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout terminarProcesoPanelLayout = new javax.swing.GroupLayout(terminarProcesoPanel);
        terminarProcesoPanel.setLayout(terminarProcesoPanelLayout);
        terminarProcesoPanelLayout.setHorizontalGroup(
            terminarProcesoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(terminarProcesoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(terminarProcesoIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idTerminarProcesoField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(terminarProcesoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        terminarProcesoPanelLayout.setVerticalGroup(
            terminarProcesoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(terminarProcesoPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(terminarProcesoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terminarProcesoIdLabel)
                    .addComponent(idTerminarProcesoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminarProcesoButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelProcesos.setBackground(new java.awt.Color(255, 255, 255));
        panelProcesos.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesos"));

        ejecucionScrollPanel.setViewportView(ejecucionJList);

        esperaScrollPanel.setViewportView(esperaJList);

        terminadoScrollPanel.setViewportView(terminadoJList);

        marcoPaginaScrollPanel.setViewportView(marcoPaginaJList);

        ejecucionLabel.setText("Ejecución");

        esperaLabel.setText("Espera");

        terminadoLabel.setText("Terminado");

        marcoPaginaLabel.setText("Marco de Página");

        javax.swing.GroupLayout panelProcesosLayout = new javax.swing.GroupLayout(panelProcesos);
        panelProcesos.setLayout(panelProcesosLayout);
        panelProcesosLayout.setHorizontalGroup(
            panelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProcesosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ejecucionScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(esperaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(terminadoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(marcoPaginaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelProcesosLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(ejecucionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(esperaLabel)
                .addGap(104, 104, 104)
                .addComponent(terminadoLabel)
                .addGap(82, 82, 82)
                .addComponent(marcoPaginaLabel)
                .addGap(38, 38, 38))
        );
        panelProcesosLayout.setVerticalGroup(
            panelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProcesosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ejecucionLabel)
                    .addComponent(esperaLabel)
                    .addComponent(terminadoLabel)
                    .addComponent(marcoPaginaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(panelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(terminadoScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(esperaScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ejecucionScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(marcoPaginaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        panelNotificaciones.setBackground(new java.awt.Color(255, 255, 255));
        panelNotificaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Notificaciones"));

        notificacionesJTextArea.setEditable(false);
        notificacionesJTextArea.setColumns(20);
        notificacionesJTextArea.setRows(5);
        notificacionesJTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        areaNotificaciones.setViewportView(notificacionesJTextArea);

        javax.swing.GroupLayout panelNotificacionesLayout = new javax.swing.GroupLayout(panelNotificaciones);
        panelNotificaciones.setLayout(panelNotificacionesLayout);
        panelNotificacionesLayout.setHorizontalGroup(
            panelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areaNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelNotificacionesLayout.setVerticalGroup(
            panelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areaNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        instruccionesJPanel.setBackground(new java.awt.Color(255, 255, 255));
        instruccionesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Instrucciones"));

        instruccionesJTextArea.setEditable(false);
        instruccionesJTextArea.setColumns(20);
        instruccionesJTextArea.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        instruccionesJTextArea.setLineWrap(true);
        instruccionesJTextArea.setRows(10);
        instruccionesJTextArea.setWrapStyleWord(true);
        instruccionesJTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(instruccionesJTextArea);

        javax.swing.GroupLayout instruccionesJPanelLayout = new javax.swing.GroupLayout(instruccionesJPanel);
        instruccionesJPanel.setLayout(instruccionesJPanelLayout);
        instruccionesJPanelLayout.setHorizontalGroup(
            instruccionesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instruccionesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        instruccionesJPanelLayout.setVerticalGroup(
            instruccionesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, instruccionesJPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instruccionesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(nuevoProcesoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terminarProcesoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelProcesos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelNotificaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(instruccionesJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(terminarProcesoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevoProcesoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarProcesoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarProcesoButtonActionPerformed
        final String textoTamano = tamanoNuevoProcesoField.getText();
        if (textoTamano.isBlank()) {
            return;
        }
        try {
            int tamano = Integer.valueOf(textoTamano);
            this.simulador.iniciarProceso(tamano);
        } catch (NumberFormatException ex) {
            final String mensajeError = "Error formateando tamaño de proceso";
            agregarNotificacion(mensajeError);
            LOGGER.log(Level.SEVERE, mensajeError, ex);
        } finally {
            tamanoNuevoProcesoField.setText(null);
        }
    }//GEN-LAST:event_iniciarProcesoButtonActionPerformed

    private void terminarProcesoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarProcesoButtonActionPerformed
        String id = idTerminarProcesoField.getText();
        if(id.isBlank()){
            return;
        }
        this.simulador.terminarProceso(id);
        idTerminarProcesoField.setText(null);
    }//GEN-LAST:event_terminarProcesoButtonActionPerformed

    private void agregarNotificacion(String mensaje) {
        notificacionesJTextArea.setText(
                notificacionesJTextArea.getText() + mensaje + "\n");
    }

    private void actualizarListaEspera(List<String> listaEspera) {
        esperaJList.setModel(new StringListModel(listaEspera));
    }

    private void actualizarListaFinalizado(List<String> listaTerminado) {
        terminadoJList.setModel(new StringListModel(listaTerminado));
    }

    private void actualizarMarcoPagina(
            List<String> listaEjecucion,
            List<String> listaMarcoPagina) {
        ejecucionJList.setModel(new StringListModel(listaEjecucion));
        marcoPaginaJList.setModel(new StringListModel(listaMarcoPagina));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            VentanaGrafica window = new VentanaGrafica();
            //window.setSize(627, 700);
            window.setResizable(false);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane areaNotificaciones;
    private javax.swing.JList<String> ejecucionJList;
    private javax.swing.JLabel ejecucionLabel;
    private javax.swing.JScrollPane ejecucionScrollPanel;
    private javax.swing.JList<String> esperaJList;
    private javax.swing.JLabel esperaLabel;
    private javax.swing.JScrollPane esperaScrollPanel;
    private javax.swing.JTextField idTerminarProcesoField;
    private javax.swing.JButton iniciarProcesoButton;
    private javax.swing.JPanel instruccionesJPanel;
    private javax.swing.JTextArea instruccionesJTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> marcoPaginaJList;
    private javax.swing.JLabel marcoPaginaLabel;
    private javax.swing.JScrollPane marcoPaginaScrollPanel;
    private javax.swing.JTextArea notificacionesJTextArea;
    private javax.swing.JPanel nuevoProcesoPanel;
    private javax.swing.JLabel nuevoProcesoTamanoLabel;
    private javax.swing.JPanel panelNotificaciones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelProcesos;
    private javax.swing.JTextField tamanoNuevoProcesoField;
    private javax.swing.JList<String> terminadoJList;
    private javax.swing.JLabel terminadoLabel;
    private javax.swing.JScrollPane terminadoScrollPanel;
    private javax.swing.JButton terminarProcesoButton;
    private javax.swing.JLabel terminarProcesoIdLabel;
    private javax.swing.JPanel terminarProcesoPanel;
    // End of variables declaration//GEN-END:variables
}
