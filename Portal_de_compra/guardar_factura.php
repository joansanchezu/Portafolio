<?php


if(isset($_SESSION['user']) AND isset($_SESSION['carrito'])){
    $mail = $_SESSION['user']['e-mail'];
    $cantidad = count($_SESSION['carrito']);
    $p_total = 0;
    for($i=0;$i<$cantidad;$i++){
        $p_total += $_SESSION['carrito'][$i][2];
    }
    $timezone = date_default_timezone_get();
    $fecha = date('Y/m/d H:i:s', time());

    $sql = 'INSERT INTO `Factura` (`e-mail`, `cantidad`, `coste`, `fecha`) VALUES (?, ?, ?, ?)';


    //Preparamos la consulta
    $stmt = $conn->prepare($sql);

    //Ejecutamos la comanda
    $stmt->execute([$mail, $cantidad, $p_total, $fecha]);


}



