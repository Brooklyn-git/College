# QuickSort en Python

Implementación educativa del algoritmo de ordenamiento **QuickSort** usando el
esquema de partición de **Lomuto** y pivote por **mediana de tres**.

## Archivos

- `quicksort.py`: implementación del algoritmo y una demostración ejecutable.

## Cómo ejecutarlo

```bash
python3 quicksort.py
```

Salida esperada:

```
OK    [10, 7, 8, 9, 1, 5] -> [1, 5, 7, 8, 9, 10]
OK    [5, 2, 8, 1, 3] -> [1, 2, 3, 5, 8]
OK    [1, 2, 3, 4, 5] -> [1, 2, 3, 4, 5]
OK    [5, 4, 3, 2, 1] -> [1, 2, 3, 4, 5]
OK    [4, 4, 2, 4, 1, 2] -> [1, 2, 2, 4, 4, 4]
OK    [] -> []
OK    [42] -> [42]
```

## ¿Cómo funciona?

QuickSort es un algoritmo de **divide y vencerás**:

1. **Elegir un pivote**: en este caso, la mediana entre el primer elemento, el
   del medio y el último.
2. **Particionar**: recorrer el segmento y mover los elementos menores o iguales
   al pivote hacia la izquierda. Al final, el pivote queda en su posición
   definitiva.
3. **Recursión**: aplicar el mismo proceso a la sublista izquierda y a la
   derecha del pivote.

La recursión termina cuando el segmento tiene 0 o 1 elementos (`inicio >= fin`).

## Complejidad

| Caso | Tiempo |
| --- | --- |
| Mejor caso | O(n log n) |
| Caso promedio | O(n log n) |
| Peor caso | O(n²) |

- **Espacio**: O(log n) en promedio por la pila de llamadas recursivas.
- **Estabilidad**: QuickSort no es estable (puede cambiar el orden relativo de
  elementos iguales).
- **In-place**: sí, ordena la misma lista sin crear listas auxiliares.

La elección del pivote por mediana de tres reduce la probabilidad de caer en el
peor caso cuando la lista ya está ordenada o inversamente ordenada.

## Código principal

```python
def quicksort(lista, inicio=0, fin=None):
    if fin is None:
        fin = len(lista) - 1

    if inicio < fin:
        pivote = _particionar(lista, inicio, fin)
        quicksort(lista, inicio, pivote - 1)
        quicksort(lista, pivote + 1, fin)

    return lista
```
