package bankAccount;

public interface IBaseRate {

    //Method that returns the base rate (in this example, set at 2.5):
    default double getBaseRate () {
        return 2.5;
    }
}
