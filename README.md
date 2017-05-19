# Connect4SeniorProject
A connect 4 game with unlockable characters, a character selection screen, and voice recordings

# Problems encountered during project
Issues with listeners were encountered when first implemented. They placed inside of the board class and final dependents of listeners caused issues.
We made custom JButtons with getters and listeners, which the listeners could utilize. This fixed the need for final variables as the listeners used the getters instead.

Severe performance issues were encountered when the MediaPlayer class was added. Media player was removed from each instance of the buttons and added to a seperate object,
MediaPlayer instance count went from 126 to 3. 

Images added to new layouts would only appear when hovered over. It was then discovered that becuase of the null layout, the JPanel boundries were stretched to fit the ImageIcons.
This was fixed by calling the repaint() function after each token insertion.

An error occured when JFX methods and objects were used before the JFX enviroment was initialized. The IllegalStateException was fixed by adding a CountDownLatch and a new thread on the EDT, which 
ran a function that initialized the JFX enviroment by a call to JFXPanel(). The program only proceeded after the CountDownLatch was finished

Token offsets were slightly different on different operating systems. Mac OS and Windows support was added by a call to System.getProperty(). This information was used to prepare the
correct offsets for the tokens.

MediaUnavaliable exceptions were fixed by including a try catch block in MediaPlayer instanciation

A 2.5 second pause was needed after the second player had selected their character. However, calling Thread.sleep() in the listener caused for the sleep command to be issued
in the EDT, freezing the gui while still proceeding in the main thread. Adding Thread.sleep() to the main thread resulted in both the EDT and main thread to sleep for 2.5 seconds.
This issue was resolved by using a swingtimer and executing the remaining code only after the actionlistener for the timer reached the 2500 miliseconds.