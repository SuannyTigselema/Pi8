/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Conexion {

    public Connection connection;
    private String message;
    private Statement statement;
    ResultSet resultSet;

    public Conexion() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinanciero", "root", "");
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://26.161.108.204:5432/pi8", "postgres", "Laturbina1997");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //connection = DriverManager.getConnection(url, username, password);
            message = "ok";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public String obtenerFotoEstablecimiento(int id) {
        String foto = "";
        try {
            ResultSet rs = statement.executeQuery("select foto from establecimiento where id_establecimiento=1");
            while (rs.next()) {
                foto = rs.getString("foto");
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return foto;
    }

    public String descripcionEstablecimiento(int id) {
        String desc = "";
        try {
            ResultSet rs = statement.executeQuery("select descripcion from establecimiento where id_establecimiento=1");
            while (rs.next()) {
                desc = rs.getString("descripcion");
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return desc;
    }

    public Integer existeusuario(String usuario) {
        int desc = 0;
        try {
            ResultSet rs = statement.executeQuery("select id_usuario from usuario where nombre_usuario='" + usuario + "'");
            while (rs.next()) {
                desc = Integer.parseInt(rs.getString("id_usuario"));
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return desc;
    }

    public Integer maximopersona() {
        int desc = 0;
        try {
            ResultSet rs = statement.executeQuery("select max(id_persona)as id from persona");
            while (rs.next()) {
                desc = Integer.parseInt(rs.getString("id"));
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return desc;
    }

    public Integer maximoUsuario() {
        int desc = 0;
        try {
            ResultSet rs = statement.executeQuery("select max(id_usuario) as id from usuario");
            while (rs.next()) {
                desc = Integer.parseInt(rs.getString("id"));
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return desc;
    }

    public String nombreEstablecimiento(int id) {
        String desc = "";
        try {
            ResultSet rs = statement.executeQuery("select nombre from establecimiento where id_establecimiento=1");
            while (rs.next()) {
                desc = rs.getString("nombre");
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return desc;
    }

    public String tipoEstablecimiento(int id) {
        String desc = "";
        try {
            ResultSet rs = statement.executeQuery("select nombre from categoria c inner join categoria_establecimiento e on c.id_categoria=e.id_categoria where id_establecimiento=1");
            while (rs.next()) {
                desc = rs.getString("nombre");
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return desc;
    }

    public String direccionEstablecimiento(int id) {
        String desc = "";
        try {
            ResultSet rs = statement.executeQuery("select direccion from establecimiento where id_establecimiento=1");
            while (rs.next()) {
                desc = rs.getString("direccion");
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return desc;
    }

    public void registrarPersona(int id, String nombre, String apellido, String telefono, String correo, String ciudad, String sector, String calle, String referencia) {
        String desc = "";
        try {
            ResultSet rs = statement.executeQuery("insert into persona values(" + id + ",'" + nombre + "','" + apellido + "','" + telefono + "','" + correo + "','" + ciudad + "','" + sector + "','" + calle + "','" + referencia + "')");
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void registrarUsuario(int usuario, int id, String nombre, String clave) {
        String desc = "";
        try {
            ResultSet rs = statement.executeQuery("insert into usuario values (" + usuario + ",'" + nombre + "','" + hash.sha1(clave) + "','C'," + id + ")");
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void registrarCalificacion(int calificacion, String comentario) {
        String desc = "";
        try {
            ResultSet rs = statement.executeQuery("select insertarcomentario(" + calificacion + ",'" + comentario + "',1,1);");
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public List<CatalagoImagenes> fotosCatalogo(int i) {
        String fotof = "";
        String desc = "", nomb = "";
        List<CatalagoImagenes> fotos = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select p.foto as foto, a.nombre as restaurante, t.nombre as nombre from producto_final p \n"
                    + "	inner join producto t on t.id_producto=p.id_producto\n"
                    + "	inner join establecimiento a on a.id_establecimiento= p.id_establecimiento where p.id_establecimiento=1");
            while (rs.next()) {
                CatalagoImagenes c = new CatalagoImagenes();
                fotof = rs.getString("foto");
                desc = rs.getString("restaurante");
                nomb = rs.getString("nombre");
                c.setFoto(fotof);
                c.setDescripcion(desc);
                c.setNombre(nomb);
                fotos.add(n, c);
                n++;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return fotos;
    }

    public List<Producto_Final> fotosProdcuto() {
        String fotof = "";
        String desc = "", nomb = "";
        List<Producto_Final> fotos = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select p.descripcion as descripcion, p.foto as foto, e.nombre as nombre from producto_final p inner join establecimiento e on p.id_establecimiento=e.id_establecimiento");
            while (rs.next()) {
                Producto_Final c = new Producto_Final();
                fotof = rs.getString("foto");
                desc = rs.getString("descripcion");
                nomb = rs.getString("nombre");
                c.setDescripcion(desc);
                c.setFoto(fotof);
                c.setNombre(nomb);
                fotos.add(n, c);
                n++;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return fotos;
    }

    public List<Producto_Final> filtroTipoComida(int i) 
    {
        String fotof = "";
        String desc = "", nomb = "";
        List<Producto_Final> fotos = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select p.descripcion as descripcion, p.foto as foto, e.nombre as nombre from producto_final p inner join establecimiento e \n"
                    + "on p.id_establecimiento=e.id_establecimiento where p.id_tipo_producto=" + i + "");
            while (rs.next()) {
                Producto_Final c = new Producto_Final();
                fotof = rs.getString("foto");
                desc = rs.getString("descripcion");
                nomb = rs.getString("nombre");
                c.setDescripcion(desc);
                c.setFoto(fotof);
                c.setNombre(nomb);
                fotos.add(n, c);
                n++;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return fotos;
    }

    public List<calificacion> calificacionesPorProducto(int i) {
        List<calificacion> listCalificaciones = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select u.nombre_usuario,c.calificacion,c.opinion,c.fecha from calificacion c, usuario u where \n"
                    + "c.id_usuario=u.id_usuario and id_producto_final=" + i + "");
            while (rs.next()) {
                calificacion c = new calificacion();
                c.setNombreUsuario(rs.getString("nombre_usuario"));
                c.setFecha(rs.getString("fecha"));
                c.setOpinion(rs.getString("opinion"));
                c.setCalificacion(rs.getInt("calificacion"));
                listCalificaciones.add(c);
                n++;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return listCalificaciones;
    }

    public calificacion analisisCalificacion(int i) {
        List<calificacion> listCalificaciones = new ArrayList();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdrestaurantes", "postgres", "123");

            statement = null;
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int n = 0;
            ResultSet rs2 = statement.executeQuery("select u.nombre_usuario,c.calificacion,c.opinion,c.fecha from calificacion c, usuario u where \n"
                    + "c.id_usuario=u.id_usuario and id_producto_final=" + i + "");
            while (rs2.next()) {
                calificacion c = new calificacion();
                c.setNombreUsuario(rs2.getString("nombre_usuario"));
                c.setFecha(rs2.getString("fecha"));
                c.setOpinion(rs2.getString("opinion"));
                c.setCalificacion(rs2.getInt("calificacion"));
                listCalificaciones.add(c);
                n++;
            }
            rs2.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            String Exc = e.toString();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        calificacion ac = new calificacion();
        float prom = 0, por1 = 0, por2 = 0, por3 = 0, por4 = 0, por5 = 0;
        float suma = 0, cantidad = 0;
        int promedioint = 0, cant1 = 0, cant2 = 0, cant3 = 0, cant4 = 0, cant5 = 0;
        cantidad = listCalificaciones.size();

        for (int j = 0; j < cantidad; j++) {
            suma = suma + listCalificaciones.get(j).calificacion;
            switch (listCalificaciones.get(j).calificacion) {
                case 1:
                    cant1 = cant1 + 1;
                    break;
                case 2:
                    cant2 = cant2 + 1;
                    break;
                case 3:
                    cant3 = cant3 + 1;
                    break;
                case 4:
                    cant4 = cant4 + 1;
                    break;
                case 5:
                    cant5 = cant5 + 1;
                    break;
            }
        }
        prom = suma / cantidad;
        promedioint = (int) prom;
        DecimalFormat formato1 = new DecimalFormat("#.00");
        String promedio = formato1.format(prom);
        por1 = ((cant1 * 100) / cantidad);
        por2 = ((cant2 * 100) / cantidad);
        por3 = ((cant3 * 100) / cantidad);
        por4 = ((cant4 * 100) / cantidad);
        por5 = ((cant5 * 100) / cantidad);

        ac.setPorc1(por1);
        ac.setPorc2(por2);
        ac.setPorc3(por3);
        ac.setPorc4(por4);
        ac.setPorc5(por5);

        int j = listCalificaciones.size();
        ac.setNumOpiniones(j);
        ac.setPromedio(promedio);
        ac.setPromedioInt(promedioint);

        return ac;
    }

    public List<Producto_Final> filtroTipoComidaPrecioMayorMenor(int i) 
    {
        String fotof = "";
        String desc = "", nomb = "";
        List<Producto_Final> fotos = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select p.descripcion as descripcion, p.foto as foto, e.nombre as nombre from producto_final p inner join establecimiento e \n"
                    + "on p.id_establecimiento=e.id_establecimiento where p.id_tipo_producto=" + i + ""
                    + "order by p.precio desc");
            while (rs.next()) {
                Producto_Final c = new Producto_Final();
                fotof = rs.getString("foto");
                desc = rs.getString("descripcion");
                nomb = rs.getString("nombre");
                c.setDescripcion(desc);
                c.setFoto(fotof);
                c.setNombre(nomb);
                fotos.add(n, c);
                n++;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return fotos;
    }

    public List<Producto_Final> filtroTipoComidaPrecioMenorMayor(int i) {
        String fotof = "";
        String desc = "", nomb = "";
        List<Producto_Final> fotos = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select p.descripcion as descripcion, p.foto as foto, e.nombre as nombre from producto_final p inner join establecimiento e \n"
                    + "on p.id_establecimiento=e.id_establecimiento where p.id_tipo_producto=" + i + "\n"
                    + "order by p.precio asc");
            while (rs.next()) {
                Producto_Final c = new Producto_Final();
                fotof = rs.getString("foto");
                desc = rs.getString("descripcion");
                nomb = rs.getString("nombre");
                c.setDescripcion(desc);
                c.setFoto(fotof);
                c.setNombre(nomb);
                fotos.add(n, c);
                n++;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return fotos;
    }

    public List<Producto_Final> flitroSoloPrecioMenorMayor() {
        String fotof = "";
        String desc = "", nomb = "";
        List<Producto_Final> fotos = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select p.descripcion as descripcion, p.foto as foto, e.nombre as nombre from producto_final p inner join establecimiento e \n"
                    + "on p.id_establecimiento=e.id_establecimiento order by p.precio desc");
            while (rs.next()) 
            {
               Producto_Final c = new Producto_Final();
                fotof = rs.getString("foto");
                desc = rs.getString("descripcion");
                nomb = rs.getString("nombre");
                c.setDescripcion(desc);
                c.setFoto(fotof);
                c.setNombre(nomb);
                fotos.add(n, c);
                n++;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return fotos;
    }

    public List<Producto_Final> flitroSoloPrecioMayorMenor() {
        String fotof = "";
        String desc = "", nomb = "";
        List<Producto_Final> fotos = new ArrayList();
        int n = 0;
        try 
        {
            ResultSet rs = statement.executeQuery("select p.descripcion as descripcion, p.foto as foto, e.nombre as nombre from producto_final p inner join establecimiento e \n"
                    + "on p.id_establecimiento=e.id_establecimiento order by p.precio asc");
            while (rs.next()) 
            {
                Producto_Final c = new Producto_Final();
                fotof = rs.getString("foto");
                desc = rs.getString("descripcion");
                nomb = rs.getString("nombre");
                c.setDescripcion(desc);
                c.setFoto(fotof);
                c.setNombre(nomb);
                fotos.add(n, c);
                n++;
            }
            rs.close();
            statement.close();
            connection.close();
        } 
        catch (Exception e) 
        { 
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return fotos;
    }

    public Integer id(String usu, String ct) {
        int desc = 0;
        try {
              ResultSet rs = statement.executeQuery("select id_usuario from usuario where nombre_usuario='" + usu + "' and clave='" + ct + "'");
            while (rs.next()) {
                desc = Integer.parseInt(rs.getString("id_usuario"));
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return desc;
    }
    public List<Tipo_productos> tipoproducto() {
        List<Tipo_productos> productos = new ArrayList();
        String nomb="";
        int n=0;
        try 
        {
            ResultSet rs = statement.executeQuery("select id_tipo_producto, nombre from tipo_producto");
            while (rs.next()) 
            {
                Tipo_productos pro= new Tipo_productos();
                n = rs.getInt("id_tipo_producto");
                nomb=rs.getString("nombre");
                pro.setId(n);
                pro.setNombre(nomb);
                productos.add(pro);
            }
            rs.close();
            statement.close();
            connection.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return productos;
    }
    
      public List<Chefs> chefs(int establecimiento) {
        List<Chefs> chef = new ArrayList();
        String nomb="", apelli="";
        int n=0;
        try {
            ResultSet rs = statement.executeQuery("select chef.id_chef,persona.nombres,persona.apellidos from chef,persona where chef.id_persona=persona.id_persona and id_establecimiento="+establecimiento+"");
            while (rs.next()) 
            {
                Chefs pro= new Chefs();
                n = rs.getInt("id_chef");
                nomb=rs.getString("nombres");
                apelli=rs.getString("apellidos");
                pro.setId(n);
                pro.setNombre(nomb);
                pro.setApellidos(apelli);
                chef.add(pro);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return chef;
    }
      
       public int producto(String nombre) {
        int id=0;
        try 
        {
            ResultSet rs = statement.executeQuery("select id_producto from producto where nombre='"+nombre+"'");
            while (rs.next()) {
                
                id = rs.getInt("id_producto");
            }
            rs.close();
            statement.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return id;
    }
       public boolean insertar_productof(int producto,int establecimiento,String descripcion,String foto, int tipo_producto,double precio,int chef,String disponible){
           boolean bandera=true;
           try{
             statement=connection.createStatement();
             statement.executeQuery("insert into producto_final(id_producto,id_establecimiento,descripcion,foto,id_tipo_producto,precio,id_chef,disponible) values("+producto+","+establecimiento+",'"+descripcion+"','"+foto+"',"+tipo_producto+","+precio+","+chef+",'"+disponible+"')");
             statement.close();
             connection.close();
           }
           catch(SQLException e)
           {
               
           }
           return bandera;
       }
       public boolean insertar_producto(String nombre){
           boolean bandera=true;
           try
           {
             statement=connection.createStatement();
             statement.executeQuery("insert into producto(nombre)values('"+nombre+"')");
             statement.close();
           }
           catch(SQLException e){
           }
           return bandera;
       }
        public void recomendaciones(int usuario) {
        ArrayList<Usuario>entrenamiento=  new ArrayList<>();
        ArrayList<Usuario>prueba=DatosPrueba();
        boolean bandera=false;
        int n=0;
        try {
            ResultSet rs = statement.executeQuery("select producto_final.id_producto_final,categoria.id_categoria,establecimiento.id_establecimiento,calificacion.calificacion from calificacion,producto_final,tipo_producto,categoria,establecimiento  where calificacion.id_producto_final=producto_final.id_producto_final  and producto_final.id_establecimiento=establecimiento.id_establecimiento and producto_final.id_tipo_producto=tipo_producto.id_tipo_producto and tipo_producto.id_categoria=categoria.id_categoria and calificacion.id_usuario="+usuario+"");
            while (rs.next()) {
                Usuario pro= new Usuario(rs.getInt("id_producto_final"), rs.getInt("id_categoria"), rs.getInt("id_establecimiento"), rs.getInt("calificacion"));
                entrenamiento.add(pro);
                bandera=true;
            }
            rs.close();
            statement.close();
            connection.close();
            //Si tiene historial aparecen estas recomendaciones
            if(bandera){
                 Recomendacion recon= new Recomendacion();
                 double[][] resultado = recon.recomendacion(entrenamiento, prueba);
            }
            //en caso que no tenga historial mostrar populares
            else{
                
                double[][] resultado=populares();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
        public ArrayList<Usuario> DatosPrueba(){
        ArrayList<Usuario>prueba=  new ArrayList<>();
        int n=0;
        try 
        {
            ResultSet rs = statement.executeQuery("select producto_final.id_producto_final,categoria.id_categoria,establecimiento.id_establecimiento, 0 as calificacion from producto_final,producto,tipo_producto,categoria,establecimiento where producto_final.id_producto=producto.id_producto and producto_final.id_tipo_producto=tipo_producto.id_tipo_producto and tipo_producto.id_categoria=categoria.id_categoria and producto_final.id_establecimiento=establecimiento.id_establecimiento");
            while (rs.next()) {
                Usuario pro= new Usuario(rs.getInt("id_producto_final"), rs.getInt("id_categoria"), rs.getInt("id_establecimiento"), rs.getInt("calificacion"));
                prueba.add(pro);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
         return prueba;
        }
        
        public double[][] populares(){
         double[][] popular;
         double[][] resultado= new double[0][0];
         ArrayList<Usuario>populares=  new ArrayList<>();
        int n=0;
        try 
        {
            ResultSet rs = statement.executeQuery("select producto_final.id_producto_final,categoria.id_categoria,establecimiento.id_establecimiento,round(AVG(calificacion.calificacion)) as calificacion " +
            "from calificacion,producto_final,tipo_producto,categoria,establecimiento  " +
            "where calificacion.id_producto_final=producto_final.id_producto_final  and " +
            "producto_final.id_establecimiento=establecimiento.id_establecimiento and " +
            "producto_final.id_tipo_producto=tipo_producto.id_tipo_producto and " +
            "tipo_producto.id_categoria=categoria.id_categoria and calificacion.calificacion >= 4 " +
            "group by producto_final.id_producto_final,categoria.id_categoria,establecimiento.id_establecimiento");
            while (rs.next()) {
                Usuario pro= new Usuario(rs.getInt("id_producto_final"), rs.getInt("id_categoria"), rs.getInt("id_establecimiento"), rs.getInt("calificacion"));
                populares.add(pro);
            }
            popular= new double[populares.size()][2];
            for (int i = 0; i < populares.size(); i++) {
                popular[i][1]=Double.valueOf(populares.get(i).getEstablecimiento());
                popular[i][0]=Double.valueOf(populares.get(i).getPlato());
            }
            rs.close();
            statement.close();
            connection.close();
          return popular;
        } 
        catch (Exception e) 
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
         return resultado;  
       }

}
