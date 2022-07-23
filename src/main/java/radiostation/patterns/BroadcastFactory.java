package radiostation.patterns;

// ABSTRACT FACTORY pattern used
public interface BroadcastFactory {
    PaidContent createPaidContent(int durationSec);
    FreeContent createFreeContent(int durationSec);
}
