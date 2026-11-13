<?php
// GET listar.php -> [{"id":1,"nombre":"Pilar","puntuacion":8}, ...] ordenado de mayor a menor
include 'conexion.php';

$res = mysqli_query($conexion,
    "SELECT id, nombre, puntuacion FROM usuarios ORDER BY puntuacion DESC, nombre");

$datos = [];
while ($fila = mysqli_fetch_assoc($res)) {
    $fila['id'] = (int) $fila['id'];
    $fila['puntuacion'] = (int) $fila['puntuacion'];   // que llegue como número, no como "8"
    $datos[] = $fila;
}

echo json_encode($datos);
?>
