//package radiostation;
//
//import java.util.ArrayList;
//
//class RecordCollection implements IContainer{
//
//    private ArrayList<Broadcast> broadcastList;
//
//    public RecordCollection(ArrayList<Broadcast> broadcastList) {
//        this.broadcastList = broadcastList;
//    }
//
//    @Override
//    public IIterator createIterator() {
//        RecordIterator iterator = new RecordIterator();
//        return iterator;
//    }
//
//    private class RecordIterator implements IIterator{
//        private int index;
//
//        @Override
//        public boolean hasNext() {
//            if (index < broadcastList.size() ) {
//                return true;
//                }
//            return false;
//        }
//
//        @Override
//        public Object next() {
//            if (!this.hasNext()){
//                index = -1; // to the top of the list
//            }
//            return broadcastList.get(index++);
//        }
//    }
//}
