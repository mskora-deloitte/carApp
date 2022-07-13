# carApp

Istnieje następujący opis dziedzinowy:

  Firma wypożyczająca samochody posiada wiele placówek. Każda z placówek znajduje się pod jakimś adresem i posiada jakieś dane kontaktowe. 
  W każdej z fili pracuje conajmniej kilku pracowników. Pracownik może zajmować jedno z kilku stanowisk (sprzedawca, kierownik, księgowy). 
  Firma posiada bazę klientów. Przechowywane są dane takie jak miejsce zamieszkania, data urodzenia, nr telefonu, numer karty kredytowej, itp. 
  Firma posiada też bazę samochodów wraz z danymi idetyfikacyjnymi (typ, marka, rok produkcji, kolor, pojemność silnika, moc oraz przebieg). 
  Ważne jest, aby system przechowywał pełne informacje o wypożyczeniach. Wiedział jaki klient i w jakim terminie wypożyczył konkretny samochód. 
  W której placówce go odebrał i w której oddał oraz jaka była kwota pożyczki. Dodatkowo każdy z samochodów z wypożyczalni może mieć kilku 
  opiekunów (pracowników, którzy dbają o samochód - kontrolują przeglądy itp.), a także każdy pracownik może sprawować opiekę nad wieloma samochodami.

Zadania:

1.  Stworzyć model obiektowy JPA (czyli encje i relacje miedzy nimi) (ręcznie, bez użycia generatorów)

2.  Stworzyć serwisy i DAO do: 

    2.1.  Obsługi Samochodów (Dodaj samochód, Usuń samochód, Zmień dane samochodu, Przypisz do 
          opiekuna, wyszukaj po typie i marce, wyszukaj po opiekunie)

    2.2.  Obsługi Placówek (Dodaj placówkę, Usuń placówkę, Zmień dane placówki, dodaj pracownika do placówki, 
          usuń pracownika z placówki, wyszukaj aktualnych pracowników placówki, wyszukaj wszystkich pracowników
          placówki, którzy opiekują się podanym samochodem)

    2.3.  Do tych serwisów testy jUnit działające na bazie (nie mocki)

3.  Usunięcie samochodu wiąże się z usunięciem informacji o wszystkich jego wypożyczeniach

4.  Użyj JPQL, do zrealizowania zapytań:
    
    - Znajdź pracowników według następujących kryteriów: (Nie wszystkie kryteria muszą być zdefiniowane)
      - wg podanej placówki
      - opiekują się danym autem
    - Znajdź samochody, które zostały wypożyczone przez więcej niż 10 osób
    
5.  tworzyć kontroler, przygotować widok, który pozwoli wyświetlić dane pracowników, którzy pracują w podanej placówce. Możecie użyć ThymeLeaf'a.

Dla tych co się będą nudzić dodatkowo:
- Zaimplementuj optimistic locking dla wszystkich encji. Pokaż przykładowe wykorzystanie dla samochodu.
- Wszystkie rekordy tabel powinny posiadać informacje o czasie utworzenia rekordu oraz czasie ostatniej modyfikacji
- Zmienić implementację tak, żeby korzystała z rzeczywistej bazy danych
