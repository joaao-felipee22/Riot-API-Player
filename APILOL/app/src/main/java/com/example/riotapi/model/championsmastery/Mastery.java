
package com.example.riotapi.model.championsmastery;

import com.google.gson.annotations.Expose;


public class Mastery {

    @Expose
    private Long championId;
    @Expose
    private Long championLevel;
    @Expose
    private Long championPoints;
    @Expose
    private Long championPointsSinceLastLevel;
    @Expose
    private Long championPointsUntilNextLevel;
    @Expose
    private Boolean chestGranted;
    @Expose
    private Long lastPlayTime;
    @Expose
    private String summonerId;
    @Expose
    private Long tokensEarned;

    public Long getChampionId() {
        return championId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    public Long getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(Long championLevel) {
        this.championLevel = championLevel;
    }

    public Long getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(Long championPoints) {
        this.championPoints = championPoints;
    }

    public Long getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public void setChampionPointsSinceLastLevel(Long championPointsSinceLastLevel) {
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    }

    public Long getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public void setChampionPointsUntilNextLevel(Long championPointsUntilNextLevel) {
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    }

    public Boolean getChestGranted() {
        return chestGranted;
    }

    public void setChestGranted(Boolean chestGranted) {
        this.chestGranted = chestGranted;
    }

    public Long getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(Long lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public Long getTokensEarned() {
        return tokensEarned;
    }

    public void setTokensEarned(Long tokensEarned) {
        this.tokensEarned = tokensEarned;
    }

}
