package com.mycompany.examenits;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private Button boton;
    @FXML
    private TextArea TxtArea;


    @FXML
    private void mostrar(ActionEvent event) {
        ArrayList<String> listadatos = new ArrayList<String>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://24.152.40.30:3306/examenits", "its", "12345678");
            System.out.println("OK");
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM personas");
            
            
            while(rs.next()){
               rs.getInt("idpersona");
               rs.getString("nombres");
               rs.getString("apellidos");
               
              listadatos.add(rs.getInt(1)+" "+ rs.getString(2) +" "+ rs.getString(3)+"  \n"); 
               
             }
             con.close();
             
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
            
        }
        TxtArea.setText(listadatos+"");
    }
}
