from Graph import Graph


def test():
    for x in range(len(graphs)):
        graphs.__getitem__(x).is_bipartite()


graphs = list()
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

test()
