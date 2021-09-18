public abstract class NewspaperSubscription {
    protected String subscriberName;
    protected String subscriberAddress;
    protected int subscriberRate;

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberAddress() {
        return subscriberAddress;
    }

    public abstract void setSubscriberAddress(String subscriberAddress);

    public int getSubscriberRate() {
        return subscriberRate;
    }

    public void setSubscriberRate(int subscriberRate) {
        this.subscriberRate = subscriberRate;
    }

    @Override
    public String toString() {
        return "NewspaperSubscription{" +
                "subscriberName='" + subscriberName + '\'' +
                ", subscriberAddress='" + subscriberAddress + '\'' +
                ", subscriberRate=" + subscriberRate +
                "}\n";
    }
}
