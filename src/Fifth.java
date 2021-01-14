public class Fifth {
    public static void main(String[] args) {
        handleEmployees();
    }

    private static Employee[] createEmployees(){
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Кабанов Владислав Денисович", "Инженер", "kaban@mail.ru", "+7 234 432-43-54", 342664.56, 25);
        employees[1] = new Employee("Козлов Аскольд Эдуардович", "Программист", "edik@mail.ru", "+7 409 056-76-75", 4367243.00, 32);
        employees[2] = new Employee("Гаврилов Мартын Арсеньевич", "Босс", "yaboss@mail.ru", "+7 492 308-49-95", 3466234.347, 42);
        employees[3] = new Employee("Панфилова Эрика Вадимовна", "Бухгалтер", "erika@mail.ru", "+7 859 696-36-30", 435236.5, 56);
        employees[4] = new Employee("Ильина Грета Лукьяновна", "Тимлид", "savetheworld@mail.ru", "+7 096 801-10-52", 236234.1, 34);
        return employees;
    }

    private static void handleEmployees(){
        Employee[] employees = createEmployees();
        showOld(employees);
    }

    private static void showOld(Employee[] employees){
        System.out.println("Сотрудники с возрастом больше 40 лет:");
        for (Employee employee: employees){
            if (employee.getAge() > 40){
                employee.print();
            }
        }
    }
}
