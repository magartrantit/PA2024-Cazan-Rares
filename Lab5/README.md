# PA2024-Cazan-Rares

## Homework + Compulsory

1. `Main.java`: Acesta este punctul de intrare al aplicației. Creează instanțe ale `Person`, `Document`, `Repository`
   și `DocumentManager`. De asemenea, creează directoare pentru fiecare persoană, adaugă documente în aceste directoare
   și afișează conținutul depozitului. În final, începe un shell pentru interacțiunea cu utilizatorul.

2. `ViewCommand.java`: Această clasă implementează interfața `Command` și este utilizată pentru a vizualiza un document
   specific. Folosește `DocumentManager` pentru a localiza documentul și clasa `Desktop` pentru a-l deschide.

3. `DocumentManager.java`: Această clasă este responsabilă pentru gestionarea documentelor. Poate crea directoare pentru
   fiecare persoană și poate adăuga documente în aceste directoare.

4. `Person.java`: Această clasă reprezintă o persoană cu un nume și un ID unic.

5. `Document.java`: Această clasă reprezintă un document cu un nume, format și conținut.

6. `Repository.java`: Această clasă reprezintă un depozit care stochează documente. Poate afișa conținutul depozitului.

7. `Shell.java`: Această clasă oferă un shell pentru interacțiunea cu utilizatorul. Începe o buclă care așteaptă
   intrarea utilizatorului și execută comenzi.

8. `ExportCommand.java`: Această clasă implementează interfața `Command` și este utilizată pentru a exporta documentele
   din depozit într-un fișier JSON. Metoda `execute()` a acestei clase scrie conținutul depozitului într-un
   fișier `repository.json` folosind biblioteca Jackson pentru serializarea obiectelor Java în JSON.

9. `Command.java`: Aceasta este o interfață care definește o singură metodă, `execute()`. Toate comenzile din aplicație
   implementează această interfață și oferă o implementare pentru metoda `execute()`.

10. `ReportCommand.java`: Această clasă implementează interfața `Command` și este utilizată pentru a genera un raport al
    documentelor din depozit. Metoda `execute()` a acestei clase accesează documentele din depozit și generează un
    raport folosind o clasă de raportare corespunzătoare.

## Bonus

### Încărcarea abilităților și găsirea grupurilor maxime

Au fost implementate două metode suplimentare în clasa `Repository` pentru a gestiona cerințele specifice.

#### Metoda loadAbilities

Metoda `loadAbilities` este utilizată pentru a încărca abilitățile fiecărei persoane dintr-un fișier Excel
numit `Lab7.xlsx` din directorul principal. Biblioteca Apache POI este utilizată pentru a citi acest document Microsoft.

Metoda parcurge fiecare rând în foaia Excel, sărind peste primul rând, deoarece se presupune că este antetul. Pentru
fiecare rând, preia ID-ul și abilitățile persoanei, creează un obiect `Person` și adaugă persoana și abilitățile sale în
harta `personAbilities`.

#### Metoda findMaximalGroups

Metoda `findMaximalGroups` este utilizată pentru a găsi toate grupurile maxime de persoane astfel încât oricare doi
angajați dintr-un grup să aibă cel puțin o abilitate comună. Aceasta se bazează pe datele încărcate de
metoda `loadAbilities`.

Metoda parcurge fiecare persoană din harta `personAbilities`. Pentru fiecare persoană, verifică dacă poate fi adăugată
la un grup existent (adică dacă toate persoanele din grup au cel puțin o abilitate comună cu persoana). Dacă persoana
poate fi adăugată la un grup existent, este adăugată. Dacă nu, se creează un nou grup cu persoana.

Metoda returnează o listă cu toate grupurile maxime găsite.
