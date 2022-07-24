package radiostation.patterns;

import radiostation.logic.broadcasts.*;

public class ContentBuilder implements Content{
    private final Content songs = new BroadcastList();
    private final Content ads = new BroadcastList();
    private final Content interviews = new BroadcastList();

    @Override
    public BroadcastList getContent() {
        BroadcastList broadcastList = new BroadcastList();
        broadcastList.addAll(songs.getContent().getBroadcasts());
        broadcastList.addAll(ads.getContent().getBroadcasts());
        broadcastList.addAll(interviews.getContent().getBroadcasts());
        return broadcastList;
    }

    @Override
    public boolean addContent(Content content) {
        return false;
    }

    public static class Builder {
        private final Content songs = new BroadcastList();
        private final Content ads = new BroadcastList();
        private final Content interviews = new BroadcastList();

        private final int totalDurationSec;
        private final int paidDurationSec;

        public Builder(int totalDurationSec, int paidDurationSec) {
            this.totalDurationSec = totalDurationSec;
            this.paidDurationSec = paidDurationSec;
        }

        public Builder songs(int quantity){
            BroadcastList wrapper = new BroadcastList();
            wrapper.addAll(Repository.getInstance().getNextSongs(quantity).getBroadcasts());
            this.songs.addContent(wrapper.getContent());
                return this;
        }
        public Builder ads(int quantity){
            BroadcastList wrapper = new BroadcastList();
            wrapper.addAll(Repository.getInstance().getNextAds(quantity).getBroadcasts());
            this.ads.addContent(wrapper.getContent());
            return this;
        }
        public Builder interviews(int quantity){
            BroadcastList wrapper = new BroadcastList();
            wrapper.addAll(Repository.getInstance().getNextInterviews(quantity).getBroadcasts());
            this.interviews.addContent(wrapper.getContent());
            return this;
        }

        public Builder songsWithDuration(int durationSec){
            this.songs.addContent(pickContentByDuration(Repository.getInstance().getSongsBlock(durationSec), durationSec));
            return this;
        }

        public Builder adsWithDuration(int durationSec){
            this.ads.addContent(pickContentByDuration(Repository.getInstance().getAdsBlock(durationSec), durationSec));
            return this;
        }

        public Builder interviewsWithDuration(int durationSec){
            this.interviews.addContent(pickContentByDuration(Repository.getInstance().getInterviewsBlock(durationSec), durationSec));
            return this;
        }
        private Content pickContentByDuration(Content source, int durationSec){
            Content destination = new BroadcastList();
            BroadcastList broadcastList = destination.getContent();

            for (Broadcast broadcast : source.getContent().getBroadcasts()) {

                if (broadcast.getDurationSec() + broadcastList.getTotalDurationSec() > this.totalDurationSec) {
                } else if (broadcast.isPaid() && broadcast.getDurationSec() + broadcastList.getPaidDurationSec() > this.paidDurationSec) {
                } else {
                    broadcastList.add(broadcast);
                }
            }
            return destination;
        }

        public int getCurrentSongsDurationSec(){
            return songs.getContent().getTotalDurationSec();
        }
        public int getCurrentAdsDurationSec(){
            return ads.getContent().getTotalDurationSec();
        }
        public int getCurrentInterviewsDurationSec(){
            return interviews.getContent().getTotalDurationSec();
        }
        public int getCurrentFreeDurationSec(){
            return getCurrentSongsDurationSec();
        }
        public int getCurrentPaidDurationSec(){
            return getCurrentAdsDurationSec()
                    + getCurrentInterviewsDurationSec();
        }
        public int getCurrentTotalDurationSec(){
            return getCurrentFreeDurationSec()
                    + getCurrentPaidDurationSec();
        }

        public int countSongs(){
            return songs.getContent().getBroadcasts().size();
        }
        public int countAds(){
            return ads.getContent().getBroadcasts().size();
        }
        public int countInterviews(){
            return interviews.getContent().getBroadcasts().size();
        }

        public int countAllContent(){
            return countSongs() + countAds() + countInterviews();
        }


        public ContentBuilder build(){
            ContentBuilder contentBuilder = new ContentBuilder();
            contentBuilder.songs.addContent(songs);
            contentBuilder.ads.addContent(ads);
            contentBuilder.interviews.addContent(interviews);
            return contentBuilder;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "songs=" + songs +
                    ", ads=" + ads +
                    ", interviews=" + interviews +
                    ", totalDurationSec=" + totalDurationSec +
                    ", paidDurationSec=" + paidDurationSec +
                    '}';
        }
    }

    public ContentBuilder(){
    }

    @Override
    public String toString() {
        return "ContentBuilder{" +
                "songs=" + songs +
                ", ads=" + ads +
                ", interviews=" + interviews +
                '}';
    }
}
