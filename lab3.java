// Rachel Nock   //
// CSE 3521      //
// Lab 3         //
// July 28, 2017 //

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class lab3 {
	
	public static void main(String[] args) {
		
		/** generate test data for shape 1 */
		int [] [] image = {{0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0},
									 {0, 1, 1, 1, 1, 1, 0},
									 {0, 0, 0, 0, 0, 0, 0}
									};
									
		int label = 1;
		char name = 'o';
		
		int [] [] imagetu = {{0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0},
									 {0, 1, 1, 1, 1, 1, 0},
									 {0, 0, 0, 0, 0, 0, 0}
									};
									
		int labeltu = 1;
		char nametu = 'o';
		int [] [] imagetd = {{0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0},
									 {0, 1, 1, 1, 1, 1, 0},
									 {0, 0, 0, 0, 0, 0, 0}
									};
									
		int labeltd = 1;
		char nametd = 'o';
		
		int [] [] image2 = {{0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0},
									 {0, 1, 1, 1, 1, 1, 0},
									 {0, 0, 0, 0, 0, 0, 0}
									};
									
		int label2 = 1;
		char name2 = 'o';
		
		int [] [] image3 = {{0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0},
									 {0, 1, 1, 1, 1, 1, 0},
									 {0, 0, 0, 0, 0, 0, 0}
									};
									
		int label3 = 1;
		char name3 = 'o';
		
		int [] [] image4 = {{0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0},
									 {0, 1, 1, 1, 1, 1, 0},
									 {0, 0, 0, 0, 0, 0, 0}
									};
									
		int label4 = 1;
		char name4 = 'o';
		int [] [] image4tu = {{0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0},
									 {0, 1, 1, 1, 1, 1, 0},
									 {0, 0, 0, 0, 0, 0, 0}
									};
									
		int label4tu = 1;
		char name4tu = 'o';
		int [] [] image4td = {{0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0},
									 {0, 1, 1, 1, 1, 1, 0},
									 {0, 0, 0, 0, 0, 0, 0}
									};
									
		int label4td = 1;
		char name4td = 'o';
		
		Shape shape = new Shape (image, label, name);
		
		/* creates images of the different configurations of the shape */
		Shape shape_right = new Shape(image2, label2, name2);
		shape_right = shape_right.right(shape_right);
		Shape shape_left = new Shape(image3, label3, name3);
		shape_left = shape_left.right(shape_left);
		shape_left = shape_left.left(shape_left);
		Shape shape_down = new Shape(image4, label4, name4);
		shape_down = shape_down.down(shape_down);
		
		Shape shape_trans_up = new Shape(imagetu, labeltu, nametu);
		shape_trans_up = shape_trans_up.transpose_up(shape_trans_up);
		Shape shape_down_trans_up = new Shape(image4tu, label4tu, name4tu);
		shape_down_trans_up = shape_down_trans_up.down(shape_down_trans_up);
		shape_down_trans_up = shape_down_trans_up.transpose_up(shape_down_trans_up);
		
		Shape shape_trans_down = new Shape(imagetd, labeltd, nametd);
		shape_trans_down = shape_trans_down.transpose_down(shape_trans_down);
		Shape shape_down_trans_down = new Shape(image4td, label4td, name4td);
		shape_down_trans_down = shape_down_trans_down.down(shape_down_trans_down);
		shape_down_trans_down = shape_down_trans_down.transpose_down(shape_down_trans_down);
		
		double[] initial_weight_vector = new double[35];
		int i = 0;
		while (i < 35) {
			initial_weight_vector[i] = 0.5;
			i++;
		}
		
		double[] new_weight_vector = new double[35];
		
		int epoch = 0;
		
		/* runs training data through perceptron */
		while (epoch <= 10) {
			new_weight_vector = perceptron(shape, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_right, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_left, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_down, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_trans_up, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_down_trans_up, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_trans_down, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_down_trans_down, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			epoch++;
		}
		
		int pos;
		
		System.out.println("Shape 1 Final Weights:");
		
		for (pos = 0; pos < 35; pos++) {
			System.out.print(new_weight_vector[pos]);
			System.out.print(" ");			
		}
		System.out.println();
		
		/** generate test data for shape 2 */
		int [] [] image5 = {{0, 0, 0, 0, 0, 0, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 1, 1, 1, 1, 0},
									 			{0, 0, 0, 0, 0, 0, 0}
											 };
									
		int label5 = 0;
		char name5 = 'o';
		int [] [] image5tu = {{0, 0, 0, 0, 0, 0, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 1, 1, 1, 1, 0},
									 			{0, 0, 0, 0, 0, 0, 0}
											 };
									
		int label5tu = 0;
		char name5tu = 'o';
		int [] [] image5td = {{0, 0, 0, 0, 0, 0, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 1, 1, 1, 1, 0},
									 			{0, 0, 0, 0, 0, 0, 0}
											 };
									
		int label5td = 0;
		char name5td = 'o';
		
		int [] [] image6 = {{0, 0, 0, 0, 0, 0, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 1, 1, 1, 1, 0},
									 			{0, 0, 0, 0, 0, 0, 0}
											 };
									
		int label6 = 0;
		char name6 = 'o';
		
		int [] [] image7 = {{0, 0, 0, 0, 0, 0, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 1, 1, 1, 1, 0},
									 			{0, 0, 0, 0, 0, 0, 0}
											 };
									
		int label7 = 0;
		char name7 = 'o';
		
		int [] [] image8 = {{0, 0, 0, 0, 0, 0, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 1, 1, 1, 1, 0},
									 			{0, 0, 0, 0, 0, 0, 0}
											 };
									
		int label8 = 0;
		char name8 = 'o';
		int [] [] image8tu = {{0, 0, 0, 0, 0, 0, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 1, 1, 1, 1, 0},
									 			{0, 0, 0, 0, 0, 0, 0}
											 };
									
		int label8tu = 0;
		char name8tu = 'o';
		int [] [] image8td = {{0, 0, 0, 0, 0, 0, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 0, 0, 0, 1, 0},
									 			{0, 1, 1, 1, 1, 1, 0},
									 			{0, 0, 0, 0, 0, 0, 0}
											 };
									
		int label8td = 0;
		char name8td = 'o';
		
		Shape shape2 = new Shape (image5, label5, name5);
		
		/* creates images of the different configurations of the shape */
		Shape shape_right2 = new Shape(image6, label6, name6);
		shape_right2 = shape_right2.right(shape_right2);
		Shape shape_left2 = new Shape(image7, label7, name7);
		shape_left2 = shape_left2.right(shape_left2);
		shape_left2 = shape_left2.left(shape_left2);
		Shape shape_down2 = new Shape(image8, label8, name8);
		shape_down2 = shape_down2.down(shape_down2);
		
		Shape shape_trans_up2 = new Shape(image5tu, label5tu, name5tu);
		shape_trans_up2 = shape_trans_up2.transpose_up(shape_trans_up2);
		Shape shape_down_trans_up2 = new Shape(image8tu, label8tu, name8tu);
		shape_down_trans_up2 = shape_down_trans_up2.down(shape_down_trans_up2);
		shape_down_trans_up2 = shape_down_trans_up2.transpose_up(shape_down_trans_up2);
		
		Shape shape_trans_down2 = new Shape(image5td, label5td, name5td);
		shape_trans_down2 = shape_trans_down2.transpose_down(shape_trans_down2);
		Shape shape_down_trans_down2 = new Shape(image8td, label8td, name8td);
		shape_down_trans_down2 = shape_down_trans_down2.down(shape_down_trans_down2);
		shape_down_trans_down2 = shape_down_trans_down2.transpose_down(shape_down_trans_down2);
		
		double[] initial_weight_vector2 = new double[35];
		i = 0;
		while (i < 35) {
			initial_weight_vector2[i] = 0.5;
			i++;
		}
		
		double[] new_weight_vector2 = new double[35];
		
		epoch = 0;
		
		/* runs training data through perceptron */
		while (epoch <=10) {
			new_weight_vector2 = perceptron(shape2, initial_weight_vector2);
			initial_weight_vector2 = new_weight_vector2;
			new_weight_vector2 = perceptron(shape_right2, initial_weight_vector2);
			initial_weight_vector2 = new_weight_vector2;
			new_weight_vector2 = perceptron(shape_left2, initial_weight_vector2);
			initial_weight_vector2 = new_weight_vector2;
			new_weight_vector2 = perceptron(shape_down2, initial_weight_vector2);
			initial_weight_vector2 = new_weight_vector2;
			new_weight_vector = perceptron(shape_trans_up2, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_down_trans_up2, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_trans_down2, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			new_weight_vector = perceptron(shape_down_trans_down2, initial_weight_vector);
			initial_weight_vector = new_weight_vector;
			epoch++;
		}
		
		int pos2;
		
		System.out.println("Shape 2 Final Weights:");
		
		for (pos2 = 0; pos2 < 35; pos2++) {
			System.out.print(new_weight_vector2[pos2]);
			System.out.print(" ");			
		}
		System.out.println();
	}
	
	private static double [] perceptron(Shape shape, double[] initial_weights) {
		int [] [] image = new int[5][7];
									
		int label = 1;
		char name = 'o';
		Shape shape_data = new Shape (image, label, name);
		shape_data = shape;
		
		int[] image_vector = new int[36]; 
		
		int row, column;
		int pos = 0;
		int e = 0;
		
		/** puts data in 1d vector */
		for (row = 0; row < 5; row++) {
			for (column = 0; column < 7; column++) {
				image_vector[pos] = shape_data.image [row] [column];
				pos++;
			}			
		}
		image_vector[pos] = shape_data.label;
		
		int i = 0;
		int h, y, wdotx;
		
		int[] x = new int[35];
		while (i < 35) {
			x[i] = image_vector[i];
			i++;
		}
		
		double[] w = new double[35];
		double[] wplus = new double[35];
		i = 0;
		
		while (i < 35) {
			wplus[i] = initial_weights[i];
			i++;
		}		
		w = wplus;
		
		i = 0;
		wdotx = 0;
		
		while (i < 35) {
			wdotx += (x[i]*w[i]);
			i++;
		}

		if (wdotx >= 0) {
			h = 1;
		}
		else {
			h = 0;
		}
		y = shape_data.label;
		
		e = y - h;
		
		i = 0;
		
		if (e != 0) {
			while (i < 35) {
				wplus[i] = w[i] + ((1*(y -h)) * x[i]);
				i++;
			}
		}

		return wplus;
	}
}