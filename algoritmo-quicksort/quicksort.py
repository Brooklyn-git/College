"""
Ordenamiento QuickSort (ordenamiento rápido)
=============================================

Técnica: divide y vencerás.

1. Se elige un elemento llamado pivote.
2. Se particiona la lista: los menores que el pivote quedan a su izquierda
   y los mayores a su derecha.
3. Se aplica QuickSort recursivamente a las dos sublistas.

Complejidad:
- Mejor caso / caso promedio: O(n log n)
- Peor caso: O(n^2)  (por ejemplo, lista ya ordenada con pivote en un extremo)
- Espacio: O(log n) en promedio por la pila de recursión (ordenamiento in-place)

En esta implementación se usa el esquema de partición de Lomuto y se elige
el pivote como la mediana de tres (primero, medio, último) para reducir la
probabilidad del peor caso.
"""


def quicksort(lista, inicio=0, fin=None):
    """Ordena `lista` de menor a mayor, in-place, y la retorna.

    Parámetros:
        lista: secuencia mutable de elementos comparables.
        inicio: índice inicial del segmento a ordenar (por defecto 0).
        fin: índice final inclusive (por defecto len(lista) - 1).
    """
    if fin is None:
        fin = len(lista) - 1

    if inicio < fin:
        # Índice donde queda ubicado el pivote después de particionar.
        indice_pivote = _particionar(lista, inicio, fin)

        # Ordenar la sublista izquierda (menores que el pivote).
        quicksort(lista, inicio, indice_pivote - 1)
        # Ordenar la sublista derecha (mayores que el pivote).
        quicksort(lista, indice_pivote + 1, fin)

    return lista


def _particionar(lista, inicio, fin):
    """Particiona el segmento [inicio, fin] usando el último elemento como pivote.

    Devuelve la posición final del pivote. Todos los elementos a su izquierda
    son <= pivote y todos los de su derecha son > pivote (esquema de Lomuto).
    """
    _colocar_pivote_mediana(lista, inicio, fin)

    pivote = lista[fin]
    i = inicio - 1  # Frontera de los elementos menores o iguales al pivote.

    for j in range(inicio, fin):
        if lista[j] <= pivote:
            i += 1
            lista[i], lista[j] = lista[j], lista[i]

    # Ubicar el pivote en su posición definitiva.
    lista[i + 1], lista[fin] = lista[fin], lista[i + 1]
    return i + 1


def _colocar_pivote_mediana(lista, inicio, fin):
    """Ordena primero, medio y último, y deja la mediana en `lista[fin]`.

    Esto evita elegir como pivote un extremo cuando la lista ya está ordenada
    o inversamente ordenada.
    """
    medio = (inicio + fin) // 2

    if lista[medio] < lista[inicio]:
        lista[inicio], lista[medio] = lista[medio], lista[inicio]
    if lista[fin] < lista[inicio]:
        lista[inicio], lista[fin] = lista[fin], lista[inicio]
    if lista[fin] < lista[medio]:
        lista[medio], lista[fin] = lista[fin], lista[medio]


def _demostracion():
    casos = [
        [10, 7, 8, 9, 1, 5],
        [5, 2, 8, 1, 3],
        [1, 2, 3, 4, 5],          # ya ordenada
        [5, 4, 3, 2, 1],          # inversamente ordenada
        [4, 4, 2, 4, 1, 2],       # con duplicados
        [],
        [42],                     # un solo elemento
    ]

    for original in casos:
        copia = original[:]
        resultado = quicksort(copia)
        esperado = sorted(original)
        estado = "OK" if resultado == esperado else "ERROR"
        print(f"{estado:5} {original} -> {resultado}")


if __name__ == "__main__":
    _demostracion()
