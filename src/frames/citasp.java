/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;


import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import frames.registro;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date; 
/**
 *
 * @author yanet
 */
public class citasp extends javax.swing.JFrame {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//DateFormat df = DateFormat.getDateInstance();

DefaultTableModel modelo;
String atributo;

conexionDB con = new conexionDB();
Connection cn = con.conexion();
    /**
     * Creates new form citasp
     */
    public citasp() {
        initComponents();
        cargartablapacientes("");
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Citas");
        inhabilitar();
        txthora.addItem("7:00 am");
        txthora.addItem("8:00 am");
        txthora.addItem("9:00 am");
        txthora.addItem("10:00 am");
        txthora.addItem("11:00 am");
        txthora.addItem("2:00 pm");
        txthora.addItem("3:00 pm");
        txthora.addItem("4:00 pm");
        txthora.addItem("5:00 pm");
        txthora.addItem("6:00 pm");
       
       
        JDateChooser chooser = new JDateChooser();
         JTextFieldDateEditor editor = (JTextFieldDateEditor) calendarFecha.getDateEditor(); 
         editor.setEditable(false);
        
    }
   
    
    
     void fe(){
        Date fech = new Date(); 
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM-yyyy"); 
        String s =  formato.format(fech);
           
                 String fechaObtenida = df.format(calendarFecha.getDate());
            String fecha = fechaObtenida; 
           
       if (s.compareTo(fecha) >= 0 ) {
  JOptionPane.showMessageDialog(null, "La fecha 1 es posterior a la fecha 2");
}      
    }
    
void cargartablapacientes(String valor){
        String[] titulos = {"Cedula", "Nombre", "Apellido", "Edad", "Direccion"};
         String[] registro = new String[5];
         modelo = new DefaultTableModel(null, titulos);
         
          conexionDB con = new conexionDB();
          Connection cn = con.conexion();
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
    void Buscarconsultar(String cedula){
          
          String sSQL = "";
          String nom = "", ape = "", edad = "", direc = "";
         
               sSQL = "SELECT * FROM pacientes WHERE cedula LIKE '%"+cedula+"%'";
               
       try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(sSQL);
        
        while(rs.next()){
           nom = rs.getString("nombre");
           ape = rs.getString("apellido");
           edad = rs.getString("edad");
           direc = rs.getString("direccion");
        }
        
      
        cedula_actualizar = cedula;
        
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex);
    }  
       
    } 
        void habilitar(){
        txtcedulacita.setEnabled(true); 
        txtpaciente.setEnabled(true);
        calendarFecha.setEnabled(true);
        txthora.setEnabled(true);
        txttratamiento.setEnabled(true);
        txtcedulacita.setText("");
        txtpaciente.setText("");
        txthora.setEditable(true);
        txttratamiento.setEditable(true);
        txttratamiento.setText("");
        
        calendarFecha.setDate(null);
        btnguardar.setEnabled(true);
        btnbuscarpaciente.setEnabled(true);
        
        
        
        }
        
        
          void inhabilitar(){
        txtcedulacita.setEnabled(false); 
        txtpaciente.setEnabled(false);
        calendarFecha.setEnabled(false);
        txthora.setEnabled(false);
        txttratamiento.setEnabled(false);
        txtcedulacita.setText("");
        txtpaciente.setText("");
        //calendarFecha.set("");
        //calendarFecha.setText("");
        txttratamiento.setText("");
        btnguardar.setEnabled(false);
        btnbuscarpaciente.setEnabled(false);
        }
          
          
          
          
        void Editar(){
        txtcedulacita.setEditable(false);
        txtpaciente.setEditable(false);
        //calendarFecha.setEditable(false);
           }
     
        void Editar2(){
                 txtcedulacita.setEditable(false);
                  txthora.setEditable(false);
                  txttratamiento.setEditable(false);
                  btnguardar.setEnabled(false);         
            
        } 
        //metodo para consultar date and hours
        void hora(String hora, String fecha){
             String sSQL = "";
          String hours = "", date = "";
         
               sSQL = "SELECT * FROM citas WHERE fecha LIKE '%"+fecha+"%' AND hora LIKE '%"+hora+"%'";
               
       try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(sSQL);
        
        while(rs.next()){
           hours = rs.getString("hora");
           date = rs.getString("fecha");
         
        }
        if (hora.equals(hours) || fecha.equals(date)){
             JOptionPane.showMessageDialog(null, "Esta fecha a esta hora esta ocupada");
        }
        
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

        buscarpaciente = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblconsulta = new javax.swing.JTable();
        cedula = new javax.swing.JRadioButton();
        apellido = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        grupoconsulta = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        brnnuewcitas = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txttratamiento = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpaciente = new javax.swing.JTextField();
        btnbuscarpaciente = new javax.swing.JButton();
        calendarFecha = new com.toedter.calendar.JDateChooser();
        txtcedulacita = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txthora = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(30, 51, 125));

        jPanel5.setBackground(new java.awt.Color(78, 131, 173));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(247, 237, 237))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(245, 231, 231));

        jLabel9.setForeground(new java.awt.Color(254, 238, 238));
        jLabel9.setText("Buscar");

        btnbuscar1.setForeground(new java.awt.Color(253, 251, 251));
        btnbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search2.png"))); // NOI18N
        btnbuscar1.setText("Buscar");
        btnbuscar1.setContentAreaFilled(false);
        btnbuscar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbuscar1.setIconTextGap(-1);
        btnbuscar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnbuscar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar1ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Pacientes"));

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
        jScrollPane2.setViewportView(tblconsulta);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        cedula.setForeground(new java.awt.Color(244, 236, 236));
        cedula.setText("Cedula");

        apellido.setForeground(new java.awt.Color(248, 236, 236));
        apellido.setText("Apellido");

        jButton4.setForeground(new java.awt.Color(254, 254, 254));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/consulgene.png"))); // NOI18N
        jButton4.setText("Mostrar");
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setIconTextGap(-1);
        jButton4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");

        jButton6.setText("Salir");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(cedula)
                                .addGap(83, 83, 83)
                                .addComponent(apellido)
                                .addGap(99, 99, 99)))
                        .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cedula)
                            .addComponent(apellido))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(btnbuscar1))))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout buscarpacienteLayout = new javax.swing.GroupLayout(buscarpaciente.getContentPane());
        buscarpaciente.getContentPane().setLayout(buscarpacienteLayout);
        buscarpacienteLayout.setHorizontalGroup(
            buscarpacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        buscarpacienteLayout.setVerticalGroup(
            buscarpacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(30, 51, 125));

        jPanel2.setBackground(new java.awt.Color(234, 238, 240));

        brnnuewcitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reloj1.png"))); // NOI18N
        brnnuewcitas.setText("Nueva cita");
        brnnuewcitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnnuewcitasActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(234, 239, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cita Control"));

        txttratamiento.setColumns(20);
        txttratamiento.setRows(5);
        jScrollPane1.setViewportView(txttratamiento);

        jLabel1.setText("Tratamiento");

        jLabel2.setText("Fecha");

        jLabel3.setText("Hora");

        jLabel4.setText("Paciente");

        btnbuscarpaciente.setText("Buscar Paciente ");
        btnbuscarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarpacienteActionPerformed(evt);
            }
        });

        calendarFecha.setDateFormatString("dd/MM/yyyy");
        calendarFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calendarFechaKeyTyped(evt);
            }
        });

        jLabel8.setText("Cédula");

        txthora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txthora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcedulacita, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtpaciente, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(34, 34, 34)
                        .addComponent(btnbuscarpaciente)))
                .addGap(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcedulacita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscarpaciente)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addComponent(calendarFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23))
        );

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(112, 94, 94));
        jLabel5.setText("Control de Citas ");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/odontologia_esteticaedit.jpg"))); // NOI18N

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save (1).png"))); // NOI18N
        btnguardar.setText("Registrar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reloj1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(brnnuewcitas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brnnuewcitas)
                    .addComponent(btnguardar))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarpacienteActionPerformed
        buscarpaciente.setVisible(true);
        buscarpaciente.setModal(true);
        buscarpaciente.pack();
        buscarpaciente.setLocationRelativeTo(buscarpaciente);
        buscarpaciente.setResizable(false);
        Editar();
        
    }//GEN-LAST:event_btnbuscarpacienteActionPerformed

    private void btnbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar1ActionPerformed
        // String valor = txtbuscar.getText();
        // cargartablapacientes(valor);
        grupoconsulta.add(cedula);
        grupoconsulta.add(apellido);

        if(cedula.isSelected()){
            atributo = "cedula"; cargartablapacientes(txtbuscar.getText());
        }
        else if(apellido.isSelected()){
            atributo = "apellido"; cargartablapacientes(txtbuscar.getText());
        }
        else { JOptionPane.showMessageDialog(null, "no se h aseleccionada ningun tipo de busqueda");}
    }//GEN-LAST:event_btnbuscar1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cargartablapacientes("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        int filase = tblconsulta.getSelectedRow();

        try{
            String cedula, nombre;
            if(filase == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar un Paciente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txttratamiento.setEditable(true);
            
            }else{
                modelo = (DefaultTableModel) tblconsulta.getModel();
                cedula = tblconsulta.getValueAt(filase, 0).toString();
                nombre = tblconsulta.getValueAt(filase, 1).toString();
                txtcedulacita.setText(cedula);
                txtpaciente.setText(nombre);
                buscarpaciente.setVisible(false);
                txttratamiento.setEditable(true);
            }
        }
        catch (Exception e) {
            //registro.action = "Ver";
        }
        // .setVisible(true);
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        conexionDB mysql = new conexionDB();
       Connection cn = mysql.conexion();
       String ci, pa, hora, trata, fecha;
       String sql = ""; 
       String mensaje = "";
       ci = txtcedulacita.getText();
       pa = txtpaciente.getText();
       
       hora = txthora.getSelectedItem().toString();
       trata = txttratamiento.getText();
     
    
      if(ci.isEmpty()){
          JOptionPane.showMessageDialog(null, "Debe llenar campo Cédula Obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
      }else if(pa.equals("") || hora.equals("") || trata.equals("")){
           JOptionPane.showMessageDialog(null, "Debe LLenar Todos los campos ", "Error", JOptionPane.ERROR_MESSAGE);
       }else if(calendarFecha.getDate()== null){
           JOptionPane.showMessageDialog(null, "Debe LLenar Todos los campos ", "Error", JOptionPane.ERROR_MESSAGE);
       }else if(calendarFecha.isEnabled()){
           
           
           
           Date fech = new Date(); 
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        String s =  formato.format(fech);
        
        
        
         String fechaObtenida = df.format(calendarFecha.getDate());
            fecha = fechaObtenida; 
           
                if (s.compareTo(fecha) >= 0 ) {
                     JOptionPane.showMessageDialog(null, "La Fecha es Incorrecta");
                        }else{
          
             
      fecha = fechaObtenida; 
     // hora(hora, fecha);
      
         String sSQL = "";
         String query = "";
         String hours = "", date = "";
         String h = "", d= "", ced= "";
         sSQL = "SELECT * FROM citas WHERE fecha LIKE '%"+fecha+"%' AND hora LIKE '%"+hora+"%'";
               
         
         query = "SELECT * FROM citas WHERE fecha LIKE '%"+fecha+"%'AND cedula LIKE '%"+ci+"%'";
                             try {
                                    Statement sti = cn.createStatement();
                                     ResultSet rsj =sti.executeQuery(query);
        
                                                 while(rsj.next()){
                                                    ced = rsj.getString("cedula");
                                                    h = rsj.getString("hora");
                                                    d = rsj.getString("fecha");
         
                                                                       }
                                               
                             }
                             
                             
                             catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Error");
            }
         
         
       try {
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(sSQL);
        
        while(rs.next()){
            
           hours = rs.getString("hora");
           date = rs.getString("fecha");
         
        }
        
           
             if (hora.equals(hours) || fecha.equals(date)){
                   int valor;
                    JOptionPane.showMessageDialog(this, "Esta fecha a esta hora esta ocupada");
           
              }else if (fecha.equals(d) || ci.equals(ced)){
                      String SQL = "";
                      String hour = "", dat = "", cii= "";
                      cii = txtcedulacita.getText();
                      sSQL = "SELECT * FROM citas WHERE fecha LIKE '%"+fecha+"%' AND cedula LIKE '%"+cii+"%'";
            
                    JOptionPane.showMessageDialog(null, "Este numero de cedula ya se encuentra registrado en esta fecha");
             }
        
                 else
        
              {
              

       sql = "INSERT INTO citas(cedula,fecha,hora,tratamiento) VALUES (?,?,?,?)";
       mensaje = "Los Datos se han registrado correctamente";
      
         try {
       PreparedStatement pps = cn.prepareStatement(sql);
       pps.setString(1, ci);
       pps.setString(2, fecha);
       pps.setString(3, hora);
       pps.setString(4, trata);
 
        int n = pps.executeUpdate();
        
        if (n > 0){
                
                JOptionPane.showMessageDialog(null, mensaje);
                Editar2();
        }
 
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error no se Registro");
        }
        }
        
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Error no se Registro");
            }  
        }
    }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void brnnuewcitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnnuewcitasActionPerformed
        // TODO add your handling code here:
           habilitar();
    }//GEN-LAST:event_brnnuewcitasActionPerformed

    private void txthoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoraActionPerformed
      String hora = txthora.getSelectedItem().toString();
     
    }//GEN-LAST:event_txthoraActionPerformed

    private void calendarFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calendarFechaKeyTyped
        // TODO add your handling code here:
       
  
      
 
    }//GEN-LAST:event_calendarFechaKeyTyped

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
            java.util.logging.Logger.getLogger(citasp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(citasp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(citasp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(citasp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new citasp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton apellido;
    private javax.swing.JButton brnnuewcitas;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnbuscar1;
    private javax.swing.JButton btnbuscarpaciente;
    private javax.swing.JButton btnguardar;
    private javax.swing.JDialog buscarpaciente;
    private com.toedter.calendar.JDateChooser calendarFecha;
    private javax.swing.JRadioButton cedula;
    private javax.swing.ButtonGroup grupoconsulta;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblconsulta;
    private javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtcedulacita;
    private javax.swing.JComboBox<String> txthora;
    public static javax.swing.JTextField txtpaciente;
    private javax.swing.JTextArea txttratamiento;
    // End of variables declaration//GEN-END:variables
}
