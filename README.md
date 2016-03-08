# ChessChalenge
A desktop game based on Chess. It has three game modes: normal game (a normal game of chess), the fast game (a chess game without turns) and the HP mode (each player has 10 health points and at any time a piece dies you lose an amount of hp. That way you can lose with your king alive). Before you play you have to register and there's only online matches.
All the code is writen in Java with the MySQL as database.</br>
The code is divided in four small projects plus one folder of extensions</br>
ChessGame folder: it has the game itself, inside it you can find a class named Game that works as a framework to build different modes inside.</br>
ChessGameServer folder: it has the server side of the game, managing matchmaking, registering in the database and managing games.</br>
ChessLibrary folder: it has the a set of chess classes, like board, queen and pawn.</br>
ChessWeb folder: it has the set of classes responsible for the communication between the client and the server.</br>
This project was created in Netbeans IDE.</br>
The main goal of this project was to develop software engineering skills as well as learning new stuff such as database and server client communication.
