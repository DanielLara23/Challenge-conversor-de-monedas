# CONVERSOR DE MONEDAS

Es un programa que consume la API de "ExchangeRate-API" para hacer conversiones entre las monedas disponibles que se muestran al ejecutar el programa.

## Funcionalidades

El programa puede hacer la conversión de monedas de cualquier combinación que el usuario escoja siempre y cuando las opciones estén disponibles dentro del programa; de lo contrario, marcará error.

Las opciones de conversión disponibles son las siguientes:
1. Peso argentino.
2. Boliviano boliviano.
3. Real brasileño.
4. Peso chileno.
5. Peso colombiano.
6. Dólar estadounidense.
7. Peso mexicano.

## Uso

Al ejecutar el programa, este comienza en el menú principal donde el usuario tiene que escoger entre hacer una conversión entre monedas, ver su historial de conversiones o salir del programa. Para moverse entre este menú, tiene que digitar el índice (número) correspondiente a la opción que desea escoger.

<img width="400" alt="menu1" src="https://github.com/DanielLara23/Challenge-conversor-de-monedas/assets/87244346/d9fa942c-bc4a-4c06-b4e3-c65884a45708">

Si decide escoger la opción 2 para mostrar el historial sin antes haber realizado una consulta, el programa mostrará un mensaje indicando que su historial está vacío y redirigirá al menú principal.

<img width="507" alt="historialVacio" src="https://github.com/DanielLara23/Challenge-conversor-de-monedas/assets/87244346/073d4645-9a08-4c4c-83db-32e7efedfabe">

Al escoger la opción 1, te mostrará otro menú donde se muestran las monedas disponibles para hacer la conversión y pedirá que introduzcas el índice de la moneda base, la cantidad de monedas a convertir y el índice de la moneda de destino para posteriormente hacer la consulta y mostrar en la terminal el resultado de la conversión. Además, preguntará si deseas realizar otra consulta o no. En caso de poner valores incorrectos como letras, números negativos o índices de monedas no disponibles, el programa indicará que hay un error y pedirá nuevamente que el usuario introduzca los valores requeridos.

<img width="489" alt="menu2" src="https://github.com/DanielLara23/Challenge-conversor-de-monedas/assets/87244346/c8dd7abc-9fed-4ad6-9c25-5a314a75f6e7">

Si regresa al menú principal para ver el historial después de haber realizado una consulta o más, el programa mostrará información importante como:
- La fecha y hora en que se realizó la consulta.
- El código de la moneda base.
- La cantidad de monedas a convertir.
- El código de la moneda de destino.
- El tipo de cambio (El valor de la moneda base en la moneda de destino).
- El resultado de la conversión.

Para salir del programa solo se tiene que regresar al menú principal y pulsar la opción 3.

## Requisitos

- API-KEY de ExchangeRate-API (link para conseguir API-KEY: [ExchangeRate-API](https://www.exchangerate-api.com)).
- Java 8 o superior.
- Un entorno de desarrollo integrado (IDE) como Eclipse o IntelliJ IDEA.

## Autor

Daniel Sanchez Lara.

## Licencia

Este proyecto está bajo la licencia MIT.

## Problemas conocidos

No hay problemas conocidos en este momento.
