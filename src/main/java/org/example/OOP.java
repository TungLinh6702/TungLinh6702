package org.example;// Tính chất OOP: Đóng gói, Kế thừa, Đa hình, Tính trừu tượng

// 1. Tính chất Đóng gói (Encapsulation)
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

// 2. Tính chất Kế thừa (Inheritance)
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Ghi đè phương thức withdraw để thêm chức năng phí rút tiền cho tài khoản tiết kiệm
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (getBalance() < 1000) {
            // Áp dụng phí rút tiền nếu số dư dưới 1000
            double fee = 5.0;
            super.withdraw(fee);
            System.out.println("Withdrawal fee of $" + fee + " applied. New balance: $" + getBalance());
        }
    }
}

// 3. Tính chất Đa hình (Polymorphism)
interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

// 4. Tính chất Tính trừu tượng (Abstraction)
abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}

// Main class để kiểm thử
public class OOP {
    public static void main(String[] args) {
        // Đóng gói
        BankAccount account = new BankAccount("123456", 1000.0);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.getBalance());

        // Kế thừa
        SavingsAccount savingsAccount = new SavingsAccount("789012", 2000.0, 0.02);
        System.out.println("Interest Rate: " + savingsAccount.getInterestRate());
        savingsAccount.deposit(500.0);
        savingsAccount.withdraw(300.0);

        // Đa hình
        Circle circle = new Circle(5.0);
        Square square = new Square(4.0);

        printArea(circle);
        printArea(square);

        // Tính trừu tượng
        Dog dog = new Dog();
        Cat cat = new Cat();

        makeAnimalSound(dog);
        makeAnimalSound(cat);
    }

    // Đa hình
    static void printArea(Shape shape) {
        System.out.println("Area: " + shape.calculateArea());
    }

    // Tính trừu tượng
    static void makeAnimalSound(Animal animal) {
        animal.makeSound();
    }
}
