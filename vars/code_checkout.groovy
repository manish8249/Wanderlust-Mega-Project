
def call(String repositoryUrl, String branchName) {
    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branchName}"]],
        userRemoteConfigs: [[
            url: repositoryUrl
        ]]
    ])
}
