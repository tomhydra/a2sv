package com.tomhydra.a2sv.utils.solution_file_automation;

import com.tomhydra.a2sv.utils.DefaultValues;

class Problem {
    private String name;

    // slugified version of the name by joining words with _ and making all letters in lowercase
    private String slug;
    private Integer number;
    private String link;

    // difficulty level like easy, medium and hard
    private DifficultyType difficulty;

    // problem type for organizing by folders
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public DifficultyType getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyType difficulty) {
        this.difficulty = difficulty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentDirectory() {
        return String.format("%s%s/_%d_%s/",
                DefaultValues.BASE_LEETCODE_SOLUTIONS_DIRECTORY, type, number, slug);
    }

}
