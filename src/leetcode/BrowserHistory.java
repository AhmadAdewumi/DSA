package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
//    private ArrayList<String> history;
//    private int currentIndex;
//    private int size;
//
//    public BrowserHistory(String homepage) {
//        this.history = new ArrayList<>();
//        history.add(homepage);
//        this.currentIndex = 0;
//        this.size = 1;
//    }
//
//    public void visit(String url) {
//        // to remove all entries after currentIndex (forward history)
//        // coz we are going to overwrite currentIndex+1
//        currentIndex++; //-- we clear all the forward values, say currIdx = 0, and we have ["LC", "YT", "TG"],
//                        // visit("FB"), currIdx = 1, replace value of idx 1 with FB.
//        while (history.size() > currentIndex){
//            history.remove(history.size() - 1); //-- here, e.g, we remove index 2, just logical removal, the forwad values are still being held referencce to,
//                                                        //-- say we have 4th val, it will still be there
//        }
//        history.add(url);
//    }
//
//    public String back(int steps) {
//        currentIndex = Math.max(0, currentIndex - steps); //-- to ensure we are within range
//        return history.get(currentIndex);
//    }
//
//    public String forward(int steps) {
//        currentIndex = Math.min(size-1, currentIndex + steps); //-- to ensure we are within range
//        return history.get(currentIndex);
//    }

    ///---------------------- USING ARRAYS ------- MY FIRST THOUGHT-----------------------
//    private String[] history;
//    private int currentIndex;
//    private int size;
//
//    public BrowserHistory(String homepage) {
//        this.history = new String[1000];
//        history[0] = homepage;
//        this.currentIndex = 0;
//        this.size = 1;
//    }
//
//    public void visit(String url) {
//        currentIndex++;
//        history[currentIndex] = url;
//        size = currentIndex + 1;
//    }
//
//    public String back(int steps) {
//        currentIndex = Math.max(0, currentIndex - steps);
//        return history[currentIndex];
//    }
//
//    public String forward(int steps) {
//        currentIndex = Math.min(size-1, currentIndex + steps);
//        return history[currentIndex];
//    }

    /// ------------------- USING TWO STACKS, backStack and forwardStack -----------------
    private Deque<String> backStack;
    private Deque<String> forwardStack;
    private String currentPage;

    public BrowserHistory(String homepage) {
        this.backStack = new ArrayDeque<>();
        this.forwardStack = new ArrayDeque<>();
        this.currentPage = homepage;
    }

    public void visit(String url) {
        //-- push current page onto
        backStack.push(currentPage);

        //-- set our url to current page
        currentPage = url;

        //-- clear the forward stack
        forwardStack.clear();
    }

    public String back(int steps) {
        while (steps != 0 && !backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            steps--;
        }

        return currentPage;
    }

    public String forward(int steps){
        while(steps != 0 && !forwardStack.isEmpty()){
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            steps--;
        }

        return currentPage;
    }
}
