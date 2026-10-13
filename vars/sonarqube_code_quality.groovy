
def call() {
    echo 'Waiting for SonarQube Quality Gate result...'

    timeout(time: 10, unit: 'MINUTES') {
        def qualityGate = waitForQualityGate(
            abortPipeline: true
        )

        if (qualityGate.status != 'OK') {
            error("SonarQube Quality Gate failed: ${qualityGate.status}")
        }

        echo 'SonarQube Quality Gate passed successfully.'
    }
}
