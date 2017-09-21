package course.manager


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CourseInterceptor)
class CourseInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test course interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"course")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
