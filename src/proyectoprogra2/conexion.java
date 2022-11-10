/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra2;


import java.sql.Connection;          //Aqui obtenemos el metodo conectar
import java.sql.DriverManager;       //Aqui obtenemos el manejo del driver de java a mysql
import java.sql.PreparedStatement;   //Aqui obtenemos una sintaxis facil de crear sentencias sql
import java.sql.SQLException;        //Aqui obtenemos los metodo para manejo de excepciones

/**
 *
 * @author Jimmy Vasquez
 */
//Dentro del constructor vamos a crear la conexion usando un try-catch
public class conexion {
    
    private final String url = "jdbc:mysql://localhost/proyectoprogra2";        //Creamos un string de tipo privado y final, esto quiere decir que no cambiara su valor
    //En este caso despues de la direccion "jdbc:mysql://localhost/" despues de localhost/ debemos escribit el nombre de la BD que queremos conectar, en este caso es estudiantes
    PreparedStatement psPrepararSentencia;          //Creamos un objeto de tipo  PreparedStatement para los querys que queramos hacer a la BD
    Connection con = null;                 //Como aun no tenemos conexion, con sera objeto de tipo connection que apunte a null
    public String sentencia;
//Dentro del constructor de la clase, intentaremos conectarnos usando un try-catch para agarrar las excepciones
    public conexion() {
     //sentencia = "insert into prueba (codigo, nombre) values(1,'HOLA')";
     try{   //Inicio del try
         
         Class.forName("com.mysql.jdbc.Driver");     //Con el metodo de la clase forName, le pasamos el driver de MySQL para que lo cargue    
         con = DriverManager.getConnection(url,"root","");    //Apuntamos nuestro objeto con a el intento de conectarse con los parametros o las credenciales que tenemos en MYSQL
        //Aqui mandamos la url donde viene la direccion de la BD, nuestro nombre de usuario y la contraseña, que por defecto al instalar viene vacia
        if (con!=null){                         //Si logramos conectarnos, con deja de apuntar a null y obtenemos conexion
            System.out.println("Conexion a base de datos activa...");                //Sin funciona imprimimos en consola un mensaje
            //psPrepararSentencia=con.prepareStatement(sentencia);
            //psPrepararSentencia.executeUpdate();
        }
      }//cerramos el try
         catch(SQLException e)        //Agarramos excepciones de tipo SQL
         {
         System.out.println(e);          //las mostramos en consola
         }
         catch(ClassNotFoundException e)       //agarramos excepciones de tipo clase en java
         {
          System.out.println(e);               //las mostramos en consola
         }
    }
     /**
     *
     * @return
     */
 public Connection conectado(){  //Este metodo de tipo Connection nos devuelve el estado del objeto
      return con;
}

    public void desconectar(){     //Por seguridad, cuando terminemos sentencias, cerramos la conexion o si la necesitamos cerrar por otro caso
      con = null;                  //Ahora de nuevo con sera null
      System.out.println("La conexion la BD se ha cerrado");

}
}
