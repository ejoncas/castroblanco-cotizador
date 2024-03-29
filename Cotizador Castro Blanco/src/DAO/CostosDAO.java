
package DAO;

import Entidades.CostoFijo;
import Entidades.CostoFinanciero;
import Entidades.CostoMacro;
import Entidades.CostoVariable;
import Entidades.CostoViaje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CostosDAO
{
    public List<CostoFijo> obtenerCostosFijosCamion (String patente) {
    List<CostoFijo> costosFijos = new ArrayList<CostoFijo> () ;
    PreparedStatement stmt = null;
    ResultSet rs = null;
        try {
            String query = "SELECT * FROM CostosFijos WHERE Patente = ?";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, patente);
            rs = stmt.executeQuery();
            while(rs.next()) {
                    CostoFijo cf = new CostoFijo () ;
                    cf.setNombre(rs.getString("nombre"));
                    cf.setValor(rs.getFloat("valor"));
                    cf.setActualizacion(rs.getDate("actualizacion"));
                    costosFijos.add(cf);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(rs,stmt);
        }
        return costosFijos;
    }

    public List<CostoVariable> obtenerCostosVariablesCamion (String patente) {
    List<CostoVariable> costosVariables = new ArrayList<CostoVariable> () ;
    PreparedStatement stmt = null;
    ResultSet rs = null;
        try {
            String query = "SELECT * FROM CostosVariables WHERE Patente = ?";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, patente);
            rs = stmt.executeQuery();
            while(rs.next()) {
                    CostoVariable cv = new CostoVariable () ;
                    cv.setNombre(rs.getString("nombre"));
                    cv.setCantidad(rs.getInt("cantidad"));
                    cv.setDuracion(rs.getInt("duracion"));
                    cv.setPrecioUnitario(rs.getFloat("precio"));
                    cv.setActualizacion(rs.getDate("actualizacion"));
                    costosVariables.add(cv);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(rs,stmt);
        }
        return costosVariables;
    }

    public List<CostoFinanciero> obtenerCostosFinancierosCamion (String patente) {
    List<CostoFinanciero> costosFinancieros = new ArrayList<CostoFinanciero> () ;
    PreparedStatement stmt = null;
    ResultSet rs = null;
        try {
            String query = "SELECT * FROM CostosFinancieros WHERE Patente = ?";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, patente);
            rs = stmt.executeQuery();
            while(rs.next()) {
                    CostoFinanciero cf = new CostoFinanciero () ;
                    cf.setNombre(rs.getString("nombre"));
                    cf.setDepreciacion(rs.getFloat("depreciacion"));
                    cf.setValorUnidad(rs.getInt("valorUnidad"));
                    cf.setVidaUtil(rs.getInt("vidaUtil"));
                    costosFinancieros.add(cf);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(rs,stmt);
        }
        return costosFinancieros;
    }

    public void actualizarCostoFijoCamion (CostoFijo cfijoEdit , String patente) {
    PreparedStatement stmt = null;
        try {
            String query = "UPDATE CostosFijos SET valor = ? , nombre = ? , actualizacion = ? WHERE Patente = ? AND nombre = ?";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setFloat(1, cfijoEdit.getValor()) ;
            stmt.setString(2, cfijoEdit.getNombre()) ; // nombre nuevo
            stmt.setDate(3, cfijoEdit.getActualizacion());
            stmt.setString(4, patente) ;
            stmt.setString(5, cfijoEdit.getNombre());  // nombre viejo
            stmt.executeUpdate();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(stmt);
        }
    }

    public void actualizarCostoVariableCamion (CostoVariable cvariableEdit , String patente) {
    PreparedStatement stmt = null;
        try {
            String query = "UPDATE CostosVariables SET cantidad = ? , duracion = ? , precio = ? , nombre = ? , actualizacion = ? WHERE Patente = ? AND nombre = ?";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, cvariableEdit.getCantidad()) ;
            stmt.setInt(2, cvariableEdit.getDuracion()) ;
            stmt.setFloat(3, cvariableEdit.getPrecioUnitario()) ;
            stmt.setString(4, cvariableEdit.getNombre()) ;  // nombre nuevo
            stmt.setDate(5, cvariableEdit.getActualizacion()) ;
            stmt.setString(6, patente) ;
            stmt.setString(7, cvariableEdit.getNombre()) ;  // nombre viejo
            stmt.executeUpdate();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(stmt);
        }
    }

    public void actualizarCostoFinancieroCamion (CostoFinanciero cfinancieroEdit , String patente) {
    PreparedStatement stmt = null;
        try {
            String query = "UPDATE CostosFinancieros SET nombre = ? , depreciacion = ? , valorUnidad = ? , vidaUtil = ? WHERE Patente = ? AND nombre = ?";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, cfinancieroEdit.getNombre()) ; // nombre nuevo
            stmt.setFloat(2, cfinancieroEdit.getDepreciacion()) ;
            stmt.setFloat(3, cfinancieroEdit.getValorUnidad()) ;
            stmt.setInt(4, cfinancieroEdit.getVidaUtil()) ;
            stmt.setString(5, patente) ;
            stmt.setString(6, cfinancieroEdit.getNombre()) ; // nombre viejo
            stmt.executeUpdate();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(stmt);
        }
    }

    public void guardarCostoViaje(CostoViaje cviaje , int nroViaje) {
    PreparedStatement stmt = null;
        try {
                String queryContacto = "INSERT INTO CostoViaje VALUES (?,?,?)";
                Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
                stmt = conn.prepareStatement(queryContacto);
                stmt.setString(1, cviaje.getNombre()) ;
                stmt.setFloat(2, cviaje.getValor()) ;
                stmt.setInt(3, nroViaje) ;
                stmt.executeUpdate();
        }catch(SQLException e) {
                System.out.println(e.getMessage());
        }finally {
                DAOConnectionManager.getDAOConectionManager().closeConnection(stmt);
        }
    }

    public Vector<CostoMacro> obtenerCostosMacroGeneral () {
    Vector<CostoMacro> costosMacros = new Vector<CostoMacro> () ;
    PreparedStatement stmt = null;
    ResultSet rs = null;
        try {
            String query = "SELECT * FROM CostosMacro";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while(rs.next()) {
                    CostoMacro cm = new CostoMacro () ;
                    cm.setNombre(rs.getString("nombre")) ;
                    cm.setValor(rs.getFloat("valor")) ;
                    cm.setActualizacion(rs.getDate("actualizacion")) ;
                    costosMacros.add(cm);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(rs,stmt);
        }
        return costosMacros;
    }

    public Date obtenerFechaUltimaActualizacionFijo() {
    Date ultimaFecha = null ;
    PreparedStatement stmt = null;
    ResultSet rs = null;
        try {
            String query = "SELECT MAX (actualizacion) as 'fecha' FROM CostosFijos";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            if(rs.next()) {
                ultimaFecha = rs.getDate("fecha") ;
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(rs,stmt);
        }
        return ultimaFecha;
    }

    public Date obtenerFechaUltimaActualizacionVariable() {
    Date ultimaFecha = null ;
    PreparedStatement stmt = null;
    ResultSet rs = null;
        try {
            String query = "SELECT MAX (actualizacion) as 'fecha' FROM CostosVariables";
            Connection conn = DAOConnectionManager.getDAOConectionManager().getConnection();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            if(rs.next()) {
                ultimaFecha = rs.getDate("fecha") ;
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DAOConnectionManager.getDAOConectionManager().closeConnection(rs,stmt);
        }
        return ultimaFecha;
    }

}
