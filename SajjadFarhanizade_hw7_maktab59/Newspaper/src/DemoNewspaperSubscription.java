import java.util.Arrays;

public class DemoNewspaperSubscription {
    static NewspaperSubscription[] newspaperSubscriptions = new NewspaperSubscription[6];

    public static void main(String[] args) {
        for (int i = 0; i < newspaperSubscriptions.length; i++) {
            if(i<3)
                newspaperSubscriptions[i]=new PhysicalNewspaperSubscription();
            else
                newspaperSubscriptions[i]=new OnlineNewspaperSubscription();
            newspaperSubscriptions[i].setSubscriberName("Person "+i);
            if(i%2==0){
                    newspaperSubscriptions[i].setSubscriberAddress("");
            }
            else {
                if(i<3)
                    newspaperSubscriptions[i].setSubscriberAddress("Iran");
                else
                    newspaperSubscriptions[i].setSubscriberAddress("Person"+i+"@gmail.com");
            }
        }
        for(NewspaperSubscription newspaperSubscription: newspaperSubscriptions)
            System.out.println(newspaperSubscription.toString());
    }
}
