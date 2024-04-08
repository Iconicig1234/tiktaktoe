package player;

public class Player {
    private String name;
    private int age;
    private char symbol;
    private String mailId;
    private long contactNo;

    //setters.

    public void setPlayers_Detail(String name, int age, char symbol, String mailId, long contactNo){
        this.name = name;
        this.age = age;
        this.symbol = symbol;
        this.mailId = mailId;
        this.contactNo = contactNo;
    }

    public void setPlayers_Name_Email(String name, String mailId){
        this.name = name;
        this.mailId = mailId;
    }

    public void setPlayers_Name_contactNo(String name, long contactNo){
        this.name = name;
        this.contactNo = contactNo;
    }

    public void setPlayers_Name_symbol(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    //getters.
    public String getPlayers_Name(){
        return this.name; 
    }

    public char getPlayers_Symbol(){
        return this.symbol; 
    }

    public void getPlayers_Name_Symbol(){
        System.out.println("Name:"+" "+this.name);
        System.out.println("Symbol:"+" "+this.symbol);
    }

    public void getPlayers_Detail(){
        System.out.println("Name:" +" "+this.name);
        System.out.println("Age:" +" "+this.age);
        System.out.println("Symbol:" +" "+this.symbol);
        System.out.println("EmailID:" +" "+this.mailId);
        System.out.println("ContactNo:" +" "+this.contactNo);
    }

    //change symbol
    public void change_symbol(char symbol){
        this.symbol = symbol;
    }
}
