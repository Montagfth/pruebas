import matplotlib.pyplot as plt
import numpy as np

# Datos de los tiempos (en nanosegundos)
nombres = ['Burbuja', 'Por Selección', 'Por Inserción', 'Quicksort', 'Mergesort', 'Shellsort']
tiempos = [
    [4000, 3400, 3200, 3400, 4600],
    [5400, 5300, 5300, 7300, 6100],
    [1900, 1900, 1900, 1900, 1900],
    [8200, 7300, 6800, 6600, 6600],
    [15100, 10200, 8100, 10400, 9700],
    [49280, 43190, 47130, 47110, 47950]
]

# Colores para cada conjunto de datos
colores = ['#1f77b4', '#ff7f0e', '#2ca02c', '#d62728', '#9467bd']

# Posiciones para las barras
x = np.arange(len(nombres))
ancho = 0.15  # ancho de las barras

# Crear la figura
fig, ax = plt.subplots(figsize=(10, 6))

# Dibujar las barras para cada serie
for i in range(5):
    tiempos_i = [tiempos[j][i] for j in range(len(nombres))]
    ax.bar(x + i*ancho, tiempos_i, width=ancho, label=f'Ejecución {i+1}', color=colores[i])

# Etiquetas y títulos
ax.set_xlabel('Algoritmo de ordenamiento')
ax.set_ylabel('Tiempo (nanosegundos)')
ax.set_title('Gráfico de tiempos')
ax.set_xticks(x + 2*ancho)
ax.set_xticklabels(nombres)
ax.legend()

# Mostrar la cuadrícula
ax.grid(True, linestyle='--', alpha=0.5)

# Mostrar el gráfico
plt.tight_layout()
plt.show()
