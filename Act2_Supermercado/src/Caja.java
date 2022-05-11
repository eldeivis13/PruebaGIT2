
public class Caja {
	
	private String id;
	private int saldo;
	
	public Caja (String id, int saldo) {
		this.id = id;
		this.saldo = saldo;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public void Ingresar(int dinero) {
		saldo = saldo + dinero;
	}
	
	public void Quitar(int dinero) {
		saldo = saldo - dinero;
	}
	
	@Override
	public String toString() {
		return "Caja [id=" + id + ", saldo=" + saldo + "]";
	}

}
