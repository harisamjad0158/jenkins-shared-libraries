def call() {
    echo "Running unit tests (actually linting and build check)..."

    // Run npm install and lint, build as a form of validation
    sh """
       npm install
       npm run lint
       npm run build
    """

    echo "Unit tests (lint/build) completed successfully"
}
