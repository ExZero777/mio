package control;

import DAO.Coneccion;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class BorBa implements MouseListener {
    private JTextField texto;
    private Integer tId;
    Connection conect;
   PreparedStatement s;
   String user = "root";
   String password = "";
   String url = "jdbc:mysql://localhost:3306/base_texto";
   String driver= "com.mysql.jdbc.Driver";
    
    
    public BorBa(Integer tId, JTextField texto) {
       this.tId = tId;
       this.texto = texto;
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
    Coneccion conn = new Coneccion("localhost", "root", "", "base_texto");
    
     System.out.println("Borradisimo Papa");
      Integer rst= 0; 
      
            try {
            //Class.forName(driver);
            System.out.println("Borradisimo Papa");
            conect=DriverManager.getConnection(url,user,password);
            System.out.println("Borradisimo Papa2");
            //s=conect.prepareStatement("DELETE FROM texto WHERE id = ?");//where id =(select max(id) from texto
             PreparedStatement consulta = conect.prepareStatement("select max(id) as id from texto ");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            rst = resultado.getInt(1);
         }

           
            //tId= 0;
            s=conect.prepareStatement("DELETE FROM texto WHERE id = ?");
           System.out.println("Borradisimo Papa3");
            s.setInt(1,rst);
            s.executeUpdate();
          
            System.out.println(" Recontra Borradisimo Papa");
            JOptionPane.showMessageDialog(null, "texto Borrado exitosamente");
        } 
       /* catch(ClassNotFoundException e){
              JOptionPane.showMessageDialog(null, e);
        }*/ 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } 
     // conect.close(); 
     
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    
}
