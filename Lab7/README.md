# PA2024-Cazan-Rares

## Tema + Compulsory

1. `Main.java`:  
   -main(String[] args): Aceasta este metoda principală a programului. Inițializează un joc cu 10 jetoane, creează doi
   jucători, îi adaugă la joc și începe jocul.
2. `Game.java`:  
   -Game(int n): Constructorul clasei Game. Inițializează jocul cu un sac de n jetoane.
   -play(): Această metodă începe jocul. Începe un fir pentru fiecare jucător și un fir de cronometru. Apoi verifică în
   mod continuu dacă sacul este gol sau dacă scorul unui jucător a ajuns la n, și oprește jocul dacă se îndeplinește una
   dintre aceste condiții.
   -stopGame(): Această metodă oprește jocul. Calculează și afișează timpul scurs, oprește toți jucătorii și afișează
   câștigătorul jocului și scorul acestuia.
3. `Player.java`:  
   -Player(String name): Constructorul clasei Player. Inițializează un jucător cu un nume.
   -run(): Această metodă este apelată când firul jucătorului este pornit. Extrage în mod continuu plăci din sac și le
   adaugă la secvențele jucătorului până când jocul este oprit.
   -stop(): Această metodă oprește firul jucătorului.
4. `TimeKeeper.java`:  
   -TimeKeeper(Game game, long timeLimit): Constructorul clasei TimeKeeper. Inițializează un cronometru cu o referință
   la joc și un limită de timp.
   -run(): Această metodă este apelată când firul cronometrului este pornit. Verifică în mod continuu dacă limita de
   timp a fost depășită și oprește jocul dacă a fost.
5. `Bag.java`:  
   -Bag(int n): Constructorul clasei Bag. Inițializează un sac cu n perechi de jetoane.
   -extractTile(): Această metodă extrage un jeton din sac.
6. `Pair.java`:
   -Pair(T first, U second): Constructorul clasei Pair. Inițializează o pereche cu două valori.