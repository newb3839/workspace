import mpi.*;
public class CS460TestTwo {

	public static void main(String[] args) {
		try{
			
			MPI.Init(args);
			int rank = MPI.COMM_WORLD.Rank();
			int size = MPI.COMM_WORLD.Size();
			if (my_rank == 0) 
			{
				number = -1;
				MPI_Send((void *)&number, 1, MPI_INT, 1, 0, MPI_COMM_WORLD);
			}
			else if (my_rank == 1)
			{
				MPI_Recv((void *)&number, 1, MPI_INT, 0, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
				cout << "Process 1 received number " << number << " from process 0" << endl;
			}
			
			//System.out.println("Hello World");
			System.out.println("Hello World, I'm " + rank + " of " + size);
			MPI.Finalize();
		}catch(Exception ignore){
			System.out.println("Something went wrong during execution, please try again.");
		}

	}
}
