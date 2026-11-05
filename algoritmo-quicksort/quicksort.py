def quicksort(lista, inicio=0, fin=None):
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
    _colocar_pivote_mediana(lista, inicio, fin)

    pivote = lista[fin]
    i = inicio - 1  

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
