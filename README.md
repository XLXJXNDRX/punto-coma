
# Papelería “Punto & Coma”

En Punto & Coma, estudiantes e independientes hacen encargos de impresión y anillado para recoger el mismo día. El sistema registra nombre y teléfono del cliente y permite crear un pedido con ítems de este catálogo: Impresión B/N ($200 c/u, o $150 c/u si son 100 o más), Impresión Color ($500 c/u, o $400 c/u si son 50 o más), y Anillado ($3.000 c/u, sin precio por volumen). El cálculo funciona así: primero determinar subtotales por ítem aplicando precio por volumen cuando corresponda; luego sumar el total bruto; después aplicar un solo beneficio: si el pedido incluye al menos un anillado y la suma de impresiones (B/N + Color) es ≥ 30, se aplica 10% de descuento; de lo contrario, si el total bruto > $40.000, aplicar 5% de descuento; si ninguna condición se cumple, no hay descuento. No se aceptan cantidades ≤ 0. Tras confirmar el pedido, queda bloqueado y el sistema debe mostrar un resumen con detalle (precio aplicado por ítem), total bruto, descuento y total final. No se gestiona inventario ni pagos: solo el flujo de crear → calcular → confirmar → resumir.



REQUERIMIENTOS:

RF1 — Registrar cliente

Registrar cliente con: nombre (String) y telefono (String).
Comentario: usar String para teléfono (no double) para permitir ceros a la izquierda, signos y extensiones.

RF2 — Crear pedido en estado EN_CREACION asociado a un Cliente.
Un pedido contendrá uno o varios ItemPedido (cada ítem = producto + cantidad).

RF3 — Agregar ítems: Permitir agregar ítems al pedido (producto y cantidad enteras).
Validación: cantidad debe ser > 0. Si no, rechazar la operación con error.

RF4 — Catálogo y precios (aplicar precio por volumen cuando corresponda)
Productos y precios:

Impresión B/N: precio normal $200 / unidad; precio por volumen $150 / unidad si la cantidad del ítem ≥ 100.
Impresión Color: precio normal $500 / unidad; precio por volumen $400 / unidad si la cantidad del ítem ≥ 50.
Anillado: precio fijo $3.000 / unidad (sin volumen).

Cada ItemPedido debe calcular su subtotal usando el precio unitario aplicable (normal o volumen).

RF5 — Calcular totales

Calcular totalBruto = suma de subtotales de todos los ítems del pedido.
Calcular descuento aplicando UNA sola de las reglas (ver RF6).
Calcular totalFinal = totalBruto − descuento.

RF6 — Reglas de descuento (prioridad única)

Aplicar solo un beneficio por pedido, evaluado en este orden:

10% de descuento si (tiene al menos 1 anillado) y (suma de impresiones B/N + Color ≥ 30).
En caso de que no aplique 1: 5% de descuento si totalBruto > $40.000.
Si no aplica ninguna de las anteriores: 0% (sin descuento).
El descuento se calcula sobre totalBruto.

RF7 — Confirmación y bloqueo

El pedido puede ser confirmado (estado → CONFIRMADO).
Una vez CONFIRMADO, no se permiten modificaciones: no agregar, eliminar ni cambiar ítems.

RF8 — Resumen de pedido

El sistema debe producir un resumen imprimible que incluya:
Datos del cliente (nombre, teléfono).
Detalle de cada ítem: producto, cantidad, precio unitario aplicado (indicar si es precio normal o por volumen) y subtotal por ítem.
totalBruto, descuento (porcentaje y valor monetario) y totalFinal.


REGLAS DEL NEGOCIO:

RN1 — Precios base y por volumen
Cada producto tiene un precio unitario definido, y algunos cuentan con descuento por volumen:

Impresión en blanco y negro:
Precio normal de 200 pesos por unidad.
Si la cantidad >= 100, el precio baja a 150 pesos por unidad.

Impresión a color:
Precio normal de 500 pesos por unidad.
Si la cantidad es >= a 50, el precio baja a 400 pesos por unidad.

Anillado:
Precio fijo de 3.000 pesos por unidad.
No tiene precio por volumen.

El sistema debe determinar automáticamente qué precio aplicar según la cantidad ingresada.

RN2 — Cálculo del subtotal por ítem

Para cada producto, el subtotal se obtiene multiplicando la cantidad por el precio unitario que corresponda.
Por ejemplo: subtotal del ítem = cantidad × precio unitario aplicado

RN3 — Cálculo del total bruto del pedido: El total bruto es la suma de todos los subtotales de los productos incluidos en el pedido.
En palabras simples: total bruto = subtotal impresión B/N + subtotal impresión color + subtotal anillado

RN4 — Criterios de descuento

El sistema debe aplicar un solo tipo de descuento, de acuerdo con las siguientes condiciones y en este orden de prioridad:
Descuento combinado del 10%:
Se aplica si el pedido incluye al menos un anillado y la suma total de impresiones (blanco y negro más color) es igual o mayor a 30 unidades.

Descuento por monto del 5%:
Se aplica únicamente si no se cumple la primera condición y el total bruto es mayor a 40.000 pesos.

Sin descuento:
Si no se cumplen ninguna de las condiciones anteriores, no se aplica descuento. Si el pedido cumple con más de una condición, solo se aplica la de mayor prioridad, es decir, la del 10%.

RN5 — Cálculo del descuento y total final

El valor del descuento se obtiene multiplicando el total bruto por el porcentaje correspondiente (10%, 5% o 0%).
Luego, el total final se calcula restando ese valor al total bruto.
descuento = total bruto × porcentaje aplicado
total final = total bruto − descuento

RN6 — Estados del pedido

El pedido puede estar en dos estados:

En creación: mientras el pedido no se haya confirmado. En este estado se pueden agregar o eliminar productos, y calcular totales.
Confirmado: una vez confirmado, el pedido queda bloqueado y ya no se pueden hacer modificaciones. Solo se puede consultar o imprimir el resumen.

RN7 — Restricciones de validación

No se permiten cantidades menores o iguales a cero.
No se pueden crear pedidos vacíos.
No se pueden modificar pedidos que ya estén confirmados.

RN8 — Formato del resumen

El resumen que genera el sistema después de confirmar un pedido debe incluir la siguiente información:

Datos del cliente: nombre y teléfono.
Detalle de los ítems: nombre del producto, cantidad, precio unitario aplicado y subtotal.
Total bruto del pedido.
Descuento aplicado (porcentaje y valor).
Total final a pagar.


CRITERIOS DE ACEPTACION:


CA1 — Registro de cliente

El sistema debe solicitar el nombre y teléfono del cliente antes de crear un pedido.

No se puede dejar el nombre vacío ni ingresar un número de teléfono no numérico.

Al registrar los datos correctamente, el sistema debe confirmar con un mensaje del tipo “Cliente registrado exitosamente”.

CA2 — Creación de pedido

Solo se puede crear un pedido si existe un cliente registrado.

El pedido debe comenzar en estado “EN_CREACIÓN”.

Si se intenta crear un pedido sin cliente, el sistema debe mostrar un mensaje de error.

Si los valores ingresados para las cantidades de productos son menores o iguales a cero, el sistema debe mostrar una advertencia e impedir el registro del pedido.

CA3 — Aplicación de precios por volumen

Cuando la cantidad de impresiones B/N sea menor a 100, el sistema debe aplicar el precio normal de 200 por unidad.

Si la cantidad es igual o superior a 100, debe aplicar el precio reducido de 150 por unidad.

Cuando la cantidad de impresiones a color sea menor a 50, el sistema debe aplicar el precio normal de 500 por unidad.

Si la cantidad es igual o superior a 50, debe aplicar el precio reducido de 400 por unidad.

El precio de anillado siempre debe ser 3.000 sin importar la cantidad.

CA4 — Cálculo del total bruto

El sistema debe calcular el subtotal de cada ítem multiplicando la cantidad por el precio unitario aplicado.

Luego debe sumar todos los subtotales para obtener el total bruto.

El resultado debe mostrarse en pantalla antes de aplicar descuentos.

CA5 — Cálculo de descuentos

Si el pedido incluye al menos un anillado y el total de impresiones (B/N + color) es igual o mayor a 30, el sistema debe aplicar un 10% de descuento sobre el total bruto.

Si no se cumple la condición anterior pero el total bruto es mayor a 40.000, el sistema debe aplicar un 5% de descuento.

En caso de que ninguna condición se cumpla, no debe aplicarse ningún descuento.

Solo se puede aplicar un tipo de descuento por pedido.

CA6 — Cálculo del total final

El sistema debe mostrar el valor del descuento aplicado y luego el total final (total bruto menos descuento).

El total final nunca debe ser negativo ni mayor al total bruto.

El valor del descuento y el total final deben mostrarse con formato numérico claro.

CA7 — Confirmación del pedido

Al confirmar el pedido, el sistema debe cambiar su estado a “CONFIRMADO”.

Una vez confirmado, ya no se puede modificar ninguna cantidad ni eliminar productos.

Si se intenta modificar un pedido confirmado, debe mostrarse un mensaje de advertencia indicando que el pedido está bloqueado.

CA8 — Generación del resumen

Tras confirmar el pedido, el sistema debe mostrar un resumen con los siguientes datos:

Nombre y teléfono del cliente.

Nombre de cada producto, cantidad, precio unitario aplicado y subtotal.

Total bruto del pedido.

Descuento aplicado (porcentaje y valor).

Total final a pagar.

Todos los valores deben aparecer correctamente alineados y legibles.

El resumen debe poder imprimirse o visualizarse en pantalla.


DISEÑO CLASES Y UML:

![image](./assets/Diagrama%20de%20Clases%20UML%20(1).png)

1. Clase Cliente

Responsabilidad: Representar la información básica del cliente que realiza el pedido.

Atributos:
nombre : String
telefono : double

Métodos:
getNombre() : String
getTelefono() : double
setNombre(nombre : String) : void
setTelefono(telefono : double) : void

2. Clase Producto

Responsabilidad: Representar un producto disponible en el catálogo (Impresión B/N, Impresión Color o Anillado).

Atributos:
nombre : String
precioUnitario : double

Métodos:
getNombre() : String
getPrecioUnitario() : double
setPrecioUnitario(precio : double) : void

3. Clase ItemPedido

Responsabilidad: Asociar un producto con una cantidad específica dentro de un pedido y calcular su subtotal.

Atributos:
producto : Producto
cantidad : int
subtotal : double

Métodos:
calcularSubtotal() : double
getProducto() : Producto
getCantidad() : int
getSubtotal() : double

4. Clase Pedido

Responsabilidad: Gestionar la información completa del pedido, aplicando precios por volumen, descuentos y generando el resumen final.

Atributos:
cliente : Cliente
items : ArrayList<ItemPedido>
estado : String
totalBruto : double
descuento : double
totalFinal : double

Métodos:
agregarItem(item : ItemPedido) : void
calcularPreciosPorVolumen() : void
calcularTotalBruto() : double
calcularDescuento() : double
calcularTotalFinal() : double
confirmarPedido() : void
generarResumen() : void

5. Clase App

Responsabilidad: Controlar el flujo del programa (crear cliente, crear pedido, ingresar ítems, calcular, confirmar y mostrar resumen).

Métodos principales:
main(String[] args) : void
mostrarMenu() : void
registrarCliente() : void
crearPedido() : void
confirmarPedido() : void
mostrarResumen() : void

FLUJO DE CONSOLA:

Ingresar cliente.
Crear pedido.
Seleccionar producto y cantidad.
Mostrar resumen: detalle con precio aplicado, subtotal por ítem, total bruto, descuento y total final.
Confirmar pedido.
Intentar editar después de la confirmación → debe fallar.

