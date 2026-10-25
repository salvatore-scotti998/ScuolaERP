# ScuolaERP

Prototipo didattico di un gestionale scolastico, realizzato con Java e Spring Boot per il backend, Angular per il frontend e Oracle Database per la gestione dei dati.

La versione attuale permette di consultare un elenco di alunni con le rispettive classi e filtrare i risultati per colonna.

## Funzionalità

- Visualizzazione di alunni, anno scolastico, sezione e classe.
- Filtri per colonna nella tabella.
- Recupero dei dati tramite API REST.
- Script SQL per creare e popolare le tabelle e la vista utilizzata dall’applicazione.

## Tecnologie utilizzate

- **Backend:** Java, Spring Boot, Spring Data JPA.
- **Frontend:** Angular, TypeScript, HTML e CSS.
- **Database:** Oracle Database.

## Struttura del progetto

- `BACKEND/`: applicazione Spring Boot che espone le API.
- `FRONTEND/`: applicazione Angular che visualizza e filtra i dati.
- `DB/`: script SQL per ricostruire la struttura e caricare i dati iniziali.

## Come funziona

Il frontend Angular invia una richiesta HTTP al backend Spring Boot. Il backend legge i dati da Oracle attraverso la vista `V_CLASSI_ALUNNI` e restituisce una risposta JSON. Il frontend mostra i risultati nella tabella e applica i filtri.

## Requisiti

- JDK 17 per il backend.
- Node.js compatibile con Angular 20, per esempio versione 22 dalla 22.12.0.
- npm per installare le dipendenze del frontend.
- Oracle Database: il progetto è stato provato con Oracle XE 21c.
- Un client SQL, come Oracle SQL Developer, per eseguire lo script del database.

Il backend include Maven Wrapper: non è necessario installare Maven separatamente. Al primo utilizzo è richiesta una connessione Internet per scaricare gli strumenti e le dipendenze.

## Preparazione del database

Lo script `DB/scuola_erp.sql` contiene:

- creazione delle quattro tabelle;
- creazione della vista `V_CLASSI_ALUNNI`;
- caricamento dei dati iniziali;
- creazione di indici e vincoli;
- riallineamento dei generatori degli ID.

Lo script deve essere eseguito in uno schema Oracle vuoto, predisposto con i permessi necessari per creare tabelle e viste e con spazio disponibile nel tablespace.

Non crea l’utente Oracle: la connessione allo schema deve essere predisposta prima dell’esecuzione.

Il backend utilizza `ddl-auto: validate`: verifica la struttura esistente e non crea automaticamente le tabelle.

## Avvio del backend

Aprire PowerShell nella cartella `BACKEND`.

Configurare la connessione al proprio schema Oracle:

```powershell
$env:DB_URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1"
$env:DB_USERNAME = "NOME_UTENTE_ORACLE"
```

Sostituire `NOME_UTENTE_ORACLE` con l’utente dello schema in cui è stato eseguito lo script SQL. Adattare l’URL se host, porta o servizio Oracle sono diversi.

Inserire la password senza mostrarla durante la digitazione:

```powershell
$passwordDb = Read-Host "Password Oracle" -AsSecureString
$env:DB_PASSWORD = [System.Net.NetworkCredential]::new("", $passwordDb).Password
Remove-Variable passwordDb
```

Avviare il backend dalla stessa finestra PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

Le variabili valgono per la sessione PowerShell corrente e per i processi avviati da essa.

L’API è disponibile all’indirizzo:

http://localhost:8080/api/classi-alunni

Per arrestare il backend premere `Ctrl+C`.

## Avvio del frontend

Aprire una seconda finestra PowerShell nella cartella `FRONTEND`.

Installare le dipendenze usando le versioni del lockfile:

```powershell
npm ci
```

Avviare il frontend:

```powershell
npm start
```

Aprire nel browser:

http://localhost:4200

Il frontend è attualmente configurato per chiamare il backend all’indirizzo `http://localhost:8080`. Il backend consente le richieste provenienti da `http://localhost:4200`.

Per arrestare il frontend premere `Ctrl+C`.

## Compilazione e test del frontend

Dalla cartella `FRONTEND`, compilare con:

```powershell
npm run build
```

Eseguire i test con:

```powershell
npm test -- --watch=false --browsers=ChromeHeadless
```

Per questo comando di test è necessario Google Chrome.

## Stato del progetto

La versione attuale è un prototipo didattico per la consultazione e il filtraggio di alunni e classi.

Non include operazioni di inserimento, modifica o cancellazione dall’interfaccia, né autenticazione degli utenti. La configurazione attuale è pensata per l’esecuzione locale.