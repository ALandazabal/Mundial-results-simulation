package Paquete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;


public class Principal {
	
	public static Equipo []equipos = new Equipo[32];
	public static Equipo []equipoOcta = new Equipo[16];
	public static Equipo []equipoCuarta = new Equipo[8];
	public static Equipo []equipoSemi = new Equipo[4];
	public static Equipo []equipoFinish = new Equipo[2];
	public static Equipo []equipoFinish2 = new Equipo[2];
	public static Equipo []equipoGanadores = new Equipo[30];
	public static Equipo []equipoSegundos = new Equipo[30];
	public static Equipo []equipoTerceros = new Equipo[30];
	public static Historico []historicos = new Historico[276];
	public static ArrayList<Juego> juegosClasificatoria = new ArrayList<>();
	public static ArrayList<Estadistica> estadistica = new ArrayList<>();
	
	
	public static  String buscarEncuentro(Equipo eq1, Equipo eq2){
		ArrayList<Historico> partidoj = new ArrayList<Historico>();
		int k = 0;
		int oficial = 70;
		int amistosa = 30;
		int g_eq1 = 0;
		int g_eq2 = 0;
		int goles_eq1 = 0;
		int goles_eq2 = 0;
		for(int i=0; i<historicos.length; i++) {
			for(int j=0; j<historicos.length; j++) {
				
				if (historicos[i].getNom_eq1() == eq1.getNombre() && historicos[j].getNom_eq2() == eq2.getNombre() || 
					historicos[i].getNom_eq1() == eq2.getNombre() && historicos[j].getNom_eq2() == eq1.getNombre()) {
					partidoj.add(historicos[i]);
					k++;
					
				}
			}
		}	
		
		if(!partidoj.isEmpty()) {
			
			for(int i=0; i<partidoj.size(); i++) {
				if(partidoj.get(i).TipoPartido == "Oficial") {
					g_eq1 += partidoj.get(i).goles_eq1 * (oficial / 100);
					g_eq2 += partidoj.get(i).goles_eq2 * (oficial/ 100);
					
				}
				else {	
					g_eq1 += partidoj.get(i).goles_eq1 * (amistosa/ 100);
					g_eq2 += partidoj.get(i).goles_eq2 * (amistosa/ 100);
				}
				goles_eq1 += partidoj.get(i).goles_eq1;
				goles_eq2 += partidoj.get(i).goles_eq2;
			}
			
			return g_eq1+","+g_eq2+""+goles_eq1+","+goles_eq2;
			
			
			
		}else {
			return "0,0,0,0";
		}
	}
	
	
        
        public static void estadisticas(Equipo []g1, Equipo []g2, Equipo []g3){
            int cont = 0;
            int band = 1 ;
            String nombre="";
            
            //For para los 1eros Lugares
            for (int i = 0; i < g1.length; i++) {
                Estadistica esta= new Estadistica();
                for (int j = 0; j < g1.length; j++) {
                    if(g1[i].getNombre().equals(g1[j].getNombre())){
                        nombre = g1[j].getNombre();
                        cont++;
                    }
                }
                //System.out.println("---->"+(float)cont/30);
                esta.setCantidad(((float)cont/30)*100);
                //System.out.println(esta.getCantidad());
                esta.setLugar("1er Lugar");
                esta.setNombre(nombre);
                cont = 0;
                
                if(estadistica.size()!= 0){
                    for (int t = 0; t < estadistica.size(); t++) {
                        if(estadistica.get(t).getLugar().equals(esta.lugar) && estadistica.get(t).getNombre().equals(esta.nombre)){
                            band = 0;                            
                        }
                    }
                    if(band == 1) estadistica.add(esta);
                    
                    band = 1;
                }else{
                    estadistica.add(esta);
                } 
            }
            
            //For para los 2dos Lugares
            for (int i = 0; i < g2.length; i++) {
                Estadistica esta= new Estadistica();
                for (int j = 0; j < g2.length; j++) {
                    if(g2[i].getNombre().equals(g2[j].getNombre())){
                        nombre = g2[j].getNombre();
                        cont++;
                    }
                }
                esta.setCantidad(((float)cont/30)*100);
                esta.setLugar("2do Lugar");
                esta.setNombre(nombre);
                cont = 0;
                
                if(estadistica.size()!= 0){
                    for (int t = 0; t < estadistica.size(); t++) {
                        if(estadistica.get(t).getLugar().equals(esta.lugar) && estadistica.get(t).getNombre().equals(esta.nombre)){
                            band = 0;                            
                        }
                    }
                    if(band == 1) estadistica.add(esta);
                    
                    band = 1;
                }else{
                    estadistica.add(esta);
                }
            }
            
            
            //For para los 3er Lugare
            for (int i = 0; i < g3.length; i++) {
                Estadistica esta= new Estadistica();
                for (int j = 0; j < g3.length; j++) {
                    if(g3[i].getNombre().equals(g3[j].getNombre())){
                        nombre = g3[j].getNombre();
                        cont++;
                    }
                }
                esta.setCantidad(((float)cont/30)*100);
                esta.setLugar("3er Lugar");
                esta.setNombre(nombre);
                cont = 0;
                
                if(estadistica.size()!= 0){
                    for (int t = 0; t < estadistica.size(); t++) {
                        if(estadistica.get(t).getLugar().equals(esta.lugar) && estadistica.get(t).getNombre().equals(esta.nombre)){
                            band = 0;                            
                        }
                    }
                    if(band == 1) estadistica.add(esta);
                    
                    band = 1;
                }else{
                    estadistica.add(esta);
                }
            }
            
        }
        
	
	public static  int promediosH(Equipo eq){
		
		float pro = 0;
		int total = 0;
		pro = eq.ranking / 100;		
		total = (int) ((eq.partidos_g / eq.partidos_t) / pro);			
		return total;
	}
	
	public static boolean comprobar(Equipo eq1, Equipo eq2){
		
		for (int i = 0; i < juegosClasificatoria.size(); i++) {
			if(juegosClasificatoria.get(i).etapa == 0) {
			if (juegosClasificatoria.get(i).id_eq1 == eq1.getNombre() && juegosClasificatoria.get(i).id_eq2 == eq2.getNombre() || 
                            juegosClasificatoria.get(i).id_eq2 == eq1.getNombre() && juegosClasificatoria.get(i).id_eq1 == eq2.getNombre()) {
					
				return false;
					
                            }
			}
			
		}
		return true;
		
	}
	
	
	public static  Equipo jugar(Equipo eq1, Equipo eq2){
		String[] golessp;
		int g_eq1 = 0;
		int g_eq2 = 0;
		float pro_eq1 = 0;
		float pro_eq2 = 0;
		int goles_eq1 = 0;
		int goles_eq2 = 0;
		Juego juego= new Juego();
		
		String goles = buscarEncuentro(eq1, eq2);
		
		
		golessp = goles.split(",");
		g_eq1 = Integer.parseInt(golessp[0]);
		g_eq2 = Integer.parseInt(golessp[1]);
		
		goles_eq1 = Integer.parseInt(golessp[2]);
		goles_eq2 = Integer.parseInt(golessp[3]);
		
		pro_eq1 = promediosH(eq1);
		pro_eq2 = promediosH(eq2);
		
		//System.out.println(goles_eq1+" <---> "+goles_eq2);
		
		int aleatorio_eq1 = (int) (Math.random()*7);
		int aleatorio_eq2 = (int) (Math.random()*7);
		
                if(pro_eq1 != 0)
                    pro_eq1 += (pro_eq1 + g_eq1) * aleatorio_eq1;
		else
                    pro_eq1 += (pro_eq1 + g_eq1) + aleatorio_eq1;
                                
                if(pro_eq2 != 0)
                    pro_eq2 += (pro_eq2 + g_eq2) * aleatorio_eq2;
		else
                    pro_eq2 += (pro_eq2 + g_eq2) + aleatorio_eq2;
                
		juego.etapa=0;
		juego.id_eq1 = eq1.nombre;
		juego.id_eq2 = eq2.nombre;
		
		//System.out.println(pro_eq1+" <---> "+pro_eq2);
		
		Equipo equipoa = new Equipo();
		
		
		if(pro_eq1> pro_eq2) {
			equipoa= eq1;
			eq1.puntajes_eq += 3;
			eq2.puntajes_eq += 0;
			if(aleatorio_eq1!=1)
				aleatorio_eq2 = (int) (Math.random()*aleatorio_eq1 - 1 );
		}
		else if(pro_eq1 == pro_eq2){
			equipoa = eq2;
			eq1.puntajes_eq += 1;
			eq2.puntajes_eq += 1;
			aleatorio_eq1 = aleatorio_eq2;
		}
		else {
			eq1.puntajes_eq += 0;
			eq2.puntajes_eq += 3;
			if(aleatorio_eq2!=1)
				aleatorio_eq1 = (int) (Math.random()*aleatorio_eq2 - 1 );
			equipoa = eq2;
		}
		
		juego.goles_eq1 = aleatorio_eq1;
		juego.goles_eq2 = aleatorio_eq2;
		
		eq1.dif_goles += aleatorio_eq1 - aleatorio_eq2;
		eq2.dif_goles += aleatorio_eq2 - aleatorio_eq1;
		
		
		juegosClasificatoria.add(juego);
		//System.out.println(eq1.nombre+" "+juego.goles_eq1+"----"+eq2.nombre+" "+juego.goles_eq2);
		
		return equipoa;
		
	}
	
	
	public static void seleccionar() {
		for(int i=0; i<equipos.length; i++) {
			for(int j=0; j<equipos.length; j++) {
				
				if (equipos[i].getGrupo().equals(equipos[j].getGrupo()) && !equipos[i].getNombre().equals(equipos[j].getNombre()) && comprobar(equipos[i], equipos[j])) {
					
					jugar(equipos[i], equipos[j]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String csvFile = "Grupos.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int index = 0;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));         
          
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] grupo = line.split(cvsSplitBy);
                //System.out.println(grupo[0]);
                Equipo temporal = new Equipo(grupo[0], grupo[1], true, Integer.parseInt(grupo[2]), Integer.parseInt(grupo[7]), Integer.parseInt(grupo[3]), Integer.parseInt(grupo[5]),0);
                equipos[index] = temporal;
                index++;
            }
            
        for(int i=0; i<equipos.length; i++) {
        	//System.out.println("Equipo: " + equipos[i].getNombre());
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Historicos
        
        csvFile = "Historico.csv";
        
        index = 0;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] history = line.split(cvsSplitBy);
                Historico temporal = new Historico(history[1], history[0], history[2], history[3], Integer.parseInt(history[4]), Integer.parseInt(history[5]));
                historicos[index] = temporal;
                index++;
            }
            
        for(int i=0; i<equipos.length; i++) {
        	//System.out.println("Historico: " + historicos[i].getFecha());
        }
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        for (int xxx = 0; xxx < 30; xxx++) {
        	seleccionar();
		
        
        
	        int k=0,octa=0;
	        Equipo auxe = new Equipo();
	        for(int i=0; i< 8; i++) {
	        	 //System.out.println(equipos[i].nombre+" --> "+equipos[i].puntajes_eq+" "+equipos[i].dif_goles);
	        	for(int j=0; j<4 ; j++ ) {
	        		for(int m=2; m<4; m++) {
	        			for(int n=0; n<3; n++) {
	        				if(equipos[n+k].puntajes_eq < equipos[n+1+k].puntajes_eq) {
	        					auxe = equipos[n+k];
	        					equipos[n+k] = equipos[n+1+k];
	        					equipos[n+1+k] = auxe;
	        				}else {
	        					if(equipos[n+k].puntajes_eq == equipos[n+1+k].puntajes_eq && equipos[n+k].dif_goles < equipos[n+1+k].dif_goles) {
	        						auxe = equipos[n+k];
	            					equipos[n+k] = equipos[n+1+k];
	            					equipos[n+1+k] = auxe;
	        					}
	        				}
	        			}
	        		}
	  
	        	}
	    		k+=4;
	        	
	        }
	        
	        k=0;
	        for(int i=0; i< 8; i++) {
	        	//System.out.println(equipos[i].nombre+" --> "+equipos[i].puntajes_eq+" "+equipos[i].dif_goles);
	        	equipoOcta[octa] = equipos[k];
	    		octa+=1;
	    		equipoOcta[octa] = equipos[1+k];
	    		octa+=1;
	    		k+=4;
	        }
	        for(int i=0; i< 32; i++) {
	        	//System.out.println(equipos[i].nombre+" --> "+equipos[i].puntajes_eq+" "+equipos[i].dif_goles);
	        }
	        //System.out.println();
	        for(int i=0; i< 16; i++) {
	        	//System.out.println(equipoOcta[i].nombre+" --> "+equipoOcta[i].puntajes_eq+" "+equipoOcta[i].dif_goles);
	        }
	        
	        //System.out.println("Juego octavos");
	        
	        
	        
	        equipoCuarta[0] = jugar(equipoOcta[0], equipoOcta[3]);
	        equipoCuarta[1] = jugar(equipoOcta[4], equipoOcta[7]);
	        equipoCuarta[2] = jugar(equipoOcta[8], equipoOcta[11]);
	        equipoCuarta[3] = jugar(equipoOcta[12], equipoOcta[15]);
	        equipoCuarta[4] = jugar(equipoOcta[1], equipoOcta[2]);
	        equipoCuarta[5] = jugar(equipoOcta[5], equipoOcta[6]);
	        equipoCuarta[6] = jugar(equipoOcta[9], equipoOcta[10]);
	        equipoCuarta[7] = jugar(equipoOcta[13], equipoOcta[14]);
	       
	        /*for(int x=0;x<8;x++) {
	        	//System.out.println(equipoCuarta[x].nombre+" --> "+equipoCuarta[x].puntajes_eq+" "+equipoCuarta[x].dif_goles);
	        }*/
	        //System.out.println("Juego cuarto");
	        
	        int v=0;
	        for(int y=0;y<4;y++) {
	        	equipoSemi[y] = jugar(equipoCuarta[v], equipoCuarta[v+1]);
	        	//System.out.println(equipoSemi[y].nombre+" --> "+equipoSemi[y].puntajes_eq+" "+equipoSemi[y].dif_goles);
	        	v+=2;
	        }
	        
	        
	        //System.out.println("Juego Semi");
	        int w=0;
	        for(int z=0;z<2;z++) {
	        	equipoFinish[z] = jugar(equipoCuarta[w], equipoCuarta[w+1]);
	        			if(equipoCuarta[w].nombre == equipoFinish[z].nombre) {        
	        				equipoFinish2[z] = equipoCuarta[w+1];
	        	        }else {
	        	        	equipoFinish2[z] = equipoCuarta[w];
	        	        }
	        	//System.out.println(equipoFinish[z].nombre+" --> "+equipoFinish[z].puntajes_eq+" "+equipoFinish[z].dif_goles);
	        	w+=2;
	        }
	        
	        //System.out.println("Juego Final");
	        
	        Equipo equipog = new Equipo();
	        Equipo equipot = new Equipo();
	        	
	        equipog = jugar(equipoFinish[0], equipoFinish[1]);
	        
	        
	        
	        if(equipoFinish[0].nombre == equipog.nombre) {        
	        	equipoGanadores[xxx] = equipog;
	        	equipoSegundos[xxx] = equipoFinish[1];
	        }else {
	        	equipoGanadores[xxx] = equipog;
	        	equipoSegundos[xxx] = equipoFinish[0];
	        }
	        
	        equipoTerceros[xxx] = jugar(equipoFinish2[0], equipoFinish2[1]);       
	       
	        /*System.out.println("Etapa "+ (xxx+1));
	        System.out.println(equipog.nombre);
                System.out.println(equipoSegundos[xxx].nombre);
	        System.out.println(equipoTerceros[xxx].nombre);
                */
                
	        
        }
        
        estadisticas(equipoGanadores, equipoSegundos, equipoTerceros);
        
        String matriz[][] = new String[33][4];
        DecimalFormat df = new DecimalFormat("#.0");
        for (int i = 0; i < estadistica.size(); i++) {
            //System.out.println(estadistica.get(i).getLugar()+" "+estadistica.get(i).getNombre()+" --> "+estadistica.get(i).getCantidad()+"%");
        }
            System.out.println("---------- Estadisticas ----------");
        int cont = 0;
        
        matriz[0][0]="Equipos";
         matriz[0][1]="1er Lugar";
          matriz[0][2]="2do Lugar";
           matriz[0][3]="3er Lugar";
        for (int vv = 1; vv <= equipos.length; vv++) {
            matriz[vv][0]=equipos[cont].nombre; 
            cont++;
        }
        
        /*int con = 0;
        for (int i = 0; i < estadistica.size(); i++) {
            
                for (int vv = 1; vv < matriz.length; vv++) {
                     if(estadistica.get(i).getLugar().equals(matriz[0][1]) && estadistica.get(i).getNombre().equals(matriz[vv][0])) {
                         matriz[vv][1] = df.format(estadistica.get(i).getCantidad())+"%";
                         
                     }else if(estadistica.get(i).getLugar().equals(matriz[0][2]) && estadistica.get(i).getNombre().equals(matriz[vv][0])){
                         matriz[vv][2] = df.format(estadistica.get(i).getCantidad())+"%";
                     }else{
                         if(estadistica.get(i).getLugar().equals(matriz[0][3]) && estadistica.get(i).getNombre().equals(matriz[vv][0])){
                             matriz[vv][3] = df.format(estadistica.get(i).getCantidad())+"%";
                         }
                     }
                }             
            
        }*/
        
        int con = 0;
        for (int i = 0; i < estadistica.size(); i++) {
            
                for (int vv = 1; vv < matriz.length; vv++) {
                     if(estadistica.get(i).getLugar().equals(matriz[0][1]) && estadistica.get(i).getNombre().equals(matriz[vv][0])) {
                         //System.out.println("-->"+estadistica.get(i).getCantidad());
                         matriz[vv][1] = Float.toString(estadistica.get(i).getCantidad());
                         //System.out.println("A"+matriz[vv][1]);
                         
                     }else if(estadistica.get(i).getLugar().equals(matriz[0][2]) && estadistica.get(i).getNombre().equals(matriz[vv][0])){
                         matriz[vv][2] = Float.toString(estadistica.get(i).getCantidad());
                     }else{
                         if(estadistica.get(i).getLugar().equals(matriz[0][3]) && estadistica.get(i).getNombre().equals(matriz[vv][0])){
                             matriz[vv][3] = Float.toString(estadistica.get(i).getCantidad());
                         }
                     }
                }             
            
        }
        
        String auxbb[];
        float mb1, mb2,mb12,mb22;
        for(int bb = 2; bb < matriz.length; bb++){
            for (int bb2 = 1; bb2 < matriz.length-2; bb2++) {
                mb1 = Float.parseFloat("0.0");
                mb2 = Float.parseFloat("0.0");
                if(matriz[bb2][1] != null)
                    mb1 = Float.parseFloat(matriz[bb2][1]);
                if(matriz[bb2+1][1] != null)
                    mb2 = Float.parseFloat(matriz[bb2+1][1]);
                if(mb1<mb2){
                    auxbb = matriz[bb2];
                    matriz[bb2] = matriz[bb2+1];
                    matriz[bb2+1] = auxbb;
                }else if(mb1==mb2){
                    mb1 = Float.parseFloat("0.0");
                    mb2 = Float.parseFloat("0.0");
                    if(matriz[bb2][2] != null)
                        mb1 = Float.parseFloat(matriz[bb2][2]);
                    if(matriz[bb2+1][2] != null)
                        mb2 = Float.parseFloat(matriz[bb2+1][2]);
                    if(mb1<mb2){
                        auxbb = matriz[bb2];
                        matriz[bb2] = matriz[bb2+1];
                        matriz[bb2+1] = auxbb;
                    }else if(mb1==mb2){
                        mb1 = Float.parseFloat("0.0");
                        mb2 = Float.parseFloat("0.0");
                        if(matriz[bb2][3] != null)
                            mb1 = Float.parseFloat(matriz[bb2][3]);
                        if(matriz[bb2+1][3] != null)
                            mb2 = Float.parseFloat(matriz[bb2+1][3]);
                        if(mb1<mb2){
                            auxbb = matriz[bb2];
                            matriz[bb2] = matriz[bb2+1];
                            matriz[bb2+1] = auxbb;
                        }
                    }
                }
            }
        }
            
        
        
            System.out.println("\t\tPor orden");
        for (int x=0; x < matriz.length; x++) {
            String sSubCadena="";
            for (int y=0; y < matriz[x].length; y++) {
              if(matriz[x][y] == null)
                System.out.print ("0,0%");
              else{
                  if(matriz[x][y].length()>4)
                     sSubCadena = matriz[x][y].substring(0,5);
                  else
                      sSubCadena = matriz[x][y];
                  System.out.print ( sSubCadena + "%" );
              }
              if (y!=matriz[x].length-1) System.out.print("\t\t");
            }
            System.out.println("");
            System.out.println("-----------------------------------------------------------------");
        }
        
       
	}
	
	
}
