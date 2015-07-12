TASK 1
Napisati klasu koja opisuje jednu kasu. Kasa sadrži:
 Atribut (private) koji opisuje ime, npr. “Moja kasa”, “Za more”, “Crni fond”, itd.
 Atribut (private) koji opisuje trenutnu sumu novca u kasi
 Konstruktor koji inicijalizira ime objekta (ne i trenutnu sumu novca)
 Metoda koja dodaje novac u kasu, npr. dodaj 20 u kasu bi bilo addMoney(20)
 Metoda koja vadi sav novac iz kase, npr. ako je bilo 20 onda æe postati 0
 Metoda koja ispisuje koliko novca ima u kasi na sljedeæi naèin:
 Ako nema nikako onda ispisuje “It is empty...”
 Ako ima izmeðu 1 i 20 ispisuje “There’s some, but not much.”
 Ako ima izmeðu 21 i 100 ispisuje “There’s some.”
 Ako ima 101 ili više onda ispisuje “There’s a lot.”
PRIMJER
Safe s = new Safe(„Crni fond“);
s.printInformation(); // Isprinta „It is empty...“
s.addMoney(30); // Doda 30 KM u kasu
s.printInformation(); // Isprinta „There's some.“
s.addMoney(100);
s.printInformation(); // Isprinta „There's a lot.“
s.clear(); // Isprazni sef/kasu
s.printInformation(); // Isprinta „It is empty...“
TASK 2
Napisati klasu koja opisuje jednu životinju. Životinju opisuju sljedeæi atributi:
 Atribut (private) koji opisuje ime životinje
 Atribut (private) koji opisuje da li je životinja aktivna danju ili noæu
 Vrijednost 1 znaèi da je životinja aktivna danju
 Vrijednost 2 znaèi da je životinja aktivna noæu
 Atribut (private) koji opisuje koliko je životinji potrebno vode
 Vrijednost 1 znaèi da je životinji potrebno malo vode
 Vrijednost 2 znaèi da je životinji potrebno više vode
 Vrijednost 3 znaèi da je životinji potrebno mnogo vode
  Napraviti konstruktor koji inicijalizira ta tri atributa
Pored toga, sve te životinje dijele isto stanište. Stanište je potrebno predstaviti u istoj klasi kao i životinje,
tj. bez korištenja dodatnih klasa. To stanište je opisano sa dvije varijable:
 Da li je noæ ili dan (private) koje je po default-u 1
 Vrijednost 1 znaèi da je dan
 Vrijednost 2 znaèi da je noæ
 Koliko vode ima stanište (private) koje je po default-u 1
 Vrijednost 0 znaèi da stanište nema vode
 Vrijednost 1 znaèi da stanište posjeduje malo vode
 Vrijednost 2 znaèi da stanište posjeduje više vode
 Vrijednost 3 znaèi da stanište posjeduje mnogo vode
Životinje imaju samo jednu metodu:
 Isprintati kakvo je trenutno stanje životinje
 Ukoliko doba dana odgovara životinji i ona ima dovoljno vode za sebe
 Isprintati “It’s fine. The animal is active and has water.”
 Ukoliko doba dana odgovara, ali nema dovoljno vode
 Isprintati “The animal is active, but does not have enough water.”
 Ukoliko doba dana ne odgovara, ali ima dovoljno vode
 Isprintati “The animal is not active, but has enough water.”
 Ukoliko doba dana ne odgovara, niti ima dovoljno vode
 Isprintati “The animal is not active and it does not have enough water.”
Postoji još jedna metoda koja utièe na stanište:
 Promijeni doba dana
 Ako je bila noæ onda postaje dan (nakon poziva metode)
 Ako je bio dan onda postaje noæ (nakon poziva metode)
 Promijeni koliko vode trenutno ima (static set metoda)
PRIMJER
Animal a1 = new Animal(„Animal 1“, 1, 1);
Animal a2 = new Animal(„Animal 2“, 2, 3);
// „It’s fine. The animal is active and has water.”
a1.printStatus();
// “The animal is not active and it does not have enough water.”
a2.printStatus();
Animal.cycleDayNight(); // Dan prelazi u noæ
Animal.setAmountOfWater(3); // Sada vrijednost vode prelazi na 3
// “The animal is not active, but has enough water.”
a1.printStatus();
// “It’s fine. The animal is active and has water.”
a2.printStatus();