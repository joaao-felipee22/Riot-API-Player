
package com.example.riotapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;


public class PlayerResponse implements Parcelable {

    @Expose
    private String accountId;
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private Long profileIconId;
    @Expose
    private String puuid;
    @Expose
    private Long revisionDate;
    @Expose
    private Long summonerLevel;

    protected PlayerResponse(Parcel in) {
        accountId = in.readString();
        id = in.readString();
        name = in.readString();
        if (in.readByte() == 0) {
            profileIconId = null;
        } else {
            profileIconId = in.readLong();
        }
        puuid = in.readString();
        if (in.readByte() == 0) {
            revisionDate = null;
        } else {
            revisionDate = in.readLong();
        }
        if (in.readByte() == 0) {
            summonerLevel = null;
        } else {
            summonerLevel = in.readLong();
        }
    }

    public static final Creator<PlayerResponse> CREATOR = new Creator<PlayerResponse>() {
        @Override
        public PlayerResponse createFromParcel(Parcel in) {
            return new PlayerResponse(in);
        }

        @Override
        public PlayerResponse[] newArray(int size) {
            return new PlayerResponse[size];
        }
    };

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(Long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public Long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Long revisionDate) {
        this.revisionDate = revisionDate;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(accountId);
        dest.writeString(id);
        dest.writeString(name);
        if (profileIconId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(profileIconId);
        }
        dest.writeString(puuid);
        if (revisionDate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(revisionDate);
        }
        if (summonerLevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(summonerLevel);
        }
    }
}
