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

        stage('prepare') {
                    echo ('[start] prepare')
					
                    echo "[INFO]${Blue} Cleaning workspace ${Color_Off}"
					cleanWs()
					
                    echo ('[end] prepare')
                }

                

            }  


echo "[Info]${Blue} Eneded pipeline succesfully ${Color_Off}"

return this
