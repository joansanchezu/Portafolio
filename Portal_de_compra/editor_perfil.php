<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Technolyze</title>
    <link rel="stylesheet" href = "/Vista/css/practica.css" />
    <script type="text/javascript" src="/Vista/js/MyFunctions.js"></script>
    <script type="text/javascript" src="/Vista/js/jquery-3.4.1.js"></script>
</head>
<body>
<div>
    <!-- header -->

    <div>
        <h2>Modificar cuenta</h2>
    </div>


    <div class="Modificar-perfil">
        <h3>Introduce los cambios a tu cuenta:</h3>
        <form action="http://tdiw-a4.deic-docencia.uab.cat/Modelo/editar_perfil.php" method="POST">
            <ul>

                <p> Nombre: <input type = "text" name = "nombre" value="<?php $_SESSION['user']['nombre']?>" required maxlength = 20 pattern = "[^0-9]+" title = "El nombre no puede contener números" /> <br /> </p>
                <p> Apellidos: <input type = "text" name = "apellidos" value="<?php $_SESSION['user']['apellidos']?>" required maxlength = 50 pattern = "[^0-9]+" title = "Los apellidos no pueden contener números" /> <br /> </p>
                <p> Password: <input type = "password" name = "password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}"  title = "La contraseña debe contener al menos un número, una letra mayúscula y minúscula, y una longitud entre 8 y 20 carácteres"  /> <br /></p>
                <p> Dirección: <input type = "text" name = "direccion" value="<?php $_SESSION['user']['dirección']?>" /> <br /></p>
                <p>Población: <input type = "text" name = "poblacion" maxlength = "30" value="<?php $_SESSION['user']['poblacion']?>" pattern = "[^0-9]+" title = "La población no puede contener números" /> <br /></p>
                <p>Código postal: <input type = "text" name = "codigopostal" maxlength = "5" value="<?php $_SESSION['user']['codigo_postal']?>" pattern = "(?=.*\d).{5,5}" title = "El código postal tiene que contener 5 números"/> <br /> </p>



                <input type = "submit" value = "Modificar" />

                </il>

            </ul>

        </form>
    </div>



</body>
</html>