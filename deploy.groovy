def env = System.getenv()
def version = new Date().format("yyyyMMddHHmm", TimeZone.getTimeZone('UTC'))
inlineInventory {
    node {
        id = 'server'
        host = env["DEPLOY_HOST"]
        username = env["DEPLOY_USERNAME"]
        password = env["DEPLOY_PASSWORD"]
    }
}.provision {
    task name: 'Deployment', actions: {
        info "Uploading WAR file"
        upload {
            target = "/root/course-manager-${version}.war"
            source = "build/libs/course-manager-0.1.war"
        }
        info "Stopping service"
        shell "systemctl stop course-manager"
        info "Copying WAR file"
        shell "cp course-manager-${version}.war /var/course-manager/course-manager-0.1.war"
        info "Starting service"
        shell "systemctl start course-manager"
        info "Healthcheck of service"
        retry count: 50, delay: 5000, actions: {
            def response = httpGet url: "http://$node.host/"
            assert response.code == 200
        }
    }
}