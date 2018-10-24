from copy import deepcopy
from Util import Util


class Graph(object):
    def __init__(self, matrix):
        self.__adjacency_matrix = matrix

    def print_adjacency_matrix(self):
        for x in range(len(self.__adjacency_matrix)):
            for y in range(len(self.__adjacency_matrix[x])):
                print(" {} ".format(self.__adjacency_matrix[x][y]), end='')
            print()

    def is_bipartite(self):
        # defines variables
        bolsonaro = set()
        lula = set()
        is_bipartite = True

        # iterates through adjacency matrix
        for x in range(len(self.__adjacency_matrix)):

            # defines if current vertex should be bolsonaro or lula
            # defines which set this particular vertex belongs, and which it doesn't
            is_bolsonaro = bolsonaro.__contains__(x)
            current_set = bolsonaro if is_bolsonaro else lula
            non_current_set = bolsonaro if not is_bolsonaro else lula

            # adds the current vertex to the current set
            current_set.add(x)
            # gets all the vertex's adjacent to the current vertex
            adjacent_vertices = list()
            for y in range(len(self.__adjacency_matrix)):
                if self.__adjacency_matrix[x][y] > 0:
                    adjacent_vertices.append(y)

            # if current set contains any of the adjacent vertex's return false
            # else adds all adjacent vertex's to the non current set
            if Util.current_set_contains_any(current_set, adjacent_vertices):
                is_bipartite = False
                break
            else:
                while len(adjacent_vertices) > 0:
                    non_current_set.add(adjacent_vertices.pop())

        # prints matrix and if this Graph is bipartite or not
        self.print_adjacency_matrix()
        print('O grafo {} bipartido!'.format('é' if is_bipartite else 'não é'))
        print()

    def goodman_algorithm(self):
        vertex_count = len(self.__adjacency_matrix)
        if vertex_count == 1:
            is_connected = True
        else:
            vertices_not_explored = Util.get_list_of(vertex_count)
            adjacency_matrix_aux = deepcopy(self.__adjacency_matrix)

            while True:
                current_vertex = vertices_not_explored.pop()
                next_vertex = Util.get_first_adjacency(current_vertex, adjacency_matrix_aux)
                if next_vertex < 0 or next_vertex == current_vertex:
                    if len(vertices_not_explored) > 0:
                        is_connected = False
                    else:
                        is_connected = True
                    break
                Util.unite(current_vertex, next_vertex, adjacency_matrix_aux)
                Util.remove_current_vertex(adjacency_matrix_aux, current_vertex)

        self.print_adjacency_matrix()
        print('O grafo {} conexo!'.format('é' if is_connected else 'não é'))
        print()

    def connected_components(self):
        disjointed_sets = dict()
        for x in range(len(self.__adjacency_matrix)):
            disjointed_sets[x] = set()
            disjointed_sets[x].add(x)

        for x in range(len(self.__adjacency_matrix)):
            for y in range(len(self.__adjacency_matrix[x])):
                if self.__adjacency_matrix[x][y] > 0:
                    for element in disjointed_sets[y]:
                        disjointed_sets[x].add(element)
                    disjointed_sets[y].clear()

        self.print_adjacency_matrix()
        print('Conjuntos disjuntos resultantes:')
        for key in disjointed_sets:
            current_set = disjointed_sets.get(key)
            if len(current_set) > 0:
                print(current_set)
        print()
