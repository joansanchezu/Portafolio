<script type="text/javascript" src="/Vista/js/MyFunctions.js"></script>
<div>
    <h1 class="Titulo-Categoria"> Categorias </h1>
    <h1 class="Titulo-Productos">Productos</h1>
    <ul class="ul-Productos">
        <?php foreach ($categorias as $categoria): ?>
            <li class="Detalles-productos">
                <?php $categoria['nombre'] = htmlentities($categoria['nombre'], ENT_QUOTES | ENT_HTML5, 'UTF-8'); ?>

                <div class="Detalles-productos">

                    <div class="AJAX-Categoria">

                        <h3><?php echo $categoria['nombre'] ?></h3>
                        <img src="<?php  echo $categoria['imagen'] ?>" alt="Imagen" onclick="listar_productos(<?php echo $categoria['id'] ?>)">
                    </div>


                </div>


            </li>
        <?php endforeach; ?>
        <div class="Mostrar-productos"></div>
    </ul>

    <div class="Producto-Unico"></div>
    <a href="/Vista/main.php">Volver</a>
</div>



