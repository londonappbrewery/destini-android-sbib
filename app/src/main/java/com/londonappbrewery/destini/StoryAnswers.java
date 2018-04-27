package com.londonappbrewery.destini;

public class StoryAnswers {

    int story;
    int answer1; //answer displayed on top button
    int answer2; //answer displayed on bottom button

    public StoryAnswers(int story, int answer1, int answer2) {
        this.story = story;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int getAnswer1() {
        return answer1;
    }

    public void setAnswer1(int answer1) {
        this.answer1 = answer1;
    }

    public int getAnswer2() {
        return answer2;
    }

    public void setAnswer2(int answer2) {
        this.answer2 = answer2;
    }
}
