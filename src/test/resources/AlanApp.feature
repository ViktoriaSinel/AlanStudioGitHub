@run
  Feature: GitHub

    Scenario: GitHub pull repositories, add new script and push it back
      Given that I am on the Alan App
      Then I enter my email address
      And I enter my password
      Then I press login button
      #Then if there is a project named test I open it
      Then I create a new voice assistant
      Then I choose an empty project
      And name it test and create a new project
      #Then I add a new script and choose the small talk script
      And I sync with my github account
      Then I authorize my github account
      Then I add a repository from my github account
      And I add a new script and push it back to github
      Then make sure push was successful
      Then I log out from studio

    Scenario: GitHub pull repositories to a new project
      Given that I am on the Alan App
      Then I enter my email address
      Then I enter my password

    Scenario: GitHub push scripts to an empty repository
      Given that I am on the Alan App
      Then I enter my email address
      Then I enter my password
