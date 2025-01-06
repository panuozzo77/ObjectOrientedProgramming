Realizzare una classe esami.Officina che gestisce l'inserimento, la ricerca e la cancellazione di schede Auto in riparazione.

Ogni scheda Auto deve contenere gli attributi necessari alla gestione delle riparazioni: (Es.: targa, modello, numero progressivo di scheda).
Inoltre per mezzo della classe Scheda deve essere possibile leggere:
- lo stato del veicolo (in riparazione, riparato, consegnato, data di arrivo in officina)
- il numero di veicoli in officina
- il numero di veicoli che hanno attraversato l'officina

La classe esami.Officina deve consentire all'utente di:
- Stampare l'elenco dei veicoli in un file con le seguenti opzioni:
    1. Tutti i veicoli
    2. Solo i veicoli in riparazione
    3. I veicoli riparati, ma non consegnati
    4. I veicoli consegnati
    5. Il nome del file deve essere scelto dall'utente
- Caricare da un file di testo scelto dall'utente la lista di veicoli
- Cancellare dalla lista i veicoli consegnati


Alla chiusura del programma:
- cancellare dalla lista i veicoli consegnati
- salvare in un file tutti i veicoli rimasti
- scrivere in un secondo file binario (il cui nome e' fissato dal programma) il numero di veicoli che hanno lasciato l'officina

All'avvio del programma:
- aprire il file binario in lettura per inizializzare il numero di veicoli che hanno lasciato l'officina
- aprire in lettura il file di testo per caricare la lista dei veicoli presenti in officina
