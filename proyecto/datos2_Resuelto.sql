
CREATE TABLE alumnos_fp (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  dni VARCHAR(12) NOT NULL UNIQUE,
  nombre VARCHAR(60) NOT NULL,
  apellidos VARCHAR(80) NOT NULL,
  ciclo ENUM('DAW','DAM','ASIR') NOT NULL,
  curso TINYINT UNSIGNED NOT NULL,
  nota_media DECIMAL(4,2) NOT NULL,
  fecha_matricula DATE NOT NULL,
  CHECK (curso IN (1,2)),
  CHECK (nota_media >= 0.00 AND nota_media <= 10.00)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO alumnos_fp (dni, nombre, apellidos, ciclo, curso, nota_media, fecha_matricula) VALUES
('12345678A','Lucia','Martinez Ruiz','DAW',1,7.85,'2025-09-12'),
('23456789B','Hugo','Sanchez Mora','DAM',2,8.40,'2024-09-10'),
('34567890C','Noa','Gomez Perez','ASIR',1,6.20,'2025-09-15'),
('45678901D','Daniel','Lopez Navarro','DAW',2,5.95,'2024-09-09'),
('56789012E','Paula','Fernandez Gil','DAM',1,9.10,'2025-09-11'),
('67890123F','Mateo','Rodriguez Cano','ASIR',2,7.05,'2024-09-13'),
('78901234G','Sofia','Hernandez Vidal','DAW',1,4.80,'2025-09-16'),
('89012345H','Leo','Torres Ramos','DAM',2,6.75,'2024-09-12'),
('90123456J','Valeria','Diaz Serrano','ASIR',1,8.95,'2025-09-10'),
('11223344K','Izan','Moreno Castro','DAW',2,9.60,'2024-09-11'),
('22334455L','Carla','Iglesias Romero','DAM',1,5.10,'2025-09-13'),
('33445566M','Eric','Vazquez Pardo','ASIR',2,3.90,'2024-09-14'),
('44556677N','Marta','Suarez Leon','DAW',1,6.65,'2025-09-14'),
('55667788P','Adrian','Nunez Ortega','DAM',2,7.30,'2024-09-10'),
('66778899Q','Aitana','Crespo Molina','ASIR',1,2.75,'2025-09-17');




-- 1) Se requiere obtener el alumnado de DAW o DAM cuya nota_media esté entre 6 y 8 inclusive, 
-- mostrando nombre, ciclo, curso y nota_media, ordenado por nota_media descendente.
SELECT nombre, ciclo, curso, nota_media
FROM alumnos_fp
WHERE (ciclo = 'DAW' OR ciclo = 'DAM') -- ciclo in('DAM', 'DAW') ciclo <> 'ASIR'
  AND nota_media BETWEEN 6.00 AND 8.00
ORDER BY nota_media DESC;

-- 2) Se requiere listar alumnado de curso 1 con nota_media aprobada o alumnado de curso 2 con nota_media superior a 7, mostrando nombre, curso y nota_media.
SELECT nombre, curso, nota_media
FROM alumnos_fp
WHERE (curso = 1 AND nota_media >= 5.00)
   OR (curso = 2 AND nota_media > 7.00);

-- 3) Se requiere obtener alumnado cuya fecha_matricula sea anterior a 2025 y cuya nota_media sea inferior a 6 o superior a 9.
SELECT nombre, fecha_matricula, nota_media
FROM alumnos_fp
WHERE fecha_matricula < '2025-01-01' -- year(fecha_matricula) < 2025
  AND (nota_media < 6.00 OR nota_media > 9.00);

-- 4) Se requiere listar alumnado del ciclo ASIR que no esté en curso 2 y cuya nota_media sea al menos 6.
SELECT nombre, ciclo, curso, nota_media
FROM alumnos_fp
WHERE ciclo = 'ASIR'
  AND curso <> 2
  AND nota_media >= 6.00;

-- 5) Se requiere obtener alumnado cuyo nombre empiece por A o M y cuya nota_media no esté entre 5 y 7.
SELECT nombre, apellidos, nota_media
FROM alumnos_fp
WHERE (nombre LIKE 'A%' OR nombre LIKE 'M%')
  AND NOT (nota_media BETWEEN 5.00 AND 7.00);

-- 6) Se requiere listar alumnado de DAW y ASIR con nota_media inferior a 5 o superior a 8.
SELECT nombre, ciclo, nota_media
FROM alumnos_fp
WHERE ciclo IN ('DAW','ASIR')
  AND (nota_media < 5.00 OR nota_media > 8.00);

-- 7) Se requiere obtener alumnado matriculado en septiembre de 2025 con nota_media aprobada.
SELECT nombre, fecha_matricula, nota_media
FROM alumnos_fp
WHERE fecha_matricula BETWEEN '2025-09-01' AND '2025-09-30'
  AND nota_media >= 5.00;

-- 8) Se requiere listar alumnado cuyo DNI termine en letra vocal y cuya nota_media sea superior a la media de aprobado (>= 6).
SELECT dni, nombre, nota_media
FROM alumnos_fp
WHERE (dni LIKE '%A' OR dni LIKE '%E' OR dni LIKE '%I' OR dni LIKE '%O' OR dni LIKE '%U')
  AND nota_media >= 6.00;

-- 9) Se requiere obtener alumnado de curso 2 que no pertenezca al ciclo DAM y tenga nota_media inferior a 6.5.
SELECT nombre, ciclo, curso, nota_media
FROM alumnos_fp
WHERE curso = 2
  AND ciclo <> 'DAM'
  AND nota_media < 6.50;

-- 10) Se requiere mostrar el número total de alumnos por curso,
-- indicando también la nota_media media por curso redondeada a dos decimales.
SELECT curso,
       COUNT(*) AS total_alumnos,
       ROUND(AVG(nota_media), 2) AS media_notas
FROM alumnos_fp
GROUP BY curso
ORDER BY curso;



-- 11) Se requiere obtener el número de alumnos aprobados y suspensos por ciclo, sin usar HAVING.
SELECT ciclo,
       SUM(CASE WHEN nota_media >= 5.00 THEN 1 ELSE 0 END) AS aprobados,
       SUM(CASE WHEN nota_media < 5.00 THEN 1 ELSE 0 END) AS suspensos
FROM alumnos_fp
GROUP BY ciclo;

-- 12) Se requiere listar alumnado con nota_media entre 4 y 6 que no sea de ASIR y esté matriculado en 2025.
SELECT nombre, ciclo, nota_media, fecha_matricula
FROM alumnos_fp
WHERE nota_media BETWEEN 4.00 AND 6.00
  AND ciclo <> 'ASIR'
  AND fecha_matricula BETWEEN '2025-01-01' AND '2025-12-31';
  -- and year(fecha_matricula) = 2025

-- 13) Se requiere obtener alumnado de DAM con nota_media superior a 7 o alumnado de DAW con nota_media inferior a 6.
SELECT nombre, ciclo, nota_media
FROM alumnos_fp
WHERE (ciclo = 'DAM' AND nota_media > 7.00)
   OR (ciclo = 'DAW' AND nota_media < 6.00);

-- 14) Se requiere listar alumnado cuyo apellido contenga la letra 'z' y cuya nota_media sea mayor o igual que 5.
SELECT nombre, apellidos, nota_media
FROM alumnos_fp
WHERE apellidos LIKE '%z%'
  AND nota_media >= 5.00;

-- 15) Se requiere obtener, por ciclo, la nota máxima y mínima registrada, ordenando el resultado por la nota máxima de mayor a menor.
SELECT ciclo,
       MAX(nota_media) AS nota_maxima,
       MIN(nota_media) AS nota_minima
FROM alumnos_fp
GROUP BY ciclo
ORDER BY nota_maxima DESC;


-- 16) Se necesita obtener un listado ordenado de alumnado que cumpla: (a) DAW 1.º con nota_media entre 6.50 y 9.00 (incluidos),
-- o (b) DAM 2.º con nota_media >= 7.00. Mostrar id, dni, nombre, apellidos, ciclo, curso, nota_media. Ordenar por nota_media DESC y apellidos ASC.
SELECT id, dni, nombre, apellidos, ciclo, curso, nota_media
FROM alumnos_fp
WHERE (ciclo='DAW' AND curso=1 AND nota_media BETWEEN 6.50 AND 9.00)
   OR (ciclo='DAM' AND curso=2 AND nota_media >= 7.00)
ORDER BY nota_media DESC, apellidos ASC;

-- 17) Se necesita listar alumnado con nota_media >= 5.00 excluyendo ASIR de 2.º. Además, filtrar por fecha_matricula: 
-- o bien >= '2025-09-12' o bien <= '2024-09-10'. Mostrar dni, nombre, apellidos, ciclo, curso, nota_media. 
-- Ordenar por fecha_matricula DESC y nota_media DESC.
SELECT dni, nombre, apellidos, ciclo, curso, nota_media
FROM alumnos_fp
WHERE NOT (ciclo='ASIR' AND curso=2)
  AND nota_media >= 5.00
  AND (fecha_matricula >= '2025-09-12' OR fecha_matricula <= '2024-09-10')
ORDER BY fecha_matricula DESC, nota_media DESC;

-- 18) Se requiere identificar alumnado solo de DAW o DAM cuyo apellidos contenga 'ez' o 'ro', 
-- y que su nota_media sea < 6.00 o > 8.50. Mostrar id, nombre, apellidos, ciclo, nota_media. Ordenar por ciclo y nota_media.
SELECT id, nombre, apellidos, ciclo, nota_media
FROM alumnos_fp
WHERE (apellidos LIKE '%ez%' OR apellidos LIKE '%ro%')
  AND (nota_media < 6.00 OR nota_media > 8.50)
  AND ciclo IN ('DAW','DAM')
ORDER BY ciclo, nota_media;

-- 19) Se necesita extraer alumnado de DAW y ASIR (curso 1 o 2) con nota_media en [4.50, 7.50] o en [8.80, 10.00].
-- Mostrar dni, nombre, ciclo, curso, nota_media, fecha_matricula. Ordenar por curso DESC y nota_media DESC.
SELECT dni, nombre, ciclo, curso, nota_media, fecha_matricula
FROM alumnos_fp
WHERE ciclo IN ('DAW','ASIR')
  AND curso IN (1,2)
  AND (nota_media BETWEEN 4.50 AND 7.50 OR nota_media BETWEEN 8.80 AND 10.00)
ORDER BY curso DESC, nota_media DESC;

-- 20) Se requiere localizar alumnado cuyo nombre empiece por A o M,
-- cuyos apellidos contengan 'M' o 'm', 
-- y cuya fecha_matricula esté entre '2024-09-10' y '2025-09-16'.
-- Mostrar id, dni, nombre, apellidos, fecha_matricula.
-- Ordenar por apellidos y nombre.
SELECT id, dni, nombre, apellidos, fecha_matricula
FROM alumnos_fp
WHERE (nombre LIKE 'A%' OR nombre LIKE 'M%')
  AND (apellidos LIKE '%M%' OR apellidos LIKE '%m%')
  AND fecha_matricula BETWEEN '2024-09-10' AND '2025-09-16'
ORDER BY apellidos, nombre;

-- 21) Se requiere obtener alumnado que cumpla alguno de estos perfiles:
-- (a) DAM 1.º con nota_media >= 8.50, 
-- (b) DAW 2.º con nota_media entre 5.50 y 7.00, 
-- (c) ASIR 1.º con nota_media >= 8.80. Mostrar dni, ciclo, curso, nota_media. 
-- Ordenar por ciclo, curso, nota_media DESC.
SELECT dni, ciclo, curso, nota_media
FROM alumnos_fp
WHERE (ciclo='DAM' AND (curso=1 AND nota_media >= 8.50))
   OR (ciclo='DAW' AND (curso=2 AND nota_media BETWEEN 5.50 AND 7.00))
   OR (ciclo='ASIR' AND (curso=1 AND nota_media >= 8.80))
ORDER BY ciclo, curso, nota_media DESC;

-- 22) Se necesita detectar alumnado con apellidos que contengan 'ez' o 'es',
-- con nota_media entre 5.00 y 7.00, excluyendo el perfil DAM 1.º.
-- Mostrar id, nombre, apellidos, ciclo, nota_media.
-- Ordenar por apellidos y nota_media DESC.
SELECT id, nombre, apellidos, ciclo, nota_media
FROM alumnos_fp
WHERE (apellidos LIKE '%ez%' OR apellidos LIKE '%es%')
  AND (nota_media BETWEEN 5.00 AND 7.00)
  AND NOT (ciclo='DAM' AND curso=1)
ORDER BY apellidos, nota_media DESC;

-- 23) Se requiere listar alumnado cuyo dni termine en A/B/C/D
-- y que cumpla: fecha_matricula >= '2025-09-11' o
-- (fecha_matricula <= '2024-09-11' y curso=2).
-- Mostrar dni, nombre, apellidos, ciclo, curso, fecha_matricula.
-- Ordenar por fecha_matricula y dni.
SELECT dni, nombre, apellidos, ciclo, curso, fecha_matricula
FROM alumnos_fp
WHERE (dni LIKE '%A' OR dni LIKE '%B' OR dni LIKE '%C' OR dni LIKE '%D')
  AND (fecha_matricula >= '2025-09-11' OR (fecha_matricula <= '2024-09-11' AND curso=2))
ORDER BY fecha_matricula, dni;

-- 24) Se requiere seleccionar alumnado que sea DAW 1.º o
-- DAM 2.º y cuya nota_media sea >= 6.00 o < 4.00. 
-- Mostrar id, nombre, apellidos, ciclo, curso, nota_media.
-- Ordenar por nota_media DESC.
SELECT id, nombre, apellidos, ciclo, curso, nota_media
FROM alumnos_fp
WHERE (
        (ciclo='DAW' AND curso=1)
        OR (ciclo='DAM' AND curso=2)
      )
  AND NOT (ciclo='DAW' AND curso=1 AND ciclo='DAM' AND curso=2)
  AND (nota_media >= 6.00 OR nota_media < 4.00)
ORDER BY nota_media DESC;

-- 25) Se requiere un resumen estadístico por ciclo y curso: total de alumnos,
-- nota mínima, nota máxima y 
-- nota media redondeada a 2 decimales. 
-- Agrupar por ciclo y curso y ordenar por ciclo y curso.
SELECT ciclo, curso, COUNT(*) AS total_alumnos,
       MIN(nota_media) AS min_nota,
       MAX(nota_media) AS max_nota,
       ROUND(AVG(nota_media), 2) AS media_nota
FROM alumnos_fp
GROUP BY ciclo, curso
ORDER BY ciclo, curso;

-- 26) Se requiere un informe por ciclo: total , 
-- aprobados, suspensos
-- y media redondeada a 2 decimales. 
-- Filtrar fecha_matricula entre '2024-09-10' y '2025-09-17' y curso 1 o 2.
-- Agrupar por ciclo y ordenar por total DESC y media DESC.
SELECT ciclo,
       COUNT(*) AS total,
       SUM(CASE WHEN nota_media >= 5.00 THEN 1 ELSE 0 END) AS aprobados,
       SUM(CASE WHEN nota_media < 5.00 THEN 1 ELSE 0 END) AS suspensos,
       ROUND(AVG(nota_media), 2) AS media
FROM alumnos_fp
WHERE (fecha_matricula >= '2024-09-10' AND fecha_matricula <= '2025-09-17')
  AND (curso=1 OR curso=2)
GROUP BY ciclo
ORDER BY total DESC, media DESC;

-- 27) Se requiere listar alumnado excelente con nota_media >= 8.50, en ciclos DAW/DAM/ASIR, 
-- incluyendo todo curso=1 y, si curso=2, solo si fecha_matricula <= '2024-09-12'. 
-- Mostrar dni, nombre, apellidos, ciclo, curso, nota_media. Ordenar por nota_media DESC y fecha_matricula ASC.
SELECT dni, nombre, apellidos, ciclo, curso, nota_media
FROM alumnos_fp
WHERE nota_media >= 8.50
  AND (ciclo='DAW' OR ciclo='DAM' OR ciclo='ASIR')
  AND (curso=1 OR (curso=2 AND fecha_matricula <= '2024-09-12'))
ORDER BY nota_media DESC, fecha_matricula ASC;

-- 28) Se requiere obtener alumnado matriculado en dos ventanas de fecha: 
-- [2024-09-09, 2024-09-11] o [2025-09-14, 2025-09-17], y que además cumpla: nota_media >= 5.50 o ciclo='ASIR'. 
-- Mostrar id, dni, nombre, ciclo, fecha_matricula, nota_media. Ordenar por fecha_matricula, ciclo, nota_media DESC.
SELECT id, dni, nombre, ciclo, fecha_matricula, nota_media
FROM alumnos_fp
WHERE (fecha_matricula BETWEEN '2024-09-09' AND '2024-09-11')
   OR (fecha_matricula BETWEEN '2025-09-14' AND '2025-09-17')
  AND (nota_media >= 5.50 OR ciclo='ASIR')
ORDER BY fecha_matricula, ciclo, nota_media DESC;

-- 29) Se requiere detectar alumnado en riesgo: (a) nota_media < 5.00 y ciclo DAW o ASIR,
-- o (b) nota_media < 4.50 y ciclo DAM. Además, incluir todo curso=1 y, si curso=2, 
-- solo si fecha_matricula <= '2024-09-14'. Mostrar dni, nombre, apellidos, ciclo, curso, nota_media. Ordenar por nota_media ASC y ciclo ASC.
SELECT dni, nombre, apellidos, ciclo, curso, nota_media
FROM alumnos_fp
WHERE (nota_media < 5.00 AND (ciclo='DAW' OR ciclo='ASIR'))
   OR (nota_media < 4.50 AND ciclo='DAM')
  AND (curso=1 OR (curso=2 AND fecha_matricula <= '2024-09-14'))
ORDER BY nota_media ASC, ciclo ASC;

-- 30) Se requiere listar alumnado mostrando un campo calculado alumno = CONCAT(nombre,' ',apellidos),
-- y campos derivados anio_matricula = YEAR(fecha_matricula) y mes_matricula = MONTH(fecha_matricula).
-- Filtrar por reglas por año: en 2025 incluir si nota_media entre 6.00 y 9.50; 
-- en 2024 incluir si nota_media >= 7.00 o ciclo='ASIR'. Mostrar id, alumno, ciclo, curso, nota_media, 
-- anio_matricula, mes_matricula. Ordenar por anio_matricula DESC, mes_matricula DESC, nota_media DESC.
SELECT id,
       CONCAT(nombre, ' ', apellidos) AS alumno,
       ciclo,
       curso,
       nota_media,
       YEAR(fecha_matricula) AS anio_matricula,
       MONTH(fecha_matricula) AS mes_matricula
FROM alumnos_fp
WHERE (YEAR(fecha_matricula)=2025 AND (nota_media >= 6.00 AND nota_media <= 9.50))
   OR (YEAR(fecha_matricula)=2024 AND (nota_media >= 7.00 OR ciclo='ASIR'))
ORDER BY anio_matricula DESC, mes_matricula DESC, nota_media DESC;