import mpi.*;
public class JavaTest {

	public static void main(String[] args) 
	{
		try {
			MPI.Init(args);
			int rank = MPI.COMM_WORLD.getRank(), size = MPI.COMM_WORLD.getSize();
			//System.out.println("Hello World");
			System.out.println("Hello World, I'm " + rank + " of " + size);
			MPI.Finalize();
		}
        catch (MPIException e) {
            // Do something here
        }
	}
}
