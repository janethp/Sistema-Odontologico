/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;


import static frames.consultahistoria.tblcitas;
import static frames.consultahistoria.txtcedula;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import frames.registro;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.commons.codec.digest.DigestUtils;



/**
 *
 * @author yanet
 */
public class consulta extends javax.swing.JFrame {
DefaultTableModel modelo;
String atributo;

conexionDB con = new conexionDB();
Connection cn = con.conexion();


    /**
     * Creates new form consulta
     */
    public consulta() {
        initComponents();
        cargartablapacientes("");
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Consulta");
    }

    void cargartablapacientes(String valor){
        String[] titulos = {"Cedula", "Nombre", "Apellido", "Edad", "Direccion"};
         String[] registro = new String[5];
         modelo = new DefaultTableModel(null, titulos);
     
          String sSQL = "";
          if(valor.equals("")){
               sSQL = "SELECT * FROM pacientes";
          }else{
               sSQL = "SELECT * FROM pacientes WHERE "+atributo+" LIKE '%"+valor+"%'";
               
         
          }

              try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(sSQL);
        
        
        while(rs.next()){
            
            registro[0] = rs.getString("cedula");
            registro[1] = rs.getString("nombre");
            registro[2] = rs.getString("apellido");
            registro[3] = rs.getString("edad");
            registro[4] = rs.getString("direccion");
            modelo.addRow(registro);
        }
        
        tblconsulta.setModel(modelo);    
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex);
    } 
       
   
    }
      String cedula_actualizar = "";
    void BuscarpacienteEditar(String cedula){
          String sSQL = "";
         String nom = "", na = "", ape = "", edad = "", sexo= "", estado = "", direc = "", tlf="";
               sSQL = "SELECT * FROM pacientes WHERE cedula=" + cedula;
         
       try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(sSQL);
        
        while(rs.next()){
            
            //registro[0] = rs.getString("cedula");
            nom = rs.getString("nombre");
            na = rs.getString("nacionalidad");
            ape = rs.getString("apellido");
            edad = rs.getString("edad");
            sexo = rs.getString("sexo");
            estado = rs.getString("estado_civil");
            direc = rs.getString("direccion");
            tlf = rs.getString("telefono");
            
        }
         modificarhistoria.txtdireccion.setText(direc);
         modificarhistoria.txttelefono.setText(tlf);
        // modificarhistoria.
         modificarhistoria.estado.setSelectedItem(estado);
         modificarhistoria.nacio.setSelectedItem(na);
         //modificarhistoria.getSelectedItem(edad);
        modificarhistoria.cedula_actualizar = cedula;
       
        
        String s = "Masculino"; 
        String femini= "Femenino";
        
        if(sexo.equals(s)){
            modificarhistoria.m.setSelected(true);
        }else if(sexo.equals(femini)){
            modificarhistoria.f.setSelected(true);
        }   
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex);
    }  
          String SQL = "";
         String mot = "", ante = "", histo = "", exa = "", fecha = "";
               SQL = "SELECT * FROM historia WHERE cedula=" + cedula;
         
       try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(SQL);
        
        while(rs.next()){
            
            //registro[0] = rs.getString("cedula");
            fecha = rs.getString("fecha");
            mot = rs.getString("motivo");
            ante = rs.getString("antecedentes_medicos");
            histo = rs.getString("historia_dental");
            exa = rs.getString("examen_clinico");
            
            
        }
          modificarhistoria.txtconsulta.setText(mot);
          modificarhistoria.txtfecha.setText(fecha);
         modificarhistoria.txtantecedentes.setText(ante);
         modificarhistoria.txthistoria.setText(histo);
         modificarhistoria.txtexamen.setText(exa);
         modificarhistoria.txtdireccion.setText(direc);
         modificarhistoria.txttelefono.setText(tlf);
          
         cedula_actualizar = cedula;
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex);
    } 
       
       
    }
    void captura(){
         int filase = tblconsulta.getSelectedRow();
        try{
            String cedula, nombre, ape, edad, direccion;
            if(filase == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar un Paciente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }else{
                modelo = (DefaultTableModel) tblconsulta.getModel();
                cedula =  tblconsulta.getValueAt(filase, 0).toString();
                nombre = tblconsulta.getValueAt(filase, 1).toString();
                ape = tblconsulta.getValueAt(filase, 2).toString();
                edad = tblconsulta.getValueAt(filase, 3).toString();
                direccion = tblconsulta.getValueAt(filase, 4).toString();
                
              
                new modificarhistoria().setVisible(true);
                modificarhistoria.txtcedula.setText(cedula);
                modificarhistoria.txtnombre.setText(nombre);
                modificarhistoria.txtapellido.setText(ape);
                modificarhistoria.txtedad.setText(edad);            
                //this.setVisible(false);
                BuscarpacienteEditar(cedula);
         
                
                
        }
        }
        catch (Exception e) {
            //registro.action = "Ver";
        }
    }
    String c_actualizar= "";
   public void consultaVer(String cedula){
          String sSQL = "";
         String nom = "", na ="", ape = "", edad = "", sexo="", direc = "", estado= "", tlf="";
               sSQL = "SELECT * FROM pacientes WHERE cedula=" + cedula;
         
       try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(sSQL);
        
        while(rs.next()){
            //registro[0] = rs.getString("cedula");
            nom = rs.getString("nombre");
            na = rs.getString("nacionalidad");
            ape = rs.getString("apellido");
            edad = rs.getString("edad");
            sexo = rs.getString("sexo");
            estado = rs.getString("estado_civil");
            direc = rs.getString("direccion");
            tlf = rs.getString("telefono");
        }
         consultahistoria.txtdireccion.setText(direc);
         consultahistoria.txttelefono.setText(tlf);
         consultahistoria.txtsexo.setText(sexo);
         consultahistoria.txtestado.setText(estado);
         consultahistoria.txtnacio.setText(na);
         //modificarhistoria.getSelectedItem(edad);
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex);
    }  
          String SQL = "";
         String mot = "", ante = "", histo = "", exa = "", fecha = "", num = "";
               SQL = "SELECT * FROM historia WHERE cedula=" + cedula;
       try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(SQL);
        
        while(rs.next()){
            //registro[0] = rs.getString("cedula");
            num = rs.getString("N_historia");
            fecha = rs.getString("fecha");
            mot = rs.getString("motivo");
            ante = rs.getString("antecedentes_medicos");
            histo = rs.getString("historia_dental");
            exa = rs.getString("examen_clinico");
        }
          consultahistoria.txtnum.setText(num);
          consultahistoria.txtconsulta.setText(mot);
          consultahistoria.txtfecha.setText(fecha);
          consultahistoria.txtantecedentes.setText(ante);
          consultahistoria.txthistoria.setText(histo);
          consultahistoria.txtexamen.setText(exa);
          consultahistoria.txtdireccion.setText(direc);
          consultahistoria.txttelefono.setText(tlf);
         
         cedula_actualizar = cedula;
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex);
    } 
    }
   
   
    void cargarCitas(String cedula){
        
         String[] titulos = {"Cedula", "Fecha", "hora", "tratamiento"};
         String[] registro = new String[4];
         modelo = new DefaultTableModel(null, titulos);
     
          String sSQL = "";
         
               sSQL = "SELECT * FROM citas WHERE cedula="+cedula;
         
       try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(sSQL);
        
        while(rs.next()){
            
            registro[0] = rs.getString("cedula");
            registro[1] = rs.getString("fecha");
            registro[2] = rs.getString("hora");
            registro[3] = rs.getString("tratamiento");
            //registro[4] = rs.getString("direccion");
            modelo.addRow(registro);
        }
        
        tblcitas.setModel(modelo);    
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex);
    }    
    }
   
   
   
    public void Ver(){
             int filase = tblconsulta.getSelectedRow();

        try{
            String cedula, nombre, ape, edad, direccion;
            if(filase == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar un Paciente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }else{
                modelo = (DefaultTableModel) tblconsulta.getModel();
                cedula = tblconsulta.getValueAt(filase, 0).toString();
                nombre = tblconsulta.getValueAt(filase, 1).toString();
                ape = tblconsulta.getValueAt(filase, 2).toString();
                edad = tblconsulta.getValueAt(filase, 3).toString();
                direccion = tblconsulta.getValueAt(filase, 4).toString();
 
                new consultahistoria().setVisible(true);
                consultahistoria.txtcedula.setText(cedula);
                consultahistoria.txtnombre.setText(nombre);
                consultahistoria.txtapellido.setText(ape);
                consultahistoria.txtedad.setText(edad);
                consultahistoria.txtcicitas.setText(cedula);
                //consultahistoria.txtdireccion.setText(direccion);
               // this.setVisible(false);
               consultaVer(cedula);
               cargarCitas(cedula);
               
            }  
        }
        catch (Exception e) {
            //registro.action = "Ver";
        }
    }
    
    void Eliminar(String cedula){
        String sSQL = "";
         String nom = "", ape = "", edad = "", direc = "", tlf="";
            
       try {
           sSQL = "DELETE FROM pacientes WHERE cedula="+ cedula;
        PreparedStatement pps = cn.prepareStatement(sSQL);
        pps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Se Han eliminado con exitos");
        cargartablapacientes("");
        
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex);
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

        grupoconsulta = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnModificar = new javax.swing.JMenuItem();
        mnVer = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblconsulta = new javax.swing.JTable();
        cedula = new javax.swing.JRadioButton();
        apellido = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        mnModificar.setText("Modificar");
        mnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnModificar);

        mnVer.setText("ver");
        mnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVerActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnVer);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 51, 125));

        jPanel2.setBackground(new java.awt.Color(78, 131, 173));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(247, 237, 237))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(245, 231, 231));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 238, 238));
        jLabel1.setText("Buscar");

        btnbuscar.setForeground(new java.awt.Color(254, 254, 254));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search2.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbuscar.setIconTextGap(-5);
        btnbuscar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnbuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Pacientes"));

        tblconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblconsulta.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tblconsulta);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        cedula.setBackground(new java.awt.Color(254, 254, 254));
        grupoconsulta.add(cedula);
        cedula.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        cedula.setForeground(new java.awt.Color(244, 236, 236));
        cedula.setText("Cédula");

        grupoconsulta.add(apellido);
        apellido.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        apellido.setForeground(new java.awt.Color(248, 236, 236));
        apellido.setText("Apellido");

        jButton1.setForeground(new java.awt.Color(253, 251, 251));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/consulgene.png"))); // NOI18N
        jButton1.setText("General");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDoubleBuffered(true);
        jButton1.setFocusCycleRoot(true);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(-5);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Tipo de Búsqueda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40)
                                .addComponent(cedula)
                                .addGap(58, 58, 58)
                                .addComponent(apellido)
                                .addGap(133, 133, 133)))
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(apellido)
                                .addComponent(cedula)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jPanel4.setBackground(new java.awt.Color(234, 239, 242));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1466449409_Application.png"))); // NOI18N
        btnModificar.setText("Modificar ");
        btnModificar.setContentAreaFilled(false);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setDoubleBuffered(true);
        btnModificar.setFocusCycleRoot(true);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setIconTextGap(-1);
        btnModificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1466449365_PatientData.png"))); // NOI18N
        btnver.setText("Ver Historia");
        btnver.setContentAreaFilled(false);
        btnver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnver.setDoubleBuffered(true);
        btnver.setFocusCycleRoot(true);
        btnver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnver.setIconTextGap(-10);
        btnver.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cropped-happy_tooth3.jpg"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1466451542_delete_unapprove_discard_remove_x_red.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.setContentAreaFilled(false);
        jButton3.setDoubleBuffered(true);
        jButton3.setFocusCycleRoot(true);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setIconTextGap(5);
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1466454184_free-27.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setContentAreaFilled(false);
        btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnver, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jMenu1.setText("Reportes");

        jMenuItem1.setText("Reportes de Pacientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
     // String valor = txtbuscar.getText();
     // cargartablapacientes(valor);
      String men;
       men = txtbuscar.getText();
       grupoconsulta.add(cedula);
      grupoconsulta.add(apellido);
      
      if(cedula.isSelected()){
         atributo = "cedula"; cargartablapacientes(txtbuscar.getText());
      }
      else if(apellido.isSelected()){
         atributo = "apellido"; cargartablapacientes(txtbuscar.getText());
      }
      else if(men.isEmpty()){
          JOptionPane.showMessageDialog(null, "Escribe en el campo busqueda", "Error", JOptionPane.WARNING_MESSAGE);
              } //if (!apellido.isSelected() || !cedula.isSelected())
      else
      { JOptionPane.showMessageDialog(null, "Seleccione un tipo de busqueda");}
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       cargartablapacientes("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnModificarActionPerformed
        captura();
    }//GEN-LAST:event_mnModificarActionPerformed

    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
            Ver();
    }//GEN-LAST:event_btnverActionPerformed

    private void mnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVerActionPerformed
            Ver();
    }//GEN-LAST:event_mnVerActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
     int filase = tblconsulta.getSelectedRow();

     try{
            String cedula, nombre, ape, edad, direccion;
        if(filase == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar un Paciente", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{ 
           
                int valor = JOptionPane.showConfirmDialog(this, "¿Esta Seguro eliminar el paciente?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (valor == JOptionPane.YES_NO_OPTION){
                      JPasswordField pf = new JPasswordField(); 
                int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (okCxl == JOptionPane.OK_OPTION) { 
                        String password = new String(pf.getPassword()); 
                             String cap = "", cap1= "";
                            int id;
                            String encriptado = DigestUtils.md5Hex(password);
                             
                             String sql= "";
                             
                             
                             sql = "SELECT * FROM administrador WHERE clave='"+encriptado+"'"; 
    
                                try {
                                     Statement st = cn.createStatement();
                                     ResultSet rs = st.executeQuery(sql);

                                            while(rs.next()){
                                                id= rs.getInt("id_usuario");
                                                cap= rs.getString("usuario"); 
                                                cap1= rs.getString("clave"); 
                                            }

                                    if (cap1.equals(encriptado)){
        
                                           modelo = (DefaultTableModel) tblconsulta.getModel();
                                            cedula = tblconsulta.getValueAt(filase, 0).toString();
                                           nombre = tblconsulta.getValueAt(filase, 1).toString();
                                           ape = tblconsulta.getValueAt(filase, 2).toString();
                                           edad = tblconsulta.getValueAt(filase, 3).toString();
                                           direccion = tblconsulta.getValueAt(filase, 4).toString();
                                          
              
                                           Eliminar(cedula);
                                           
                                            
                                    }else{
                                      JOptionPane.showMessageDialog(null, "Clave Invalida", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    
                                    }
                                        } catch (SQLException ex) {
                                      JOptionPane.showMessageDialog(null, ex);;
                                        }
                                                 //System.err.println("You entered: " + password);
                    } 
                                             //System.exit(0);
                }
            } 
        }
        catch (Exception e) {
            //registro.action = "Ver";
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        captura();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    try {
         /**
        JasperReport reporte = JasperCompileManager.compileReport("report1.jrxml");
        JasperPrint print = JasperFillManager.fillReport(reporte, null, this.cn);
        JasperViewer jv = new JasperViewer(print, false);
        jv.show();
        JasperViewer.viewReport(print);
    */
        JasperReport reporte = (JasperReport) JRLoader.loadObject(consulta.class.getResource("/Reportes/report1.jasper"));
        //Map parametro = new HashMap();
        //parametro.put("fecha", fecha);
        JasperPrint jprint = JasperFillManager.fillReport(reporte, null, this.cn);
        JasperViewer jv = new JasperViewer(jprint, false);
        jv.show();
        
    
    } catch (JRException ex) {
        Logger.getLogger(consulta.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton apellido;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnver;
    private javax.swing.JRadioButton cedula;
    private javax.swing.ButtonGroup grupoconsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnModificar;
    private javax.swing.JMenuItem mnVer;
    private javax.swing.JTable tblconsulta;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

   
}
 
