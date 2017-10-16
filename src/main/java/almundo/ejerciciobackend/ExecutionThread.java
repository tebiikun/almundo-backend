package almundo.ejerciciobackend;

/**
 * Hello world!
 *
 */
public class ExecutionThread implements Runnable
{
	private Dispatcher dispatcher;
	private Integer id;
	public ExecutionThread(Dispatcher dispatcher, Integer id) {
		this.dispatcher = dispatcher;
		this.id = id;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			dispatcher.dispatchCall(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
