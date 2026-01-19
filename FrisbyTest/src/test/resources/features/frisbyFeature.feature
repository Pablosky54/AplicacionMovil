Feature: Automatización de Frisby
  Para verificar búsquedas y acciones básicas en la app Frisby
  Mantener la aplicación establecida y reutilizable con Screenplay

  Background: La aplicación está abierta
    Given que el actor "Pablo" abre la aplicación

  Scenario: Buscar un producto existente
    When busca el producto "Cuarto Frisby Arepas"
    Then debería ver el resultado "Cuarto Frisby Arepas"

  Scenario: Agregar producto al carrito
    When busca el producto "Pollo Frisby Arepas"
    And agrega el producto al carrito
    Then el carrito debería contener "Pollo Frisby Arepas"

  Scenario Outline: Búsqueda parametrizada
    When busca el producto "<producto>"
    Then debería ver el resultado "<producto>"

    Examples:
      | producto          |
      | Medio Frisby BBQ arepas      |
      | Pollo Frisby BBQ francesa   |