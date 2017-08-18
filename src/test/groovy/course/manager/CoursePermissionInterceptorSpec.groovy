package course.manager


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CoursePermissionInterceptor)
class CoursePermissionInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test coursePermission interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"coursePermission")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
