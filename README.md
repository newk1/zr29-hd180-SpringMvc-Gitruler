# Using git with Software Development

The goal of this exercise will be to apply our Git skills and knowledge to a real piece of software to get an idea of how git is normally used in the tech industry.

In this exercise, we will be working with a basic Spring MVC web application similar to the ones you are currently learning how to develop in CO2006.

N.B: You will need to [import](http://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.platform.doc.user%2Ftasks%2Ftasks-importproject.htm) the project in your eclipse workspace to start working on the exercise. 

## Environment Setup:

In order to start completing the exercise we must first setup the repository:

1. Create a working directory on your machine 
1. Clone the repository inside your working directory
1. Run GitRuler to initialize the exercise

## First tasks:

The project manager has just informed us that we need to change the server port:

1. Open the application.properties file located under `src/main/resources`
1. Change `server.port=8090` to `server.port=8080`
1. Stage and commit this change with the message "change server port to 8080"
1. Tag this commit with tag `server-port`

## Removing useless files:

There are some backup files that we don't need anymore, let's remove them:

1. Remove all files from `SpringMvc_webApp/backups` folder
1. Commit the removal with message "remove backup files"

## Moving files:

We've just received all the views that we will using in the app, the jsp files have been sent to us and we need to put them in the right path for the application to import them from:

1. Move the views from the `newviews` folder to `SpringMvc_webApp/src/main/webapp/WEB-INF/views/form`
1. Commit the move with message "move view files"

## Ignore files:

If there are many files in our directories that we never want to track using git then we can tell git to ignore them. This often happens while programming because we don't want to commit compiled files:

1. [Create](https://help.github.com/articles/ignoring-files/) a `.gitignore` file
1. Commit the '.gitignore' file with the message "generate gitignore"
1. Ignore all backup files under `SpringMvc_webApp/compiled_builds`
1. Commit with message "ignore all backups"

## Branching:

We need to add a new request mapping function to show the view `final.jsp` on a `/finalPage` get request, on a new branch that we will create:

1. Create a new branch called `request-map`
1. Checkout to this new branch
1. Add this feature in `SpringMvc_webApp/src/main/java/labMvc/control/IndexController.java`:
  ```
  @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
      public String finalPage() {      
        return "/form/final";
      }
  ```
4. Commit this change with the message "add request mapping"


## Merging:

We would like to merge the changes we've applied in the `request-map` branch to the `master` branch:

1. Checkout to the `master` branch
1. Merge `request-map` into `master`
1. Create a new file called "file.txt" in the folder `SpringMvc_webApp`
1. Commit the file with message "add file"
 
 (Gitruler will only let you pass question 3 if you finish questions 4 and 5, don't be alarmed if you find that the merge rule doesn't pass after committing)

## Merge-conflict:

The project manager has informed us that there is a major bug in the system and we need to fix it immediately. To simulate multiple poeple working on this project, imagine that you are working on the new branch that we will create and another developer is working on the master branch.

1. Create and checkout a new branch called `bug-fix`
1. Change line 5 in `SpringMvc_webApp/src/main/java/labMvc/domain/Student.java` from `private Integer age = 11;` to `private Integer age = 22;`
1. Stage and commit the changes with the message "change age default value"
1. Checkout to the `master` branch
1. Change line 5 in `SpringMvc_webApp/src/main/java/labMvc/domain/Student.java` from `private Integer age = 11;` to `private Integer age = 16;`
1. Stage and commit the changes with the message "change value of age variable"
1. Merge `bug-fix` into `master`
1. Resolve the merge conflict by keeping `private Integer age = 22;`
1. Commit this with the message "keep 22 as age value"
