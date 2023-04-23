pipeline{

	agent any

		stages{

			stage('Checkout'){

					steps{

						git branch: "main", url: 'https://github.com/kottamamrutha/student-demo.git'

						}

					}

			stage('Build'){

					steps{

						sh 'chmod a+x mvnw'

						sh './mvnw clean package -DskipTests=true'

						}

					post{

						always{

							archiveArtifacts 'target/*.jar'

							}

						}

				}

			stage(DockerBuild) {

						steps {

							sh 'docker build -t amrutha456/student-demo:latest .'

							}

						}

			stage('Login') {

					steps {

						sh 'echo Amrutha+123 | docker login -u amrutha456 --password-stdin'

						}

					}

			stage('Push') {

					steps {

						sh 'docker push amrutha456/student-demo'

						}
	
					}
				}

		post {

			always {

				sh 'docker logout'

				}

			}

}