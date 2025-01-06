Prima prova intercorso 12/11/2018
Non è consentito usare libri o appunti.
Implementare un sistema per gestire la gestione di elettrodomestici che possono essere di 2 tipi:
Lavatrice e LettoreMP3 caratterizzati da nome, marca e numero di programmi eseguiti.
1. [15 punti] Definire la classe Lavatrice che modella le lavatrici che hanno una lista dei
   possibili programmi di lavaggio (ad esempio Lana, Normale, Seta, Rapido) ed il programma
   della lista selezionato. L’esecuzione del metodo start accenderà la lavatrice e fornirà le
   informazioni della lavatrice e del programma attualmente selezionato. Il metodo next consente
   di effettuare la selezione del programma di lavaggio restituendo il programma selezionato se la
   lavatrice è accesa. In particolare, se il programma i-esimo è il programma attualmente
   selezionato, allora next lo cambierà con l’i+1-esimo programma della lista. Quindi next
   scandirà la lista da sinistra verso destra finché non arriverà alla fine della lista. A questo punto
   next selezionerà il penultimo programma della lista, e continuerà scandendo la lista da destra
   verso sinistra. Il metodo play restituisce il programma selezionato per l’esecuzione ed
   aggiorna il numero di programmi eseguiti, mentre il metodo stop spegne la lavatrice.
   Definire la classe LettoreMP3 che modella i lettori MP3 che sono caratterizzati da una lista
   di canzoni: quest’ultima viene inizializzata con il metodo load. L’esecuzione del metodo
   start accenderà il lettore e mostrerà sullo schermo il nome del lettore ed il titolo della
   canzone selezionata. Il metodo next consente di effettuare la selezione della canzone dalla lista
   e restituisce la canzone selezionata. In particolare, se la canzone i-esima è quella attualmente
   selezionata, allora next la cambierà con l’i+1-esima canzone della lista. Quando si arriva alla
   fine della lista next selezionerà la prima canzone della lista. Il metodo play restituisce la
   canzone selezionato per essere ascoltata ed aggiorna il numero di programmi eseguiti mentre il
   metodo stop spegne l’MP3.
2. [9 punti] La classe Domotica tiene traccia di un insieme di elettrodomestici. Inoltre, la classe
   fornisce i seguenti metodi:
   • aggiungiElettrodomestico(elettrodomestico)
   aggiunge
   un
   elettrodomestico all’insieme di elettrodomestici
   • eseguiProgramma(i,j) esegue il programma/canzone j dell’elettrodomestico nella
   posizione i. Se l’elettrodomestico non è accesso deve essere avviato con start. Se non esiste
   il programma j-esimo il metodo non fa nulla.
   • stop() che ferma tutti gli elettrodomestici.
   • toString()visualizza le informazioni degli elettrodomestici
3. [6 punti] Implementare una classe tester che esegue le operazioni seguenti nell’ordine in cui
   sono elencate:
1. Istanzia 20 elettrodomestici scelti in maniera casuale tra quelli definiti.
2. Esegue 100 programmi scegliendo in modo casuale l’elettrodomestico ed il programma.
3. Ferma tutti gli elettrodomestici.
4. Visualizza le informazioni degli elettrodomestici incluso il numero di programmi effettuati.