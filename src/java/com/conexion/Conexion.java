/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JoseRene
 */
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
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:5432/dbFoodi", "postgres", "123");
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
            ResultSet rs = statement.executeQuery("insert into usuario values (" + usuario + ",'" + nombre + "','" + clave + "','C'," + id + ")");
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

    public List<Producto_Final> filtroTipoComida(int i) {
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
                connection = DriverManager.getConnection("jdbc:postgresql://26.161.108.204:5432/pi8", "postgres", "Laturbina1997");

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

    
    public List<ControladorProducto> productosPerfil(int i, int res) {
        List<ControladorProducto> listCalificaciones = new ArrayList();

        try {
            Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://26.161.108.204:5432/pi8", "postgres", "Laturbina1997");
                  //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbFoodi", "postgres", "123");
            statement = null;
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int n = 0;
            ResultSet rs2 = statement.executeQuery("select p.id_producto as producid,a.foto,p.nombre as producto,m.nombre as establecimiento,  a.descripcion, a.precio from producto_final a inner join \n" +
"producto p on p.id_producto = a.id_producto inner join establecimiento m \n" +
"on m.id_establecimiento = a.id_establecimiento where p.id_producto="+i+" and m.id_establecimiento="+res+"");
            while (rs2.next()) {
                ControladorProducto c = new ControladorProducto();
                c.setNombreP(rs2.getString("producto"));
                c.setIdP(rs2.getString("producid"));
                c.setDescripcionP(rs2.getString("descripcion"));
                c.setImagenP(rs2.getString("foto"));
                c.setRestauranteP(rs2.getString("establecimiento"));
                c.setPrecioP(rs2.getString("precio"));
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

       
        return listCalificaciones;
    }
    
    public List<Producto_Final> filtroTipoComidaPrecioMayorMenor(int i) {
        String fotof = "";
        String desc = "", nomb = "";
        List<Producto_Final> fotos = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select p.descripcion as descripcion, p.foto as foto, e.nombre as nombre from producto_final p inner join establecimiento e \n"
                    + "on p.id_establecimiento=e.id_establecimiento where p.id_tipo_producto=" + i + "\n"
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

    public List<Producto_Final> flitroSoloPrecioMayorMenor() {
        String fotof = "";
        String desc = "", nomb = "";
        List<Producto_Final> fotos = new ArrayList();
        int n = 0;
        try {
            ResultSet rs = statement.executeQuery("select p.descripcion as descripcion, p.foto as foto, e.nombre as nombre from producto_final p inner join establecimiento e \n"
                    + "on p.id_establecimiento=e.id_establecimiento order by p.precio asc");
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

}
