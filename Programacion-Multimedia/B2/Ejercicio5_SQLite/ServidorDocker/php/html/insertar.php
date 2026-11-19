<?php
// POST insertar.php  (nombre, puntuacion) -> {"resultado":"OK"} o {"resultado":"ERROR", ...}
include 'conexion.php';

$nombre = trim($_POST['nombre'] ?? '');
$puntuacion = $_POST['puntuacion'] ?? '';

if ($nombre === '' || !is_numeric($puntuacion)) {
    http_response_code(400);   // 400 = la petición está mal hecha: Volley lo trata como error
    echo json_encode(['resultado' => 'ERROR', 'mensaje' => 'Faltan el nombre o la puntuación']);
    exit;
}

// Consulta preparada: los valores van aparte de la consulta, así que no hay inyección SQL.
// "si" = el primer valor es string y el segundo, integer
$sentencia = mysqli_prepare($conexion,
    "INSERT INTO usuarios(nombre, puntuacion) VALUES (?, ?)");
$puntuacion = (int) $puntuacion;
mysqli_stmt_bind_param($sentencia, "si", $nombre, $puntuacion);
mysqli_stmt_execute($sentencia);

echo json_encode(['resultado' => 'OK', 'id' => mysqli_insert_id($conexion)]);
?>
