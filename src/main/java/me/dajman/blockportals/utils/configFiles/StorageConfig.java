package me.dajman.blockportals.utils.configFiles;

public class StorageConfig {
    private String databaseType;
    private String databaseIP;
    private Integer databasePort;
    private String databaseName;
    private String databaseUsername;
    private String databasePassword;
    private String databaseTablePrefix;

    public StorageConfig(String databaseType, String databaseIP, String databaseName,
                         String databaseUsername, String databasePassword, String databaseTablePrefix) {
        this.databaseType = databaseType;
        this.databaseIP = databaseIP;
        this.databaseName = databaseName;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
        this.databaseTablePrefix = databaseTablePrefix;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getDatabaseIP() {
        return databaseIP;
    }

    public void setDatabaseIP(String databaseIP) {
        this.databaseIP = databaseIP;
    }

    public Integer getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(Integer databasePort) {
        this.databasePort = databasePort;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public String getDatabaseTablePrefix() {
        return databaseTablePrefix;
    }

    public void setDatabaseTablePrefix(String databaseTablePrefix) {
        this.databaseTablePrefix = databaseTablePrefix;
    }

}
