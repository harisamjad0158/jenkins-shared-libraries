def call() {
    echo "Running unit tests..."

    try {
        // Replace this with your actual test command
        // For Node.js projects:
        sh 'npm test'

        // For Maven projects, use instead:
        // sh 'mvn test'

        echo "Unit tests completed successfully"
    } catch (err) {
        echo "Unit tests failed!"
        error("Failing the build because tests failed")
    }
}
