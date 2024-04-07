package protune.controller.inapp;


import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AWSS3Handle {

//    public static void moveCredential(){
//        Path cre = Paths.get("src/main/resources/aws/credentials");
//
//        System.out.println(System.getProperty("user.home") + "\\.aws");
//
//        Path des = Paths.get(System.getProperty("user.home") + "\\.aws");
//
//        try {
//            Files.copy(cre, des, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    private static final Region region = Region.AP_SOUTHEAST_1;
    private static final S3Client s3 = S3Client.builder()
            .region(region)
            .build();

    private static final String bucketName = "ngthanh-audio";

    public static List<String> getAudioUrlList(){
        List<S3Object> audioList = getAudioList();

        List<String> urlList = new ArrayList<>();
        for(S3Object object : audioList){
            urlList.add(getAudioUrl(object.key()));
        }
        return urlList;
    }

    public static List<S3Object> getAudioList(){
        try {
            ListObjectsRequest listObjects = ListObjectsRequest
                    .builder()
                    .bucket(bucketName)
                    .build();

            ListObjectsResponse res = s3.listObjects(listObjects);
            return res.contents();

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return null;
    }

    public static String getAudioUrl(String fileName){
        try {
            GetUrlRequest request = GetUrlRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .build();

            URL url = s3.utilities().getUrl(request);
            return url.toString();

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return null;
    }
}