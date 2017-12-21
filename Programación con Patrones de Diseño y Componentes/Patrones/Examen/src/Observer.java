public interface Observer {
	public int[] getDias();
	public int getHora();
	public String getTipo();
	public void update(Observable a);
}
