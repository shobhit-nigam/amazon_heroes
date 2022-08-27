package graphs;

public class BIF {
	final static int MAX=5;
	static int [] queue=new int[MAX];
	static int rear = -1;
	static int front = 0;
	static int queueItemCount = 0;

	//graph variables

	//array of vertices
	 static Vertex [] lstVertices=  new  Vertex[MAX];

	//adjacency matrix
	static int [][] adjMatrix= new int[MAX][MAX];

	//vertex count
	static int vertexCount = 0;

	//queue functions

	static void insert(int data) {
	   queue[++rear] = data;
	   queueItemCount++;
	}

	static int removeData() {
	   queueItemCount--;
	   return queue[front++]; 
	}

	static Boolean isQueueEmpty() {
	   return queueItemCount == 0;
	}

	//graph functions

	//add vertex to the vertex list
	static void addVertex(char label) {
	   Vertex  vertex = new Vertex();
	   vertex.label = label;  
	   vertex.visited = false;     
	   lstVertices[vertexCount++] = vertex;
	}

	//add edge to edge array
	static void addEdge(int start,int end) {
	   adjMatrix[start][end] = 1;
	   adjMatrix[end][start] = 1;
	}
	

	//display the vertex
	static void displayVertex(int vertexIndex) {
	   System.out.println(lstVertices[vertexIndex].label);
	}       

	//get the adjacent unvisited vertex
	static int getAdjUnvisitedVertex(int vertexIndex) {
	   int i;
		
	   for(i = 0; i<vertexCount; i++) {
	      if(adjMatrix[vertexIndex][i] == 1 && lstVertices[i].visited == false)
	         return i;
	   }
		
	   return -1;
	}

	static void breadthFirstSearch() {
	   int i;

	   //mark first node as visited
	   lstVertices[0].visited = true;

	   //display the vertex
	   displayVertex(0);   

	   //insert vertex index in queue
	   insert(0);
	   int unvisitedVertex;

	   while(!isQueueEmpty()) {
	      //get the unvisited vertex of vertex which is at front of the queue
	      int tempVertex = removeData();   //4

	      //no adjacent vertex found
	      while((unvisitedVertex = getAdjUnvisitedVertex(tempVertex)) != -1) {    
	         lstVertices[unvisitedVertex].visited = true;
	         displayVertex(unvisitedVertex);
	         insert(unvisitedVertex);               
	      }
			
	   }   

	   //queue is empty, search is complete, reset the visited flag        
	 /*  for(i = 0;i<vertexCount;i++) {
	      lstVertices[i].visited = false;
	   }*/    
	   rear = -1;
	front = 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;

		   for(i = 0; i<MAX; i++) // set adjacency 
		   {
			   		for(j = 0; j<MAX; j++) // matrix to 0
			   				adjMatrix[i][j] = 0;
			}

		   addVertex('S');   // 0
		   addVertex('A');   // 1
		   addVertex('B');   // 2
		   addVertex('C');   // 3
		   addVertex('D');   // 4
		 
		   addEdge(0, 1);    // S - A
		   addEdge(0, 2);    // S - B
		   addEdge(0, 3);    // S - C
		   addEdge(1, 4);    // A - D
		   addEdge(2, 4);    // B - D
		   addEdge(3, 4);    // C - D
		   
			
		  System.out.println("\nBreadth First Search: ");
		   
		   breadthFirstSearch();
		   breadthFirstSearch();
		}

}
