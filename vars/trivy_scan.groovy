
def call() {
    sh '''
        set -eu

        echo "Starting Trivy filesystem security scan..."

        trivy fs \
            --scanners vuln,misconfig,secret \
            --severity HIGH,CRITICAL \
            --format table \
            --exit-code 1 \
            .

        echo "Trivy filesystem scan completed successfully."
    '''
}
