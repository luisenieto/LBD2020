/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.controladores;

import auxiliares.ManejoDeFechas;
import com.toedter.calendar.JDateChooser;
import empleados.modelos.Empleado;
import empleados.modelos.GestorEmpleados;
import empleados.modelos.ModeloComboEmpleados;
import empleados.vistas.VentanaAMEmpleado;
import interfaces.IControladorAMEmpleado;
import interfaces.IControladorVentanaPrincipal;
import interfaces.IGestorEmpleados;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ControladorAMEmpleado implements IControladorAMEmpleado {    
    private VentanaAMEmpleado ventana;
    private Empleado empleado;

    /**
     * Constructor
     * @param ventanaPadre (VentanaEmpleados en este caso)
     */
    public ControladorAMEmpleado(Dialog ventanaPadre) {
        this(ventanaPadre, null);
    }
    
    /**
     * Constructor
     * @param ventanaPadre (VentanaEmpleados en este caso)
     * @param empleado empleado a modificar
     */    
    public ControladorAMEmpleado(Dialog ventanaPadre, Empleado empleado) {
        this.empleado = empleado;
        this.ventana = new VentanaAMEmpleado(this, ventanaPadre);
        this.ventana.setTitle(this.empleado == null ? TITULO_NUEVO : TITULO_MODIFICAR);
        this.ventana.setLocationRelativeTo(null);
        this.configurarReportaA();
        this.configurarFechaNacimiento();
        this.configurarFechaContratacion();        
        if (this.empleado != null) { //modificación de empleado
            this.ventana.verTxtIdentificador().setText(Integer.toString(this.empleado.verIdEmpleado()));
            this.ventana.verTxtIdentificador().setEditable(false);
            this.ventana.verTxtApellido().setText(this.empleado.verApellido());
            this.ventana.verTxtNombre().setText(this.empleado.verNombre());              
            this.ventana.verTxtTitulo().setText(this.empleado.verTitulo());
            this.ventana.verTxtTituloCortesia().setText(this.empleado.verTituloDeCortesia());            
            this.ventana.verTxtDireccion().setText(this.empleado.verDireccion());
            this.ventana.verTxtCiudad().setText(this.empleado.verCiudad());
            this.ventana.verTxtRegion().setText(this.empleado.verRegion());
            this.ventana.verTxtCodigoPostal().setText(this.empleado.verCodigoPostal());
            this.ventana.verTxtPais().setText(this.empleado.verPais());
            this.ventana.verTxtTelefono().setText(this.empleado.verTelefono());
            this.ventana.verTxtExtension().setText(this.empleado.verExtension());            
            this.ventana.verTxtFoto().setText(this.empleado.verFoto());
            this.ventana.verTxtNotas().setText(this.empleado.verNotas());
        }
        this.ventana.setVisible(true);
    }   
    
    /**
     * Configura el combo "ReportaA"
     */
    private void configurarReportaA() {
        this.ventana.verComboReportaA().setModel(new ModeloComboEmpleados());
        if (this.empleado != null) {
            Integer reportaA = this.empleado.verReportaA();
            if (reportaA != null)
                ((ModeloComboEmpleados)this.ventana.verComboReportaA().getModel()).seleccionarEmpleado(reportaA);            
            else
                this.ventana.verComboReportaA().setSelectedIndex(-1);
        }
        else
            this.ventana.verComboReportaA().setSelectedIndex(-1);
    }
    
    /**
     * Configura el dateChooser fecha de nacimiento
     */
    private void configurarFechaNacimiento() {
        JDateChooser dateChooserFecha = this.ventana.verFechaNacimiento();
        GregorianCalendar fecha;        
        if (this.empleado == null)
            fecha = ManejoDeFechas.transformarLocalDateEnGregorianCalendar(LocalDate.now());
        else
            fecha = ManejoDeFechas.transformarLocalDateEnGregorianCalendar(this.empleado.verFechaNacimiento());
        dateChooserFecha.setCalendar(fecha);
    }
    
    /**
     * Configura el dateChooser fecha de nacimiento
     */
    private void configurarFechaContratacion() {
        JDateChooser dateChooserFecha = this.ventana.verFechaContratacion();
        GregorianCalendar fecha;        
        if (this.empleado == null)
            fecha = ManejoDeFechas.transformarLocalDateEnGregorianCalendar(LocalDate.now());
        else
            fecha = ManejoDeFechas.transformarLocalDateEnGregorianCalendar(this.empleado.verFechaContratacion());
        dateChooserFecha.setCalendar(fecha);
    }    
                                      
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        Integer idEmpleado = this.leerEnteroDeCampoDeTexto(this.ventana.verTxtIdentificador());
        
        String apellido = this.leerTextoDeCampoDeTexto(this.ventana.verTxtApellido());
        
        String nombre = this.leerTextoDeCampoDeTexto(this.ventana.verTxtNombre());
        
        String titulo = this.leerTextoDeCampoDeTexto(this.ventana.verTxtTitulo());        
        
        String tituloDeCortesia = this.leerTextoDeCampoDeTexto(this.ventana.verTxtTituloCortesia());
        
        LocalDate fechaNacimiento = ManejoDeFechas.obtenerFechaDeJDateChooser(this.ventana.verFechaNacimiento());
        
        LocalDate fechaContratacion = ManejoDeFechas.obtenerFechaDeJDateChooser(this.ventana.verFechaContratacion());
        
        String direccion = this.leerTextoDeCampoDeTexto(this.ventana.verTxtDireccion());
        
        String ciudad = this.leerTextoDeCampoDeTexto(this.ventana.verTxtCiudad());
        
        String region = this.leerTextoDeCampoDeTexto(this.ventana.verTxtRegion());
        
        String codigoPostal = this.leerTextoDeCampoDeTexto(this.ventana.verTxtCodigoPostal());
        
        String pais = this.leerTextoDeCampoDeTexto(this.ventana.verTxtPais());
        
        String telefono = this.leerTextoDeCampoDeTexto(this.ventana.verTxtTelefono());
        
        String extension = this.leerTextoDeCampoDeTexto(this.ventana.verTxtExtension());
        
        String notas = this.leerDeJTextArea(this.ventana.verTxtNotas());
        
        Integer reportaA = this.leerDeJComboBox(this.ventana.verComboReportaA());
        
        String foto = this.leerTextoDeCampoDeTexto(this.ventana.verTxtFoto());
        if (this.empleado == null) //nuevo empleado
            this.nuevoEmpleado(idEmpleado, apellido, nombre, titulo, tituloDeCortesia, fechaNacimiento, fechaContratacion, direccion, ciudad, region, codigoPostal, pais, telefono, extension, notas, reportaA, foto);
        else //modificar empleado
            this.modificarEmpleado(idEmpleado, apellido, nombre, titulo, tituloDeCortesia, fechaNacimiento, fechaContratacion, direccion, ciudad, region, codigoPostal, pais, telefono, extension, notas, reportaA, foto);
    }
    
    /**
     * Devuelve la representación entera del campo texto
     * En el campo de texto sólo se pueden ingresar números (ver txtIdentificadorPresionarTecla())
     * @param campo campo de texto a leer
     * @return Integer  - si el texto del campo de texto no está vacío, devuelve su representación numérica, null en caso contrario
     */
    private Integer leerEnteroDeCampoDeTexto(JTextField campo) {
        String texto = this.leerTextoDeCampoDeTexto(campo);
        return (texto != null ? Integer.parseInt(texto) : null);
    }
    
    /**
     * Debuelve el texto del campo de texto
     * @param campo campo de texto a leer
     * @return String  - si el texto del campo de texto no está vacío, lo devuelve, null en caso contrario
     */    
    private String leerTextoDeCampoDeTexto(JTextField campo) {
        if (!campo.getText().trim().isEmpty())
            return campo.getText().trim();
        else
            return null;
    }
    
    /**
     * Si en el cambo especificado hay un empleado seleccionado, devuelve su identificador
     * Si no hay un empleado seleccionado, devuelve null
     * @param combo combo a leer
     * @return Integer  - identificador del empleado seleccionado, null si no hay ninguno seleccionado
     */
    private Integer leerDeJComboBox(JComboBox combo) {
        ModeloComboEmpleados mce = (ModeloComboEmpleados)combo.getModel();
        Empleado empleadoSeleccionado = mce.obtenerEmpleado();
        return (empleadoSeleccionado != null ? empleadoSeleccionado.verIdEmpleado() : null);
    }
    
    /**
     * Debuelve el texto del área de texto
     * @param campo área de texto a leer
     * @return String  - si el texto del área de texto no está vacío, lo devuelve, null en caso contrario
     */        
    private String leerDeJTextArea(JTextArea campo) {
        if (!campo.getText().trim().isEmpty())
            return campo.getText().trim();
        else
            return null;
    }
    
    /**
     * Se encarga de la creación de un empleado
     * @param idEmpleado identificador del empleado
     * @param apellido apellido del empleado
     * @param nombre nombre del empleado
     * @param titulo título del empleado
     * @param tituloDeCortesia título de cortesía del empleado
     * @param fechaNacimiento fecha de nacimiento del empleado
     * @param fechaContratacion fecha de contratación del empleado
     * @param direccion dirección del empleado
     * @param ciudad ciudad del empleado
     * @param region región del empleado
     * @param codigoPostal código postal del empleado
     * @param pais país del empleado
     * @param telefono teléfono del empleado
     * @param extension extensión del teléfono del empleado
     * @param notas notas del empleado
     * @param reportaA identificador del empleado a quien se reporta
     * @param foto ruta con la foto del empleado
     * @return String  - cadena con el resultado de la operación
     */
    private void nuevoEmpleado(Integer idEmpleado, String apellido, String nombre, String titulo, String tituloDeCortesia, LocalDate fechaNacimiento, LocalDate fechaContratacion, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String extension, String notas, Integer reportaA, String foto) {        
        IGestorEmpleados ge = GestorEmpleados.instanciar();
        String resultado = ge.nuevoEmpleado(idEmpleado, apellido, nombre, titulo, tituloDeCortesia, fechaNacimiento, fechaContratacion, direccion, ciudad, region, codigoPostal, pais, telefono, extension, notas, reportaA, foto);
        if (!resultado.equals(IGestorEmpleados.EXITO_CREAR))
            JOptionPane.showOptionDialog(null, resultado, TITULO_NUEVO, JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[] {"Aceptar"}, this);       
        else
            this.ventana.dispose();                                    
    }
    
    /**
     * Se encarga de la modificación de un empleado
     * @param idEmpleado identificador del empleado
     * @param apellido apellido del empleado
     * @param nombre nombre del empleado
     * @param titulo título del empleado
     * @param tituloDeCortesia título de cortesía del empleado
     * @param fechaNacimiento fecha de nacimiento del empleado
     * @param fechaContratacion fecha de contratación del empleado
     * @param direccion dirección del empleado
     * @param ciudad ciudad del empleado
     * @param region región del empleado
     * @param codigoPostal código postal del empleado
     * @param pais país del empleado
     * @param telefono teléfono del empleado
     * @param extension extensión del teléfono del empleado
     * @param notas notas del empleado
     * @param reportaA identificador del empleado a quien se reporta
     * @param foto ruta con la foto del empleado
     * @return String  - cadena con el resultado de la operación
     */
    private void modificarEmpleado(Integer idEmpleado, String apellido, String nombre, String titulo, String tituloDeCortesia, LocalDate fechaNacimiento, LocalDate fechaContratacion, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String extension, String notas, Integer reportaA, String foto) {        
        IGestorEmpleados ge = GestorEmpleados.instanciar();
        String resultado = ge.modificarEmpleado(idEmpleado, apellido, nombre, titulo, tituloDeCortesia, fechaNacimiento, fechaContratacion, direccion, ciudad, region, codigoPostal, pais, telefono, extension, notas, reportaA, foto);
        if (!resultado.equals(IGestorEmpleados.EXITO_MODIFICAR))
            JOptionPane.showOptionDialog(null, resultado, TITULO_MODIFICAR, JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[] {"Aceptar"}, this);       
        else
            this.ventana.dispose();                                    
    }
                            
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }
    
    @Override
    public void btnAbrirClic(ActionEvent evt) {
        //Se ponen en español los nombres de los botones de la ventana de diálogo
        UIManager.put("FileChooser.openButtonText","Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos del tipo:");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.newFolderToolTipText", "Carpeta nueva");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File(System.getProperty("user.home")));
        //se establece la carpeta personal del usuario para empezar la búsqueda
        selector.setDialogTitle(IControladorVentanaPrincipal.TITULO);
        selector.setAcceptAllFileFilterUsed(false); //no se muestra el filtro de todos los archivos
        
        int resultado = selector.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) { //se selecciona un archivo
            File selectedFile = selector.getSelectedFile();
            this.ventana.verTxtFoto().setText(selectedFile.getAbsolutePath());
        }        
    }

    @Override
    public void txtIdentificadorPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) { //sólo se aceptan los dígitos del 0-9, Enter, Del y Backspace
            switch(c) {
                case KeyEvent.VK_ENTER: 
                    this.btnGuardarClic(null); //no importa el evento en este caso
                    break;
                case KeyEvent.VK_BACK_SPACE:    
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume(); //consume el evento para que no sea procesado por la fuente
            }
        }
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) { //sólo se aceptan letras, Enter, Del, Backspace y espacio
            switch(c) {
                case KeyEvent.VK_ENTER: 
                    this.btnGuardarClic(null); //no importa el evento en este caso
                    break;
                case KeyEvent.VK_BACK_SPACE:    
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_SPACE:
                    break;
                default:
                    evt.consume(); //consume el evento para que no sea procesado por la fuente
            }
        }
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtTituloCortesiaPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtDireccionPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtCiudadPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtRegionPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtCodigoPostalPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtPaisPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtTelefonoPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtExtensionPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtFotosPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }

    @Override
    public void txtNotasPresionarTecla(KeyEvent evt) {
        this.txtApellidoPresionarTecla(evt);
    }    
}
