<?php

$sql = "SELECT ID 
FROM Factura
WHERE `fecha` = {$fecha}";

//Preparamos la consulta
$stmt = $conn->prepare($sql);

//Ejecutamos la comanda
$stmt->execute();

//Recogemos los resultados

$id_factura = $stmt->fetch();


if(isset($_SESSION['user']) AND isset($_SESSION['carrito'])){

    for($i=0;$i<count($_SESSION['carrito']);$i++){
        $id_prod = $_SESSION['carrito'][$i][3];
        $qty= 1; //Solo se puede elegir un producto a la vez
        $precio = $_SESSION['carrito'][$i][2];

        $sql = 'INSERT INTO `LineasCompra` (`id_factura`, `id_producto`, `cantidad`, `precio`) VALUES (?, ?, ?, ?)';


        //Preparamos la consulta
        $stmt = $conn->prepare($sql);

        //Ejecutamos la comanda
        $stmt->execute([$id_factura, $id_prod, $qty, $precio]);

    }

}


