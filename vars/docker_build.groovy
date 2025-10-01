def call(Map config = [:]) {
    // Required parameters
    def imageName = config.imageName ?: error("Image name is required")
    def imageTag = config.imageTag ?: 'latest'
    def dockerfile = config.dockerfile ?: 'Dockerfile'
    def context = config.context ?: '.'

    echo "Building Docker image: ${imageName}:${imageTag} using ${dockerfile}"

    // Build Docker image
    sh """
        docker build -t ${imageName}:${imageTag} -t ${imageName}:latest -f ${dockerfile} ${context}
    """
}

// Optional helper function for Docker login (recommended for pipeline usage)
def dockerLogin(credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        // Use single quotes to prevent exposing secrets to Groovy interpolation
        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
    }
}
