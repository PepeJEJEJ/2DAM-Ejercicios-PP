<?php
// Todas las respuestas son JSON
header("Content-Type: application/json; charset=utf-8");

// Los avisos de PHP no se escriben en la respuesta: romperían el JSON y, una vez escritos, ya no
// se podría cambiar el código de respuesta. El motivo del fallo va en el JSON de error
ini_set('display_errors', '0');

// Si algo falla (la base de datos no responde, una consulta está mal...), PHP lanza una
// excepción. Sin esto, respondería un error en HTML con código 200 y la app creería que ha ido
// bien. Así responde 500, que Volley y la web tratan como error, con el motivo en JSON
set_exception_handler(function ($e) {
    http_response_code(500);
    echo json_encode(['resultado' => 'ERROR', 'mensaje' => $e->getMessage()]);
});

// "db" es el nombre del servicio en docker-compose.yml: Docker lo resuelve en su red interna
$conexion = mysqli_connect("db", "alumno", "alumno", "bd_android");
mysqli_set_charset($conexion, "utf8mb4");
?>
