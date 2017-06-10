<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
 <title>AutoComplate</title>
      <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
     <script type="text/javascript" src="../js/jquery.autocomplete.js"></script>
      <link rel="Stylesheet" href="../css/jquery.autocomplete.css" />
      <script type="text/javascript">
          $(function() {
          var test = [];
          test.push("Core");
             var data = "Core Selectors Attributes Traversing Manipulation CSS Events Effects Ajax Utilities".split(" ");
 
             $('#keyword').autocomplete(test).result(function(event, data, formatted) {
                 alert(test);
             });
         });
     </script>
 </head>
 <body>
     <div>
         <input id="keyword" />
         <input id="getValue" value="GetValue" type="button" />
     </div>
 </body>
 </html>
