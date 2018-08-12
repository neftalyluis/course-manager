def env = System.getenv()
inlineInventory {
    node {
        id = 'server'
        host = env["DEPLOY_HOST"]
        username = env["DEPLOY_USERNAME"]
        password = env["DEPLOY_PASSWORD"]
    }
}.provision {
    task name: 'Copy file', actions: {
        info "LOL"
    }
}