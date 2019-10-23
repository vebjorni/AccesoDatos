package manejoFicheros;

import java.io.*;
import java.util.*;

public class escribirXML {
//prueba
	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre del fichero:");
		String nomfich = teclado.next();
		
		
		File fichero= new File("C:\\Users\\ALUMNO.AULA4-PCPROFE\\Desktop\\"+nomfich+".xml");
		fichero.createNewFile();
		
		FileWriter fw = new FileWriter(fichero);
		String[] nombre = new String[100];
		String[] apellido = new String[100];
		String[] grupo = {"DAM","ASIR","SMR"};
		int cont = 0;
		
		FileReader frNom = new FileReader("C:\\Users\\ALUMNO.AULA4-PCPROFE\\Desktop\\nombres.txt");
		FileReader frApe = new FileReader("C:\\Users\\ALUMNO.AULA4-PCPROFE\\Desktop\\apellido.txt");
		BufferedReader brNom = new BufferedReader(frNom);
		BufferedReader brApe = new BufferedReader(frApe);
		
		fw.write("<?xml version=\"\"1.0\"?>\n<alumnos>");
		
		String aux;
		while((aux=brNom.readLine())!=null) {
			String nom="";
			for(int i =0;i<aux.length();i++) {
				if(aux.substring(i,i+1).equals(",")) {
					nombre[cont]=nom;
					nom = "";
					cont++;
				}else {
					if(!(aux.substring(i,i+1).equals(" "))||aux.substring(i,i+1).equals(".")) {
					nom = nom+aux.substring(i,i+1);
					}
				}
			}
			
			
		}
		
		cont=0;
		while((aux=brApe.readLine())!=null) {
			String nom="";
			for(int i =0;i<aux.length();i++) {
				if(aux.substring(i,i+1).equals(",")) {
					apellido[cont]=nom;
					nom = "";
					cont++;
				}else {
					if(!(aux.substring(i,i+1).equals(" "))||aux.substring(i,i+1).equals(".")) {
						nom = nom+aux.substring(i,i+1);
						}
					
				}
			}
			
			
		}
		
		for(int i = 0;i<100;i++) {

			int dia = (int) (Math.random()*28)+1;
			int mes = (int) (Math.random()*12)+1;
			String mesD="";
			String diaD="";
			mesD = Integer.toString(mes);
			diaD = Integer.toString(dia);
			
			if(mes<10) {
				mesD="0"+Integer.toString(mes);
			}
			if(dia<10) {
				diaD = "0"+Integer.toString(dia);
			}
			int anyo = (int) (Math.random()*21)+1980;
			fw.write("\n\t<alumno>\n\t\t<id>"+(i+1)+"</id>\n\t\t<nombre>"+nombre[(int)((Math.random()*100))]+"</nombre>\n\t\t<apellido>"+apellido[(int)((Math.random()*100))]+
					"</apellido>\n\t\t<grupo>"+grupo[(int) (Math.random()*3)]+"</grupo>\n\t\t<dob>"+dia+"/"+mesD+"/"+anyo+"</dob>\n\t</alumno>");
		
		
		}
	
		fw.write("\n</alumnos>");
		fw.close();
		
		
	}
}
