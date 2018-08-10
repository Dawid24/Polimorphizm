public class SalariedEmpolyee extends Employee {
    private double weaklySalary;

    public SalariedEmpolyee(String firstName, String lastName, String socialSecurityNumber, double weaklySalary) {
        super(firstName, lastName, socialSecurityNumber);

        if (weaklySalary < 0.0) {
            throw new IllegalArgumentException(
                    "Tygodniowe wynagrodzenie musi być >= 0.0"
            );
        }
        this.weaklySalary = weaklySalary;
    }

    public void setWeaklySalary(double weaklySalary) {
        if (weaklySalary < 0.0) {
            throw new IllegalArgumentException(
                    "Tygodniowe wynagrodzenie musi być >= 0.0"
            );
        }
        this.weaklySalary = weaklySalary;
    }

    public double getWeaklySalary() { return weaklySalary; }

    @Override
    public double earnings() { return getWeaklySalary(); }

    @Override
    public String toString() {
        return String.format("pracownik ze stałym wynagrodzeniem: %s%n%s: " +
                "%,.2f zł",
                super.toString(), "wynagrodzenie tygodniowe", getWeaklySalary());
    }
}
