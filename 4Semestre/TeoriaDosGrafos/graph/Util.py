class Util(object):
    @staticmethod
    def get_list_of(size):
        ret = list()
        for x in range(size):
            ret.append(x)
        return ret

    @staticmethod
    def get_first_adjacency(vertex, adjacency_matrix):
        for y in range(len(adjacency_matrix)):
            if adjacency_matrix[vertex][y] > 0:
                return y
        return -1

    @staticmethod
    def remove_current_vertex(adjacency_matrix, vertex):
        for y in range(len(adjacency_matrix)):
            adjacency_matrix[vertex][y] = 0

    @staticmethod
    def unite(current_vertex, next_vertex, adjacency_matrix):
        for y in range(len(adjacency_matrix)):
            adjacency_matrix[next_vertex][y] += adjacency_matrix[current_vertex][y]

    @staticmethod
    def current_set_contains_any(current_set, adjacent_vertices):
        if isinstance(current_set, set):
            for x in range(len(adjacent_vertices)):
                if current_set.__contains__(adjacent_vertices[x]):
                    return True
            return False
        else:
            raise Exception
