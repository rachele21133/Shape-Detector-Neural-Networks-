import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Shape {
	
	public int [] [] image;
	public int label;
	public char name;
	
	
	public Shape(int [] [] image, int label, char name) {
		this.image = image;
		this.label = label;
		this.name = name;
	}
	
	/** rotates shape image to the right, sets label, and returns rotated image */
	public Shape right(Shape shape) {
		Shape shape_right = new Shape (image, label, name);
		shape_right = shape;
		
		
		/** case for original triangle */
		if (shape_right.image [1] [3] == 1) {
			shape_right.image [3] [1] = 0;
			shape_right.image [4] [2] = 1;
		
			shape_right.image [3] [4] = 0;
			shape_right.image [1] [2] = 1;
		
			shape_right.image [3] [5] = 0;
			shape_right.image [0] [2] = 1;
			
			shape_right.label = 1;
		}
		
		/** case for original u-shape */
		else {
			shape_right.image [1] [1] = 0;
			shape_right.image [0] [3] = 1;
		
			shape_right.image [2] [1] = 0;
			shape_right.image [1] [3] = 1;
		
			shape_right.image [3] [1] = 0;
			shape_right.image [2] [3] = 1;
			
			shape_right.image [3] [2] = 0;
			shape_right.image [4] [3] = 1;
			
			shape_right.image [3] [4] = 0;
			shape_right.image [0] [4] = 1;
			
			shape_right.image [3] [5] = 0;
			shape_right.image [0] [5] = 1;
			
			shape_right.image [2] [5] = 0;
			shape_right.image [4] [4] = 1;
			
			shape_right.image [1] [5] = 0;
			shape_right.image [4] [5] = 1;
			
			shape_right.label = 0;
		}
		shape_right.name = 'r';
		return shape_right;
	}
	
	/** rotates shape image to the left, sets label, and returns rotated image */
	public Shape left(Shape shape_right) {
		Shape shape_left = new Shape (image, label, name);
		shape_left = shape_right;
		
		
		/** case for original triangle */
		if (shape_left.image [0] [2] == 1) {
			shape_left.image [0] [2] = 0;
			shape_left.image [0] [4] = 1;
		
			shape_left.image [1] [2] = 0;
			shape_left.image [1] [4] = 1;
		
			shape_left.image [3] [2] = 0;
			shape_left.image [3] [4] = 1;
		
			shape_left.image [4] [2] = 0;
			shape_left.image [4] [4] = 1;
			
			shape_left.label = 1;
		}
		
		/** case for original u-shape */
		else {
			shape_left.image [0] [4] = 0;
			shape_left.image [0] [2] = 1;
		
			shape_left.image [0] [5] = 0;
			shape_left.image [0] [1] = 1;
		
			shape_left.image [4] [4] = 0;
			shape_left.image [4] [2] = 1;
		
			shape_left.image [4] [5] = 0;
			shape_left.image [4] [1] = 1;
			
			shape_left.label = 0;
		}
		shape_left.name = 'l';
		return shape_left;
	}
	
	/** flips shape image upside down, sets label, and returns flipped image */
	public Shape down(Shape shape) {
		Shape shape_down = new Shape (image, label, name);
		shape_down = shape;
		
		/** case for original triangle */
		if (shape_down.image [1] [3] == 1) {
			shape_down.image [3] [1] = 0;
			shape_down.image [1] [1] = 1;
		
			shape_down.image [3] [2] = 0;
			shape_down.image [1] [2] = 1;
		
			shape_down.image [3] [4] = 0;
			shape_down.image [1] [4] = 1;
		
			shape_down.image [3] [5] = 0;
			shape_down.image [1] [5] = 1;
			
			shape_down.label = 1;
		}
		
		/** case for original u-shape */
		else {
			shape_down.image [3] [2] = 0;
			shape_down.image [1] [2] = 1;
		
			shape_down.image [3] [3] = 0;
			shape_down.image [1] [3] = 1;
		
			shape_down.image [3] [4] = 0;
			shape_down.image [1] [4] = 1;
			
			shape_down.label = 0;
		}
		shape_down.name = 'd';
		return shape_down;
	}
	
	/** shifts image up and returns transposed image */
	public Shape transpose_up(Shape shape) {
		Shape shape_trans_up = new Shape (image, label, name);
		shape_trans_up = shape;
		
		/** case for original triangle */
		if ((shape_trans_up.name == 'o') && (shape_trans_up.label == 1)) {
			shape_trans_up.image [0] [3] = 1;
			shape_trans_up.image [1] [2] = 1;
			shape_trans_up.image [1] [4] = 1;
			shape_trans_up.image [2] [1] = 1;
			shape_trans_up.image [2] [2] = 1;
			shape_trans_up.image [2] [3] = 1;
			shape_trans_up.image [2] [4] = 1;
			shape_trans_up.image [2] [5] = 1;
			
			shape_trans_up.image [1] [3] = 0;
			shape_trans_up.image [3] [1] = 0;
			shape_trans_up.image [3] [2] = 0;
			shape_trans_up.image [3] [3] = 0;
			shape_trans_up.image [3] [4] = 0;
			shape_trans_up.image [3] [5] = 0;
		}
		
		/** case for down triangle */
		if ((shape_trans_up.name == 'd') && (shape_trans_up.label == 1)) {
			shape_trans_up.image [0] [1] = 1;
			shape_trans_up.image [0] [2] = 1;
			shape_trans_up.image [0] [3] = 1;
			shape_trans_up.image [0] [4] = 1;
			shape_trans_up.image [0] [5] = 1;
			shape_trans_up.image [1] [2] = 1;
			shape_trans_up.image [1] [4] = 1;
			shape_trans_up.image [2] [3] = 1;
			
			shape_trans_up.image [1] [1] = 0;
			shape_trans_up.image [1] [3] = 0;
			shape_trans_up.image [1] [5] = 0;
			shape_trans_up.image [2] [2] = 0;
			shape_trans_up.image [2] [4] = 0;
			shape_trans_up.image [3] [3] = 0;
		}
		
		/** case for original u-shape */
		if ((shape_trans_up.name == 'o') && (shape_trans_up.label == 0)) {
			shape_trans_up.image [0] [1] = 1;
			shape_trans_up.image [0] [5] = 1;
			shape_trans_up.image [1] [1] = 1;
			shape_trans_up.image [1] [5] = 1;
			shape_trans_up.image [2] [1] = 1;
			shape_trans_up.image [2] [2] = 1;
			shape_trans_up.image [2] [3] = 1;
			shape_trans_up.image [2] [4] = 1;
			shape_trans_up.image [2] [5] = 1;
			
			shape_trans_up.image [3] [1] = 0;
			shape_trans_up.image [3] [2] = 0;
			shape_trans_up.image [3] [3] = 0;
			shape_trans_up.image [3] [4] = 0;
			shape_trans_up.image [3] [5] = 0;
		}
		
		/** case for down u-shape */
		if ((shape_trans_up.name == 'd') && (shape_trans_up.label == 0)) {
			shape_trans_up.image [0] [1] = 1;
			shape_trans_up.image [0] [2] = 1;
			shape_trans_up.image [0] [3] = 1;
			shape_trans_up.image [0] [4] = 1;
			shape_trans_up.image [0] [5] = 1;
			shape_trans_up.image [1] [1] = 1;
			shape_trans_up.image [1] [5] = 1;
			shape_trans_up.image [2] [1] = 1;
			shape_trans_up.image [2] [5] = 1;
			
			shape_trans_up.image [1] [2] = 0;
			shape_trans_up.image [1] [3] = 0;
			shape_trans_up.image [1] [4] = 0;
			shape_trans_up.image [3] [1] = 0;
			shape_trans_up.image [3] [5] = 0;
		}
		
		return shape_trans_up;
	}
	
	/** shifts image down and returns transposed image */
	public Shape transpose_down(Shape shape) {
		Shape shape_trans_down = new Shape (image, label, name);
		shape_trans_down = shape;
		
		/** case for original triangle */
		if ((shape_trans_down.name == 'o') && (shape_trans_down.label == 1)) {
			shape_trans_down.image [2] [3] = 1;
			shape_trans_down.image [3] [2] = 1;
			shape_trans_down.image [3] [4] = 1;
			shape_trans_down.image [4] [1] = 1;
			shape_trans_down.image [4] [2] = 1;
			shape_trans_down.image [4] [3] = 1;
			shape_trans_down.image [4] [4] = 1;
			shape_trans_down.image [4] [5] = 1;
			
			shape_trans_down.image [1] [3] = 0;
			shape_trans_down.image [2] [2] = 0;
			shape_trans_down.image [2] [4] = 0;
			shape_trans_down.image [3] [1] = 0;
			shape_trans_down.image [3] [3] = 0;
			shape_trans_down.image [3] [5] = 0;
		}
		
		/** case for down triangle */
		if ((shape_trans_down.name == 'd') && (shape_trans_down.label == 1)) {
			shape_trans_down.image [2] [1] = 1;
			shape_trans_down.image [2] [2] = 1;
			shape_trans_down.image [2] [3] = 1;
			shape_trans_down.image [2] [4] = 1;
			shape_trans_down.image [2] [5] = 1;
			shape_trans_down.image [3] [2] = 1;
			shape_trans_down.image [3] [4] = 1;
			shape_trans_down.image [4] [3] = 1;
			
			shape_trans_down.image [1] [1] = 0;
			shape_trans_down.image [1] [2] = 0;
			shape_trans_down.image [1] [3] = 0;
			shape_trans_down.image [1] [4] = 0;
			shape_trans_down.image [1] [5] = 0;
			shape_trans_down.image [3] [3] = 0;
		}
		
		/** case for original u-shape */
		if ((shape_trans_down.name == 'o') && (shape_trans_down.label == 0)) {
			shape_trans_down.image [2] [1] = 1;
			shape_trans_down.image [2] [5] = 1;
			shape_trans_down.image [3] [1] = 1;
			shape_trans_down.image [3] [5] = 1;
			shape_trans_down.image [4] [1] = 1;
			shape_trans_down.image [4] [2] = 1;
			shape_trans_down.image [4] [3] = 1;
			shape_trans_down.image [4] [4] = 1;
			shape_trans_down.image [4] [5] = 1;
			
			shape_trans_down.image [1] [1] = 0;
			shape_trans_down.image [1] [5] = 0;
			shape_trans_down.image [3] [2] = 0;
			shape_trans_down.image [3] [3] = 0;
			shape_trans_down.image [3] [4] = 0;
		}
		
		/** case for down u-shape */
		if ((shape_trans_down.name == 'd') && (shape_trans_down.label == 0)) {
			shape_trans_down.image [2] [1] = 1;
			shape_trans_down.image [2] [2] = 1;
			shape_trans_down.image [2] [3] = 1;
			shape_trans_down.image [2] [4] = 1;
			shape_trans_down.image [2] [5] = 1;
			shape_trans_down.image [3] [1] = 1;
			shape_trans_down.image [3] [5] = 1;
			shape_trans_down.image [4] [1] = 1;
			shape_trans_down.image [4] [5] = 1;
			
			shape_trans_down.image [1] [1] = 0;
			shape_trans_down.image [1] [2] = 0;
			shape_trans_down.image [1] [3] = 0;
			shape_trans_down.image [1] [4] = 0;
			shape_trans_down.image [1] [5] = 0;
		}
		
		return shape_trans_down;
	}
}