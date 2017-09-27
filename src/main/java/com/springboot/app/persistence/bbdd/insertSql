INSERT INTO piezas ( `codigo`, `nombre`,`color`,`precio`, `peso`,`ciudad`) 
SELECT SUBSTRING(MD5(RAND()) FROM 1 FOR 6), 
		 concat( 
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97)
),
       (SELECT color FROM piezas ORDER BY RAND() limit 1),
        round( rand() * 100),
        round( rand() * 10),
       (SELECT  ciudad FROM proveedores ORDER BY RAND() LIMIT 1) 
FROM piezas; 
