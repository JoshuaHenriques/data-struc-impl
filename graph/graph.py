import numpy as np

if __name__ == "__main__":
	vertices = {0, 1, 2, 3, 4, 5}
	edges = {(0, 1), (1, 2), (0, 3), (1, 3), (3, 4), (2, 5), (4, 5), (2, 4)}
	## adjacencyMatrix = [[0]*len(vertices)]*len(vertices)
	adjacencyMatrix = np.zeros((len(vertices), len(vertices))).astype(int)
	adjacencyList = {}
	for vertex in vertices:
		adjacencyList[vertex] = []
	for edge in edges:
		v1 = edge[0]
		v2 = edge[1]
		adjacencyMatrix[v1][v2] = 1
		adjacencyMatrix[v2][v1] = 1
		adjacencyList[v1].append(v2)
		adjacencyList[v2].append(v1)
	print("The set of vertices of the graph is:")
	print(vertices)
	print("The set of edges of the graph is:")
	print(edges)
	print("The adjacency matrix representing the graph is:")
	print(adjacencyMatrix)
	print("The adjacency List representing the graph is:")
	print(adjacencyList)