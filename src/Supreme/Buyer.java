package Supreme;

public class Buyer {

    String name;
    String email;
    String tel;
    String address;
    String apt;
    String zip;
    String city;
    String State;
    String cardNumber;
    String expMonth;
    String expYear;
    String cvv;
    String country;
    String username;
    String password;

    public Buyer(String name, String email, String tel, String address, String apt, String zip, String city, String state, String cardNumber, String expMonth, String expYear, String cvv, String country, String username, String password) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.apt = apt;
        this.zip = zip;
        this.city = city;
        State = state;
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cvv = cvv;
        this.country=country;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String getCountry() {
    	return country;
    }
    
    public void setCountry(String country) {
    	this.country=country;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String username) {
    	this.username=username;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password=password;
    }

    @Override
    public String toString() {
    	String s = name+"~"+email+"~"+tel+"~"+ address+"~"+ apt+"~"+zip+"~"+city+"~"+State+"~"+cardNumber+"~"+expMonth+"~"+expYear+"~"+cvv+"~"+country+"~"+username+"~"+password;
    	return s;
    }

}
