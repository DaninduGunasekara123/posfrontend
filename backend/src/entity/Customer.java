package entity;

public class Customer {
    private Integer cusName;
    private String cusAge;
    private String cusTp;
    private Double cusSalary;

    public Customer() {
    }

    public void setcusName(Integer cusName){
        this.cusName = cusName;
    }

    public Integer getCusName(){
        return cusName;
    }

    public void setCusAge(String cusAge){
        this.cusAge = cusAge;
    }

    public String getCusAge(){
        return cusAge;
    }

    public void setCusTp(String cusTp){
        this.cusTp = cusTp;
    }

    public String getCusTp(){
        return cusTp;
    }

    public void setCusSalary(Double cusSalary){
        this.cusSalary = cusSalary;
    }

    public Double getCusSalary(){
        return cusSalary;
    }

}
