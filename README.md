# PA2024-Cazan-Rares

1) Laboratorul 1:
    -Compulsory:
     In functia main am implementat iterativ, pe rand, cerintele problemei. In final am obtinut rezultatul corect, afisat in consola.
    -Homework:
     Am realizat o functie care sa verifice daca un numar este k-reductibil, in care adun fiecare cifra inmultita cu ea insasi intr-un parametru 'sum', care va fi noul 'n', asta pana cand obtinem un numar format dintr-o singura cifra si returnam adevarat sau fals daca este sau nu egal cu 'k'. In functia main calculam in nanosecunde de cand este pornit programul si verificam si afisam numerele k-reductibile dintr-un interval dat in concola. Dupa ce rulam programul in modul cerut obtinem numerele k-reductibile din intervalul [100, 200] (exemplul rulat de mine) si timpul de rulare al aplicatiei, si anume:
   Numerele 1 reductibile din intervalul [ 100, 200 ]:
100 103 109 129 130 133 139 167 176 188 190 192 193 
Timp de executie: 127500
    -Bonus:
     Construim mai intai matricea de adiacenta astfel: am ales ca nodul cu numarul n-1 sa fie cel din mijloc iar celelalte de la 0 la n-2 sa fie pe marginea exterioara. Mai intai facem conexiunile nodului din mijloc cu cele de pe exterior, si invers in matrice, iar apoi fiecare nod de pe margine va fi adiacent cu urmatorul dupa el si cu cel anterior, in cazul in care nodul este 'n-2' vom realiza legatura acestuia cu nodul 0, pentru ca matricea sa fie corecta. Vom afisa matricea si observam ca este corecta ( am luat un graf de 5 noduri ca exemplu):
0 1 0 1 1 
1 0 1 0 1 
0 1 0 1 1 
1 0 1 0 1 
1 1 1 1 0
     Strabatem mai apoi un for de la 3 la n pentru a identifica fiecare cicluri de 'i' noduri si vom creea fiecare ciclu incepand si terminandu-se cu nodul din mijlocul "rotii" (in cazul nostru nodul 4). In interiorul ciclului vom pune restul de noduri pe rand astfel incat sa le obtinem pe toate. Vom avea un caz special pentru ciclul format din toate nodurile de pe marginea exterioara care este tratat mai jos. Afisam toate ciclurile si numarul lor, verificand la final ca obtinem un rezultat corect (13).
