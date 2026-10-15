
def call(String installationName, String projectKey, String projectName) {
    echo 'Starting SonarQube code analysis...'

    def scannerHome = tool 'Sonar'   // must match the name in Tools exactly

    withSonarQubeEnv(installationName) {
        sh """
            ${scannerHome}/bin/sonar-scanner \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.projectName=${projectName} \
                -Dsonar.sources=backend,frontend \
                -Dsonar.exclusions=**/node_modules/**,**/dist/**,**/build/** \
                -Dsonar.sourceEncoding=UTF-8
        """
    }

    echo 'SonarQube code analysis submitted.'
}
