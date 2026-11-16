<p align="center">
  <img src="assets/icon-only.png" alt="Icona di Carrds" width="160">
</p>

<h1 align="center">Carrds</h1>

<p align="center">
  Le tessere fedeltà dei negozi, pronte alla cassa in un tocco.<br>
  <a href="https://github.com/wolve666/Carrds/releases/latest"><strong>Scarica l’APK »</strong></a>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/versione-2.1-D7263D" alt="Versione 2.1">
  <img src="https://img.shields.io/badge/Android-APK-46AAF5" alt="App Android">
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

**Carrds** è un’app Android che raccoglie in un unico portafoglio digitale le tessere fedeltà di supermercati e negozi. Alla cassa basta aprirla, toccare la tessera e mostrare il codice a barre.

È nata per essere un’alternativa **più veloce** alle app commerciali come Klarna (ex Stocard): niente account, niente server, niente caricamenti. Le tessere sono salvate sul telefono e si aprono all’istante. Tutto quello che serve è dentro l’APK: funziona anche senza rete dati.

---

## Funzionalità

### Portafoglio
- Griglia a due colonne con tutte le tessere visibili subito, a scorrimento verticale.
- **Tocchi una tessera e si allarga**: le altre scorrono giù e sotto compare il codice a barre.
- **La tocchi di nuovo e si gira**: sul retro modifichi numero, logo, colore e stellina del widget.
- Le tessere più usate salgono in cima da sole.
- Ricerca per nome quando le tessere sono più di quattro.
- Animazione di apertura: le tessere si impilano una sull’altra e poi si distribuiscono nella griglia.

### Alla cassa
- Codice a barre grande su sfondo bianco, sempre leggibile dagli scanner anche con il tema scuro.
- Numero della tessera mostrato in chiaro sotto il codice.
- Schermo tenuto acceso e **luminosità al massimo** finché la tessera resta aperta.

### Aggiunta delle tessere
- **Scansione dal vivo** con la fotocamera.
- **Lettura da foto** già scattata.
- **Inserimento manuale** del numero, con riconoscimento automatico del tipo di codice.
- Anteprima del codice in tempo reale mentre si compila.

### Aspetto delle tessere
- **Logo a tutta tessera**, con il nome del negozio in alto a destra, sempre leggibile.
- Il colore della tessera si prende in automatico dai bordi del logo.
- **Ricerca loghi** integrata su più fonti (vedi [Ricerca dei loghi](#ricerca-dei-loghi)).
- **Foto del fronte** della tessera vera, ritagliata in automatico alle proporzioni di una carta.
- Dieci colori di sfondo, bianco compreso, per le tessere senza logo.
- Sito compilato in automatico per una cinquantina di catene italiane.

### App
- Tre temi: **Rosso** (predefinito), **Notte** e **Portafoglio**, ispirato all’icona.
- Sfondo decorato con carrelli, shopper e regali a linea sottile.
- App Android vera (APK), **indipendente dalla rete**: librerie, font e loghi sono dentro l’app.
- I loghi scelti vengono salvati dentro la tessera e restano visibili offline.
- **Tasto indietro** del telefono collegato a tutte le schermate.
- **Widget per la Home** con le tessere segnate dalla stellina ★ (fino a quattro): un tocco apre direttamente il codice.
- Versione corrente accanto al nome: toccandola **verifica gli aggiornamenti** e scarica la nuova APK.

---

## Installazione su Android

1. Apri **[l’ultima release](https://github.com/wolve666/Carrds/releases/latest)** dal telefono.
2. Scarica `Carrds.apk` e aprilo.
3. Alla prima installazione Android chiede di consentire l’installazione da questa fonte: autorizzala.
4. Al primo avvio concedi il permesso **fotocamera** quando scansioni una tessera.

Per spostare le tessere dalla vecchia versione web: **⋯ → Copia backup** lì, poi **⋯ → Importa tessere** nell’app.

---

## Come si usa

| Azione | Come |
|---|---|
| Aggiungere una tessera | Tasto **+** → inquadra il codice, oppure leggilo da una foto, oppure scrivi il numero |
| Scegliere il logo | Nel modulo → **Cerca logo** → tocca quello che preferisci |
| Mostrarla alla cassa | Tocca la tessera: si allarga e mostra il codice |
| Modificarla o eliminarla | Con la tessera aperta, toccala di nuovo: si gira |
| Metterla nel widget | Sul retro → **☆ Metti nel widget** |
| Aggiungere il widget | **⋯ → Aggiungi widget alla Home** |
| Cambiare tema | Tasto con il cerchio a metà, in alto: Rosso, Notte, Portafoglio |
| Backup e aggiornamenti | Tasto **⋯**, in alto |
| Verificare gli aggiornamenti | Tocca la versione accanto al nome |
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
| **Brandfetch** | Logo, icona e simbolo del marchio a 1024 px | Altissima |
| **Wikidata** | Il logo ufficiale registrato per l’azienda, più il suo sito | Alta, spesso vettoriale |
| **Wikimedia Commons** | Varianti e versioni storiche del logo | Alta |
| **Icone del sito** | Le icone grandi dichiarate dal sito e dalla sua app web | Media-alta |

- Le proposte compaiono in ordine di nitidezza, con l’etichetta **HD** sulle migliori; quelle troppo piccole vengono scartate.
- I loghi di Wikidata, Commons e dei siti vengono salvati **dentro la tessera**: si vedono sempre, anche offline.
- I loghi **Brandfetch** per regolamento non si possono salvare: si caricano dal loro server e si vedono quando c’è rete. Nel widget quelle tessere mostrano colore e nome.
- La ricerca invece richiede la connessione.
- Per i negozi piccoli o locali conviene scrivere il sito nel campo apposito. In alternativa, la foto del fronte è sempre la soluzione più affidabile.

---

## Privacy e dati

- **Nessun account**, nessun server, nessun tracciamento.
- Le tessere sono salvate solo nella memoria del browser del telefono (`localStorage`).
- L’app va in rete solo per cercare i loghi e per verificare gli aggiornamenti su GitHub.

> **Attenzione:** disinstallare l’app o usare “Cancella dati” nelle impostazioni Android elimina le tessere. Fai prima un backup.

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
├── www/
│   ├── index.html          App completa: interfaccia, stili e logica
│   └── lib/                Librerie e font inclusi nell’APK
├── native/                 Codice Android: widget, luminosità, apertura dal widget
├── assets/                 Icone sorgente per Android (normale e adattiva)
├── .github/workflows/
│   └── build.yml           Compila, firma e pubblica l’APK
├── capacitor.config.json   Configurazione dell’app Android
├── package.json            Dipendenze Capacitor
└── README.md               Questo file
```

---

## Tecnologie

| Componente | Ruolo |
|---|---|
| HTML, CSS e JavaScript puri | Interfaccia senza framework |
| [Capacitor](https://capacitorjs.com) | Trasforma la pagina in app Android |
| Codice Android nativo | Widget della Home e luminosità dello schermo |
| [Brandfetch](https://brandfetch.com) | Loghi dei marchi in alta qualità |
| [JsBarcode](https://github.com/lindell/JsBarcode) | Disegno dei codici a barre |
| [qrcode-generator](https://github.com/kazuhikoarase/qrcode-generator) | Disegno dei QR code |
| BarcodeDetector (nativo di Chrome) | Scansione veloce dalla fotocamera |
| [ZXing](https://github.com/zxing-js/library) | Scansione di riserva sui browser senza BarcodeDetector |
| GitHub Actions | Compilazione e firma automatica dell’APK |
| Wake Lock API | Schermo acceso alla cassa |
| Font [Bricolage Grotesque](https://fonts.google.com/specimen/Bricolage+Grotesque) | Tipografia, inclusa nell’app |

---

## Aggiornare l’app

1. Modifica i file e cambia il numero nella riga:
   ```js
   const APP_VERSION = '2.1';   // in www/index.html
   ```
2. Carica su GitHub **solo i file cambiati** (quasi sempre `www/index.html`).
3. GitHub Actions compila l’APK e pubblica la release `v<versione>`.
4. Sul telefono tocca la versione accanto al nome: l’app trova la nuova release e scarica l’APK.

Segreti richiesti nel repository (*Settings → Secrets and variables → Actions*):
- `KEYSTORE_B64`: la chiave di firma codificata in base64.
- `KEYSTORE_PASS`: la password della chiave.

La chiave va conservata fuori dal repository: senza, Android non accetta gli aggiornamenti sopra l’app installata.

---

## Risoluzione dei problemi

| Problema | Soluzione |
|---|---|
| Android blocca l’installazione | Consenti l’installazione da fonti sconosciute per il browser o il file manager usato |
| “App non installata” durante un aggiornamento | L’APK è firmato con un’altra chiave: fai un backup, disinstalla e reinstalla |
| La fotocamera non si apre | Impostazioni Android → App → Carrds → Autorizzazioni → Fotocamera |
| Lo scanner della cassa non legge | Alza la luminosità al massimo e tieni il telefono fermo |
| Un logo non compare | Prova un’altra proposta nella ricerca, oppure usa la foto del fronte |
| Il widget è vuoto | Metti la stellina ★ sul retro di almeno una tessera |
| La verifica aggiornamenti non trova nulla | Controlla che la compilazione su GitHub (scheda *Actions*) sia finita in verde |

---

## Novità per versione

| Versione | Novità |
|---|---|
| **2.1** | Tessere che si allargano e si girano, nome sul logo, tre temi (nuovo Portafoglio), widget con stelline, luminosità al massimo, loghi HD con Brandfetch e icone dei siti |
| **2.0** | App Android (APK) indipendente dalla rete: librerie e font inclusi, loghi salvati dentro le tessere, verifica aggiornamenti dalle release |
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
