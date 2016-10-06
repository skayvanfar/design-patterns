package BehavioralPatterns.Mediator;

/**
 * The "intermediary"
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 10/6/2016.
 */
public class Mediator {

    // 4. The Mediator arbitrates
    private boolean slotFull = false;
    private int number;
    public synchronized void storeMessage( int num ) {
        // no room for another message
        while (slotFull == true) {
            try {
                wait();
            }
            catch (InterruptedException e ) { }
        }
        slotFull = true;
        number = num;
        notifyAll();
    }
    public synchronized int retrieveMessage() {
        // no message to retrieve
        while (slotFull == false)
            try {
                wait();
            }
            catch (InterruptedException e ) { }
        slotFull = false;
        notifyAll();
        return number;
    }
}
