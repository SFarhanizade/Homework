import java.util.Arrays;

public class DemoNewspaperSubscription {
    static PhysicalNewspaperSubscription[] physicalNewspaperSubscriptions = new PhysicalNewspaperSubscription[3];
    static OnlineNewspaperSubscription[] onlineNewspaperSubscriptions = new OnlineNewspaperSubscription[3];

    public static void main(String[] args) {
        for (int i = 0; i < physicalNewspaperSubscriptions.length; i++) {
            physicalNewspaperSubscriptions[i]=new PhysicalNewspaperSubscription();
            physicalNewspaperSubscriptions[i].setSubscriberName("Person "+i);
            if(i%2==0){
                physicalNewspaperSubscriptions[i].setSubscriberAddress("");
            }
            else {
                physicalNewspaperSubscriptions[i].setSubscriberAddress(Integer.toString(i));
            }
        }
        for (int i = 0; i < onlineNewspaperSubscriptions.length; i++) {
            onlineNewspaperSubscriptions[i]=new OnlineNewspaperSubscription();
            onlineNewspaperSubscriptions[i].setSubscriberName("Person "+i);
            if(i%2==0){
                onlineNewspaperSubscriptions[i].setSubscriberAddress("");
            }
            else {
                onlineNewspaperSubscriptions[i].setSubscriberAddress("@");
            }
        }
        System.out.println(Arrays.toString(onlineNewspaperSubscriptions));
        System.out.println(Arrays.toString(physicalNewspaperSubscriptions));
    }
}
