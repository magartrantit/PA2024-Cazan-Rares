# Proiectul PA2024-Cazan-Rares

## Homework + Compulsory

1) `Attraction`: Aceasta este o clasă abstractă care reprezintă o atracție turistică. Fiecare atracție are un nume.

2) `Statue`, `Church`, `Concert`: Acestea sunt clase care extind clasa `Attraction` și implementează interfețele `Visitable` și `Payable`. Acestea reprezintă diferite tipuri de atracții turistice care pot fi vizitate și pentru care se poate plăti un bilet.

3) `Visitable`: Aceasta este o interfață care definește metode pentru a obține programul de vizitare al unei atracții.

4) `Payable`: Aceasta este o interfață care definește metode pentru a obține și a seta prețul unui bilet la o atracție.

5) `TimeInterval`: Aceasta este o clasă care reprezintă un interval de timp, folosit pentru a defini programul de vizitare al unei atracții.

6) `TravelPlan`: Aceasta este o clasă care reprezintă un plan de călătorie. Un plan de călătorie conține o mapare între zilele săptămânii și atracțiile care vor fi vizitate în acele zile.

7) `Trip`: Aceasta este o clasă care reprezintă o călătorie. O călătorie conține o listă de atracții care vor fi vizitate.

8) `Lab3Compulsory`: Aceasta este clasa principală a proiectului. Aici sunt create obiecte de tip `Attraction` și sunt afișate pe ecran.

    -În clasa `Lab3Compulsory`, se creează mai multe obiecte de tip `Attraction` (adică `Statue`, `Church`, `Concert`). Pentru fiecare atracție, se setează numele, descrierea, prețul biletului și programul de vizitare.

    -Apoi, atracțiile sunt sortate după nume și afișate pe ecran.

    -După aceea, se afișează atracțiile care pot fi vizitate, dar pentru care nu se poate plăti un bilet.

    -În final, se creează un `TravelPlan` și se adaugă atracțiile la acesta pe zilele corespunzătoare. Planul de călătorie este apoi afișat pe ecran.

## Bonus

Sunt implementate două euristici de colorare a grafurilor, o interfata pentru acestea si o clasa pentru reprezentarea grafului:

1) `DegreeDescendingHeuristic`: Această euristică colorează nodurile în ordinea descrescătoare a gradului lor. Gradul unui nod este numărul de muchii pe care le are.

2) `DSaturHeuristic`: Această euristică colorează nodurile în ordinea descrescătoare a gradului lor de saturație (DSatur). DSatur al unui nod este numărul de culori diferite utilizate de vecinii săi.

3) `Graph`: Aceasta este o clasă care reprezintă un graf. Un graf conține o listă de adiacență care maparează fiecare nod la lista sa de noduri adiacente.

4) `ColoringHeuristic`: Aceasta este o interfață care definește o metodă applyColoring pentru colorarea nodurilor unui graf.
Ambele euristici utilizează un algoritm lacom pentru a colora nodurile, atribuind prima culoare disponibilă fiecărui nod.

În clasa `Lab3Compulsory`, se creează un obiect `Graph` și se adaugă muchii între atracții. Apoi, se aplică `DegreeDescendingHeuristic` și `DSaturHeuristic` pe graf, iar colorările rezultate sunt afișate în consolă.

Colorările sunt reprezentate ca hărți, cu atracțiile ca chei și culorile ca valori. Culorile sunt reprezentate ca numere întregi, cu diferite numere întregi reprezentând diferite zile ale călătoriei.