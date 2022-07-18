package radiostation;

public interface IContainer {
    public IIterator createSongsIterator();
    public IIterator createAdsIterator();
    public IIterator createInterviewsIterator();
}
