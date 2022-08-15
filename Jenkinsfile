pipeline {
    agent any

    stages 
     {
        stage('Code') 
           {
            steps {
                echo 'NewCode change'
            }
      }
        stage('Test') 
          {
            steps {
                echo 'NewTest change'
            }
       } 
        stage('Deploy') 
            {
            steps {
                echo 'NewDeploy change'
            }
        }
    }
    post{
          failure
{
         mail bcc: '', body: '''Hi Sarika ,
    our new testcases is executed successfully''', cc: '', from: '', replyTo: '', subject: 'Build executed successfully', to: 'sarikanazare610@gmail.com'
    }
  }
}