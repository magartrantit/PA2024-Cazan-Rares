# PA2024-Cazan-Rares

## Homework + Compulsory

1. `Main.java`:
    - `main(String[] args)`: Aceasta este metoda principală a programului. Ea generează o listă de destinații comune,
      apoi creează un număr de șoferi și pasageri cu destinații aleatoare, unele dintre acestea fiind comune. Apoi,
      filtrează șoferii și pasagerii, setează vârsta aleatorie pentru șoferi și îi sortează pe șoferi și pasageri. În
      final, asociază șoferii cu pasagerii în funcție de destinațiile lor.

2. `Person.java`:
    - `Person(String name, String destination)`: Constructorul clasei `Person`. Inițializează numele și destinația unei
      persoane.
    - `getDestination()`: Returnează destinația unei persoane.
    - `getAge()`: Returnează vârsta unei persoane.
    - `setAge(int age)`: Setează vârsta unei persoane.
    - `getName()`: Returnează numele unei persoane.
    - `compareTo(Person other)`: Compară această persoană cu o altă persoană în funcție de nume.

3. `Driver.java`:
    - `Driver(String name, String destination, List<String> destinations)`: Constructorul clasei `Driver`. Inițializează
      numele, destinația și lista de destinații ale unui șofer.
    - `getDestination()`: Returnează destinația unui șofer.
    - `getDestinations()`: Returnează lista de destinații ale unui șofer.
    - `getName()`: Returnează numele unui șofer.
    - `getAge()`: Returnează vârsta unui șofer.
    - `setPassenger(Passenger passenger)`: Asociază un pasager cu acest șofer.
    - `getPassenger()`: Returnează pasagerul asociat acestui șofer.

4. `Passenger.java`:
    - `Passenger(String name, String destination)`: Constructorul clasei `Passenger`. Inițializează numele și destinația
      unui pasager.
    - `getDestination()`: Returnează destinația unui pasager.

5. `Problem.java`:
    - `Problem(List<Driver> drivers, List<Passenger> passengers)`: Constructorul clasei `Problem`. Inițializează listele
      de șoferi și pasageri.
    - `matchDriversAndPassengers()`: Asociază șoferii cu pasagerii în funcție de destinațiile lor și returnează o mapă
      cu aceste asocieri.

## Bonus