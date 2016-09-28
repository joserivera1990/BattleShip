# BattleShip
Batalla Naval

El juego de Batlla Naval se desarrolla en un tablero de 10 x 10. En él se colocan 5 barcos, cada uno con un tamaño específico, representado en el número de celdas que ocupa. Los barcos son: Portaaviones (5), Acorazado (4), Submarino (3), Destructor (3), Bote (2) El jugador debe hundir los barcos en el menor número de intentos. Si un jugador esconde una celda donde se encuentra parte de un barco, realiza un impacto sobre él. Una vez que todas las celdas que ocupa un barco han sido impactadas, el barco se hunde.
Desarrollo
Queremos hacer una versión digital para un jugador. El tablero inicial se puede ver así:

  ABCDEFGHIJ<br>
 +---------<br>
0|~~~~~~~~~<br>
1|~~~~~~~~~<br>
2|~~~~~~~~~<br>
3|~~~~~~~~~<br>
4|~~~~~~~~~<br>
5|~~~~~~~~~<br>
6|~~~~~~~~~<br>
7|~~~~~~~~~<br>
8|~~~~~~~~~<br>
9|~~~~~~~~~<br>

Cuando un barco ha sido impactado, la celda se como una X. Una vez que un barco ha sido hundido, todas las celdas que ocupa se ven por la primera letra del barco: P, A, S, D o B. Una celda impactada que no tiene un barco se como un .

  ABCDEFGHIJ<br>
 +---------<br>
0|~~~~~~~~~<br>
1|~~~~~~~~~<br>
2|~~~...~~~<br>
3|~SSS~~~~~<br>
4|~~~~~~~~~<br>
5|~~~~~..~~<br>
6|~~~~X~~~~<br>
7|~~~~X~~~~<br>
8|~~~~~~~~~<br>
9|~~~~~~~~.<br>
