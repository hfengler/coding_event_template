# Minesweeper
Haben Sie jemals Minesweeper gespielt? Es ist ein süßes kleines Spiel, das in einem bestimmten Betriebssystem enthalten ist, dessen Namen wir uns nicht merken können.
Nun, das Ziel des Spiels ist es, alle Minen in einem MxN-Feld zu finden.
Um dir dabei zu helfen, zeigt das Spiel eine Zahl in einem Feld an, die dir sagt, wie viele Minen an dieses Feld angrenzen.
Nehmen wir zum Beispiel das folgende 4x4-Feld mit 2 Minen (die durch ein *-Zeichen dargestellt werden):
*...
....
.*..
....

Das gleiche Feld mit den oben beschriebenen Hinweisnummern würde wie folgt aussehen:

*100
2210
1*10
1110

Das Kata

Schreibe ein Programm, welches für ein gegebenes m*n großes Feld, welches anzeigt, an welchen Stellen sich die Bomben befinden, das Feld inklusive der Hinweisnummern zurückgibt. Nutze dazu geeignete Datentypen, um das Minenfeld zu modellieren und achte auf saubere TDD Praktiken.