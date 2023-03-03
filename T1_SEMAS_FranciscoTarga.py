def geradorNumsAleatorios(seed, a, c, m, num_aleatorios):
    x = seed
    numeros_aleatorios = []
    for i in range(num_aleatorios):
        x = (a*x + c) % m
        num_aleatorio = x / m
        numeros_aleatorios.append(num_aleatorio)
    return numeros_aleatorios

X0 = 666666
a = 12324
c = 342423
M = 2**35

numeros_aleatorios = geradorNumsAleatorios(X0, a, c, M, 1000)
print(numeros_aleatorios)
