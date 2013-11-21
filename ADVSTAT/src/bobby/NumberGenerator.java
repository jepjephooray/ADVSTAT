package bobby;
import java.util.Random;



public class NumberGenerator {

	static final int central = 100;
	public static void main (String args[]){
		
		float[] f = generateNormal(1000,1,10);
		for(int i = 0; i < f.length; i++)
			System.out.print(f[i] + ", ");
		System.out.println();
		System.out.println(getMean(f));
		
	}
	
	
	
	public static float[] generateNormal(int size, int lower, int upper){
		
		float[] f = new float[size];
		float[] temp = null; 
		
		for(int i = 0; i < size; i++){
			
			temp = generateRandom(central,lower,upper);
			
			
			f[i] = getMean(temp);
			
		}
		
		return f;
	}
	
	
	public static float[] generateRandom(int size, int lower, int upper){
		Random r = new Random();
		float[] f = new float[size];
		for(int i = 0; i < size; i++)
			f[i] = r.nextFloat() * (upper - lower) + lower;
		
		return f;
		
	}
	
	public static float getMean(float[] population){
		float sum = 0;
		for(int i = 0; i < population.length; i++)
			sum += population[i];
		return sum / population.length;
		
	}
}
