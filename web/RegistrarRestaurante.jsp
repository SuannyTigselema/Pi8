<%-- 
    Document   : RegistrarRestaurante
    Created on : 23-sep-2020, 23:08:22
    Author     : Cristhian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Restaurante</title>
        <link rel="stylesheet" href="resources/css/estil.css"></link>
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
    </head>
    <body style=" background-color: #F7F7F7;"> 
   <div class="nav_header" >
       <div class="nav_header_logo">
         <div>
             <span class="material-icons icon_logo" >shopping_cart</span>
         </div>
         <div>
             <t3 style="font-weight: 600; color: #707070">LOGO</t3>
         </div>
          
       </div>
       <div class="nav_header_busqueda_princ">
           <div class="nav_header_busqueda">
       <input class="nav_header_busq_text" type="text" placeholder="Buscar.."/>
       <span class="material-icons nav_header_busq_icon">search</span>
       </div>
           <div class="nav_header_busq_cart_cont">
              <p class="item_num_cart">9+</p>
               <a href="#" id="Add2cart"><i class="material-icons nav_header_busq_cart_cont_icon" style="font-size: 25px;">shopping_cart</i>
               </a>
               
            <label for="Add2cart" class="nav_header_busq_cart_cont_lbl">Mi carrito</label>
           </div>
            
       </div>
       
       <div class="nav_header_submenu">
        <div class="nav_header_busq_cart_cont_item">
               <a href="#" id="nav_head_prim_itm_home"><i class="material-icons nav_header_busq_cart_cont_icon selected_item" style="font-size: 25px;">home</i>
               </a>
            <label for="nav_head_prim_itm_home" class="nav_header_busq_cart_cont_lbl selected_item">Inicio</label>
           </div>
           <div class="nav_header_busq_cart_cont_item">
               <a href="#" id="nav_head_prim_itm_star"><i class="material-icons nav_header_busq_cart_cont_icon" style="font-size: 25px;">favorite</i>
               </a>
            <label for="nav_head_prim_itm_star" class="nav_header_busq_cart_cont_lbl">Favoritos</label>
           </div>
           <div class="nav_header_busq_cart_cont_item">
               <a href="#" id="nav_head_prim_itm_star"><i class="material-icons nav_header_busq_cart_cont_icon" style="font-size: 25px;">style</i>
               </a>
            <label for="nav_head_prim_itm_star" class="nav_header_busq_cart_cont_lbl">Mis compras</label>
           </div>
           <div class="nav_header_busq_cart_cont_item">
               <a href="#" id="nav_head_prim_itm_star"><i class="material-icons nav_header_busq_cart_cont_icon" style="font-size: 25px;">perm_identity</i>
               </a>
            <label for="nav_head_prim_itm_star" class="nav_header_busq_cart_cont_lbl">Usuario</label>
           </div>
       </div>
            
       </div>
    <div class="prinplbRes" >   
    <div class="prinplbRes_sec" >
        <div class="prinplbRes_tit">
           <div class="prinplbRes_tit_ci"><span class="material-icons">restaurant</span></div>
           <div class="prinplbRes_tit_cont">REGISTRAR NUEVO RESTAURANTE</div>
       </div>
       
       
       
       
       
       
       <div class="contPrinFrm">
        <div class="contPrinFrm_Sec1">
             <div class="contPrinFrm_Sec1_in">
             
             <div class="contInpT">
              <label class="contInpT_lbl" for="txtRNombre" >Nombre</label>
           <div class="contInpT_Sec2">
               <span class="contInpT_img material-icons">local_offer</span>
                <input class="contInpT_txt" type="text" id="txtRNombre" placeholder="Ingrese un nombre"/>
           </div> 
          </div>
          
          <div class="contInpT">
              <label class="contInpT_lbl" for="txtRNombre" >Dirección</label>
           <div class="contInpT_Sec2">
               <span class="contInpT_img material-icons">fastfood</span>
                 <input class="contInpT_txt" type="text" id="txtRNombre" placeholder="Ingrese su dirección"/>
                  
           </div> 
          </div>
          
          <div class="contInpT">
              <label class="contInpT_lbl" for="txtRNombre" >Teléfono</label>
           <div class="contInpT_Sec2">
               <span class="contInpT_img material-icons">phone</span>
                 <input class="contInpT_txt" type="text" id="txtRNombre" placeholder="Ingrese su teléfono"/>
           </div> 
          </div>
            
            
             <div class="contInpT">
              <label class="contInpT_lbl" for="txtRNombre" >WhatsApp</label>
           <div class="contInpT_Sec2">
               <span class="contInpT_img material-icons">phone</span>
                <input class="contInpT_txt" type="text" id="txtRNombre" placeholder="Ingrese su WhatsApp">
           </div> 
          </div>
          
          
          
         </div>
         
         <div class="contPrinFrm_Sec1_in">
            <div class="contPrinFrmImgCargCon" >
                <img class="contPrinFrmImgCarg2" src="img/bollo.jpg" alt="">
         </div>
            
             <div class="contInpT">
              <label class="contInpT_lbl" for="txtRNombre" >Foto</label>
           <div class="contInpT_Sec2">
               <span class="contInpT_img material-icons">camera_alt</span>
                <label class="custom-file-upload">
                    <input type="file"/>
                    Seleccione un archivo
                </label>
           </div>
          
          </div>
          <div class="contInpT">
              <label class="contInpT_lbl" for="txtRNombre" >Foto</label>
           <div class="contInpT_Sec2">
               <span class="contInpT_img material-icons">location_on</span>
                <a href="#popup" class="contInpT_txt btn">Seleccione su ubicación</a>
           </div>
          
          </div>
         </div>
        </div>
        
          <div class="contInpT">
              <label class="contInpT_lbl" for="txtRNombre" >Descripción</label>
           <div class="contInpT_Sec2">
               <span class="contInpT_img material-icons">description</span>
                <textarea class="contInpT_txt"  id="txtRNombre" placeholder="Ingrese la descripci'on del producto"></textarea> 
           </div>
          
          </div>
           
            <button class="card_prod_dest_btnRes" style="margin-bottom: 50px;">GUARDAR</button>
       </div>
 
       
    </div>
      
      
    
 
    </div>
       
<div id="popup" class="popup">
   <a href="#" class="close" style=" text-decoration: none;">&times;</a>
   <div class="prinplbRes_tit" style="margin: 0;">
           <div class="prinplbRes_tit_ci" ><span class="material-icons">location_on</span></div>
           <div class="prinplbRes_tit_cont">Seleccione su ubicación</div>
       </div>
    <div id="map"></div>
       <button class="card_prod_dest_btnRes" style="margin-top: 10px;">GUARDAR</button>  
</div>
<a href="#" class="close-popup act" ></a>



 <script>
      function initMap() {
        var myLatlng = {lat: -1.028453, lng: -79.467503};

        var map = new google.maps.Map(
            document.getElementById('map'), {zoom: 12, center: myLatlng});

        // Create the initial InfoWindow.
        var infoWindow = new google.maps.InfoWindow(
            {content: 'Click the map to get Lat/Lng!', position: myLatlng});
        infoWindow.open(map);

        // Configure the click listener.
        map.addListener('click', function(mapsMouseEvent) {
          // Close the current InfoWindow.
          infoWindow.close();

          // Create a new InfoWindow.
          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
          infoWindow.setContent(mapsMouseEvent.latLng.toString());
          infoWindow.open(map);
        });
      }
    </script>
    <script 
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB5MkIB5lNnQH1kC1tZ3ATeEsv7z66moKs&callback=initMap"  defer>
    </script>

    </body>
</html>
