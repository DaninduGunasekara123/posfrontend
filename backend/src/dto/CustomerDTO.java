package dto;

public class CustomerDTO {
    private String cusName;
    private String cusAge;
    private String cusTp;
    private String cusSalary;

    public void setcusName(String cusName){
        this.cusName = cusName;
    }

    public String getCusName(){
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

    public void setCusSalary(String cusSalary){
        this.cusSalary = cusSalary;
    }

    public String getCusSalary(){
        return cusSalary;
    }
}
