-- A. OPERACIONES:
	-- 1. LIKE
-- SELECT * FROM oficina_de_alumnos of WHERE of.Correo_electronico LIKE "%@hotmail.com";
+---------------+-----------------+------+-------------------+--------------------------+----------+------------------+--------------------------+----------------------------+
| LEGAJO_ALUMNO | Nombre_completo | Edad | Direccion         | Correo_electronico       | DNI      | Fecha_nacimiento | Nombre_tutor_responsable | Telefono_tutor_responsable |
+---------------+-----------------+------+-------------------+--------------------------+----------+------------------+--------------------------+----------------------------+
|             3 | Lucas Santos    |   15 | Monte Castro 3600 | lucascrack@hotmail.com   | 51367312 | 2009-08-02       | Maria Santos             |                   11030417 |
|             5 | Macarena Rivero |   14 | Quevedo 4512      | Macuriv@hotmail.com      | 52614545 | 2010-01-16       | Juan Rivero              |                   11798134 |
|             8 | Marco Lozano    |   15 | Allende 1215      | marcoooooo@hotmail.com   | 51555498 | 2009-05-30       | Micaela Lozano           |                   11094328 |
|             9 | Fatima Sosa     |   16 | Mercedes 5432     | fatisosasosa@hotmail.com | 49309446 | 2008-08-02       | Tatiana Sosa             |                   11882431 |
+---------------+-----------------+------+-------------------+--------------------------+----------+------------------+--------------------------+----------------------------+

-- SELECT * FROM oficina_de_alumnos of WHERE of.DNI LIKE "47%";
+---------------+-----------------+------+----------------+----------------------+----------+------------------+--------------------------+----------------------------+
| LEGAJO_ALUMNO | Nombre_completo | Edad | Direccion      | Correo_electronico   | DNI      | Fecha_nacimiento | Nombre_tutor_responsable | Telefono_tutor_responsable |
+---------------+-----------------+------+----------------+----------------------+----------+------------------+--------------------------+----------------------------+
|             2 | Joaquin Ledesma |   17 | Baigorria 4523 | joacolesma@gmail.com | 47521643 | 2007-01-10       | Pedro Alfonso Ledesma    |                   11245578 |
|             4 | Lucia Leanza    |   18 | New York 8894  | lulilanza@gmail.com  | 47224411 | 2006-07-13       | Tiziano Leanza           |                   11432212 |
|             7 | Damian Fontan   |   17 | Hawai 3076     | damifon@gmail.com    | 47873539 | 2007-09-15       | Yazmin Fontan            |                  117659403 |
+---------------+-----------------+------+----------------+----------------------+----------+------------------+--------------------------+----------------------------+

	-- 2. IS NULL
-- SELECT * FROM notas n WHERE n.2do_cierre IS NULL;
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+
| ID_NOTA | ID_ALUMNO | ID_ASIGNATURA | 1er_bimestre | 2do_bimestre | 1er_cuatrimestre | 3er_bimestre | 4to_bimestre | 2do_cuatrimestre | 1er_cierre | 2do_cierre |
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+
|       3 |         1 |             3 |            8 |            9 |                8 |            6 |           10 |                8 |          8 |       NULL |
|       4 |         1 |             4 |           10 |           10 |               10 |            9 |           10 |                9 |          9 |       NULL |
|       5 |         1 |             5 |            4 |            6 |                5 |            9 |            6 |                7 |          6 |       NULL |
|       6 |         1 |             6 |            6 |            5 |                5 |            7 |            7 |                7 |          6 |       NULL |
|       7 |         1 |             7 |            9 |           10 |                9 |            8 |            8 |                8 |          8 |       NULL |
|       8 |         1 |             8 |            7 |            5 |                6 |            6 |            8 |                7 |          6 |       NULL |
|      10 |         1 |            10 |            8 |            8 |                8 |            7 |            7 |                7 |          7 |       NULL |
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+

-- SELECT * FROM secretaria s WHERE s.Licencias IS NULL; 
+-----------------+----------+--------------------+------+-----------------------------------+-------------------------------+----------+----------+--------------+--------------+-----------+-------------+
| LEGAJO_PERSONAL | Cargo    | Nombre_completo    | Edad | Direccion                         | Correo_electronico            | Telefono | DNI      | Fecha_inicio | Ficha_censal | Licencias | Asistencias |
+-----------------+----------+--------------------+------+-----------------------------------+-------------------------------+----------+----------+--------------+--------------+-----------+-------------+
|               1 | Rector   | Alfonso Gutierrez  |   59 | Avenida Lope de Vega 1592         | alfonsooo@hotmail.com         | 11242211 |  2527869 | 2007-07-27   |        58153 |      NULL |         100 |
|               5 | Profesor | Ignacio Sarale     |   37 | Avenida Salvador Maria del Carril | Igna@gmail.com                | 11874253 | 44324689 | 2019-10-31   |       108379 |      NULL |          98 |
|               7 | Profesor | Francisca Roberti  |   25 | Bermudez 2142                     | FR@gmail.com                  | 11564302 | 43152781 | 2022-07-19   |       110379 |      NULL |          99 |
|               8 | Profesor | Lorena Marta Roca  |   44 | Virgilio 7642                     | LoreMar@hotmail.com           | 11346223 | 33856801 | 2010-03-30   |        40379 |      NULL |         100 |
|              10 | Profesor | Julian Perez       |   30 | Monte Castro 2991                 | Juli@hotmail.com              | 11123409 | 40056401 | 2015-01-15   |        80871 |      NULL |          98 |
|              12 | Profesor | Lautaro Sosa Lanza |   51 | Quevedo 2328                      | lautisosa@gmail.com           | 11212317 | 27785601 | 2023-05-10   |        55871 |      NULL |         100 |
|              13 | Profesor | Joaquin Lozano     |   23 | Avenida Rivadavia 6789            | jl@hotmail.com                | 11085391 | 42531344 | 2021-08-29   |        99345 |      NULL |          99 |
|              18 | Profesor | Julieta Lizarraga  |   33 | Avenida Rivadavia 8901            | juli@hotmail.com              | 11890797 | 45135214 | 2022-01-23   |       100112 |      NULL |          98 |
|              19 | Profesor | Diego Maradona     |   59 | Ecuador 3214                      | diego@gmail.com               | 11753232 | 24865432 | 1997-02-10   |        30649 |      NULL |         100 |
|              21 | Profesor | Santino Rivero     |   22 | Avenida Rivadavia 1252            | santiriv@hotmail.com          | 11142643 | 42745210 | 2024-07-22   |       124312 |      NULL |         100 |
|              25 | Portero  | Agustina Rodriguez |   40 | Lavalle 3134                      | agustinarodriguez@hotmail.com | 11234867 | 30321009 | 2014-02-06   |        75332 |      NULL |          98 |
+-----------------+----------+--------------------+------+-----------------------------------+-------------------------------+----------+----------+--------------+--------------+-----------+-------------+

	-- 3. NOT IN
-- SELECT * FROM oficina_de_alumnos of WHERE of.Edad NOT IN (14, 15);
+---------------+-------------------+------+---------------------+--------------------------+----------+------------------+--------------------------+----------------------------+
| LEGAJO_ALUMNO | Nombre_completo   | Edad | Direccion           | Correo_electronico       | DNI      | Fecha_nacimiento | Nombre_tutor_responsable | Telefono_tutor_responsable |
+---------------+-------------------+------+---------------------+--------------------------+----------+------------------+--------------------------+----------------------------+
|             1 | Federico Santos   |   12 | Monte Castro 3600   | fedesanto@gmail.com      | 56456896 | 2012-03-17       | Maria Santos             |                   11030417 |
|             2 | Joaquin Ledesma   |   17 | Baigorria 4523      | joacolesma@gmail.com     | 47521643 | 2007-01-10       | Pedro Alfonso Ledesma    |                   11245578 |
|             4 | Lucia Leanza      |   18 | New York 8894       | lulilanza@gmail.com      | 47224411 | 2006-07-13       | Tiziano Leanza           |                   11432212 |
|             6 | Francisco Pecile  |   13 | Benitos Juarez 5327 | skibiditoilet@gmail.com  | 55321718 | 2011-05-04       | Esteban Pe├▒aloza         |                   11245816 |
|             7 | Damian Fontan     |   17 | Hawai 3076          | damifon@gmail.com        | 47873539 | 2007-09-15       | Yazmin Fontan            |                  117659403 |
|             9 | Fatima Sosa       |   16 | Mercedes 5432       | fatisosasosa@hotmail.com | 49309446 | 2008-08-02       | Tatiana Sosa             |                   11882431 |
|            12 | Alejandro Peralta |   16 | Av Rivadavia 2100   | aleperalta@gmail.com     | 49100321 | 2008-03-12       | Julian Cortez            |                 1143852254 |
+---------------+-------------------+------+---------------------+--------------------------+----------+------------------+--------------------------+----------------------------+

-- SELECT * FROM notas n WHERE n.1er_cuatrimestre NOT IN(6, 7, 8, 9, 10);
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+
| ID_NOTA | ID_ALUMNO | ID_ASIGNATURA | 1er_bimestre | 2do_bimestre | 1er_cuatrimestre | 3er_bimestre | 4to_bimestre | 2do_cuatrimestre | 1er_cierre | 2do_cierre |
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+
|       1 |         1 |             1 |            5 |            6 |                5 |            2 |            6 |                4 |          4 |          7 |
|       5 |         1 |             5 |            4 |            6 |                5 |            9 |            6 |                7 |          6 |       NULL |
|       6 |         1 |             6 |            6 |            5 |                5 |            7 |            7 |                7 |          6 |       NULL |
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+

	-- 4. IN
-- SELECT * FROM notas n WHERE n.1er_cuatrimestre IN (6, 7, 8, 9, 10);
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+
| ID_NOTA | ID_ALUMNO | ID_ASIGNATURA | 1er_bimestre | 2do_bimestre | 1er_cuatrimestre | 3er_bimestre | 4to_bimestre | 2do_cuatrimestre | 1er_cierre | 2do_cierre |
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+
|       2 |         1 |             2 |            7 |            6 |                6 |            5 |            5 |                5 |          5 |          5 |
|       3 |         1 |             3 |            8 |            9 |                8 |            6 |           10 |                8 |          8 |       NULL |
|       4 |         1 |             4 |           10 |           10 |               10 |            9 |           10 |                9 |          9 |       NULL |
|       7 |         1 |             7 |            9 |           10 |                9 |            8 |            8 |                8 |          8 |       NULL |
|       8 |         1 |             8 |            7 |            5 |                6 |            6 |            8 |                7 |          6 |       NULL |
|       9 |         1 |             9 |            6 |            6 |                6 |            5 |            4 |                4 |          5 |          8 |
|      10 |         1 |            10 |            8 |            8 |                8 |            7 |            7 |                7 |          7 |       NULL |
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+

-- SELECT * FROM asignaturas a WHERE a.ID_DOCENTE IN (5);
+---------------+-------------------+------------+
| ID_ASIGNATURA | Nombre_asignatura | ID_DOCENTE |
+---------------+-------------------+------------+
|             1 | Lengua            |          5 |
|            17 | Fisica            |          5 |
+---------------+-------------------+------------+

	-- 5. BETWEEN
-- SELECT * FROM secretaria s WHERE s.Cargo = "Profesor" AND s.Fecha_inicio BETWEEN '2007-01-01' AND '2017-01-01';
+-----------------+----------+-------------------+------+---------------------------+----------------------+----------+----------+--------------+--------------+-----------+-------------+
| LEGAJO_PERSONAL | Cargo    | Nombre_completo   | Edad | Direccion                 | Correo_electronico   | Telefono | DNI      | Fecha_inicio | Ficha_censal | Licencias | Asistencias |
+-----------------+----------+-------------------+------+---------------------------+----------------------+----------+----------+--------------+--------------+-----------+-------------+
|               8 | Profesor | Lorena Marta Roca |   44 | Virgilio 7642             | LoreMar@hotmail.com  | 11346223 | 33856801 | 2010-03-30   |        40379 |      NULL |         100 |
|              10 | Profesor | Julian Perez      |   30 | Monte Castro 2991         | Juli@hotmail.com     | 11123409 | 40056401 | 2015-01-15   |        80871 |      NULL |          98 |
|              11 | Profesor | Lola Fierro       |   31 | Avenida Lope de Vega 1300 | lolafierro@gmail.com | 11096792 | 40959601 | 2013-04-21   |        75871 |        11 |          89 |
|              14 | Profesor | Lionel Messi      |   43 | Avenida Corrientes 10789  | Messi@gmail.com      | 11345678 | 32319874 | 2011-02-13   |        80649 |         8 |          92 |
|              15 | Profesor | Gonzalo Mendez    |   39 | Vicente Lopez 3280        | vicens@gmail.com     | 11426243 | 44913044 | 2012-12-14   |        62349 |        18 |          82 |
|              16 | Profesor | Fernando Louro    |   41 | Avenida Lope de Vega 3131 | ferrnan@gmail.com    | 11852242 | 33014778 | 2016-09-29   |        89245 |        14 |          86 |
+-----------------+----------+-------------------+------+---------------------------+----------------------+----------+----------+--------------+--------------+-----------+-------------+

-- SELECT * FROM oficina_de_alumnos of WHERE of.DNI BETWEEN 47000000 AND 51000000 ORDER BY DNI DESC;
+---------------+-------------------+------+-------------------+--------------------------+----------+------------------+--------------------------+----------------------------+
| LEGAJO_ALUMNO | Nombre_completo   | Edad | Direccion         | Correo_electronico       | DNI      | Fecha_nacimiento | Nombre_tutor_responsable | Telefono_tutor_responsable |
+---------------+-------------------+------+-------------------+--------------------------+----------+------------------+--------------------------+----------------------------+
|             9 | Fatima Sosa       |   16 | Mercedes 5432     | fatisosasosa@hotmail.com | 49309446 | 2008-08-02       | Tatiana Sosa             |                   11882431 |
|            12 | Alejandro Peralta |   16 | Av Rivadavia 2100 | aleperalta@gmail.com     | 49100321 | 2008-03-12       | Julian Cortez            |                 1143852254 |
|             7 | Damian Fontan     |   17 | Hawai 3076        | damifon@gmail.com        | 47873539 | 2007-09-15       | Yazmin Fontan            |                  117659403 |
|             2 | Joaquin Ledesma   |   17 | Baigorria 4523    | joacolesma@gmail.com     | 47521643 | 2007-01-10       | Pedro Alfonso Ledesma    |                   11245578 |
|             4 | Lucia Leanza      |   18 | New York 8894     | lulilanza@gmail.com      | 47224411 | 2006-07-13       | Tiziano Leanza           |                   11432212 |
+---------------+-------------------+------+-------------------+--------------------------+----------+------------------+--------------------------+----------------------------+

-- B. FUNCIÓN DE FECHAS
-- SELECT YEAR(of.Fecha_nacimiento) as Anio_nacimiento FROM oficina_de_alumnos of WHERE of.Edad = 14;
+-----------------+
| Anio_nacimiento |
+-----------------+
|            2010 |
|            2010 |
|            2010 |
+-----------------+

-- SELECT *, MONTH(of.Fecha_nacimiento) as Mes_nacimiento FROM oficina_de_alumnos of WHERE of.Edad = 15;
+---------------+-----------------+------+-------------------+------------------------+----------+------------------+--------------------------+----------------------------+----------------+
| LEGAJO_ALUMNO | Nombre_completo | Edad | Direccion         | Correo_electronico     | DNI      | Fecha_nacimiento | Nombre_tutor_responsable | Telefono_tutor_responsable | Mes_nacimiento |
+---------------+-----------------+------+-------------------+------------------------+----------+------------------+--------------------------+----------------------------+----------------+
|             3 | Lucas Santos    |   15 | Monte Castro 3600 | lucascrack@hotmail.com | 51367312 | 2009-08-02       | Maria Santos             |                   11030417 |              8 |
|             8 | Marco Lozano    |   15 | Allende 1215      | marcoooooo@hotmail.com | 51555498 | 2009-05-30       | Micaela Lozano           |                   11094328 |              5 |
+---------------+-----------------+------+-------------------+------------------------+----------+------------------+--------------------------+----------------------------+----------------+

-- C. AGRUPACIÓN
	-- a. GROUP BY
-- SELECT COUNT(*) as Cant_Por_Cargo, s.Cargo FROM secretaria s GROUP BY s.Cargo;
+----------------+----------------------+
| Cant_Por_Cargo | Cargo                |
+----------------+----------------------+
|              2 | Auxiliar de limpieza |
|              1 | Guardia              |
|              1 | Portero              |
|             17 | Profesor             |
|              1 | Rector               |
|              1 | Regente              |
|              1 | Secretario           |
|              1 | Vicerrector          |
+----------------+----------------------+

-- SELECT COUNT(*) as Cant_Por_Edad, of.Edad FROM oficina_de_alumnos of GROUP BY of.Edad;
+---------------+------+
| Cant_Por_Edad | Edad |
+---------------+------+
|             1 |   12 |
|             1 |   13 |
|             3 |   14 |
|             2 |   15 |
|             2 |   16 |
|             2 |   17 |
|             1 |   18 |
+---------------+------+

	-- b. HAVING
-- SELECT COUNT(*) as Cant_Notas, n.1er_bimestre FROM notas n GROUP BY n.1er_bimestre HAVING n.1er_bimestre > 6;
+------------+--------------+
| Cant_Notas | 1er_bimestre |
+------------+--------------+
|          2 |            7 |
|          2 |            8 |
|          1 |            9 |
|          1 |           10 |
+------------+--------------+

-- SELECT COUNT(*) as Cant_Notas, n.2do_cuatrimestre FROM notas n GROUP BY n.2do_cuatrimestre HAVING n.2do_cuatrimestre < 6;
+------------+------------------+
| Cant_Notas | 2do_cuatrimestre |
+------------+------------------+
|          2 |                4 |
|          1 |                5 |
+------------+------------------+

-- D. ORDENAMIENTO (ORDER BY)
-- SELECT * FROM `cursos` ORDER BY A├▒o DESC, Division ASC;
+----------+------+----------+---------+----------------+
| ID_CURSO | A├▒o  | Division | Turno   | Numero_Alumnos |
+----------+------+----------+---------+----------------+
|        9 |    5 |        1 | Tarde   |              2 |
|       10 |    5 |        2 | Noche   |              2 |
|        7 |    4 |        1 | Tarde   |              2 |
|        8 |    4 |        2 | Noche   |              3 |
|        5 |    3 |        1 | Ma├▒ana  |              2 |
|        6 |    3 |        2 | Tarde   |              3 |
|        3 |    2 |        1 | Ma├▒ana  |              2 |
|        4 |    2 |        2 | Tarde   |              2 |
|        1 |    1 |        1 | Ma├▒ana  |              2 |
|        2 |    1 |        2 | Tarde   |              3 |
+----------+------+----------+---------+----------------+

-- SELECT * FROM `notas` ORDER BY 1er_cierre DESC, 2do_cierre DESC;
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+
| ID_NOTA | ID_ALUMNO | ID_ASIGNATURA | 1er_bimestre | 2do_bimestre | 1er_cuatrimestre | 3er_bimestre | 4to_bimestre | 2do_cuatrimestre | 1er_cierre | 2do_cierre |
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+
|       4 |         1 |             4 |           10 |           10 |               10 |            9 |           10 |                9 |          9 |       NULL |
|       3 |         1 |             3 |            8 |            9 |                8 |            6 |           10 |                8 |          8 |       NULL |
|       7 |         1 |             7 |            9 |           10 |                9 |            8 |            8 |                8 |          8 |       NULL |
|      10 |         1 |            10 |            8 |            8 |                8 |            7 |            7 |                7 |          7 |       NULL |
|       8 |         1 |             8 |            7 |            5 |                6 |            6 |            8 |                7 |          6 |       NULL |
|       6 |         1 |             6 |            6 |            5 |                5 |            7 |            7 |                7 |          6 |       NULL |
|       5 |         1 |             5 |            4 |            6 |                5 |            9 |            6 |                7 |          6 |       NULL |
|       9 |         1 |             9 |            6 |            6 |                6 |            5 |            4 |                4 |          5 |          8 |
|       2 |         1 |             2 |            7 |            6 |                6 |            5 |            5 |                5 |          5 |          5 |
|       1 |         1 |             1 |            5 |            6 |                5 |            2 |            6 |                4 |          4 |          7 |
+---------+-----------+---------------+--------------+--------------+------------------+--------------+--------------+------------------+------------+------------+

-- E. CAMPOS CALCULADOS O FUNCIONES AGREGADAS DE DOMINIO
	--1. COUNT
-- SELECT COUNT(ID_DOCENTE) FROM `docentes` WHERE 1;
+-------------------+
| COUNT(ID_DOCENTE) |
+-------------------+
|                17 |
+-------------------+

-- SELECT COUNT(ID_ALUMNO) FROM `alumnos` WHERE 1;
+------------------+
| COUNT(ID_ALUMNO) |
+------------------+
|               11 |
+------------------+

	-- 2. SUM
-- SELECT Cargo, SUM(Asistencias) FROM secretaria GROUP BY Cargo;
+----------------------+------------------+
| Cargo                | SUM(Asistencias) |
+----------------------+------------------+
| Auxiliar de limpieza |              185 |
| Guardia              |               90 |
| Portero              |               98 |
| Profesor             |             1597 |
| Rector               |              100 |
| Regente              |               96 |
| Secretario           |               80 |
| Vicerrector          |               90 |
+----------------------+------------------+

-- SELECT Nombre_completo, SUM(Licencias) FROM secretaria WHERE Cargo = "Profesor" GROUP BY Nombre_completo;
+--------------------+----------------+
| Nombre_completo    | SUM(Licencias) |
+--------------------+----------------+
| Anahi Ozores       |              5 |
| Antonio Penalba    |             12 |
| Diego Maradona     |           NULL |
| Fernando Louro     |             14 |
| Francisca Roberti  |           NULL |
| Gonzalo Mendez     |             18 |
| Ignacio Sarale     |           NULL |
| Joaquin Lozano     |           NULL |
| Julian Perez       |           NULL |
| Julieta Lizarraga  |           NULL |
| Lautaro Sosa Lanza |           NULL |
| Lionel Messi       |              8 |
| Lola Fierro        |             11 |
| Lorena Marta Roca  |           NULL |
| Rodolfo Decurgez   |              7 |
| Santino Rivero     |           NULL |
| Sofia Gomez        |             20 |
+--------------------+----------------+

	-- 3. MAX
-- SELECT MAX(1er_cierre),MAX(2do_cierre) FROM `notas` WHERE 1;
+-----------------+-----------------+
| MAX(1er_cierre) | MAX(2do_cierre) |
+-----------------+-----------------+
|               9 |               8 |
+-----------------+-----------------+

-- SELECT * FROM oficina_de_alumnos WHERE DNI=(SELECT MAX(DNI) FROM oficina_de_alumnos);
+---------------+-----------------+------+-------------------+---------------------+----------+------------------+--------------------------+----------------------------+
| LEGAJO_ALUMNO | Nombre_completo | Edad | Direccion         | Correo_electronico  | DNI      | Fecha_nacimiento | Nombre_tutor_responsable | Telefono_tutor_responsable |
+---------------+-----------------+------+-------------------+---------------------+----------+------------------+--------------------------+----------------------------+
|             1 | Federico Santos |   12 | Monte Castro 3600 | fedesanto@gmail.com | 56456896 | 2012-03-17       | Maria Santos             |                   11030417 |
+---------------+-----------------+------+-------------------+---------------------+----------+------------------+--------------------------+----------------------------+

	-- 4. MIN
-- SELECT * FROM `secretaria` WHERE Ficha_censal = (SELECT MIN(Ficha_censal) FROM secretaria);
+-----------------+----------+------------------+------+----------------+--------------------+----------+----------+--------------+--------------+-----------+-------------+
| LEGAJO_PERSONAL | Cargo    | Nombre_completo  | Edad | Direccion      | Correo_electronico | Telefono | DNI      | Fecha_inicio | Ficha_censal | Licencias | Asistencias |
+-----------------+----------+------------------+------+----------------+--------------------+----------+----------+--------------+--------------+-----------+-------------+
|               6 | Profesor | Rodolfo Decurgez |   66 | Baigorria 7894 | Dec@gmail.com      | 11324689 | 23256012 | 1995-11-09   |        10379 |         7 |          93 |
+-----------------+----------+------------------+------+----------------+--------------------+----------+----------+--------------+--------------+-----------+-------------+

-- SELECT MIN(1er_cierre) FROM `notas` WHERE 1;
+-----------------+
| MIN(1er_cierre) |
+-----------------+
|               4 |
+-----------------+

	-- 5. AVG
-- SELECT AVG(1er_cierre) FROM `notas` WHERE 1;
+-----------------+
| AVG(1er_cierre) |
+-----------------+
|          6.4000 |
+-----------------+

-- SELECT AVG(Edad) FROM `secretaria` WHERE 1;
+-----------+
| AVG(Edad) |
+-----------+
|   44.0000 |
+-----------+

-- F. INNER JOIN
-- SELECT s.Nombre_completo, a.Nombre_asignatura FROM secretaria s INNER JOIN docentes d ON s.LEGAJO_PERSONAL = d.ID_DOCENTE INNER JOIN asignaturas a ON d.ID_DOCENTE = a.ID_DOCENTE WHERE s.Cargo = "profesor";
+--------------------+-------------------+
| Nombre_completo    | Nombre_asignatura |
+--------------------+-------------------+
| Ignacio Sarale     | Lengua            |
| Ignacio Sarale     | Fisica            |
| Rodolfo Decurgez   | Historia          |
| Rodolfo Decurgez   | Ingles            |
| Francisca Roberti  | Matematica        |
| Francisca Roberti  | Ingles            |
| Lorena Marta Roca  | Fisica            |
| Anahi Ozores       | Matematica        |
| Anahi Ozores       | Historia          |
| Anahi Ozores       | Civica            |
| Julian Perez       | Civica            |
| Lola Fierro        | Historia          |
| Lautaro Sosa Lanza | Biologia          |
| Joaquin Lozano     | Biologia          |
| Joaquin Lozano     | Ingles            |
| Lionel Messi       | Educacion fisica  |
| Gonzalo Mendez     | Geografia         |
| Fernando Louro     | Quimica           |
| Antonio Penalba    | Lengua            |
| Antonio Penalba    | Geografia         |
| Antonio Penalba    | Educacion fisica  |
+--------------------+-------------------+

-- SELECT o.Nombre_completo, c.A├▒o, c.Division FROM oficina_de_alumnos o INNER JOIN alumnos a ON o.LEGAJO_ALUMNO = a.LEGAJO_ALUMNO INNER JOIN cursos c ON a.ID_CURSO = c.ID_CURSO ORDER BY A├▒o ASC;
+-------------------+------+----------+
| Nombre_completo   | A├▒o  | Division |
+-------------------+------+----------+
| Francisco Pecile  |    1 |        2 |
| Federico Santos   |    1 |        1 |
| Fatima Sosa       |    2 |        1 |
| Macarena Rivero   |    2 |        2 |
| Lucas Santos      |    3 |        2 |
| Manuel Louro      |    3 |        1 |
| Miguel Louro      |    3 |        1 |
| Marco Lozano      |    4 |        2 |
| Lucia Leanza      |    4 |        1 |
| Alejandro Peralta |    4 |        1 |
| Damian Fontan     |    5 |        2 |
+-------------------+------+----------+

-- G. SUBCONSULTAS
--  SELECT s.Nombre_completo FROM secretaria s WHERE s.LEGAJO_PERSONAL IN ( SELECT a.ID_DOCENTE FROM asignaturas a GROUP BY a.ID_DOCENTE HAVING COUNT(a.ID_ASIGNATURA) > 1 );
+---------------------+
| Nombre_completo     |
+---------------------+
| Pedro Kafka         |
| Maria Mariana Lanza |
| Ignacio Sarale      |
| Rodolfo Decurgez    |
| Francisca Roberti   |
| Anahi Ozores        |
| Joaquin Lozano      |
| Antonio Penalba     |
+---------------------+

--  SELECT o.Nombre_completo FROM oficina_de_alumnos o WHERE o.LEGAJO_ALUMNO IN(SELECT a.LEGAJO_ALUMNO FROM alumnos a WHERE a.ID_CURSO IN (SELECT c.ID_CURSO FROM cursos c WHERE c.Numero_Alumnos > 30));


-- H. 
	-- I. CURSORES
-- DELIMITER //
CREATE PROCEDURE calcular_promedios()
BEGIN
    DECLARE alumno_id INT;
    DECLARE asignatura_id INT;
    DECLARE promedio FLOAT;
    DECLARE fin INT DEFAULT 0;
    DECLARE cur CURSOR FOR SELECT n.ID_ALUMNO, n.ID_ASIGNATURA, (1er_cuatrimestre + 2do_cuatrimestre) / 2 AS promedio FROM notas n; 
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    OPEN cur;
    ciclo: LOOP
        FETCH cur INTO alumno_id, asignatura_id, promedio;
        IF fin = 1 THEN
            LEAVE ciclo;
        END IF;
        SELECT alumno_id, asignatura_id, promedio;
    END LOOP;   
    CLOSE cur;
END //
DELIMITER ;

CALL calcular_promedios();

+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             1 |      4.5 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             2 |      5.5 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             3 |        8 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             4 |      9.5 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             5 |        6 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             6 |        6 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             7 |      8.5 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             8 |      6.5 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |             9 |        5 |
+-----------+---------------+----------+
+-----------+---------------+----------+
| alumno_id | asignatura_id | promedio |
+-----------+---------------+----------+
|         1 |            10 |      7.5 |
+-----------+---------------+----------+


-- DELIMITER //

CREATE PROCEDURE promedio_asistencias_docente()
BEGIN
    
    DECLARE total_asistencias INT DEFAULT 0;
DECLARE cantidad_docentes INT DEFAULT 0;
    DECLARE promedio INT;
    DECLARE asistencia_actual INT;
    DECLARE fin INT DEFAULT 0;
	
    DECLARE cursor_asistencias CURSOR FOR
    SELECT s.Asistencias
    FROM SECRETARIA s
    INNER JOIN DOCENTES d ON s.LEGAJO_PERSONAL = d.LEGAJO_PERSONAL;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    OPEN cursor_asistencias;
    ciclo:LOOP
        FETCH cursor_asistencias INTO asistencia_actual;
        IF fin THEN
            LEAVE ciclo;
        END IF;
        SET total_asistencias = total_asistencias + asistencia_actual;
        SET cantidad_docentes = cantidad_docentes + 1;
    	END LOOP ciclo;
        SET promedio = total_asistencias / cantidad_docentes;
    SELECT promedio AS promedio_asistencias_docente;
    CLOSE cursor_asistencias;
END //
DELIMITER ;

CALL promedio_asistencias_docente();
+------------------------------+
| promedio_asistencias_docente |
+------------------------------+
|                           94 |
+------------------------------+


	-- II. PROCEDIMIENTOS ALMACENADOS CON Y SIN PARAMETROS
-- 


-- 


	-- III. FUNCIONES ALMACENADAS
-- 


-- 


	-- IV. VISTAS Y SUS POSIBLES USOS
-- 


-- 


	-- V. CREACION DE USUARIOS Y USO DE PRIVILEGIOS
-- 


-- 


	-- VI. TRIGGERS
-- 
DELIMITER //
CREATE TRIGGER actualizar_numero_alumnos AFTER INSERT ON ALUMNOS FOR EACH ROW
BEGIN
    UPDATE CURSOS
    SET Numero_Alumnos = Numero_Alumnos + 1 WHERE ID_CURSO = NEW.ID_CURSO;
END //
DELIMITER ;


--
DELIMITER //
CREATE TRIGGER actualizar_numero_alumnos_delete AFTER DELETE ON alumnos FOR EACH ROW
BEGIN
    UPDATE CURSOS
    SET Numero_Alumnos = Numero_Alumnos - 1 WHERE ID_CURSO = OLD.ID_CURSO;
END //
DELIMITER ;
