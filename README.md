# api-wompi-reto

Este proyecto implementa pruebas automatizadas de la **plataforma de pagos Wompi** utilizando **Java, SerenityBDD, RestAssured y Cucumber (BDD)**.  
El objetivo es validar la creación de transacciones vía API con diferentes métodos de pago (**Nequi** para este reto) incluyendo escenarios positivos y negativos.

---
# 👨‍💻 Autor

Este proyecto fue desarrollado por **Francisco Leon Cordero** 

Fecha de creación: **Agosto 2025**

---
## 📂 Estructura del Proyecto

```text
src
├── main
│   └── java
│       └── api.co.wompi
│           ├── interations     # Acciones a realizar
│           ├── models          # Modelos de request
│           ├── questions       # Validaciones
│           ├── tasks           # Acciones (POST /transactions, GET /merchants, etc.)
│           └── utils           # Funciones de apoyo (faker, firma, etc.)
│
└── test
    ├── java
    │   └── api.co.wompi
    │       ├── runners         # Runners de Cucumber/Serenity
    │       └── stepdefinitions # Implementación de los steps
    │
    └── resources
        ├── features            # Escenarios BDD en Gherkin
        │   └── crear_transaccion.feature
        └── serenity.conf       # Configuración de Serenity BDD
```
---
# ⚙️ Requisitos

- **Java 21**
- **Gradle 8+**
- IDE compatible: *IntelliJ IDEA*
- Revisar la informacion del sandbox de Wompi:  
  `https://api-sandbox.co.uat.wompi.dev/v1`
---

# 🔑 Llaves de prueba

Del documento del reto:

- **Llave pública**  
  `pub_stagtest_g2u0HQd3ZMh05hsSgTS2lUV8t3s4mOt7`

- **Llave privada**  
  `prv_stagtest_5i0ZGIGiFcDQifYsXxvsny7Y37tKqFWg`

- **Llave de eventos**  
  `stagtest_events_2PDUmhMywUkvb1LvxYnayFbmofT7w39N`

- **Llave de integridad**  
  `stagtest_integrity_nAIBuqayW70XpUqJS4qf4STYiISd89Fp`

---

# 📜 serenity.conf

```hocon
environments {
  default {
    serenity.rest.base.url = "https://api-sandbox.co.uat.wompi.dev/v1"
  }
}
```
---
# ▶️ Ejecución de pruebas

**Ejecutar todas las pruebas**

```bash
./gradlew clean test
```

```bash
./gradlew clean test aggregate
```
---
# 🚀 Integración Continua con GitHub Actions

Este proyecto está integrado con **GitHub Actions** para ejecutar automáticamente las pruebas de Serenity BDD en cada **push** o **pull request** a la rama `main`.

## 📄 Pipeline

El pipeline se encuentra definido en: .github/workflows/serenity-tests.yml

---

## ▶️ Ejecución

Cada vez que se dispara el workflow:

1. Se compilan y ejecutan las pruebas con Gradle (`./gradlew clean test aggregate`).
2. Se generan los reportes de Serenity en la carpeta `target/site/serenity`.
3. Los reportes se publican como **Artifacts** en la ejecución de Actions.

## 📊 Acceso a los reportes

- Ir a la pestaña **Actions** de este repositorio.
- Seleccionar la última ejecución del pipeline **Run Serenity API Tests**.
- Descargar el artefacto **`serenity-reports`**.
- Abrir el archivo `index.html` dentro del ZIP descargado.

## ✅ Estado del pipeline

![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/FranciscoJL99/api-wompi-reto/serenity-tests.yml?branch=main)

---

---
# 📊 Reporte Serenity

Serenity genera automáticamente un reporte visual con:

- Escenarios ejecutados
- Evidencias (requests/responses de API)
- Resultados (passed/failed)

**Ubicación del reporte:**

```text
target/site/serenity/index.html
```
---
# 📊 Reporte Serenity

- **Java 21**
- **Gradle 8+**
- **Serenity BDD**
- **Serenity Rest**
- **Cucumber**
- **Java Faker**