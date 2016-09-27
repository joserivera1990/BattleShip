# BattleShip
Batalla Naval

El juego de Batlla Naval se desarrolla en un tablero de 10 x 10. En él se colocan 5 barcos, cada uno con un tamaño específico, representado en el número de celdas que ocupa. Los barcos son: Portaaviones (5), Acorazado (4), Submarino (3), Destructor (3), Bote (2) El jugador debe hundir los barcos en el menor número de intentos. Si un jugador esconde una celda donde se encuentra parte de un barco, realiza un impacto sobre él. Una vez que todas las celdas que ocupa un barco han sido impactadas, el barco se hunde.
Desarrollo
Queremos hacer una versión digital para un jugador. El tablero inicial se puede ver así:

  ABCDEFGHIJ
 +---------
0|~~~~~~~~~
1|~~~~~~~~~
2|~~~~~~~~~
3|~~~~~~~~~
4|~~~~~~~~~
5|~~~~~~~~~
6|~~~~~~~~~
7|~~~~~~~~~
8|~~~~~~~~~
9|~~~~~~~~~

Cuando un barco ha sido impactado, la celda se como una X. Una vez que un barco ha sido hundido, todas las celdas que ocupa se ven por la primera letra del barco: P, A, S, D o B. Una celda impactada que no tiene un barco se como un .

  ABCDEFGHIJ
 +---------
0|~~~~~~~~~
1|~~~~~~~~~
2|~~~...~~~
3|~SSS~~~~~
4|~~~~~~~~~
5|~~~~~..~~
6|~~~~X~~~~
7|~~~~X~~~~
8|~~~~~~~~~
9|~~~~~~~~.
