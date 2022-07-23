package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastList;

public interface FreeContent {
    BroadcastList getSongsBlock(int durationSec);
}
