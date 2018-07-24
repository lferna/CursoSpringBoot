pipeline { 
    agent any  
    stages { 
       stage('Preparation') { // for display purposes        
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }       
       }
       stage('Build') {
          // Run the maven build          
             sh "'${mvnHome}/bin/mvn' -DskipTests clean package"
           }
    }
}
