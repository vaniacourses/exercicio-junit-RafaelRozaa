package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jokenpo.Jokenpo;

public class JokenpoTest {

    private Jokenpo jog1win;
    private Jokenpo jog2win;
    private Jokenpo jogtie;
    private Jokenpo jogerr;
    @beforeEach
    public void inicializa(){
        Jokenpo jog1win = new Jokenpo(1,2);
        Jokenpo jog2win = new Jokenpo(2,1);
        Jokenpo jogtie = new Jokenpo(1,1);
        Jokenpo jogerr = new Jokenpo(5,1);
    }

    @Test
    public void jogarTest(){
        assertEquals(jog1win,1);
        assertEquals(jog2win,2);
        assertEquals(jogtie,0);
        assertEquals(jogerr,-1);
    }
}
