// Cambia questo numero a ogni aggiornamento dei file per forzare il rinnovo della cache
const VERSION = 'carrds-v2';
const CORE = ['./', './index.html', './manifest.webmanifest', './icon-192.png', './icon-512.png', './icon-maskable-512.png', './apple-touch-icon.png'];
const LIBS = [
  'https://cdnjs.cloudflare.com/ajax/libs/jsbarcode/3.11.6/JsBarcode.all.min.js',
  'https://cdnjs.cloudflare.com/ajax/libs/qrcode-generator/1.4.4/qrcode.min.js',
  'https://cdn.jsdelivr.net/npm/@zxing/library@0.21.3/umd/index.min.js'
];

self.addEventListener('install', e => {
  e.waitUntil((async () => {
    const c = await caches.open(VERSION);
    await c.addAll(CORE);
    await Promise.all(LIBS.map(u => c.add(new Request(u, {mode: 'cors'})).catch(() => {})));
    await self.skipWaiting();
  })());
});

self.addEventListener('activate', e => {
  e.waitUntil((async () => {
    for (const k of await caches.keys()) if (k !== VERSION && k !== 'carrds-esterni') await caches.delete(k);
    await self.clients.claim();
  })());
});

self.addEventListener('fetch', e => {
  const req = e.request;
  if (req.method !== 'GET') return;
  const url = new URL(req.url);

  // File dell'app: risponde subito dalla cache e intanto aggiorna in background
  if (url.origin === location.origin) {
    e.respondWith((async () => {
      const c = await caches.open(VERSION);
      const hit = await c.match(req, {ignoreSearch: true}) || (req.mode === 'navigate' ? await c.match('./index.html') : null);
      const net = fetch(req).then(r => { if (r.ok) c.put(req, r.clone()); return r; }).catch(() => null);
      return hit || (await net) || new Response('Offline', {status: 503});
    })());
    return;
  }

  // Librerie, font e loghi: prima la cache, poi la rete (poi restano disponibili offline)
  e.respondWith((async () => {
    const own = await caches.match(req);
    if (own) return own;
    try {
      const r = await fetch(req);
      if (r.ok || r.type === 'opaque') (await caches.open('carrds-esterni')).put(req, r.clone());
      return r;
    } catch (err) {
      return new Response('', {status: 504});
    }
  })());
});
