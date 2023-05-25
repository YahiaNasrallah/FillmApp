package com.example.projectdesign;

import android.net.Uri;

public class Actors {

    private String ActorName;
    private Uri ActorPhoto;

    public Actors(){

    }

    public Actors(String actorName, Uri actorPhoto) {
        ActorName = actorName;
        ActorPhoto = actorPhoto;
    }

    public String getActorName() {
        return ActorName;
    }

    public void setActorName(String actorName) {
        ActorName = actorName;
    }

    public Uri getActorPhoto() {
        return ActorPhoto;
    }

    public void setActorPhoto(Uri actorPhoto) {
        ActorPhoto = actorPhoto;
    }
}
