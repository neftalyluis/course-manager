package course.manager

import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.cloud.storage.Blob
import com.google.cloud.storage.Bucket
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import grails.transaction.Transactional
import org.springframework.beans.factory.InitializingBean

@Transactional
class GoogleCloudStorageService implements InitializingBean {

    def grailsApplication
    Storage storage
    Boolean ready = false

    def listBucketsAndObjects() {
        System.out.println("My buckets:")
        for (Bucket bucket : storage.list().iterateAll()) {
            System.out.println(bucket)

            // List all blobs in the bucket
            System.out.println("Blobs in the bucket:")
            for (Blob blob : bucket.list().iterateAll()) {
                System.out.println(blob)
            }
        }
    }

    void afterPropertiesSet() throws Exception {
        try {
            storage = StorageOptions.newBuilder()
                .setProjectId(grailsApplication.config.getRequiredProperty('google.cloud.storage.projectId'))
                .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(grailsApplication.config.getRequiredProperty('google.cloud.storage.credentialsFile'))))
                .build()
                .getService()
                ready = true
        } catch (all) {
            log.warn("Error when making GCS Setup: $all")
        }
    }
}
