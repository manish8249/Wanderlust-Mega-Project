
def call(String imageName, String imageTag, String dockerHubUser) {
    if (!imageTag?.trim()) {
        error("Docker image tag is required for ${imageName}")
    }

    echo "Building Docker image: ${dockerHubUser}/${imageName}:${imageTag}"

    sh """
        set -eu

        docker build \
            --pull \
            -t ${dockerHubUser}/${imageName}:${imageTag} \
            .
    """

    echo "Docker image built successfully: ${dockerHubUser}/${imageName}:${imageTag}"
}
