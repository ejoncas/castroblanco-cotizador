
package Vistas;

import Controladores.ListarCotizacionesCONT;
import javax.swing.JOptionPane;


public class ListarCotizaciones extends javax.swing.JInternalFrame
{
    public ListarCotizaciones() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        calendarDesde = new org.freixas.jcalendar.JCalendarCombo();
        jLabel2 = new javax.swing.JLabel();
        calendarHasta = new org.freixas.jcalendar.JCalendarCombo();
        radioPrecio = new javax.swing.JRadioButton();
        radioDistancia = new javax.swing.JRadioButton();
        radioFecha = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listar Cotizaciones");

        jTable1.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Desde");

        calendarDesde.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                calendarDesdeDateChanged(evt);
            }
        });

        jLabel2.setText("Hasta");

        calendarHasta.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                calendarHastaDateChanged(evt);
            }
        });

        radioPrecio.setText("Precio");
        radioPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPrecioActionPerformed(evt);
            }
        });

        radioDistancia.setText("Distancia");
        radioDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDistanciaActionPerformed(evt);
            }
        });

        radioFecha.setText("Fecha");
        radioFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFechaActionPerformed(evt);
            }
        });

        jLabel3.setText("Ordenar Por:");

        jLabel4.setText("Filtrar por Fecha:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/excel_icon.png"))); // NOI18N
        jButton1.setToolTipText("Exportar a MS Excel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioPrecio)
                                .addGap(18, 18, 18)
                                .addComponent(radioDistancia)
                                .addGap(18, 18, 18)
                                .addComponent(radioFecha))
                            .addComponent(jLabel3))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendarDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(calendarHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calendarDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(calendarHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioFecha)
                    .addComponent(radioPrecio)
                    .addComponent(radioDistancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPrecioActionPerformed
        this.radioDistancia.setSelected(false);
        this.radioFecha.setSelected(false);
        this.controlador.ordenarPorPrecio();
    }//GEN-LAST:event_radioPrecioActionPerformed

    private void radioDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDistanciaActionPerformed
        this.radioPrecio.setSelected(false);
        this.radioFecha.setSelected(false);
        this.controlador.ordenarPorDistancia();
    }//GEN-LAST:event_radioDistanciaActionPerformed

    private void radioFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFechaActionPerformed
        this.radioPrecio.setSelected(false);
        this.radioDistancia.setSelected(false);
        this.controlador.ordenarPorFecha();
    }//GEN-LAST:event_radioFechaActionPerformed

    private void calendarDesdeDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_calendarDesdeDateChanged
      System.out.println(this.calendarDesde.getDate()+" selected on calendar DESDE");
      if(this.calendarHasta.getDate().before(this.calendarDesde.getDate())){
          JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha anterior a la del campo Hasta");
          this.calendarDesde.setDate(this.calendarHasta.getDate());
      }
      else
         this.controlador.procesarFiltrosFecha(this.calendarDesde.getDate(), this.calendarHasta.getDate());
    }//GEN-LAST:event_calendarDesdeDateChanged

    private void calendarHastaDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_calendarHastaDateChanged
      System.out.println(this.calendarHasta.getDate()+ " selected on calendar HASTA");
      if(this.calendarDesde.getDate().after(this.calendarHasta.getDate())){
          JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha posterior a la del campo Desde");
          this.calendarHasta.setDate(this.calendarDesde.getDate());
      }
      else
        this.controlador.procesarFiltrosFecha(this.calendarDesde.getDate(), this.calendarHasta.getDate());
    }//GEN-LAST:event_calendarHastaDateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.controlador.exportarExcel();
       JOptionPane.showMessageDialog(null, "El archivo \"export.csv\" ha sido creado correctamente en su directorio de trabajo.");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.freixas.jcalendar.JCalendarCombo calendarDesde;
    private org.freixas.jcalendar.JCalendarCombo calendarHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioDistancia;
    private javax.swing.JRadioButton radioFecha;
    private javax.swing.JRadioButton radioPrecio;
    // End of variables declaration//GEN-END:variables

    private ListarCotizacionesCONT controlador;

    public void setControlador(ListarCotizacionesCONT controller) {
        this.controlador = controller;
    }

    public void setTableModel(CotizacionTableModel ctm) {
        this.jTable1.setModel(ctm);
    }

}
