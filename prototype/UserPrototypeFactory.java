package pattpack.account;

/**
 *  This class represents a prototype factory to create users of the internet service provider.
 *  Only one instance allowed.
 */
public class UserPrototypeFactory {
    /** Instance of the factory */
    private static final UserPrototypeFactory factoryInstance = new UserPrototypeFactory ();
    /** Available accounts */
    private static final AccountEconomy      accountEconomy = new AccountEconomy ();
    private static final AccountStandard     accountStandard = new AccountStandard ();
    private static final AccountProfessional accountProfessional = new AccountProfessional ();
    /** Available security managers */
    private static final SecurityManagerEconomy      securityManagerEconomy = new SecurityManagerEconomy ();
    private static final SecurityManagerStandard     securityManagerStandard = new SecurityManagerStandard ();
    private static final SecurityManagerProfessional securityManagerProfessional = new SecurityManagerProfessional ();
    /**
     *  Private constructor 
     */
    private UserPrototypeFactory () {
        // Client can not instanciate this
    }
    /**
     *  Get an instance of the factory
     */
    public static UserPrototypeFactory getInstance () {
        return factoryInstance;
    }
    /**
     *  Construct a user object.
     *  @param loginId Login ID that would be assigned to the user.
     */
    public User newUser (int loginId) throws InternalErrorException {
        /* Account and Security Manager */
        AccountIF account = null;
        SecurityManagerIF securityManager = null;
        /* User to return */
        User user = null;
        /* Parse login ID */
        try {
            if (1000 < loginId && loginId <= 5000) {
                account = (AccountIF) accountEconomy.makeNew (loginId);
                securityManager = (SecurityManagerIF) securityManagerEconomy.clone ();
            } else if (5000 < loginId && loginId <= 8000) {
                account = (AccountIF) accountStandard.makeNew (loginId);
                securityManager = (SecurityManagerIF) securityManagerStandard.clone ();
            } else if (8000 < loginId && loginId <= 9999) {
                account = (AccountIF) accountProfessional.makeNew (loginId);
                securityManager = (SecurityManagerIF) securityManagerProfessional.clone ();
            } else {
                throw new InternalErrorException ("Argument out of range");
            }
        } catch (CloneNotSupportedException e) {
            throw new InternalErrorException ("Cloning not supported: " + e);
        }
        /* Create user */
        user = new User (account, securityManager);

        return user;
    }
}
