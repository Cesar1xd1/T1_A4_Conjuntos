import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class Conjunto  {
	private ArrayList<Integer> elementos= new ArrayList<>();

	public Conjunto(ArrayList<Integer> elementos) {
		super();
		this.elementos = elementos;
	}
	public Conjunto() {}
	public ArrayList getElementos() {
		return elementos;
	}
	public void setElementos(ArrayList elementos) {
		this.elementos = elementos;
	}
	public int validacion(){
		return 0;
	}
	
	
	public ArrayList<Integer> llenar(){
		System.out.println("Ingresa la cantidad de elementos: ");
		int conte = this.validacion();
		int elementos[] = {};
		for (int i = 0; i < conte; i=i+1) {
			System.out.println("El elemento "+(i+1)+": ");
			elementos=Arrays.copyOf(elementos, elementos.length+1);
			elementos[elementos.length-1]=this.validacion();
		}
        ArrayList<Integer> a = new ArrayList<>();
        for (int i: elementos) {
            a.add(i);
        }
		return a;
	}
	public ArrayList<Integer> llenar(int elementos[]){
        ArrayList<Integer> a = new ArrayList<>();
        for (int i: elementos) {
            a.add(i);
        }
		return a;
	}
	//==========================================00
	public void mostrarElementos() {
		System.out.println(this.getElementos());
	}
	//==============================================0
	public <Tem> ArrayList<Tem> eliminarDobles(ArrayList<Tem> elementos) {
		Set<Tem> set = new LinkedHashSet<>();   
        set.addAll(elementos); 
        elementos.clear(); 
        elementos.addAll(set);
        return elementos;
	}
	
	public Conjunto union(Conjunto conj, Conjunto conj1) {
		ArrayList elementos = conj.getElementos();
		
				ArrayList elementos1 = conj1.getElementos();
		
		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(elementos);
		
		
		a.addAll(elementos1);
		
		Collections.sort(a);
		a = this.eliminarDobles(a);
		
		Conjunto uni = new Conjunto(a);
		return uni;
	}
	public Conjunto interseccion(Conjunto conj, Conjunto conj1) {
		
		
		ArrayList elementos = conj.getElementos();
		
		  ArrayList elementos1 = conj1.getElementos();
		
		Collections.sort(elementos);
		elementos=this.eliminarDobles(elementos);
		Collections.sort(elementos1);
		elementos1=this.eliminarDobles(elementos1);
		
		ArrayList<Integer> a = new ArrayList<>();
	
		for (int k = 0; k < elementos.size(); k=k+1) {
			for (int j = 0; j < elementos1.size(); j++) {
				if (elementos.get(k).equals(elementos1.get(j))) {
					a.add((Integer) elementos.get(k));
					break;
				}
			}
		}
	
		Conjunto ff = new Conjunto(a);
		
		return ff;
	}
	public Conjunto diferencia(Conjunto conj, Conjunto conj1) {
		ArrayList elementos = conj1.getElementos();
		
		
		
		
		
		
		ArrayList elementos1 = conj1.getElementos();
		
		Collections.sort(elementos);
		elementos=this.eliminarDobles(elementos);
		
				
	
				
		Collections.sort(elementos1);
		elementos1=this.eliminarDobles(elementos1);
		
		ArrayList<Integer> ve = new ArrayList<>();
		ve.addAll(elementos);
		ve.removeAll(elementos1);
		
		Conjunto dif = new Conjunto(ve);
		
		return dif;
	}
	
}
public class PruebaConjunto {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		Conjunto con = new Conjunto();

		ArrayList<Integer> x = new ArrayList<>();
		int cont=0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= i; j++) {
				if (i%j==0) {
					cont+=1;
				}
			}
			if (cont==2) {
				x.add(i);
			}
			cont=0;
		}
		Conjunto cona = new Conjunto(x);
		System.out.println("El Conjunto A es: ");
		cona.mostrarElementos();
		
		ArrayList<Integer> y = new ArrayList<>();
		int gra = 350;
		for (int i = 1; i <= gra; i=i+1) {
			if (gra%i==0) {
				y.add(i);
			}
		}
		Conjunto conb = new Conjunto(y);
		System.out.println("El Conjunto B es: ");
		conb.mostrarElementos();
		
		System.out.println("La union de AB:");
		con = con.union(cona, conb);
		con.mostrarElementos();
		
		System.out.println("La Intersección de AB: ");
		con = con.interseccion(cona, conb);
		con.mostrarElementos();
		
		System.out.println("La Diferencia de AB: ");
		con = con.diferencia(cona, conb);
		con.mostrarElementos();
		
		System.out.println("La Diferencia de BA: ");
		con = con.diferencia(conb, cona);
		con.mostrarElementos();
		
		System.out.println("==========MENU==========");
		System.out.println();
		byte opcion = 0;
		
		Conjunto conjunto1 = new Conjunto();
		Conjunto conjunto2 = new Conjunto();
		Conjunto q = new Conjunto();
		
		
		do {
			System.out.println("Digite 1 para llenar el 'conjunto' 1");
			System.out.println("Digite 2 para llenar el 'conjunto' 2");
			System.out.println("Digite 3 para mostrar los elementos del 'conjunto' 1");
			System.out.println("Digite 4 para mostrar los elementos del 'conjunto' 2");
			System.out.println("Digite 5 para mostrar la union de los 'conjuntos'");
			System.out.println("Digite 6 para mostrar la interseccion de los 'conjuntos'");
			System.out.println("Digite 7 para mostrar la diferencia del conjunto 1 menos el conjunto 2 o");
			System.out.println("Digite 8 para hacerlo visebersa");
			System.out.println("Digite 9 para ***SALIR***");		

			opcion=(byte)q.validacion();
			opcion = entrada.nextByte();
			
			switch (opcion) {
			case 1:
				conjunto1= new Conjunto(con.llenar());
				break;
			case 2:
				conjunto2= new Conjunto(con.llenar());
				break;
			case 3:
				conjunto1.mostrarElementos();
				break;
			case 4:
				conjunto2.mostrarElementos();
				break;
			case 5:
				con = con.union(conjunto1, conjunto2);
				con.mostrarElementos();
				break;
			case 6:
				con = con.interseccion(conjunto1, conjunto2);
				con.mostrarElementos();
				break;
			case 7:
				con = con.diferencia(conjunto1, conjunto2);
				con.mostrarElementos();
				break;
			case 8:
				con = con.diferencia(conjunto1, conjunto1);
				con.mostrarElementos();
				break;
			case 9:break;
			default:
				System.out.println("Opcion invalida!");
				break;
			}
			
		} while (opcion!=9);
		System.out.println("Fin del programa, gracias por usarlo");
		
		
	}
	}


