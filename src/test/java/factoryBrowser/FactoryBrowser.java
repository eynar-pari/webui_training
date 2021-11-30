package factoryBrowser;

public class FactoryBrowser {

    public static IBrowser make(String browserType){
        IBrowser browser;
        switch (browserType.toLowerCase()){
            case "chrome":
                browser= new Chrome();
                break;
            case "firefox":
                browser = new Firefox();
                break;
            case "edge":
                browser = new Edge();
                break;
            case "cloud":
               browser = new ChromeCloud();
               break;
            default:
                browser= new Chrome();
                break;
        }
        return browser;
    }

}
