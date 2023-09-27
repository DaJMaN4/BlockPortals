package me.dajman.blockportals.utils.configFiles;

public class DatabaseConfig {
    private Integer port;
    private String dbname;
    private String username;
    private String password;
    private String host;
    private String databaseType;


    public String getDatabaseType(){
        return this.databaseType;
    }
    public void setDatabaseType(String databaseType){
        this.databaseType = databaseType;
    }
    public String getHost(){
        return this.host;
    }
    public void setHost(String host){
        this.host = host;
    }
    public Integer getPort() {
        return port;
    }
    public void setPort(Integer port) {
        this.port = port;
    }
    public String getDbname() {
        return dbname;
    }
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
