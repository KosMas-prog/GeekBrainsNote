public class Employee {
    //1. Создать класс "Сотрудник" с полями: ФИО, зарплата, возраст;





    //***8. Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный
    // уникальный идентификационный порядковый номер
    private String name;
    private int age;
    private double salary;
    //2. Конструктор класса должен заполнять эти поля при создании объекта;
    Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    //3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public double getSalary(){
        return this.salary;
    }
    //4. Вывести при помощи методов из пункта 3 ФИО и возраст.
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    //5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    Employee[] employee = new Employee[5];

    for (int i=0; i<employee.length; i++){
      if(employee[i].age>40) System.out.println(employee[i]);
    }

    //*6. Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    private static double UpSalary() {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].age > 45) System.out.println(employee[i]) {
                employee[i].salary = employee[i].salary + 5000;
            }
            return employee[i].salary;
        }
    }
        //**7. Подсчитать средние арифметические зарплаты и возраста
        int sum;
        for (int i = 0; i < employee.length; i++) {
            sum = employee[i].salary + sum;
        }
        System.out.println(sum / employee.length);
    }