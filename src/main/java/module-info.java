module protune {
    requires javafx.controls;
    requires javafx.media;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires jaudiotagger;
    requires software.amazon.awssdk.auth;
    requires software.amazon.awssdk.services.s3;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.awscore;

//    requires aws.java.sdk.core;
    requires aws.java.sdk.s3;

    opens protune.model;
    opens protune;
}