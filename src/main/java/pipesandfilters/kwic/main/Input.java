package pipesandfilters.kwic.main;

import pipesandfilters.kwic.pipes.Pipe;

import java.util.Scanner;

/**
 * Created by luisburgos on 20/08/15.
 */
public class Input {

    public String getInput(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Phrase: ");
        return userInput.nextLine();
    }

    public void sendThroughPipe(Data data, Pipe pipe){
        pipe.send(data);
    }

}
