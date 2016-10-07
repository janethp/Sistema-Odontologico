/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import static frames.citasp.txtcedulacita;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat; 
import java.util.Date; 


/**
 *
 * @author yanet
 */
public class registro extends javax.swing.JFrame {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    //DateFormat df = DateFormat.getDateInstance();
    conexionDB con = new conexionDB();
    Connection cn = con.conexion();
    /**
     * Creates new form registro
     */
    public registro() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Historia Medica");
        this.setVisible(false);
        estado.addItem("Soltero");
        estado.addItem("Divorciado");
        estado.addItem("Casado");
        inhabilitar();
        txtfecha.setText(FechaActual());
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
        nacio.addItem("V");
        nacio.addItem("E");
        
        
         JDateChooser chooser = new JDateChooser();
         JTextFieldDateEditor editor = (JTextFieldDateEditor) calendarFecha.getDateEditor(); 
         editor.setEditable(false);
    }

    private registro(JTabbedPane panelRegistro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       void habilitar(){
        txtfecha.setEnabled(true); 
        txtfecha.setEditable(false);
       
        txtcedula.setEnabled(true);
        nacio.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtedad.setEnabled(true);
        f.setEnabled(true);
        m.setEnabled(true);
        estado.setEnabled(true);
        txtdireccion.setEnabled(true);
        txttelefono.setEnabled(true);
        txtconsulta.setEnabled(true);
        //txtnum.setEnabled(true);
        txtantecedentes.setEnabled(true);
        txthistoria.setEnabled(true);
        txtexamen.setEnabled(true);
        txtcedula.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtedad.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtantecedentes.setText("");
        txthistoria.setText("");
        txtexamen.setText("");
         txtconsulta.setText("");;
        btnguardar.setEnabled(true);
        btnodontodiagrama.setEnabled(true);
        panelRegistro.setEnabled(true);
        
        txtcedula.setEditable(true);
        txtnombre.setEditable(true);
        txtapellido.setEditable(true);
        txtedad.setEditable(true);
        txttelefono.setEditable(true);
        txtconsulta.setEditable(true);
        txtdireccion.setEditable(true);
        
        txtantecedentes.setEditable(true);
        txthistoria.setEditable(true);
        txtexamen.setEditable(true);
        txtcedulacita.setEditable(true);
        txtpaciente.setEditable(true);
        txthora.setEditable(true);
        txttratamiento.setEditable(true);
        //calendarFecha.setEditable(false);
        btnguardar.setEnabled(true);
         btnguardar2.setEnabled(true);
        txtcedulacita.setEnabled(true);
        txtpaciente.setEnabled(true);
        txthora.setEnabled(true);
        txttratamiento.setEnabled(true);
      
        txtcedulacita.setText("");
        txtpaciente.setText("");
       calendarFecha.setDate(null);
        txttratamiento.setText("");
       
        }
   
    void inhabilitar(){
      txtfecha.setEnabled(false);
      nacio.setEnabled(false);
        txtcedula.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        txtedad.setEnabled(false);
        f.setEnabled(false);
        m.setEnabled(false);
        estado.setEnabled(false);
        txtdireccion.setEnabled(false);
        txttelefono.setEnabled(false);
        txtconsulta.setEnabled(false);
        //txtnum.setEnabled(false);
        txtantecedentes.setEnabled(false);
        txthistoria.setEnabled(false);
        txtexamen.setEnabled(false);
        txtcedula.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtedad.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
         txtconsulta.setText("");
        //txtnum.setText("");
        txtantecedentes.setText("");
        txthistoria.setText("");
        txtexamen.setText("");
        btnguardar.setEnabled(false);
        btnodontodiagrama.setEnabled(false);
        //odontodiagrama.setEnabled(false);
        panelRegistro.setEnabledAt(1, false);
      //  btncancelar.setEnabled(false);
        txtcedulacita.setEnabled(false);
        txtpaciente.setEnabled(false);
        txthora.setEnabled(false);
        txttratamiento.setEnabled(false);
      
        txtcedulacita.setText("");
        txtpaciente.setText("");
       calendarFecha.setDate(null);
        txttratamiento.setText("");
    }

     public static String FechaActual(){ 
           
        Date fecha = new Date(); 
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
          return formato.format(fecha);    
}

       void Editar(){
        panelRegistro.setEnabledAt(0, true);
        txtcedula.setEditable(false);
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txtedad.setEditable(false);
        txttelefono.setEditable(false);
        txtconsulta.setEditable(false);
        txtdireccion.setEditable(false);
        f.setEnabled(false);
        m.setEnabled(false);
        txtfecha.setEditable(false);
        txtantecedentes.setEditable(false);
        txthistoria.setEditable(false);
        txtexamen.setEditable(false);
        txtcedulacita.setEditable(false);
        txtpaciente.setEditable(false);
        //calendarFecha.setEditable(false);
        btnguardar.setEnabled(false);
}
       
       void Editar2(){
        txthora.setEditable(false);
        txttratamiento.setEditable(false);
        btnguardar2.setEnabled(false);
       }
      
       funcion c = new funcion();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gruposexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelRegistro = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtantecedentes = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txthistoria = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtexamen = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        f = new javax.swing.JRadioButton();
        m = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtconsulta = new javax.swing.JTextField();
        nacio = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnodontodiagrama = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txttratamiento = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtpaciente = new javax.swing.JTextField();
        calendarFecha = new com.toedter.calendar.JDateChooser();
        txtcedulacita = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txthora = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnguardar2 = new javax.swing.JButton();
        btnnuevo2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 51, 125));
        jPanel1.setAutoscrolls(true);

        jPanel6.setBackground(new java.awt.Color(78, 131, 173));

        jPanel7.setBackground(new java.awt.Color(234, 239, 242));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historia Médica", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel6.setText("*Antecedentes Médicos");

        txtantecedentes.setColumns(20);
        txtantecedentes.setRows(5);
        txtantecedentes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtantecedentesKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(txtantecedentes);

        jLabel7.setText("Historia Dental");

        txthistoria.setColumns(20);
        txthistoria.setRows(5);
        txthistoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthistoriaKeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(txthistoria);

        jLabel8.setText("Examen Clínico");

        txtexamen.setColumns(20);
        txtexamen.setRows(5);
        txtexamen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtexamenKeyTyped(evt);
            }
        });
        jScrollPane7.setViewportView(txtexamen);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel8.setBackground(new java.awt.Color(234, 239, 242));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Paciente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel19.setText("*Apellido");

        jLabel20.setText("*Cédula");

        jLabel21.setText("*Edad");

        jLabel22.setText("*Nombre");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });
        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        txtedad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtedadFocusLost(evt);
            }
        });
        txtedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtedadActionPerformed(evt);
            }
        });
        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
            }
        });

        jLabel23.setText("Sexo");

        gruposexo.add(f);
        f.setText("Femenino");
        f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fMouseClicked(evt);
            }
        });
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });

        gruposexo.add(m);
        m.setText("Masculino");
        m.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mMouseClicked(evt);
            }
        });
        m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mActionPerformed(evt);
            }
        });

        jLabel24.setText("Fecha");

        jLabel25.setText("Estado Cívil");

        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });

        jLabel26.setText("*Dirección");

        txtdireccion.setColumns(20);
        txtdireccion.setRows(5);
        txtdireccion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtdireccionAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });
        jScrollPane8.setViewportView(txtdireccion);

        jLabel27.setText("Teléfono");

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel3.setText("*Motivo de la Consulta");

        txtconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconsultaActionPerformed(evt);
            }
        });
        txtconsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtconsultaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(txtedad)
                                                .addGap(53, 53, 53))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(nacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(f)
                                                .addGap(26, 26, 26)
                                                .addComponent(m))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane8))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                                        .addGap(46, 46, 46)
                                                        .addComponent(jLabel24)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtconsulta)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nacio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f)
                    .addComponent(m))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/odontologia.jpg"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/diente.png"))); // NOI18N

        btnodontodiagrama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/odontodiagrama.png"))); // NOI18N
        btnodontodiagrama.setText("ODONTODIAGRAMA");
        btnodontodiagrama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnodontodiagrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnodontodiagramaActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(246, 242, 242));
        jLabel4.setText("Guardar");

        jLabel9.setForeground(new java.awt.Color(249, 247, 247));
        jLabel9.setText("Cancelar");

        jLabel10.setForeground(new java.awt.Color(246, 242, 242));
        jLabel10.setText("Nuevo");

        jPanel5.setBackground(new java.awt.Color(234, 239, 242));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Herramientas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevo.png"))); // NOI18N
        btnnuevo.setBorderPainted(false);
        btnnuevo.setContentAreaFilled(false);
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save (1).png"))); // NOI18N
        btnguardar.setBorder(null);
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setIconTextGap(-3);
        btnguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Remove.png"))); // NOI18N
        btncancelar.setBorder(null);
        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.setHideActionText(true);
        btncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancelar.setIconTextGap(-3);
        btncancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btncancelar)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel2)))
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(btnodontodiagrama, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jLabel10)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnodontodiagrama, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 54, Short.MAX_VALUE))
        );

        panelRegistro.addTab("Registro", jPanel6);

        jPanel10.setBackground(new java.awt.Color(78, 131, 173));

        jPanel2.setBackground(new java.awt.Color(234, 239, 242));

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(112, 94, 94));
        jLabel11.setText("Control de Citas ");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reloj1.png"))); // NOI18N

        jPanel13.setBackground(new java.awt.Color(234, 239, 242));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Cita Control"));

        txttratamiento.setColumns(20);
        txttratamiento.setRows(5);
        txttratamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttratamientoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txttratamiento);

        jLabel17.setText("Tratamiento");

        jLabel18.setText("Fecha");

        jLabel28.setText("Hora");

        jLabel29.setText("Paciente");

        jLabel30.setText("Cédula");

        txthora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel28)
                    .addComponent(jLabel18)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtcedulacita, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(calendarFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addComponent(txtpaciente, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcedulacita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel18))
                    .addComponent(calendarFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(23, 23, 23))
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/odontologia_esteticaedit.jpg"))); // NOI18N

        btnguardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save (1).png"))); // NOI18N
        btnguardar2.setText("Registrar");
        btnguardar2.setBorder(null);
        btnguardar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar2.setInheritsPopupMenu(true);
        btnguardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar2ActionPerformed(evt);
            }
        });

        btnnuevo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevo.png"))); // NOI18N
        btnnuevo2.setText("Limpiar");
        btnnuevo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(jLabel11)
                .addGap(37, 37, 37)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel13)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnnuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(btnguardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(427, 427, 427))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(130, 199, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115))))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRegistro.addTab("Control de Citas", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRegistro)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        Archivo.setText("Archivo");
        Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArchivoActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Nueva Historia");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Archivo.add(jMenuItem1);

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Archivo.add(jMenuItem3);

        jMenuBar1.add(Archivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoActionPerformed

    private void btnodontodiagramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnodontodiagramaActionPerformed
      //String ci, nom, ape, edad, sexo, civil, direc, telf, fecha, motivo, num, ante, histo, examen;
      // String sql = ""; 
       //String mensaje = "";
       //ci = txtcedula.getText();
       //nom = txtnombre.getText();
      // ape = txtapellido.getText();
       //motivo = txtconsulta.getText();
      //if(ci.isEmpty()){
     //     JOptionPane.showMessageDialog(null, "Debe llenar campo Cédula Obligatorio", "Error", JOptionPane.WARNING_MESSAGE);
      //}else if(nom.equals("") || ape.equals("") || motivo.equals("")){
       //    JOptionPane.showMessageDialog(null, "Debe LLenar los campos Obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
      // }else {
     // panelRegistro.setEnabledAt(1, true);
     // panelRegistro.setSelectedIndex(1);
     // String dato;
     //   dato= txtcedula.getText();
      //  nom = txtnombre.getText();
      //  motivo= txtconsulta.getText();
       // registro.txtodoncedula.setText(dato);
       // registro.txtodonnom.setText(nom);
       // registro.txtodonmotivo.setText(motivo);
      
      //registro.txtcedulacita.setText(dato);
      //registro.txtpaciente.setText(nom);
     // }       
    }//GEN-LAST:event_btnodontodiagramaActionPerformed
    String accion = "Insertar";
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
       conexionDB mysql = new conexionDB();
       Connection cn = mysql.conexion();
       String ci, na, nom, ape, edad, sexo, civil, direc, telf, fecha, motivo, num, ante, histo, examen;
       String sql = ""; 
       String mensaje = "";
       ci = txtcedula.getText();
       nom = txtnombre.getText();
       ape = txtapellido.getText();
       edad = txtedad.getText();
       na = nacio.getSelectedItem().toString();
      // sexo = gruposexo.getSelection();
       sexo = c.sexo;
     //sexo = gruposexo.getSelectedChecked().toString();
       civil = estado.getSelectedItem().toString();
       direc = txtdireccion.getText();
       telf = txttelefono.getText();
       fecha = txtfecha.getText();
       motivo = txtconsulta.getText();
       //num = txtnum.getText();
       ante = txtantecedentes.getText();
       histo = txthistoria.getText();
       examen = txtexamen.getText();
      
      if(ci.isEmpty()){
          JOptionPane.showMessageDialog(null, "Debe llenar campo Cédula Obligatorio", "Error", JOptionPane.WARNING_MESSAGE);
      }else if(nom.equals("") || ape.equals("") || edad.equals("") || direc.equals("") || motivo.equals("") || ante.equals("") || na.isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe LLenar los campos Obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
       }else if(edad.equals("0") || edad.equals("00")){
            JOptionPane.showMessageDialog(null, "No puede ingresar cero 0", "Error", JOptionPane.ERROR_MESSAGE);
       }
       else{
           if(JOptionPane.showConfirmDialog(null, "Desea Guardar los Datos", "Confirmar", 1)==0){
       sql = "INSERT INTO pacientes(cedula,nacionalidad,nombre,apellido,edad,sexo,estado_civil,direccion,telefono) VALUES (?,?,?,?,?,?,?,?,?)";
       mensaje = "Los Datos se han registrado correctamente";
      
         try {
       PreparedStatement pps = cn.prepareStatement(sql);
       pps.setString(1, ci);
       pps.setString(2, na);
       pps.setString(3, nom);
       pps.setString(4, ape);
       pps.setString(5, edad);
       pps.setString(6, sexo);
       pps.setString(7, civil);
       pps.setString(8, direc);
       pps.setString(9, telf);
       int n = pps.executeUpdate();
        if (n > 0){ 
                JOptionPane.showMessageDialog(null, mensaje);
               // inhabilitar(); 
                
        }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al Guardar, campo cédula repetido ó conexión", "Error", JOptionPane.ERROR_MESSAGE);
        }
         
         sql = "INSERT INTO historia(cedula,fecha,motivo,antecedentes_medicos,historia_dental,examen_clinico) VALUES (?,?,?,?,?,?)";
         try {
       PreparedStatement pps = cn.prepareStatement(sql);
       pps.setString(1, ci);
       pps.setString(2, fecha);
       pps.setString(3, motivo);
       pps.setString(4, ante);
       pps.setString(5, histo);
       pps.setString(6, examen);
       int n = pps.executeUpdate();
        if (n > 0){     
              //  JOptionPane.showMessageDialog(null, mensaje);
                // inhabilitar();
        }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al Guardar, campo cédula repetido ó conexión", "Error", JOptionPane.ERROR_MESSAGE);
           //dispose();
        }
        panelRegistro.setSelectedIndex(1);
        panelRegistro.setEnabledAt(1, true);
        String dato;
        dato= txtcedula.getText();
        nom = txtnombre.getText();
        motivo= txtconsulta.getText();
        Editar();
        //registro.txtodoncedula.setText(dato);
        //registro.txtodonnom.setText(nom);
        //registro.txtodonmotivo.setText(motivo);
        txtcedulacita.setText(dato);
        txtpaciente.setText(nom);
       }
       }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        habilitar();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
       inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
       txtcedula.transferFocus();
    }//GEN-LAST:event_txtcedulaActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
       txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
       txtapellido.transferFocus();
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void txtedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtedadActionPerformed
      txtedad.transferFocus();
    }//GEN-LAST:event_txtedadActionPerformed

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
      f.transferFocus();
    }//GEN-LAST:event_fActionPerformed

    private void mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mActionPerformed
       m.transferFocus();
    }//GEN-LAST:event_mActionPerformed

    private void txtdireccionAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtdireccionAncestorAdded
      txtdireccion.transferFocus();
    }//GEN-LAST:event_txtdireccionAncestorAdded

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        txttelefono.transferFocus();
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconsultaActionPerformed
        txtconsulta.transferFocus();
    }//GEN-LAST:event_txtconsultaActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
       char c = evt.getKeyChar();
       
        if(c<'0' || c> '9') evt.consume();
        
        int n= 10;
         if(txtcedula.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 10 caracteres");
       }
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
      char c = evt.getKeyChar();
       
        if((c<'a' || c> 'z') && (c<'A')|c>'Z') evt.consume();
        
          int n= 20;
         if(txtnombre.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 20 caracteres");
       }
        
        
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
          char c = evt.getKeyChar();
       
        if((c<'a' || c> 'z') && (c<'A')|c>'Z') evt.consume();
        
          int n= 20;
         if(txtapellido.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 20 caracteres");
       }
        
        
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txtedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedadKeyTyped
        char c = evt.getKeyChar();
       
        if(c<'0' || c> '9') evt.consume();
        
        
       int n = 2;
       if(txtedad.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 2 caracteres");
       }
 
  
       
       
    }//GEN-LAST:event_txtedadKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char c = evt.getKeyChar();
       
        if(c<'0' || c> '9') evt.consume();
        
          int n= 11;
         if(txttelefono.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 11 caracteres");
       }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void btnnuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo2ActionPerformed
        // TODO add your handling code here:
       
       
       txttratamiento.setText("");
        txthora.setEditable(true);
       txttratamiento.setEditable(true);
       btnguardar2.setEnabled(true);
    }//GEN-LAST:event_btnnuevo2ActionPerformed

    private void btnguardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar2ActionPerformed

       String ci, pa, hora, trata, fecha;
       String sql = ""; 
       String mensaje = "";
       ci = txtcedulacita.getText();
       pa = txtpaciente.getText();
       hora = txthora.getSelectedItem().toString();
       trata = txttratamiento.getText();
     
      if(ci.isEmpty()){
          JOptionPane.showMessageDialog(null, "Debe llenar campo Cédula Obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
      }else if(pa.equals("")  || trata.equals("")){
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
      
     // Editar2();
      
    }//GEN-LAST:event_btnguardar2ActionPerformed

    private void fMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fMouseClicked
        String fe= "F";
        c.getsexo(f.getLabel());
    }//GEN-LAST:event_fMouseClicked

    private void mMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mMouseClicked
        String M= "M";
        c.getsexo(m.getLabel());
    }//GEN-LAST:event_mMouseClicked

    private void txthoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoraActionPerformed
        String hora = txthora.getSelectedItem().toString();

    }//GEN-LAST:event_txthoraActionPerformed

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped

      
        
          int n= 100;
         if(txtdireccion.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 11 caracteres");
       }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtconsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconsultaKeyTyped
       
         int n=50;
         if(txtconsulta.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 50 caracteres");
       }
    }//GEN-LAST:event_txtconsultaKeyTyped

    private void txtantecedentesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtantecedentesKeyTyped
         int n=200;
         if(txtantecedentes.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 200 caracteres");
       }
    }//GEN-LAST:event_txtantecedentesKeyTyped

    private void txthistoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthistoriaKeyTyped
        int n=140;
         if(txthistoria.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 140 caracteres");
       }
    }//GEN-LAST:event_txthistoriaKeyTyped

    private void txtexamenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtexamenKeyTyped
        int n=140;
         if(txtexamen.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 140 caracteres");
       }
    }//GEN-LAST:event_txtexamenKeyTyped

    private void txttratamientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttratamientoKeyTyped

          int n=140;
         if(txttratamiento.getText().length()>=n){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Solo son 140 caracteres");
       }
    }//GEN-LAST:event_txttratamientoKeyTyped

    private void txtedadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtedadFocusLost
           String e = txtedad.getText();
        
           
           
       if(e.equals("0") || e.equals("00")){
            JOptionPane.showMessageDialog(rootPane, "Edad incorrecta, No puede ingresar cero","Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_txtedadFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        habilitar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArchivoActionPerformed
       habilitar();
    }//GEN-LAST:event_ArchivoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivo;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardar2;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnnuevo2;
    private javax.swing.JButton btnodontodiagrama;
    private com.toedter.calendar.JDateChooser calendarFecha;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JRadioButton f;
    public static javax.swing.ButtonGroup gruposexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JRadioButton m;
    private javax.swing.JComboBox<String> nacio;
    private javax.swing.JTabbedPane panelRegistro;
    private javax.swing.JTextArea txtantecedentes;
    public static javax.swing.JTextField txtapellido;
    public static javax.swing.JTextField txtcedula;
    public static javax.swing.JTextField txtcedulacita;
    private javax.swing.JTextField txtconsulta;
    public static javax.swing.JTextArea txtdireccion;
    public static javax.swing.JTextField txtedad;
    private javax.swing.JTextArea txtexamen;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextArea txthistoria;
    private javax.swing.JComboBox<String> txthora;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtpaciente;
    private javax.swing.JTextField txttelefono;
    public static javax.swing.JTextArea txttratamiento;
    // End of variables declaration//GEN-END:variables
}
