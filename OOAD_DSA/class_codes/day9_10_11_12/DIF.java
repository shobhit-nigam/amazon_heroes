package graphs;

public class DIF {

	static final int MAX=5;		//stack variables

		static int [] stack = new int[MAX]; 
		static int top = -1; 

		//graph variables

		//array of vertices
	static Vertex [] lstVertices= new Vertex [MAX];

		//adjacency matrix
		static int [][] adjMatrix = new int[MAX][MAX];

		//vertex count
		static int vertexCount = 0;

		//stack functions

		static void push(int item) { 
		   stack[++top] = item; 
		} 

		
		static int pop() { 
		   return stack[top--]; 
		} 

		static int peek() {
		   return stack[top];
		}

		static Boolean isStackEmpty() {
		   return top == -1;
		}

		//graph functions

		//add vertex to the vertex list
		static void addVertex(char label) {
		   Vertex vertex = new Vertex();
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

		   for(i = 0; i < vertexCount; i++) {
		      if(adjMatrix[vertexIndex][i] == 1 && lstVertices[i].visited == false) {
		         return i;
		      }
		   }

		   return -1;
		}

		static void depthFirstSearch() {
		   int i;

		   //mark first node as visited
		   if(lstVertices[0].visited == false)
		   {
			   lstVertices[0].visited = true;

			   //display the vertex
			   displayVertex(0);   

		   //push vertex index in stack
		   push(0);
		   }
		   while(!isStackEmpty()) {
		      //get the unvisited vertex of vertex which is at top of the stack
		      int unvisitedVertex = getAdjUnvisitedVertex(peek());

		      //no adjacent vertex found
		      if(unvisitedVertex == -1) {
		         pop();
		      } 
		      else {
		         lstVertices[unvisitedVertex].visited = true;
		         displayVertex(unvisitedVertex);
		         push(unvisitedVertex);
		      }
		     
		   }

		   //stack is empty, search is complete, reset the visited flag        
		   for(i = 0;i < vertexCount;i++) {
		      lstVertices[i].visited = false;
		   }        
		}

	public static void main(String[] args) {
		 int i, j;

		   for(i = 0; i < MAX; i++)    // set adjacency 
			   {
			   		for(j = 0; j < MAX; j++) // matrix to 0
			   				adjMatrix[i][j] = 0;
			   }

		   addVertex('S'); 
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

		   System.out.println("Depth First Search: ");
		   depthFirstSearch(); 
		   System.out.println("Depth First Search: ");
		   depthFirstSearch(); 
 
	}

}
