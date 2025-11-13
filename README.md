
# Papelería “Punto & Coma”

En Punto & Coma, estudiantes e independientes hacen encargos de impresión y anillado para recoger el mismo día. El sistema registra nombre y teléfono del cliente y permite crear un pedido con ítems de este catálogo: Impresión B/N ($200 c/u, o $150 c/u si son 100 o más), Impresión Color ($500 c/u, o $400 c/u si son 50 o más), y Anillado ($3.000 c/u, sin precio por volumen). El cálculo funciona así: primero determinar subtotales por ítem aplicando precio por volumen cuando corresponda; luego sumar el total bruto; después aplicar un solo beneficio: si el pedido incluye al menos un anillado y la suma de impresiones (B/N + Color) es ≥ 30, se aplica 10% de descuento; de lo contrario, si el total bruto > $40.000, aplicar 5% de descuento; si ninguna condición se cumple, no hay descuento. No se aceptan cantidades ≤ 0. Tras confirmar el pedido, queda bloqueado y el sistema debe mostrar un resumen con detalle (precio aplicado por ítem), total bruto, descuento y total final. No se gestiona inventario ni pagos: solo el flujo de crear → calcular → confirmar → resumir.



rf1. registrar: nombre (string) y telefono del cliente (double)
rf2. crear pedido: impresion1 (int, b/n) impresion2 (int , color) anillado (int)
rf3. aplicar precio por volumen: impresion1 (int, b/n ≥ 100 150) impresionz (int , color ≥50 400) anillado (int)
rf4. calcular descuento: calculo1: anillado + (B/N + Color) es ≥ 30 con un 10% , calculo2: total › 40.000 con un 5% , galculo3 = (calculo1 + calculoz)
rf5. reportar: total final(double) = (impresion1+impresion2+anillado+calcul01+calculo2+calculo3)rf1. registrar: nombre (string) y telefono del cliente (double)
rf2. crear pedido: impresion1 (int, b/n) impresion2 (int , color) anillado (int)
rf3. aplicar precio por volumen: impresion1 (int, b/n ≥ 100 150) impresionz (int , color ≥50 400) anillado (int)
rf4. calcular descuento: calculo1: anillado + (B/N + Color) es ≥ 30 con un 10% , calculo2: total › 40.000 con un 5% , galculo3 = (calculo1 + calculoz)
rf5. reportar: total final(double) = (impresion1+impresion2+anillado+calcul01+calculo2+calculo3)
