package course.manager

import grails.transaction.Transactional
import org.springframework.beans.factory.InitializingBean

@Transactional
class GoogleCloudStorageService implements InitializingBean {

    def test() {
        log.info "test"
    }

    void afterPropertiesSet() throws Exception {

        log.info "memazo"
    }
}
