/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class ManejoDeFechas {
    public static final String SEPARADOR_FECHAS = "/";
    public static final String FECHA_NULA = "-";
    public static final String PATRON = "dd/MM/yyyy";
        
    /**
     * Dada una fecha, devuelve una cadena de la forma indicada den el patrón
     * Si la fecha es nula, devuelve el caracter usado para fechas nulas
     * @param fecha fecha a transformar
     * @return String  - cadena con la representación de la fecha
     */
    public static String transformarLocalDateEnCadena(LocalDate fecha) {        
        if (fecha != null) {
            return fecha.format(DateTimeFormatter.ofPattern(PATRON));
        }
        else
            return FECHA_NULA;            
    }
    
    /**
     * Obtiene la fecha de un campo JDateChooser
     * Si no hay seleccionada una fecha devuelve null
     * @param dateChooser campo JDateChooser
     * @return LocalDate  - fecha de un campo JDateChooser
     */
    public static LocalDate obtenerFechaDeJDateChooser(JDateChooser dateChooser) {
        if (dateChooser.getCalendar() != null) {
            Date date = dateChooser.getCalendar().getTime();
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        else
            return null;
    }
    
    /**
     * Dado un LocalDate, devuelve un GregorianCalendar
     * Si no se especifica una fecha, devuelve null
     * @param fecha fecha a transformar
     * @return GregorianCalendar  - objeto GregorianCalendar
     */
    public static GregorianCalendar transformarLocalDateEnGregorianCalendar(LocalDate fecha) {
        return (fecha != null ? GregorianCalendar.from(fecha.atStartOfDay(ZoneId.systemDefault())) : null);
    }
}
