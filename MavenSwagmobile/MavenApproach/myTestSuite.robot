*** Settings ***
Library    AppiumLibrary
   
***Test Cases***
Test1
        [Documentation]    login with invalid credentials.
        Log    Testcase 1 is started
        Open Application    deviceName=Pixel    platformName=Android    platformVersion=R    udid=FA6A40301235    com.swaglabsmobileapp.SplashActivity    com.swaglabsmobileapp    http://localhost:4723/wd/hub 
        Input Text    accessibility_id=test-Username    invalidusername
        Input Text    accessibility_id=test-Password    secret_sauce
        Click Element    accessibility_id=test-LOGIN
        Close Application