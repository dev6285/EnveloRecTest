# EnveloRecTest
Recruitment test for the "Akademia Envelo w PKP Informatyka"

Cześć! Kod do zadania #3 jest do pobrania z tego repozytorium.

Odpowiadając na pozostałe pytania:

1A: "Klasy abstrakcyjne mogą dziedziczyć tylko po jednej innej klasie, mogą dostarczać ciała metod i mogą określać metody o innej widoczności niż ‘public’. Interfejsy z kolei mogą być dziedziczone wielokrotnie, mogą dostarczać domyślne ciała metod (ale nie mogą przesłaniać innych metod) i dotyczą tylko metod o widoczności public."

1B: "Główna różnica między listą Array i Linked jest związana z ich strukturą. Tablice to struktura danych oparta na indeksach, w której każdy element jest powiązany z indeksem. Z drugiej strony lista powiązań opiera się na referencjach, w których każdy węzeł składa się z danych i odniesień do poprzedniego i następnego elementu."

2: Przykładowa metoda sprawdzająca czy w tablicy znajduje się wskazana liczba całkowita (x):
        
        private boolean search(int[] numbers, int x) {
        boolean isInArray = false;        
        for (int number : numbers) {        
            if (number == x) {            
                isInArray = true;                
                break;
               }            
        }        
        return isInArray;        
    }    

Prawdopodobnie bardziej optymalnym rozwiązaniem byłoby użycie Arrays.binarySearch(numbers,x). Niestety z zabrakło mi czasu aby napisać działające rozwiązanie na podstawie tej metody. Również z tego samego powdu niestety nie uzupełniam rozwiązania o przewidywaną złożoność obliczeniową oraz pamięciową. Natomiast myślę, że przy odpowiednim nakładzie pracy z odrobiną doświadczenia, np w oparciu o https://binarnie.pl/zlozonosc-obliczeniowa/ jest to do zrobienia.
