# PA2024-Cazan-Rares

Laboratorul 2:

1) Compulsory:
   Am creat cate o clasa pentru client, vehicle, depot si client type(in care sa afla enum-ul pentru tipurile de
   clienti). Pentru fiecare am creat cate un constructor, gettere si settere, pentru a seta si prelua valori ale
   obiectelor create. De asemenea, implementat pentru fiecare clasa functia toString. Toate acestea le-am realizat cu
   feature-urile IDE-ului. In final, am creat obiectele, am adaugat valori cu ajutorul setterelor si am afisat toate
   obietele in consola.
2) Homework:
   La clasele realizate am adaugat clasele Tour Problem Solution, am facut clasa Vehicle abstracta si apoi am adaugat
   clasele Drones si Trucks care extind clasa Vehicle. AM scris metoda equals pentru clasele cerute, careia i-am dat
   override, apoi am implementat metoda getVehicles care va capta si va returna lista de vehicule. In final am realizat
   algoritmul greedy in clasa principala a temei in care am alocat clientii vehiculelor parcurgand clientii apoi
   vehiculele, generam un timp random si verificam daca vehiculul respectiv poate ajunge la client. Ruland, observam ca
   meru ne va da un raspuns diferit, alocarea de timp fiind random. La sfarsit am adaugat comentariile necesare si am
   generat documentatia java.
3) Bonus:
   Am facut o functie pentru a initializa matricea de distanta in care calculam distantele bazate pe matricea de grid
   construita in main. Am luat o lista pentru pozitiile depozitelor si clientilor pentru ca la fiecare rulare a
   programului sa obtinem o matrice random. Dupa ce au fost amestecate le vom seta pentru clienti si depozite, in care
   valoarea -1 reprezinta un depozit iar orice alta valoare un client(ceea ce va fi si costul pentru a ajunge in acel
   nod). Parcurgem matricea si daca intalnim -1 initializam depozitele si vehiculele la pozitiile de start, iar daca
   intalnim alta valoare initializam un client pe acea pozitie. Afisam matricea si numarul de clienti si depozite,
   initializam matricea de distanta si apoi aplicam algoritmul lui Floyd-Warshall pentru a gasi distantele minime intre
   toate nodurile. In final, folosim cel mai scurt drum pentru a aloca lientii la vehicule iterand peste fiecare client
   si peste fiecare vehicul, si uptatand cel mai bun candidat prin calcularea costului de deplasare depou-client
   client-client. Afisam clientii si vehiculele asignate acestora.