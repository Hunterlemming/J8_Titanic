package Model.DataBase;

import Model.Passenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBC extends Config {

    //<editor-fold defaultstate="collapsed" desc="First run">
    public void firstRun(){                 //ezt hívd meg a mainből
        passengersToDB(fileToPassengers());
    }

    private ArrayList<Passenger> fileToPassengers(){
        ArrayList<Passenger> passengers = null;
        String lineAtError="";
        try {
            BufferedReader br = new BufferedReader( new FileReader("src/DataSource/train.csv") );
            passengers = new ArrayList<>();
            String line;
            br.readLine();
            while ((line=br.readLine()) != null && !line.equals("")){
                lineAtError=line;
                passengers.add(stringToPassenger(line));
            }
        }catch(Exception e){
            System.out.println("Error occurred while reading from files | " + e + " | " + lineAtError);
            e.printStackTrace();
        }
        return passengers;
    }

    private Passenger stringToPassenger(String line){

        int id = Integer.parseInt(getDataPart(line,0));

        int isAlive = Integer.parseInt(getDataPart(line,1));

        int pclass = Integer.parseInt(getDataPart(line,2));

        String name = getDataPart(line,3) + "," + getDataPart(line,4);    // "Asd, Mr.Asd" - formátumban van a név

        String sex = verifyStrValue(getDataPart(line,5));

        double age = verifyDoubleValue(getDataPart(line,6));

        int sibOrSpNum = verifyIntValue(getDataPart(line,7));

        int parOrChNum = verifyIntValue(getDataPart(line,8));

        String ticket = verifyStrValue(getDataPart(line,9));

        double fare = verifyDoubleValue(getDataPart(line,10));

        String cabin = verifyStrValue(getDataPart(line,11));

        String embarkLoc="";
        try {
            embarkLoc = verifyStrValue(getDataPart(line,12));
        } catch (ArrayIndexOutOfBoundsException e){}

        return new Passenger(id,isAlive,pclass,name,sex,age,sibOrSpNum,parOrChNum,ticket,fare,cabin,embarkLoc);

    }

        private String getDataPart(String line, int part){
            return line.split(",")[part];
        }

        private String verifyStrValue(String s){
            if (s.equals("") || s == null){
                return "";
            }
            else return s;
        }

        private int verifyIntValue(String s){
            if (s.equals("") || s == null){
                return 0;
            }
            else return Integer.parseInt(s);
        }

        private double verifyDoubleValue(String s){
            if (s.equals("") || s == null){
                return 0;
            }
            else return Double.parseDouble(s);
        }
    //</editor-fold>

    public void passengersToDB(ArrayList<Passenger> passengers){
        for (Passenger passenger:passengers) {
            addPassenger(passenger);
        }
    }

    public void addPassenger(Passenger passenger){
        String sql = "insert into titanic values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int id = -1;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            id=passenger.getId();

            preparedStatement.setInt(1,passenger.getId());
            preparedStatement.setInt(2,passenger.getisAlive());
            preparedStatement.setInt(3,passenger.getPclass());
            preparedStatement.setString(4,passenger.getName());
            preparedStatement.setString(5,passenger.getSex());
            preparedStatement.setDouble(6,passenger.getAge());
            preparedStatement.setInt(7,passenger.getSibOrSpNum());
            preparedStatement.setInt(8,passenger.getParOrChNum());
            preparedStatement.setString(9,passenger.getTicket());
            preparedStatement.setDouble(10,passenger.getFare());
            preparedStatement.setString(11,passenger.getCabin());
            preparedStatement.setString(12,passenger.getEmbarkLoc());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error in addPassenger method | " +e + "at id" + id);
        }
    }

    public Passenger getPassengerById(int id) throws Exception{
        Passenger passenger = null;
        String sql = "SELECT * FROM TITANIC WHERE PASSENGERID = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                passenger = new Passenger ( rs.getInt("passengerid"),
                                            rs.getInt("survived"),
                                            rs.getInt("pclass"),
                                            rs.getString("name"),
                                            rs.getString("sex"),
                                            rs.getDouble("age"),
                                            rs.getInt("sibsp"),
                                            rs.getInt("parch"),
                                            rs.getString("ticket"),
                                            rs.getDouble("fare"),
                                            rs.getString("cabin"),
                                            rs.getString("embarkloc"));
            }

        return passenger;
    }

}
