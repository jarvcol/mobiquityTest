package util;

import enums.EnvironmentType;

public class UrlSetUp {
    private static EnvironmentType environmentType;

    public static String getUrl(){
        String url = null;
        environmentType = environmentType.valueOf(FileReaderManager.getInstance().getConfigReader().getEnvironment().toLowerCase().trim());
        switch (environmentType) {
            case dev:
                url = "";
                break;
            case qa:
                url = "";
                break;
            case prod:
                url =  "http://cafetownsend-angular-rails.herokuapp.com";
                break;
        }
        return url;
    }
}
