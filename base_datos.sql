
CREATE DATABASE raiz_campesina;

USE raiz_campesina;

CREATE TABLE producto (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  descripcion VARCHAR(255),
  precio DOUBLE,
  cantidad INT
);

SELECT * FROM producto;