def call() {
    echo "Running unit tests..."

    // If your package.json is inside 'frontend' folder for example:
    sh """
        cd frontend
        npm install
        npm test
    """

    echo "Unit tests completed successfully"
}
