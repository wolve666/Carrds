<p align="center">
  <img src="icon-512.png" alt="Icona di Carrds" width="160">
</p>

<h1 align="center">Carrds</h1>

<p align="center">
  Le tessere fedeltà dei negozi, pronte alla cassa in un tocco.<br>
  <a href="https://wolve666.github.io/Carrds/"><strong>Apri l’app »</strong></a>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/versione-1.5-D7263D" alt="Versione 1.5">
  <img src="https://img.shields.io/badge/PWA-installabile-46AAF5" alt="PWA installabile">
  <img src="https://img.shields.io/badge/funziona-offline-2E9E5B" alt="Funziona offline">
  <img src="https://img.shields.io/badge/dati-solo%20sul%20telefono-3A3F4B" alt="Dati solo sul telefono">
</p>

---

## Indice

- [Cos’è](#cosè)
- [Funzionalità](#funzionalità)
- [Installazione su Android](#installazione-su-android)
- [Come si usa](#come-si-usa)
- [Codici supportati](#codici-supportati)
- [Ricerca dei loghi](#ricerca-dei-loghi)
- [Privacy e dati](#privacy-e-dati)
- [Backup e trasferimento](#backup-e-trasferimento)
- [Struttura del progetto](#struttura-del-progetto)
- [Tecnologie](#tecnologie)
- [Aggiornare l’app](#aggiornare-lapp)
- [Risoluzione dei problemi](#risoluzione-dei-problemi)
- [Novità per versione](#novità-per-versione)
- [Crediti](#crediti)

---

## Cos’è

**Carrds** è una web app installabile (PWA) che raccoglie in un unico portafoglio digitale le tessere fedeltà di supermercati e negozi. Alla cassa basta aprirla, toccare la tessera e mostrare il codice a barre.

È nata per essere un’alternativa **più veloce** alle app commerciali come Klarna (ex Stocard): niente account, niente server, niente caricamenti. Le tessere sono salvate sul telefono e si aprono all’istante, anche senza connessione.

---

## Funzionalità

### Portafoglio
- Griglia a due colonne con tutte le tessere visibili subito, a scorrimento verticale.
- Le tessere più usate salgono in cima da sole.
- Ricerca per nome quando le tessere sono più di quattro.
- Animazione di apertura: le tessere si impilano una sull’altra e poi si distribuiscono nella griglia.

### Alla cassa
- Codice a barre grande su sfondo bianco, sempre leggibile dagli scanner anche con il tema scuro.
- Numero della tessera mostrato in chiaro sotto il codice.
- Schermo tenuto acceso finché la tessera resta aperta.

### Aggiunta delle tessere
- **Scansione dal vivo** con la fotocamera.
- **Lettura da foto** già scattata.
- **Inserimento manuale** del numero, con riconoscimento automatico del tipo di codice.
- Anteprima del codice in tempo reale mentre si compila.

### Aspetto delle tessere
- **Logo a tutta tessera**, intero oppure a riempimento completo.
- **Ricerca loghi** integrata su più fonti (vedi [Ricerca dei loghi](#ricerca-dei-loghi)).
- **Foto del fronte** della tessera vera, ritagliata in automatico alle proporzioni di una carta.
- Dieci colori di sfondo, bianco compreso, per le tessere senza logo.
- Sito compilato in automatico per una cinquantina di catene italiane.

### App
- Due temi: **rosso su bianco** (predefinito) e **nero con il rosso**.
- Sfondo decorato con carrelli, shopper e regali a linea sottile.
- Installabile come app Android, con tasto **Installa** dedicato.
- Funziona **offline** dopo il primo avvio.
- **Tasto indietro** del telefono collegato a tutte le schermate.
- Versione corrente visibile accanto al nome.
- Pannello di **diagnosi dell’installazione**.

---

## Installazione su Android

1. Apri **[wolve666.github.io/Carrds](https://wolve666.github.io/Carrds/)** con **Chrome**.
2. Premi il tasto **Installa** che compare in alto, accanto al nome.
3. Carrds appare tra le app del telefono con la sua icona.

Se il tasto non compare: tocca **⋯ → Installazione** dentro l’app. Il pannello mostra quali requisiti sono soddisfatti e cosa manca.

> Il suggerimento di installazione proposto dal menu di Chrome può fallire con il messaggio “app già installata”. Il tasto **Installa** dell’app è il metodo affidabile.

---

## Come si usa

| Azione | Come |
|---|---|
| Aggiungere una tessera | Tasto **+** → inquadra il codice, oppure leggilo da una foto, oppure scrivi il numero |
| Scegliere il logo | Nel modulo → **Cerca logo** → tocca quello che preferisci |
| Mostrarla alla cassa | Tocca la tessera nella griglia |
| Modificarla o eliminarla | Apri la tessera → **Modifica** |
| Cambiare tema | Tasto con il cerchio a metà, in alto |
| Backup e installazione | Tasto **⋯**, in alto |
| Tornare indietro | Tasto o gesto indietro del telefono |

Consiglio: alla cassa alza la luminosità dello schermo se lo scanner fa fatica a leggere.

---

## Codici supportati

| Tipo | Uso tipico |
|---|---|
| EAN-13 | La maggior parte delle tessere dei supermercati |
| EAN-8 | Tessere con numero corto |
| UPC-A / UPC-E | Tessere di catene internazionali |
| Code 128 | Tessere con lettere o numeri lunghi |
| Code 39 | Sistemi più datati |
| ITF | Tessere con numeri a coppie |
| Codabar | Biblioteche e sistemi particolari |
| QR code | Tessere e app più recenti |

Con **Automatico** l’app sceglie il formato in base al numero. Se il numero non è valido per il formato scelto, lo disegna in Code 128, che gli scanner leggono comunque.

---

## Ricerca dei loghi

La ricerca interroga più fonti in parallelo e mostra i risultati in una griglia:

| Fonte | Cosa trova | Qualità |
|---|---|---|
| **Wikidata** | Il logo ufficiale registrato per l’azienda, più il suo sito | Alta, spesso vettoriale |
| **Wikimedia Commons** | Varianti e versioni storiche del logo | Alta |
| **Icone del sito** | Le icone pubblicate dal sito del negozio | Media |

- I loghi scelti vengono salvati nella cache e restano disponibili **offline**.
- La ricerca invece richiede la connessione.
- Per i negozi piccoli o locali conviene scrivere il sito nel campo apposito. In alternativa, la foto del fronte è sempre la soluzione più affidabile.

---

## Privacy e dati

- **Nessun account**, nessun server, nessun tracciamento.
- Le tessere sono salvate solo nella memoria del browser del telefono (`localStorage`).
- Le uniche richieste esterne sono le librerie dei codici, i font e, solo quando si usa la ricerca, i loghi.

> **Attenzione:** non usare “Cancella dati” del sito `wolve666.github.io` nelle impostazioni di Chrome. Cancellerebbe insieme i dati di tutte le app pubblicate su questo indirizzo.

---

## Backup e trasferimento

Dal tasto **⋯ → Backup e app**:

1. **Copia backup**: tutte le tessere, con loghi e foto, vengono copiate come testo.
2. Invia il testo all’altro telefono, per esempio in chat.
3. Sull’altro telefono: **⋯ → Incolla un backup → Importa tessere**.

Le tessere già presenti con lo stesso nome e numero non vengono duplicate.

---

## Struttura del progetto

```
Carrds/
├── index.html              App completa: interfaccia, stili e logica
├── sw.js                   Service worker: cache e funzionamento offline
├── manifest.webmanifest    Nome, colori e icone per l’installazione
├── icon-192.png            Icona 192×192
├── icon-512.png            Icona 512×512
├── icon-maskable-512.png   Icona adattiva per i launcher Android
├── apple-touch-icon.png    Icona per iPhone
└── README.md               Questo file
```

---

## Tecnologie

| Componente | Ruolo |
|---|---|
| HTML, CSS e JavaScript puri | Nessun framework, nessuna compilazione |
| [JsBarcode](https://github.com/lindell/JsBarcode) | Disegno dei codici a barre |
| [qrcode-generator](https://github.com/kazuhikoarase/qrcode-generator) | Disegno dei QR code |
| BarcodeDetector (nativo di Chrome) | Scansione veloce dalla fotocamera |
| [ZXing](https://github.com/zxing-js/library) | Scansione di riserva sui browser senza BarcodeDetector |
| Service Worker e Web App Manifest | Installazione e uso offline |
| Wake Lock API | Schermo acceso alla cassa |
| Font [Bricolage Grotesque](https://fonts.google.com/specimen/Bricolage+Grotesque) | Tipografia |

---

## Aggiornare l’app

1. Modifica i file e cambia il numero nella riga:
   ```js
   const APP_VERSION = '1.5';   // in index.html
   ```
2. Carica su GitHub **solo i file cambiati**: quasi sempre `index.html`, a volte `sw.js`.
3. All’apertura successiva l’app installata scarica la nuova versione da sola.

Non serve modificare `sw.js` per cambiare versione: il service worker legge il numero direttamente da `index.html`.

---

## Risoluzione dei problemi

| Problema | Soluzione |
|---|---|
| Chrome dice “app già installata” | Usa il tasto **Installa** dell’app invece del menu di Chrome |
| Il tasto Installa non compare | **⋯ → Installazione**: controlla le voci rosse e ricarica la pagina |
| La fotocamera non si apre | Concedi il permesso fotocamera a Chrome, oppure usa **Codice da foto** |
| Lo scanner della cassa non legge | Alza la luminosità al massimo e tieni il telefono fermo |
| Un logo non compare | Prova un’altra proposta nella ricerca, oppure usa la foto del fronte |
| L’app non si aggiorna | Chiudila del tutto e riaprila; se serve, ricarica la pagina una volta |
| L’icona sulla Home è quella vecchia | Disinstalla e reinstalla l’app |

---

## Novità per versione

| Versione | Novità |
|---|---|
| **1.5** | Tasto indietro del telefono collegato a tutte le schermate |
| **1.4** | Logo a tutta tessera, ricerca loghi su Wikidata, Commons e siti, sfondo bianco |
| **1.3** | Versione visibile accanto al nome, pannello di diagnosi, installazione più robusta |
| **1.2** | Icona definitiva con il portafoglio di cuoio |
| **1.1** | Nome Carrds, app installabile, funzionamento offline, loghi automatici delle catene |
| **1.0** | Prima versione: temi rosso e nero, griglia animata, scansione, foto delle tessere, backup |

---

## Crediti

- **Idea:** nata in famiglia, per avere le tessere sempre pronte senza attese.
- **Sviluppo:** Federico, con l’aiuto di Claude.
- **Loghi:** forniti da Wikidata, Wikimedia Commons e dai siti dei negozi. I marchi appartengono ai rispettivi proprietari e sono usati solo per riconoscere le proprie tessere personali.
