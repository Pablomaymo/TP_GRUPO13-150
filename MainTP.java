package ar.utn.ap.pronosticos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     
		Collection<Partido> partidos = new ArrayList<Partido>();
		Path pathResultados = Paths.get("C:\\Users\\USUARIO\\Desktop\\UTN\\TP INTEGRADOR\\TP INTEGRADOR PROPIO\\RESULTADO\\Resultado.csv");
		List<String> lineasResultados = null;
		try {
			lineasResultados = Files.readAllLines(pathResultados);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no se pudo obtener la linea de resultados");
			System.out.println(e.getMessage());
			System.exit (1);
		}
		    boolean primera = true;
			for (String lineaResultado : lineasResultados){
				if(primera) {
					primera=false;
				}else {
					String[] campos = lineaResultado.split(";");
					Equipo equipo1 = new Equipo(campos[0], lineaResultado);
					Equipo equipo2 = new Equipo(campos[3], lineaResultado);
					
					Partido partido = new Partido(equipo1,equipo2, 0, 0);
					partido.setGolesE1(Integer.parseInt(campos[1]));
					partidos.add(partido);
					
					//System.out.println(lineaResultado);
				}
					
					
				}
			
		    int puntos=0;
			Path pathPronostico = Paths.get("C:\\Users\\USUARIO\\Desktop\\UTN\\TP INTEGRADOR\\TP INTEGRADOR PROPIO\\PRONOSTICO\\Pronostico.csv");
			List<String> lineasPronostico = null;
			try {
				lineasPronostico = Files.readAllLines(pathPronostico);
			} catch (IOException e) {
				
				System.out.println("no se pudo obtener la linea de pronostico");
				System.out.println(e.getMessage());
				System.exit (1);
			}
				primera = true;
				for (String lineaPronostico : lineasPronostico){
					if(primera) {
						primera=false;
				
				}else {
					//sumar los puntos correspondientes
					String[] campos = lineaPronostico.split(";");
					Equipo equipo1 = new Equipo(campos[0], lineaPronostico);
					Equipo equipo2 = new Equipo(campos[4], lineaPronostico);
					Partido partido = null;
					
					for (Partido partidoCol: partidos) {
						if (partidoCol.getEquipo1().getNombre(
								).equals(equipo1.getNombre()) 
								&& partidoCol.getEquipo2().getNombre(
										).equals(equipo2.getNombre())) {
							partido = partidoCol;
							
						}
					}
					Equipo equipo = null;
					String resultado = null;
					if ("X".equals (campos [1])) {
						equipo = equipo1;
						resultado = "GANADOR";
						
					}
					if ("X".equals (campos [2])) {
						equipo = equipo1;
						resultado = "EMPATE";
						
					}
					if ("X".equals (campos [3])) {
						equipo = equipo1;
						resultado = "PERDEDOR";
						
					}
					
					
					Pronostico pronostico = new Pronostico (partido,equipo,resultado);
					//mostrar los puntos
					puntos += pronostico.puntos();
					
			    //System.out.println(lineaPronostico);
				}
				}
					
				System.out.print("El participante obtuvo la cantidad de puntos:");
				System.out.println(puntos);
				}
				}
			
		
	
	
