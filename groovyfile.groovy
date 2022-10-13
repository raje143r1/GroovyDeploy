pipeline{
        agent any
        stages{
              stage("build"){
               steps{
                echo 'helloworld'
                       readProp = readProperties file: 'buildproperties.properties'
                       echo "test ${testdata}"
                }
               }
                   
      }
}
