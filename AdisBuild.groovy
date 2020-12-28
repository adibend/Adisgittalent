#!groovy
import groovy.transform.Field


@Field String Color_Off = "\033[0m"
@Field String Red = "\033[0;31m"
@Field String Green = "\033[0;32m"
@Field String Blue = "\033[0;34m"

properties([
        parameters([]),
        pipelineTriggers([])
])

node('LinuxSlave') {
    ansiColor('xterm') {
        stage('prepare') {
                    echo ('[start] prepare')
					
                    echo "[INFO]${Blue} Cleaning workspace ${Color_Off}"
					cleanWs()
					
                    echo ('[end] prepare')
        }

        stage('merge') {
                    echo ('[start] build')
					
                    echo "[INFO]${Blue} Building webapp ${Color_Off}"
					sh '''
                        git clone --branch master https://adibend:Bendavid69!@github.com/adibend/Adisgittalent.git    
                        '''
					
                    echo ('[end] bumerge')
        }


        stage('build') {
                    echo ('[start] build')
					
                    echo "[INFO]${Blue} Building webapp ${Color_Off}"
					sh '''
                            cd gittalent-frontend
                            npm install
                            ng build
                            docker build -t frontend .
                        '''
					
                    echo ('[end] build')
        }
                

    }  
}

echo "[Info]${Blue} Eneded pipeline succesfully ${Color_Off}"

return this
