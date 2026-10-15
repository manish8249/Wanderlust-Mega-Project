
def call() {
    sh '''
        set -eu

        echo "Starting Trivy filesystem security scan..."

        trivy fs \
            --scanners vuln,misconfig,secret \
            --severity HIGH,CRITICAL \
            --format table \
            --exit-code 0 \
            .

        echo "Trivy filesystem scan completed successfully."
    '''
}
