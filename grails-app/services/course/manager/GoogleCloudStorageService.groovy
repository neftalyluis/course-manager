package course.manager

import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.cloud.storage.Blob
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Bucket
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import grails.transaction.Transactional
import org.springframework.beans.factory.InitializingBean

import java.util.concurrent.TimeUnit

@Transactional
class GoogleCloudStorageService implements InitializingBean {

    def grailsApplication
    Storage storage
    String bucket
    Boolean ready = false

    void afterPropertiesSet() throws Exception {
        try {
            storage = StorageOptions.newBuilder()
                    .setProjectId(grailsApplication.config.getRequiredProperty('google.cloud.storage.projectId'))
                    .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(grailsApplication.config.getRequiredProperty('google.cloud.storage.credentialsFile'))))
                    .build()
                    .getService()
            bucket = grailsApplication.config.getRequiredProperty('google.cloud.storage.bucket')
            ready = true
        } catch (all) {
            log.warn("Error when making GCS Setup: $all")
        }
    }

    def listBucketsAndObjects() {
        log.info("My buckets:")
        for (Bucket bucket : storage.list().iterateAll()) {
            log.info(bucket.toString())

            // List all blobs in the bucket
            log.info("Blobs in the bucket:")
            for (Blob blob : bucket.list().iterateAll()) {
                log.info(blob.toString())
                log.info(blob.signUrl(14, TimeUnit.DAYS).toString())
            }
        }
    }

    def getUrlForObject(String blobName, Long daysDuration = 3650) {
        BlobId blobId = BlobId.of(bucket, blobName);
        Blob blob = storage.get(blobId);
        if (blob) {
            return blob.signUrl(daysDuration, TimeUnit.DAYS).toString()
        } else {
            log.warn("Can't get URL for Blob: $blobName")
            return blobName
        }
    }

    def putObject(String object) {
        BlobId blobId = BlobId.of(bucket, object)
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build()
        Blob blob = storage.create(blobInfo, obj)
    }

    def removeObject(String object) {

    }

    def replaceObject(String object, byte[] obj, String contentType) {

    }

}
