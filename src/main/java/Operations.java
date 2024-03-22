import java.util.*;

public class Operations {

    public static Polynomial addition(Polynomial p1, Polynomial p2) {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> term : p1.getPolynomial().entrySet()) {
            result.put(term.getKey(), term.getValue());
        }
        for (Map.Entry<Integer, Double> term : p2.getPolynomial().entrySet()) {
            result.merge(term.getKey(), +term.getValue(), Double::sum);
        }
        return new Polynomial(result);
    }

    public static Polynomial subtraction(Polynomial p1, Polynomial p2) {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> term : p1.getPolynomial().entrySet()) {
            result.put(term.getKey(), term.getValue());
        }
        for (Map.Entry<Integer, Double> term : p2.getPolynomial().entrySet()) {
            result.merge(term.getKey(), -term.getValue(), Double::sum);
        }
        return new Polynomial(result);
    }

    public static Polynomial multiplication(Polynomial p1, Polynomial p2) {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> term1 : p1.getPolynomial().entrySet()) {
            for (Map.Entry<Integer, Double> term2 : p2.getPolynomial().entrySet()) {
                int degree = term1.getKey() + term2.getKey();
                double coefficient = term1.getValue() * term2.getValue();
                result.merge(degree, coefficient, Double::sum);
            }
        }
        return new Polynomial(result);
    }

    public static Polynomial[] division(Polynomial p1, Polynomial p2) {
        if(p2.getDegree() > p1.getDegree()) {
            throw new IllegalArgumentException("Degree of divisor > Degree of dividend.");
        }

        if (p2.getPolynomial().isEmpty() || isZero(p2)) {
            throw new IllegalArgumentException("The divisor cannot be zero.");
        }

        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();
        Polynomial dividend = new Polynomial(p1.getPolynomial());

        while (!isZero(dividend) && dividend.getDegree() >= p2.getDegree()) {
            int degreeQ = dividend.getDegree() - p2.getDegree();
            double coeffQ = dividend.getCoefficient(dividend.getDegree()) / p2.getCoefficient(p2.getDegree());

            Polynomial additionTerm = new Polynomial();
            additionTerm.setCoefficient(degreeQ, coeffQ);

            quotient = addition(quotient, additionTerm);
            Polynomial subtractTerm = multiplication(additionTerm, p2);
            dividend = subtraction(dividend, subtractTerm);

            HashSet<Integer> degrees = new HashSet<>(dividend.getPolynomial().keySet());
            for (int degree : degrees) {
                if (dividend.getCoefficient(degree) == 0) {
                    dividend.getPolynomial().remove(degree);
                }
            }
        }
        remainder = dividend;

        return new Polynomial[]{quotient, remainder};
    }

    private static boolean isZero(Polynomial polynomial) {
        for (double coefficient : polynomial.getPolynomial().values()) {
            if (coefficient != 0) {
                return false;
            }
        }
        return true;
    }

    public static Polynomial derivative(Polynomial p) {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : p.getPolynomial().entrySet()) {
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            if (degree > 0) {
                result.put(degree - 1, coefficient * degree);
            } else {
                // For constant terms , the derivative is 0
                result.put(0, 0.0);
            }
        }
        return new Polynomial(result);
    }

    public static Polynomial integration(Polynomial p) {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : p.getPolynomial().entrySet()) {
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            result.put(degree + 1, coefficient / (degree + 1));
        }

        return new Polynomial(result);
    }




}
