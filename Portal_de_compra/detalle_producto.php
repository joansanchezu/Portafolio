

<div class="detalle_producto">
    <div class="detalle_producto_c1">

        <h2><?php echo $detalles["nombre"] ?></h2>
        <img src="<?php echo $detalles['imagen'] ?>"
    </div>

    <div class="detalle_producto_c2">
        <p><?php echo $detalles['descripción'] ?></p>
        <h4><?php echo $detalles['precio'] ?>€</h4>
    </div>

    <input type="submit" name="Añadir_carrito" value="Añadir al carrito" onclick="Anadir_carrito('<?php echo $detalles["nombre"]; ?>', '<?php echo $detalles["imagen"]; ?>', '<?php echo $detalles["precio"]; ?>','<?php echo $detalles["id"]; ?>')" >

    <br>
    <br>
</div>
