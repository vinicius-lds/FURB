from Graph import Graph


def test():
    for graph in graphs:
        graph.connected_components()


graphs = list()
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

test()
