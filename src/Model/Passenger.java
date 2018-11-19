package Model;

public class Passenger {

    private int id;
    private int isAlive;
    private int pclass;
    private String name;
    private String sex;
    private double age;
    private int sibOrSpNum;
    private int parOrChNum;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarkLoc;


    //<editor-fold defaultstate="collapsed", desc="Constructors">
    public Passenger(){}

    public Passenger(int id, int isAlive, int pclass, String name, String sex, double age, int sibOrSpNum, int parOrChNum, String ticket, double fare, String cabin, String embarcLoc){
        this.id=id;
        this.isAlive=isAlive;
        this.pclass=pclass;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.sibOrSpNum=sibOrSpNum;
        this.parOrChNum=parOrChNum;
        this.ticket=ticket;
        this.fare=fare;
        this.cabin=cabin;
        this.embarkLoc=embarcLoc;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed", desc="Getters and Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getisAlive() {
        return isAlive;
    }

    public void setisAlive(int alive) {
        isAlive = alive;
    }

    public int getPclass() {
        return pclass;
    }

    public void setPclass(int pclass) {
        this.pclass = pclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getSibOrSpNum() {
        return sibOrSpNum;
    }

    public void setSibOrSpNum(int sibOrSpNum) {
        this.sibOrSpNum = sibOrSpNum;
    }

    public int getParOrChNum() {
        return parOrChNum;
    }

    public void setParOrChNum(int parOrChNum) {
        this.parOrChNum = parOrChNum;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarkLoc() {
        return embarkLoc;
    }

    public void setEmbarkLoc(String embarkLoc) {
        this.embarkLoc = embarkLoc;
    }
    //</editor-fold>

}
