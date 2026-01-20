# src/test/resources/features/frisby.feature
Feature: Apertura de aplicación Frisby
  Como usuario de Frisby
  Quiero poder abrir la aplicación
  Para realizar pedidos de comida

  @frisby
  Scenario: Abrir aplicación por primera vez
    Given que "Juan" abre la aplicación Frisby
    When ve la pantalla de inicio
    Then debería ver el logo de Frisby