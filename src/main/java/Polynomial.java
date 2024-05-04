import java.util.*;
import java.util.regex.Pattern;

public class Polynomial {

    private HashMap<Integer, Double> polynomial;

    public Polynomial() {
        polynomial = new HashMap<>();
    }

    public Polynomial(HashMap<Integer, Double> result) {
        polynomial = result;
    }

    public HashMap<Integer, Double> getPolynomial() {
        return polynomial;
    }
    void setPolynomial(HashMap<Integer, Double> polynomial) {
        this.polynomial = polynomial;
    }

    public int getDegree() {
        if (this.polynomial.isEmpty()) {
            return 0;
        }
        return Collections.max(this.polynomial.keySet());
    }

    public double getCoefficient(int degree) {
        return this.polynomial.getOrDefault(degree, 0.0);
    }

    public void setCoefficient(int degree, double coefficient) {
        if (coefficient != 0) {
            this.polynomial.put(degree, coefficient);
        } else {
            this.polynomial.remove(degree);
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        List<Integer> sortedDegrees = new ArrayList<>(polynomial.keySet());
        Collections.sort(sortedDegrees, Collections.reverseOrder());

        for (int degree : sortedDegrees) {
            if (degree == 0) {
                continue; // Skip degree 0 as it's handled separately
            }

            double coefficient = polynomial.get(degree);
            if (coefficient == 0) {
                continue; // Skip terms with zero coefficient
            }

            if (!stringBuilder.isEmpty()) {
                if (coefficient >= 0) {
                    stringBuilder.append(" + ");
                } else {
                    stringBuilder.append(" - ");
                    coefficient = Math.abs(coefficient);
                }
            }
            stringBuilder.append(formatCoefficient(coefficient, degree));
            if (degree > 0) {
                stringBuilder.append("x");
                if (degree > 1) {
                    stringBuilder.append("^").append(degree);
                }
            }
        }

        // Handle constant term
        if (polynomial.containsKey(0)) {
            double constant = polynomial.get(0);
            if (constant != 0) {
                if (!stringBuilder.isEmpty()) {
                    if (constant >= 0) {
                        stringBuilder.append(" + ");
                    } else {
                        stringBuilder.append(" - ");
                        constant = Math.abs(constant);
                    }
                }
                stringBuilder.append(formatCoefficient(constant,0));
            }
        }

        return stringBuilder.toString();
    }

    private String formatCoefficient(double coefficient, int degree) {
        if (isInteger(coefficient)) {
            if (coefficient == 1 || coefficient == -1) {
                if (degree == 0) {
                    return Integer.toString((int) coefficient);
                } else {
                    if (coefficient < 0) {
                        return "-";
                    } else {
                        return ""; // Don't display coefficient if it's 1
                    }
                }
            } else {
                return Integer.toString((int) coefficient); // Convert to integer if possible
            }
        } else {
            return Double.toString(coefficient);
        }
    }

    private boolean isInteger(double value) {
        return value == (int) value;
    }

    public static Polynomial build(String input) {
        HashMap<Integer, Double> poly = new HashMap<>();
        input = input.replace("-", "+-");
        String[] monomials = input.split("\\+");
        for (String monomial : monomials) {
            if (monomial.isEmpty()) {
                continue;
            }
            double coefficient;
            int degree;
            if (!monomial.contains("x")) {
                coefficient = Double.parseDouble(monomial);
                degree = 0;
            } else {
                String[] parts = monomial.split("x");
                if (parts.length == 0) {
                    coefficient = 1;
                } else if (parts[0].equals("-")) {
                    coefficient = -1;
                } else if (parts[0].isEmpty() || parts[0].equals("+")) {
                    //coefficient = parts.length > 1 ? 1 : Double.parseDouble(parts[0]);
                    coefficient = 1;
                } else {
                    coefficient = Double.parseDouble(parts[0]);
                }
                degree = parts.length > 1 ? Integer.parseInt(parts[1].substring(1)) : 1;
            }
            poly.put(degree, coefficient);

        }
        return new Polynomial(poly);
    }

    public static boolean isValidPolynomialFormat(String input) {
        String regex = "([+-]?\\d*(\\.\\d*)?(x)?(\\^\\d+)?)+";
        return Pattern.matches(regex, input.trim());
    }




}
