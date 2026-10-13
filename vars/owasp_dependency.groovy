def call() {
    echo 'Starting OWASP Dependency-Check scan...'

    dependencyCheck(
        additionalArguments: '--scan . --format XML --out dependency-check-report --disableYarnAudit --disableNodeAudit',
        odcInstallation: 'dp-check'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )

    echo 'OWASP Dependency-Check scan completed.'
}
