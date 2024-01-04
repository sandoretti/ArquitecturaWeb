def generar_combinaciones(id_proyeccion, num_filas, num_columnas):
    # Generar combinaciones
    tuples_list = [(id_proyeccion, i, j) for i in range(1, num_filas + 1) for j in range(1, num_columnas + 1)]

    # Retornar la lista de tuplas generadas
    return tuples_list

# Ejemplo de uso
id_proyeccion = 10
num_filas = 10
num_columnas = 20

resultado = generar_combinaciones(id_proyeccion, num_filas, num_columnas)

# Imprimir el resultado con filas juntas sin corchetes y con coma al final de cada fila
for i in range(len(resultado) // num_columnas):
    fila = resultado[i * num_columnas: (i + 1) * num_columnas]
    print(', '.join(map(str, fila)) + ',')
