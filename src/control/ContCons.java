package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ContCons implements MouseListener {
    private JTextField texto;
     Connection conect;
   PreparedStatement s;
   String user = "root";
   String password = "";
   String url = "jdbc:mysql://localhost:3306/base_texto";
   String driver= "com.mysql.jdbc.Driver";  
    public ContCons(JTextField texto) {
      this.texto=texto;
    }

    @Override
   
    public void mouseClicked(MouseEvent evt) {
          Integer rst = 0;  //Integer.parseInt(texto.getText());
          String rsts ="";
     try{
         //System.out.println(texto);
         conect=DriverManager.getConnection(url,user,password);
         PreparedStatement cons = conect.prepareStatement("select max(id) as ultid FROM texto ");
         ResultSet res = cons.executeQuery();
         while(res.next()){
          rst = res.getInt(1);
            System.out.println("yeahh1!!");
         }
          
        PreparedStatement consulta = conect.prepareStatement("SELECT texto FROM  texto  WHERE id = ?");
         consulta.setInt(1, rst);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
          rsts = resultado.getString("texto");
          System.out.println("yeahh2!!");  
         }
          
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e);
      }
     System.out.println(rst);
     System.out.println(rsts);
     texto.setText(rsts);
    
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
