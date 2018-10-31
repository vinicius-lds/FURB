from Graph import Graph
from Dijkstra import dijkstra
from Floyd_Warshall import floyd_warshall
from Util import infinity


def test():
    for graph in graphs:
        print(floyd_warshall(graph))


v = infinity
graphs = list()
graphs.append(Graph([
    [0, 3, 8, v, -4],
    [v, 0, v, 1, 7],
    [v, 4, 0, v, v],
    [2, v, -5, 0, v],
    [v, v, v, 6, 0],
]))
'''''''''
graphs.append(Graph([
    [0, 4, 7, 6, v],
    [4, 0, 1, 3, v],
    [7, 1, 0, v, 3],
    [6, 3, v, 0, v],
    [v, v, 3, v, 0]
]))
graphs.append((Graph([
    [0, 2, v, v, 10],
    [v, 0, 3, v, 7],
    [v, v, 0, 4, v],
    [v, v, v, 0, v],
    [v, v, 8, 5, 0]
])))
graphs.append(Graph([
    # a|b |c |d |e |f |g |h |i |j
    [0, 1, 1, 0, 0, 0, 0, 0, 0, 0],  # a
    [1, 0, 1, 1, 0, 0, 0, 0, 0, 0],  # b
    [1, 1, 0, 0, 0, 0, 0, 0, 0, 0],  # c
    [0, 1, 0, 0, 0, 0, 0, 0, 0, 0],  # d
    [0, 0, 0, 0, 0, 1, 1, 0, 0, 0],  # e
    [0, 0, 0, 0, 1, 0, 0, 0, 0, 0],  # f
    [0, 0, 0, 0, 1, 0, 0, 0, 0, 0],  # g
    [0, 0, 0, 0, 0, 0, 0, 0, 1, 0],  # h
    [0, 0, 0, 0, 0, 0, 0, 1, 0, 0],  # i
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]   # j
]))
graphs.append(Graph([
    [0, 1, 1],
    [1, 0, 1],
    [1, 1, 0]
]))
graphs.append(Graph([
    [0, 0, 0, 0, 1],
    [0, 0, 0, 0, 1],
    [0, 0, 0, 0, 1],
    [0, 0, 0, 0, 1],
    [1, 1, 1, 1, 0]
]))
graphs.append(Graph([
    [0, 0, 1, 0],
    [0, 0, 0, 1],
    [1, 0, 0, 0],
    [0, 1, 0, 0]
]))
graphs.append(Graph([
    [0, 1, 0],
    [1, 0, 0],
    [0, 0, 0]
]))
'''''''''
test()
