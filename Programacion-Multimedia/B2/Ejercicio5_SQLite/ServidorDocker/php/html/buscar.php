<?php
// GET buscar.php?nombre=Pilar -> {"id":1,"nombre":"Pilar","puntuacion":8}
// Si no existe, responde 404: Volley lo recibe por el escuchador de error
include 'conexion.php';

$nombre = $_GET['nombre'] ?? '';

$sentencia = mysqli_prepare($conexion,
    "SELECT id, nombre, puntuacion FROM usuarios WHERE nombre = ? LIMIT 1");
mysqli_stmt_bind_param($sentencia, "s", $nombre);
mysqli_stmt_execute($sentencia);
$usuario = mysqli_fetch_assoc(mysqli_stmt_get_result($sentencia));

if (!$usuario) {
    http_response_code(404);
    echo json_encode(['resultado' => 'NO_ENCONTRADO']);
    exit;
}

$usuario['id'] = (int) $usuario['id'];
$usuario['puntuacion'] = (int) $usuario['puntuacion'];
echo json_encode($usuario);
?>
