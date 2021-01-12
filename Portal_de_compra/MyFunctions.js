function listar_productos($id) {
    $(document).ready(function () {
        $.ajax({url:"index.php?accion=listar_productos&id_categoria="+$id,
            dataType:'html',
            success: function (data) {
                $(".Mostrar-productos").html(data);
                $(".Detalles-productos").hide();
                $(".Titulo-Categoria").hide();
                $(".Titulo-Productos").show();

            }})

    })

}

function Mostrar_producto_unico($id_producto) {
    $(document).ready(function () {
        $.ajax({url:"index.php?accion=detalle_producto&id_producto="+$id_producto,
            dataType:'html',
            success: function (data) {
                $(".Producto-Unico").html(data);
                $(".Producto-Unico").show();
                $(".ul-Productos").hide();

            }})

    })

}

function Menu_desplegable(){
    $(document).ready(function () {
        $menu = $(".menu-no-usuario").find('ul').find('li');

        $menu.hover(function () {
            $(this).children('ul').stop();
            $(this).children('ul').slideDown();
        }, function () {
            $(this).children('ul').stop();
            $(this).children('ul').slideUp();
        });
    });
}

function Menu_desplegable_log() {
    $(document).ready(function () {
        $menulog = $(".menu-usuario-logeado").find('ul').find('li');

        $menulog.hover(function () {
            $(this).children('ul').stop();
            $(this).children('ul').slideDown();
        }, function () {
            $(this).children('ul').stop();
            $(this).children('ul').slideUp();
        });
    });
}

function Anadir_carrito($n_prd,$img_prod, $precio_prod, $id_prod) {
    $(document).ready(function () {
        $.ajax({url:"/index.php?accion=anadir_carrito&n_prod="+$n_prd+"&img_prod="+$img_prod+"&precio="+$precio_prod+"&id_prod="+$id_prod,
            dataType:'html',
            success: function () {
                alert('Producto añadido con éxito al carrito.')
            },
            error: function () {
                alert('No se ha podido añadir este producto al carrito')
            }

            }
        )

    })
}

function Vaciar_carrito() {
    $(document).ready(function () {
        $.ajax({url:"/index.php?accion=vaciar_comanda",
                dataType:'html',
                success: function () {
                    alert('Se ha vaciado el carrito!');
                }

            }
        )

    })

}

function Acabar_comanda() {
    $(document).ready(function () {
        $.ajax({url:"/index.php?accion=guardar_comanda",
                dataType:'html',
                success: function () {
                    alert('Gracias por comprar nuestros productos!');
                }

            }
        )

    })

}