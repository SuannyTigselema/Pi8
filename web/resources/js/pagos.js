/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


src="https://www.paypal.com/sdk/js?client-id=AYkI84ClZeHfKRdIGWY8gv1xMi0936vz9bHWKac1yB2h76sVqTsVjk_whwuidBNNSgLnVU2dGTbBkjm2">
paypal.Buttons({
    createOrder: function(data, actions) {
      return actions.order.create({
        purchase_units: [{
          amount: {
            value: document.getElementById("monto").value
          }
        }]
      });
    },
    onApprove: function(data, actions) {
      return actions.order.capture().then(function(details) {
      
        alert('Transaction completed by ' + details.payer.name.given_name);
         // location.replace("http://localhost:8080/Pi8/faces/inicio.xhtml")
      });
    }
  }).render('#paypal-button-container');

