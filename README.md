# 🚗 Concessionario Auto – Spring Boot Demo

Applicazione **Spring Boot MVC** per la gestione di un concessionario di **automobili, motociclette e furgoni**, con interfaccia web realizzata tramite **Thymeleaf**.

👉 **Demo pubblica (Render):**  
https://concessionarioauto.onrender.com

---

## 🎯 Descrizione del progetto

Il progetto nasce come **esercizio didattico sulla proprietà di ereditarietà dell’OOP**  
(superclasse `Veicolo` → sottoclassi `Automobile`, `Motocicletta`, `Furgone`).

Successivamente è stato **evoluto in chiave più professionale**, introducendo:

- **DTO** per non esporre direttamente le entità
- **Mapper** dedicati per la conversione Entity ↔ DTO
- **Gestione centralizzata delle eccezioni**
- Separazione chiara dei layer (Controller / Service / Repository)
- Supporto a **più database** (H2 per demo, MySQL per ambiente reale)
- Modalità **demo pronta all’uso** per il deploy pubblico

L’obiettivo del progetto è **formativo e dimostrativo**, pensato per portfolio e colloqui tecnici.

---

## 🧱 Architettura

- **Controller** → gestione richieste HTTP (MVC)
- **Service** → logica applicativa
- **Repository** → accesso ai dati con Spring Data JPA
- **DTO & Mapper** → isolamento del dominio dal layer web
- **Exception handling centralizzato**
- **DataInitializer** → popolamento automatico dati in modalità demo

---

## 🛠️ Stack Tecnologico

**Backend**
- Java 21
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- Thymeleaf
- Maven

**Frontend**
- Thymeleaf templates
- Bootstrap 5

**Database**
- H2 (in-memory, demo)
- MySQL 8 (ambiente reale)

**Deploy**
- Docker
- Render

---

## 🌐 Modalità DEMO (Render – H2)

La versione online utilizza il profilo **`demo`**:

- Database **H2 in-memory**
- Nessuna configurazione richiesta
- Dati iniziali caricati automaticamente all’avvio
- Applicazione subito navigabile

👉 Ideale per recruiter e valutatori: **apri il link e funziona**.

---

## 🐬 Modalità MySQL (ambiente reale)

Il progetto supporta anche **MySQL** tramite configurazione esterna con **variabili d’ambiente**, senza credenziali hardcodate.

### Database
```sql
CREATE DATABASE concessionario_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_0900_ai_ci;
Variabili d’ambiente richieste
text
Copia codice
DB_URL=jdbc:mysql://localhost:3306/concessionario_db?useSSL=false&serverTimezone=UTC
DB_USER=concessionario_user
DB_PASS=********
Avvio con MySQL
bash
Copia codice
mvn spring-boot:run
(In assenza di profilo esplicito, viene usato il datasource MySQL.)

📄 Pagine principali
/ → Home

/automobili → Lista automobili

/motociclette → Lista motociclette

/furgoni → Lista furgoni

/automobili/{id} → Dettaglio veicolo
(analoghi per le altre categorie)

▶️ Avvio in locale
Modalità DEMO (H2 – consigliata)
bash
Copia codice
mvn spring-boot:run -Dspring-boot.run.profiles=demo
Modalità H2 con console (debug)
bash
Copia codice
mvn spring-boot:run -Dspring-boot.run.profiles=h2
Console H2:

bash
Copia codice
http://localhost:8080/h2-console
Modalità MySQL
bash
Copia codice
mvn spring-boot:run
🐳 Deploy con Docker (Render)
Il progetto include un Dockerfile multi-stage:

build con JDK 21

runtime con JRE 21

profilo demo forzato

porta configurata tramite variabile PORT

Nessuna variabile DB necessaria per la demo pubblica.

📌 Note finali
Questo progetto fa parte di un percorso di formazione full-stack Java ed è pensato come:

esercizio avanzato di OOP

dimostrazione di best practice Spring Boot

progetto portfolio-ready, consultabile online

👨‍💻 Autore: Edoardo Mattei
📅 Anno: 2025
