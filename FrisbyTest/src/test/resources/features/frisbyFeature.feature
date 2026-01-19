Feature: Automatización de Frisby
  Para verificar búsquedas y acciones básicas en la app Frisby
  Mantener la aplicación establecida y reutilizable con Screenplay

  Background: La aplicación está abierta
    Given que el actor "Pablo" abre la aplicación

  Scenario: Buscar un producto existente
    When busca el producto "Donas de fresa"
    Then debería ver el resultado "Donas de fresa"

  Scenario: Agregar producto al carrito
    When busca el producto "Donas de chocolate"
    And agrega el producto al carrito
    Then el carrito debería contener "Donas de chocolate"

  Scenario Outline: Búsqueda parametrizada
    When busca el producto "<producto>"
    Then debería ver el resultado "<producto>"

    Examples:
      | producto          |
      | Donas mixtas      |
      | Donas glaseadas   |