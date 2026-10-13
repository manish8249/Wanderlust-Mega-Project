
def call() {
    echo 'Starting OWASP Dependency-Check scan...'

    dependencyCheck(
        additionalArguments: '--scan . --format XML --out dependency-check-report'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml',
        failedTotalCritical: 1
    )

    echo 'OWASP Dependency-Check scan completed.'
}
