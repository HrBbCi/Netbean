
package B3.com.vn;

public class NguoiDung {
    private String Id, fullName, Sex, Birthday, Mobile, Email, webSite, 
            userName, PassWord,rePassWord ,dateCreate, dateLastUpdate,Address, Note;
    public NguoiDung(){
        
    }
    public NguoiDung(String Id, String fullName, String Sex, String Birthday, 
            String Mobile, String Email, String webSite, String userName, 
            String Password, String rePassWord,String dateCreate, String dateLastUpdate, 
            String Address, String Note) {
        this.Id = Id;
        this.fullName = fullName;
        this.Sex = Sex;
        this.Birthday = Birthday;
        this.Mobile = Mobile;
        this.Email = Email;
        this.webSite = webSite;
        this.userName = userName;
        this.PassWord = Password;
        this.dateCreate = dateCreate;
        this.dateLastUpdate = dateLastUpdate;
        this.Address = Address;
        this.Note = Note;
        this.rePassWord = rePassWord;
    }

    public String getRePassWord() {
        return rePassWord;
    }

    public void setRePassWord(String rePassWord) {
        this.rePassWord = rePassWord;
    }
    
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    public String getFullName(){
        return fullName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String Password) {
        this.PassWord = Password;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateLastUpdate() {
        return dateLastUpdate;
    }

    public void setDateLastUpdate(String dateLastUpdate) {
        this.dateLastUpdate = dateLastUpdate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
}
