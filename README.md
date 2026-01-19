# Proyecto base - Automatización móvil (Frisby) con Screenplay + Cucumber + Appium

Este proyecto es una plantilla mínima para automatizar una aplicación móvil (Frisby) usando:
- Java + Gradle + ScrenPlayBDD
- Cucumber + gerkin
- ScrenPlayBDD
- Appium (para ejecutar en un emulador de escritorio)

Estructura principal
- src/test/resources/features/frisby.feature  -> Feature en Gherkin 
- src/test/java/.../screenplay               -> Clases Actor / Ability / Tasks / Questions
- src/test/java/.../steps                    -> Step Definitions para Cucumber
- src/test/java/.../RunCucumberTest.java     -> Runner JUnit para ejecutar las features
- src/test/resources/config.properties       -> Configuración básica de Appium

Requisitos previos
- Java 11+ instalado
- Gradle instalado (o usa el wrapper si lo agregas)
- Emulador Android en tu escritorio (Android Virtual Device)
- Appium Server corriendo (por ejemplo `appium` en localhost:4723)
- APK de Frisby (si es necesario) o que la app ya esté instalada en el emulador

Configuración
1. Edita `src/test/resources/config.properties` con las capabilities correctas (appPackage, appActivity, deviceName, platformVersion).
2. Asegúrate de tener Appium corriendo:
   - `appium` (por defecto en http://127.0.0.1:4723)
3. Inicia el emulador Android.

Ejecución
- Ejecuta desde la raíz del proyecto:
  - `./gradlew test`  (o `gradle test`)
