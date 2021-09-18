public class PhysicalNewspaperSubscription extends NewspaperSubscription{
    @Override
    public void setSubscriberAddress(String subscriberAddress) {
        this.subscriberAddress=subscriberAddress;
        if(this.subscriberAddress.length()==0) {
            System.out.println("Error!");
            setSubscriberRate(0);
        }else{
            setSubscriberRate(15);

        }

    }

}
