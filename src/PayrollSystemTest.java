public class PayrollSystemTest {
    public static void main(String[] args) {
        SalariedEmpolyee salariedEmpolyee = new SalariedEmpolyee("Jan", "Kowalski", "111-11-1111", 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Anna", "Nowak", "222-22-2222", 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Zofia", "Lewandowska", "333-33-3333", 10000, .06);
        BesePlusCommissionEmployee besePlusCommissionEmployee = new BesePlusCommissionEmployee("Robert", "Czekaj", "444-44-4444", 5000, .04, 300);

        System.out.println("Pracownicy przetwarzani pojedynczo:");
        System.out.printf("%n%s%n%s: %,.2f zł%n%n",
                salariedEmpolyee, "zarobił", salariedEmpolyee.earnings());
        System.out.printf("%s%n%s: %,.2fzł%n%n",
                hourlyEmployee, "zarobił", hourlyEmployee.earnings());
        System.out.printf("%s%n%s %,.2f zł%n%n",
                commissionEmployee, "zarobił", commissionEmployee.earnings());
        System.out.printf("%S%n%s %,.2f zł%n%n",
                besePlusCommissionEmployee, "zarobił", besePlusCommissionEmployee.earnings());

        Employee[] employees = new Employee[4];

        employees[0] = salariedEmpolyee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = besePlusCommissionEmployee;

        System.out.printf("Pracownicy przetwarzani polimorficznie:%n%n");

        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);
            if (currentEmployee instanceof BesePlusCommissionEmployee) {
                BesePlusCommissionEmployee employee = (BesePlusCommissionEmployee) currentEmployee;
                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf("nowe wynagrodzenie zasadnicze po podwyżce 10%% wynosi: %,.2f zł%n",
                        employee.getBaseSalary());
            }
            System.out.printf("zarobił %,.2f zł%n%n", currentEmployee.earnings());
        }

        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Pracownik %d to klasa %s%n", j, employees[j].getClass().getName());
        }
    }
}
