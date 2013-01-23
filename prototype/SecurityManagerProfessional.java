package pattpack.account;

/**
 *  Security manager of an professional account.
 */
public class SecurityManagerProfessional extends SecurityManagerIF {
    /** Maximum connection hours per months. */
    private static final int connectionHoursLimit = 180;
    /** Maximum connection speed. */
    private static final int connectionSpeedLimit = 178;
    /**
     *  Return the maximum connection hours per months.
     *  @return the maximum connection hours per months.
     */
    public int getConnectionHours () { return connectionHoursLimit; }
    /**
     *  Return the maximum connection speed.
     *  @return the maximum connection speed.
     */
    public int getConnectionSpeed () { return connectionSpeedLimit; }
    /**
     *  String representation of an professional security manager.
     *  @return the representation of an professional security manager.
     */
    public String toString () { return "SecurityManagerProfessional"; }
}






