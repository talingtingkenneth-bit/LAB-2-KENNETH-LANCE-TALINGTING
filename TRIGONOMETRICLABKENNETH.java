/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trigonometric.lab.kenneth;

import java.util.Scanner;
import static java.lang.Math.*;

public class TRIGONOMETRICLABKENNETH {

    /**
     * @param args the command line arguments
     * 
     * 
     * 
     * 
     *///PROBLEM 1///
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter angle in degrees: ");
        double angleDeg1 = input.nextDouble();

        System.out.println("Choose function:");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.println("4. All three");
        int choice = input.nextInt();

        // Convert degrees to radians (Java Math uses radians)
        double rad3 = toRadians(angleDeg1);

        // Conditional logic
        if (choice == 1) {
            System.out.println("Sine(" + angleDeg1 + "°) = " + sin(rad3));
        } else if (choice == 2) {
            System.out.println("Cosine(" + angleDeg1 + "°) = " + cos(rad3));
        } else if (choice == 3) {
            // Check for tangent undefined condition
            if (Math.abs(angleDeg1 % 180 - 90) <= 1) {
                System.out.println("Tangent(" + angleDeg1 + "°) is undefined!");
            } else {
                System.out.println("Tangent(" + angleDeg1 + "°) = " + tan(rad3));
            }
        } else if (choice == 4) {
            System.out.println("Sine(" + angleDeg1 + "°) = " + sin(rad3));
            System.out.println("Cosine(" + angleDeg1 + "°) = " + cos(rad3));

            if (Math.abs(angleDeg1 % 180 - 90) <= 1) {
                System.out.println("Tangent(" + angleDeg1 + "°) is undefined!");
            } else {
                System.out.println("Tangent(" + angleDeg1 + "°) = " + tan(rad3));
            }
        } else {
            System.out.println("Invalid choice!");
        }

// 1. Why do we need to convert angles from degrees to radians?
        // → Java's Math class trigonometric functions (sin, cos, tan) 
        // expect input in radians. Degrees must be converted so the 
        // functions give correct results.
//2. What makes tangent undefined at certain angles?
        //→ Tangent = sin/cos. At angles like 90° and 270°, cosine = 0, 
        // so the denominator becomes zero. Division by zero is undefined.
//3. How could you modify this program to also calculate reciprocal functions 
        //(cosecant, secant, cotangent)?
        //→ By adding conditions to compute:
        //   - cosecant = 1/sin(θ), if sin(θ) ≠ 0
        // - secant  = 1/cos(θ), if cos(θ) ≠ 0
        //  - cotangent = 1/tan(θ), if tan(θ) ≠ 0
        // Using if-statements to check undefined cases first.
        
        
        
        
        
        
        /// PROBLEM 2 ///
        System.out.print("Enter angle in degrees: ");
        double angle = input.nextDouble();

        // Normalize angle to range [0, 360)
        angle = ((angle % 360) + 360) % 360;

        System.out.println("Normalized angle: " + angle + "°");

        // Check exact axis angles
        if (angle == 0 || angle == 180 || angle == 360) {
            System.out.println("On X-axis: sine = 0, cosine = ±1, tangent = 0");
        } else if (angle == 90 || angle == 270) {
            System.out.println("On Y-axis: sine = ±1, cosine = 0, tangent = undefined");
        } else {
            // Quadrant determination
            if (angle > 0 && angle < 90) {
                System.out.println("Quadrant I: sin +, cos +, tan +");
            } else if (angle > 90 && angle < 180) {
                System.out.println("Quadrant II: sin +, cos -, tan -");
            } else if (angle > 180 && angle < 270) {
                System.out.println("Quadrant III: sin -, cos -, tan +");
            } else if (angle > 270 && angle < 360) {
                System.out.println("Quadrant IV: sin -, cos +, tan -");
            }
        }

        //================ Critical Thinking Questions =================
//1. Why is it important to normalize angles before determining their quadrant?
        //→ Because angles can be given as negative values or values larger than 360°.
        // Normalizing ensures we reduce the angle to its equivalent within the standard
        //0°–360° range, making quadrant detection consistent.
//2. How does the sign of trigonometric functions change across different quadrants?
        // → The signs follow the ASTC rule ("All Students Take Calculus"):
        // Quadrant I   : sin +, cos +, tan +
        // Quadrant II  : sin +, cos -, tan -
        // Quadrant III : sin -, cos -, tan +
        //Quadrant IV  : sin -, cos +, tan -
//3. What special considerations are needed for angles exactly on the axes?
        //→ At axis angles (0°, 90°, 180°, 270°), one or more trigonometric
        // functions become exactly 0 or undefined (e.g., tan(90°) is undefined). 
        // These cases must be handled separately to avoid division errors.
        
        
        
        
        
        
        /// PROBLEM 3 ///
        System.out.println("Right Triangle Solver");
        System.out.println("Choose what you know:");
        System.out.println("1. Two sides");
        System.out.println("2. One side and one angle (< 90°)");
        int choice1 = input.nextInt();

        double a = 0, b = 0, c = 0; // sides
        double A = 0, B = 0, C = 90; // angles (C is always 90° in right triangle)

        if (choice == 1) {
            // Case 1: Two sides known
            System.out.print("Enter side a: ");
            a = input.nextDouble();
            System.out.print("Enter side b: ");
            b = input.nextDouble();

            if (a <= 0 || b <= 0) {
                System.out.println("Invalid input! Sides must be positive.");
                input.close();
                return;
            }

            // Hypotenuse
            c = sqrt(pow(a, 2) + pow(b, 2));
            // Angles
            A = toDegrees(atan2(a, b));
            B = 90 - A;

        } else if (choice == 2) {
            // Case 2: One side and one angle
            System.out.print("Enter known side length: ");
            double side = input.nextDouble();
            System.out.print("Enter known angle (< 90°): ");
            double angleA = input.nextDouble();

            if (side <= 0 || angleA <= 0 || angleA >= 90) {
                System.out.println("Invalid input! Side must be positive and angle must be < 90°.");
                input.close();
                return;
            }

            A = angleA;
            B = 90 - A;

            // Assume given side is opposite side "a"
            a = side;
            // Hypotenuse
            c = a / sin(toRadians(A));
            // Other side
            b = sqrt(pow(c, 2) - pow(a, 2));

        } else {
            System.out.println("Invalid choice!");
            input.close();
            return;
        }

        // Display results
        System.out.println("\n=== Results ===");
        System.out.printf("Sides: a = %.2f, b = %.2f, c = %.2f%n", a, b, c);
        System.out.printf("Angles: A = %.2f°, B = %.2f°, C = 90°%n", A, B);
        System.out.printf("Area = %.2f%n", 0.5 * a * b);

        
        
        
        
        /// PROBLEM 4 ///
        System.out.print("Enter angle in degrees: ");
        double angleDeg4 = input.nextDouble();
        double rad5 = toRadians(angleDeg4);

        // Set tolerance for floating-point comparisons
        double tol = 1e-6;

        // Identity 1: sin²θ + cos²θ = 1
        double lhs1 = pow(sin(rad5), 2) + pow(cos(rad5), 2);
        double rhs1 = 1;
        boolean id1 = abs(lhs1 - rhs1) < tol;

        // Identity 2: 1 + tan²θ = sec²θ
        double lhs2 = 1 + pow(tan(rad5), 2);
        double rhs2 = 1 / pow(cos(rad5), 2);
        boolean id2 = abs(lhs2 - rhs2) < tol;

        // Identity 3: sin(2θ) = 2sinθcosθ
        double lhs3 = sin(2 * rad5);
        double rhs3 = 2 * sin(rad5) * cos(rad5);
        boolean id3 = abs(lhs3 - rhs3) < tol;

        System.out.println("\n=== Identity Verification Results ===");
        System.out.printf("sin²θ + cos²θ = 1 : %s (diff = %.6f)%n", id1, lhs1 - rhs1);
        System.out.printf("1 + tan²θ = sec²θ : %s (diff = %.6f)%n", id2, lhs2 - rhs2);
        System.out.printf("sin(2θ) = 2sinθcosθ : %s (diff = %.6f)%n", id3, lhs3 - rhs3);

        //================ Critical Thinking Questions =================
//1. Why do we need a tolerance when comparing floating-point values?
        // → Because computers approximate real numbers, floating-point operations 
        // may produce tiny rounding errors. A tolerance ensures we treat values 
        // as equal if their difference is extremely small.
//2. Which identity might be most susceptible to floating-point precision issues and why?
        // → The identity "1 + tan²θ = sec²θ" is most susceptible. 
        // This is because tangent and secant both involve division by cosine, 
        //  which can be very small near 90° or 270°, amplifying rounding errors.
//3. How could you extend this program to verify more complex identities?
        // → By adding more formulas and computing both sides symbolically. 
        // For example: half-angle identities, sum and difference formulas, 
        // or using loops/arrays to test multiple identities automatically.
        
        
        
        
        
        /// PROBLEM 5 ///
        System.out.print("Enter amplitude: ");
        double A2 = input.nextDouble();

        System.out.print("Enter frequency (Hz): ");
        double f = input.nextDouble();

        System.out.print("Enter phase shift (degrees): ");
        double phase = toRadians(input.nextDouble());

        System.out.print("Enter time (seconds): ");
        double t = input.nextDouble();

        // Instantaneous value of wave
        double value = A * sin(2 * PI * f * t + phase);

        System.out.println("\n=== Wave Analysis ===");
        System.out.printf("Wave value at t = %.3f s: %.6f%n", t, value);

        // Determine peak, trough, or zero-crossing
        double tol4 = 1e-6;
        if (abs(value - A) < tol) {
            System.out.println("Wave is at a PEAK.");
        } else if (abs(value + A) < tol) {
            System.out.println("Wave is at a TROUGH.");
        } else if (abs(value) < tol) {
            System.out.println("Wave is at a ZERO-CROSSING.");
        } else {
            System.out.println("Wave is at a general point (not peak/trough/zero).");
        }

        // Next peak calculation
        // Peak occurs when argument = π/2 + 2πn
        double arg = 2 * PI * f * t + phase;
        double n = ceil((arg - PI / 2) / (2 * PI)); // smallest n that gives a future peak
        double nextPeak = ((PI / 2) + 2 * PI * n - phase) / (2 * PI * f);

        System.out.printf("Next peak will occur at t = %.6f s%n", nextPeak);

    }

}
