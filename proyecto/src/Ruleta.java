import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta {
	public static void main(String[] args) {

		        int[][] laberinto = {
		            // 0 = camino, 1 = muro, 2 = inicio, 3 = final, 4 = posición actual
		            {2, 0, 0, 0, 0, 1, 0, 0, 0, 0},
		            {1, 1, 1, 1, 0, 1, 0, 1, 1, 0},
		            {1, 0, 0, 0, 0, 1, 0, 1, 0, 0},
		            {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
		            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
		            {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
		            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
		            {1, 1, 1, 0, 1, 0, 1, 1, 1, 1},
		            {1, 4, 0, 0, 0, 0, 0, 0, 3, 1},
		            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		        };

		        imprimirLaberinto(laberinto);
		    }

		    public static void imprimirLaberinto(int[][] laberinto) {
		        for (int i = 0; i < laberinto.length; i++) {
		            for (int j = 0; j < laberinto[i].length; j++) {
		                System.out.print(laberinto[i][j] + " ");
		            }
		            System.out.println();
		    
		}
	}
}
