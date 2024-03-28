package protune;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.net.URL;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create("AKIAVRUVVIAZVLLPUTXT", "doJp6iVgAhNVjGk0s/ztONGASwTscF8SybVd5D/i");
//        S3Client s3Client = S3Client.builder()
//                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
//                .region(Region.AP_NORTHEAST_1)
//                .build();

        Region region = Region.AP_SOUTHEAST_1;
        S3Client s3 = S3Client.builder()
                .region(region)
                .build();

        final String usage = """

                Usage:
                    <bucketName> <keyName>\s

                Where:
                    bucketName - The Amazon S3 bucket name.
                    keyName - A key name that represents the object.\s
                """;

//        if (args.length != 2) {
//            System.out.println(usage);
//            System.exit(1);
//        }

        String bucketName = "ngthanh-audio";
        String keyName = "Hãy Trao Cho Anh - Sơn Tùng M-TP, Snoop Dogg.mp3";

//        listBuckets(s3);
//        listBucketObjects(s3, "ngthanh-audio");

//
//        ListObjectsV2Request listObjectsV2Request = ListObjectsV2Request.builder()
//                .bucket("ngthanh-audio")
//                .build();
//        ListObjectsV2Response listObjectsV2Response = s3.listObjectsV2(listObjectsV2Request);
//
//        List<S3Object> contents = listObjectsV2Response.contents();
//
//        System.out.println("Number of objects in the bucket: " + contents.stream().count());
//        contents.stream().forEach(System.out::println);

//        System.out.println("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/" + contents.get(0).u() + ".mp3");

        getURL(s3, bucketName, keyName);

        s3.close();

    }


    public static void getURL(S3Client s3, String bucketName, String keyName) {
        try {
            GetUrlRequest request = GetUrlRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .build();

            URL url = s3.utilities().getUrl(request);
            System.out.println("The URL for  " + keyName + " is " + url);

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    public static void listBucketObjects(S3Client s3, String bucketName) {
        try {
            ListObjectsRequest listObjects = ListObjectsRequest
                    .builder()
                    .bucket(bucketName)
                    .build();

            ListObjectsResponse res = s3.listObjects(listObjects);
            List<S3Object> objects = res.contents();
            for (S3Object myValue : objects) {

                System.out.print("\n The name of the key is " + myValue.key());
                System.out.print("\n The object is " + calKb(myValue.size()) + " KBs");
                System.out.print("\n The owner is " + myValue.owner());
            }

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    private static long calKb(Long val) {
        return val / 1024;
    }

    public static void listBuckets(S3Client s3) {
        try {
            ListBucketsResponse response = s3.listBuckets();
            List<Bucket> bucketList = response.buckets();
            bucketList.forEach(bucket -> {
                System.out.println("Bucket Name: " + bucket.name());
            });

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}
