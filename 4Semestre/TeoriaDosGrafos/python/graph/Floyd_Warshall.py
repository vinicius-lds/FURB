from copy import deepcopy
from Util import infinity


def floyd_warshall(graph):
    dist = deepcopy(graph.adjacency_matrix)
#    next = deepcopy(graph.adjacency_matrix)
    v = len(dist)

#    for x in range(v):
#        for y in range(v):
#            if dist[x][y] < infinity and x != y:
#                next[x][y] = dist[x][y]
#            else:
#                next[x][y] = None

    for k in range(v):
        for i in range(v):
            for j in range(v):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
#                    next[i][j] = i
#    print_table(next)
#    print()
#    print_table(dist)

    return str_dist(dist)
#    return str_shortest_path(next, 0, 4)


def str_shortest_path(next, start, end):
    if next[start][end] is None:
        return 'O caminho entre {} e {} não é possível!'.format(start, end)
    else:
        path = 'Caminho: { ' + str(start) + ' '
        while start != end:
            end = next[start][end]
            path += str(start) + ' '
        path += '}'
        print(path)
        return path


def str_dist(dist):
    string = str()
    for x in range(len(dist)):
        for y in range(len(dist)):
            string += ' ' + str(dist[x][y]) + ' '
        string += '\n'
    return string


def print_table(table):
    for x in range(len(table)):
        for y in range(len(table[x])):
            print(" {} ".format(table[x][y]), end='')
        print()
