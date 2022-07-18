package radiostation.patterns;

public interface IContainer {
    IIterator createSongsIterator();
    IIterator createAdsIterator();
    IIterator createInterviewsIterator();
}
