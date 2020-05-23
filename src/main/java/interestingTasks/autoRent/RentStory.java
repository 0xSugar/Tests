package interestingTasks.autoRent;

public class RentStory {
    private Person person;
    private Company.AutoTransport autoTransport;
    private int from;
    private int to;

    public RentStory(Person person, Company.AutoTransport autoTransport, int from, int to) {
        this.person = person;
        this.autoTransport = autoTransport;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return String.format("Person %s орендовал %s на %d дней", person.toString(), autoTransport, to);
    }
}
