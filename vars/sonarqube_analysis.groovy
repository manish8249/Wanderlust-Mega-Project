
def call(String installationName, String projectKey, String projectName) {
    echo 'Starting SonarQube code analysis...'

    withSonarQubeEnv(installationName) {
        sh """
            sonar-scanner \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.projectName=${projectName} \
                -Dsonar.sources=backend,frontend \
                -Dsonar.exclusions=**/node_modules/**,**/dist/**,**/build/** \
                -Dsonar.sourceEncoding=UTF-8
        """
    }

    echo 'SonarQube code analysis completed.'
}
