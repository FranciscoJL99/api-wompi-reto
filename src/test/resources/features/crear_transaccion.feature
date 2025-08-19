#Author: Francisco Leon
#language: es
Característica: Creación de transacción en Wompi


  Esquema del escenario: Crear transacción exitosa con Nequi
    Dado que el comercio tiene un token de autenticación válido
    Cuando solicita la creación de una transacción con Nequi de <monto> y referencia "<referencia>"
    Entonces la respuesta debe contener un estado "PENDING" o "APPROVED"

    Ejemplos:
      | monto  | referencia                            |
      | 150000 | prueba-transferencia-valor-minimo-001 |
      | 950000 | prueba-transferencia-valor-mayor-001  |

  Escenario: Crear transacción con monto no valido
    Dado que el comercio tiene un token de autenticación válido
    Cuando solicita la creación de una transacción con un monto inválido
    Entonces la respuesta debe contener un error de validación