import java.util.*;
public class PrincipalApp {
	static Scanner nd = new Scanner(System.in);
	public static void main(String[] args) {
		int opc, opcion;
		ArrayList<Caja> cajas = new ArrayList<Caja>();
		cajas.add(new Caja("Caja1", 20));cajas.add(new Caja("Caja2", 5));
		do {
			System.out.println("¿Que quieres hacer? \n"
					+ "1. Crear caja \n"
					+ "2. Eliminar caja \n"
					+ "3. Modificar Caja \n"
					+ "4. Imprimir Cajas \n"
					+ "5. Salir");
			opc = nd.nextInt();
			System.out.println("---------------------------");
			
			switch(opc) {
			case 1:
				crearCajas(cajas);
				break;
			case 2:
				eliminarCajas(cajas);
				break;
			case 3:
				if(cajas.isEmpty()) {
					System.out.println("No hay ninguna caja creada");
				}else {
					System.out.println("¿Que quieres hacer? \n"
								+ "1. Ingresar dinero \n"
								+ "2. Retirar dinero \n"
								+ "3. Transferir saldo \n"
								+ "4. Caja Max");
					System.out.println("---------------------------");
					opcion = nd.nextInt();
					
					switch(opcion) {
					case 1:
						ingresarSaldo(cajas);
						break;
					case 2:
						retirarSaldo(cajas);
						break;
					case 3:
						transferirSaldo(cajas);
						break;
					case 4:
						cajaMax(cajas);
						break;
					}
				}
				break;
			case 4:
				imprimirCajas(cajas);
				break;
			}
		}while(opc!=5);
	}

	private static void cajaMax(ArrayList<Caja> cajas) {
		int cajaMax = 0;
		for(int i=0; i<cajas.size(); i++) {
			if(cajaMax<cajas.get(i).getSaldo()) {
				cajaMax = cajas.get(i).getSaldo();
			}
		}
		for(int i=0; i<cajas.size(); i++) {
			if(cajas.get(i).getSaldo()==cajaMax) {
				System.out.println("La caja que tiene mas dinero es: " + cajas.get(i).toString());
			}
		}
		System.out.println("---------------------------");
	}

	private static void transferirSaldo(ArrayList<Caja> cajas) {
		int cant, num, n;
		imprimirCajas(cajas);
		num = seleccionarCaja();
		System.out.println("---------------------------");
		imprimirCajas(cajas);
		System.out.println("¿A que caja le vas a transferir el dinero?");
		n = nd.nextInt();
		System.out.println("---------------------------");
		System.out.println("¿Cuanto quieres transferir?");
		cant = nd.nextInt();
		if(cajas.get(num).getSaldo()>cant) {
			cajas.get(n).Ingresar(cant);
			cajas.get(num).Quitar(cant);
		}else {
			System.out.println("No dispone de tanto saldo");
		}
		System.out.println("---------------------------");
	}

	private static void retirarSaldo(ArrayList<Caja> cajas) {
		int retirar, num;
		imprimirCajas(cajas);
		num = seleccionarCaja();
		System.out.println("¿Cuanto vas a retirar de la caja?");
		retirar = nd.nextInt();
		if(cajas.get(num).getSaldo()>retirar) {
			cajas.get(num).Quitar(retirar);
		}else {
			System.out.println("No hay tanto saldo en la caja");
		}
		System.out.println("---------------------------");
	}

	private static int seleccionarCaja() {
		int num;
		System.out.println("¿En que cajas estas?");
		num = nd.nextInt();
		return num;
	}

	private static void ingresarSaldo(ArrayList<Caja> cajas) {
		int ingresar, num;
		imprimirCajas(cajas);
		num = seleccionarCaja();
		System.out.println("¿Cuanto vas a ingresar en la caja?");
		ingresar = nd.nextInt();
		cajas.get(num).Ingresar(ingresar);
		System.out.println("---------------------------");
	}

	private static void eliminarCajas(ArrayList<Caja> cajas) {
		int C;
		if(cajas.isEmpty()) {
			System.out.println("No hay ninguna caja creada");
			System.out.println("---------------------------");
		}else {
			System.out.println("¿Que caja quieres eliminar?");
			C = nd.nextInt();
			System.out.println("---------------------------");
			
			if(!cajas.contains(C)){
				System.out.println("Esa caja no exite");
				System.out.println("---------------------------");
			}else {
				cajas.remove(C);
				
			}
		}
	}
	
	private static void crearCajas(ArrayList<Caja> cajas) {
		int C, cant;
		String nombre;
		System.out.println("¿Cuantos cajas quieres hacer?");
		C = nd.nextInt();
		
		for(int i=0; i<C; i++) {
			System.out.println("Nombre de la caja");
			nombre = nd.next();
			System.out.println("Saldo de la caja");
			cant = nd.nextInt();
			if(cajas.contains(nombre)) {
				System.out.println("Esa caja ya existe");
				System.out.println("---------------------------");
			}else {
				cajas.add(new Caja(nombre, cant));
			}
		}
		System.out.println("---------------------------");
	}
	
	public static void imprimirCajas(ArrayList<Caja> cajas) {
		for(int i=0; i<cajas.size(); i++) {
			System.out.println(i + ". " + cajas.get(i).toString());
		}
		System.out.println("---------------------------");
	}
}
