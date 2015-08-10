TASK #1 
– CHECK IF FILE EXISTS 
Napraviti jedan server koji za klijenta provjerava da li dati file na serverovom racunaru postoji. 
Nije potrebno uraditi GUI za ovaj zadatak. 
PRIMJER
Ukoliko klijent posalje serveru String „C:/Users/Neko/Desktop/text.txt“ i ukoliko server IMA taj file
u tom direktoriju onda server odgovara sa 1, a ukoliko taj file ne postoji onda odgovara sa 0. 
 
TASK #2
– THREE THREADS OF ONE CLASS 
Napraviti tri Thread-a. Prvi isprinta brojeve od 1 do 10, sa pauzom od 200 [ms] izmedju svakog broja. 
Drugi isprinta cetiri puta „BitCamp“ sa pauzom od 1000 [ms], a treci isprinta pet Random brojeva u rasponu od 1 do 5
sa pauzom od 700 [ms] izmedju svakog. 
Treci Thread krece sa radom kada zavrsi drugi, a drugi krece sa radom kada zavrsi prvi. 
Kada svi zavrse zatvara se program. 
Sva tri Thread-a su bazirani na samo jednoj klasi!
  
TASK #3 
– INTERRUPTING A THREAD (GUI) 
Napraviti GUI aplikaciju koja ima jedan JLabel i jedan JButton. JLabel je na pocetku prazan, ali nakon svake sekunde 
dobija jedno po jedno slovo abecede, pa tako nakon tri sekunde JLabel ce imati u sebi „abc“, 
a nakon pet ce imati „abcde“. Klikom na dugme se zaustavi taj proces, ali ne i aplikacija.
 
Koristiti vlastite Thread-ove za ovaj zadatak! Niposto ne koristiti glavni Thread za JLabel!
  
TASK #4 
– HTTP IMAGE SERVER 
Napraviti HTTP server kojem klijent daje (upload-uje) sliku u obliku niza byte-ova. Server kod sebe spasava tu sliku 
i daje joj proizvoljno ime (moze biti nasumicno, moze se generisati na osnovu ip adrese i vremena kada je poslata slika). 
Nakon uspjesnog prebacivanja slike na server, na stranici se pojavljuje link na tu sliku tako da korisnik može otvoriti 
stranicu gdje se nalazi ta slika.
 
PRIMJER Server prima sliku od klijenta i generise joj ime 2034317.jpg. Na stranici servera (HTTP protokol) pojavi se novi 
link koji vodi na stranicu, ukoliko je lokalni racunar, localhost/2034317 i tu se pojavi postavljena slika.
  