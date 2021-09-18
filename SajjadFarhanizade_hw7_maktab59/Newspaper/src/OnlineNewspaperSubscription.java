public class OnlineNewspaperSubscription extends NewspaperSubscription {
    @Override
    public void setSubscriberAddress(String subscriberAddress) {
        this.subscriberAddress=subscriberAddress;
        if (!this.subscriberAddress.contains("@")) {
            System.out.println("Error!");
        } else {
            setSubscriberRate(9);
        }

    }
}
