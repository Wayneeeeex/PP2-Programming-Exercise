class Vehicle {
    private String regNo;
    private String make;
    private int yearOfManufacture;
    private double value;

    public Vehicle(String regNo, String make, int yearOfManufacture, double value) {
        this.regNo = regNo;
        this.make = make;
        this.yearOfManufacture = yearOfManufacture;
        this.value = value;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getMake() {
        return make;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getValue() {
        return value;
    }

    // Added calculateAge() method to calculate the age of the vehicle
    public int calculateAge() {
        // Assuming the current year is retrieved at runtime
        int currentYear = 2024; // You can replace this with a method to get the current year
        return currentYear - yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Reg No: " + regNo + ", Make: " + make + ", Year of Manufacture: " + yearOfManufacture + ", Value: Php" + String.format("%.2f", value);
    }
}