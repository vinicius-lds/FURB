from Util import infinity


def dijkstra(graph, source, end):
    source -= 1
    end -= 1
    v_size = len(graph.adjacency_matrix)
    if source >= v_size or source < 0 or end >= v_size or end < 0:
        return '{} e/ou {} são vértices inválidos!'.format(source, end)
    v = []  # vertices
    d = []  # distancia total percorrida
    l = []  # visitado
    p = []  # anterior
    for x in range(v_size):
        v.append(x)
        p.append(None)
        if x == source:
            d.append(0)
            l.append(True)
        else:
            d.append(infinity)
            l.append(False)

    current_v = source
    while current_v != end and current_v is not -1:
        neighbors = get_neighbors(graph, current_v)
        l[current_v] = True
        for x in neighbors:
            alt = d[current_v] + graph.adjacency_matrix[current_v][x]
            if alt < d[x]:
                d[x] = alt
                p[x] = current_v
        current_v = get_closest_v(v, d, l)

    return wrap_search(v, d, p, source, end)


def wrap_search(v, d, p, source, end):
    #  vertice, distancia percorrida até ele
    aux = []
    current = end
    while current != source:
        aux.append([current, d[current]])
        current = p[current]
        if current is None:
            return 'Não existe um caminho  entre {} e {}.'.format(source, end)

    result = 'Caminho resultante: ' + str(source)
    for x in range(len(aux) - 1, -1, -1):
        result += '->' + str(aux[x][0]) + '(' + str(aux[x][1]) + ')'
    return result


def get_closest_v(v, d, l):
    smallest_distance = infinity
    closest_v = -1
    for x in range(len(v)):
        if smallest_distance > d[x] and not l[x]:
            smallest_distance = d[x]
            closest_v = x
    return closest_v


def get_neighbors(graph, v):
    neighbors = []
    for y in range(len(graph.adjacency_matrix[v])):
        if graph.adjacency_matrix[v][y] != infinity and graph.adjacency_matrix[v][y] > 0:
            neighbors.append(y)
    return neighbors
