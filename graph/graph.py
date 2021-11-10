# A class to represent a graph object
class Graph:
    # Constructor
    def __init__(self, edges, n):
 
        # A list of lists to represent an adjacency list
        self.adjList = [[] for _ in range(n)]
 
        # add edges to the directed graph
        for (src, dest) in edges:
            self.adjList[src].append(dest)
        
    # Function to print adjacency list representation of a graph
    def printGraph(graph):
        for src in range(len(graph.adjList)):
            # print current vertex and all its neighboring vertices
            for dest in graph.adjList[src]:
                print(f'({src} —> {dest}) ', end='')
            print()

if __name__ == "__main__":
    edges = [(0, 1), (1, 2), (2, 0), (2, 1), (3, 2), (4, 5), (5, 4)]
    graph = Graph(edges, 6)
    print(graph.adjList)