
def call(String imageName, String imageTag, String dockerHubUser) {
    if (!imageTag?.trim()) {
        error("Docker image tag is required for ${imageName}")
    }

    def fullImageName = "${dockerHubUser}/${imageName}:${imageTag}"

    echo "Pushing Docker image: ${fullImageName}"

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-credentials',
            usernameVariable: 'DOCKERHUB_USER',
            passwordVariable: 'DOCKERHUB_TOKEN'
        )
    ]) {
        sh """
            set -eu

            echo "\$DOCKERHUB_TOKEN" | docker login \
                --username "\$DOCKERHUB_USER" \
                --password-stdin

            docker push ${fullImageName}

            docker logout
        """
    }

    echo "Docker image pushed successfully: ${fullImageName}"
}
